package com.zola.gym



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CheckInController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond CheckIn.list(params), model:[checkInInstanceCount: CheckIn.count()]
    }

    def show(CheckIn checkInInstance) {
        respond checkInInstance
    }

    def create() {
        respond new CheckIn(params)
    }

    @Transactional
    def save(CheckIn checkInInstance) {
        if (checkInInstance == null) {
            notFound()
            return
        }

        if (checkInInstance.hasErrors()) {
            respond checkInInstance.errors, view:'create'
            return
        }

        checkInInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'checkIn.label', default: 'CheckIn'), checkInInstance.id])
                redirect checkInInstance
            }
            '*' { respond checkInInstance, [status: CREATED] }
        }
    }

    def edit(CheckIn checkInInstance) {
        respond checkInInstance
    }

    @Transactional
    def update(CheckIn checkInInstance) {
        if (checkInInstance == null) {
            notFound()
            return
        }

        if (checkInInstance.hasErrors()) {
            respond checkInInstance.errors, view:'edit'
            return
        }

        checkInInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'CheckIn.label', default: 'CheckIn'), checkInInstance.id])
                redirect checkInInstance
            }
            '*'{ respond checkInInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(CheckIn checkInInstance) {

        if (checkInInstance == null) {
            notFound()
            return
        }

        checkInInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'CheckIn.label', default: 'CheckIn'), checkInInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'checkIn.label', default: 'CheckIn'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

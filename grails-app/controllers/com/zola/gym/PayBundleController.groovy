package com.zola.gym



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class PayBundleController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond PayBundle.list(params), model:[payBundleInstanceCount: PayBundle.count()]
    }

    def show(PayBundle payBundleInstance) {
        respond payBundleInstance
    }

    def create() {
        respond new PayBundle(params)
    }

    @Transactional
    def save(PayBundle payBundleInstance) {
        if (payBundleInstance == null) {
            notFound()
            return
        }

        if (payBundleInstance.hasErrors()) {
            respond payBundleInstance.errors, view:'create'
            return
        }

        payBundleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'payBundle.label', default: 'PayBundle'), payBundleInstance.id])
                redirect payBundleInstance
            }
            '*' { respond payBundleInstance, [status: CREATED] }
        }
    }

    def edit(PayBundle payBundleInstance) {
        respond payBundleInstance
    }

    @Transactional
    def update(PayBundle payBundleInstance) {
        if (payBundleInstance == null) {
            notFound()
            return
        }

        if (payBundleInstance.hasErrors()) {
            respond payBundleInstance.errors, view:'edit'
            return
        }

        payBundleInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'PayBundle.label', default: 'PayBundle'), payBundleInstance.id])
                redirect payBundleInstance
            }
            '*'{ respond payBundleInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(PayBundle payBundleInstance) {

        if (payBundleInstance == null) {
            notFound()
            return
        }

        payBundleInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'PayBundle.label', default: 'PayBundle'), payBundleInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'payBundle.label', default: 'PayBundle'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}

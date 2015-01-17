package com.zola.gym



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import org.jadira.usertype.dateandtime.joda.*

@Transactional(readOnly = true)
class CheckInController {
    
    def passwordEncoder

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
    
    def checkin(){
        render view:'checkin'
    }
    
    def authorizecheckin(){
        def loguser = User.findByEmail(params.email)
        if(loguser == null){
            flash.error = "Wrong email/password combination, please try again"
            println "${loguser.firstname}"
            redirect action:'checkin'
        }
        else{
            if(!passwordEncoder.isPasswordValid(loguser.password,params.password,null)){
                flash.error = "Wrong email/password combination, please try again"
                println "Log user point"
                redirect action:'checkin'
            }
            else{
                if(loguser.subscription != null){
                    def subscriptionenddate = loguser.subscription.enddate
                    def currentdate = new LocalDate()
                    def subday = subscriptionenddate.getDayOfYear()
                    def curday = currentdate.getDayOfYear()

                    if(curday<=subday){
                        def newcheckin = new CheckIn()
                        newcheckin.customer = loguser
                        newcheckin.checkintime = new Date()
                        newcheckin.save()
                        flash.info = "Succesful Check in ${loguser.firstname}, Enjoy Your Workout"
                        redirect action:'checkin'
                    }
                    else{
                        flash.error = "Check-In unsuccesful, You do not have an active subscription. Login and purchase one"
                        redirect action:'checkin'
                    }
                }
                else{
                    flash.error = "Check-In unsuccesful, You do not have an active subscription. Login and purchase one"
                    redirect action:'checkin'
                }
            }
        }
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

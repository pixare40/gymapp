package com.zola.gym

import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import org.jadira.usertype.dateandtime.joda.*
import org.springframework.security.access.annotation.Secured

class CustomerController {

    def springSecurityService
    def persistenceService
    
    def index() {
        def curuser = lookupUser()
        def checkins = CheckIn.findAll{
            customer == curuser
        }
        
        def checkinsize = checkins.size()
        
        def activesubscription = curuser.subscription
        
        render view:'index', model:[checkInInstanceList:checkins,checkinsize:checkinsize, activesubscription:activesubscription]
    }
    
    def checkin(){
        def curuser = lookupUser()
        if(curuser.subscription == null){
            flash.error = "Check-In unsuccesful, You do not have an active subscription. Please purchase one!"
            redirect action:'index'
        }
        else{
        def subscriptionenddate = persistenceService.checksubscription(curuser)
        def currentdate = new LocalDate()
        def subday = subscriptionenddate.getDayOfYear()
        def curday = currentdate.getDayOfYear()
        
        if(curday<=subday){
            def newcheckin = new CheckIn()
            newcheckin.customer = curuser
            newcheckin.checkintime = new Date()
            newcheckin.save()
            flash.message = "Succesful Check in, Enjoy Your Workout"
            redirect action:'index'
        }
        else{
            flash.error = "Check-In unsuccesful, You do not have an active subscription. Please purchase one!"
            println "From wrong place"
        }
        }
    }

     private lookupUser(){
        User.get(springSecurityService.principal.id)
    }
    
    def payzone(){
        def curuser = lookupUser()
        def paybundles = PayBundle.findAll()
        render view:'payzone', model:[payBundleInstanceList:paybundles, curuser:curuser]
    }
    
    
    def mycheckins(){
        def curuser = lookupUser()
        def checkins = persistenceService.getCheckIns(curuser)
        render view:'mycheckins', model:[checkInInstance:checkins]
    }
    
    def myaccount(){
        def userInstance = lookupUser()
        redirect userInstance
    }
    
    def cancelsubscription(){
        def curuser = lookupUser()
        if(curuser.subscription != null){
            curuser.subscription = null
            curuser.save(flush:true)
            flash.message = "Subscription Cancelled Succesfully"
            redirect action:'index', controller:'customer'
        }
    }
}

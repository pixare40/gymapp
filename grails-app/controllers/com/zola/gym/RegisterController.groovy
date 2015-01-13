package com.zola.gym

import grails.plugin.springsecurity.SpringSecurityUtils
import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import org.jadira.usertype.dateandtime.joda.*

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {
    def index(){
    }
    
    def registernewuser(User user){
        def newuser = new User()
        
        newuser.username = params.username
        newuser.password = params.password
        newuser.email = params.email
        newuser.firstname = params.firstname
        newuser.lastname = params.lastname
        newuser.birthdate = new LocalDate(params.birthdate)
        newuser.phoneNumber = params.phonenumber
        
        def customerRole = Role.findByAuthority('ROLE_CUSTOMER')?:new Role(authority:'ROLE_CUSTOMER').save(failOnError:true)
        
        if(newuser.save()){
            if(!newuser.authorities.contains(customerRole)){
            UserRole.create newuser, customerRole
        }
            render "User Saved"
        }
        else{
            render "Error"
        }
    }
}

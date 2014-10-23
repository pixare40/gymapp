package com.zola.gym

import grails.plugin.springsecurity.SpringSecurityUtils

class HomeController {

    def index() {
        
        if(SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')){
            redirect controller: 'Admin', action:'index'
        }
        
        else if(SpringSecurityUtils.ifAllGranted('ROLE_STAFF')){
            redirect controller:'Doctor', action:'home'
        }
        
        else if(SpringSecurityUtils.ifAllGranted('ROLE_CUSTOMER')){
            redirect controller:'Patient', action:'home'
        }
        
        else{
            view:'index'
        }
    
    }
}
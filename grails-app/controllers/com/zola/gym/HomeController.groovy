package com.zola.gym

import grails.plugin.springsecurity.SpringSecurityUtils

class HomeController {

    def index() {
        
        if(SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')){
            redirect controller: 'Admin', action:'index' , 'home'
        }
        
        else if(SpringSecurityUtils.ifAllGranted('ROLE_CUSTOMER')){
            redirect controller:'Client', action:'index' , 'home'
        }
        
        else{
            view:'index'
        }
    
    }
}

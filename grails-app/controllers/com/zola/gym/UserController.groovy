package com.zola.gym

import grails.plugin.springsecurity.annotation.Secured

class UserController {
    
    
   @Secured("ROLE_COSTUMER")
    def index() {
        
     
    render 'User Section!'
    
    }
}

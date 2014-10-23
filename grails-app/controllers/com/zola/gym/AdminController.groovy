package com.zola.gym

import grails.plugin.springsecurity.annotation.Secured
class AdminController {

    def springSecurityService
    
    @Secured("ROLE_ADMIN")
    def index() {
        def currentuser = lookupuser()
        render "${currentuser.firstname} ${currentuser.lastname}"
    }
    
    private lookupuser(){
        User.get(springSecurityService.principal.id)
    }
}

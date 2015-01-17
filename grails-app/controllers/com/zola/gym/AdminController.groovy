package com.zola.gym

import grails.plugin.springsecurity.annotation.Secured
class AdminController {

    def springSecurityService
    
    def index() {
        def currentuser = lookupuser()
        render view:'index', model:[userInstance:currentuser]
    }
    
    private lookupuser(){
        User.get(springSecurityService.principal.id)
    }
    
}

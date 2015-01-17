package com.zola.gym

import grails.plugin.springsecurity.SpringSecurityUtils

class HomeController {

    def index() {
        
        if(SpringSecurityUtils.ifAllGranted('ROLE_ADMIN')){
            redirect controller: 'Admin', action:'index'
        }
        
        else if(SpringSecurityUtils.ifAllGranted('ROLE_CUSTOMER')){
            redirect controller:'Customer', action:'index'
        }
        
        else{
            render view:'index'
        }
    
    }
    
    def home(){
        render view:'index'
    }
    def appdetails(){
        render view:'/index'
    }
    
    def aboutus(){
        
    }
    
    def terms(){
        
    }
    
    def contactus(){
        
    }
}

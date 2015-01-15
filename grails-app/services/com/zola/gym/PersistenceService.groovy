package com.zola.gym

import grails.transaction.Transactional
import com.zola.gym.*

@Transactional
class PersistenceService {

    def checksubscription(User user) {
        def subs = user.subscription
        def enddate = subs.enddate
        return enddate
    }
    
    def getSubscription(User user){
        def subs = user.subscription
        return subs
    }
    
    def getCheckIns(User user){
        def checks = CheckIn.findAll{
            customer == user
        }
        return checks
    }
}

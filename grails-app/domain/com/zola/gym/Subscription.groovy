package com.zola.gym

import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import org.jadira.usertype.dateandtime.joda.*
import org.grails.paypal.Payment

class Subscription {
    String name
    LocalDate startdate
    LocalDate enddate
    Payment payment
    boolean active=false

    
    static constraints = {
        name nullable:false, blank:false
        startdate nullable:false, blank:false
        enddate nullable:false, blank:false
        payment nullable:false, blank:false
    }
}

package com.zola.gym

class CheckIn {
    User customer
    Date checkintime

    static constraints = {
        customer nullable:false, blank:false
        checkintime nullable:false, blank:false
    }
}

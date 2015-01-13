package com.zola.gym

import java.time.LocalDate

class Subscription {
    LocalDate startdate
    LocalDate enddate

    static constraints = {
        startdate nullable:false, blank:false
        enddate nullable:false, blank:false
    }
}

package com.zola.gym

class PayBundle {
    String bundlename
    Double price
    int duration

    static constraints = {
        bundlename nullable:false, blank:false
        price nullable:false, blank:false
        duration nullable:false, blank:false
    }
}

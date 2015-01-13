package com.zola.gym

class PayBundle {
    String bundlename
    int duration

    static constraints = {
        bundlename nullable:false, blank:false
        duration nullable:false, blank:false
    }
}

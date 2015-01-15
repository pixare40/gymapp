package gymapp

import com.zola.gym.*

class PurchaseCompletedFilters {

    def filters = {
        all(controller:'paypal', action:'(success|notifyPaypal)') {
            before = {

            }
            after = { Map model ->
                def payment = request.payment
                if(payment && payment.status == org.grails.paypal.Payment.COMPLETE) {
                    def subscription = Subscription.findByPayment(payment)
                    if ( !subscription.active ) {
                        subscription.active = true
                    }
                }
            }
            afterView = { Exception e ->

            }
        }
    }
}

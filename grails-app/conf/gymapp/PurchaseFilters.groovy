package gymapp

import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import com.zola.gym.*
import org.jadira.usertype.dateandtime.joda.*
import grails.transaction.Transactional

@Transactional
class PurchaseFilters {

    def filters = {
        all(controller:'paypal', action:'buy') {
            before = {

            }
            after = { Map model ->
                def user = User.get(request.payment.buyerId)
                def item = PayBundle.get(request.payment.paymentItems[0].itemNumber)
                def subs = new Subscription(
                    name:item.bundlename,
                    startdate:new LocalDate(),
                    enddate:new LocalDate().plusDays(item.duration),
                    payment:request.payment
                ).save(failOnError:true)
                user.subscription = subs
                user.save(failOnError:true)
            }
            afterView = { Exception e ->

            }
        }
    }
}

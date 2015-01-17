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
                if(user.subscription !=null){
                    user.subscription.name = item.bundlename
                    user.subscription.enddate = user.subscription.enddate.plusDays(item.duration)
                    user.subscription.save(failOnError:true)
                    user.save(flush:true)
                }
                else if(user.subscription == null){
                def subs = new Subscription(
                    name:item.bundlename,
                    startdate:new LocalDate(),
                    enddate:new LocalDate().plusDays(item.duration),
                    payment:request.payment
                ).save(failOnError:true)
                user.subscription = subs
                user.save(failOnError:true)
                }
            }
            afterView = { Exception e ->

            }
        }
    }
}

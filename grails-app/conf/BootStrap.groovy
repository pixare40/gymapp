
import com.zola.gym.*

import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import org.jadira.usertype.dateandtime.joda.*


class BootStrap {

    def init = { servletContext ->
        
        def adminRole = Role.findByAuthority('ROLE_ADMIN')?:new Role(authority:'ROLE_ADMIN').save(failOnError:true)
        def customerRole = Role.findByAuthority('ROLE_CUSTOMER')?:new Role(authority:'ROLE_CUSTOMER').save(failOnError:true)
        
        def secuser1 = new User(
            username:'amjad',
            email:'amjad@yahoo.com',
            firstname:'Amjad',
            lastname:'Takrouri',
            password:'amjad',
            birthdate:new LocalDate(),
            phoneNumber:7413346938
        ).save(failOnError:true)
        
        if(!secuser1.authorities.contains(adminRole)){
            UserRole.create secuser1, adminRole
        }
        
         def secuser2 = new User(
            username:'pixare40',
            email:'kabajiegara@gmail.com',
            firstname:'Kabaji',
            lastname:'Egara',
            password:'miriam12',
            birthdate:new LocalDate(),
            phoneNumber:7413346938
        ).save(failOnError:true)
        
        if(!secuser2.authorities.contains(customerRole)){
            UserRole.create secuser2, customerRole
        }
        
        def bundle1 = new PayBundle(
            bundlename:'Day Pass',
            price:'10',
            duration:'1'
        ).save(failOnError:true)
        
        
        def bundle2 = new PayBundle(
            bundlename:'Week Pass',
            price:'70',
            duration:'7'
        ).save(failOnError:true)
        
        def bundle3 = new PayBundle(
            bundlename:'Month Pass',
            price:'300',
            duration:'30'
        ).save(failOnError:true)
        
        
        
    }
    def destroy = {
    }
}

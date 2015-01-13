
import com.zola.gym.*

import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import org.jadira.usertype.dateandtime.joda.*


class BootStrap {

    def init = { servletContext ->
        
        def adminRole = Role.findByAuthority('ROLE_ADMIN')?:new Role(authority:'ROLE_ADMIN').save(failOnError:true)
        def staffRole = Role.findByAuthority('ROLE_STAFF')?:new Role(authority:'ROLE_STAFF').save(failOnError:true)
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
        
    }
    def destroy = {
    }
}

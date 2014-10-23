import com.zola.gym.*


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
            password:'amjad'
        ).save(failOnError:true)
        
        if(!secuser1.authorities.contains(adminRole)){
            UserRole.create secuser1, adminRole
        }
        
    }
    def destroy = {
    }
}

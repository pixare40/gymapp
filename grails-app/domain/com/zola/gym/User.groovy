package com.zola.gym

import org.joda.time.*
import org.joda.time.contrib.hibernate.*
import org.jadira.usertype.dateandtime.joda.*

class User {

	transient springSecurityService

	String username
	String password
        String email
        String firstname
        String lastname
        LocalDate birthdate
        String phoneNumber
        Subscription subscription
    
	boolean enabled = true
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    
	static transients = ['springSecurityService']

	static constraints = {
		username blank: false, unique: true
		password blank: false
                email email:true, unique:true
                firstname nullable:false
                lastname nullable:false
                birthdate nullable:false
                phoneNumber nullable:false, blank: false
                subscription nullable:true, blank:true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role }
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
	}
}

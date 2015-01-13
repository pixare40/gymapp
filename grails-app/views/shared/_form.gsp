<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page import="com.zola.gym.User" %>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'username', 'error')} required">
	<label for="username">
		Username
		<span class="required-indicator">*</span>
	</label>
        <g:textField name="username" value="${userInstance?.username}" />

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'password', 'error')} required">
	<label for="shifttype">
		Password
		<span class="required-indicator">*</span>
	</label>
	<g:passwordField name="password" value="${userInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'email', 'error')} required">
	<label for="email">
		Email:
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" value="${userInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'firstname', 'error')} ">
	<label for="firstname">
		First Name:
	</label>
	<g:textField id="firstname" name="firstname" value="${userInstance?.firstname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'lastname', 'error')} required">
	<label for="lastname">
		Last Name:
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastname" value="${userInstance?.lastname}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'birthdate', 'error')} ">
	<label for="birthdate">
		Birth Date:
	</label>
	<g:datePicker id="birthdate" name="birthdate" value="${userInstance?.birthdate}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: userInstance, field: 'phonenumber', 'error')} ">
	<label for="phonenumber">
		Phone Number:
	</label>
                <input type="number" name="phonenumber" value="${userInstance?.phonenumber}"/>
</div>
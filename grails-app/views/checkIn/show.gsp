
<%@ page import="com.zola.gym.CheckIn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'checkIn.label', default: 'CheckIn')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-checkIn" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="show-checkIn" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list checkIn">
			
				<g:if test="${checkInInstance?.customer}">
				<li class="fieldcontain">
					<span id="customer-label" class="property-label"><g:message code="checkIn.customer.label" default="Customer" /></span>
					
						<span class="property-value" aria-labelledby="customer-label"><g:link controller="user" action="show" id="${checkInInstance?.customer?.id}">${checkInInstance?.customer?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${checkInInstance?.checkintime}">
				<li class="fieldcontain">
					<span id="checkintime-label" class="property-label"><g:message code="checkIn.checkintime.label" default="Checkintime" /></span>
					
						<span class="property-value" aria-labelledby="checkintime-label"><g:formatDate date="${checkInInstance?.checkintime}" /></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:checkInInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${checkInInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

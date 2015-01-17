
<%@ page import="com.zola.gym.PayBundle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'payBundle.label', default: 'PayBundle')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-payBundle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="show-payBundle" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list payBundle">
			
				<g:if test="${payBundleInstance?.bundlename}">
				<li class="fieldcontain">
					<span id="bundlename-label" class="property-label"><g:message code="payBundle.bundlename.label" default="Bundlename" /></span>
					
						<span class="property-value" aria-labelledby="bundlename-label"><g:fieldValue bean="${payBundleInstance}" field="bundlename"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${payBundleInstance?.price}">
				<li class="fieldcontain">
					<span id="price-label" class="property-label"><g:message code="payBundle.price.label" default="Price" /></span>
					
						<span class="property-value" aria-labelledby="price-label"><g:fieldValue bean="${payBundleInstance}" field="price"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${payBundleInstance?.duration}">
				<li class="fieldcontain">
					<span id="duration-label" class="property-label"><g:message code="payBundle.duration.label" default="Duration" /></span>
					
						<span class="property-value" aria-labelledby="duration-label"><g:fieldValue bean="${payBundleInstance}" field="duration"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:payBundleInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${payBundleInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>

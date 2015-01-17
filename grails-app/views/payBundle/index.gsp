
<%@ page import="com.zola.gym.PayBundle" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'payBundle.label', default: 'PayBundle')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-payBundle" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-payBundle" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="bundlename" title="${message(code: 'payBundle.bundlename.label', default: 'Bundlename')}" />
					
						<g:sortableColumn property="price" title="${message(code: 'payBundle.price.label', default: 'Price')}" />
					
						<g:sortableColumn property="duration" title="${message(code: 'payBundle.duration.label', default: 'Duration')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${payBundleInstanceList}" status="i" var="payBundleInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${payBundleInstance.id}">${fieldValue(bean: payBundleInstance, field: "bundlename")}</g:link></td>
					
						<td>${fieldValue(bean: payBundleInstance, field: "price")}</td>
					
						<td>${fieldValue(bean: payBundleInstance, field: "duration")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${payBundleInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

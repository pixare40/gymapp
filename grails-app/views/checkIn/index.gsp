
<%@ page import="com.zola.gym.CheckIn" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'checkIn.label', default: 'CheckIn')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
                <r:require modules="bootstrap"/>
	</head>
	<body>
		<a href="#list-checkIn" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		
		<div id="list-checkIn" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<th><g:message code="checkIn.customer.label" default="Customer" /></th>
					
						<g:sortableColumn property="checkintime" title="${message(code: 'checkIn.checkintime.label', default: 'Checkintime')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${checkInInstanceList}" status="i" var="checkInInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${checkInInstance.id}">${fieldValue(bean: checkInInstance, field: "customer")}</g:link></td>
					
						<td><g:formatDate date="${checkInInstance.checkintime}" /></td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${checkInInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>

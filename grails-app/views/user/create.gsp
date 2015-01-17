<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'user.label', default: 'User')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
                <r:require modules="bootstrap"/>
                <link rel="stylesheet" href="${resource(dir: 'css', file: 'custom.styles.css')}" type="text/css">
                <script>
                    $(document).ready(function() {
                        if (!Modernizr.inputtypes.date) {
                            $("input[type=date]").datepicker({dateFormat: $.datepicker.W3C});
                        }
                    });
                </script>
	</head>
	<body>
            <div class="container">
		<a href="#create-user" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<sec:ifAllGranted roles="ROLE_ADMIN">
                    <g:render template="/admin/menu"/>
                </sec:ifAllGranted>
                <sec:ifAllGranted roles="ROLE_CUSTOMER">
                    <g:render template="/customer/menu"/>
                    </sec:ifAllGranted>
                    <sec:ifNotGranted roles="ROLE_ADMIN,ROLE_CUSTOMER">
                        <g:render template="/home/menu"/>
                    </sec:ifNotGranted>
		<div id="create-user" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${userInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${userInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:userInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
            </div>
	</body>
</html>

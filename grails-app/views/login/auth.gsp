<html>

<head>
<title><g:message code='spring.security.ui.login.title'/></title>
<meta name="layout" content="main">
</head>

<body>
<div class="container">
    <g:render template="/home/menu"/>
<p/>

<div class="login s2ui_center ui-corner-all" style='text-align:center;'>
	<div class="login-inner">
	<form action='${postUrl}' method='POST' id="loginForm" name="loginForm" autocomplete='off'>
	<div class="sign-in">

	<h1><g:message code='spring.security.ui.login.signin'/></h1>

	
			<label for="username"><g:message code='spring.security.ui.login.username'/></label>
			<input name="j_username" id="username" size="20" class="form-control" />
		
			<label for="password"><g:message code='spring.security.ui.login.password'/></label>
                        <input type="password" name="j_password" id="password" size="20" class="form-control" />
                        <br/>
                        <s2ui:submitButton class="btn btn-default btn-lg" elementId='loginButton' form='loginForm' messageCode='spring.security.ui.login.login'/>
			
		

	</div>
	</form>
	</div>
</div>

<script>
$(document).ready(function() {
	$('#username').focus();
});

<s2ui:initCheckboxes/>

</script>
</div>
</body>
</html>

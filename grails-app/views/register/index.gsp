<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page import="com.zola.gym.User"%>

<html>
  <head>
    <meta name="layout" content="main">
    <title>Sample title</title>
    <r:require modules="bootstrap" />
  </head>
  <body class="body">
      <div class="container">
        <br>
        <br>
        <fieldset>
            <legend>User Registration</legend>
            <g:form action="registernewuser" controller="register">
            <g:render template="/shared/form" />
            <g:submitButton name="register" value="Register" />
            </g:form>
        </fieldset>
      </div>
  </body>
</html>

<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="main">
    <title>Check-In</title>
    <r:require modules="bootstrap" />
    <script>
        $(document).ready(setTimeout(function(){
            if($('#response').length > 0{
                $('#response').remove();
            }
        },5000));
        </script>
  </head>
  <body class="body">
      <div class="container">
          <g:render template="/home/menu"/>
        <br>
        <br>
        <div class="text-center center-block">
            <g:form name="checkinform" action="authorizecheckin" controller="checkIn">
                <div class="form-group">
                    <label for="exampleInputEmail1">Email address</label>
                    <input name="email" type="email" class="form-control" id="email" placeholder="Enter email">
                  </div>
                  <div class="form-group">
                    <label for="exampleInputPassword1">Password</label>
                    <input name="password" type="password" class="form-control" id="password" placeholder="Password">
                  </div>
                  
                  <button type="submit" class="btn btn-default btn-lg">Check-In</button>
                </g:form>
        </div>
          <br/>
          <br/>
        <div id="response">
            <g:if test="${flash.info}">
                <div class="alert alert-success text-center">${flash.info}</div>
                </g:if>
                <g:if test="${flash.error}">
                    <div class="alert alert-danger text-center">${flash.error}</div>
                </g:if>
        </div>
      </div>
  </body>
</html>

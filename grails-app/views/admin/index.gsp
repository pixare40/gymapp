<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="main">
    <title>Administrator Dashboard</title>
    <r:require modules="bootstrap" />
  </head>
  <body class="body">
      <div class="container">
          <g:render template="menu"/>
        <br>
        <br>
        <div class="col-xs-4">
            <fieldset>
                <legend>Profile</legend>
                <table>
                    <tbody>
                        <tr>
                            <td>Name</td>
                            <td>${userInstance.firstname} ${userInstance.lastname}</td>
                        </tr>
                        <tr>
                            <td>Date of Birth</td>
                            <td>${userInstance.birthdate}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>${userInstance.email}</td>
                        </tr>
                        <tr>
                            <td>Phone Number</td>
                            <td>${userInstance.phoneNumber}</td>
                        </tr>
                    </tbody>
                </table>
            </fieldset>
        </div>
        
      </div>
  </body>
</html>

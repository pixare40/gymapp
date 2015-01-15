<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="main">
    <title>Sample title</title>
    <r:require modules="bootstrap" />
  </head>
  <body class="body">
      
      <div class="container">
          <g:render template="menu"/>
        <br>
        <br>
        <g:if test="${flash.message}">
        <div class="alert alert-info">${flash.message}</div>
        </g:if>
        <g:if test="${flash.error}">
        <div class="alert alert-danger">${flash.error}</div>
        </g:if>
        <div class="col-xs-5">
            <fieldset>
                <legend>My Subscription</legend>
                <g:if test="${activesubscription != null}">
                You are subscribed to ${activesubscription.name}<br>
                Your subscription ends on ${activesubscription.enddate}
                </g:if>
                <g:else>
                    You have no active subscriptions
                    </g:else>
            </fieldset>
            <fieldset>
                <legend>My Last 5 Check-ins</legend>
                <g:if test="${checkInInstanceList.size()>0}">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <g:sortableColumn property="checkintime" title="Check-In Times"/>
                        </tr>
                    </thead>
                    <tbody>
                        <g:each in="${checkInInstanceList}" status="i" var="checkInInstance">
                                <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">					
                                        <td><g:formatDate date="${checkInInstance.checkintime}" /></td>
                                </tr>
                        </g:each>
                    </tbody>
                </table>
                </g:if>
                <g:else>
                    No Check Ins Available
                    </g:else>
            </fieldset>
        </div>
        <div class="col-xs-7">
            <g:link controller="customer" action="checkin">Check-In</g:link>
        </div>
      </div>
  </body>
</html>

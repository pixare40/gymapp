<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
  <head>
    <meta name="layout" content="main">
    <title>Pay Zone</title>
    <r:require modules="bootstrap" />
  </head>
  <body class="body">
      <div class="container">
          <g:render template="menu"/>
        <br>
        <br>
        <table class="table table-bordered table-condensed">
            <thead><tr>
					
                            <g:sortableColumn property="bundlename" title="Bundle Type" />
                            <g:sortableColumn property="duration" title="${message(code: 'payBundle.duration.label', default: 'Duration')}" />
                            <g:sortableColumn property="price" title="${message(code: 'payBundle.price.label', default: 'Price')}" />
                            <th>Purchase</th>
                    </tr>
            </thead>
            <tbody>
            <g:each in="${payBundleInstanceList}" status="i" var="payBundleInstance">
                    <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                            <td>${fieldValue(bean: payBundleInstance, field: "bundlename")}</td>
                            <td>${fieldValue(bean: payBundleInstance, field: "duration")} day(s)</td>
                            <td>£ ${fieldValue(bean: payBundleInstance, field: "price")}</td>
                            <td>
                                <paypal:button 
                                itemName="${payBundleInstance.bundlename}"
                                itemNumber="${payBundleInstance.id}"
                                amount="${payBundleInstance.price}"
                                discountAmount="0"
                                buyerId="${curuser.id}"
                                />
                            </td>
                    </tr>
            </g:each>
            </tbody>
        </table>
      </div>
  </body>
</html>

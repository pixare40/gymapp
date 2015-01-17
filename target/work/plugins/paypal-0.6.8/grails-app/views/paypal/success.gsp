<html>
	<head>
		<meta name="layout" content="main">
		<title>Transaction Complete</title>
	</head>
	<body id="body">
            <div class="container text-center">
                <br/>
                <br/>
		Your purchase is complete. Information for your reference can be seen below:
		<div id="transactionSummary" class="transactionSummary">
			<div class="transSummaryItem">
				<span class="transSummaryItemName">Transaction ID:</span>
				<span class="transSummaryItemValue">${payment.transactionId}</span>
			</div>
			<g:render template="txsummary" model="[payment:payment]"/>
		</div>
                <g:link controller="home" action="index" class="btn btn-default btn-large">&#8606; Go Home</g:link>
                </div>
	</body>
</html>
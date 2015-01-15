<%@ page import="com.zola.gym.CheckIn" %>



<div class="fieldcontain ${hasErrors(bean: checkInInstance, field: 'customer', 'error')} required">
	<label for="customer">
		<g:message code="checkIn.customer.label" default="Customer" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="customer" name="customer.id" from="${com.zola.gym.User.list()}" optionKey="id" required="" value="${checkInInstance?.customer?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: checkInInstance, field: 'checkintime', 'error')} required">
	<label for="checkintime">
		<g:message code="checkIn.checkintime.label" default="Checkintime" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="checkintime" precision="day"  value="${checkInInstance?.checkintime}"  />

</div>


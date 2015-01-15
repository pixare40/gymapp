<%@ page import="com.zola.gym.PayBundle" %>



<div class="fieldcontain ${hasErrors(bean: payBundleInstance, field: 'bundlename', 'error')} required">
	<label for="bundlename">
		<g:message code="payBundle.bundlename.label" default="Bundlename" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="bundlename" required="" value="${payBundleInstance?.bundlename}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: payBundleInstance, field: 'price', 'error')} required">
	<label for="price">
		<g:message code="payBundle.price.label" default="Price" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="price" value="${fieldValue(bean: payBundleInstance, field: 'price')}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: payBundleInstance, field: 'duration', 'error')} required">
	<label for="duration">
		<g:message code="payBundle.duration.label" default="Duration" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="duration" type="number" value="${payBundleInstance.duration}" required=""/>

</div>


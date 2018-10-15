<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="label" required="true" %>
<%@ attribute name="value" required="false" %>

<label for="${id}">${label}:</label>
<input type="text" id="${id}" name="${id}" value="${value}" />

<script>
	$('#${id}').datepicker({changeMonth: true, changeYear: true});
	$('#${id}').datapicker($.datepicker.regional[ "pt-BR" ]);
</script>

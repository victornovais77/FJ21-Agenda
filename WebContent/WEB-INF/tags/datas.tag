<%@ attribute name="data" required="true" %>
<%@ attribute name="texto" %>

${texto}:
<input id="${data}" type="text" name="${empty data ? 'dataNascimento' : data}">
<script>
	$('#${data}').datepicker({dateFormat: 'dd/mm/yy'})
</script>

	
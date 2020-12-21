<%@include file="/html/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Empleado empleado = (Empleado) row.getObject();
	long groupId = empleado.getGroupId();
	String nombre = Empleado.class.getName();
	int idEmpleado = empleado.getIdEmpleado();
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>

	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/gestion-empleados/edit_empleados.jsp" />
		<portlet:param name="idEmpleado" value="<%= String.valueOf(idEmpleado) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />
	
	<portlet:actionURL name="deleteEmpleado" var="deleteURL">
		<portlet:param name="idEmpleado" value="<%= String.valueOf(idEmpleado) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
	
</liferay-ui:icon-menu>
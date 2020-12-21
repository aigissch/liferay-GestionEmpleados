<%@include file="/html/init.jsp" %>
<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Departamento departamento = (Departamento) row.getObject();
	long groupId = departamento.getGroupId();
	String name = Departamento.class.getName();
	long idDepartamento = departamento.getIdDepartamento();
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<liferay-ui:icon-menu>
	<portlet:renderURL var="editURL">
		<portlet:param name="mvcPath" value="/html/gestion-departamentos/edit_departamentos.jsp" />
		<portlet:param name="idDepartamento" value="<%= String.valueOf(idDepartamento) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<liferay-ui:icon image="edit" url="<%= editURL.toString() %>" />

	<portlet:actionURL name="deleteDepartamento" var="deleteURL">
		<portlet:param name="idDepartamento" value="<%= String.valueOf(idDepartamento) %>" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:actionURL>
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>
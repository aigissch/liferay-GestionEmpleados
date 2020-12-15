
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>

<%@include file="/html/init.jsp" %>

Esta es la lista de empleados.

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addEmpleadoURL">
		<portlet:param name="mvcPath" value="/html/listaempleados/edit_empleado.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addEmpleadoURL.toString() %>" value="Añadir nuevo empleado" />
</aui:button-row>

<liferay-ui:search-container emptyResultsMessage="La lista de empleados está vacía">
	<liferay-ui:search-container-results
		results="<%= EmpleadoLocalServiceUtil.getEmpleadosByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= EmpleadoLocalServiceUtil.getEmpleadosCountByGroupId(scopeGroupId) %>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.sample.model.Empleado"
		keyProperty="idEmpleado"
		modelVar="empleado" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="nombre"
			value="<%= empleado.getNombre() %>"
		/>

		<liferay-ui:search-container-column-text
			name="telefono"
			property="telefono"
		/>

		<%
			String departamentoName = "";
			try {
				departamentoName = DepartamentoLocalServiceUtil.getDepartamento
						(empleado.getIdDepartamento()).getNombre();
			} catch (Exception e) {
			}
		%>

		<liferay-ui:search-container-column-text
			name="departamento"
			value="<%= departamentoName %>"
		/>


		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/listaempleados/empleado_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<%@include file="/html/init.jsp" %>
Esta es la lista de empleados.
<% String redirect = PortalUtil.getCurrentURL(renderRequest); %>

<aui:button-row>
	<portlet:renderURL var="addEmpleadoURL">
		<portlet:param name="mvcPath" value="/html/gestion-empleados/edit_empleados.jsp" />
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
		className="com.telefonica.model.Empleado"
		keyProperty="idEmpleado"
		modelVar="empleado" escapedModel="<%= true %>"
	>
<%-- 			<liferay-ui:search-container-column-text --%>
<%-- 			name="Foto" --%>
<%-- 			value="<%= empleado.getUrlFoto() %>" /> --%>
		<liferay-ui:search-container-column-text>
			<img src="<%= empleado.getUrlFoto() %>" class="avatar">
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text
			name="nombre"
			value="<%= empleado.getNombre() %>" />

		<liferay-ui:search-container-column-text
			name="telefono"
			value="<%= empleado.getTelefono() %>" />
		
		<%
			String departamentoName = "";
			try { departamentoName = DepartamentoLocalServiceUtil.getDepartamento
						(empleado.getIdDepartamento()).getNombre();
			} catch (Exception e) { e.printStackTrace(); }
		%>

		<liferay-ui:search-container-column-text
			name="departamento"
			value="<%= departamentoName %>" />

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/gestion-empleados/actions_empleados.jsp" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
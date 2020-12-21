<%@ include file="/html/init.jsp" %>
Esta es la lista de departamentos
<% String redirect = PortalUtil.getCurrentURL(renderRequest); %>

<aui:button-row>
	<portlet:renderURL var="addDepartamentoURL">
		<portlet:param name="mvcPath" value="/html/gestion-departamentos/edit_departamentos.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>
	<aui:button onClick="<%= addDepartamentoURL.toString() %>" value="Añadir nuevo departamento" />
</aui:button-row>

<% boolean showDepartamento_view = GetterUtil.getBoolean(portletPreferences.getValue("showDepartamento", StringPool.TRUE)); %>

<liferay-ui:search-container emptyResultsMessage="La lista de departamento está vacío">
	<liferay-ui:search-container-results
		results="<%= DepartamentoLocalServiceUtil.getDepartamentosByGroupId(scopeGroupId)%>"
		total="<%= DepartamentoLocalServiceUtil.getDepartamentosCountByGroupId(scopeGroupId)%>"
	/>
	<liferay-ui:search-container-row
		className="com.telefonica.model.Departamento"
		keyProperty="idDepartamento"
		modelVar="departamento" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="nombre"
			value="<%= departamento.getNombre() %>"
		/>
		<liferay-ui:search-container-column-text
			name="descripcion"
			property="descripcion"
		/>
		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/gestion-departamentos/actions_departamentos.jsp"
		/>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>
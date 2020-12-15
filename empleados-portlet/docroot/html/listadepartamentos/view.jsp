<%@ include file="/html/init.jsp" %>

Esta es la lista de departamentos

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>
	<portlet:renderURL var="addDepartamentoURL">
		<portlet:param name="mvcPath" value="/html/listadepartamentos/edit_departamento.jsp" />
		<portlet:param name="redirect" value="<%= redirect %>" />
	</portlet:renderURL>

	<aui:button onClick="<%= addDepartamentoURL.toString() %>" value="Añadir nuevo departamento" />
</aui:button-row>

<%
boolean showDepartamento_view = GetterUtil.getBoolean(portletPreferences.getValue("showDepartamento", StringPool.TRUE));
%>

<liferay-ui:search-container emptyResultsMessage="La lista de departamento está vacío">
	<liferay-ui:search-container-results
		results="<%= DepartamentoLocalServiceUtil.getDepartamentosByGroupId(scopeGroupId)%>"
		total="<%= DepartamentoLocalServiceUtil.getDepartamentosCountByGroupId(scopeGroupId)%>"
	/>

	<liferay-ui:search-container-row
		className="com.liferay.sample.model.Departamento"
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

        <c:choose>
            <c:when test="<%= showDepartamento_view == true %>">
 			
            </c:when>
        </c:choose>

		<liferay-ui:search-container-column-jsp
			align="right"
			path="/html/listadepartamentos/departamento_actions.jsp"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
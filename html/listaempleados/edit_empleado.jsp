<%@include file="/html/init.jsp" %>

<%
	Empleado empleado = null;
	int idEmpleado = ParamUtil.getInteger(request, "idEmpleado");
	if (idEmpleado > 0) {
		empleado = EmpleadoLocalServiceUtil.getEmpleado(idEmpleado);
	}
	ThemeDisplay themeDisplay2 = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
	long scopeGroupId2 = themeDisplay2.getScopeGroupId();
	List<Departamento> departamentos = DepartamentoLocalServiceUtil.getDepartamentosByGroupId(scopeGroupId);
	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= empleado %>" model="<%= Empleado.class %>" />
<portlet:renderURL var="viewEmpleadoURL" />
<portlet:actionURL name='<%= empleado == null ? "addEmpleado" : "updateEmpleado" %>' var="editEmpleadoURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewEmpleadoURL %>"
	title='<%= (empleado != null) ? "Editando a " + empleado.getNombre() : "Nuevo empleado" %>'
/>

<aui:form action="<%= editEmpleadoURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />

		<aui:input name="idEmpleado" type="hidden" value='<%= empleado == null ? "" : empleado.getIdEmpleado() %>'/>

		<aui:input name="nombre" />

		<aui:input name="telefono" />

		<aui:select label="Departamento" name="idDepartamento" showEmptyOption="<%= true %>">

	 		<%
				for (Departamento departamento : departamentos) {
			%>

			<aui:option selected="<%= empleado != null && departamento.getIdDepartamento() == empleado.getIdDepartamento() %>" value="<%= departamento.getIdDepartamento() %>"><%=departamento.getNombre() %></aui:option>

			<%
				}
			%>

		</aui:select>

<%-- 		<aui:input name="date" /> --%>

	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button onClick="<%= viewEmpleadoURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>

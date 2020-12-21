<%@include file="/html/init.jsp" %>
<%
	Departamento departamento = null;
	int IdDepartamento = ParamUtil.getInteger(request, "IdDepartamento");
	if (IdDepartamento > 0) {
		departamento = DepartamentoLocalServiceUtil.getDepartamento(IdDepartamento); }
	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= departamento %>" model="<%= Departamento.class %>" />
<portlet:renderURL var="viewDepartamentoURL" />
<portlet:actionURL name='<%= departamento == null ? "addDepartamento" : "updateDepartamento" %>' var="editDepartamentoURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewDepartamentoURL %>"
	title='<%= (departamento != null) ? departamento.getNombre() : "Nuevo departamento" %>'
/>

<aui:form action="<%= editDepartamentoURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="IdDepartamento" type="hidden" value='<%= departamento == null ? "" : departamento.getIdDepartamento() %>'/>
		<aui:input name="nombre" />
		<aui:input name="descripcion" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button onClick="<%= viewDepartamentoURL %>"  type="cancel" />
	</aui:button-row>
</aui:form>
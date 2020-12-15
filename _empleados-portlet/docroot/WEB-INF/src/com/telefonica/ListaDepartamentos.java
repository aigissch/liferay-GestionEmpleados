package com.telefonica;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.sample.model.Departamento;
import com.liferay.sample.service.DepartamentoLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ListaDepartamentos
 */
public class ListaDepartamentos extends MVCPortlet {
 

	public void addDepartamento(ActionRequest request, ActionResponse response)
			throws Exception {
		_updateDepartamento(request);
		sendRedirect(request, response);
	}

	public void deleteDepartamento(ActionRequest request, ActionResponse response)
		throws Exception {

		int idDepartamento = ParamUtil.getInteger(request, "idDepartamento");

		DepartamentoLocalServiceUtil.deleteDepartamento(idDepartamento);

		sendRedirect(request, response);
	}
	
	public void updateDepartamento(ActionRequest request, ActionResponse response)
		throws Exception {

		_updateDepartamento(request);

		sendRedirect(request, response);
	}

	private Departamento _updateDepartamento(ActionRequest request)
			throws PortalException, SystemException {

		int idDepartamento= (ParamUtil.getInteger(request, "idDepartamento"));
		String nombre = (ParamUtil.getString(request, "nombre"));
		String descripcion = (ParamUtil.getString(request, "descripcion"));
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Departamento.class.getName(), request);
		
		Departamento departamento = null;

		if (idDepartamento <= 0) {

			departamento = DepartamentoLocalServiceUtil.addDepartamento(
				serviceContext.getScopeGroupId(), nombre, descripcion,
				serviceContext);
		}
		else {
			departamento = DepartamentoLocalServiceUtil.getDepartamento(idDepartamento);

			departamento = DepartamentoLocalServiceUtil.updateDepartamento(idDepartamento, nombre,
					descripcion,
					serviceContext);
		}
		
		return departamento;
	}

	private static Log _log = LogFactoryUtil.getLog(ListaDepartamentos.class);

}

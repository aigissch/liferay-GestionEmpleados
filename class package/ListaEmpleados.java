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
import com.liferay.sample.model.Empleado;
import com.liferay.sample.service.EmpleadoLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ListaEmpleados
 */
public class ListaEmpleados extends MVCPortlet {
 
	public void addEmpleado(ActionRequest request, ActionResponse response)
            throws Exception {

        _updateEmpleado(request);

        sendRedirect(request, response);
    }

    public void deleteEmpleado(ActionRequest request, ActionResponse response)
        throws Exception {

        int idEmpleado = ParamUtil.getInteger(request, "idEmpleado");

        EmpleadoLocalServiceUtil.deleteEmpleado(idEmpleado);

        sendRedirect(request, response);
    }

    public void updateEmpleado(ActionRequest request, ActionResponse response)
        throws Exception {

        _updateEmpleado(request);

        sendRedirect(request, response);
    }

    private Empleado _updateEmpleado(ActionRequest request)
        throws PortalException, SystemException {

        int idEmpleado = ParamUtil.getInteger(request, "idEmpleado");
        String nombre = ParamUtil.getString(request, "nombre");
        String telefono = ParamUtil.getString(request, "telefono");
        int idDepartamento = ParamUtil.getInteger(request, "idDepartamento");



        ServiceContext serviceContext = ServiceContextFactory.getInstance(
            Empleado.class.getName(), request);

        Empleado empleado = null;

        if (idEmpleado <= 0) {
            empleado = EmpleadoLocalServiceUtil.addEmpleado(
            		nombre, telefono, idDepartamento,
                serviceContext);
        }
        else {
            empleado = EmpleadoLocalServiceUtil.getEmpleado(idEmpleado);

            empleado = EmpleadoLocalServiceUtil.updateEmpleado(
                idEmpleado, nombre, telefono, idDepartamento, serviceContext);
        }
        
        return empleado;
    }

    private static Log _log = LogFactoryUtil.getLog(ListaEmpleados.class);
}
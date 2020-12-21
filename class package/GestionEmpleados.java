package com.telefonica;

import java.io.File;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.model.DLFolderConstants;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.util.DLUtil;
import com.telefonica.model.Empleado;
import com.telefonica.service.EmpleadoLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class ListaEmpleados
 */
public class GestionEmpleados extends MVCPortlet {
 
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
        throws PortalException, SystemException, Exception {
    	//Al tratarse de multipart, tenemos que usar UploadPortletRequest en lugar de request:
    	UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
        int idEmpleado = ParamUtil.getInteger(uploadRequest, "idEmpleado");
        String nombre = ParamUtil.getString(uploadRequest, "nombre");
        String telefono = ParamUtil.getString(uploadRequest, "telefono");
        int idDepartamento = ParamUtil.getInteger(uploadRequest, "idDepartamento");
        String urlFoto =""; 
		String fileInputName = "foto";
		
        /* EMPLEADO */
        ServiceContext serviceContextEmp = ServiceContextFactory.getInstance(
            Empleado.class.getName(), uploadRequest);
        
        Empleado empleado = null;
        
		if (uploadRequest.getSize(fileInputName) != 0) {
			// Si no subimos fichero
			File uploadedFile = uploadRequest.getFile(fileInputName);
			String fileName = uploadRequest.getFileName(fileInputName);
			long repositoryId = themeDisplay.getScopeGroupId();
			long parentFolderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID; 
			String mimeType = MimeTypesUtil.getContentType(uploadedFile);
			ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), request);
			Folder folder = null;
				try{ 
					folder = DLAppLocalServiceUtil.getFolder(repositoryId, parentFolderId, "fotos_empleados");
				}catch(NoSuchFolderException exp){
					folder = DLAppLocalServiceUtil.addFolder(themeDisplay.getDefaultUserId(),repositoryId,
						parentFolderId, "fotos_empleados", "Fotos de los empleados",serviceContext);
				}
				
				try{
					DLAppLocalServiceUtil.addFileEntry(themeDisplay.getDefaultUserId(), repositoryId, folder.getFolderId(), fileName, mimeType, fileName, fileName, fileName, uploadedFile, serviceContext);
				}catch(DuplicateFileException exp){
					FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(repositoryId, folder.getFolderId(), fileName);
					DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
					DLAppLocalServiceUtil.addFileEntry(themeDisplay.getDefaultUserId(), repositoryId, folder.getFolderId(), fileName, mimeType, fileName, fileName, fileName, uploadedFile, serviceContext);
				}		
			urlFoto = urlFoto(themeDisplay);
		}else { //Si no subimos fichero, la url será la misma
			empleado = EmpleadoLocalServiceUtil.getEmpleado(idEmpleado);
			urlFoto = empleado.getUrlFoto();
		}
		
        if (idEmpleado <= 0) { // Si el empleado es nuevo
            empleado = EmpleadoLocalServiceUtil.addEmpleado(
            		nombre,telefono,idDepartamento,urlFoto,serviceContextEmp);
        }else { //Si el empleado ya existe
            empleado = EmpleadoLocalServiceUtil.getEmpleado(idEmpleado);
            empleado = EmpleadoLocalServiceUtil.updateEmpleado(
                idEmpleado, nombre, telefono, idDepartamento,urlFoto, serviceContextEmp);
        }
        return empleado;
    }
    
    /*
     * Método que devuelve la url absoluta del archivo
     * subido como foto del empleado.
     * 
     */
    private String urlFoto(ThemeDisplay themeDisplay) throws PortalException, SystemException{
    	String url = "";
    	
    	Folder folder = DLAppLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, "fotos_empleados");
    	List<FileEntry> fileEntryList = DLAppServiceUtil.getFileEntries(themeDisplay.getScopeGroupId(), folder.getFolderId());
    	
    	if(fileEntryList != null && fileEntryList.size()>0){
			FileEntry fileEntry = fileEntryList.get(fileEntryList.size()-1);
			url = DLUtil.getPreviewURL(fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK, false, true);
		}
    	
    	return url;
    }
    
	//En caso de querer realizar log
    //private static Log _log = LogFactoryUtil.getLog(GestionEmpleados.class);
}
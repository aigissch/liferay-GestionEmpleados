/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.telefonica.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.telefonica.service.http.EmpleadoServiceSoap}.
 *
 * @author    anadlca
 * @see       com.telefonica.service.http.EmpleadoServiceSoap
 * @generated
 */
public class EmpleadoSoap implements Serializable {
	public static EmpleadoSoap toSoapModel(Empleado model) {
		EmpleadoSoap soapModel = new EmpleadoSoap();

		soapModel.setIdEmpleado(model.getIdEmpleado());
		soapModel.setNombre(model.getNombre());
		soapModel.setTelefono(model.getTelefono());
		soapModel.setIdDepartamento(model.getIdDepartamento());
		soapModel.setUrlFoto(model.getUrlFoto());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static EmpleadoSoap[] toSoapModels(Empleado[] models) {
		EmpleadoSoap[] soapModels = new EmpleadoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EmpleadoSoap[][] toSoapModels(Empleado[][] models) {
		EmpleadoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EmpleadoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EmpleadoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EmpleadoSoap[] toSoapModels(List<Empleado> models) {
		List<EmpleadoSoap> soapModels = new ArrayList<EmpleadoSoap>(models.size());

		for (Empleado model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EmpleadoSoap[soapModels.size()]);
	}

	public EmpleadoSoap() {
	}

	public int getPrimaryKey() {
		return _idEmpleado;
	}

	public void setPrimaryKey(int pk) {
		setIdEmpleado(pk);
	}

	public int getIdEmpleado() {
		return _idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		_idEmpleado = idEmpleado;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getTelefono() {
		return _telefono;
	}

	public void setTelefono(String telefono) {
		_telefono = telefono;
	}

	public int getIdDepartamento() {
		return _idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		_idDepartamento = idDepartamento;
	}

	public String getUrlFoto() {
		return _urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		_urlFoto = urlFoto;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	private int _idEmpleado;
	private String _nombre;
	private String _telefono;
	private int _idDepartamento;
	private String _urlFoto;
	private long _companyId;
	private long _groupId;
}
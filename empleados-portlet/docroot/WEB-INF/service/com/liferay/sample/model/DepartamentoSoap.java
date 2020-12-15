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

package com.liferay.sample.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    anadlca
 * @generated
 */
public class DepartamentoSoap implements Serializable {
	public static DepartamentoSoap toSoapModel(Departamento model) {
		DepartamentoSoap soapModel = new DepartamentoSoap();

		soapModel.setIdDepartamento(model.getIdDepartamento());
		soapModel.setNombre(model.getNombre());
		soapModel.setDescripcion(model.getDescripcion());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static DepartamentoSoap[] toSoapModels(Departamento[] models) {
		DepartamentoSoap[] soapModels = new DepartamentoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DepartamentoSoap[][] toSoapModels(Departamento[][] models) {
		DepartamentoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DepartamentoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DepartamentoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DepartamentoSoap[] toSoapModels(List<Departamento> models) {
		List<DepartamentoSoap> soapModels = new ArrayList<DepartamentoSoap>(models.size());

		for (Departamento model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DepartamentoSoap[soapModels.size()]);
	}

	public DepartamentoSoap() {
	}

	public int getPrimaryKey() {
		return _idDepartamento;
	}

	public void setPrimaryKey(int pk) {
		setIdDepartamento(pk);
	}

	public int getIdDepartamento() {
		return _idDepartamento;
	}

	public void setIdDepartamento(int idDepartamento) {
		_idDepartamento = idDepartamento;
	}

	public String getNombre() {
		return _nombre;
	}

	public void setNombre(String nombre) {
		_nombre = nombre;
	}

	public String getDescripcion() {
		return _descripcion;
	}

	public void setDescripcion(String descripcion) {
		_descripcion = descripcion;
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

	private int _idDepartamento;
	private String _nombre;
	private String _descripcion;
	private long _companyId;
	private long _groupId;
}
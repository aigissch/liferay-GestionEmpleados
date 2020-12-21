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
 * This class is used by SOAP remote services, specifically {@link com.telefonica.service.http.TelefonoServiceSoap}.
 *
 * @author    anadlca
 * @see       com.telefonica.service.http.TelefonoServiceSoap
 * @generated
 */
public class TelefonoSoap implements Serializable {
	public static TelefonoSoap toSoapModel(Telefono model) {
		TelefonoSoap soapModel = new TelefonoSoap();

		soapModel.setIdTelefono(model.getIdTelefono());
		soapModel.setNumero(model.getNumero());
		soapModel.setIdEmpleado(model.getIdEmpleado());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static TelefonoSoap[] toSoapModels(Telefono[] models) {
		TelefonoSoap[] soapModels = new TelefonoSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TelefonoSoap[][] toSoapModels(Telefono[][] models) {
		TelefonoSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TelefonoSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TelefonoSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TelefonoSoap[] toSoapModels(List<Telefono> models) {
		List<TelefonoSoap> soapModels = new ArrayList<TelefonoSoap>(models.size());

		for (Telefono model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TelefonoSoap[soapModels.size()]);
	}

	public TelefonoSoap() {
	}

	public int getPrimaryKey() {
		return _idTelefono;
	}

	public void setPrimaryKey(int pk) {
		setIdTelefono(pk);
	}

	public int getIdTelefono() {
		return _idTelefono;
	}

	public void setIdTelefono(int idTelefono) {
		_idTelefono = idTelefono;
	}

	public String getNumero() {
		return _numero;
	}

	public void setNumero(String numero) {
		_numero = numero;
	}

	public int getIdEmpleado() {
		return _idEmpleado;
	}

	public void setIdEmpleado(int idEmpleado) {
		_idEmpleado = idEmpleado;
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

	private int _idTelefono;
	private String _numero;
	private int _idEmpleado;
	private long _companyId;
	private long _groupId;
}
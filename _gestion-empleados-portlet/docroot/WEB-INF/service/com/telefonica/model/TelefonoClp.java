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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.telefonica.service.TelefonoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anadlca
 */
public class TelefonoClp extends BaseModelImpl<Telefono> implements Telefono {
	public TelefonoClp() {
	}

	public Class<?> getModelClass() {
		return Telefono.class;
	}

	public String getModelClassName() {
		return Telefono.class.getName();
	}

	public int getPrimaryKey() {
		return _idTelefono;
	}

	public void setPrimaryKey(int primaryKey) {
		setIdTelefono(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_idTelefono);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idTelefono", getIdTelefono());
		attributes.put("numero", getNumero());
		attributes.put("idEmpleado", getIdEmpleado());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idTelefono = (Integer)attributes.get("idTelefono");

		if (idTelefono != null) {
			setIdTelefono(idTelefono);
		}

		String numero = (String)attributes.get("numero");

		if (numero != null) {
			setNumero(numero);
		}

		Integer idEmpleado = (Integer)attributes.get("idEmpleado");

		if (idEmpleado != null) {
			setIdEmpleado(idEmpleado);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}
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

	public BaseModel<?> getTelefonoRemoteModel() {
		return _telefonoRemoteModel;
	}

	public void setTelefonoRemoteModel(BaseModel<?> telefonoRemoteModel) {
		_telefonoRemoteModel = telefonoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			TelefonoLocalServiceUtil.addTelefono(this);
		}
		else {
			TelefonoLocalServiceUtil.updateTelefono(this);
		}
	}

	@Override
	public Telefono toEscapedModel() {
		return (Telefono)Proxy.newProxyInstance(Telefono.class.getClassLoader(),
			new Class[] { Telefono.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		TelefonoClp clone = new TelefonoClp();

		clone.setIdTelefono(getIdTelefono());
		clone.setNumero(getNumero());
		clone.setIdEmpleado(getIdEmpleado());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(Telefono telefono) {
		int primaryKey = telefono.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		TelefonoClp telefono = null;

		try {
			telefono = (TelefonoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = telefono.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{idTelefono=");
		sb.append(getIdTelefono());
		sb.append(", numero=");
		sb.append(getNumero());
		sb.append(", idEmpleado=");
		sb.append(getIdEmpleado());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("com.telefonica.model.Telefono");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idTelefono</column-name><column-value><![CDATA[");
		sb.append(getIdTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numero</column-name><column-value><![CDATA[");
		sb.append(getNumero());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idEmpleado</column-name><column-value><![CDATA[");
		sb.append(getIdEmpleado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private int _idTelefono;
	private String _numero;
	private int _idEmpleado;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _telefonoRemoteModel;
}
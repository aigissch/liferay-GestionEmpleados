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

import com.telefonica.service.DepartamentoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anadlca
 */
public class DepartamentoClp extends BaseModelImpl<Departamento>
	implements Departamento {
	public DepartamentoClp() {
	}

	public Class<?> getModelClass() {
		return Departamento.class;
	}

	public String getModelClassName() {
		return Departamento.class.getName();
	}

	public int getPrimaryKey() {
		return _idDepartamento;
	}

	public void setPrimaryKey(int primaryKey) {
		setIdDepartamento(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_idDepartamento);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idDepartamento", getIdDepartamento());
		attributes.put("nombre", getNombre());
		attributes.put("descripcion", getDescripcion());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idDepartamento = (Integer)attributes.get("idDepartamento");

		if (idDepartamento != null) {
			setIdDepartamento(idDepartamento);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String descripcion = (String)attributes.get("descripcion");

		if (descripcion != null) {
			setDescripcion(descripcion);
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

	public BaseModel<?> getDepartamentoRemoteModel() {
		return _departamentoRemoteModel;
	}

	public void setDepartamentoRemoteModel(BaseModel<?> departamentoRemoteModel) {
		_departamentoRemoteModel = departamentoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			DepartamentoLocalServiceUtil.addDepartamento(this);
		}
		else {
			DepartamentoLocalServiceUtil.updateDepartamento(this);
		}
	}

	@Override
	public Departamento toEscapedModel() {
		return (Departamento)Proxy.newProxyInstance(Departamento.class.getClassLoader(),
			new Class[] { Departamento.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DepartamentoClp clone = new DepartamentoClp();

		clone.setIdDepartamento(getIdDepartamento());
		clone.setNombre(getNombre());
		clone.setDescripcion(getDescripcion());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(Departamento departamento) {
		int primaryKey = departamento.getPrimaryKey();

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

		DepartamentoClp departamento = null;

		try {
			departamento = (DepartamentoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = departamento.getPrimaryKey();

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

		sb.append("{idDepartamento=");
		sb.append(getIdDepartamento());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append(", descripcion=");
		sb.append(getDescripcion());
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
		sb.append("com.telefonica.model.Departamento");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idDepartamento</column-name><column-value><![CDATA[");
		sb.append(getIdDepartamento());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>descripcion</column-name><column-value><![CDATA[");
		sb.append(getDescripcion());
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

	private int _idDepartamento;
	private String _nombre;
	private String _descripcion;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _departamentoRemoteModel;
}
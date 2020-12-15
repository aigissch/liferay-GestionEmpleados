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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.liferay.sample.service.EmpleadoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anadlca
 */
public class EmpleadoClp extends BaseModelImpl<Empleado> implements Empleado {
	public EmpleadoClp() {
	}

	public Class<?> getModelClass() {
		return Empleado.class;
	}

	public String getModelClassName() {
		return Empleado.class.getName();
	}

	public int getPrimaryKey() {
		return _idEmpleado;
	}

	public void setPrimaryKey(int primaryKey) {
		setIdEmpleado(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Integer(_idEmpleado);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Integer)primaryKeyObj).intValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("idEmpleado", getIdEmpleado());
		attributes.put("nombre", getNombre());
		attributes.put("telefono", getTelefono());
		attributes.put("idDepartamento", getIdDepartamento());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer idEmpleado = (Integer)attributes.get("idEmpleado");

		if (idEmpleado != null) {
			setIdEmpleado(idEmpleado);
		}

		String nombre = (String)attributes.get("nombre");

		if (nombre != null) {
			setNombre(nombre);
		}

		String telefono = (String)attributes.get("telefono");

		if (telefono != null) {
			setTelefono(telefono);
		}

		Integer idDepartamento = (Integer)attributes.get("idDepartamento");

		if (idDepartamento != null) {
			setIdDepartamento(idDepartamento);
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

	public BaseModel<?> getEmpleadoRemoteModel() {
		return _empleadoRemoteModel;
	}

	public void setEmpleadoRemoteModel(BaseModel<?> empleadoRemoteModel) {
		_empleadoRemoteModel = empleadoRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			EmpleadoLocalServiceUtil.addEmpleado(this);
		}
		else {
			EmpleadoLocalServiceUtil.updateEmpleado(this);
		}
	}

	@Override
	public Empleado toEscapedModel() {
		return (Empleado)Proxy.newProxyInstance(Empleado.class.getClassLoader(),
			new Class[] { Empleado.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EmpleadoClp clone = new EmpleadoClp();

		clone.setIdEmpleado(getIdEmpleado());
		clone.setNombre(getNombre());
		clone.setTelefono(getTelefono());
		clone.setIdDepartamento(getIdDepartamento());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(Empleado empleado) {
		int primaryKey = empleado.getPrimaryKey();

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

		EmpleadoClp empleado = null;

		try {
			empleado = (EmpleadoClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		int primaryKey = empleado.getPrimaryKey();

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
		StringBundler sb = new StringBundler(13);

		sb.append("{idEmpleado=");
		sb.append(getIdEmpleado());
		sb.append(", nombre=");
		sb.append(getNombre());
		sb.append(", telefono=");
		sb.append(getTelefono());
		sb.append(", idDepartamento=");
		sb.append(getIdDepartamento());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(22);

		sb.append("<model><model-name>");
		sb.append("com.liferay.sample.model.Empleado");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>idEmpleado</column-name><column-value><![CDATA[");
		sb.append(getIdEmpleado());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nombre</column-name><column-value><![CDATA[");
		sb.append(getNombre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telefono</column-name><column-value><![CDATA[");
		sb.append(getTelefono());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>idDepartamento</column-name><column-value><![CDATA[");
		sb.append(getIdDepartamento());
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

	private int _idEmpleado;
	private String _nombre;
	private String _telefono;
	private int _idDepartamento;
	private long _companyId;
	private long _groupId;
	private BaseModel<?> _empleadoRemoteModel;
}
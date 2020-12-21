create table ge_Departamento (
	idDepartamento INTEGER not null primary key,
	nombre VARCHAR(75) null,
	descripcion VARCHAR(75) null,
	companyId LONG,
	groupId LONG
);

create table ge_Empleado (
	idEmpleado INTEGER not null primary key,
	nombre VARCHAR(75) null,
	telefono VARCHAR(75) null,
	idDepartamento INTEGER,
	urlFoto VARCHAR(500) null,
	companyId LONG,
	groupId LONG
);

create table ge_Telefono (
	idTelefono INTEGER not null primary key,
	numero VARCHAR(75) null,
	idEmpleado INTEGER,
	companyId LONG,
	groupId LONG
);
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
	companyId LONG,
	groupId LONG
);
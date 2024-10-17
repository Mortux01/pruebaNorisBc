-- Crear tabla de usuarios
CREATE TABLE USUARIO(
    id VARCHAR(255)  PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created TIMESTAMP(6),
    modified TIMESTAMP(6),
    last_login TIMESTAMP(6),
    token VARCHAR(255) NOT NULL,
    isactive BOOLEAN
);

-- Crear tabla de telefonos
CREATE TABLE TELEFONOS(
    id INTEGER,
    number VARCHAR(255) NOT NULL,
    cityCode VARCHAR(255) NOT NULL,
    countryCode VARCHAR(255) NOT NULL
);

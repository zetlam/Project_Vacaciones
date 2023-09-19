CREATE database Vacaciones;

use Vacaciones;

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombreUsuario VARCHAR(20) NOT NULL,
    clave VARCHAR(20) NOT NULL,
    nombre VARCHAR(25),
    apellidos VARCHAR(40),
    tipoUsuario VARCHAR(20)
);


CREATE TABLE PeticionVacaciones (
    idPeticion INT AUTO_INCREMENT PRIMARY KEY,
    fechaInicio DATE,
    fechaFin DATE,
    estado VARCHAR(20),
    comentario TEXT,
    realiza INT, 
    año INT
);

ALTER TABLE PeticionVacaciones
ADD CONSTRAINT fk_realiza_usuarios
FOREIGN KEY (realiza)
REFERENCES Usuarios(id);

INSERT INTO Usuarios (nombreUsuario, clave, nombre, apellidos, tipoUsuario)
VALUES
    ('Pepe1', '12345', 'Pepe', 'Seoane', 'Empleado'),
    ('Juan2', '1234', 'Juan', 'Gonzalez', 'Empleado'),
    ('admin', 'admin123', 'Admin', 'Administrador', 'Administrador');

INSERT INTO PeticionVacaciones (fechaInicio, fechaFin, estado, comentario, realiza, año)
VALUES
    ('2023-09-10', '2023-09-15', 'PENDIENTE', 'Necesito tiempo libre', 1, 2023),
    ('2023-08-20', '2023-08-25', 'ACEPTADA', 'Vacaciones confirmadas', 2, 2023),
    ('2023-11-05', '2023-11-10', 'PENDIENTE', 'Espero su aprobación', 1, 2023),
    ('2023-11-15', '2023-11-10', 'RECHAZADA', 'Espero su aprobación', 1, 2023);
    
INSERT INTO NovaTabela (ID, NombreUsuario, FechaInicio, FechaFin, Estado)
SELECT P.idPeticion, U.nombre, P.fechaInicio, P.fechaFin, P.estado
FROM PeticionVacaciones AS P
INNER JOIN Usuarios AS U ON P.realiza = U.id
WHERE año LIKE ? AND estado LIKE ? AND U.NombreUsuario LIKE ?;

    
    update usuarios 
    set tipoUsuario = "TRABAJADOR" 
    where id < 3;
    
    
SELECT P.idPeticion AS ID, U.nombre AS NombreUsuario, P.fechaInicio AS FechaInicio, P.fechaFin AS FechaFin, P.estado AS Estado 
FROM PeticionVacaciones AS P INNER JOIN Usuarios AS U ON P.realiza = U.id 
where año LIKE ? and estado LIKE ? and U.NombreUsuario LIKE ?;
    
    

BEGIN;

-- Inserción de usuarios
INSERT INTO public.usuario (dni, contrasena, direccion, email, fecha_nacimiento, foto_usuario, genero, nivel_acceso, nombre_completo, permiso_conducir, r_pregunta_seguridad, telefono, usuario, usuario_activo)
VALUES 
('12345678A', 'pass1234', 'Calle A, 1', 'usuario1@email.com', '1990-01-01', NULL, 'M', 1, 'Usuario Uno', true, 'Color favorito?', 600123456, 'user1', true),
('23456789B', 'pass1234', 'Calle B, 2', 'usuario2@email.com', '1985-02-02', NULL, 'F', 1, 'Usuario Dos', true, 'Mascota?', 600234567, 'user2', true),
('34567890C', 'pass1234', 'Calle C, 3', 'usuario3@email.com', '1992-03-03', NULL, 'M', 1, 'Usuario Tres', true, 'Comida favorita?', 600345678, 'user3', true),
('45678901D', 'pass1234', 'Calle D, 4', 'usuario4@email.com', '1995-04-04', NULL, 'F', 1, 'Usuario Cuatro', false, 'Película favorita?', 600456789, 'user4', true),
('56789012E', 'pass1234', 'Calle E, 5', 'usuario5@email.com', '1993-05-05', NULL, 'M', 1, 'Usuario Cinco', false, 'Animal favorito?', 600567890, 'user5', true);

-- Inserción de conductores
INSERT INTO public.conductor (dni, foto_carnet, verificado)
VALUES 
('12345678A', NULL, true),
('23456789B', NULL, true),
('34567890C', NULL, true);

-- Inserción de coches asociados a los conductores
INSERT INTO public.coche (matricula, anio, carroceria, foto_coche, marca, modelo, numero_plazas, dni)
VALUES 
('ABC1234', 2015, 'SUV', NULL, 'Toyota', 'RAV4', 5, '12345678A'),
('DEF5678', 2018, 'Sedan', NULL, 'Honda', 'Civic', 4, '23456789B'),
('GHI9012', 2020, 'Hatchback', NULL, 'Ford', 'Focus', 5, '34567890C');

-- Inserción de viajes asociados a los coches
INSERT INTO public.viaje (destino, fecha, hora, origen, plazas_disponibles, precio, matricula)
VALUES 
('Madrid', '2024-11-10', '08:00:00', 'Barcelona', 5, 30.50, 'ABC1234'),
('Valencia', '2024-11-12', '10:30:00', 'Madrid', 4, 20.00, 'DEF5678'),
('Sevilla', '2024-11-15', '12:00:00', 'Granada', 5, 25.00, 'GHI9012'),
('Bilbao', '2024-11-18', '15:00:00', 'Pamplona', 5, 27.50, 'ABC1234'),
('Malaga', '2024-11-20', '09:00:00', 'Sevilla', 4, 22.00, 'DEF5678');

-- Inserción de plazas para los viajes
-- Para coche ABC1234 (5 plazas)
INSERT INTO public.plazas (n_asiento, id_viaje) 
VALUES 
(1, 1), (2, 1), (3, 1), (4, 1), (5, 1), -- Viaje 1
(1, 4), (2, 4), (3, 4), (4, 4), (5, 4); -- Viaje 4

-- Para coche DEF5678 (4 plazas)
INSERT INTO public.plazas (n_asiento, id_viaje) 
VALUES 
(1, 2), (2, 2), (3, 2), (4, 2), -- Viaje 2
(1, 5), (2, 5), (3, 5), (4, 5); -- Viaje 5

-- Para coche GHI9012 (5 plazas)
INSERT INTO public.plazas (n_asiento, id_viaje) 
VALUES 
(1, 3), (2, 3), (3, 3), (4, 3), (5, 3); -- Viaje 3

COMMIT;

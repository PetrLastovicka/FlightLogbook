
INSERT INTO wings (manufacturer, model, wing_size, category, my, purchased, initial_hours, my_hours, total_hours,
total_flights, next_check_date, next_check_hours, active)
VALUES ('ElSpeedo', 'Bobby', 'S', 'ENA', false, null, 0, 0, 0, 0, null, 0, false),
('UP', 'Rimo', 'S/M', 'ENA', true, null, 0, 0, 0, 0, null, 220, true);



INSERT INTO flights (date, duration, location, wing_id, min_altitude, max_altitude, max_climb, max_sink, odometer)
VALUES (CURRENT_TIMESTAMP, 1, 'Lanzarote', 1, 100, 1000, 3, -4, 10);

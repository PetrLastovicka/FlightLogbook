INSERT INTO wings (manufacturer, model, size, category, active, initial_hours, total_hours, my, next_check_hours, total_flights)
VALUES ('UP', 'Rimo', 'S/M', 'ENA', true, 10, 100, true, 50, 10);

INSERT INTO flights (date, duration, location, wing_id, min_altitude, max_altitude, max_climb, max_sink, odometer)
VALUES (CURRENT_TIMESTAMP, 1, 'Lanzarote', 1, 100, 1000, 3, -4, 10);

-- Brands
INSERT IGNORE INTO brand (id, name, logo_url) VALUES (1, 'Royal Enfield', 'http://localhost:8081/images/Royal%20Enfield.jpg');
INSERT IGNORE INTO brand (id, name, logo_url) VALUES (2, 'Yamaha', 'http://localhost:8081/images/Yamaha.jpg');
INSERT IGNORE INTO brand (id, name, logo_url) VALUES (3, 'KTM', 'http://localhost:8081/images/ktm_racing-logo.jpg');

-- Bikes
-- Royal Enfield Classic 350
INSERT IGNORE INTO bike (id, name, brand_id, price_min, price_max, image_url, description) 
VALUES (1, 'Classic 350', 1, 193000, 225000, 'http://localhost:8081/images/Classic%20350.jpg', 'The Classic 350 is a retro-styled cruiser bike available at a starting price of Rs. 1.93 Lakh in India.');

-- Yamaha MT 15
INSERT IGNORE INTO bike (id, name, brand_id, price_min, price_max, image_url, description) 
VALUES (2, 'MT 15 V2', 2, 168000, 174000, 'http://localhost:8081/images/MT%2015%20V2.jpg', 'Yamaha MT 15 V2 is a street bike available at a starting price of Rs. 1.68 Lakh in India.');

-- Specifications
-- Classic 350
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (1, 'Engine', '349 cc');
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (1, 'Power', '20.2 bhp');
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (1, 'Torque', '27 Nm');
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (1, 'Mileage', '35 kmpl');

-- MT 15
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (2, 'Engine', '155 cc');
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (2, 'Power', '18.1 bhp');
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (2, 'Torque', '14.1 Nm');
INSERT IGNORE INTO specification (bike_id, spec_key, spec_value) VALUES (2, 'Mileage', '48 kmpl');

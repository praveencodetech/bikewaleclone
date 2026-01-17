CREATE TABLE IF NOT EXISTS brand (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    logo_url VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS bike (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand_id BIGINT,
    price_min DOUBLE,
    price_max DOUBLE,
    image_url VARCHAR(255),
    description TEXT,
    FOREIGN KEY (brand_id) REFERENCES brand(id)
);

CREATE TABLE IF NOT EXISTS specification (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bike_id BIGINT,
    spec_key VARCHAR(255),
    spec_value VARCHAR(255),
    FOREIGN KEY (bike_id) REFERENCES bike(id)
);

-- Initial Data Seeding (Optional, for testing)
INSERT INTO brand (name, logo_url) VALUES ('Royal Enfield', 'https://upload.wikimedia.org/wikipedia/commons/4/42/Royal_Enfield_logo.png');
INSERT INTO brand (name, logo_url) VALUES ('Yamaha', 'https://upload.wikimedia.org/wikipedia/commons/8/8b/Yamaha_Motor_Logo_2020.png');

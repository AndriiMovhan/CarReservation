CREATE TABLE IF NOT EXISTS car(
    id          SERIAL PRIMARY KEY,
    brand       VARCHAR(255) NOT NULL,
    model       VARCHAR(255) NOT NULL,
    description TEXT
);

CREATE TABLE IF NOT EXISTS car_photo_urls(
    car_id    BIGSERIAL    NOT NULL,
    photo_url VARCHAR(255) NOT NULL,
    CONSTRAINT car_photo_urls_pk PRIMARY KEY (car_id, photo_url),
    CONSTRAINT car_photo_urls_car_id_fk FOREIGN KEY (car_id) REFERENCES car (id)
);
-- !Ups

CREATE TABLE auto_mark (
    id BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    country VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE auto_model (
                           id BIGINT(20) NOT NULL AUTO_INCREMENT,
                           name VARCHAR(255) NOT NULL,
                           production_start_year INT NOT NULL,
                           production_end_year INT NOT NULL,
                           PRIMARY KEY (id)
);

CREATE TABLE shop_position (
                           id BIGINT(20) NOT NULL AUTO_INCREMENT,
                           mark_id BIGINT(20) NOT NULL,
                           model_id BIGINT(20) NOT NULL,
                           year_of_production INT NOT NULL,
                           mileage DOUBLE NOT NULL,
                           price DECIMAL NOT NULL,
                           PRIMARY KEY (id),
                           foreign key (mark_id) references auto_mark(id),
                           foreign key (model_id) references auto_model(id)
);

-- !Downs

DROP TABLE auto_mark;

DROP TABLE auto_model;

DROP TABLE shop_position;
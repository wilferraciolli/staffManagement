drop table IF EXISTS day_schedule;
create TABLE day_schedule
(
    id                   BIGINT       NOT NULL auto_increment,
    day                  DATE         NOT NULL,
    PRIMARY KEY (id)
);

drop table IF EXISTS person_schedule;
create TABLE person_schedule
(
    id                   BIGINT       NOT NULL auto_increment,
    person_id            BIGINT       NOT NULL,
    shift_id             BIGINT       NOT NULL,
    open_shift           BIT          NULL,
    all_day_shift        BIT          NULL,
    night_shift          BIT          NULL,
    PRIMARY KEY (id)
);

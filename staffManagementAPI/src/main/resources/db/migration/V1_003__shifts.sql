drop table IF EXISTS shift;
create TABLE shift
(
    id                   BIGINT       NOT NULL auto_increment,
    name                 VARCHAR(80)  NOT NULL,
    description          VARCHAR(255) NOT NULL,
    shift_type           VARCHAR(50)  NOT NULL,
    supervisor_only      BIT          NOT NULL,
    start_time           TIME         NOT NULL,
    end_time             TIME         NOT NULL,
    PRIMARY KEY (id)
);

insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6000, 'All day', 'All day shift, normally used for when on call', 'ALL_DAY', 0, '15:00:00', '23:00:00');

insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6001, 'Morning opening', 'Morning shift to open the lab', 'HALF_DAY', 1, '07:30:00', '16:00:00');


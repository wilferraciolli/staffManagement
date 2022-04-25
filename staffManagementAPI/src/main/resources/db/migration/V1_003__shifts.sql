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
values (6000, 'Open', 'Morning opening shift, used for when opening the lab', 'HALF_DAY', 1, '07:30:00', '13:00:00');
insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6001, 'Morning', 'Morning All day shift', 'ALL_DAY', 1, '07:30:00', '16:00:00');

insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6002, 'Morning', 'Late morning shift', 'ALL_DAY', 0, '10:00:00', '18:00:00');
insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6003, 'Afternoon', 'Afternoon', 'ALL_DAY', 0, '12:00:00', '20:00:00');
insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6004, 'Late Afternoon', 'Afternoon all day shift', 'ALL_DAY', 0, '15:00:00', '23:00:00');

insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6005, 'Close', 'Close lab shift', 'HALF_DAY', 1, '16:00:00', '19:00:00');

insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6006, 'Open Special', 'Open special', 'HALF_DAY', 1, '07:30:00', '12:00:00');
insert into shift(id, name, description, shift_type, supervisor_only, start_time, end_time)
values (6007, 'Close Special', 'Close special', 'HALF_DAY', 1, '19:00:00', '23:00:00');


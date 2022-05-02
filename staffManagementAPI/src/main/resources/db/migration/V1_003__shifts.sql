drop table IF EXISTS shift;
create TABLE shift
(
    id                   BIGINT       NOT NULL auto_increment,
    schedule_id          BIGINT       NOT NULL,
    title                VARCHAR(80)  NOT NULL,
    description          VARCHAR(255) NOT NULL,
    shift_type           VARCHAR(50)  NOT NULL,
    supervisor_only      BIT          NOT NULL,
    active               BIT          NOT NULL,
    start_time           TIME         NOT NULL,
    end_time             TIME         NOT NULL,
    PRIMARY KEY (id)
);

insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6000, 5000, 'Open', 'Morning opening shift, used for when opening the lab', 'HALF_DAY', 1, 1, '07:30:00', '13:00:00');
insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6001, 5000, 'Morning', 'Morning All day shift', 'ALL_DAY', 1, 1, '07:30:00', '16:00:00');

insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6002, 5001, 'Morning', 'Late morning shift', 'ALL_DAY', 0, 1, '10:00:00', '18:00:00');
insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6003, 5001, 'Afternoon', 'Afternoon', 'ALL_DAY', 0, 1, '12:00:00', '20:00:00');
insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6004, 5001, 'Late Afternoon', 'Afternoon all day shift', 'ALL_DAY', 0, 1, '15:00:00', '23:00:00');

insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6005, 5002, 'Close', 'Close lab shift', 'HALF_DAY', 1, 1, '16:00:00', '19:00:00');

insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6006, 5003, 'Open Special', 'Open special', 'HALF_DAY', 1, 1, '07:30:00', '12:00:00');
insert into shift(id, schedule_id, title, description, shift_type, supervisor_only, active, start_time, end_time)
values (6007, 5003, 'Close Special', 'Close special', 'HALF_DAY', 1, 1, '19:00:00', '23:00:00');


insert into user(id, username, password, active)
values (1000, 'WilFerraciolli@wiltech.com', '{bcrypt}$2a$10$2WacIN6u7bxhQOkx9gxPAOaTZjab0GCzoCSdJF7HU5ajf5CC4hgga', 1);
insert into User_Roles(user_id, role)
values (1000, 'ROLE_ADMIN');
insert into User_Roles(user_id, role)
values (1000, 'ROLE_HR_ADMIN');
insert into User_Roles(user_id, role)
values (1000, 'ROLE_USER');

insert into User(id, username, password, active)
values (1001, 'George@wiltech.com', '{bcrypt}$2a$10$2WacIN6u7bxhQOkx9gxPAOaTZjab0GCzoCSdJF7HU5ajf5CC4hgga', 1);
insert into User_Roles(user_id, role)
values (1001, 'ROLE_USER');
insert into User_Roles(user_id, role)
values (1001, 'ROLE_ADMIN');

insert into User(id, username, password, active)
values (1002, 'Maria@wiltech.com', '{bcrypt}$2a$10$2WacIN6u7bxhQOkx9gxPAOaTZjab0GCzoCSdJF7HU5ajf5CC4hgga', 1);
insert into User_Roles(user_id, role)
values (1002, 'ROLE_USER');

insert into User(id, username, password, active)
values (1003, 'Test@wiltech.com', '{bcrypt}$2a$10$2WacIN6u7bxhQOkx9gxPAOaTZjab0GCzoCSdJF7HU5ajf5CC4hgga', 1);
insert into User_Roles(user_id, role)
values (1003, 'ROLE_USER');

insert into User(id, username, password, active)
values (1004, 'athina@wiltech.com', '{bcrypt}$2a$10$2WacIN6u7bxhQOkx9gxPAOaTZjab0GCzoCSdJF7HU5ajf5CC4hgga', 1);
insert into User_Roles(user_id, role)
values (1004, 'ROLE_USER');

insert into person(id, user_Id, first_name, last_name, email, gender, phone_Number, date_of_birth, marital_status, number_of_dependants, allowed_on_call, fully_trained, allowed_special_shift)
values (2000, 1000, 'Wiliam', 'Ferraciolli', 'WilFerraciolli@wiltech.com', 'MALE', '+44 7540595289', '1985-02-16', 'MARRIED', 1, 1, 1, 1);
insert into person(id, user_Id, first_name, last_name, email, gender, phone_Number, date_of_birth, marital_status, number_of_dependants, allowed_on_call, fully_trained, allowed_special_shift)
values (2001, 1001, 'George', 'Ferraciolli', 'George@wiltech.com', 'MALE', '+44 7540595289', '2015-07-13', 'SINGLE', 0, 0, 0, 0);
insert into person(id, user_Id, first_name, last_name, email, gender, phone_Number, date_of_birth, marital_status, number_of_dependants, allowed_on_call, fully_trained, allowed_special_shift)
values (2002, 1002, 'Maria', 'Georgiou', 'Maria@wiltech.com', 'FEMALE', '+44 7540595289', '2015-07-13', 'SINGLE', 1, 0, 0, 0);
insert into person(id, user_Id, first_name, last_name, email, gender, phone_Number, date_of_birth, marital_status, number_of_dependants, allowed_on_call, fully_trained, allowed_special_shift)
values (2003, 1003, 'Test', 'User', 'Test@wiltech.com', null, null, null, null, 0, 0, 0, 0);
insert into person(id, user_Id, first_name, last_name, email, gender, phone_Number, date_of_birth, marital_status, number_of_dependants, allowed_on_call, fully_trained, allowed_special_shift)
values (2004, 1004, 'Athina', 'Theodorou', 'athina@wiltech.com', 'FEMALE', '+44 7540595289', '2007-04-11', 'DIVORCED', 1, 0, 0, 0);

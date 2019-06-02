
insert into person(name, lastName, age, birthplace, password) values('Jorge', 'Almagro', 22, 'Spain', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into person(name, lastName, age, birthplace, password) values('Antonio', 'Sanchez', 60, 'Spain', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into person(name, lastName, age, birthplace, password) values('Nacho', 'Lopez', 59, 'Spain', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into person(name, lastName, age, birthplace, password) values('Marina', 'Lopez', 22, 'Spain', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into person(name, lastName, age, birthplace, password) values('Jorge', 'Rivas', 60, 'Spain', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');
insert into person(name, lastName, age, birthplace, password) values('David', 'Bielsa', 23, 'Spain', '$2a$12$k4Zt1f1CYw34zkrU2P7Iz.IAyklW4yawVZtYVGqNJ2gkGj4lwsjze');

insert into authority(id, name) values(1, 'ROLE_ADMIN');
insert into authority(id, name) values(2, 'ROLE_USER');

insert into person_authorities(users_id, authorities_id) values(1, 1);
insert into person_authorities(users_id, authorities_id) values(2, 2);
insert into person_authorities(users_id, authorities_id) values(3, 2);
insert into person_authorities(users_id, authorities_id) values(4, 2);
insert into person_authorities(users_id, authorities_id) values(5, 2);
insert into person_authorities(users_id, authorities_id) values(6, 2);

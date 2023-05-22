create database healthcare_management;

create table user(
    id int not null primary key auto_increment,
    name varchar(50) not null ,
    surname varchar(50) not null ,
    email varchar(255) not null ,
    user_type enum('ADMIN','USER')
);


create table doctor(
    id int auto_increment not null ,
    specialty enum('FAMILY_PHYSICIANS','INTERNISTS','EMERGENCY_PHYSICIANS','PSYCHIATRISTS'),
    phone_number varchar(255) not null ,
    user_id int not null,
    primary key (id, user_id)
);


create table patient(
    id int auto_increment not null ,
    date_of_birthday date not null ,
    user_id int not null,
    primary key (id, user_id)
);


create table appointment(
    id int auto_increment not null ,
    date_time datetime not null ,
    doctor_id int not null,
    patient_id int not null,
    primary key (id, doctor_id,patient_id)
);
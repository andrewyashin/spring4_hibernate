
create table contact
(
	id int not null auto_increment
		primary key,
	first_name varchar(20) null,
	second_name varchar(20) null,
	birth_date date null
)
;

create table contact_tel_detail
(
	id int not null auto_increment
		primary key,
	contact_id int null,
	tel_type varchar(20) null,
	tel_number varchar(20) null,
	constraint contact_foreign
		foreign key (contact_id) references ch6.contact (id)
)
;

create index contact_foreign
	on contact_tel_detail (contact_id)
;



create table hobby
(
	hobby_id int not null auto_increment
		primary key,
	name varchar(20) null
)
;

create table contact_hobby_detail
(
	contact_id int null,
	hobby_id int null,
	constraint contact_hobby_detail_contact_id_fk
		foreign key (contact_id) references ch6.contact (id),
	constraint contact_hobby_detail_hobby_hobby_id_fk
		foreign key (hobby_id) references ch6.hobby (hobby_id)
)
;

create index contact_hobby_detail_hobby_hobby_id_fk
	on contact_hobby_detail (hobby_id)
;

create index contact_hobby_detail_contact_id_fk
	on contact_hobby_detail (contact_id)
;




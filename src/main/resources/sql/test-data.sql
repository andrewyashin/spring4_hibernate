insert into contact(first_name, second_name, birth_date) values
    ('Andrew', 'Yashin', '1997-04-03'),
    ('Sasha','Rudyka','1995-03-12'),
    ('John', 'Smith','1994-04-07');

insert into contact_tel_detail(contact_id, tel_type, tel_number) values
    (1, 'home','123-345'),
    (1, 'work','345-123'),
    (2, 'home','123-456'),
    (3, 'work','345-678');

insert into hobby(name) values
    ('Swimming'),
    ('Football'),
    ('Basketball');

insert into contact_hobby_detail(contact_id, hobby_id) values
    (1,2),
    (2,1),
    (3,3);


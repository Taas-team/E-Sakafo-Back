insert into category (label) values ('lisinopril');
insert into category (label) values ('Mycophenolic Acid');
insert into category (label) values ('Olanzapine');
insert into category (label) values ('Xylocaine');

insert into dish (name, price, category, order_number, quantity) values ('even-keeled', 30759, 3, 2, 12);
insert into dish (name, price, category, order_number, quantity) values ('workforce', 12857, 4, 1, 17);
insert into dish (name, price, category, order_number, quantity) values ('homogeneous', 39993, 3, 7, 21);
insert into dish (name, price, category, order_number, quantity) values ('leverage', 48658, 4, 8, 23);
insert into dish (name, price, category, order_number, quantity) values ('Versatile', 33826, 3, 6, 10);
insert into dish (name, price, category, order_number, quantity) values ('algorithm', 37938, 3, 11, 8);
insert into dish (name, price, category, order_number, quantity) values ('synergy', 21241, 4, 9, 8);
insert into dish (name, price, category, order_number, quantity) values ('multi-state', 16762, 1, 10, 12);
insert into dish (name, price, category, order_number, quantity) values ('Customizable', 44251, 1, 1, 25);
insert into dish (name, price, category, order_number, quantity) values ('eco-centric', 14594, 3, 7, 15);


insert into orders (ref, category, dish, quantity, client_name, contact, address, order_date, status) values ('REF-001', 'Temazepam', 10, 18, 'Frankowski', '5498995830', '96 Loftsgordon Court', '2022-02-07 16:29:22', 'DELIVERED');
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('24249 Northland Point', 'Orange Basil and Lime Antibacterial Foaming Hand Wash', 'Midlar', '6377096968', '2022-05-20 03:14:42', 26, 'REF-002', 'DELIVERED', 2);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('6 Dorton Place', 'all day pain relief', 'Abethell', '4534178328', '2022-01-24 02:37:15', 16, 'REF-003', 'IN_PROGRESS', 9);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('2508 Milwaukee Pass', 'Hog Hair', 'Lepard', '2500031349', '2022-06-08 11:36:29', 12, 'REF-004', 'IN_PROGRESS', 3);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('2682 Pennsylvania Hill', 'Tizanidine', 'Lenden', '5405188239', '2022-06-01 21:43:42', 16, 'REF-005', 'IN_PROGRESS', 2);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('462 Tennyson Terrace', 'Calcium Folic Acid Plus D Chewable', 'Saile', '4122070260', '2021-12-23 10:11:16', 19, 'REF-006', 'DELIVERED', 10);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('885 Towne Alley', 'Leader Stool Softener', 'Stenyng', '1087002672', '2022-01-31 16:05:36', 24, 'REF-007', 'IN_PROGRESS', 7);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('85903 Gerald Drive', 'Alprazolam', 'Stanners', '0773602410', '2021-11-09 23:31:57', 14, 'REF-008', 'IN_PROGRESS', 3);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('14473 Continental Terrace', 'citalopram hydrobromide', 'Hamill', '2041962585', '2021-10-05 16:03:36', 11, 'REF-009', 'IN_PROGRESS', 6);
insert into orders (address, category, client_name, contact, order_date, quantity, ref, status, dish) values ('99 Fordem Terrace', 'Long Last Makeup 05', 'Medford', '0452428254', '2022-01-23 18:33:40', 24, 'REF-010', 'IN_PROGRESS', 10);
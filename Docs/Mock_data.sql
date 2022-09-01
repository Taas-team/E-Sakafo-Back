insert into category (label) values ('Entrée');
insert into category (label) values ('Résistance');
insert into category (label) values ('Dessert');

insert into dish (name, price, category, order_number, quantity, url) values ('feuilletés', 15000, 1, 0, 10, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Recettes-de-feuilletes.jpg?alt=media&token=c29418ac-3c8e-4dcf-9900-61f5d5657dc5');
insert into dish (name, price, category, order_number, quantity, url) values ('Feuilleté de dinde', 20000, 1, 0, 10, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Feuillete-de-dinde.webp?alt=media&token=401848f2-dcd6-4da3-985a-5e7f3dd83fca');
insert into dish (name, price, category, order_number, quantity, url) values ('Samoussas', 10000, 1, 0, 10, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Samoussas.webp?alt=media&token=dccea294-24a8-4d05-a3e9-85be7f36d79f');
insert into dish (name, price, category, order_number, quantity, url) values ('Lentilles bolognaise', 50000, 2, 0, 5, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Recette%20Lentilles%20bolognaise%20au%20chorizo%20Cookeo.jpeg?alt=media&token=a1d24987-6bab-4003-bed7-98c772b06d37');
insert into dish (name, price, category, order_number, quantity, url) values ('Haricots Verts à la Carbonara', 30000, 2, 0, 5, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Haricots%20Verts%20%C3%A0%20la%20Carbonara%20-%20Plat%20et%20Recette.jpeg?alt=media&token=ac4bdecb-d95b-4a88-934e-1b02c2c9f075');
insert into dish (name, price, category, order_number, quantity, url) values ('POULET SAUTE CHASSEUR', 40000, 2, 0, 5, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/POULET%20SAUTE%20%20CHASSEUR%20-%20quelque%20part%20en%20Provence.jpeg?alt=media&token=b00aa4c0-4a53-4d1e-add9-4903ac4ea1b4');
insert into dish (name, price, category, order_number, quantity, url) values ('fraises et meringue', 10000, 3, 0, 20, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Cyril.jpeg?alt=media&token=1f7a0fcd-8cb2-4a2f-bf3f-ec667ec0baf0');
insert into dish (name, price, category, order_number, quantity, url) values ('Tarte Oranaise', 25000, 3, 0, 10, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Tarte%20Oranaise%20_%20Guy%20Demarle.jpeg?alt=media&token=d2a8848d-0019-4460-b29a-4f384b8e3ea4');
insert into dish (name, price, category, order_number, quantity, url) values ('Charlotte au citron', 10000, 3, 0, 5, 'https://firebasestorage.googleapis.com/v0/b/test-upload-firebase-4e8cf.appspot.com/o/Charlotte%20au%20citron%20meringu%C3%A9e%20-%20Recette%20facile.jpeg?alt=media&token=9d24421e-2e12-4c7e-a066-386cb6ff05d1');



insert into orders (address, category, client_name, contact, quantity, ref, status, dish, order_date) values ('Hei ivandry', 'Entrée', 'Franklin Hyriol', '0330025487', 2, 'REF-001', 'IN_PROGRESS', 1, '2022-09-1 12:00:12');
insert into orders (address, category, client_name, contact, quantity, ref, status, dish, order_date) values ('Ambohipo', 'Résistance', 'Michellah', '0344785695', 1, 'REF-002', 'DELIVERED', 4, '2022-09-2 13:00:12');

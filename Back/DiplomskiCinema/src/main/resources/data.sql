 

INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga )
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2a$04$8ECdISz13YpZ/F7kjxqRjec7.6gJJA9.VlTPUYzCO1J.Yu7bgGsXa','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2a$04$s8AMzvCXjHwqwEQPBfit0.UK8tVb9QvOBl8WZAHnBb3nOYzUfyf/K','Tamara','Milosavljevic','KORISNIK' );
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga )
              VALUES (3,'petar@maildrop.cc','petar','$2a$04$D7w8A/ak5pbqQ/tiTPxPeesEQjfiYZkpiL3o03pcG.2ZBe1d/996S','Petar','Jovic','KORISNIK' );



 INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (1, 'Ko to tamo peva', 1998, 'Dusan Kovacevic',190);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (2, 'Dvoje', 1988, 'Milan Maric',170);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (3, 'Varljivo Leto 68', 1986, 'Goran Paskalkjevic',170);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (4, 'Bure Baruta', 1998, 'Goran Paskalkjevic',120);
 

 INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (5, 'Juzni Vetar', 2020, 'Milos Avramovic',250);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (6, 'Mala nocna muzika', 1988, 'Dejan Zecevic',170);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (7, 'Karaula', 2000, 'Rajko Grlic',170);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (8, 'Montevideo', 2012, 'Dragan Bjelogrlic',120);
 INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (9, 'Mrtav Ladan', 1970, 'Rajko Grlic',170);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (10, 'Hajde da se volimo', 1998, 'Aleksandar Djordjevic',120);
INSERT INTO movies (id, film_name,  year,  director,  duration) VALUES (11, 'Besa', 1970, 'Srdjan Karanovic',120);



INSERT INTO Ganres (id, name_ganre) VALUES (1, 'naučna fantastika');
INSERT INTO Ganres (id, name_ganre) VALUES (2, 'akcija');
INSERT INTO Ganres (id, name_ganre) VALUES (3, 'komedija');
INSERT INTO Ganres (id, name_ganre) VALUES (4, 'horor');
INSERT INTO Ganres (id, name_ganre) VALUES (5, 'avantura');

INSERT INTO film_genre (movie_id, ganre_id) VALUES (1, 3);
INSERT INTO film_genre (movie_id, ganre_id) VALUES (3, 3);
INSERT INTO film_genre (movie_id, ganre_id) VALUES (3, 4);

INSERT INTO film_genre (movie_id, ganre_id) VALUES (2, 5);

INSERT INTO film_genre (movie_id, ganre_id) VALUES (4, 2);
INSERT INTO film_genre (movie_id, ganre_id) VALUES (4, 3);


INSERT INTO film_genre (movie_id, ganre_id) VALUES (5, 3);
INSERT INTO film_genre (movie_id, ganre_id) VALUES (5, 4);

INSERT INTO film_genre (movie_id, ganre_id) VALUES (6, 4);

INSERT INTO film_genre (movie_id, ganre_id) VALUES (7, 5);
INSERT INTO film_genre (movie_id, ganre_id) VALUES (8, 5);
INSERT INTO film_genre (movie_id, ganre_id) VALUES (9, 4);
INSERT INTO film_genre (movie_id, ganre_id) VALUES (10, 4);

INSERT INTO film_genre (movie_id, ganre_id) VALUES (11, 2);




insert into title (id, lenguage,movie_id ) values (1, 'madjarski', 1);
insert into title (id, lenguage,movie_id ) values (2, 'rumunski', 2);
insert into title (id, lenguage,movie_id ) values (3, 'engleski', 4);

insert into projection (id, date_and_time, movie_id, theater, price) values (1, '2020-06-22 20:00', 1, 2, 240 );
insert into projection (id, date_and_time, movie_id, theater, price) values (2, '2020-06-22 20:00', 2, 1, 240 );
insert into projection (id, date_and_time, movie_id, theater, price) values (3, '2021-06-22 20:00', 4, 2, 212 );

insert into ticket (id, price, reserved, seat_number, projection_id, user_id ) values (1,222, 'reserved', '12', 1,1);
insert into ticket (id, price, reserved, seat_number, projection_id, user_id ) values (2,250, 'reserved', '12', 2,2);
insert into ticket (id, price, reserved, seat_number, projection_id, user_id ) values (3,222, 'reserved', '12', 1,1);
 
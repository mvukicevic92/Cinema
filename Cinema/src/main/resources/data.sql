INSERT INTO user (id, username, password, date_of_registration, role) VALUES (1,"milan","$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6","2023-01-21",'ADMIN'); -- sifra je miroslav
INSERT INTO user (id, username, password, date_of_registration, role) VALUES (2,"petar","$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC","2023-01-31",'USER'); -- sifra je verovatno pera ili petar

INSERT INTO type_of_projection (id, name) VALUES (1, "2D");
INSERT INTO type_of_projection (id, name) VALUES (2, "3D");
INSERT INTO type_of_projection (id, name) VALUES (3, "4D");

INSERT INTO hall (id, name) VALUES (1, "Sala A");
INSERT INTO hall (id, name) VALUES (2, "Sala B");
INSERT INTO hall (id, name) VALUES (3, "Sala C");
INSERT INTO hall (id, name) VALUES (4, "Sala D");
INSERT INTO hall (id, name) VALUES (5, "Sala E");

INSERT INTO seat (serial_number, hall_id) VALUES (1, 1);
INSERT INTO seat (serial_number, hall_id) VALUES (2, 5);
INSERT INTO seat (serial_number, hall_id) VALUES (3, 3);
INSERT INTO seat (serial_number, hall_id) VALUES (4, 4);
INSERT INTO seat (serial_number, hall_id) VALUES (5, 2);

INSERT INTO movie (id, name, director, actors, genres, duration, distributor, country_of_origin, year_of_production, description) VALUES (1, "Oluja", "Milos Radunovic", "Jovo Maksic, Zlatan Vidovic, Marija Pikic", "Ratna drama", 156, "Telekom Srbija", "Srbija", 2023, "“Drama o ratu ispričana iz ugla običnog čoveka koga maestralno glumi Jovo Maksić u ulozi Ilije, čiji je jedini cilj da zaštiti i sačuva svoju porodicu, ognjište i selo u kom je odrastao sa drugovima koji su mu silom prilika postali saborci, a čije se životne priče prepliću.");
INSERT INTO movie (id, name, director, actors, genres, duration, distributor, country_of_origin, year_of_production, description) VALUES (2, "Avatar: Put vode", "James Cameron", "Sam Worthington, Zoe Saldana, Giovanni Ribisi", "Akcija, animirani, SF", 101, "20th Century Studios", "SAD", 2022, "Džejk Sali živi sa svojom porodicom na planeti Pandori. Kada se vrati poznati neprijatelj koji pokušava da ih uništi, Džejk i Nejtiri se udružuju sa vojskom Navi naroda kako bi zaštitili svoju planetu.");
INSERT INTO movie (id, name, director, actors, genres, duration, distributor, country_of_origin, year_of_production, description) VALUES (3, "Macak u cizmama: Poslednja zelja", "Joel Crawford", "Antonio Banderas, Salma Hajek", "Animirani", 93, "DreamWorks", "SAD", 2022, "Odvažni odmetnik, Mačak u čizmama otkriće da su njegova strast prema opasnosti i zanemarivanje bezbednosti došli po svoje. Mačak je iskoristio osam od devet života, ali usput se zabrojao. Vraćanje života odvešće ga u njegovu najveću potragu ikada.");
INSERT INTO movie (id, name, director, actors, genres, duration, distributor, country_of_origin, year_of_production, description) VALUES (4, "Duhovi proslosti", "Lori Evans Taylor", "	Melissa Barrera, Guy Burnet, Kristen Harris", "Horor", 90, "Project X", "SAD", 2022, "Trudnica na odmoru počinje da se pita da li je njena kuća ukleta ili je sve u njenoj glavi.");
INSERT INTO movie (id, name, director, actors, genres, duration, distributor, country_of_origin, year_of_production, description) VALUES (5, "Vavilon", "Damien Chazelle", "Brad Pitt, Margot Robbie, Diego Calva", "Drama", 189, "Paramount", "SAD", 2023, "Priča o ogromnoj ambiciji i nečuvenim ekscesima, prati uspone i padove više likova tokom ere neobuzdane dekadencije i izopačenosti koja je vladala u počecima Holivuda.");
INSERT INTO movie (id, name, director, actors, genres, duration, distributor, country_of_origin, year_of_production, description) VALUES (6, "Asteriks i Obeliks: Srednje kraljevstvo", "Guillaume Canet", "Guillaume Canet, Gilles Lellouche, Vincent Cassel", "Avantura, Porodicni", 111, "Tresor Films", "Francuska", 2022, "Uz pomoć Finaltesisa, feničanskog trgovca i njenog vernog telohranitelja Mai Vei, jedina ćerka carice, princeza Sas-Ji beži u Galiju da zatraži pomoć od dva hrabra ratnika Asteriksa i Obeliksa, koji su obdareni nadljudskom snagom zahvaljujući svom magičnom napitku.");
INSERT INTO movie (id, name, director, actors, genres, duration, distributor, country_of_origin, year_of_production, description) VALUES (7, "Kikoriki: Vec vidjeno", "Denis Chernov", "Nemanja Zivkovic, Predrag Damnjanovic, Braniislav Platisa", "Animirani", 85, "Petersburg Animation Studio", "Rusija", 2018, "Neodoljiva Kikoriki družina vraća nam se u novoj, nezaboravnoj porodičnoj avanturi “Kikoriki: Već viđeno”. Kraš odlučuje da svom najboljem prijatelju Bariju priredi nezaboravnu rođendansku zabavu.");

INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (1, 1, 1, 1, "2023-02-01 20:30:00", 350.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (2, 2, 2, 2, "2023-02-01 21:00:00", 420.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (3, 1, 3, 5, "2023-02-02 17:00:00", 380.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (4, 4, 3, 3, "2023-02-02 22:00:00", 400.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (5, 3, 1, 4, "2023-02-05 15:00:00", 330.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (6, 5, 1, 4, "2023-02-02 21:00:00", 450.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (7, 3, 3, 3, "2023-02-02 10:00:00", 350.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (8, 7, 2, 1, "2023-02-03 15:00:00", 420.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (9, 5, 2, 2, "2023-02-03 20:30:00", 390.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (10, 7, 2, 5, "2023-02-04 11:15:00", 380.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (11, 6, 3, 5, "2023-02-02 21:00:00", 330.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (12, 3, 1, 4, "2023-02-01 21:15:00", 450.00);
INSERT INTO projection (id, movie_id, type_of_projection_id, hall_id, date_time_of_display, ticket_price) VALUES (13, 4, 1, 3, "2023-02-05 21:30:00", 420.00);

INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (1, 1, 1, "2023-02-01");
INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (2, 3, 2, "2023-02-02");
INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (3, 10, 4, "2023-02-04");
INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (4, 13, 3, "2023-02-05");
INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (5, 9, 3, "2023-02-03");
INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (6, 5, 5, "2023-02-05");
INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (7, 8, 4, "2023-02-03");
INSERT INTO ticket (id, projection_id, seat_number, date_time_of_purchase) VALUES (8, 2, 1, "2023-02-01");
              






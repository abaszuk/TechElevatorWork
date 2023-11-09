-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
INSERT INTO genre(genre_name)
VALUES ('Sports');

INSERT INTO movie_genre(movie_id, genre_id)
VALUES ((SELECT movie.movie_id FROM movie WHERE movie.title = 'Coach Carter'), (SELECT genre.genre_id FROM genre WHERE genre_name = 'Sports'));

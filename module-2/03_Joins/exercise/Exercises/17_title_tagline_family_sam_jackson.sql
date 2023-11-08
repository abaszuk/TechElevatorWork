-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)
SELECT title, tagline
FROM movie
JOIN movie_actor ON movie_actor.movie_id = movie.movie_id
JOIN person ON movie_actor.actor_id = person.person_id
Join movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre. genre_id = genre.genre_id
WHERE person.person_name = 'Samuel L. Jackson' AND genre.genre_name = 'Family'
ORDER BY title

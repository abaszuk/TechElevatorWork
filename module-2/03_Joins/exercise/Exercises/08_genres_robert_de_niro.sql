-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)
SELECT DISTINCT genre_name
FROM person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.Genre_id
WHERE person_name = 'Robert De Niro' AND movie.release_date > '2010-01-01'
ORDER BY genre_name

-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.
SELECT DISTINCT genre_name
FROM person
JOIN movie_actor ON person.person_id = movie_actor.actor_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
JOIN movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre.genre_id = genre.Genre_id
WHERE person_name = 'Christopher Lloyd'
ORDER BY genre_name


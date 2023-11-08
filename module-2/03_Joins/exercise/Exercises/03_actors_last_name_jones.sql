-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. 
-- Order the results by the actor names (A-Z) and then by movie title (A-Z). 
-- (48 rows)
SELECT person.person_name, movie.title
from movie
JOIN movie_actor on movie_actor.movie_id = movie.movie_id
JOIN person on movie_actor.actor_id = person.person_id
WHERE person.person_name LIKE '% Jones'
ORDER BY person.person_name, movie.title


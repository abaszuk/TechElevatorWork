-- 18. The average length of movies in the "Science Fiction" genre. Name the column 'average_length'.
-- (1 row, expected result between 110-120)
SELECT AVG(length_minutes) as average_length
FROM movie
Join movie_genre ON movie.movie_id = movie_genre.movie_id
JOIN genre ON movie_genre. genre_id = genre.genre_id
WHERE genre_name = 'Science Fiction'


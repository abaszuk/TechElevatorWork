-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT *
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT census_region, state_name
FROM state
ORDER BY census_region DESC, state_name ASC ;

-- The biggest park by area
-- The columns we use in the order by are not required to be in the select statement
SELECT park_name
FROM park
ORDER BY area DESC;


-- LIMITING RESULTS

-- The 10 largest cities by populations
SELECT *
FROM city
ORDER BY population DESC
LIMIT 10;


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.

-- Two ways to get date
SELECT NOW();
SELECT CURRENT_DATE;
SELECT extract(year from CURRENT_DATE);
SELECT date_part('year', CURRENT_DATE);


SELECT (CURRENT_DATE - date_established)/365 AS years
FROM park
ORDER BY years DESC -- Because the order by runs after the select statement we can use any column aliases we create 
LIMIT 20;




-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
SELECT city_name || ' (' || state_abbreviation || ')' AS formatted_name
FROM city;

-- The all parks by name and date established.
SELECT park_name || ' - ' || date_established
FROM park;


-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || ': ' || state_name AS region_state
FROM state
WHERE census_region IN ('West','Midwest')
ORDER BY region_state ASC;



-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG(population)
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population)
FROM state
WHERE census_region IN ('West','South');

-- The number of cities with populations greater than 1 million
SELECT count(*) 
FROM city
WHERE population > 1000000;

-- The number of state nicknames.
SELECT count(*) -- using * in count will count each row
FROM state;

SELECT count(state_nickname) -- using a specific column name will count how many rows have a value in this specific column. Nulls will be ignored
FROM state;


-- The area of the smallest and largest parks.
SELECT MAX(area), MIN(area)
FROM park;


-- We can also use the distinct keyword inside out COUNT function
SELECT COUNT(city_name)
FROM city;

SELECT COUNT(DISTINCT city_name)
FROM city;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(city_name) AS num_cities --unless they are contained inside of an aggregate function, you cannot use columns in your select that are not also in your group by
FROM city
GROUP BY state_abbreviation
ORDER BY num_cities DESC;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) AS avg_park_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population)
FROM city
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) AS smallest_city
FROM city
GROUP BY state_abbreviation
ORDER BY smallest_city;


-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)
SELECT city_name, state_abbreviation
FROM city
ORDER BY city_name
OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY;

SELECT city_name, state_abbreviation
FROM city
ORDER BY city_name
OFFSET 10 ROWS FETCH NEXT 10 ROWS ONLY;

SELECT city_name, state_abbreviation
FROM city
ORDER BY city_name
OFFSET 20 ROWS FETCH NEXT 10 ROWS ONLY;


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT (
		 SELECT state_name FROM state WHERE state.state_abbreviation = city.state_abbreviation
       ), COUNT(city_name)
FROM city
GROUP BY state_abbreviation;

-- Include the names of the smallest and largest parks
--SELECT MIN(area), MAX(area)
--FROM park;

SELECT park_name, area
FROM park p,
     (
		 SELECT MIN(area) AS smallest, MAX(area) AS largest
		 FROM park
	 ) AS smallest_largest
WHERE p.area = smallest OR p.area = largest;	 

-- List the capital cities for the states in the Northeast census region.
SELECT state_abbreviation, (SELECT city_name FROM city WHERE city_id = state.capital)
FROM state
WHERE census_region = 'Northeast'
     ;


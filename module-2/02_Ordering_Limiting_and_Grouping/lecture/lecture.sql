-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
SELECT *
FROM state
ORDER BY population DESC;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
SELECT state_name, census_region
FROM state
ORDER BY census_region DESC, state_name;

-- The biggest park by area
--the columns we use in the order by are not required to be in the select statement
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
--two ways to get the date
SELECT now();
SELECT CURRENT_DATE;

SELECT (CURRENT_DATE - date_established)/365 as years
FROM park
ORDER BY years DESC
LIMIT 20;

-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
-- use || (pipes) as + 
SELECT city_name || '(' || state_abbreviation || ')'
FROM city;

-- The all parks by name and date established.
SELECT park_name || ' - ' || date_established
FROM park;

-- The census region and state name of all states in the West & Midwest sorted in ascending order.
SELECT census_region || '; ' || state_name as region_state
FROM state
WHERE census_region IN ('West','Midwest')
ORDER BY region_state;

-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
SELECT AVG (population)
FROM state;

-- Total population in the West and South census regions
SELECT SUM(population)
FROM state
WHERE census_region in ('West','South');

-- The number of cities with populations greater than 1 million
SELECT count(*) -- using * in count will count each row
FROM city
WHERe population > 100000;

-- The number of state nicknames.
SELECT *
FROM state;

SELECT count(state_nickname) -- using a specific column name will count how many rows haver a value. null will be ignored
FROM state;

-- The area of the smallest and largest parks.
SELECT MAX(area), MIN(area)
FROM park;



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
SELECT state_abbreviation, COUNT(city_name)
FROM city
GROUP BY state_abbreviation;

-- Determine the average park area depending upon whether parks allow camping or not.
SELECT has_camping, AVG(area) as avg_area
FROM park
GROUP BY has_camping;

-- Sum of the population of cities in each state ordered by state abbreviation.
SELECT state_abbreviation, SUM(population)
FROM state
GROUP BY state_abbreviation
ORDER BY state_abbreviation;

-- The smallest city population in each state ordered by city population.
SELECT state_abbreviation, MIN(population) as smallest_city
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


-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,
SELECT (
		SELECT state_name FROM state WHERE  state.state_abbreviation = city.state_abbreviation
), COUNT(city_name)
FROM city
GROUP BY state_abbreviation;

-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.


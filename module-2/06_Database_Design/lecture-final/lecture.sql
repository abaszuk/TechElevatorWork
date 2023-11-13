

BEGIN TRANSACTION;

-- Drop the tables in the opposite order that you create them
-- in order to avoid dependencies
DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS painting;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS customer;

-- Create tables first that do not have any dependencies (foreign keys)
CREATE TABLE customer(
	--just indicate column name, data type, and constraints if we have them
	customer_id SERIAL PRIMARY KEY,
	customer_name VARCHAR(100) NOT NULL, -- We can indicate this column should not be null
	customer_address VARCHAR(100) NOT NULL,
	customer_phone VARCHAR(15) NOT NULL UNIQUE -- we can indicate this column should only have unique values
   -- CONSTRAINT pk_customer_id PRIMARY KEY(customer_id)
);

CREATE TABLE artist(
	artist_id SERIAL PRIMARY KEY,
	artist_name VARCHAR(100) NOT NULL,
	artist_birthday DATE NOT NULL,
	artist_deathday DATE
);

CREATE TABLE painting(
	painting_id SERIAL PRIMARY KEY,
	artist_id INT REFERENCES artist(artist_id),
	owner_id INT REFERENCES customer(customer_id),
	painting_title VARCHAR(250) DEFAULT('Untitled') --If we want a default, use DEFAULT and put the value in parentheses
	--CONSTRAINT fk_painting_artist FOREIGN KEY(artist_id) REFERENCES artist(artist_id),
	--CONSTRAINT fk_painting_customer FOREIGN KEY (owner_id) REFERENCES customer(customer_id)
);

CREATE TABLE sales(
	painting_id INT NOT NULL REFERENCES painting(painting_id),
	owner_id INT REFERENCES customer(customer_id) NOT NULL,
	sale_amount money NOT NULL CHECK(sale_amount::numeric >= 0.00), --We can also add a check constraint
	purchase_date DATE NOT NULL DEFAULT(NOW()),
	CONSTRAINT pk_painting_owner PRIMARY KEY (painting_id, owner_id) -- if we have multiple columns combining to be a primary key, list them out in parentheses here
);


-- If you see the message "current transaction is aborted, commands ignored until end of transaction block"
-- then highlight and run only the commit, and it will rollback
COMMIT;
BEGIN TRANSACTION;

--drop the tables in the opposite order that you create them
--in order to avoid dependencies
DROP TABLE IF EXISTS sales;
DROP TABLE IF EXISTS painting;
DROP TABLE IF EXISTS artist;
DROP TABLE IF EXISTS customer;

--create tables first that do not have any dependencies (foreign keys)
CREATE TABLE customer (
	--just indicate the column name, data type, and potential constraints
	customer_id SERIAL PRIMARY KEY,
	customer_name VARCHAR(100) NOT NULL, -- we can indicate this column can not be null
	customer_address VARCHAR(100) NOT NULL,
	customer_phone VARCHAR(15) UNIQUE -- we can indicate this column can only have unique values 
	-- this is the hard way and does the same as PRIMARY KEY on line 5 (CONSTRAINT pk_customer_id PRIMARY KEY(customer_id))
);

CREATE TABLE artist (
	artist_id SERIAL PRIMARY KEY,
	artist_name VARCHAR(100) NOT NULL,
	artist_birthday DATE NOT NULL,
	artist_deathday DATE
);

CREATE TABLE painting(
	painting_id SERIAL PRIMARY KEY,
	artist_id INT REFERENCES artist(artist_id), -- easy way
	owner_id INT REFERENCES customer(customer_id),
	painting_title VARCHAR(250) DEFAULT('untitled') -- if we want a default value 
	-- hard way for foreign key (CONSTRAINT fk_painting_artist FOREIGN KEY(artist_id) REFERENCES artist(artist_id)),
	-- hard way CONSTRAINT fk_painting_customer FOREIGN KEY (owner_id) REFERENCES customer(customer_id)
);

CREATE TABLE sales(
	sales_id SERIAL PRIMARY KEY,
	painting_id INT REFERENCES painting(painting_id),
	owner_id INT REFERENCES customer (customer_id),
	sale_amount money NOT NULL CHECK(sale_amount::numeric >= 0), -- we can also add a check constraint
	purchase_data DATE NOT NULL DEFAULT (NOW())
);



COMMIT;
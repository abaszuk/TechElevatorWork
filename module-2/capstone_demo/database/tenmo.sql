BEGIN TRANSACTION;

DROP TABLE IF EXISTS  newsletter_subscribers, newsletter, account, tenmo_user;
DROP SEQUENCE IF EXISTS seq_user_id, seq_account_id, seq_transfer_id;



CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  START WITH 1001
  NO MAXVALUE;

CREATE TABLE tenmo_user (
	user_id int NOT NULL DEFAULT nextval('seq_user_id'),
	username varchar(50) UNIQUE NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(20),
	CONSTRAINT PK_tenmo_user PRIMARY KEY (user_id),
	CONSTRAINT UQ_username UNIQUE (username)
);

CREATE SEQUENCE seq_account_id
  INCREMENT BY 1
  START WITH 2001
  NO MAXVALUE;

CREATE TABLE account (
	account_id int NOT NULL DEFAULT nextval('seq_account_id'),
	user_id int NOT NULL,
	balance decimal(13, 2) NOT NULL,
	CONSTRAINT PK_account PRIMARY KEY (account_id),
	CONSTRAINT FK_account_tenmo_user FOREIGN KEY (user_id) REFERENCES tenmo_user (user_id)
);


CREATE TABLE newsletter(
	newsletter_id SERIAL PRIMARY KEY,
	newsletter_name VARCHAR(50) NOT NULL
);

CREATE TABLE newsletter_subscribers(
	newsletter_id INT REFERENCES newsletter(newsletter_id),
	user_id INT REFERENCES tenmo_user(user_id),
	CONSTRAINT pk_newsletter_subscribers PRIMARY KEY ( newsletter_id, user_id)
);


COMMIT;

START TRANSACTION;

DROP TABLE IF EXISTS member_events;
DROP TABLE IF EXISTS member_groups;
DROP TABLE IF EXISTS events;
DROP TABLE IF EXISTS interest_groups;
DROP TABLE IF EXISTS members;

CREATE TABLE members (
	member_number SERIAL PRIMARY KEY,
	last_name VARCHAR (50) NOT NULL,
	first_name VARCHAR(50) NOT NULL,
	email VARCHAR(50),
	phone VARCHAR(15),
	birthday DATE NOT NULL,
	has_reminder_email BOOLEAN
);

CREATE TABLE interest_groups(
	group_number SERIAL PRIMARY KEY,
	group_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE events (
	event_number SERIAL PRIMARY KEY,
	event_name VARCHAR(50),
	description VARCHAR(250),
	start_date DATE,
	start_time TIME,
	duration VARCHAR(50),
	group_running_event INT REFERENCES interest_groups(group_number)
);

CREATE TABLE member_groups (
	member_number INT PRIMARY KEY REFERENCES members(member_number),
	group_number INT REFERENCES interest_groups(group_number)
);

CREATE TABLE member_events (
	member_number INT REFERENCES members(member_number),
	event_number INT REFERENCES events(event_number)
);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Bridges','Jeff','dude@gmail.com','2165550123','1949-12-04',true);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Goodman','John','sobchak@gmail.com','2165551234','1952-06-20',false);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Buscemi','Steve','donny@gmail.com','2165552345','1957-12-13', true);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Moore','Julianna','maude@gmail.com','2165553456','1960-12-03', false);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Turturro','John','dajesus@gmail.com','2165554567','1957-02-28',true);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Elliot','Sam','cowboy@gmail.com','2165555678','1944-08-09', false);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Hoffman','Philip','brandt@gmail.com','2165556789','1967-07-23',true);

INSERT INTO members (last_name,first_name,email,phone,birthday,has_reminder_email)
VALUES ('Huddleston', 'David', 'bossman@gmail.com','2165557890','1930-09-17',false);

INSERT INTO interest_groups (group_name)
VALUES ('Bowling');

INSERT INTO interest_groups (group_name)
VALUES ('Art');

INSERT INTO interest_groups (group_name)
VALUES ('Business');

INSERT INTO events (event_name,description,start_date, start_time,duration,group_running_event)
VALUES ('Bowling Night', 'Bowling with the buddies','2024-03-06', '09:30pm','2.5 hours',(select group_number FROM interest_groups WHERE group_name = 'Bowling'));

INSERT INTO events (event_name,description,start_date,start_time,duration,group_running_event)
VALUES ('Art Night','Art with the homies','2023-11-16','10:00pm','2 Hours',(select group_number FROM interest_groups WHERE group_name = 'Art'));

INSERT INTO events (event_name,description,start_date,start_time,duration,group_running_event)
VALUES ('Business Night','Business with the bros','2023-11-20','07:30pm','1.5 hours',(select group_number FROM interest_groups WHERE group_name = 'Business'));

INSERT INTO events (event_name,description,start_date,start_time,duration,group_running_event)
VALUES ('Cowboy Night','Cowboying with the cowboys','2023-11-28','11:00pm','12 hours',(select group_number FROM interest_groups WHERE group_name = 'Business'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Bridges'),(SELECT group_number FROM interest_groups WHERE group_name = 'Bowling'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Goodman'),(SELECT group_number FROM interest_groups WHERE group_name = 'Bowling'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Buscemi'),(SELECT group_number FROM interest_groups WHERE group_name = 'Bowling'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Moore'),(SELECT group_number FROM interest_groups WHERE group_name = 'Art'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Turturro'),(SELECT group_number FROM interest_groups WHERE group_name = 'Art'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Elliot'),(SELECT group_number FROM interest_groups WHERE group_name = 'Art'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Hoffman'),(SELECT group_number FROM interest_groups WHERE group_name = 'Business'));

INSERT INTO member_groups (member_number,group_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Huddleston'),(SELECT group_number FROM interest_groups WHERE group_name = 'Business'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Huddleston'),(SELECT event_number FROM events WHERE event_name = 'Business Night'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Hoffman'),(SELECT event_number FROM events WHERE event_name = 'Business Night'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Moore'),(SELECT event_number FROM events WHERE event_name = 'Art Night'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Bridges'),(SELECT event_number FROM events WHERE event_name = 'Art Night'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Bridges'),(SELECT event_number FROM events WHERE event_name = 'Bowling Night'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Goodman'),(SELECT event_number FROM events WHERE event_name = 'Bowling Night'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Elliot'),(SELECT event_number FROM events WHERE event_name = 'Cowboy Night'));

INSERT INTO member_events(member_number,event_number)
VALUES ((SELECT member_number FROM members WHERE last_name = 'Buscemi'),(SELECT event_number FROM events WHERE event_name = 'Cowboy Night'));


COMMIT;
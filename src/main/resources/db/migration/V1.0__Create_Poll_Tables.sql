CREATE TABLE poll (
	poll_id INT auto_increment NOT NULL,
	poll_description varchar(200) NOT NULL,
	views INT NULL,
	PRIMARY KEY (poll_id)
);

CREATE TABLE options (
	option_id INT auto_increment NOT NULL,
	option_description varchar(200) NOT NULL,
	qty INT NULL,
	poll_id INT NOT NULL,	
	PRIMARY KEY (option_id),
	FOREIGN KEY (poll_id) REFERENCES poll(poll_id)
);
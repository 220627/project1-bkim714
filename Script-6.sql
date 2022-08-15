CREATE TABLE ers_user_roles (
	ers_user_role_id serial PRIMARY KEY,
	user_role varchar(10)
);

INSERT INTO ers_user_roles (user_role)
VALUES ('Manager'), ('Employee');

SELECT * FROM ers_user_roles;

DROP TABLE ers_user_roles;

--figure out cascade delete because it won't let me delete then continue inserting and then create insert (without value) for reimb table

CREATE TABLE ers_reimbursement_type (
	reimb_type_id serial PRIMARY KEY,
	reimb_type varchar(25)
);

INSERT INTO ers_reimbursement_type (reimb_type)
VALUES ('General Principle'), ('Boss Hog Outlaw');

SELECT * FROM ers_reimbursement_type;

DROP TABLE ers_reimbursement_type CASCADE;




CREATE TABLE ers_reimbursement_status (
	reimb_status_id serial PRIMARY KEY,
	reimb_status varchar(10)
);

INSERT INTO ers_reimbursement_status (reimb_status)
VALUES ('Accepted'), ('Denied');

SELECT * FROM ers_reimbursement_status;


DROP TABLE ers_reimbursement_status;




CREATE TABLE ers_users (
	ers_users_id serial PRIMARY KEY,
	ers_username varchar(50),
	ers_password varchar(50),
	user_first_name varchar(100),
	user_last_name varchar(100),
	user_email varchar(150),
	user_role_id int,
	CONSTRAINT user_roles_fk FOREIGN KEY (user_role_id) REFERENCES ers_user_roles(ers_user_role_id)
);

INSERT INTO ers_users (ers_username, ers_password, user_first_name, user_last_name, user_email, user_role_id)
VALUES ('BK', 'bkpassword', 'Bryan', 'Kim','BK4U@gmail.com', 1),
	   ('Bon', 'benpassword', 'Ben', 'P', 'Bon@gmail.com', 2);
	  
SELECT * FROM ers_users;


DROP TABLE ers_users;




CREATE TABLE ers_reimbursement (
	reimb_id serial PRIMARY KEY,
	reimb_amount int,
	reimb_submitted timestamp,
	reimb_author int,
	reimb_resolver int,
	reimb_status_id int,
	reimb_type_id int,
	CONSTRAINT ers_users_fk_auth FOREIGN KEY (reimb_author) REFERENCES ers_users(ers_users_id),
	CONSTRAINT ers_users_fk_reslvr FOREIGN KEY (reimb_resolver) REFERENCES ers_users(ers_users_id),
	CONSTRAINT ers_reimbursement_status_fk FOREIGN KEY (reimb_status_id) REFERENCES ers_reimbursement_status(reimb_status_id),
	CONSTRAINT ers_reimbursement_type_fk FOREIGN KEY (reimb_type_id) REFERENCES ers_reimbursement_type(reimb_type_id)
);

INSERT INTO ers_reimbursement (reimb_amount, reimb_submitted, reimb_author, reimb_resolver, reimb_status_id, reimb_type_id)
VALUES 

SELECT * FROM ers_reimbursement;


DROP TABLE ers_reimbursement;


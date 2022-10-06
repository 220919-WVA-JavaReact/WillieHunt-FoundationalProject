CREATE TABLE employee (
employee_id serial PRIMARY KEY,
"first" varchar(50),
"last" varchar(50),
username varchar(50) UNIQUE,
"password" varchar(50)
);

CREATE TABLE Reimburseticket (
Ticket_num serial PRIMARY KEY,
amount int,
description TEXT,
employee_id int REFERENCES employee
);


INSERT INTO employee ("first", "last", username, "password")
VALUES 
('willie', 'hunt', 'whunt12', 'passnone12'),
('john', 'snow', 'jsnowfall', 'winterishere'),
('timmy', 'turner', 'tturner', 'gotsomefairies');


INSERT INTO reimburseticket (amount, description, employee_id)
VALUES 
(500, 'Rent assisstance', 1),
(200, 'Netflix subscribtion', 2),
(50, 'Food', 3);


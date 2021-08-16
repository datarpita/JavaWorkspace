use teacherstudentconnect;

desc user;
desc bike;
desc student;
desc activity;
desc students_activities;

insert into user(username, password) values ('arpita','arpita');
insert into user(username, password) values ('teacher','teacher');

insert into bike (model, name) values ('Royal Enfield','Classic 350'); 
insert into bike (model, name) values ('Yamaha','YZF R15'); 
insert into bike (model, name) values ('Hero Splendor','Plus 100'); 

insert into activity(activity_name) values ('swimming');
insert into activity(activity_name) values ('basketball');
insert into activity(activity_name) values ('volleyball');
insert into activity(activity_name) values ('gymnastics');
insert into activity(activity_name) values ('soccer');
insert into activity(activity_name) values ('aerobics');
insert into activity(activity_name) values ('dancing');

INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (1,'male',3.6,2,'Adam',23,1,'2019-04-21');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (2,'female',3.8,2,'Jenny',24,3,'2019-07-11');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (3,'female',4,3,'Emily',5,2,'2019-04-21');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (4,'male',3.9,3,'Dave',15,1,'2019-07-11');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (5,'female',3.5,4,'Sophia',12,NULL,'2019-07-11');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (6,'male',3.9,4,'James',6,1,'2019-04-21');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (7,'male',4,4,'Tom',10,NULL,'2019-07-11');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (8,'male',3.6,4,'Dick',3,3,'2019-07-11');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (9,'female',2.9,2,'Harriet',18,3,'2019-04-21');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (10,'male',2.1,3,'Ron',8,2,'2019-04-21');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (11,'female',3.8,3,'Goldie',11,3,'2019-07-11');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (12,'male',2.1,3,'Bosco',18,1,'2020-06-04');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (13,'male',3.6,2,'Dick',3,1,'2021-07-18');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (14,'female',3.6,4,'arpita',3,1,'2021-07-11');
INSERT INTO student (student_id,gender,gpa,grade_level,name,note_books,bike_bike_id,admissiondate) VALUES (15,'male',3.3,4,'Wendy',12,3,'2021-07-13');

INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (1,1);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (1,2);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (1,3);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (2,1);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (2,4);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (2,5);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (3,1);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (3,3);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (3,6);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (4,4);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (4,6);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (4,7);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (5,2);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (5,4);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (5,5);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (6,1);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (6,3);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (7,2);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (7,5);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (7,7);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (8,2);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (8,4);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (9,4);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (9,6);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (9,7);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (10,3);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (10,4);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (10,6);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (11,3);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (11,6);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (11,7);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (12,1);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (12,3);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (13,2);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (14,2);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (14,4);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (15,1);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (15,2);
INSERT INTO students_activities (students_student_id,activities_activity_id) VALUES (15,3);

commit;

select * from user;
select * from student;
select * from bike;
select * from activity;
select * from students_activities;

update user set doj='2021-07-11', location='Kolkata', name='Arpita Datta' where id=1;
update user set doj='2021-07-18', location='New Delhi', name='Tom Dicky' where id=2;
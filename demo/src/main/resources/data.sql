INSERT INTO COURSE(id,name,created_date,last_update_date) 
VALUES(10001,'Spring JPA Course',sysdate(),sysdate());
INSERT INTO COURSE(id,name,created_date,last_update_date) 
VALUES(10002,'Spring Boot 50 steps',sysdate(),sysdate());
INSERT INTO COURSE(id,name,created_date,last_update_date) 
VALUES(10003,'Spring MVC 100 steps',sysdate(),sysdate());

INSERT INTO passport(id,number)
VALUES(40001,'E123456');
INSERT INTO passport(id,number)
VALUES(40002,'B123456');
INSERT INTO passport(id,number)
VALUES(40003,'F123456');

INSERT INTO student(id,name,passport_id)
VALUES(20001,'Pig',40001);
INSERT INTO student(id,name,passport_id)
VALUES(20002,'Hog',40002);
INSERT INTO student(id,name,passport_id)
VALUES(20003,'Boar',40003);



INSERT INTO review(id,rating,description,course_id)
VALUES(50001,'5','Great Course',10001);
INSERT INTO review(id,rating,description,course_id)
VALUES(50002,'4','Wonderful Course',10001);
INSERT INTO review(id,rating,description,course_id)
VALUES(50003,'5','Awesome Course',10003);

INSERT INTO student_course(student_id,course_id)
VALUES(20001,10001);
INSERT INTO student_course(student_id,course_id)
VALUES(20002,10001);
INSERT INTO student_course(student_id,course_id)
VALUES(20003,10001);
INSERT INTO student_course(student_id,course_id)
VALUES(20001,10003);

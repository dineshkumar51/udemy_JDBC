USE udemy_updated;

show tables;

CREATE TABLE user(
id SMALLINT UNSIGNED AUTO_INCREMENT,
username VARCHAR(20) NOT NULL ,
password VARCHAR(8) NOT NULL ,
full_name VARCHAR(20) NOT NULL ,
user_type VARCHAR(1) NOT NULL ,
created_date DATETIME NOT NULL ,
CONSTRAINT learner_pk PRIMARY KEY (id)
);

ALTER TABLE user MODIFY user_type VARCHAR(1) NOT NULL;

CREATE TABLE category(
    category_id TINYINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL ,
    CONSTRAINT category_pk PRIMARY KEY (category_id)
);

CREATE TABLE topic(
    topic_id TINYINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL ,
    category_id TINYINT UNSIGNED,
    CONSTRAINT topic_pk PRIMARY KEY (topic_id),
    CONSTRAINT topic_category_fk FOREIGN KEY (category_id)
    REFERENCES category(category_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);


CREATE TABLE course(
    course_id SMALLINT UNSIGNED AUTO_INCREMENT,
    name VARCHAR(150) NOT NULL,
    instructor_id SMALLINT UNSIGNED,
    topic_id TINYINT UNSIGNED,
    rating FLOAT(2,1) DEFAULT 0.0,
    no_of_ratings SMALLINT UNSIGNED DEFAULT 0,
    no_of_enrolled_students SMALLINT UNSIGNED DEFAULT 0,

    CONSTRAINT course_pk PRIMARY KEY (course_id),

    CONSTRAINT course_instructor_fk FOREIGN KEY (instructor_id)
    REFERENCES user(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT course_topic_fk FOREIGN KEY (topic_id)
    REFERENCES topic(topic_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE enrollments(
    learner_id SMALLINT UNSIGNED,
    course_id SMALLINT UNSIGNED,
    enrolled_date DATETIME NOT NULL,

    CONSTRAINT enrollment_learner_fk FOREIGN KEY (learner_id)
    REFERENCES user(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT enrollment_course_fk FOREIGN KEY (course_id)
    REFERENCES course(course_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT enrollments_pk PRIMARY KEY (learner_id,course_id)
);

CREATE TABLE wishlist(
    learner_id SMALLINT UNSIGNED,
    course_id SMALLINT UNSIGNED,

    CONSTRAINT wishlist_learner_fk FOREIGN KEY (learner_id)
    REFERENCES user(id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT wishlist_course_fk FOREIGN KEY (course_id)
    REFERENCES course(course_id)
    ON DELETE CASCADE
    ON UPDATE CASCADE,

    CONSTRAINT wishlist_pk PRIMARY KEY (learner_id,course_id)
);

INSERT INTO user(username, password, full_name, user_type, created_date) VALUES ('kumar@123','kumar515','kumar','I',CURRENT_TIMESTAMP());
INSERT INTO user(username, password, full_name, user_type, created_date) VALUES ('dinesh@123','qwer5151','dinesh','I',CURRENT_TIMESTAMP());
INSERT INTO user(username, password, full_name, user_type, created_date) VALUES ('stephane@123','step5151','Stephane Maarek','I',CURRENT_TIMESTAMP());
INSERT INTO user(username, password, full_name, user_type, created_date) VALUES ('destin@123','dest5151','Destin Learning','I',CURRENT_TIMESTAMP());

INSERT INTO user(username, password, full_name, user_type, created_date) VALUES ('dinesh@1234','dinesh51','Dineshkumar','L',CURRENT_TIMESTAMP());

SELECT * FROM user;


INSERT INTO category(name) VALUES ('Cloud Computing');
INSERT INTO category(name) VALUES ('Data Science');
INSERT INTO category(name) VALUES ('Design');
INSERT INTO category(name) VALUES ('Development');
INSERT INTO category(name) VALUES ('IT Operations');
INSERT INTO category(name) VALUES ('Leadership and Management');
INSERT INTO category(name) VALUES ('Marketing');
INSERT INTO category(name) VALUES ('Personal Development');
INSERT INTO category(name) VALUES ('Project Management');
INSERT INTO category(name) VALUES ('Workplace and Human Resource');

INSERT INTO topic(name,category_id) VALUES ('Cloud Certification',1);
INSERT INTO topic(name,category_id) VALUES ('Cloud Development',1);
INSERT INTO topic(name,category_id) VALUES ('Cloud Fundamentals',1);

INSERT INTO topic(name,category_id) VALUES ('Analytics',2);
INSERT INTO topic(name,category_id) VALUES ('Big Data',2);
INSERT INTO topic(name,category_id) VALUES ('Machine Learning',2);
INSERT INTO topic(name,category_id) VALUES ('Deep Learning',2);
INSERT INTO topic(name,category_id) VALUES ('Data Visualization',2);

INSERT INTO topic(name,category_id) VALUES ('Web Design',3);
INSERT INTO topic(name,category_id) VALUES ('Graphic Design',3);
INSERT INTO topic(name,category_id) VALUES ('Game Design',3);
INSERT INTO topic(name,category_id) VALUES ('Design Thinking',3);
INSERT INTO topic(name,category_id) VALUES ('3D and Animation',3);

INSERT INTO topic(name,category_id) VALUES ('Web Development',4);
INSERT INTO topic(name,category_id) VALUES ('Mobile Development',4);
INSERT INTO topic(name,category_id) VALUES ('Game Development',4);
INSERT INTO topic(name,category_id) VALUES ('Database Design and Development',4);
INSERT INTO topic(name,category_id) VALUES ('Software Testing',4);

INSERT INTO course(name, instructor_id, topic_id) VALUES ('Ultimate AWS certified Solutions Architect Associate 2021',3,1);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('Ultimate AWS certified SysOps Administrator Associate 2021',3,1);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('Ultimate AWS certified Solutions Architect Associate 2021',3,1);

INSERT INTO course(name, instructor_id, topic_id) VALUES ('Machine Learning A-Z',1,6);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('Deep Learning A-Z',1,7);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('The Ultimate Hands-On Hadoop',1,5);

INSERT INTO course(name, instructor_id, topic_id) VALUES ('The Web Developer Bootcamp 2021',2,14);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('The Complete JavaScript Course',2,14);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('Angular - The Complete Guide',2,9);

INSERT INTO course(name, instructor_id, topic_id) VALUES ('Graphic Design Masterclass',4,10);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('Illustrator 2021 Masterclass',4,10);
INSERT INTO course(name, instructor_id, topic_id) VALUES ('Ultimate Adobe Photoshop',4,10);




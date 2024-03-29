CREATE SEQUENCE PERSON_SEQ;

CREATE TABLE PERSON (
    ID BIGINT NOT NULL,
    UUID VARCHAR(256) NOT NULL,
    FIRST_NAME VARCHAR(256) NOT NULL,
    LAST_NAME VARCHAR(256) NOT NULL
);

ALTER TABLE PERSON ADD PRIMARY KEY (ID);
ALTER TABLE PERSON ADD CONSTRAINT PERSON_UUID_UK UNIQUE (UUID);

CREATE TABLE PERSON_DETAIL (
    PERSON_ID BIGINT NOT NULL,
    BIRTHDAY DATE NOT NULL
);

ALTER TABLE PERSON_DETAIL ADD PRIMARY KEY (PERSON_ID);
ALTER TABLE PERSON_DETAIL ADD FOREIGN KEY (PERSON_ID) REFERENCES PERSON(ID);

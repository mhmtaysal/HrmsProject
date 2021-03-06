-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.activation_codes
(
    id integer NOT NULL,
    user_id integer NOT NULL,
    activation_code text NOT NULL,
    is_confirmed boolean NOT NULL,
    confirm_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_experiences
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    company_name character varying(255) NOT NULL,
    start_date timestamp with time zone NOT NULL,
    leave_date timestamp with time zone,
    candidate_id integer NOT NULL,
    position_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_images
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    uploaded_date timestamp without time zone,
    url character varying(255) NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_languages
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    language_id integer NOT NULL,
    candidate_id integer NOT NULL,
    level smallint NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_links
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    link_id integer NOT NULL,
    candidate_id integer NOT NULL,
    link character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_schools
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    candidate_id integer,
    started_date date,
    ended_date date,
    created_date date,
    is_active boolean,
    department_id integer NOT NULL,
    university_id integer NOT NULL,
    faculty_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidate_skills
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    skill_id integer NOT NULL,
    candidate_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.candidates
(
    candidatesid integer NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    nationalidentity character varying(11) NOT NULL,
    dateofbirth timestamp without time zone,
    PRIMARY KEY (candidatesid)
);

CREATE TABLE public.city
(
    id integer NOT NULL,
    city_name character varying(255),
    PRIMARY KEY (id)
);

CREATE TABLE public.department
(
    id integer NOT NULL,
    university_id integer NOT NULL,
    name character varying(255),
    faculity_id integer,
    faculty_id integer,
    PRIMARY KEY (id)
);

CREATE TABLE public.employees
(
    employeesid integer NOT NULL,
    firstname character varying(50) NOT NULL,
    lastname character varying(50) NOT NULL,
    PRIMARY KEY (employeesid)
);

CREATE TABLE public.employers
(
    employersid integer NOT NULL,
    companyname character varying(50) NOT NULL,
    webaddress character varying(100) NOT NULL,
    phonenumber character varying(13) NOT NULL,
    PRIMARY KEY (employersid)
);

CREATE TABLE public.employers_activation_by_employees
(
    id integer NOT NULL,
    employers_id integer NOT NULL,
    employees_id integer NOT NULL,
    is_confirmed boolean NOT NULL,
    confirmed_date date NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.faculties
(
    id integer NOT NULL,
    name character varying(255) NOT NULL,
    university_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_advertisements
(
    id integer NOT NULL,
    application_deadline timestamp without time zone,
    is_active boolean,
    job_detail character varying(255),
    job_list_date timestamp without time zone,
    max_salary double precision,
    min_salary double precision,
    position_quota integer,
    city_id integer NOT NULL,
    employer_id integer NOT NULL,
    job_title_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.job_positions
(
    id integer NOT NULL,
    title character varying(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.languages
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.link_types
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    type character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.skills
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.universities
(
    id integer NOT NULL GENERATED BY DEFAULT AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    name character varying(255) NOT NULL,
    city_id integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE public.users
(
    id integer NOT NULL,
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    insert_date timestamp with time zone NOT NULL,
    PRIMARY KEY (id)
);

ALTER TABLE public.activation_codes
    ADD FOREIGN KEY (user_id)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.candidate_experiences
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (candidatesid)
    NOT VALID;


ALTER TABLE public.candidate_experiences
    ADD FOREIGN KEY (position_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.candidate_images
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (candidatesid)
    NOT VALID;


ALTER TABLE public.candidate_languages
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (candidatesid)
    NOT VALID;


ALTER TABLE public.candidate_languages
    ADD FOREIGN KEY (language_id)
    REFERENCES public.languages (id)
    NOT VALID;


ALTER TABLE public.candidate_links
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (candidatesid)
    NOT VALID;


ALTER TABLE public.candidate_links
    ADD FOREIGN KEY (link_id)
    REFERENCES public.link_types (id)
    NOT VALID;


ALTER TABLE public.candidate_schools
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (candidatesid)
    NOT VALID;


ALTER TABLE public.candidate_schools
    ADD FOREIGN KEY (department_id)
    REFERENCES public.department (id)
    NOT VALID;


ALTER TABLE public.candidate_schools
    ADD FOREIGN KEY (faculty_id)
    REFERENCES public.faculties (id)
    NOT VALID;


ALTER TABLE public.candidate_schools
    ADD FOREIGN KEY (university_id)
    REFERENCES public.universities (id)
    NOT VALID;


ALTER TABLE public.candidate_skills
    ADD FOREIGN KEY (candidate_id)
    REFERENCES public.candidates (candidatesid)
    NOT VALID;


ALTER TABLE public.candidate_skills
    ADD FOREIGN KEY (skill_id)
    REFERENCES public.skills (id)
    NOT VALID;


ALTER TABLE public.candidates
    ADD FOREIGN KEY (candidatesid)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.department
    ADD FOREIGN KEY (university_id)
    REFERENCES public.universities (id)
    NOT VALID;


ALTER TABLE public.department
    ADD FOREIGN KEY (faculty_id)
    REFERENCES public.faculties (id)
    NOT VALID;


ALTER TABLE public.employees
    ADD FOREIGN KEY (employeesid)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers
    ADD FOREIGN KEY (employersid)
    REFERENCES public.users (id)
    NOT VALID;


ALTER TABLE public.employers_activation_by_employees
    ADD FOREIGN KEY (employees_id)
    REFERENCES public.employees (employeesid)
    NOT VALID;


ALTER TABLE public.employers_activation_by_employees
    ADD FOREIGN KEY (employers_id)
    REFERENCES public.employers (employersid)
    NOT VALID;


ALTER TABLE public.faculties
    ADD FOREIGN KEY (university_id)
    REFERENCES public.universities (id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (employersid)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (job_title_id)
    REFERENCES public.job_positions (id)
    NOT VALID;


ALTER TABLE public.job_advertisements
    ADD FOREIGN KEY (city_id)
    REFERENCES public.city (id)
    NOT VALID;


ALTER TABLE public.universities
    ADD FOREIGN KEY (city_id)
    REFERENCES public.city (id)
    NOT VALID;

END;
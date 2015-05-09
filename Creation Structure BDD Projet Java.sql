--
-- PostgreSQL database dump
--

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

--
-- Name: _typep; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE _typep AS ENUM (
    'gpu',
    'cpu',
    'autre'
);


ALTER TYPE _typep OWNER TO postgres;

--
-- Name: _typer; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE _typer AS ENUM (
    'Ethernet',
    'Token Bus',
    'Token Ring',
    'Wifi 2.4',
    'Bluetooth',
    'ProfiBUS',
    'CAN',
    'ZigBee',
    'Wifi 5.0'
);


ALTER TYPE _typer OWNER TO postgres;

--
-- Name: typem; Type: TYPE; Schema: public; Owner: postgres
--

CREATE TYPE typem AS ENUM (
    'Tablette',
    'Ordinateur fixe',
    'PDA',
    'SmartPhone',
    'Ordinateur portable',
    'Routeur',
    'Commutateur',
    'Pont',
    'Autre'
);


ALTER TYPE typem OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: batiment; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE batiment (
    nom character(50) NOT NULL,
    localisation character(50) NOT NULL,
    description character varying(4000)
);


ALTER TABLE batiment OWNER TO postgres;

--
-- Name: estconnectee; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE estconnectee (
    machine1 bigint NOT NULL,
    machine2 bigint NOT NULL
);


ALTER TABLE estconnectee OWNER TO postgres;

--
-- Name: interfacereseau; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE interfacereseau (
    mac character(17) NOT NULL,
    ipv4 character(15),
    ipv6 character varying(39),
    typer _typer NOT NULL,
    etat boolean NOT NULL,
    machine bigint
);


ALTER TABLE interfacereseau OWNER TO postgres;

--
-- Name: machine; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE machine (
    id bigint NOT NULL,
    nom character(50),
    marque character(50),
    modele character(32),
    os character(150) NOT NULL,
    firmware character(150) NOT NULL,
    typem typem[] NOT NULL,
    etat boolean NOT NULL,
    salle smallint
);


ALTER TABLE machine OWNER TO postgres;

--
-- Name: machine_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE machine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE machine_id_seq OWNER TO postgres;

--
-- Name: machine_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE machine_id_seq OWNED BY machine.id;


--
-- Name: salle; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE salle (
    id smallint NOT NULL,
    numero character(10) NOT NULL,
    etage smallint NOT NULL,
    nom character(50),
    batiment character(50) NOT NULL
);


ALTER TABLE salle OWNER TO postgres;

--
-- Name: salle_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE salle_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE salle_id_seq OWNER TO postgres;

--
-- Name: salle_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE salle_id_seq OWNED BY salle.id;


--
-- Name: uniteprocesseur; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE uniteprocesseur (
    id bigint NOT NULL,
    type _typep NOT NULL,
    fabriquant character(50),
    nom character(50) NOT NULL,
    machine bigint
);


ALTER TABLE uniteprocesseur OWNER TO postgres;

--
-- Name: uniteprocesseur_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE uniteprocesseur_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE uniteprocesseur_id_seq OWNER TO postgres;

--
-- Name: uniteprocesseur_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE uniteprocesseur_id_seq OWNED BY uniteprocesseur.id;


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY machine ALTER COLUMN id SET DEFAULT nextval('machine_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salle ALTER COLUMN id SET DEFAULT nextval('salle_id_seq'::regclass);


--
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY uniteprocesseur ALTER COLUMN id SET DEFAULT nextval('uniteprocesseur_id_seq'::regclass);


--
-- Name: pk_connectee; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY estconnectee
    ADD CONSTRAINT pk_connectee PRIMARY KEY (machine1, machine2);


--
-- Name: pk_machine; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY machine
    ADD CONSTRAINT pk_machine PRIMARY KEY (id);


--
-- Name: pk_nom; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY batiment
    ADD CONSTRAINT pk_nom PRIMARY KEY (nom);


--
-- Name: pk_reseau; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY interfacereseau
    ADD CONSTRAINT pk_reseau PRIMARY KEY (mac);


--
-- Name: pk_salle; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY salle
    ADD CONSTRAINT pk_salle PRIMARY KEY (id);


--
-- Name: pk_unitep; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY uniteprocesseur
    ADD CONSTRAINT pk_unitep PRIMARY KEY (id);


--
-- Name: fk_batiment; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY salle
    ADD CONSTRAINT fk_batiment FOREIGN KEY (batiment) REFERENCES batiment(nom);


--
-- Name: fk_machine; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY uniteprocesseur
    ADD CONSTRAINT fk_machine FOREIGN KEY (machine) REFERENCES machine(id);


--
-- Name: fk_machine; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY interfacereseau
    ADD CONSTRAINT fk_machine FOREIGN KEY (machine) REFERENCES machine(id);


--
-- Name: fk_machine1; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estconnectee
    ADD CONSTRAINT fk_machine1 FOREIGN KEY (machine1) REFERENCES machine(id);


--
-- Name: fk_machine2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY estconnectee
    ADD CONSTRAINT fk_machine2 FOREIGN KEY (machine2) REFERENCES machine(id);


--
-- Name: fk_salle; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY machine
    ADD CONSTRAINT fk_salle FOREIGN KEY (salle) REFERENCES salle(id);


--
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- PostgreSQL database dump complete
--


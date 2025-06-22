--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

-- Started on 2025-06-22 16:50:45

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 220 (class 1259 OID 41431)
-- Name: fornecedores; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fornecedores (
    idforn integer NOT NULL,
    nome character varying(50) NOT NULL,
    cnpj character(14),
    razaosocial character varying(100) NOT NULL
);


ALTER TABLE public.fornecedores OWNER TO postgres;

--
-- TOC entry 224 (class 1259 OID 41522)
-- Name: fornecimentos; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.fornecimentos (
    idfcm integer NOT NULL,
    quantidade integer NOT NULL,
    datahora date NOT NULL,
    idforn integer NOT NULL,
    idmp integer NOT NULL
);


ALTER TABLE public.fornecimentos OWNER TO postgres;

--
-- TOC entry 222 (class 1259 OID 41501)
-- Name: idfcm; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.idfcm
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.idfcm OWNER TO postgres;

--
-- TOC entry 219 (class 1259 OID 41430)
-- Name: idforn; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.idforn
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.idforn OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 41357)
-- Name: idimp; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.idimp
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.idimp OWNER TO postgres;

--
-- TOC entry 221 (class 1259 OID 41500)
-- Name: idmp; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.idmp
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.idmp OWNER TO postgres;

--
-- TOC entry 218 (class 1259 OID 41369)
-- Name: impressoras; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.impressoras (
    idimp integer NOT NULL,
    nome character varying(50) NOT NULL,
    nvlciano integer NOT NULL,
    nvlmagenta integer NOT NULL,
    nvlamarelo integer NOT NULL,
    nvlpreto integer NOT NULL
);


ALTER TABLE public.impressoras OWNER TO postgres;

--
-- TOC entry 223 (class 1259 OID 41517)
-- Name: materiasprimas; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.materiasprimas (
    idmp integer NOT NULL,
    nome character varying(50) NOT NULL,
    quantidade integer NOT NULL,
    volume integer,
    vol boolean
);


ALTER TABLE public.materiasprimas OWNER TO postgres;

--
-- TOC entry 4917 (class 0 OID 41431)
-- Dependencies: 220
-- Data for Name: fornecedores; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fornecedores VALUES (1, 'Folhas folhudas', '12345678901234', 'Folhinhas bonitas');


--
-- TOC entry 4921 (class 0 OID 41522)
-- Dependencies: 224
-- Data for Name: fornecimentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fornecimentos VALUES (4, 10, '2025-06-22', 1, 1);


--
-- TOC entry 4915 (class 0 OID 41369)
-- Dependencies: 218
-- Data for Name: impressoras; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4920 (class 0 OID 41517)
-- Dependencies: 223
-- Data for Name: materiasprimas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.materiasprimas VALUES (1, 'Folha A4', 50, -1, false);


--
-- TOC entry 4927 (class 0 OID 0)
-- Dependencies: 222
-- Name: idfcm; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idfcm', 5, true);


--
-- TOC entry 4928 (class 0 OID 0)
-- Dependencies: 219
-- Name: idforn; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idforn', 2, true);


--
-- TOC entry 4929 (class 0 OID 0)
-- Dependencies: 217
-- Name: idimp; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idimp', 3, true);


--
-- TOC entry 4930 (class 0 OID 0)
-- Dependencies: 221
-- Name: idmp; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idmp', 2, true);


--
-- TOC entry 4760 (class 2606 OID 41437)
-- Name: fornecedores fornecedores_cnpj_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedores
    ADD CONSTRAINT fornecedores_cnpj_key UNIQUE (cnpj);


--
-- TOC entry 4762 (class 2606 OID 41435)
-- Name: fornecedores fornecedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedores
    ADD CONSTRAINT fornecedores_pkey PRIMARY KEY (idforn);


--
-- TOC entry 4766 (class 2606 OID 41526)
-- Name: fornecimentos fornecimentos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecimentos
    ADD CONSTRAINT fornecimentos_pkey PRIMARY KEY (idfcm);


--
-- TOC entry 4758 (class 2606 OID 41373)
-- Name: impressoras impressoras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.impressoras
    ADD CONSTRAINT impressoras_pkey PRIMARY KEY (idimp);


--
-- TOC entry 4764 (class 2606 OID 41521)
-- Name: materiasprimas materiasprimas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materiasprimas
    ADD CONSTRAINT materiasprimas_pkey PRIMARY KEY (idmp);


--
-- TOC entry 4767 (class 2606 OID 41527)
-- Name: fornecimentos fornecimentos_idforn_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecimentos
    ADD CONSTRAINT fornecimentos_idforn_fkey FOREIGN KEY (idforn) REFERENCES public.fornecedores(idforn);


--
-- TOC entry 4768 (class 2606 OID 41532)
-- Name: fornecimentos fornecimentos_idmp_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecimentos
    ADD CONSTRAINT fornecimentos_idmp_fkey FOREIGN KEY (idmp) REFERENCES public.materiasprimas(idmp);


-- Completed on 2025-06-22 16:50:45

--
-- PostgreSQL database dump complete
--


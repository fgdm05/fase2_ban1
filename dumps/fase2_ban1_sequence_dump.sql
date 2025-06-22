--
-- PostgreSQL database dump
--

-- Dumped from database version 16.3
-- Dumped by pg_dump version 16.3

-- Started on 2025-06-22 20:05:33

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
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
-- TOC entry 223 (class 1259 OID 16810)
-- Name: abastecimento; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.abastecimento (
    idabastecimento integer NOT NULL,
    idmateriaprima integer NOT NULL,
    idimpressora integer NOT NULL,
    datahora date NOT NULL,
    quantidade integer NOT NULL
);


ALTER TABLE public.abastecimento OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16759)
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
-- TOC entry 216 (class 1259 OID 16762)
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
-- TOC entry 224 (class 1259 OID 16825)
-- Name: idabastecimento; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.idabastecimento
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE public.idabastecimento OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16765)
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
-- TOC entry 218 (class 1259 OID 16766)
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
-- TOC entry 219 (class 1259 OID 16767)
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
-- TOC entry 220 (class 1259 OID 16768)
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
-- TOC entry 221 (class 1259 OID 16769)
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
-- TOC entry 222 (class 1259 OID 16772)
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
-- TOC entry 4922 (class 0 OID 16810)
-- Dependencies: 223
-- Data for Name: abastecimento; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4914 (class 0 OID 16759)
-- Dependencies: 215
-- Data for Name: fornecedores; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fornecedores VALUES (1, 'Folhas folhudas', '12345678901234', 'Folhinhas bonitas');


--
-- TOC entry 4915 (class 0 OID 16762)
-- Dependencies: 216
-- Data for Name: fornecimentos; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.fornecimentos VALUES (4, 10, '2025-06-22', 1, 1);


--
-- TOC entry 4920 (class 0 OID 16769)
-- Dependencies: 221
-- Data for Name: impressoras; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 4921 (class 0 OID 16772)
-- Dependencies: 222
-- Data for Name: materiasprimas; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.materiasprimas VALUES (1, 'Folha A4', 50, -1, false);


--
-- TOC entry 4929 (class 0 OID 0)
-- Dependencies: 224
-- Name: idabastecimento; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idabastecimento', 1, false);


--
-- TOC entry 4930 (class 0 OID 0)
-- Dependencies: 217
-- Name: idfcm; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idfcm', 5, true);


--
-- TOC entry 4931 (class 0 OID 0)
-- Dependencies: 218
-- Name: idforn; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idforn', 2, true);


--
-- TOC entry 4932 (class 0 OID 0)
-- Dependencies: 219
-- Name: idimp; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idimp', 3, true);


--
-- TOC entry 4933 (class 0 OID 0)
-- Dependencies: 220
-- Name: idmp; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.idmp', 2, true);


--
-- TOC entry 4766 (class 2606 OID 16814)
-- Name: abastecimento abastecimento_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abastecimento
    ADD CONSTRAINT abastecimento_pkey PRIMARY KEY (idabastecimento);


--
-- TOC entry 4756 (class 2606 OID 16776)
-- Name: fornecedores fornecedores_cnpj_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedores
    ADD CONSTRAINT fornecedores_cnpj_key UNIQUE (cnpj);


--
-- TOC entry 4758 (class 2606 OID 16778)
-- Name: fornecedores fornecedores_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecedores
    ADD CONSTRAINT fornecedores_pkey PRIMARY KEY (idforn);


--
-- TOC entry 4760 (class 2606 OID 16780)
-- Name: fornecimentos fornecimentos_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecimentos
    ADD CONSTRAINT fornecimentos_pkey PRIMARY KEY (idfcm);


--
-- TOC entry 4762 (class 2606 OID 16782)
-- Name: impressoras impressoras_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.impressoras
    ADD CONSTRAINT impressoras_pkey PRIMARY KEY (idimp);


--
-- TOC entry 4764 (class 2606 OID 16784)
-- Name: materiasprimas materiasprimas_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.materiasprimas
    ADD CONSTRAINT materiasprimas_pkey PRIMARY KEY (idmp);


--
-- TOC entry 4769 (class 2606 OID 16820)
-- Name: abastecimento abastecimento_idimpressora_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abastecimento
    ADD CONSTRAINT abastecimento_idimpressora_fkey FOREIGN KEY (idimpressora) REFERENCES public.impressoras(idimp);


--
-- TOC entry 4770 (class 2606 OID 16815)
-- Name: abastecimento abastecimento_idmateriaprima_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.abastecimento
    ADD CONSTRAINT abastecimento_idmateriaprima_fkey FOREIGN KEY (idmateriaprima) REFERENCES public.materiasprimas(idmp);


--
-- TOC entry 4767 (class 2606 OID 16785)
-- Name: fornecimentos fornecimentos_idforn_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecimentos
    ADD CONSTRAINT fornecimentos_idforn_fkey FOREIGN KEY (idforn) REFERENCES public.fornecedores(idforn);


--
-- TOC entry 4768 (class 2606 OID 16790)
-- Name: fornecimentos fornecimentos_idmp_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.fornecimentos
    ADD CONSTRAINT fornecimentos_idmp_fkey FOREIGN KEY (idmp) REFERENCES public.materiasprimas(idmp);


-- Completed on 2025-06-22 20:05:34

--
-- PostgreSQL database dump complete
--


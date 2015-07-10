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

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: compromisso; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE compromisso (
    compromisso_sq integer NOT NULL,
    data_compromisso timestamp without time zone NOT NULL,
    paciente_sq integer NOT NULL,
    medico_sq integer NOT NULL,
    compareceu boolean,
    data_cadastro timestamp without time zone NOT NULL,
    tipo_compromisso_sq integer NOT NULL,
    convenio_sq integer NOT NULL,
    valor_cobrado numeric(9,2),
    valor_pago numeric(9,2)
);


ALTER TABLE public.compromisso OWNER TO consultorio;

--
-- Name: compromisso_agenda_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE compromisso_agenda_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.compromisso_agenda_sq_seq OWNER TO consultorio;

--
-- Name: compromisso_agenda_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE compromisso_agenda_sq_seq OWNED BY compromisso.compromisso_sq;


--
-- Name: consultorio; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE consultorio (
    consultorio_sq integer NOT NULL,
    cnpj_consultorio character varying(14) NOT NULL,
    razao_social_consultorio character varying(255) NOT NULL
);


ALTER TABLE public.consultorio OWNER TO consultorio;

--
-- Name: consultorio_consultorio_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE consultorio_consultorio_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consultorio_consultorio_sq_seq OWNER TO consultorio;

--
-- Name: consultorio_consultorio_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE consultorio_consultorio_sq_seq OWNED BY consultorio.consultorio_sq;


--
-- Name: consultorio_pessoa; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE consultorio_pessoa (
    consultorio_pessoa_sq integer NOT NULL,
    pessoa_sq integer NOT NULL,
    consultorio_sq integer NOT NULL,
    tipo_pessoa_sq integer NOT NULL
);


ALTER TABLE public.consultorio_pessoa OWNER TO consultorio;

--
-- Name: consultorio_pessoa_consultorio_pessoa_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE consultorio_pessoa_consultorio_pessoa_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.consultorio_pessoa_consultorio_pessoa_sq_seq OWNER TO consultorio;

--
-- Name: consultorio_pessoa_consultorio_pessoa_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE consultorio_pessoa_consultorio_pessoa_sq_seq OWNED BY consultorio_pessoa.consultorio_pessoa_sq;


--
-- Name: convenio; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE convenio (
    convenio_sq integer NOT NULL,
    nome_convenio character varying(50) NOT NULL,
    valor_base numeric(9,2) NOT NULL,
    prazo_maximo_retorno integer DEFAULT 0 NOT NULL,
    consultorio_sq integer NOT NULL
);


ALTER TABLE public.convenio OWNER TO consultorio;

--
-- Name: convenio_convenio_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE convenio_convenio_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.convenio_convenio_sq_seq OWNER TO consultorio;

--
-- Name: convenio_convenio_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE convenio_convenio_sq_seq OWNED BY convenio.convenio_sq;


--
-- Name: endereco; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE endereco (
    endereco_sq integer NOT NULL,
    logradouro character varying(255) NOT NULL,
    cep character varying(8) NOT NULL,
    numero character varying(10) NOT NULL,
    complemento character varying(50) NOT NULL,
    bairro character varying(255) NOT NULL,
    pessoa_sq integer NOT NULL,
    tipo_endereco_sq integer NOT NULL
);


ALTER TABLE public.endereco OWNER TO consultorio;

--
-- Name: endereco_endereco_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE endereco_endereco_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.endereco_endereco_sq_seq OWNER TO consultorio;

--
-- Name: endereco_endereco_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE endereco_endereco_sq_seq OWNED BY endereco.endereco_sq;


--
-- Name: observacao; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE observacao (
    observacao_sq integer NOT NULL,
    compromisso_sq integer NOT NULL,
    observacao text NOT NULL,
    data_observacao timestamp without time zone DEFAULT now() NOT NULL
);


ALTER TABLE public.observacao OWNER TO consultorio;

--
-- Name: observacao_observacao_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE observacao_observacao_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.observacao_observacao_sq_seq OWNER TO consultorio;

--
-- Name: observacao_observacao_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE observacao_observacao_sq_seq OWNED BY observacao.observacao_sq;


--
-- Name: pessoa; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE pessoa (
    pessoa_sq integer NOT NULL,
    cpf_pessoa character varying(11) NOT NULL,
    nome_pessoa character varying(50) NOT NULL
);


ALTER TABLE public.pessoa OWNER TO consultorio;

--
-- Name: pessoa_imagem; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE pessoa_imagem (
    pessoa_imagem_sq integer NOT NULL,
    pessoa_sq integer NOT NULL
);


ALTER TABLE public.pessoa_imagem OWNER TO consultorio;

--
-- Name: pessoa_imagem_metadado; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE pessoa_imagem_metadado (
    pessoa_imagem_metadado_sq integer NOT NULL,
    chave character varying(255) NOT NULL,
    valor character varying(255) NOT NULL,
    pessoa_imagem_sq integer NOT NULL
);


ALTER TABLE public.pessoa_imagem_metadado OWNER TO consultorio;

--
-- Name: pessoa_imagem_metadado_pessoa_imagem_metadado_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE pessoa_imagem_metadado_pessoa_imagem_metadado_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoa_imagem_metadado_pessoa_imagem_metadado_sq_seq OWNER TO consultorio;

--
-- Name: pessoa_imagem_metadado_pessoa_imagem_metadado_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE pessoa_imagem_metadado_pessoa_imagem_metadado_sq_seq OWNED BY pessoa_imagem_metadado.pessoa_imagem_metadado_sq;


--
-- Name: pessoa_imagem_pessoa_imagem_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE pessoa_imagem_pessoa_imagem_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoa_imagem_pessoa_imagem_sq_seq OWNER TO consultorio;

--
-- Name: pessoa_imagem_pessoa_imagem_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE pessoa_imagem_pessoa_imagem_sq_seq OWNED BY pessoa_imagem.pessoa_imagem_sq;


--
-- Name: pessoa_pessoa_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE pessoa_pessoa_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.pessoa_pessoa_sq_seq OWNER TO consultorio;

--
-- Name: pessoa_pessoa_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE pessoa_pessoa_sq_seq OWNED BY pessoa.pessoa_sq;


--
-- Name: telefone; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE telefone (
    telefone_sq integer NOT NULL,
    numero_telefone character varying(20) NOT NULL,
    ramal_telefone character varying(10) NOT NULL,
    pessoa_sq integer NOT NULL,
    tipo_telefone_sq integer NOT NULL
);


ALTER TABLE public.telefone OWNER TO consultorio;

--
-- Name: telefone_telefone_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE telefone_telefone_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.telefone_telefone_sq_seq OWNER TO consultorio;

--
-- Name: telefone_telefone_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE telefone_telefone_sq_seq OWNED BY telefone.telefone_sq;


--
-- Name: tipo_compromisso; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE tipo_compromisso (
    tipo_compromisso_sq integer NOT NULL,
    descricao_tipo_compromisso character varying(50) NOT NULL
);


ALTER TABLE public.tipo_compromisso OWNER TO consultorio;

--
-- Name: tipo_compromisso_tipo_compromisso_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE tipo_compromisso_tipo_compromisso_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_compromisso_tipo_compromisso_sq_seq OWNER TO consultorio;

--
-- Name: tipo_compromisso_tipo_compromisso_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE tipo_compromisso_tipo_compromisso_sq_seq OWNED BY tipo_compromisso.tipo_compromisso_sq;


--
-- Name: tipo_pessoa; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE tipo_pessoa (
    tipo_pessoa_sq integer NOT NULL,
    descricao_tipo_pessoa character varying(50) NOT NULL
);


ALTER TABLE public.tipo_pessoa OWNER TO consultorio;

--
-- Name: tipo_dominio_tipo_endereco_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE tipo_dominio_tipo_endereco_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_dominio_tipo_endereco_sq_seq OWNER TO consultorio;

--
-- Name: tipo_dominio_tipo_endereco_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE tipo_dominio_tipo_endereco_sq_seq OWNED BY tipo_pessoa.tipo_pessoa_sq;


--
-- Name: tipo_endereco; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE tipo_endereco (
    tipo_endereco_sq integer NOT NULL,
    descricao_tipo_endereco character varying(50) NOT NULL
);


ALTER TABLE public.tipo_endereco OWNER TO consultorio;

--
-- Name: tipo_endereco_tipo_endereco_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE tipo_endereco_tipo_endereco_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_endereco_tipo_endereco_sq_seq OWNER TO consultorio;

--
-- Name: tipo_endereco_tipo_endereco_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE tipo_endereco_tipo_endereco_sq_seq OWNED BY tipo_endereco.tipo_endereco_sq;


--
-- Name: tipo_telefone; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE tipo_telefone (
    tipo_telefone_sq integer NOT NULL,
    descricao_tipo_telefone character varying(50) NOT NULL
);


ALTER TABLE public.tipo_telefone OWNER TO consultorio;

--
-- Name: tipo_telefone_tipo_telefone_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE tipo_telefone_tipo_telefone_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.tipo_telefone_tipo_telefone_sq_seq OWNER TO consultorio;

--
-- Name: tipo_telefone_tipo_telefone_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE tipo_telefone_tipo_telefone_sq_seq OWNED BY tipo_telefone.tipo_telefone_sq;


--
-- Name: usuario; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE usuario (
    usuario_sq integer NOT NULL,
    pessoa_sq integer NOT NULL,
    login character varying(50) NOT NULL,
    senha character varying(50) NOT NULL,
    usuario_facebook_sq integer
);


ALTER TABLE public.usuario OWNER TO consultorio;

--
-- Name: usuario_facebook; Type: TABLE; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE TABLE usuario_facebook (
    usuario_facebook_sq integer NOT NULL,
    usuario_facebook character varying(50),
    id_facebook character varying(50)
);


ALTER TABLE public.usuario_facebook OWNER TO consultorio;

--
-- Name: usuario_facebook_usuario_facebook_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE usuario_facebook_usuario_facebook_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_facebook_usuario_facebook_sq_seq OWNER TO consultorio;

--
-- Name: usuario_facebook_usuario_facebook_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE usuario_facebook_usuario_facebook_sq_seq OWNED BY usuario_facebook.usuario_facebook_sq;


--
-- Name: usuario_usuario_sq_seq; Type: SEQUENCE; Schema: public; Owner: consultorio
--

CREATE SEQUENCE usuario_usuario_sq_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.usuario_usuario_sq_seq OWNER TO consultorio;

--
-- Name: usuario_usuario_sq_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: consultorio
--

ALTER SEQUENCE usuario_usuario_sq_seq OWNED BY usuario.usuario_sq;


--
-- Name: compromisso_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY compromisso ALTER COLUMN compromisso_sq SET DEFAULT nextval('compromisso_agenda_sq_seq'::regclass);


--
-- Name: consultorio_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY consultorio ALTER COLUMN consultorio_sq SET DEFAULT nextval('consultorio_consultorio_sq_seq'::regclass);


--
-- Name: consultorio_pessoa_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY consultorio_pessoa ALTER COLUMN consultorio_pessoa_sq SET DEFAULT nextval('consultorio_pessoa_consultorio_pessoa_sq_seq'::regclass);


--
-- Name: convenio_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY convenio ALTER COLUMN convenio_sq SET DEFAULT nextval('convenio_convenio_sq_seq'::regclass);


--
-- Name: endereco_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY endereco ALTER COLUMN endereco_sq SET DEFAULT nextval('endereco_endereco_sq_seq'::regclass);


--
-- Name: observacao_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY observacao ALTER COLUMN observacao_sq SET DEFAULT nextval('observacao_observacao_sq_seq'::regclass);


--
-- Name: pessoa_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY pessoa ALTER COLUMN pessoa_sq SET DEFAULT nextval('pessoa_pessoa_sq_seq'::regclass);


--
-- Name: pessoa_imagem_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY pessoa_imagem ALTER COLUMN pessoa_imagem_sq SET DEFAULT nextval('pessoa_imagem_pessoa_imagem_sq_seq'::regclass);


--
-- Name: pessoa_imagem_metadado_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY pessoa_imagem_metadado ALTER COLUMN pessoa_imagem_metadado_sq SET DEFAULT nextval('pessoa_imagem_metadado_pessoa_imagem_metadado_sq_seq'::regclass);


--
-- Name: telefone_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY telefone ALTER COLUMN telefone_sq SET DEFAULT nextval('telefone_telefone_sq_seq'::regclass);


--
-- Name: tipo_compromisso_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY tipo_compromisso ALTER COLUMN tipo_compromisso_sq SET DEFAULT nextval('tipo_compromisso_tipo_compromisso_sq_seq'::regclass);


--
-- Name: tipo_endereco_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY tipo_endereco ALTER COLUMN tipo_endereco_sq SET DEFAULT nextval('tipo_endereco_tipo_endereco_sq_seq'::regclass);


--
-- Name: tipo_pessoa_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY tipo_pessoa ALTER COLUMN tipo_pessoa_sq SET DEFAULT nextval('tipo_dominio_tipo_endereco_sq_seq'::regclass);


--
-- Name: tipo_telefone_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY tipo_telefone ALTER COLUMN tipo_telefone_sq SET DEFAULT nextval('tipo_telefone_tipo_telefone_sq_seq'::regclass);


--
-- Name: usuario_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY usuario ALTER COLUMN usuario_sq SET DEFAULT nextval('usuario_usuario_sq_seq'::regclass);


--
-- Name: usuario_facebook_sq; Type: DEFAULT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY usuario_facebook ALTER COLUMN usuario_facebook_sq SET DEFAULT nextval('usuario_facebook_usuario_facebook_sq_seq'::regclass);


--
-- Name: compromisso_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY compromisso
    ADD CONSTRAINT compromisso_pk PRIMARY KEY (compromisso_sq);


--
-- Name: consultorio_pessoa_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY consultorio_pessoa
    ADD CONSTRAINT consultorio_pessoa_pk PRIMARY KEY (consultorio_pessoa_sq);


--
-- Name: consultorio_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY consultorio
    ADD CONSTRAINT consultorio_pk PRIMARY KEY (consultorio_sq);


--
-- Name: convenio_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY convenio
    ADD CONSTRAINT convenio_pk PRIMARY KEY (convenio_sq);


--
-- Name: endereco_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT endereco_pk PRIMARY KEY (endereco_sq);


--
-- Name: observacao_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY observacao
    ADD CONSTRAINT observacao_pk PRIMARY KEY (observacao_sq);


--
-- Name: pessoa_imagem_metadado_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY pessoa_imagem_metadado
    ADD CONSTRAINT pessoa_imagem_metadado_pk PRIMARY KEY (pessoa_imagem_metadado_sq);


--
-- Name: pessoa_imagem_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY pessoa_imagem
    ADD CONSTRAINT pessoa_imagem_pk PRIMARY KEY (pessoa_imagem_sq);


--
-- Name: pessoa_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY pessoa
    ADD CONSTRAINT pessoa_pk PRIMARY KEY (pessoa_sq);


--
-- Name: telefone_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY telefone
    ADD CONSTRAINT telefone_pk PRIMARY KEY (telefone_sq);


--
-- Name: tipo_compromisso_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY tipo_compromisso
    ADD CONSTRAINT tipo_compromisso_pk PRIMARY KEY (tipo_compromisso_sq);


--
-- Name: tipo_endereco_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY tipo_endereco
    ADD CONSTRAINT tipo_endereco_pk PRIMARY KEY (tipo_endereco_sq);


--
-- Name: tipo_pessoa_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY tipo_pessoa
    ADD CONSTRAINT tipo_pessoa_pk PRIMARY KEY (tipo_pessoa_sq);


--
-- Name: tipo_telefone_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY tipo_telefone
    ADD CONSTRAINT tipo_telefone_pk PRIMARY KEY (tipo_telefone_sq);


--
-- Name: usuario_facebook_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY usuario_facebook
    ADD CONSTRAINT usuario_facebook_pk PRIMARY KEY (usuario_facebook_sq);


--
-- Name: usuario_pk; Type: CONSTRAINT; Schema: public; Owner: consultorio; Tablespace: 
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_pk PRIMARY KEY (usuario_sq);


--
-- Name: fki_usuario_facebook_usuario_fk; Type: INDEX; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE INDEX fki_usuario_facebook_usuario_fk ON usuario USING btree (usuario_facebook_sq);


--
-- Name: pessoa_imagem_metadado_idx; Type: INDEX; Schema: public; Owner: consultorio; Tablespace: 
--

CREATE UNIQUE INDEX pessoa_imagem_metadado_idx ON pessoa_imagem_metadado USING btree (chave, pessoa_imagem_sq);


--
-- Name: compromisso_observacao_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY observacao
    ADD CONSTRAINT compromisso_observacao_fk FOREIGN KEY (compromisso_sq) REFERENCES compromisso(compromisso_sq);


--
-- Name: consultorio_consultorio_pessoa_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY consultorio_pessoa
    ADD CONSTRAINT consultorio_consultorio_pessoa_fk FOREIGN KEY (consultorio_sq) REFERENCES consultorio(consultorio_sq);


--
-- Name: consultorio_convenio_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY convenio
    ADD CONSTRAINT consultorio_convenio_fk FOREIGN KEY (consultorio_sq) REFERENCES consultorio(consultorio_sq);


--
-- Name: convenio_compromisso_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY compromisso
    ADD CONSTRAINT convenio_compromisso_fk FOREIGN KEY (convenio_sq) REFERENCES convenio(convenio_sq);


--
-- Name: pessoa_agenda_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY compromisso
    ADD CONSTRAINT pessoa_agenda_fk FOREIGN KEY (paciente_sq) REFERENCES pessoa(pessoa_sq);


--
-- Name: pessoa_compromisso_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY compromisso
    ADD CONSTRAINT pessoa_compromisso_fk FOREIGN KEY (medico_sq) REFERENCES pessoa(pessoa_sq);


--
-- Name: pessoa_consultorio_pessoa_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY consultorio_pessoa
    ADD CONSTRAINT pessoa_consultorio_pessoa_fk FOREIGN KEY (pessoa_sq) REFERENCES pessoa(pessoa_sq);


--
-- Name: pessoa_endereco_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT pessoa_endereco_fk FOREIGN KEY (pessoa_sq) REFERENCES pessoa(pessoa_sq);


--
-- Name: pessoa_imagem_pessoa_imagem_metadata_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY pessoa_imagem_metadado
    ADD CONSTRAINT pessoa_imagem_pessoa_imagem_metadata_fk FOREIGN KEY (pessoa_imagem_sq) REFERENCES pessoa_imagem(pessoa_imagem_sq);


--
-- Name: pessoa_pessoa_imagem_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY pessoa_imagem
    ADD CONSTRAINT pessoa_pessoa_imagem_fk FOREIGN KEY (pessoa_sq) REFERENCES pessoa(pessoa_sq);


--
-- Name: pessoa_telefone_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY telefone
    ADD CONSTRAINT pessoa_telefone_fk FOREIGN KEY (pessoa_sq) REFERENCES pessoa(pessoa_sq);


--
-- Name: pessoa_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT pessoa_usuario_fk FOREIGN KEY (pessoa_sq) REFERENCES pessoa(pessoa_sq);


--
-- Name: tipo_compromisso_compromisso_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY compromisso
    ADD CONSTRAINT tipo_compromisso_compromisso_fk FOREIGN KEY (tipo_compromisso_sq) REFERENCES tipo_compromisso(tipo_compromisso_sq);


--
-- Name: tipo_dominio_consultorio_pessoa_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY consultorio_pessoa
    ADD CONSTRAINT tipo_dominio_consultorio_pessoa_fk FOREIGN KEY (tipo_pessoa_sq) REFERENCES tipo_pessoa(tipo_pessoa_sq);


--
-- Name: tipo_endereco_endereco_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY endereco
    ADD CONSTRAINT tipo_endereco_endereco_fk FOREIGN KEY (tipo_endereco_sq) REFERENCES tipo_endereco(tipo_endereco_sq);


--
-- Name: tipo_telefone_telefone_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY telefone
    ADD CONSTRAINT tipo_telefone_telefone_fk FOREIGN KEY (tipo_telefone_sq) REFERENCES tipo_telefone(tipo_telefone_sq);


--
-- Name: usuario_facebook_usuario_fk; Type: FK CONSTRAINT; Schema: public; Owner: consultorio
--

ALTER TABLE ONLY usuario
    ADD CONSTRAINT usuario_facebook_usuario_fk FOREIGN KEY (usuario_facebook_sq) REFERENCES usuario_facebook(usuario_facebook_sq);


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


CREATE DATABASE tbp WITH OWNER = postgres ENCODING = 'UTF8' TABLESPACE = pg_default LC_COLLATE = 'en_US.UTF-8' LC_CTYPE = 'en_US.UTF-8' CONNECTION LIMIT = -1;

CREATE TABLE item
(
  id bigint NOT NULL,
  modification_time timestamp without time zone NOT NULL,
  modified_by character varying(20) NOT NULL,
  CONSTRAINT item_pkey PRIMARY KEY (id)
);
ALTER TABLE item
  OWNER TO postgres;

CREATE TYPE customer_type AS ENUM
(
  'STANDARD',
  'GOLDEN',
  'PLATINUM'
);

CREATE TABLE "user"
(
  active character(1) NOT NULL,
  deleted character(1) NOT NULL,
  email character varying(50) NOT NULL,
  first_name character varying(50) NOT NULL,
  last_name character varying(50) NOT NULL,
  "password" character varying(255) NOT NULL,
  username character varying(20) NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id),
  CONSTRAINT uk_mail UNIQUE (email),
  CONSTRAINT uk_username UNIQUE (username)
) INHERITS ("item");
ALTER TABLE "user"
  OWNER TO postgres;

CREATE TABLE "employee"
(
  department character varying(255) NOT NULL,
  picture oid, 
  CONSTRAINT user_pkey_e PRIMARY KEY (id)
)
 INHERITS ("user");
ALTER TABLE "employee"
  OWNER TO postgres;

CREATE TABLE "customer"
(
  "type" customer_type NOT NULL,
  CONSTRAINT user_pkey_c PRIMARY KEY (id)
)
  INHERITS ("user");
ALTER TABLE "customer"
  OWNER TO postgres;

CREATE TABLE permission
(
  code character varying(30) NOT NULL,
  description character varying(200),
  name character varying(100) NOT NULL,
  CONSTRAINT permission_pkey PRIMARY KEY (id),
  CONSTRAINT uk_permission_name UNIQUE ("name"),
  CONSTRAINT uk_permission_code UNIQUE (code)
)
 INHERITS ("item");
ALTER TABLE permission
  OWNER TO postgres;

CREATE TABLE permission2customer
(
  customer_id bigint NOT NULL,
  permission_id bigint NOT NULL,
  CONSTRAINT permission2user_pkey PRIMARY KEY (customer_id, permission_id),
  CONSTRAINT fk_customer_id FOREIGN KEY (customer_id)
      REFERENCES "customer" (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fk_permission_id FOREIGN KEY (permission_id)
      REFERENCES permission (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
ALTER TABLE permission2customer
  OWNER TO postgres;

CREATE TYPE address AS (
"country" varchar (100) ,
"town" varchar ( 100 ) ,
"postal_code" int4 ,
"address" varchar (100)
);

CREATE TABLE contact_info
(
  "address" address,
  mobile_phone character varying(50),
  postal_code character varying(10),
  username character varying(20) NOT NULL,
  CONSTRAINT contact_info_pkey PRIMARY KEY (id)
)
 INHERITS ("item");
ALTER TABLE contact_info
  OWNER TO postgres;
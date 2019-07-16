
CREATE TABLE public."user"
(
    id SERIAL NOT NULL,
    login character varying COLLATE pg_catalog."default" NOT NULL,
    password character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT "User_pkey" PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public."user"
    OWNER to postgres;
    
    
    CREATE TYPE public.features AS ENUM
    ('WIFI', 'AIR_CONDITIONING', 'ALL_INCLISIVE', 'SWIMMING_POOL', 'MINI_BAR', 'PARKING', 'LUXURY_ROOM', 'LOW_COST', 'JACUZZI', 'CINEMA');

ALTER TYPE public.features
    OWNER TO postgres;
    

CREATE TABLE public.hotel
(
    id SERIAL NOT NULL,
    name character varying COLLATE pg_catalog."default" NOT NULL,
    stars integer NOT NULL,
    webside character varying COLLATE pg_catalog."default" NOT NULL,
    lalitude double precision NOT NULL,
    longitude double precision NOT NULL,
    features features NOT NULL,
    CONSTRAINT hotel_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hotel
    OWNER to postgres;
    
    
 CREATE TYPE public.tour_type AS ENUM
    ('WEEKED_TOUR', 'CRUISE', 'GUIDED_TOUR', 'SHOP_TOUR', 'WEDDING_TOUR', 'FISHING_TOUR', 'GASTRONOMIC_TOUR', 'BIKE_TOUR', 'AUTO_TOUR', 'SPA_TOUR');

ALTER TYPE public.tour_type
    OWNER TO postgres;
    
   -- Table: public.tour

-- DROP TABLE public.tour;

CREATE TABLE public.tour
(
    id SERIAL NOT NULL,
    date date NOT NULL,
    duration character varying COLLATE pg_catalog."default" NOT NULL,
    description character varying COLLATE pg_catalog."default" NOT NULL,
    cost double precision NOT NULL,
    hotel_id integer NOT NULL,
    coutry_id integer NOT NULL,
    tour_type tour_type NOT NULL,
    CONSTRAINT tour_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.tour
    OWNER to postgres;


CREATE TABLE public.review
(
    id SERIAL NOT NULL,
    date date NOT NULL,
    text text COLLATE pg_catalog."default" NOT NULL,
    user_id integer NOT NULL,
    tour_id integer NOT NULL,
    CONSTRAINT review_pkey PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.review
    OWNER to postgres;
    
  

CREATE TABLE public.usertour
(
    user_id integer NOT NULL,
    tour_id integer NOT NULL
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usertour
    OWNER to postgres;
    
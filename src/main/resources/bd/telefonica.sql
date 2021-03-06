PGDMP     *    6                y         
   telefonica    11.5    11.5     
           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false                       1262    57487 
   telefonica    DATABASE     ?   CREATE DATABASE telefonica WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Peru.1252' LC_CTYPE = 'Spanish_Peru.1252';
    DROP DATABASE telefonica;
             postgres    false            ?            1259    57488 	   t_cliente    TABLE     ?   CREATE TABLE public.t_cliente (
    id_cliente integer NOT NULL,
    nombres character varying NOT NULL,
    tipo_doc character varying NOT NULL,
    num_doc character varying NOT NULL,
    fec_nac timestamp without time zone NOT NULL
);
    DROP TABLE public.t_cliente;
       public         postgres    false            ?            1259    57496    t_movil    TABLE     #  CREATE TABLE public.t_movil (
    id_movil integer NOT NULL,
    telefono character varying NOT NULL,
    estado character varying NOT NULL,
    tipo character varying NOT NULL,
    plan character varying NOT NULL,
    nro_documento character varying,
    codigo_oferta character varying
);
    DROP TABLE public.t_movil;
       public         postgres    false            ?            1259    57504    t_oferta    TABLE     ?   CREATE TABLE public.t_oferta (
    id_oferta integer NOT NULL,
    cod_oferta character varying NOT NULL,
    descripcion character varying NOT NULL,
    fec_ini date NOT NULL,
    fec_fin date
);
    DROP TABLE public.t_oferta;
       public         postgres    false                      0    57488 	   t_cliente 
   TABLE DATA               T   COPY public.t_cliente (id_cliente, nombres, tipo_doc, num_doc, fec_nac) FROM stdin;
    public       postgres    false    196                    0    57496    t_movil 
   TABLE DATA               g   COPY public.t_movil (id_movil, telefono, estado, tipo, plan, nro_documento, codigo_oferta) FROM stdin;
    public       postgres    false    197   ?                 0    57504    t_oferta 
   TABLE DATA               X   COPY public.t_oferta (id_oferta, cod_oferta, descripcion, fec_ini, fec_fin) FROM stdin;
    public       postgres    false    198          ?
           2606    57511    t_oferta oferta_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.t_oferta
    ADD CONSTRAINT oferta_pkey PRIMARY KEY (id_oferta);
 >   ALTER TABLE ONLY public.t_oferta DROP CONSTRAINT oferta_pkey;
       public         postgres    false    198            ?
           2606    57495    t_cliente t_cliente_pkey 
   CONSTRAINT     ^   ALTER TABLE ONLY public.t_cliente
    ADD CONSTRAINT t_cliente_pkey PRIMARY KEY (id_cliente);
 B   ALTER TABLE ONLY public.t_cliente DROP CONSTRAINT t_cliente_pkey;
       public         postgres    false    196            ?
           2606    57503    t_movil t_movil_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.t_movil
    ADD CONSTRAINT t_movil_pkey PRIMARY KEY (id_movil);
 >   ALTER TABLE ONLY public.t_movil DROP CONSTRAINT t_movil_pkey;
       public         postgres    false    197               i   x?3??,.JL??t???4127154??4??0?54?52U00?#.#Π??Ԣ?|$?? ??`???Ɯ^?ŇWr:;???p??B???????????1Bq? k         n   x?u˱	?0F???)?@r?.j?`,D#(ί?????|L???މ?t^G\???^G?[Qv=13????e£1і??E1?BL?{?@MhYh.????D?Tx ?K?         \   x?uʱ? К????t???ܿ4wPB???D2]??m.IE??e???i?8?e?%R?I??F?=?y??z?E:??|$??"?w ?5*?     
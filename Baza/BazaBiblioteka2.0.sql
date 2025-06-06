PGDMP                      }           Biblioteka2.0    17.4    17.4 !    @           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false            A           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false            B           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false            C           1262    17223    Biblioteka2.0    DATABASE     u   CREATE DATABASE "Biblioteka2.0" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'pl-PL';
    DROP DATABASE "Biblioteka2.0";
                     postgres    false            �            1259    17225    autorzy    TABLE     �   CREATE TABLE public.autorzy (
    id_autora integer NOT NULL,
    imie_autora character varying(30) NOT NULL,
    nazwisko_autora character varying(40)
);
    DROP TABLE public.autorzy;
       public         heap r       postgres    false            �            1259    17224    autorzy_id_autora_seq    SEQUENCE     �   CREATE SEQUENCE public.autorzy_id_autora_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.autorzy_id_autora_seq;
       public               postgres    false    218            D           0    0    autorzy_id_autora_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.autorzy_id_autora_seq OWNED BY public.autorzy.id_autora;
          public               postgres    false    217            �            1259    17232 	   czytelnik    TABLE     2  CREATE TABLE public.czytelnik (
    id_czytelnika integer NOT NULL,
    imie character varying(30) NOT NULL,
    nazwisko character varying(30) NOT NULL,
    email character varying(40) NOT NULL,
    haslo character varying(30) NOT NULL,
    CONSTRAINT haslo_length CHECK ((length((haslo)::text) >= 8))
);
    DROP TABLE public.czytelnik;
       public         heap r       postgres    false            �            1259    17231    czytelnik_id_czytelnika_seq    SEQUENCE     �   CREATE SEQUENCE public.czytelnik_id_czytelnika_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.czytelnik_id_czytelnika_seq;
       public               postgres    false    220            E           0    0    czytelnik_id_czytelnika_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.czytelnik_id_czytelnika_seq OWNED BY public.czytelnik.id_czytelnika;
          public               postgres    false    219            �            1259    17241    ksiazka    TABLE     �   CREATE TABLE public.ksiazka (
    kod_ksiazki integer NOT NULL,
    tytul character varying(50) NOT NULL,
    id_autora integer NOT NULL,
    status character varying(25) NOT NULL,
    gatunek character varying(40) NOT NULL
);
    DROP TABLE public.ksiazka;
       public         heap r       postgres    false            �            1259    17240    ksiazka_kod_ksiazki_seq    SEQUENCE     �   CREATE SEQUENCE public.ksiazka_kod_ksiazki_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.ksiazka_kod_ksiazki_seq;
       public               postgres    false    222            F           0    0    ksiazka_kod_ksiazki_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.ksiazka_kod_ksiazki_seq OWNED BY public.ksiazka.kod_ksiazki;
          public               postgres    false    221            �            1259    17252    wypozyczenia    TABLE     �   CREATE TABLE public.wypozyczenia (
    id_czytelnika integer NOT NULL,
    kod_ksiazki integer NOT NULL,
    data_wypozyczenia date NOT NULL,
    data_oddania date
);
     DROP TABLE public.wypozyczenia;
       public         heap r       postgres    false            �           2604    17228    autorzy id_autora    DEFAULT     v   ALTER TABLE ONLY public.autorzy ALTER COLUMN id_autora SET DEFAULT nextval('public.autorzy_id_autora_seq'::regclass);
 @   ALTER TABLE public.autorzy ALTER COLUMN id_autora DROP DEFAULT;
       public               postgres    false    218    217    218            �           2604    17235    czytelnik id_czytelnika    DEFAULT     �   ALTER TABLE ONLY public.czytelnik ALTER COLUMN id_czytelnika SET DEFAULT nextval('public.czytelnik_id_czytelnika_seq'::regclass);
 F   ALTER TABLE public.czytelnik ALTER COLUMN id_czytelnika DROP DEFAULT;
       public               postgres    false    219    220    220            �           2604    17244    ksiazka kod_ksiazki    DEFAULT     z   ALTER TABLE ONLY public.ksiazka ALTER COLUMN kod_ksiazki SET DEFAULT nextval('public.ksiazka_kod_ksiazki_seq'::regclass);
 B   ALTER TABLE public.ksiazka ALTER COLUMN kod_ksiazki DROP DEFAULT;
       public               postgres    false    222    221    222            8          0    17225    autorzy 
   TABLE DATA           J   COPY public.autorzy (id_autora, imie_autora, nazwisko_autora) FROM stdin;
    public               postgres    false    218   *'       :          0    17232 	   czytelnik 
   TABLE DATA           P   COPY public.czytelnik (id_czytelnika, imie, nazwisko, email, haslo) FROM stdin;
    public               postgres    false    220   �'       <          0    17241    ksiazka 
   TABLE DATA           Q   COPY public.ksiazka (kod_ksiazki, tytul, id_autora, status, gatunek) FROM stdin;
    public               postgres    false    222   &(       =          0    17252    wypozyczenia 
   TABLE DATA           c   COPY public.wypozyczenia (id_czytelnika, kod_ksiazki, data_wypozyczenia, data_oddania) FROM stdin;
    public               postgres    false    223   �(       G           0    0    autorzy_id_autora_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.autorzy_id_autora_seq', 7, true);
          public               postgres    false    217            H           0    0    czytelnik_id_czytelnika_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.czytelnik_id_czytelnika_seq', 15, true);
          public               postgres    false    219            I           0    0    ksiazka_kod_ksiazki_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.ksiazka_kod_ksiazki_seq', 11, true);
          public               postgres    false    221            �           2606    17230    autorzy autorzy_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.autorzy
    ADD CONSTRAINT autorzy_pkey PRIMARY KEY (id_autora);
 >   ALTER TABLE ONLY public.autorzy DROP CONSTRAINT autorzy_pkey;
       public                 postgres    false    218            �           2606    17239    czytelnik czytelnik_email_key 
   CONSTRAINT     Y   ALTER TABLE ONLY public.czytelnik
    ADD CONSTRAINT czytelnik_email_key UNIQUE (email);
 G   ALTER TABLE ONLY public.czytelnik DROP CONSTRAINT czytelnik_email_key;
       public                 postgres    false    220            �           2606    17237    czytelnik czytelnik_pkey 
   CONSTRAINT     a   ALTER TABLE ONLY public.czytelnik
    ADD CONSTRAINT czytelnik_pkey PRIMARY KEY (id_czytelnika);
 B   ALTER TABLE ONLY public.czytelnik DROP CONSTRAINT czytelnik_pkey;
       public                 postgres    false    220            �           2606    17246    ksiazka ksiazka_pkey 
   CONSTRAINT     [   ALTER TABLE ONLY public.ksiazka
    ADD CONSTRAINT ksiazka_pkey PRIMARY KEY (kod_ksiazki);
 >   ALTER TABLE ONLY public.ksiazka DROP CONSTRAINT ksiazka_pkey;
       public                 postgres    false    222            �           2606    17256    wypozyczenia wypozyczenia_pkey 
   CONSTRAINT     �   ALTER TABLE ONLY public.wypozyczenia
    ADD CONSTRAINT wypozyczenia_pkey PRIMARY KEY (id_czytelnika, kod_ksiazki, data_wypozyczenia);
 H   ALTER TABLE ONLY public.wypozyczenia DROP CONSTRAINT wypozyczenia_pkey;
       public                 postgres    false    223    223    223            �           1259    17267    idx_wypozyczenia_id_czytelnika    INDEX     `   CREATE INDEX idx_wypozyczenia_id_czytelnika ON public.wypozyczenia USING btree (id_czytelnika);
 2   DROP INDEX public.idx_wypozyczenia_id_czytelnika;
       public                 postgres    false    223            �           2606    17247    ksiazka ksiazka_fk    FK CONSTRAINT     |   ALTER TABLE ONLY public.ksiazka
    ADD CONSTRAINT ksiazka_fk FOREIGN KEY (id_autora) REFERENCES public.autorzy(id_autora);
 <   ALTER TABLE ONLY public.ksiazka DROP CONSTRAINT ksiazka_fk;
       public               postgres    false    222    218    4761            �           2606    17257    wypozyczenia wypozyczenia_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.wypozyczenia
    ADD CONSTRAINT wypozyczenia_fk FOREIGN KEY (id_czytelnika) REFERENCES public.czytelnik(id_czytelnika);
 F   ALTER TABLE ONLY public.wypozyczenia DROP CONSTRAINT wypozyczenia_fk;
       public               postgres    false    4765    223    220            �           2606    17262    wypozyczenia wypozyczenia_fk1    FK CONSTRAINT     �   ALTER TABLE ONLY public.wypozyczenia
    ADD CONSTRAINT wypozyczenia_fk1 FOREIGN KEY (kod_ksiazki) REFERENCES public.ksiazka(kod_ksiazki);
 G   ALTER TABLE ONLY public.wypozyczenia DROP CONSTRAINT wypozyczenia_fk1;
       public               postgres    false    4767    222    223            8   n   x�˽
�P���������Pp)�.il�&�s�^����Y�-�x�E�vhS�:��5��Q��F���g��?��P���p�a��"���.�G���S������R"�      :   n   x�e�1�0�����j׌����G<0M.���_/�ݜ^^x�tA��u�"M(.��e��,.����aA�.g�l|��P�Eժ����O�V��py�$���#w��_a.z      <   o   x�3�J*�O��LT�T�N,J�4�t�/.92� /�3 �<3���#�
ŕ��9���Uy�\��II�%�&H���J�*��9@���(�䧔��O��i�Ei� �/�      =      x�3�4�4202�50�50Dbr��qqq S�     
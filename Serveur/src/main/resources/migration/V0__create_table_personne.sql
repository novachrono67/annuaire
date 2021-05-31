drop table if exists personne;

create table if not exists personne (
    id serial primary key not null,
    nom char(50) not null,
    prenom char(50) not null,
    login char(50) not null,
    mot_de_passe char(50) not null,
    adresse_mail char(50) not null,
    date_arrivee_entreprise date not null
);

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (1, 'Specter', 'Harvey', 'HarveySpecter', 'vgtbwehuo', 'harvey.specter@gmail.com', '2014-05-17');

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (2, 'Ross', 'Mike', 'MikeRoss', 'bwrbrgzg', 'mike.ross@gmail.com', '2017-02-20');

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (3, 'Paulsen', 'Donna', 'DonnaPaulsen', 'hzrzgthrzh', 'donna.paulsen@gmail.com', '2015-07-09');

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (4, 'Litt', 'Louis', 'LouisLitt', 'heztgrzr', 'louis.litt@gmail.com', '2012-11-01');

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (5, 'Pearson', 'Jessica', 'JessicaPearson', 'bhztjuzrg', 'jessica.pearson@gmail.com', '2002-01-04');

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (6, 'Zane', 'Rachel', 'RachelZane', 'ngthrwoj', 'rachel.Zane@gmail.com', '2013-09-23');

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (7, 'Hardman', 'Daniel', 'DanielHardman', 'nfuewripb', 'daniel.hardman@gmail.com', '2000-11-07');

insert into personne (id, nom, prenom, login, mot_de_passe, adresse_mail, date_arrivee_entreprise)
values (8, 'Bennett', 'Katrina', 'KatrinaBennett', 'xcvtbznui', 'katrina.bennett@gmail.com', '2016-10-20');
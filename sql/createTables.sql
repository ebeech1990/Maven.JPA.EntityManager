create table pet_owner(
     id int not null auto_increment,
     fname varchar(50),
     lname varchar(50),
     num_of_pets int,
     primary key(id));

    create table pet(
     id int not null auto_increment,
     species varchar(250),
     name varchar(100),
     age int,
     fav_napping_spot varchar(250),
     fav_food varchar(100),
     primary key(id)));

     create table pet_petOwner(
        pet_id int,
        petOwner_id int
     );
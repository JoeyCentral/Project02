drop table customrolls;
drop table my_spells;
drop table my_feats;
drop table spellsources;
drop table spells;
drop table features;
drop table my_characters;
drop table backgrounds;
drop table race;
drop table character_class;
drop table proficiencies;
drop table users;





create table users(
	user_id serial primary key,
	username varchar,
	hashpass varchar,
	salt varchar
);

create table proficiencies(
		prof_id serial primary key,
		prof_name varchar,
		ability int,
		description varchar
);

create table character_class(
	class_id serial primary key,
	classname varchar,
	hit_die int,
	saveprof1 int references proficiencies(prof_id),
	saveprof2 int references proficiencies(prof_id),
	spellprog int,
	cantrips int
);

create table race(
	race_id serial primary key,
	racename varchar,
	ability_mod int,
	base_speed int,
	free_prof int references proficiencies(prof_id)
);

create table backgrounds(
	background_id serial primary key,
	background_name varchar,
	proficiency1 int references proficiencies(prof_id),
	proficiency2 int references proficiencies(prof_id),
	bonus_gear varchar
);


create table my_characters(
	char_id serial primary key,
	player int references users(user_id),
	my_class int references character_class(class_id),
	my_race int references race(race_id),
	class_prof1 int references proficiencies(prof_id),
	class_prof2 int references proficiencies(prof_id),
	background int references backgrounds(background_id),
	gear varchar,
	equiped_ac int,
	personality varchar,
	ideals varchar,
	bonds varchar,
	flaws varchar,
	appearance varchar,
	allies varchar,
	backstory varchar,
	tempdata int
);
	
create table features(
	feat_id serial primary key,
	feat_name varchar,
	field_modified varchar,
	modifier int,
	prereq varchar,
	reqval int
	);

create table spells(
	spell_id serial primary key,
	spellname varchar,
	spelllevel int,
	school int,
	casttime varchar,
	spellrange int,
	components varchar,
	duration varchar,
	description varchar
);

create table spellsources(
	source_id serial primary key,
	spell int references spells(spell_id),
	class_id int references character_class(class_id),
	race int references race(race_id),
	feature int references features(feat_id)
);

create table my_feats(
	id serial primary key,
	char_id int references my_characters(char_id),
	feat_id int references features(feat_id)
);

create table my_spells(
	id serial primary key,
	char_id int references my_characters(char_id),
	spell_id int references spells(spell_id)
);

create table customrolls(
	roll_id serial primary key,
	roll_name varchar,
	ability int,
	modifier int,
	damage_amount int,
	damage_type varchar,
	char_id int references my_characters(char_id)
);






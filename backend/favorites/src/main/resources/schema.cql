USE williamescudero_com;

CREATE TABLE favorites (
	id uuid PRIMARY KEY,
	header map<text, text>
);

CREATE TABLE favoriteItems (
	id uuid,
	favorite_id uuid,
	title text,
	likes int,
	tags map<text, text>,
	PRIMARY KEY ((favorite_id), id)
);
BEGIN TRANSACTION;
CREATE TABLE IF NOT EXISTS "cars" (
	"id"	INTEGER NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"speed"	INTEGER NOT NULL CHECK("speed" < 1000),
	"weight"	INTEGER NOT NULL CHECK("weight" < 10000),
	"color"	TEXT NOT NULL,
	"wheelsCount"	INTEGER NOT NULL CHECK("wheelsCount" < 100),
	PRIMARY KEY("id" AUTOINCREMENT)
);
CREATE TABLE IF NOT EXISTS "express" (
	"id"	INTEGER NOT NULL UNIQUE,
	"name"	TEXT NOT NULL,
	"speed"	INTEGER NOT NULL CHECK("speed" < 1000),
	"weight"	INTEGER NOT NULL CHECK("weight" < 10000),
	"color"	TEXT NOT NULL,
	"railsCount"	INTEGER NOT NULL CHECK("railsCount" < 100),
	"expressType"	TEXT,
	PRIMARY KEY("id" AUTOINCREMENT)
);
INSERT INTO "cars" VALUES (1,'Машина 5',120,1500,'черный',4);
INSERT INTO "cars" VALUES (2,'Машина 325',100,1250,'серый',4);
INSERT INTO "cars" VALUES (3,'Автобус 431',80,2500,'металлик',6);
INSERT INTO "cars" VALUES (4,'Микроавтобус',90,1780,'черный',4);
INSERT INTO "express" VALUES (1,'экспресс 154',400,3050,'белый',6,'Региональный');
INSERT INTO "express" VALUES (2,'экспрес 643',340,2800,'серый',6,'Местная линия');
INSERT INTO "express" VALUES (3,'экспрес 236',360,3120,'белый',6,'Региональный');
INSERT INTO "express" VALUES (4,'экспресс 345',390,3210,'черный',0,'Региональный');
COMMIT;

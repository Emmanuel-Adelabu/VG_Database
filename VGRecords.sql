PRAGMA foreign_keys=OFF;
BEGIN TRANSACTION;
CREATE TABLE Creator(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
Name VARCHAR(255) NOT NULL,
DateOfBirth DATE NOT NULL,
Age INT NOT NULL,
CONSTRAINT UIX_Name UNIQUE(Name)
);
INSERT INTO Creator VALUES(3,'Yoshiaki Koizumi','1968-04-29',50);
INSERT INTO Creator VALUES(4,'Hideaki Itsuno','1971-04-07',47);
INSERT INTO Creator VALUES(5,'Hideki Kamiya','1970-12-19',48);
INSERT INTO Creator VALUES(6,'Eiji Aonuma','1963-03-16',55);
INSERT INTO Creator VALUES(7,'Tetsuya Nomura','1970-10-08',48);
INSERT INTO Creator VALUES(8,'Toby Fox','1991-10-11',27);
INSERT INTO Creator VALUES(9,'Cory Barlog','1975-09-02',44);
INSERT INTO Creator VALUES(10,'Masahiro Sakurai','1970-08-03',48);
INSERT INTO Creator VALUES(11,'Hidetaka Miyazaki',1975,45);
INSERT INTO Creator VALUES(12,'Hideo Kojima','1963-08-24',55);
INSERT INTO Creator VALUES(13,'Michel Ancel','1972-03-29',46);
CREATE TABLE Console(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
Name VARCHAR(255) NOT NULL,
ReleaseYear INT NOT NULL,
CONSTRAINT UIX_Name UNIQUE(Name)
);
INSERT INTO Console VALUES(1,'Nintendo Switch',2017);
INSERT INTO Console VALUES(2,'Playstation 4',2013);
INSERT INTO Console VALUES(3,'Xbox One',2013);
INSERT INTO Console VALUES(4,'Nintendo 3DS',2011);
INSERT INTO Console VALUES(5,'Playstation 4 Pro',2016);
INSERT INTO Console VALUES(6,'Xbox One X',2017);
INSERT INTO Console VALUES(7,'Steam',2003);
INSERT INTO Console VALUES(8,'Playstation 3',2006);
INSERT INTO Console VALUES(9,'Nintendo Wii',2006);
INSERT INTO Console VALUES(10,'Xbox 360',2005);
CREATE TABLE Publisher(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
Name VARCHAR(255) NOT NULL,
FoundedYear INT NOT NULL,
PlaceOfOrigin VARCHAR(255) NULL,
CONSTRAINT UIX_Name UNIQUE(Name)
);
INSERT INTO Publisher VALUES(1,'Ubisoft',1986,'France');
INSERT INTO Publisher VALUES(2,'Square Enix',2003,'Japan');
INSERT INTO Publisher VALUES(3,'Nintendo',1889,'Japan');
INSERT INTO Publisher VALUES(4,'Toby Fox',2015,'USA');
INSERT INTO Publisher VALUES(5,'Sony Corp',1946,'Japan');
INSERT INTO Publisher VALUES(6,'Activision',1979,'USA');
INSERT INTO Publisher VALUES(7,'Electronic Arts',1982,'USA');
INSERT INTO Publisher VALUES(8,'Devolver Digital',2009,'USA');
INSERT INTO Publisher VALUES(9,'Xseed Games',2004,'USA');
INSERT INTO Publisher VALUES(10,'BANDAI NAMCO',2006,'Japan');
INSERT INTO Publisher VALUES(11,'Capcom',1979,'Japan');
INSERT INTO Publisher VALUES(12,'Sega',1960,'USA');
CREATE TABLE DevCompany(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
Name VARCHAR(255) NOT NULL,
PlaceOfOrigin VARCHAR(255) NULL,
FoundedYear INT NOT NULL,
CONSTRAINT UIX_Name UNIQUE(Name)
);
INSERT INTO DevCompany VALUES(1,'Nintendo','Japan',1889);
INSERT INTO DevCompany VALUES(2,'Capcom','Japan',1979);
INSERT INTO DevCompany VALUES(3,'Platinum Games','Japan',2007);
INSERT INTO DevCompany VALUES(4,'Square Enix','Japan',2003);
INSERT INTO DevCompany VALUES(5,'Toby Fox','USA',2015);
INSERT INTO DevCompany VALUES(6,'Santa Monica Studio','USA',1999);
INSERT INTO DevCompany VALUES(7,'Sora Ltd','Japan',2005);
INSERT INTO DevCompany VALUES(8,'From Software','Japan',1986);
INSERT INTO DevCompany VALUES(9,'Kojima Productions','Japan',2005);
INSERT INTO DevCompany VALUES(10,'Ubisoft','France',1986);
CREATE TABLE Genre(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
Title VARCHAR(255) NOT NULL,
CONSTRAINT UIX_Title UNIQUE(Title)
);
INSERT INTO Genre VALUES(1,'Action');
INSERT INTO Genre VALUES(2,'Adventure');
INSERT INTO Genre VALUES(3,'RPG');
INSERT INTO Genre VALUES(4,'Horror');
INSERT INTO Genre VALUES(5,'Fighting');
INSERT INTO Genre VALUES(6,'Platformer');
INSERT INTO Genre VALUES(7,'Puzzle');
INSERT INTO Genre VALUES(8,'Sport');
INSERT INTO Genre VALUES(9,'Racing');
INSERT INTO Genre VALUES(10,'Strategy');
CREATE TABLE Game(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
Title VARCHAR(255) NOT NULL,
Rating INT NULL,
CreatorId INT NOT NULL,
DevCompanyId INT NOT NULL,
CONSTRAINT UIX_Title UNIQUE(Title),
CONSTRAINT FK_Game_CreatorId_2_Creator_Id FOREIGN KEY(CreatorId) REFERENCES Creator(Id),
CONSTRAINT FK_Game_DevCompanyId_2_DevCompany_Id FOREIGN KEY(DevCompanyId) REFERENCES DevCompany(Id)
);
INSERT INTO Game VALUES(1,'Super Mario Odyssey',97,3,1);
INSERT INTO Game VALUES(2,'Bloodborne',92,11,8);
INSERT INTO Game VALUES(3,'Sekiro',NULL,11,8);
INSERT INTO Game VALUES(4,'Devil May Cry 5',87,4,2);
INSERT INTO Game VALUES(5,'Kingdom Hearts 3',83,7,4);
INSERT INTO Game VALUES(6,'Legend of Zelda: Breath of the Wild',97,6,1);
INSERT INTO Game VALUES(7,'UNDERTALE',93,8,5);
INSERT INTO Game VALUES(8,'Bayonetta',90,5,3);
INSERT INTO Game VALUES(9,'Rayman Legends',87,13,10);
INSERT INTO Game VALUES(10,'Super Smash Brothers: Ultimate',93,10,1);
INSERT INTO Game VALUES(11,'God of War',94,9,6);
INSERT INTO Game VALUES(12,'Death Stranding',NULL,12,9);
CREATE TABLE GameGenre(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
GameId INT NOT NULL,
GenreId INT NOT NULL,
CONSTRAINT FK_GameGenre_GameId_2_Game_Id FOREIGN KEY(GameId) REFERENCES Game(Id),
CONSTRAINT FK_GameGenre_GenreId_2_Genre_Id FOREIGN KEY(GenreId) REFERENCES Genre(Id)
);
INSERT INTO GameGenre VALUES(1,1,6);
INSERT INTO GameGenre VALUES(2,1,2);
INSERT INTO GameGenre VALUES(3,2,1);
INSERT INTO GameGenre VALUES(4,2,3);
INSERT INTO GameGenre VALUES(5,2,4);
INSERT INTO GameGenre VALUES(6,3,1);
INSERT INTO GameGenre VALUES(7,3,3);
INSERT INTO GameGenre VALUES(8,4,1);
INSERT INTO GameGenre VALUES(9,4,5);
INSERT INTO GameGenre VALUES(10,5,1);
INSERT INTO GameGenre VALUES(11,5,3);
INSERT INTO GameGenre VALUES(12,6,1);
INSERT INTO GameGenre VALUES(13,6,2);
INSERT INTO GameGenre VALUES(14,7,3);
INSERT INTO GameGenre VALUES(15,7,7);
INSERT INTO GameGenre VALUES(16,8,1);
INSERT INTO GameGenre VALUES(17,8,5);
INSERT INTO GameGenre VALUES(18,9,6);
INSERT INTO GameGenre VALUES(19,10,5);
INSERT INTO GameGenre VALUES(20,11,1);
INSERT INTO GameGenre VALUES(21,11,2);
INSERT INTO GameGenre VALUES(22,12,2);
INSERT INTO GameGenre VALUES(23,12,1);
INSERT INTO GameGenre VALUES(24,12,4);
CREATE TABLE Distributed(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
GameId INT NOT NULL,
PublisherId INT NOT NULL,
Regions VARCHAR(255) NOT NULL,
CONSTRAINT FK_Distributed_GameId_2_Game_Id FOREIGN KEY(GameId) REFERENCES Game(Id),
CONSTRAINT FK_Distributed_PublisherId_2_Publisher_Id FOREIGN KEY(PublisherId) REFERENCES Publisher(Id)
);
INSERT INTO Distributed VALUES(2,1,3,'USA');
INSERT INTO Distributed VALUES(3,1,3,'Japan');
INSERT INTO Distributed VALUES(4,2,5,'USA');
INSERT INTO Distributed VALUES(5,2,5,'Japan');
INSERT INTO Distributed VALUES(6,3,5,'Japan');
INSERT INTO Distributed VALUES(7,3,6,'USA');
INSERT INTO Distributed VALUES(8,4,11,'USA');
INSERT INTO Distributed VALUES(9,4,11,'Japan');
INSERT INTO Distributed VALUES(10,5,2,'USA');
INSERT INTO Distributed VALUES(11,5,2,'Japan');
INSERT INTO Distributed VALUES(12,6,3,'USA');
INSERT INTO Distributed VALUES(13,6,3,'Japan');
INSERT INTO Distributed VALUES(14,7,4,'USA');
INSERT INTO Distributed VALUES(15,8,12,'USA');
INSERT INTO Distributed VALUES(16,8,3,'USA');
INSERT INTO Distributed VALUES(17,8,3,'Japan');
INSERT INTO Distributed VALUES(18,9,1,'USA');
INSERT INTO Distributed VALUES(19,10,3,'USA');
INSERT INTO Distributed VALUES(20,10,3,'Japan');
INSERT INTO Distributed VALUES(21,11,5,'USA');
INSERT INTO Distributed VALUES(22,11,5,'Japan');
INSERT INTO Distributed VALUES(23,12,5,'USA');
INSERT INTO Distributed VALUES(24,12,5,'Japan');
CREATE TABLE InteractsWith(
Id INTEGER PRIMARY KEY AUTOINCREMENT,
GameId INT NOT NULL,
ConsoleId INT NOT NULL,
ReleaseDate DATE NOT NULL,
CONSTRAINT FK_InteractsWith_GameId_2_Game_Id FOREIGN KEY(GameId) REFERENCES Game(Id),
CONSTRAINT FK_InteractsWith_ConsoleId_2_Console_Id FOREIGN KEY(ConsoleId) REFERENCES Console(Id)
);
INSERT INTO InteractsWith VALUES(1,1,1,'2017-10-27');
INSERT INTO InteractsWith VALUES(2,2,2,'2015-03-24');
INSERT INTO InteractsWith VALUES(3,3,2,'2019-03-22');
INSERT INTO InteractsWith VALUES(4,4,2,'2019-03-08');
INSERT INTO InteractsWith VALUES(5,4,3,'2019-03-08');
INSERT INTO InteractsWith VALUES(6,4,7,'2019-03-08');
INSERT INTO InteractsWith VALUES(7,5,2,'2019-01-29');
INSERT INTO InteractsWith VALUES(8,5,3,'2019-01-29');
INSERT INTO InteractsWith VALUES(9,6,1,'2017-03-03');
INSERT INTO InteractsWith VALUES(10,7,7,'2015-09-15');
INSERT INTO InteractsWith VALUES(11,7,2,'2017-08-15');
INSERT INTO InteractsWith VALUES(12,7,1,'2018-09-18');
INSERT INTO InteractsWith VALUES(13,8,10,'2010-01-05');
INSERT INTO InteractsWith VALUES(14,8,8,'2010-01-05');
INSERT INTO InteractsWith VALUES(15,8,1,'2018-02-16');
INSERT INTO InteractsWith VALUES(16,9,2,'2014-02-18');
INSERT INTO InteractsWith VALUES(17,9,1,'2017-09-12');
INSERT INTO InteractsWith VALUES(18,10,1,'2018-12-07');
INSERT INTO InteractsWith VALUES(19,11,2,'2018-04-20');
DELETE FROM sqlite_sequence;
INSERT INTO sqlite_sequence VALUES('Creator',13);
INSERT INTO sqlite_sequence VALUES('DevCompany',10);
INSERT INTO sqlite_sequence VALUES('Publisher',12);
INSERT INTO sqlite_sequence VALUES('Genre',10);
INSERT INTO sqlite_sequence VALUES('Console',10);
INSERT INTO sqlite_sequence VALUES('Game',12);
INSERT INTO sqlite_sequence VALUES('GameGenre',24);
INSERT INTO sqlite_sequence VALUES('Distributed',24);
INSERT INTO sqlite_sequence VALUES('InteractsWith',19);
COMMIT;

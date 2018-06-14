
## https://gist.github.com/datduyng/84e49d270d62637950a5fcc193885174
--
-- Queries to create extra table to add concertHall
--

DROP TABLE IF EXISTS `ConcertSongs`;
DROP TABLE IF EXISTS `Concert`;
DROP TABLE IF EXISTS `ConcertHall`;

-- create concert hall to prevent duplicate data 
CREATE TABLE ConcertHall(
	ConcertHallID INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	NameOfHall VARCHAR(255) NOT NULL DEFAULT 'na',
	Capacity INT NOT NULL
);

#2Write a statement to create the table Concert
## CREATE concert table
CREATE TABLE Concert(
	ConcertID INT PRIMARY KEY NOT NULL  AUTO_INCREMENT,
	BandID INT NOT NULL,
	ConcertDate DATE NOT NULL,
	ConcertHallID INT NOT NULL,
	NumOfTicketSold INT NOT NULL,
	FOREIGN KEY(BandID) REFERENCES Bands(BandID),
	FOREIGN KEY(ConcertHallID) REFERENCES ConcertHall(ConcertHallID)
);

#1Write a statement to create the table ConcertSongs
CREATE TABLE ConcertSongs(
	ConcertSongID INT PRIMARY KEY NOT NULL  AUTO_INCREMENT,
	SongID INT NOT NULL,
	ConcertID INT NOT NULL,
	FOREIGN KEY(concertID) REFERENCES Concert(ConcertID),
	FOREIGN KEY(SongID) REFERENCES Songs(SongID)
);


--
-- Use the new data base
--

#1. Write queries to insert at least two Concert records.
INSERT INTO ConcertHall(NameOfHall,Capacity) 
VAlUES ('The Opera',12000),('Nha Hat Lon',20000),
	('The Mega Dome',12000),('The Gorge',32000);
INSERT INTO Concert(BandID,ConcertDate,ConcertHallID,NumOfTicketSold)
VAlUES (52,'2018-09-05',1,5),
	(9,'2017-12-18',2,10),
	(2,'2018-01-13',3,20),
	(52,'2017-05-20',1,30);



#2. Write queries to associate at least 3 songs with each of the two concerts
INSERT INTO ConcertSongs(SongID,ConcertID) 
VALUES (1,1),(2,1),(3,1),(4,1),
	(5,2),(6,3),(7,4),(4,4);


#3. Write a select-join query to retrieve these new results and produce a playlist for each concert
SELECT cs.ConcertID,cs.SongID,s.SongTitle FROM ConcertSongs cs 
JOIN Songs s ON cs.SongID=s.SongID
GROUP BY ConcertID;

#4. Modify the query to include the name of the band playing the concert. # If such a query is not
# possible, explain why and sketch an alternative design in which in0 
# would  be possible.
SELECT c.BandID,c.ConcertDate,c.ConcertHallID,c.NumOfTicketSold,b.BandName
FROM Concert c JOIN Bands b ON b.BandID=c.BandID;



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
VAlUES ('The MEGA Dome',12000),('The Gorge',32000),
	('Hotel Concert Hall',5000),('Cruise Concert Hall',2000);
INSERT INTO Concert(BandID,ConcertDate,ConcertHallID,NumOfTicketSold)
VAlUES (50,'2018-09-05',1,5),
	(9,'2017-12-18',2,10),
	(2,'2018-01-13',3,20),
	(50,'2017-05-20',1,30);



#2. Write queries to associate at least 3 songs with each of the two concerts
INSERT INTO ConcertSongs(SongID,ConcertID) 
VALUES (1,1),(2,1),(3,1),(4,1),
	(5,2),(6,3),(7,4),(4,4);


#3. Write a select-join query to retrieve these new results and produce a playlist for each concert
SELECT cs.ConcertID,cs.SongID,s.SongTitle FROM ConcertSongs cs 
JOIN Songs s ON cs.SongID=s.SongID
ORDER BY cs.ConcertID;

#4. Modify the query to include the name of the band playing the concert. 
# If such a query is not possible, explain why and sketch an alternative design in which inshow 
# would  be possible.
SELECT c.BandID,c.ConcertDate,c.ConcertHallID,c.NumOfTicketSold,b.BandName
FROM Concert c JOIN Bands b ON b.BandID=c.BandID;


## Advance activities
SELECT b.BandName,b.BandID, COUNT(SongID) numOfSongs FROM AlbumSongs als 
JOIN Albums a ON als.AlbumID=a.AlbumID 
JOIN Bands b ON b.BandID = a.BandID
GROUP BY b.BandName,b.BandID
ORDER BY numOfSongs DESC,b.BandName;

INSERT INTO Concert(BandID,ConcertDate,ConcertHallID,NumOfTicketSold)
VAlUES (1,'2018-09-05',1,32000),
	(21,'2017-12-18',2,12000),
	(29,'2018-01-13',3,5000),
	(49,'2017-05-20',4,2000);


SELECT cs.ConcertID, cs.SongID, als.TrackLength FROM ConcertSongs cs 
JOIN Songs s ON cs.SongID=s.SongID 
JOIN AlbumSongs als ON als.SongID=s.SongID 
WHERE (TrackLength/60)>5; 

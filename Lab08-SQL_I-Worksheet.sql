
-- Querying Data 

-- 1. 
select MusicianFirstName as FirstName, MusicianLastName as LastName, MusicianCountry as Country from Musicians where MusicianCountry = 'USA';
select * from Musicians where MusicianCountry = 'UK' OR MusicianCountry = 'England' OR MusicianCountry = 'Britain';
select * from Songs order by SongTitle;
select AlbumID from Albums where AlbumTitle = 'Odelay';

-- 2-8. 
select count(*) as NumberOfAlbums from Albums where AlbumTitle like '%Love%';
select count(*) as NumberOfMusicians from Musicians where MusicianFirstName = 'John';
select sum(TrackLength) from AlbumSongs as alS join Albums as a on alS.AlbumID = a.AlbumID where AlbumTitle = 'I Hope You Win!';
select AlbumTitle, AlbumYear from Albums as a join Bands as b on a.BandID = b.BandID where BandName = 'Korn';
select TrackNumber, SongTitle from AlbumSongs as alS join Songs as s on alS.SongID = s.SongID join Albums as a on alS.AlbumID = a.AlbumID where AlbumTitle = 'Odelay' order by TrackNumber;
select SongTitle, AlbumTitle from Songs as s join AlbumSongs as alS on s.SongID = alS.SongID join Albums as a on alS.AlbumID = a.AlbumID join Bands as b on a.BandID = b.BandID where BandName = 'Linkin Park'; 
select SongTitle from Songs as s join AlbumSongs as alS on s.SongID = alS.SongID where AlbumID = null;

select AlbumTitle, count(*) as NumberOfTracks from Albums as a join AlbumSongs as alS on a.AlbumID = alS.AlbumID group by AlbumTitle;
select AlbumTitle, count(*) as NumberOfTracks from Albums as a join AlbumSongs as alS on a.AlbumID = alS.AlbumID group by AlbumTitle having NumberofTracks > 11;
select MusicianFirstName, MusicianLastName, count(*) as NumberOfSongs from Musicians as m join BandMusicians as bm on m.MusicianID = bm.MusicianID join Bands as b on bm.BandID = b.BandID join Albums as a on b.BandID = a.BandID join AlbumSongs as alS on a.AlbumID = alS.AlbumID where MusicianFirstName = 'Nick' and MusicianLastName = 'Carter'; 

# delete from AlbumSongs where AlbumID in (select AlbumID from Albums where AlbumTitle = 'War');
delete from Albums where AlbumTitle = 'Kid A';
delete from AlbumSongs where SongID in (select SongID from Songs where SongTitle = 'Paranoid Android');
delete from Songs where SongTitle = 'Paranoid Android';

# 10
update Albums Set AlbumTitle = 'Kid A' where AlbumTitle = 'Kid';
#11
insert into Bands(BandName) values ('Red Hot Chili Peppers');
insert into Albums(AlbumTitle, AlbumYear, BandID, AlbumNumber) values ('Californication', 1995,  (select BandID from Bands where BandName = 'Red Hot Chili Peppers'), 2);
insert into Songs(SongTitle) values ('Californication');
insert into Songs(SongTitle) values ('Road Trippin');
insert into AlbumSongs(SongID, AlbumID, TrackNumber, TrackLength) values ((select SongID from Songs where SongTitle = 'Californication'), (select AlbumID from Albums where AlbumTitle = 'Californication'), 1, 260);
insert into AlbumSongs(SongID, AlbumID, TrackNumber, TrackLength) values ((select SongID from Songs where SongTitle = 'Road Trippin'), (select AlbumID from Albums where AlbumTitle = 'Californication'), 2, 300);


 

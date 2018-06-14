# use user name 
use datduyn;

# insert a new band to database 
insert into Bands (BandName) value('One Direction');

## accidently create 2 band name 'One direction' so deltet one
delete from Bands where BandName='One Direction' AND BandID > 52;


## Insert a new album 
# use inner query to find BandID
insert into Albums(AlbumTitle,AlbumYear,BandID,AlbumNumber) value('Perfect',2015,(select BandID from Bands where BandName='One Direction'),23);


# nested insert t insert 2 album song and songsID
insert into AlbumSongs(
(select SongID from (insert into Songs(SongTitle) value ('Story Of My Life')))),
(select AlbumID from Album where AlbumTitle='Perfect'),13,4);
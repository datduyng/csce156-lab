package edu.unl.cse.sql;

import java.sql.*;

import edu.unl.cse.model.*;

import java.util.*;

public class SongAdder {
	private List<String> songs;
	private Album album;
	
	public SongAdder(List<String> songs, Album album)
	{
		this.songs = songs;
		this.album = album;
	}
	
	public void addSongs()
	{
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String getAlbumID = "select AlbumID from Albums where AlbumTitle like ?";
		String safeUpdates = "set SQL_SAFE_UPDATES = ?";
		
		try
		{
			PreparedStatement safePS = conn.prepareStatement(safeUpdates);
			safePS.setInt(1, 0);
			safePS.executeUpdate();
			
			ps = conn.prepareStatement(getAlbumID);
			ps.setString(1, this.album.getTitle());
			
			rs = ps.executeQuery();
			
			rs.next();
			int albumID = rs.getInt("AlbumID");
			rs.close();
			ps.close();
			
			String deleteSongs = "delete albs, s from AlbumSongs albs join Songs s on s.SongID = albs.SongID where AlbumID = ?";
			
			ps = conn.prepareStatement(deleteSongs);
			ps.setInt(1, albumID);
			ps.executeUpdate();
			ps.close();			
			
			safePS.setInt(1, 1);
			safePS.executeUpdate();
			safePS.close();
			
			String insertSongs = "insert into Songs (SongTitle) values (?)";
			String selectSong = "select SongID from Songs s join Albums albs where SongTitle like ? and albs.AlbumID = ?";
			String insertAlbumSongs = "insert into AlbumSongs (SongID, AlbumID) values (?, ?);";
			ps = conn.prepareStatement(insertSongs);
			PreparedStatement albs = conn.prepareStatement(insertAlbumSongs),
					songPS = conn.prepareStatement(selectSong);
			albs.setInt(2, albumID);
			songPS.setInt(2, albumID);
			int songID;
			for (String song: this.songs)
			{
				ps.setString(1, song);
				ps.executeUpdate();
				songPS.setString(1, song);
				ResultSet songRS = songPS.executeQuery();
				if (songRS.next())
				{
					songID = songRS.getInt("SongID");
				}
				else
				{
					break;
				}
				albs.setInt(1, songID);
				albs.executeUpdate();
			}
			ps.close();
			albs.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}

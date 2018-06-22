package edu.unl.cse.sql;

import edu.unl.cse.model.*;

import java.sql.*;
import java.util.*;

public class SongBean {
	
	private Album album;
	
	public SongBean(Album a)
	{
		this.album = a;
	}
	
	public List<String> getSongs()
	{
		Connection conn = DatabaseInfo.getConnection();
		List<String> songs = new ArrayList<String>();
		
		PreparedStatement ps;
		ResultSet rs;
		
		String getAlbumID = "select AlbumID from Albums where AlbumTitle like ?";
		
		try
		{
			ps = conn.prepareStatement(getAlbumID);
			ps.setString(1, this.album.getTitle());
			
			rs = ps.executeQuery();
			
			rs.next();
			int albumID = rs.getInt("AlbumID");
			rs.close();
			ps.close();
			
			String getSongs = "select SongTitle from Songs s join AlbumSongs albson on albson.SongID = s.SongID where albson.AlbumID = ?";
			ps = conn.prepareStatement(getSongs);
			
			ps.setInt(1, albumID);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				songs.add(rs.getString("SongTitle"));
			}
			
			rs.close();
			ps.close();
			conn.close();
		}
		catch (SQLException e) 
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return songs;
	}
	
}

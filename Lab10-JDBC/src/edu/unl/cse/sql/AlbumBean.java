package edu.unl.cse.sql;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.unl.cse.model.Album;
import edu.unl.cse.model.Band;

public class AlbumBean {

	public Album getDetailedAlbum(String albumTitle)
	{
		/*
		 * Query the database and get the album with the 
		 * specified ID, create an Album object with all
		 * details specified
		 */
		//TODO: implement this method
		String query = "SELECT * FROM Albums WHERE AlbumTitle=?;";
		//Album(String title, Integer year, Band band, Integer albumNumber);
		
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;

		Album a = null;
		try {
			ps = conn.prepareStatement(query);
			ps.setString(1, albumTitle);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("AlbumTitle");
				int year = rs.getInt("AlbumYear");
				int bandID = rs.getInt("BandID");
				int albumNumber = rs.getInt("AlbumNumber");
				int albumID = rs.getInt("AlbumID");
				
				BandBean bb = new BandBean();
				Band newBand = bb.getBand(bandID);
				
				a = new Album(title,year,newBand,albumNumber);
				a.setAlbumId(albumID);
//				System.out.println(String.format("%s,%d,%s,%d,%d", title,year,newBand.getName(),albumNumber,albumID));
				

			}
			rs.close();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
			

		return a;
	}
	
	public List<Album> getAlbums() {

		String query = "SELECT AlbumTitle FROM Albums;";
		
		Connection conn = DatabaseInfo.getConnection();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Album> albumList = new ArrayList<Album>();

		Album a = null;
		try {
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String title = rs.getString("AlbumTitle");
				albumList.add(this.getDetailedAlbum(title));
			}
			
			rs.close();
			ps.close();
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		
				
		return albumList;
	}
	
	/**
	 * Before you test your Java App, you can
	 * test your method implementations using this main:
	 * @param args 
	 */
	public static void main(String args[]) {
		
		AlbumAdder aa = new AlbumAdder("asd","dominic","123","123");
		if(aa.AddAlbumToDatabase()) {
			System.out.println("aa is tru");
		}else {
			System.out.println("aa is false");
		}
	
	
		AlbumBean albumBean = new AlbumBean();
		albumBean.getDetailedAlbum("Odelay");
		System.out.println("Albums: ");
		AlbumBean ab = new AlbumBean();
		for(Album a : ab.getAlbums()) {
			System.out.println("\t"+a.getTitle()+" (id = "+a.getAlbumId()+")");
		}
		
		Album da = null; 
		try {
			da = ab.getAlbums().iterator().next();
		} catch (Exception e) {
			System.out.println("No albums returned in the list");
		}
		if(da != null) {
			System.out.println(da.getTitle()+" details: ");
			for(String trackTitle : da.getSongTitles()) {
				System.out.println("\t"+trackTitle);
			}
		}
	}
}

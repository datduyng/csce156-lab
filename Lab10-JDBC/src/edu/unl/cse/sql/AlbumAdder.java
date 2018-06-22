package edu.unl.cse.sql;

import java.sql.*;

import edu.unl.cse.model.Band;

public class AlbumAdder {

	private String  albumTitle;
	private String  bandName;
	private String  albumYear;
	private String  albumNumber;
	
	public AlbumAdder(String albumTitle, String bandName, String albumYear, String albumNumber) {
		this.setAlbumTitle(albumTitle);
		this.setBandName(bandName);  
		this.setAlbumYear(albumYear); 
		this.setAlbumNumber(albumNumber);
	}

	/**
	 * Adds the album (and band if necessary) to the database and returns true if the insert was
	 * successful, false otherwise.
	 * @return
	 * @throws SQLException 
	 */
	public boolean AddAlbumToDatabase() {
		Connection conn = DatabaseInfo.getConnection();
		System.out.println("Connected to DB");
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;
		ResultSet rs = null;
		ResultSet rs2 = null;
		int lastID = 0;

		String lastIdQuery = "SELECT LAST_INTSERT_ID() FROM Bands;";
		
		//get band id given band name 
		BandBean bb = new BandBean();
		Band newBand = bb.getBand(this.bandName);
		System.out.println("created band");
		if(newBand == null) {
			try {
				ps2 = conn.prepareStatement(lastIdQuery);
				rs2 = ps2.executeQuery();
				
				while(rs2.next()) {
					lastID = rs2.getInt("BandID");
					System.out.println(lastID);
				}
				ps2.close();
				rs2.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			//System.out.println("lastID"+ lastID);
			
			BandAdder ba = new BandAdder( lastID+1, this.bandName, null);
			ba.addBandToDatabase();
		}else {
			lastID = newBand.getBandId();
		}
		
		try
		{
			String addAlbumQuery = "INSERT INTO Albums(AlbumTitle,BandID,AlbumYear,AlbumNumber) VALUES"
					+this.albumTitle+","+(lastID+1)+","+this.getAlbumYear()+","+this.getAlbumNumber()+";";
			ps = conn.prepareStatement(addAlbumQuery);
			rs = ps.executeQuery();
			
			conn.close();
			ps.close();
			rs.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	
	public boolean removeAlbumFromDatabase()
	{
		return false;
	}

	public String getAlbumTitle() {
		return albumTitle;
	}

	public void setAlbumTitle(String albumTitle) {
		this.albumTitle = albumTitle;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

	public int getAlbumYear() {
		return Integer.parseInt(albumYear);
	}

	public void setAlbumYear(String albumYear) {
		this.albumYear = albumYear;
	}

	public int getAlbumNumber() {
		return Integer.parseInt(albumNumber);
	}

	public void setAlbumNumber(String albumNumber) {
		this.albumNumber = albumNumber;
	}


}

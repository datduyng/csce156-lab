package edu.unl.cse.sql;

import java.util.List;
import java.sql.*;

import edu.unl.cse.model.Member;

public class BandAdder {
	private Integer bandId;
	private String name;
	private List<Member> members;
	
	public BandAdder(Integer id, String name, List<Member> members)
	{
		this.bandId = id;
		this.name = name;
		this.members = members;
	}
	
	public boolean addBandToDatabase()
	{
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String bandNameQuery = "select BandID from Bands where BandName like ?;";
		try
		{
			ps = conn.prepareStatement(bandNameQuery);
			ps.setString(1, this.name);
			rs = ps.executeQuery();
			
			if (rs.next())
			{
				this.bandId = rs.getInt("BandID");
				String removeMembers = "delete from BandMusicians where BandID = ?";
				rs.close();
				ps.close();
				
				ps = conn.prepareStatement(removeMembers);
				ps.setInt(1, this.bandId);
				ps.executeUpdate();
				ps.close();
			}
			else
			{
				rs.close();
				ps.close();
				
				String insertBand = "insert into Bands (BandName) values (?)";
				ps = conn.prepareStatement(insertBand);
				ps.setString(1, this.name);
				ps.executeUpdate();
				ps.close();
				
				ps = conn.prepareStatement(bandNameQuery);
				ps.setString(1, this.name);
				rs = ps.executeQuery();
				
				rs.next();
				this.bandId = rs.getInt("BandID");
			}
			

			String selectMusicians = "select MusicianID from Musicians where MusicianFirstName like ? && MusicianLastName like ? && MusicianCountry like ?";
			PreparedStatement selectPS = conn.prepareStatement(selectMusicians);
			String insertMemberJoin = "insert into BandMusicians (MusicianID, BandID) values (?,?)";
			PreparedStatement insertJoinTablePS = conn.prepareStatement(insertMemberJoin);
			String insertMusician = "insert into Musicians (MusicianFirstName, MusicianLastName, MusicianCountry) values (?,?,?)";
			PreparedStatement insertMusicianPS = conn.prepareStatement(insertMusician);
			
			for(Member m: this.members)
			{
				selectPS.setString(1, m.getFirstName());
				selectPS.setString(2, m.getLastName());
				selectPS.setString(3, m.getCountry());
				rs = selectPS.executeQuery();
				int musicianID;
				
				if (rs.next())
				{
					musicianID = rs.getInt("MusicianID");
					rs.close();
				}
				else
				{
					rs.close();
					
					insertMusicianPS.setString(1, m.getFirstName());
					insertMusicianPS.setString(2, m.getLastName());
					insertMusicianPS.setString(3, m.getCountry());
					insertMusicianPS.executeUpdate();
					
					rs = selectPS.executeQuery();
					rs.next();
					musicianID = rs.getInt("MusicianID");
					rs.close();
				}
				
				insertJoinTablePS.setInt(1, musicianID);
				insertJoinTablePS.setInt(2, this.bandId);
				insertJoinTablePS.executeUpdate();
			}
			conn.close();
		}
		catch (SQLException e)
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return true;
	}
}

package edu.unl.cse.model;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private Integer albumId;
	private String title;
	private Integer year;
	private Band band;
	private Integer albumNumber;
	private List<String> songTitles = new ArrayList<String>();
	
	public Album()
	{
		
	}
	
	public Album(String title, Integer year, Band band, Integer albumNumber) {
		this.title = title;
		this.year = year;
		this.band = band;
		this.albumNumber = albumNumber;
	}
	
	public Integer getAlbumId() {
		return albumId;
	}
	public void setAlbumId(Integer albumId) {
		this.albumId = albumId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getAlbumNumber() {
		return albumNumber;
	}
	public void setAlbumNumber(Integer albumNumber) {
		this.albumNumber = albumNumber;
	}
	public Band getBand() {
		return band;
	}
	public void setBand(Band band) {
		this.band = band;
	}
	public List<String> getSongTitles() {
		return songTitles;
	}
	public void setSongTitles(List<String> songTitles) {
		this.songTitles = songTitles;
	}
	
	@Override public String toString() {
		return this.albumId + ","+ this.getTitle();
	}
	
	
}

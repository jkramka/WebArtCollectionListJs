package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ Entity
@Table(name="artworks")
public class ListItem {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	@Column(name="artist")
	private String artist;
	@Column(name="item")
	private String item;
	@Column(name="year")
	private int year;


public ListItem() {
	super();
	// TODO Auto-generated constructor stub
}


public ListItem(String artist, String item, int year) {
	super();
	this.artist = artist;
	this.item = item;
	this.year = year;
}



public int getId() {
	return id;
}



public void setId(int id) {
	this.id = id;
}


public String getArtist() {
	return artist;
}


public void setArtist(String artist) {
	this.artist = artist;
}


public String getItem() {
	return item;
}


public void setItem(String item) {
	this.item = item;
}


public int getYear() {
	return year;
}


public void setYear(int year) {
	this.year = year;
}



@Override
public String toString() {
	return "ListItem [id=" + id + ", artist=" + artist + ", item=" + item + ", year=" + year + "]";
}

public String returnItemDetails() {
	return artist + ":" + item + ":" + year;
}

}



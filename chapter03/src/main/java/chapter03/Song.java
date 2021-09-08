package chapter03;

public class Song {
	private String title;
	private String artist;
	private String album;
	private String composer;
	private int year;
	private int track;
    
	public Song(String title, String artist, String composer, String album, int year, int track) {
		this.title = title;
		this.artist = artist;
		this.composer = composer;
		this.album = album;
		this.year = year;
		this.track = track;
		// some code....
	}
	public Song(String title, String artist) {
		//this.title = title;
		//this.artist = artist;
		// some code....  -> 코드 중복 발생
		this(title, artist, null, null, 0, 0); // this키워드를 사용해서 다른 생성자를 사용가능
		
	}
	
	public void show() {
		System.out.println(this.artist +" "+ this.title + "( " 
	                           + this.album + ", " 
	                           + this.year + ", " + this.track
				               + "번 track, " + this.composer + " 작곡)");
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getComposer() {
		return composer;
	}

	public void setComposer(String composer) {
		this.composer = composer;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTrack() {
		return track;
	}

	public void setTrack(int track) {
		this.track = track;
	}

}

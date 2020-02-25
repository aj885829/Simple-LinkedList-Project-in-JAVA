import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	private String title;
	private String artist;
	private ArrayList<Song> albumList;

	// album's constructor which require [title of song, and the artist's name ]
	public Album(String title, String artist) {
		this.title = title;
		this.artist = artist;
		albumList = new ArrayList<Song>();
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	// this function create a Song object and added it into the ArrayList
	// [in other world, creating a song and added it to the album].
	public boolean addSongtoAlbum(String title, double duration) {
		// findSong(title) ---> return an object of Song if it existe .(check it's
		// implementation below)
		Song song = findSong(title);
		if (song == null) {
			albumList.add(new Song(title, duration));
			return true;
		}
		return false;
	}

	// this function check if a song existe inside in the ArrayList (which is the
	// album)
	// if song existe then return the object, else return null.
	private Song findSong(String title2) {
		for (Song song : albumList) {
			if (song.getTitle().equals(title2)) {
				return song;
			}
		}
		return null;
	}

	// adding songs from the Album to the playList, using indexing (trackNumber).
	public void addtoPlayList(int trackNumber, LinkedList<Song> playlist) {
		int index = trackNumber - 1;
		if ((index >= 0) && (index <= albumList.size())) {
			playlist.add(albumList.get(index));
		} else {
			System.out.println("tracking number may be out of range !");
		}
	}

	// adding songs from the Album to the playList, using the title of the song.
	public void addtoPlayList(String title, LinkedList<Song> playlist) {
		Song song = findSong(title);
		if (song != null) {
			playlist.add(song);
		} else {
			System.out.println("No such a song with the name [" + title + "] in the album [" + getTitle() + "]");
		}
	}

}

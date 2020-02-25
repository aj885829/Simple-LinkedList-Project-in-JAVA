import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		// here we save all the albums
		ArrayList<Album> albumsList = new ArrayList<Album>();

		// album 1
		Album album = new Album("Shamat", "Lina Shamamyan");
		album.addSongtoAlbum("Yomma Lala", 5.04);
		album.addSongtoAlbum("Daouny Ajoud", 8.01);
		album.addSongtoAlbum("Seher (Magic)", 4.30);
		album.addSongtoAlbum("Ya Msafera", 5.32);

		// album 2
		Album album2 = new Album("Hal Asmar Ellon", "Lina Shamamyan");
		album2.addSongtoAlbum("Bali maak", 4.01);
		album2.addSongtoAlbum("Lama Bada yatathana", 4.07);
		album2.addSongtoAlbum("Al rozana", 3.07);

		// adding albums to the ArrayList
		albumsList.add(album);
		albumsList.add(album2);

		// this is the playlist
		LinkedList<Song> playlist = new LinkedList<Song>();

		// adding songs from different albums to the playList
		albumsList.get(0).addtoPlayList("Yomma Lala", playlist);
		albumsList.get(0).addtoPlayList(3, playlist);
		albumsList.get(1).addtoPlayList(2, playlist);
		albumsList.get(1).addtoPlayList(1, playlist);
		albumsList.get(1).addtoPlayList(3, playlist);

		boolean quit = false;
		boolean goingforward = true; // this boolean helps to move between songs
		Scanner scanner = new Scanner(System.in);

		// creating iterator which return a song at a time
		ListIterator<Song> iterator = playlist.listIterator();

		// show the list of options that the program gives u
		printMenu();
		// apply this, while the program is still running.
		while (!quit) {

			int action = scanner.nextInt();
			scanner.nextLine();

			switch (action) {
			case 0:
				// quit program.
				System.out.println("Quiting program .");
				scanner.close();
				quit = true;
				break;

			case 1:
				// go forward to the next song.
				if (!goingforward) {
					if (iterator.hasNext()) {
						iterator.next();
					}
					goingforward = true;
				}
				if (iterator.hasNext()) {
					System.out.println("Now playing : " + iterator.next().toString());
				} else {
					System.out.println("Reached the ends of the playList.");
					goingforward = false;
				}
				break;

			case 2:
				// go backward to the previous song.
				if (goingforward) {
					if (iterator.hasPrevious()) {
						iterator.previous();
					}
					goingforward = false;
				}
				if (iterator.hasPrevious()) {
					System.out.println("Now playing : " + iterator.previous().getTitle());
				} else {
					System.out.println("we are at the top of the playList");
				}
				break;

			case 3:
				// if we are going forward
				if (goingforward) {
					if (iterator.hasPrevious()) {
						System.out.println("replaying : " + iterator.previous().getTitle());
						goingforward = false;
					} else {
						System.out.println("we are at the top of the playList");
					}

				} else { // if we aren't going forward
					if (iterator.hasNext()) {
						System.out.println("Now replaying " + iterator.next().getTitle());
						goingforward = true;
					} else {
						System.out.println("We are at the end of the playList.");
					}
				}
				break;

			case 4:
				// print all songs in the playList.
				printList(playlist);
				break;
			case 5:
				// show list of options.
				printMenu();
				break;
			}
		}

	}

	// print all songs in the playList.
	private static void printList(LinkedList<Song> playlist) {
		Iterator<Song> iterator = playlist.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			System.out.println(i + 1 + "--> " + iterator.next().toString());
		}
	}

	// show list of options.
	private static void printMenu() {
		System.out.println("----- List of options ----- \n" + "0 - to quit program \n" + "1 - to play next song \n"
				+ "2 - to play the previous song \n" + "3 - to replay the song \n"
				+ "4 - to print all songs in this playList. \n" + "5 - to show this list of options.");

	}

}

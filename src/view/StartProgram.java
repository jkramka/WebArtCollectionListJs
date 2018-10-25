package view;

import java.util.List;
import java.util.Scanner;

import controller.ListItemHelper;
import model.ListItem;

public class StartProgram {

		static Scanner in = new Scanner(System.in);
		static ListItemHelper lih = new ListItemHelper();
		 
        //this adds an item to the database
		private static void addAnItem() {
			// TODO Auto-generated method stub
			System.out.print("Enter a artist: ");
			String artist = in.nextLine();
			System.out.print("Enter an item: ");
			String item = in.nextLine();
			System.out.print("Enter the artworks year: ");
			int year = in.nextInt();
			ListItem toAdd = new ListItem(artist, item, year);
	        lih.insertItem(toAdd);
		}

		//this method deletes an item from the database
		private static void deleteAnItem() {
			
			System.out.print("Enter the artist to delete: ");
			String artist = in.nextLine();
			System.out.print("Enter the item to delete: ");
			String item = in.nextLine();
			System.out.print("Enter the artworks year to delete: ");
			int year = in.nextInt();
            ListItem toDelete = new ListItem(artist, item, year);
			lih.deleteItem(toDelete);
		}

		private static void editAnItem() {
			
			System.out.println("How would you like to search? ");
			System.out.println("1 : Search by Artist");
			System.out.println("2 : Search by Item");
			System.out.println("3 : Search by year");
			
			int searchBy = in.nextInt();
			in.nextLine();
			List<ListItem> foundItems;
			if (searchBy == 1) {
				System.out.print("Enter the artist name: ");
				String artistName = in.nextLine();
				foundItems = lih.searchForItemByArtist(artistName);
			} else if (searchBy == 2) {
				System.out.print("Enter the item: ");
				String itemName = in.nextLine();
				foundItems = lih.searchForItemByItem(itemName);
			} else {
				System.out.print("Enter the year: ");
				int year = in.nextInt();
				foundItems = lih.searchForItemByYear(year);
			}
 			if (!foundItems.isEmpty()) {
				System.out.println("Found Results.");
				for (ListItem l : foundItems) {
					System.out.println("ID: " + l.getId() + " - " + l.returnItemDetails());
				}
				System.out.print("Which ID to edit: ");
				int idToEdit = in.nextInt();
 				ListItem toEdit = lih.searchForItemById(idToEdit);
				System.out.println("Retrieved " + toEdit.getItem() + " from " + toEdit.getArtist());
				System.out.println("1 : Update Artist");
				System.out.println("2 : Update Item");
				System.out.println("3 : Update artwork's year");
				int update = in.nextInt();
				in.nextLine();
 				if (update == 1) {
					System.out.print("New Artist: ");
					String newArtist = in.nextLine();
					toEdit.setArtist(newArtist);
					System.out.println("Artist has been changed to : " + newArtist);
				} else if (update == 2) {
					System.out.print("New Item: ");
					String newItem = in.nextLine();
					toEdit.setItem(newItem);
					System.out.println("Item has been changed to : " + newItem);
				} else {
					System.out.print("Correct year of artwork: ");
					int newYear = in.nextInt();
					toEdit.setYear(newYear);
					System.out.println("Year has been changed to : " + newYear);
					}
 				lih.updateItem(toEdit);
 			} else {
				System.out.println("---- No results found");
			}
 		}
 		public static void main(String[] args) {
			// TODO Auto-generated method stub
			runMenu();
 		}
 		public static void runMenu() {
			boolean goAgain = true;
			System.out.println("--- Welcome to our awesome shopping list! ---");
			while (goAgain) {
				System.out.println("*  Select an item:");
				System.out.println("*  1 -- Add an artwork");
				System.out.println("*  2 -- Edit an artwork");
				System.out.println("*  3 -- Delete an artwork");
				System.out.println("*  4 -- View the list");
				System.out.println("*  5 -- Exit the awesome program");
				System.out.print("*  Your selection: ");
				int selection = in.nextInt();
				in.nextLine();
 				if (selection == 1) {
					addAnItem();
				} else if (selection == 2) {
					editAnItem();
				} else if (selection == 3) {
					deleteAnItem();
				} else if (selection == 4) {
					viewTheList();
				} else {
					lih.cleanUp();
					System.out.println("   Goodbye!   ");
					goAgain = false;
				}
 			}
 		}
 		private static void viewTheList() {
			
			List<ListItem> allItems = lih.showAllItems();
			for(ListItem l : allItems){
				System.out.println(l.returnItemDetails());
			}
 		}
}

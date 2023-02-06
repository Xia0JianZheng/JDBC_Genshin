package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Menu {
	private int option;

	public Menu() {
		super();
	}

	public int mainMenu() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		do {
			System.out.println("-----------------------------------");
			System.out.println("-	      Table Menu    	  -");
			System.out.println("-----------------------------------");
			System.out.println("1. Add the Tables");
			System.out.println("2. Remove the Tables");
			System.out.println("-----------------------------------");
			System.out.println("-	      Character Menu    	  -");
			System.out.println("-----------------------------------");
			System.out.println("3. Add a Character");
			System.out.println("4. Add an Characters using CSV File");
			System.out.println("5. Show all the Characters");
			System.out.println("6. Show a character with name");
			System.out.println("7. Show all characters with region name");
			System.out.println("8. show all characters with element");
			System.out.println("9. show all characters with weapon type");
			System.out.println("10. Delete a Character");
			System.out.println("-----------------------------------");
			System.out.println("-	      Weapon Menu       	  -");
			System.out.println("-----------------------------------");
			System.out.println("11. Add a Weapon");
			System.out.println("12. Add an Weapons using CSV File");
			System.out.println("13. Show all the Weapons");
			System.out.println("14. Show a specific Weapon");
			System.out.println("15. show all Weapons with weapon type");
			System.out.println("16. Delete a Weapon");
			System.out.println("-----------------------------------");
			System.out.println("-	      Artifact Menu     	  -");
			System.out.println("-----------------------------------");
			System.out.println("17. Add a Artifact");
			System.out.println("18. Add an Artifacts using CSV File");
			System.out.println("19. Show all the Artifacts");
			System.out.println("20. Show a specific Artifact");
			System.out.println("21. Delete a Artifact");
			System.out.println("22. Quit");

			System.out.println("Choose a option : ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Ivalid option");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10 && option != 11 && option != 12 && option != 13 && option != 14 && option != 15 && option != 16 && option != 17
				&& option != 18 && option != 19 && option != 20 && option != 21 && option != 22 && option != 23);

		return option;
	}

}

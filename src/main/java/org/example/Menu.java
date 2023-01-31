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
			System.out.println("-	      Character Menu    	  -");
			System.out.println("-----------------------------------");
			System.out.println("1. Add a Character");
			System.out.println("2. Add an Characters using CSV File");
			System.out.println("3. Show all the Characters");
			System.out.println("4. Show a specific character");
			System.out.println("5. Delete a Character");
			System.out.println("6. Delete a Multiples Characters");
			System.out.println("-----------------------------------");
			System.out.println("-	      Weapon Menu       	  -");
			System.out.println("-----------------------------------");
			System.out.println("7. Add a Weapon");
			System.out.println("8. Add an Weapons using CSV File");
			System.out.println("9. Show all the Weapons");
			System.out.println("10. Show a specific Weapon");
			System.out.println("11. Delete a Weapon");
			System.out.println("12. Delete a Multiples Weapons");
			System.out.println("-----------------------------------");
			System.out.println("-	      Artifact Menu     	  -");
			System.out.println("-----------------------------------");
			System.out.println("13. Add a Artifact");
			System.out.println("14. Add an Artifacts using CSV File");
			System.out.println("15. Show all the Artifacts");
			System.out.println("16. Show a specific Artifact");
			System.out.println("17. Delete a Artifact");
			System.out.println("18. Delete a Multiples Artifacts");

			System.out.println("Choose a option : ");
			try {
				option = Integer.parseInt(br.readLine());
			} catch (NumberFormatException | IOException e) {
				System.out.println("Ivalid option");
				e.printStackTrace();

			}

		} while (option != 1 && option != 2 && option != 3 && option != 4 && option != 5 && option != 6 && option != 7
				&& option != 8 && option != 9 && option != 10);

		return option;
	}

}

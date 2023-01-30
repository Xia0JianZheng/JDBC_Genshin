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

			System.out.println(" \nMENU PRINCIPAL \n");

			System.out.println("1. Show all the Characters");
			System.out.println("2. Add a Character");
			System.out.println("3. Delete a Character");
			System.out.println("4. Show all the Weapons");
			System.out.println("5. Add a Weapon");
			System.out.println("6. Delete a Weapon");
			System.out.println("7. Show all the Artifacts");
			System.out.println("8. Add a Artifact");
			System.out.println("9. Delete a Artifact");
			System.out.println("10. Quit");
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

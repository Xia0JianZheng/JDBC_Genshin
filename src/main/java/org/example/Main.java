package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		Menu menu = new Menu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();

		WeaponController weaponController = new WeaponController(c);
		CharacterController characterController = new CharacterController(c);

		int option = menu.mainMenu();
		while (option > 0 && option < 11) {
			switch (option) {
			case 1:
				characterController.addCharacter();
				break;
			case 2:
				characterController.addCharacterUsingCSV();
				break;
			case 3:
				characterController.showAllCharacters();
				break;
			case 4:
				characterController.showSpecificCharacter();
				break;
			case 5:
				characterController.showCharacterWithRegion();
				break;
			case 6:

				break;

			case 7:

				break;

			case 8:
				characterController.removeOneCharacter();
				break;

			case 9:

				break;

			case 10:

				break;

			default:
				System.out.println("Introdueixi una de les opcions anteriors");
				break;

			}
			option = menu.mainMenu();
		}

	}

}

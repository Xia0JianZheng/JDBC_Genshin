package org.example;

import java.awt.desktop.ScreenSleepEvent;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws IOException, SQLException, ParseException {
		Menu menu = new Menu();
		
		ConnectionFactory connectionFactory = ConnectionFactory.getInstance();
		Connection c = connectionFactory.connect();

		TablesController tablesController = new TablesController(c);
		CharacterController characterController = new CharacterController(c);
		WeaponController weaponController = new WeaponController(c);
		ArtifactController artifactController = new ArtifactController(c);

		int option = menu.mainMenu();
		while (option > 0 && option < 23) {
			switch (option) {
				case 1 -> tablesController.addAllTables();
				case 2 -> tablesController.removeAllTables();
				case 3 -> characterController.addCharacter();
				case 4 -> characterController.addCharacterUsingCSV();
				case 5 -> characterController.showAllCharacters();
				case 6 -> characterController.showSpecificCharacter();
				case 7 -> characterController.showCharacterWithRegion();
				case 8 -> characterController.showCharacterWithElement();
				case 9 -> characterController.showCharacterWithWeaponType();
				case 10 -> characterController.removeOneCharacter();
				case 11 -> weaponController.addWeapon();
				case 12 -> weaponController.addWeaponUsingCSV();
				case 13 -> weaponController.showAllWeapons();
				case 14 -> weaponController.showSpecificWeapon();
				case 15 -> weaponController.showWeaponWithType();
				case 16 -> weaponController.removeOneWeapon();
				case 17 -> artifactController.addArtifactSet();
				case 18 -> artifactController.addArtifactSetUsingCSV();
				case 19 -> artifactController.showAllArtifacts();
				case 20 -> artifactController.showSpecificArtifact();
				case 21 -> artifactController.removeOneArtifactSet();
				case 22 -> {
					return;
				}
				default -> System.out.println("option not found, try again");
			}
			option = menu.mainMenu();
		}
	}

}

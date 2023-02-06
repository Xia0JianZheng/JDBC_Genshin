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

		WeaponController weaponController = new WeaponController(c);
		CharacterController characterController = new CharacterController(c);
		ArtifactController artifactController = new ArtifactController(c);

		int option = menu.mainMenu();
		while (option > 0 && option < 11) {
			switch (option) {
				case 1 -> characterController.addCharacter();
				case 2 -> characterController.addCharacterUsingCSV();
				case 3 -> characterController.showAllCharacters();
				case 4 -> characterController.showSpecificCharacter();
				case 5 -> characterController.showCharacterWithRegion();
				case 6 -> characterController.showCharacterWithElement();
				case 7 -> characterController.showCharacterWithWeaponType();
				case 8 -> characterController.removeOneCharacter();
				case 9 -> weaponController.addWeapon();
				case 10 -> weaponController.addWeaponUsingCSV();
				case 11 -> weaponController.showAllWeapons();
				case 12 -> weaponController.showSpecificWeapon();
				case 13 -> weaponController.showWeaponWithType();
				case 14 -> weaponController.removeOneWeapon();
				case 15 -> artifactController.addArtifactSet();
				case 16 -> artifactController.addArtifactSetUsingCSV();
				case 17 -> artifactController.showAllArtifacts();
				case 18 -> artifactController.showSpecificArtifact();
				case 19 -> artifactController.removeOneArtifactSet();
				default -> System.out.println("option not found, try again");
			}
			option = menu.mainMenu();
		}

	}

}

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

		while (option != 5) {
			switch (option) {
				case 1 -> {
					int tableOption = menu.tableMenu();
					while (tableOption != 3){
						switch (tableOption){
							case 1 -> tablesController.addAllTables();
							case 2 -> tablesController.removeAllTables();
						}
						tableOption = menu.tableMenu();
					}
				}
				case 2 -> {
					int characterOption = menu.characterMenu();
					while (characterOption != 9){
						switch (characterOption){
							case 1 -> characterController.addCharacter();
							case 2 -> characterController.addCharacterUsingCSV();
							case 3 -> characterController.showAllCharacters();
							case 4 -> characterController.showSpecificCharacter();
							case 5 -> characterController.showCharacterWithRegion();
							case 6 -> characterController.showCharacterWithElement();
							case 7 -> characterController.showCharacterWithWeaponType();
							case 8 -> characterController.removeOneCharacter();
							default -> System.out.println("option not found, try again");
						}
						characterOption = menu.characterMenu();
					}
				}
				case 3 -> {
					int weaponOption = menu.weaponMenu();
					while (weaponOption != 7){
						switch (weaponOption){
							case 1 -> weaponController.addWeapon();
							case 2 -> weaponController.addWeaponUsingCSV();
							case 3 -> weaponController.showAllWeapons();
							case 4 -> weaponController.showSpecificWeapon();
							case 5 -> weaponController.showWeaponWithType();
							case 6 -> weaponController.removeOneWeapon();
						}
						weaponOption = menu.weaponMenu();
					}
				}
				case 4 -> {
					int artifactOption = menu.artifactMenu();
					while (artifactOption != 6){
						switch (artifactOption){
							case 1 -> artifactController.addArtifactSet();
							case 2 -> artifactController.addArtifactSetUsingCSV();
							case 3 -> artifactController.showAllArtifacts();
							case 4 -> artifactController.showSpecificArtifact();
							case 5 -> artifactController.removeOneArtifactSet();
						}
						artifactOption = menu.artifactMenu();
					}
				}
				default -> System.out.println("option not found, try again");
			}
			option = menu.mainMenu();
		}
	}

}

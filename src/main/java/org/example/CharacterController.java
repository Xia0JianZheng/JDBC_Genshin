package org.example;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CharacterController {

	private Connection connection;
	
	public CharacterController(Connection connection) {
		this.connection = connection;
	}

	public void showAllCharacters() throws SQLException, IOException {

		Statement st = connection.createStatement();
		ResultSet rs;

		rs = st.executeQuery("SELECT * FROM character");
		while (rs.next()) {
			System.out.println("---------------------------------------" +
							"\nId: " + rs.getString("id_character") +
							"\nCharacterName : " + rs.getString("character_name") +
							"\nCharacterRarity : " + rs.getString("character_rarity") +
							"\nCharacterImage : " + rs.getString("character_image") +
							"\nCharacterDescription : " + rs.getString("character_description") +
							"\nElementName : " + rs.getString("element_name") +
							"\nRegionName : " + rs.getString("region_name") +
							"\nWeaponType : " + rs.getString("weapon_type") +
							"\nWeaponName : " + rs.getString("weapon_name") +
							"\nArtifactSet : " + rs.getString("artifact_set") +
							"\n---------------------------------------");
		}

		rs.close();
		st.close();
	}

}

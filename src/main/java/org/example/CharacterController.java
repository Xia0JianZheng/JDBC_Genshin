package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CharacterController {

	private Connection connection;
	
	public CharacterController(Connection connection) {
		this.connection = connection;
	}


	public void addCharacter() throws SQLException {

		Scanner sc = new Scanner(System.in);

		String sql = "INSERT INTO character(character_name,character_rarity,character_image,character_description,element_name,region_name,weapon_type,weapon_name,artifact_set) VALUES(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the name of the character : ");
			String character_name = sc.nextLine();
			System.out.println("Type the rarity of the character : ");
			String character_rarity = sc.nextLine();
			System.out.println("Type the image of the character : ");
			String character_image = sc.nextLine();
			System.out.println("Type the description of the character : ");
			String character_description = sc.nextLine();
			System.out.println("Type the element of the character : ");
			String element_name = sc.nextLine();
			System.out.println("Type the region of the character : ");
			String region_name = sc.nextLine();
			System.out.println("Type the weapon type of the character : ");
			String weapon_type = sc.nextLine();
			System.out.println("Type the weapon of the character : ");
			String weapon_name = sc.nextLine();
			System.out.println("Type the artifacte of the character : ");
			String artifact_set = sc.nextLine();
			pst.setString(1, character_name);
			pst.setString(2,character_rarity);
			pst.setString(3,character_image);
			pst.setString(4,character_description);
			pst.setString(5,element_name);
			pst.setString(6,region_name);
			pst.setString(7,weapon_type);
			pst.setString(8,weapon_name);
			pst.setString( 9,artifact_set);
			pst.executeUpdate();

			pst.close();
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Character Not Found ");
		}
	}

	public void addCharacterUsingCSV(){
		List<String[]> characterDatas = new ArrayList<>();

		try{
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/csv/Characters.csv"));
			String line;

			while ((line = br.readLine()) != null){
				String[] data = line.split("\",\"");
				characterDatas.add(data);
			}

			for(String[] data : characterDatas){
				String character_name = data[0];
				String character_rarity = data[1];
				String character_image = data[2];
				String character_description = data[3];
				String element_name = data[4];
				String region_name = data[5];
				String weapon_type = data[6];

				String sql = "INSERT INTO character(character_name,character_rarity,character_image,character_description,element_name,region_name,weapon_type)VALUES(?,?,?,?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1,character_name);
				pst.setString(2,character_rarity);
				pst.setString(3,character_image);
				pst.setString(4,character_description);
				pst.setString(5,element_name);
				pst.setString(6,region_name);
				pst.setString(7,weapon_type);

				pst.executeUpdate();
				pst.close();
			}
		} catch (IOException | SQLException e) {
			throw new RuntimeException(e);
		}
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

	public void showSpecificCharacter() throws SQLException {

		ResultSet rs;
		Scanner sc = new Scanner(System.in);

		String sql = "SELECT * FROM character WHERE character_name = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the name of the character : ");
			String characterName = sc.nextLine();
			pst.setString(1, characterName);
			rs = pst.executeQuery();
			// rs = st.executeQuery("SELECT * FROM character WHERE character_name = characterName=? ");

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
			pst.close();
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Character Not Found ");
		}
	}

	public void removeOneCharacter() throws SQLException {

		Scanner sc = new Scanner(System.in);

		String sql = "DELETE FROM character WHERE character_name = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try {
			System.out.println("Type the name of the character you want remove : ");
			String character_name = sc.nextLine();
			pst.setString(1, character_name);
			pst.executeUpdate();
			pst.close();
			System.out.println("El character " + character_name + " Ha sido borrado de la tabla");
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println("Character Not Found ");
		}

	}

}

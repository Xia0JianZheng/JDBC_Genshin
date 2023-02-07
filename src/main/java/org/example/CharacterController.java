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

	private final Connection connection;

	Scanner sc = new Scanner(System.in);

	ResultSet rs;
	
	public CharacterController(Connection connection) {
		this.connection = connection;
	}


	public void addCharacter() throws SQLException {

		String sql = "INSERT INTO character(character_name,character_rarity,character_image,character_description,element_name,region_name,weapon_type) VALUES(?,?,?,?,?,?,?)";
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
			pst.setString(1, character_name);
			pst.setString(2,character_rarity);
			pst.setString(3,character_image);
			pst.setString(4,character_description);
			pst.setString(5,element_name);
			pst.setString(6,region_name);
			pst.setString(7,weapon_type);
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

		rs = st.executeQuery("SELECT * FROM character");
		while (rs.next()) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
					"\nId: " + rs.getString("id_character") + " || " + "CharacterName : " + rs.getString("character_name") + " || " + "CharacterRarity : " + rs.getString("character_rarity") + " || " + "CharacterImage : " + rs.getString("character_image") + " || " + "CharacterDescription : " + rs.getString("character_description") + " || " + "ElementName : " + rs.getString("element_name") + " || " + "RegionName : " + rs.getString("region_name") + " || " + "WeaponType : " + rs.getString("weapon_type") +
					"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		rs.close();
		st.close();
	}

	public void showSpecificCharacter() throws SQLException {

		String sql = "SELECT * FROM character WHERE character_name = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the name of the character : ");
			String characterName = sc.nextLine();
			pst.setString(1, characterName);
			rs = pst.executeQuery();
			// rs = st.executeQuery("SELECT * FROM character WHERE character_name = characterName=? ");

			if (!rs.next()) {
				System.out.println("Character Not Found");
			} else {
				do {
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
							"\nId: " + rs.getString("id_character") + " || " + "CharacterName : " + rs.getString("character_name") + " || " + "CharacterRarity : " + rs.getString("character_rarity") + " || " + "CharacterImage : " + rs.getString("character_image") + " || " + "CharacterDescription : " + rs.getString("character_description") + " || " + "ElementName : " + rs.getString("element_name") + " || " + "RegionName : " + rs.getString("region_name") + " || " + "WeaponType : " + rs.getString("weapon_type") +
							"\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");				} while (rs.next());
			}

			rs.close();
			pst.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	public void showCharacterWithRegion() throws SQLException{
		String sql = "SELECT * FROM character WHERE region_name = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the region name : [-][ ][ ][ ][ ][ ][ ]");
			String regionName = sc.nextLine();
			pst.setString(1,regionName);
			rs = pst.executeQuery();

			if (!rs.next()) {
				System.out.println("Region"+ regionName + "doesn't exist");
			} else {
				do {
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
							"\nId: " + rs.getString("id_character") + " || " + "CharacterName : " + rs.getString("character_name") + " || " + "CharacterRarity : " + rs.getString("character_rarity") + " || " + "CharacterImage : " + rs.getString("character_image") + " || " + "CharacterDescription : " + rs.getString("character_description") + " || " + "ElementName : " + rs.getString("element_name") + " || " + "RegionName : " + rs.getString("region_name") + " || " + "WeaponType : " + rs.getString("weapon_type") +
							"\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");				} while (rs.next());
			}

			}catch(SQLException e){
			e.printStackTrace();
		}

	}

	public void showCharacterWithElement() throws SQLException{
		String sql = "SELECT * FROM character WHERE element_name = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the element name : [-][ ][ ][ ][ ][ ][ ]");
			String elementName = sc.nextLine();
			pst.setString(1,elementName);
			rs = pst.executeQuery();

			if (!rs.next()) {
				System.out.println("The element" + elementName + "doesn't exist");
			} else {
				do {
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
							"\nId: " + rs.getString("id_character") + " || " + "CharacterName : " + rs.getString("character_name") + " || " + "CharacterRarity : " + rs.getString("character_rarity") + " || " + "CharacterImage : " + rs.getString("character_image") + " || " + "CharacterDescription : " + rs.getString("character_description") + " || " + "ElementName : " + rs.getString("element_name") + " || " + "RegionName : " + rs.getString("region_name") + " || " + "WeaponType : " + rs.getString("weapon_type") +
							"\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");				} while (rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}

	public void showCharacterWithWeaponType() throws SQLException{
		String sql = "SELECT * FROM character WHERE weapon_type = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the weapon type : [-][ ][ ][ ][ ][ ][ ]");
			String weaponType = sc.nextLine();
			pst.setString(1,weaponType);
			rs = pst.executeQuery();

			if (!rs.next()) {
				System.out.println("The weapon type " + weaponType + " doesn't exist");
			} else {
				do {
					System.out.println("--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
							"\nId: " + rs.getString("id_character") + " || " + "CharacterName : " + rs.getString("character_name") + " || " + "CharacterRarity : " + rs.getString("character_rarity") + " || " + "CharacterImage : " + rs.getString("character_image") + " || " + "CharacterDescription : " + rs.getString("character_description") + " || " + "ElementName : " + rs.getString("element_name") + " || " + "RegionName : " + rs.getString("region_name") + " || " + "WeaponType : " + rs.getString("weapon_type") +
							"\n-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				} while (rs.next());
			}
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Character Not Found ");
		}

	}

	public void removeOneCharacter() throws SQLException {

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

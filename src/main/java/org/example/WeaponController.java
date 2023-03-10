package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase donde tiene metodos para controla la tabla de weapons
 */
public class WeaponController {

	private Connection connection;

	Scanner sc = new Scanner(System.in);

	ResultSet rs;

	/**
	 * Constructor de la clase weaponController
	 * @param connection coge la conneccion de la base de datos
	 */
	public WeaponController(Connection connection) {
		this.connection = connection;
	}

	/**
	 * metodo que añade una arma con los infos del usuario
	 * @throws SQLException throws SQLException Exception
	 */
	public void addWeapon() throws SQLException {

		String sql = "INSERT INTO weapon(weapon_name,weapon_rarity,weapon_image,weapon_description,weapon_type,base_atk) VALUES(?,?,?,?,?,?)";
		PreparedStatement pst = connection.prepareStatement(sql);
		try{
			System.out.println("Type the name of the weapon : ");
			String character_name = sc.nextLine();
			System.out.println("Type the rarity of the weapon : ");
			String character_rarity = sc.nextLine();
			System.out.println("Type the image of the weapon : ");
			String character_image = sc.nextLine();
			System.out.println("Type the description of the weapon : ");
			String character_description = sc.nextLine();
			System.out.println("Type the type of the weapon : ");
			String weapon_type = sc.nextLine();
			System.out.println("Type baseATK of the weapon : ");
			String base_atk = sc.nextLine();
			pst.setString(1, character_name);
			pst.setString(2,character_rarity);
			pst.setString(3,character_image);
			pst.setString(4,character_description);
			pst.setString(5,weapon_type);
			pst.setString( 6,base_atk);
			pst.executeUpdate();

			pst.close();
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Character Not Found ");
		}
	}

	/**
	 * Metodo que añade las armas pasando un ficharo csv
	 */
	public void addWeaponUsingCSV(){
		List<String[]> weaponDatas = new ArrayList<>();

		try{
			BufferedReader br = new BufferedReader(new FileReader("src/main/resources/csv/Weapons.csv"));
			String line;

			while ((line = br.readLine()) != null){
				String[] data = line.split("\",\"");
				weaponDatas.add(data);
			}

			for(String[] data : weaponDatas){
				String weapon_name = data[0];
				String weapon_rarity = data[1];
				String weapon_image = data[2];
				String weapon_description = data[3];
				String weapon_type = data[4];
				String baseATK = data[5];

				String sql = "INSERT INTO weapon(weapon_name,weapon_rarity,weapon_image,weapon_description,weapon_type,base_atk)VALUES(?,?,?,?,?,?)";
				PreparedStatement pst = connection.prepareStatement(sql);
				pst.setString(1,weapon_name);
				pst.setString(2,weapon_rarity);
				pst.setString(3,weapon_image);
				pst.setString(4,weapon_description);
				pst.setString(5,weapon_type);
				pst.setString(6,baseATK);

				pst.executeUpdate();
				pst.close();
			}
		} catch (IOException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Metodo que muestra toda las armas de la tabla
	 * @throws SQLException throws SQLException Exception
	 */
	public void showAllWeapons() throws SQLException{

		Statement st = connection.createStatement();

		rs = st.executeQuery("SELECT * FROM weapon");
		while (rs.next()) {
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
					"\nId: " + rs.getString("id_weapon") + " || " + "WeaponName : " + rs.getString("weapon_name") + " || " + "WeaponRarity : " + rs.getString("weapon_rarity") + " || " + "WeaponImage : " + rs.getString("weapon_image") + " || " + "WeaponDescription : " + rs.getString("weapon_description") + " || " + "WeaponType : " + rs.getString("weapon_type") + " || " + "BaseATK : " + rs.getString("base_atk") +
					"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		}

		rs.close();
		st.close();
	}

	/**
	 * Metodo que muestra los infos de la arma con el nombre que le has pasado
	 * @throws SQLException throws SQLException Exception
	 */
	public void showSpecificWeapon() throws SQLException {

		String sql = "SELECT * FROM weapon WHERE weapon_name = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the name of the weapon : ");
			String weaponName = sc.nextLine();
			pst.setString(1, weaponName);
			rs = pst.executeQuery();

			if(!rs.next()){
				System.out.println("The weapon " + weaponName + " doesn't exist");
			}else{
				do{
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
							"\nId: " + rs.getString("id_weapon") + " || " + "WeaponName : " + rs.getString("weapon_name") + " || " + "WeaponRarity : " + rs.getString("weapon_rarity") + " || " + "WeaponImage : " + rs.getString("weapon_image") + " || " + "WeaponDescription : " + rs.getString("weapon_description") + " || " + "WeaponType : " + rs.getString("weapon_type") + " || " + "BaseATK : " + rs.getString("base_atk") +
							"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				}while (rs.next());
			}
			rs.close();
			pst.close();
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Weapon Not Found ");
		}
	}

	/**
	 * Metodo que muestra las armas psasando el tipo de arma
	 * @throws SQLException throws SQLException Exception
	 */
	public void showWeaponWithType() throws SQLException {

		String sql = "SELECT * FROM weapon WHERE weapon_type = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try{
			System.out.println("Type the type of the weapon : ");
			String weaponType = sc.nextLine();
			pst.setString(1, weaponType);
			rs = pst.executeQuery();

			if(!rs.next()){
				System.out.println("The weapon type " + weaponType + " doesn't exist");
			}else{
				do{
					System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------" +
							"\nId: " + rs.getString("id_weapon") + " || " + "WeaponName : " + rs.getString("weapon_name") + " || " + "WeaponRarity : " + rs.getString("weapon_rarity") + " || " + "WeaponImage : " + rs.getString("weapon_image") + " || " + "WeaponDescription : " + rs.getString("weapon_description") + " || " + "WeaponType : " + rs.getString("weapon_type") + " || " + "BaseATK : " + rs.getString("base_atk") +
							"\n---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
				}while (rs.next());
			}
			rs.close();
			pst.close();
		} catch (SQLException e){
			e.printStackTrace();
			System.out.println("Weapon Not Found ");
		}
	}

	/**
	 * Metodo que quita una arma de la tabla pasando el nombre
	 * @throws SQLException throws SQLException Exception
	 */
	public void removeOneWeapon() throws SQLException {

		String sql = "DELETE FROM weapon WHERE weapon_name = ?";
		PreparedStatement pst = connection.prepareStatement(sql);

		try {
			System.out.println("Type the name of the weapon you want remove : ");
			String weaponName = sc.nextLine();
			pst.setString(1, weaponName);
			pst.executeUpdate();
			pst.close();
			System.out.println("El weapon " + weaponName + " Ha sido borrado de la tabla");
		}catch (SQLException e){
			e.printStackTrace();
			System.out.println("Weapon Not Found ");
		}

	}
}

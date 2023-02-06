package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArtifactController {

    private final Connection connection;

    Scanner sc = new Scanner(System.in);

    ResultSet rs;

    public ArtifactController(Connection connection) {
        this.connection = connection;
    }

    public void addArtifactSet() throws SQLException {

        String sql = "INSERT INTO artifact(set_name,flower_of_life,img_flower_of_life,plume_of_death,img_plume_of_death,sands_of_eon,img_sands_of_eon,goblet_of_eonothem,img_goblet_of_eonothem,circlet_of_logos,img_circlet_of_logos,x2_bonus,x4_bonus) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pst = connection.prepareStatement(sql);
        try{
            System.out.println("Type the set_name of the artifact : ");
            String set_name = sc.nextLine();
            System.out.println("Type the name of the flower_of_life : ");
            String flower_of_life = sc.nextLine();
            System.out.println("Type the img of the flower_of_life : ");
            String img_flower_of_life = sc.nextLine();
            System.out.println("Type the name of the plume_of_death : ");
            String plume_of_death = sc.nextLine();
            System.out.println("Type the img of the plume_of_death : ");
            String img_plume_of_death = sc.nextLine();
            System.out.println("Type the name of the sands_of_eon : ");
            String sands_of_eon = sc.nextLine();
            System.out.println("Type the img of the sands_of_eon : ");
            String img_sands_of_eon = sc.nextLine();
            System.out.println("Type the name of the goblet_of_eonothem : ");
            String goblet_of_eonothem = sc.nextLine();
            System.out.println("Type the img of the goblet_of_eonothem : ");
            String img_goblet_of_eonothem = sc.nextLine();
            System.out.println("Type the name of the circlet_of_logos : ");
            String circlet_of_logos = sc.nextLine();
            System.out.println("Type the img of the circlet_of_logos : ");
            String img_circlet_of_logos = sc.nextLine();
            System.out.println("Type the x2 piece bonus description : ");
            String x2_bonus = sc.nextLine();
            System.out.println("Type the x4 piece bonus description : ");
            String x4_bonus = sc.nextLine(); 

            pst.setString(1, set_name);
            pst.setString(2,flower_of_life);
            pst.setString(3,img_flower_of_life);
            pst.setString(4,plume_of_death);
            pst.setString(5,img_plume_of_death);
            pst.setString(6,sands_of_eon);
            pst.setString(7,img_sands_of_eon);
            pst.setString(8,goblet_of_eonothem);
            pst.setString( 9,img_goblet_of_eonothem);
            pst.setString( 10,circlet_of_logos);
            pst.setString( 11,img_circlet_of_logos);
            pst.setString( 12,x2_bonus);
            pst.setString( 13,x4_bonus);
            pst.executeUpdate();

            pst.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Artifact Not Found ");
        }
    }

    public void addArtifactSetUsingCSV(){
        List<String[]> artifactDatas = new ArrayList<>();

        try{
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/csv/Artifacts.csv"));
            String line;

            while ((line = br.readLine()) != null){
                String[] data = line.split("\",\"");
                artifactDatas.add(data);
            }

            for(String[] data : artifactDatas){
                String set_name = data[0];
                String flower_of_life = data[1];
                String img_flower_of_life = data[2];
                String plume_of_death = data[3];
                String img_plume_of_death = data[4];
                String sands_of_eon = data[5];
                String img_sands_of_eon = data[6];
                String goblet_of_eonothem = data[7];
                String img_goblet_of_eonothem = data[8];
                String circlet_of_logos = data[9];
                String img_circlet_of_logos = data[10];
                String x2_bonus = data[11];
                String x4_bonus = data[12];

                String sql = "INSERT INTO artifact(set_name,flower_of_life,img_flower_of_life,plume_of_death,img_plume_of_death,sands_of_eon,img_sands_of_eon,goblet_of_eonothem,img_goblet_of_eonothem,circlet_of_logos,img_circlet_of_logos,x2_bonus,x4_bonus) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement pst = connection.prepareStatement(sql);
                pst.setString(1,set_name);
                pst.setString(2,flower_of_life);
                pst.setString(3,img_flower_of_life);
                pst.setString(4,plume_of_death);
                pst.setString(5,img_plume_of_death);
                pst.setString(6,sands_of_eon);
                pst.setString(7,img_sands_of_eon);
                pst.setString(8,goblet_of_eonothem);
                pst.setString(9,img_goblet_of_eonothem);
                pst.setString(10,circlet_of_logos);
                pst.setString(11,img_circlet_of_logos);
                pst.setString(12,x2_bonus);
                pst.setString(13,x4_bonus);

                pst.executeUpdate();
                pst.close();
            }
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void showAllArtifacts() throws SQLException{

        Statement st = connection.createStatement();

        rs = st.executeQuery("SELECT * FROM artifact");
        while (rs.next()) {
            System.out.println("---------------------------------------" +
                    "\nId: " + rs.getString("id_artifactSet") +
                    "\nSetName : " + rs.getString("set_name") +
                    "\nFlowerOfLife : " + rs.getString("flower_of_life") +
                    "\nImgFlowerOfLife : " + rs.getString("img_flower_of_life") +
                    "\nPlumeOfDeath : " + rs.getString("plume_of_death") +
                    "\nImgPlumeOfDeath : " + rs.getString("img_plume_of_death") +
                    "\nSandsOfEon : " + rs.getString("sands_of_eon") +
                    "\nImgSandsOfEon : " + rs.getString("img_sands_of_eon") +
                    "\nGobletOfEonothem : " + rs.getString("goblet_of_eonothem") +
                    "\nImgGobletOfEonothem : " + rs.getString("img_goblet_of_eonothem") +
                    "\nCircletOfLogos : " + rs.getString("circlet_of_logos") +
                    "\nImgCircletOfLogos : " + rs.getString("img_circlet_of_logos") +
                    "\nX2_Bonus : " + rs.getString("x2_bonus") +
                    "\nX4_Bonus : " + rs.getString("x4_bonus") +
                    "\n---------------------------------------");
        }

        rs.close();
        st.close();
    }

    public void showSpecificArtifact() throws SQLException {

        String sql = "SELECT * FROM artifact WHERE set_name = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        try{
            System.out.println("Type the set name of the artifact : ");
            String setName = sc.nextLine();
            pst.setString(1, setName);
            rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("---------------------------------------" +
                        "\nId: " + rs.getString("id_artifactSet") +
                        "\nSetName : " + rs.getString("set_name") +
                        "\nFlowerOfLife : " + rs.getString("flower_of_life") +
                        "\nImgFlowerOfLife : " + rs.getString("img_flower_of_life") +
                        "\nPlumeOfDeath : " + rs.getString("plume_of_death") +
                        "\nImgPlumeOfDeath : " + rs.getString("img_plume_of_death") +
                        "\nSandsOfEon : " + rs.getString("sands_of_eon") +
                        "\nImgSandsOfEon : " + rs.getString("img_sands_of_eon") +
                        "\nGobletOfEonothem : " + rs.getString("goblet_of_eonothem") +
                        "\nImgGobletOfEonothem : " + rs.getString("img_goblet_of_eonothem") +
                        "\nCircletOfLogos : " + rs.getString("circlet_of_logos") +
                        "\nImgCircletOfLogos : " + rs.getString("img_circlet_of_logos") +
                        "\nX2_Bonus : " + rs.getString("x2_bonus") +
                        "\nX4_Bonus : " + rs.getString("x4_bonus") +
                        "\n---------------------------------------");
            }
            rs.close();
            pst.close();
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("Artifact Not Found ");
        }
    }

    public void removeOneArtifactSet() throws SQLException {

        String sql = "DELETE FROM artifact WHERE set_name = ?";
        PreparedStatement pst = connection.prepareStatement(sql);

        try {
            System.out.println("Type the set name of the artifact you want remove : ");
            String setName = sc.nextLine();
            pst.setString(1, setName);
            pst.executeUpdate();
            pst.close();
            System.out.println("The ArtifactSet " + setName + " Was removed from the table");
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Artifact Not Found ");
        }

    }

}

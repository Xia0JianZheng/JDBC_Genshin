package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class TablesController {
    private final Connection connection;

    Scanner sc = new Scanner(System.in);

    public TablesController(Connection connection) {
        this.connection = connection;
    }

    public void addAllTables() throws SQLException {

        Statement st = connection.createStatement();
        try{
            st.executeUpdate("CREATE TABLE character(" +
                    "id_character serial PRIMARY KEY," +
                    "character_name text," +
                    "character_rarity text," +
                    "character_image text," +
                    "character_description text," +
                    "element_name text," +
                    "region_name text," +
                    "weapon_type text);");

            st.executeUpdate("CREATE TABLE weapon(" +
                    "id_weapon serial PRIMARY KEY," +
                    "weapon_name text," +
                    "weapon_rarity text," +
                    "weapon_image text," +
                    "weapon_description text," +
                    "weapon_type text," +
                    "base_atk text);");

            st.executeUpdate("CREATE TABLE artifact(" +
                    "id_artifactSet serial," +
                    "set_name text," +
                    "flower_of_life text," +
                    "img_flower_of_life text," +
                    "plume_of_death text," +
                    "img_plume_of_death text," +
                    "sands_of_eon text," +
                    "img_sands_of_eon text," +
                    "goblet_of_eonothem text," +
                    "img_goblet_of_eonothem text," +
                    "circlet_of_logos text," +
                    "img_circlet_of_logos text," +
                    "x2_bonus text," +
                    "x4_bonus text);");
            st.close();
        }catch (SQLException e){
            System.out.println("Las tablas ya estan creadas, no se puede crearlos antes de borrarlos");
        }

    }

    public void removeAllTables() throws SQLException {
        Statement st = connection.createStatement();
        try {
            st.executeUpdate("DROP TABLE character");
            st.executeUpdate("DROP TABLE weapon");
            st.executeUpdate("DROP TABLE artifact");
        }catch (SQLException e){
            System.out.println("No hay tablas que borrar");
        }

    }
}


package org.example;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Clase donde se encarga de gestionar sobre las tablas del base de datos
 */
public class TablesController {
    private final Connection connection;

    /**
     * Constructor de la tablesController
     * @param connection coge la conneccion a la base de datos
     */
    public TablesController(Connection connection) {
        this.connection = connection;
    }

    /**
     * Metodo que Crea las tablas del base de datos
     * @throws SQLException si falla el metodo sale un error
     */
    public void addAllTables() throws SQLException {

        Statement st = connection.createStatement();
        try{
            st.executeUpdate("CREATE TABLE region(" +
                    "region_name text PRIMARY KEY);");

            st.executeUpdate("CREATE TABLE element(" +
                    "element_name text PRIMARY KEY);");

            st.executeUpdate("CREATE TABLE character(" +
                    "id_character serial PRIMARY KEY," +
                    "character_name text," +
                    "character_rarity text," +
                    "character_image text," +
                    "character_description text," +
                    "element_name text REFERENCES element (element_name)," +
                    "region_name text REFERENCES region (region_name)," +
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

            st.executeUpdate("INSERT INTO element(element_name)VALUES('Geo')");
            st.executeUpdate("INSERT INTO element(element_name)VALUES('Cyro')");
            st.executeUpdate("INSERT INTO element(element_name)VALUES('Pyro')");
            st.executeUpdate("INSERT INTO element(element_name)VALUES('Hydro')");
            st.executeUpdate("INSERT INTO element(element_name)VALUES('Electro')");
            st.executeUpdate("INSERT INTO element(element_name)VALUES('Dentro')");
            st.executeUpdate("INSERT INTO element(element_name)VALUES('Anemo')");

            st.executeUpdate("INSERT INTO region(region_name)VALUES('Mondstadt')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('Liyue')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('Inazuma')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('Sumeru')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('Fontaine')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('Natlan')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('Snezhnaya')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('Khaenri'ah')");
            st.executeUpdate("INSERT INTO region(region_name)VALUES('None')");
            st.close();
        }catch (SQLException e){
            System.out.println("Las tablas ya estan creadas, no se puede crearlos antes de borrarlos");
        }

    }

    /**
     * Metodo que borra toda las tablas del base de datos
     * @throws SQLException si falla sale un error
     */
    public void removeAllTables() throws SQLException {
        Statement st = connection.createStatement();
        try {
            st.executeUpdate("DROP TABLE character");
            st.executeUpdate("DROP TABLE weapon");
            st.executeUpdate("DROP TABLE artifact");
            st.executeUpdate("DROP TABLE region");
            st.executeUpdate("DROP TABLE element");
            st.close();
        }catch (SQLException e){
            System.out.println("No hay tablas para borrar");
        }

    }
}


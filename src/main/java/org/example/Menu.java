package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Menu {
	private int option;
	Scanner sc = new Scanner(System.in);

	public Menu() {
		super();
	}

	public int mainMenu() {

		System.out.println("-----------------------------------");
		System.out.println("-			Main Menu			  -");
		System.out.println("-----------------------------------");
		System.out.println("- 	1. Access to Table menu		  -");
		System.out.println("-	2. Access to Character table  -");
		System.out.println("-	3. Access to Weapon table	  -");
		System.out.println("-	4. Access to Artifact table	  -");
		System.out.println("-	5. Exit						  -");
		System.out.println("-----------------------------------");

		System.out.println("Choose a option : ");
		try{
			option = sc.nextInt();
		}catch (Exception e){
			System.out.println("The option you have choice doesn't exist");
		}
	return option;
	}

	public int tableMenu(){
		System.out.println("-----------------------------------");
		System.out.println("-	      	Table Menu   	      -");
		System.out.println("-----------------------------------");
		System.out.println("-	1. Add the Tables		  	  -");
		System.out.println("-	2. Remove the Tables	  	  -");
		System.out.println("-	3. Back to Main Menu		  -");
		System.out.println("-----------------------------------");

		System.out.println("Choose a option : ");
		try{
			option = sc.nextInt();
		}catch (Exception e){
			System.out.println("The option you have choice doesn't exist");
		}
		return option;
	}

	public int characterMenu(){
		System.out.println("---------------------------------------------");
		System.out.println("-	    	  Character Menu    	  		-");
		System.out.println("---------------------------------------------");
		System.out.println("-	1. Add a Character				   		-");
		System.out.println("-	2. Add an Characters using CSV File 	-");
		System.out.println("-	3. Show all the Characters				-");
		System.out.println("-	4. Show a character with name			-");
		System.out.println("-	5. Show all characters with region name -");
		System.out.println("-	6. show all characters with element		-");
		System.out.println("-	7. show all characters with weapon type -");
		System.out.println("-	8. Delete a Character					-");
		System.out.println("-	9. Back to Main Menu		 		    -");
		System.out.println("---------------------------------------------");

		System.out.println("Choose a option : ");
		try{
			option = sc.nextInt();
		}catch (Exception e){
			System.out.println("The option you have choice doesn't exist");
		}
	return option;
	}

	public int weaponMenu(){
		System.out.println("-------------------------------------------");
		System.out.println("-	      		Weapon Menu       	  	  -");
		System.out.println("-------------------------------------------");
		System.out.println("-	1 Add a Weapon			   		      -");
		System.out.println("-	2. Add an Weapons using CSV File	  -");
		System.out.println("-	3. Show all the Weapons			  	  -");
		System.out.println("-	4. Show a specific Weapon	 		  -");
		System.out.println("-	5. show all Weapons with weapon type  -");
		System.out.println("-	6. Delete a Weapon 				  	  -");
		System.out.println("-	7. Back to Main Menu		  		  -");
		System.out.println("-------------------------------------------");

		System.out.println("Choose a option : ");
		try{
			option = sc.nextInt();
		}catch (Exception e){
			System.out.println("The option you have choice doesn't exist");
		}
	return option;
	}

	public int artifactMenu(){
		System.out.println("-----------------------------------------");
		System.out.println("-	      	Artifact Menu     	  		-");
		System.out.println("-----------------------------------------");
		System.out.println("-	1. Add a Artifact					-");
		System.out.println("-	2. Add an Artifacts using CSV File  -");
		System.out.println("-	3. Show all the Artifacts			-");
		System.out.println("-	4. Show a specific Artifact			-");
		System.out.println("-	5. Delete a Artifact				-");
		System.out.println("-	6. Back to Main Menu		 	    -");
		System.out.println("-----------------------------------------");

		System.out.println("Choose a option : ");
		try{
			option = sc.nextInt();
		}catch (Exception e){
			System.out.println("The option you have choice doesn't exist");
		}
	return option;
	}

}

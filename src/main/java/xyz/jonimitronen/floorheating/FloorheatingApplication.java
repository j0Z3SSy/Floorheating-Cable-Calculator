
// FloorheatingApplication.java
// Tämä luokka on sovelluksen pääsisäänkäynti (entry point). Se sisältää main-metodin, joka käynnistää Spring Boot -sovelluksen. 
// Tämän luokan avulla sovellus käynnistyy ja aloittaa kaikkien muiden komponenttien lataamisen.
package xyz.jonimitronen.floorheating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FloorheatingApplication {

	public static void main(String[] args) {
		SpringApplication.run(FloorheatingApplication.class, args);
		System.out.println(
				"Lattialämmitys-Palvelu on käynnistetty...");
	}

}

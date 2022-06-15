package com.ironhack.plantisserver;

import com.ironhack.plantisserver.model.GeneralPlant;
import com.ironhack.plantisserver.model.User;
import com.ironhack.plantisserver.service.impl.GeneralPlantService;
import com.ironhack.plantisserver.service.impl.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import static com.ironhack.plantisserver.enums.Light.SHADE;

@SpringBootApplication
public class PlantisServerApplication {
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		SpringApplication.run(PlantisServerApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*").allowedOrigins("http://localhost:3000");
			}
		};
	}

	@Bean
	CommandLineRunner run(GeneralPlantService generalPlantService, UserService userService) {
		return args -> {
		/*	userService.saveUser(new User("Carmen","carmen@hotmail.com","Apple123$"));

			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=15VMo7w43ufDCXrDf_Cr65DIM2blEv8U3&export=download","Cactus","A cactus  is a member of the plant family Cactaceae","Partial sun","Not often"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1vhtxgkSoEb3IAxomuUbYkuvEcHvcX2VO&export=download","Begonia","Begonia is a genus of perennial flowering plants in the family Begoniaceae. The genus contains more than 2,000 different plant species. The Begonias are native to moist subtropical and tropical climates. ","SHADE","Three times per week"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1mLW0WJmbk-f6eNQyesG5HH5y3cPQl4Md&export=download","Pothos","Pothos is an evergreen plant with thick, waxy, green, heart-shaped leaves with splashes of yellow. ","SUN","Not often"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1KbshjzhVncfs1a7cBOsBSYGrqSW1TDgc&export=download","Monstera","The Monstera is a tropical plant with leaves that can grow monstrously big. Thanks to her large leaves, the Monstera plant is an excellent air-purifier.","A bit of sun light","Twice per week"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1NvXxWYgDmlzRu-S6PncuDnOFgZqD04eb&export=download","Shefflera","Schefflera is a genus of flowering plants in the family Araliaceae. With an estimated 600–900 species, the genus represents about half of its family.","Sun","not often"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1Sd_oI-yF8P_TyAl4fVqxBWrPJEJPbAOu&export=download","Calathea","Calathea is a genus of flowering plants belonging to the family Marantaceae. They are commonly called calatheas or prayer plants.","Sun","Not often"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1fA174ex_FOWh_V2lE6TVaMWIRoaL6AUv&export=download","Sansevieria","Sansevieria is a historically recognized genus of flowering plants, native to Africa","SHADE","not often"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1l_A9duyag6-nQnLenmO1mDnxCG4XAHIv&export=download","Alocasia","The Alocasia is a houseplant that you will not easily overlook. This is because of their spectacular foliage and visual appeal, but also literally because the leaves can grow to a meter in length!","Shade","Twice per week"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=1CtcRDKKOWyZREkBH_GJIRf9WhcR5aCPo&export=download","Anthurium","The Anthurium is not only a plant that is very easy to maintain, but she is also very beautiful. Anthuriums, or some also called the Flamingo plant, are a genus of ‘’flowering’’ plants available in many different colours.","Medium shade","Twice per week"));
			generalPlantService.saveGeneralPlant(new GeneralPlant("https://drive.google.com/uc?id=10GCAG6gNSlhq2Ontd2Vej4wBZ5WxHIba&export=download","Aloe Vera"," Most types of Aloë plants have thick fleshy leaves that contain a gel-like substance. This gel is even known for its healing powers! ","Sun","Not often"));
*/
		};
	}
}


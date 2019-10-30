package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class TaxesApplication implements CommandLineRunner{
//	
//	@Autowired
//	EntrepriseRepository entrepriseRepository;
//	@Autowired
//	TaxeRepository taxeRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(TaxesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Entreprise e1=entrepriseRepository.save(new Entreprise(1L, "ahmed", "jjj"));
//		Entreprise e2=entrepriseRepository.save(new Entreprise(2L, "ahmed", "jjj"));
//		Entreprise e3=entrepriseRepository.save(new Entreprise(3L, "ahmed", "jjj"));
//		Entreprise e4=entrepriseRepository.save(new Entreprise(5L, "ahmed", "jjj"));
//		Entreprise e=entrepriseRepository.save(new Entreprise(6L, "ahmed", "jjj"));
//		Entreprise e5=entrepriseRepository.save(new Entreprise(26L, "ahmed", "jjj"));
//		Entreprise e6=entrepriseRepository.save(new Entreprise(17L, "ahmed", "jjj"));
//		Entreprise e8=entrepriseRepository.save(new Entreprise(28L, "ahmed", "jjj"));
//		Taxe t=taxeRepository.save(new TVA(1L, "llll", new Date(), 2020.2, e5));
	}

}

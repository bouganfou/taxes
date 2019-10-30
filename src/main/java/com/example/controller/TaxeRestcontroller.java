package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.EntrepriseRepository;
import com.example.entities.Entreprise;

@RestController
public class TaxeRestcontroller {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	@RequestMapping("/listEntreprises")
	public Page<Entreprise> listEntreprise(@RequestParam(name="motcle",defaultValue="")String motCle,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="5")int size){
		return entrepriseRepository.chercher("%"+motCle+"%", new PageRequest(page, size));
	}
}

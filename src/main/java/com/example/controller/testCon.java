package com.example.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.EntrepriseRepository;
import com.example.dao.TaxeRepository;
import com.example.entities.Entreprise;
import com.example.entities.Taxe;

@Controller
public class testCon {
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private TaxeRepository taxeRepository;
	
	@RequestMapping(value="/entreprises",method=RequestMethod.GET)
	public String index(Model model,
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int s,
			@RequestParam(name="mc",defaultValue="") String mc) {
		Page<Entreprise> entreprises=entrepriseRepository.chercher("%"+mc+"%", new PageRequest(p, s));
		model.addAttribute("listEnreprises",entreprises.getContent());
		int[] pages=new int[entreprises.getTotalPages()];
		model.addAttribute("pages",pages );
		model.addAttribute("pageCourante",p );
		model.addAttribute("motCle",mc );
		return "entreprises";
	}
	@RequestMapping(value="/formEntreprise")
	public String formEntreprise(Model model) {
		model.addAttribute("entreprise",new Entreprise());
		return "formEntreprise";
	}
	@RequestMapping(value="/saveEntreprise")
	public String saveEntreprise(Model model,@Valid Entreprise e,BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "formEntreprise";
		}
		entrepriseRepository.save(e);
		return "redirect:/entreprises";
	}
	@RequestMapping(value="/taxes")
	public String taxes(Model model,
			@RequestParam(name="page",defaultValue="-1") Long code,
			@RequestParam(name="page",defaultValue="0") int p,
			@RequestParam(name="size",defaultValue="5") int s) {
		model.addAttribute("entreprises",entrepriseRepository.findAll());
		if(code==-1) model.addAttribute("taxes",new ArrayList<Taxe>());
		else {
			Entreprise e=new Entreprise();
			e.setCode(code);
			model.addAttribute("listTaxes",taxeRepository.findByEntreprise(e));
		}
			
		return "taxes";
	}
	

}

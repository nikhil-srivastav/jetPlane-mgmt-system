package com.bth.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bth.springboot.model.JetPlane;
import com.bth.springboot.service.JetplaneService;

@Controller
public class JetPlaneController {

	@Autowired
	private JetplaneService jetPlaneService;
	
	// display list of jetplanes
	@GetMapping("/")
	public String viewHomePage(Model model) {
		return findPaginated(1, "modelName", "asc", model);		
	}
	
	@GetMapping("/showNewJetPlaneForm")
	public String showNewJetPlaneForm(Model model) {
		// create model attribute to bind form data
		JetPlane jetPlane = new JetPlane();
		model.addAttribute("jetPlane", jetPlane);
		return "new_jetplane";
	}
	
	@PostMapping("/saveJetPlane")
	public String saveJetPlane(@ModelAttribute("jetPlane") JetPlane jetPlane) {
		// save jetPlane to database
		jetPlaneService.saveJetPlane(jetPlane);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get jetPlane from the service
		JetPlane jetPlane = jetPlaneService.getJetPlaneById(id);
		
		// set jetPlane as a model attribute to pre-populate the form
		model.addAttribute("jetPlane", jetPlane);
		return "update_jetplane";
	}
	
	@GetMapping("/deleteJetPlane/{id}")
	public String deleteJetPlane(@PathVariable (value = "id") long id) {
		
		// call delete jetPlane method 
		this.jetPlaneService.deleteJetPlaneById(id);
		return "redirect:/";
	}
	
	
	@GetMapping("/page/{pageNo}")
	public String findPaginated(@PathVariable (value = "pageNo") int pageNo, 
			@RequestParam("sortField") String sortField,
			@RequestParam("sortDir") String sortDir,
			Model model) {
		int pageSize = 5;
		
		Page<JetPlane> page = jetPlaneService.findPaginated(pageNo, pageSize, sortField, sortDir);
		List<JetPlane> listJetPlanes = page.getContent();
		
		model.addAttribute("currentPage", pageNo);
		model.addAttribute("totalPages", page.getTotalPages());
		model.addAttribute("totalItems", page.getTotalElements());
		
		model.addAttribute("sortField", sortField);
		model.addAttribute("sortDir", sortDir);
		model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");
		
		model.addAttribute("listJetPlanes", listJetPlanes);
		return "index";
	}
}

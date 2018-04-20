package dombosco.controller;

import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import dombosco.dominio.Cliente;
import dombosco.service.ClienteService;

@Controller
public class ClienteController {
	
	@Autowired
	private ClienteService service;

	@GetMapping("/")
	public ModelAndView findAll() {

		ModelAndView mv = new ModelAndView("/cliente");
		System.out.println(service.findAll().size());
		mv.addObject("clientes", service.findAll());

		return mv;
	}

	@GetMapping("/add")
	public ModelAndView add(@Valid Optional<Cliente> optional) {

		ModelAndView mv = new ModelAndView("/ClienteAdd");
		mv.addObject("cliente", optional);

		return mv;
	}

	@GetMapping("/edit/{id}")
	public ModelAndView edit(@PathVariable("id") Long id) {

		return add(service.edit(id));
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Long id) {

		service.delete(id);

		return findAll();
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid Cliente post) {

		service.save(post);

		return findAll();
	}
}

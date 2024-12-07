package co.edu.uniminuto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.uniminuto.entity.Mascota;
import co.edu.uniminuto.service.IMascotaService;

@RestController
@CrossOrigin("*")
@RequestMapping(value="api")
public class MascotaController {
	
	@Autowired
	IMascotaService serv;
	
	
	@GetMapping(value="mascotas", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Mascota> getListMascotas(){
		return serv.listMascota();
	}
	
	@GetMapping(value="mascota/{id}", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Mascota getByPetsId(@PathVariable("id") int id) {
		return serv.searchByIdMascota(id);
	}
	
	@GetMapping(value="mascotas-mayor5", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Mascota> getListPets5(){
		return serv.listMascota5();
		
	}
	
	@GetMapping(value="mascotas-menor5", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public List<Mascota> getListPetsMenor5(){
		return serv.listMascotaMenor5();
		
	}
	
	@PostMapping(value="mascotas-menor5", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Mascota postPets(@RequestBody Mascota mascota) {
		return serv.addMascota(mascota);
	}
	
	@PutMapping(value="mascotas-menor5", produces=org.springframework.http.MediaType.APPLICATION_JSON_VALUE, consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public Mascota putPets(@RequestBody Mascota mascota) {
		return serv.upMascota(mascota);
	}
	
	

}

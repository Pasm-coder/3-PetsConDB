package co.edu.uniminuto.service;

import java.util.List;

import co.edu.uniminuto.entity.Mascota;

public interface IMascotaService {
	
	List<Mascota> listMascota();
	Mascota searchByIdMascota(int id);
	List<Mascota> listMascota5();
	List<Mascota> listMascotaMenor5();
	Mascota addMascota(Mascota mascota);
	Mascota upMascota(Mascota mascota);
	boolean delMascota(int id);

}

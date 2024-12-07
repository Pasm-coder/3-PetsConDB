package co.edu.uniminuto.dao;

import java.util.List;

import co.edu.uniminuto.entity.Mascota;

public interface IMascotaDao {
	
	
	List<Mascota> listMascota();
	Mascota searchByIdMascota(int id);
	Mascota addMascota(Mascota mascota);
	Mascota upMascota(Mascota mascota);
	boolean delMascota(int id);

	

}

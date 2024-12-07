package co.edu.uniminuto.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.uniminuto.entity.Mascota;

@Repository
public class MascotaDao implements IMascotaDao{
	
	@Autowired
	IMascotaJPA jpa;

	@Override
	public List<Mascota> listMascota() {
		return jpa.findAll();
	}

	@Override
	public Mascota searchByIdMascota(int id) {
		return jpa.findById(id).orElse(null);
	}

	@Override
	public Mascota addMascota(Mascota mascota) {
		return jpa.save(mascota);
	}

	@Override
	public Mascota upMascota(Mascota mascota) {
		return jpa.save(mascota);
	}

	@Override
	public boolean delMascota(int id) {
		return false;
	}

}

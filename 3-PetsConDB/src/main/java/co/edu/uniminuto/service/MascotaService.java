package co.edu.uniminuto.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.uniminuto.dao.IMascotaDao;
import co.edu.uniminuto.entity.Mascota;

@Service
public class MascotaService implements IMascotaService{
	
	@Autowired
	IMascotaDao dao;

	@Override
	public List<Mascota> listMascota() {
		return dao.listMascota();
	}

	@Override
	public Mascota searchByIdMascota(int id) {
		return dao.searchByIdMascota(id);
	}

	@Override
	public List<Mascota> listMascota5() {
		List<Mascota> lista = dao.listMascota().stream().filter(i->i.getMasEdad()>5).collect(Collectors.toList());
		return lista;
	}

	@Override
	public List<Mascota> listMascotaMenor5() {
		List<Mascota> lista = dao.listMascota().stream().filter(i->i.getMasEdad()<=5).collect(Collectors.toList());
		return lista;
	}

	@Override
	public Mascota addMascota(Mascota mascota) {
		if (!mascota.equals(null)) {
			return dao.addMascota(mascota);
		}
		return null;
	}

	@Override
	public Mascota upMascota(Mascota mascota) {
		if(searchByIdMascota(mascota.getMasId()).equals(null)){
			return dao.upMascota(mascota);
		} 
		return null;
	}

	@Override
	public boolean delMascota(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}

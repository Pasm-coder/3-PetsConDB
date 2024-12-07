package co.edu.uniminuto.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.uniminuto.entity.Mascota;

public interface IMascotaJPA extends JpaRepository<Mascota, Integer> {
	

}

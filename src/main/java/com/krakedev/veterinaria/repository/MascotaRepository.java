package com.krakedev.veterinaria.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long>{
    Optional<Mascota> findById(String idProductoa);
    Optional<Mascota> findByNombre(String nombreMascota);
    List<Mascota> findByEstado(EstadoMascota estado);
}

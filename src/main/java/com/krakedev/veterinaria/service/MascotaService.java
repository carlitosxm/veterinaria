package com.krakedev.veterinaria.service;

import java.util.List;
import java.util.Optional;

import com.krakedev.veterinaria.entity.EstadoMascota;
import com.krakedev.veterinaria.entity.Mascota;

public interface MascotaService {

    Mascota registrarMascota(Mascota mascota);
    List<Mascota> listasMascotas();
    Optional<Mascota> buscarPorNombre(String nombre);
    Optional<Mascota> buscasPorId(Long id);
    Mascota actualizarMascota(Long id, Mascota mascota);
    void eliminarMascota(Long id);
    Mascota cambiarEstadoMascota(Long id, EstadoMascota nuevoEstado);
    List<Mascota> obtenerPorEstado(EstadoMascota estado);
}

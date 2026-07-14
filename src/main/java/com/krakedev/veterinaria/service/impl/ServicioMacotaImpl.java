package com.krakedev.veterinaria.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.repository.MascotaRepository;
import com.krakedev.veterinaria.service.MascotaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ServicioMacotaImpl implements MascotaService {

    private final MascotaRepository mascotaRepository;

    @Override
    public Mascota registrarMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    @Override
    public List<Mascota> listasMascotas() {
        return mascotaRepository.findAll();
    }

    @Override
    public Optional<Mascota> buscarPorNombre(String nombre) {
        return mascotaRepository.findByNombre(nombre);
    }

    @Override
    public Optional<Mascota> buscasPorId(Long id) {
        return mascotaRepository.findById(id);
    }

    @Override
    public Mascota actualizarMascota(Long id, Mascota mascota) {
        return mascotaRepository.findById(id)
                .map(existente -> {
                    existente.setNombre(mascota.getNombre());
                    existente.setEspecie(mascota.getEspecie());
                    existente.setEdad(mascota.getEdad());
                    existente.setNombreDueno(mascota.getNombreDueno());
                    existente.setFechaRegistro(mascota.getFechaRegistro());
                    return mascotaRepository.save(existente);
                })
                .orElse(null);
    }

    @Override
    public void eliminarMascota(Long id) {
        mascotaRepository.deleteById(id);
    }
}

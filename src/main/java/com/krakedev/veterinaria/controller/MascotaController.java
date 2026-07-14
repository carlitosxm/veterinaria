package com.krakedev.veterinaria.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Mascota;

@RestController
@RequestMapping("/api/mascotas")
public class MascotaController {
    
    public List<Mascota> mascotas= new ArrayList<>();

    public MascotaController(){
        mascotas.add(new Mascota(1L, "n1", "e1", 1, "nd1", LocalDate.of(2026, 1, 10)));
        mascotas.add(new Mascota(2L, "m2", "e2", 2, "nd2", LocalDate.of(2026, 2, 15)));
        mascotas.add(new Mascota(3L, "m3", "e3", 3, "nd3", LocalDate.of(2026, 3, 20)));
        mascotas.add(new Mascota(4L, "m4", "e4", 4, "nd4", LocalDate.of(2026, 4, 25)));
        mascotas.add(new Mascota(5L, "m5", "e5", 5, "nd5", LocalDate.of(2026, 5, 30)));
    }

    @GetMapping
    public List<Mascota> listarMensajes(){
        return mascotas;
    }

    @GetMapping("/{id}")
    public Mascota obtenerMascotaId(@PathVariable Long id){
        Optional<Mascota> mascota = mascotas.stream()
        .filter(m -> m.getId().equals(id)).findAny();
        return mascota.orElse(null);
    }

    @PostMapping
    public Mascota agregarMascota(@RequestBody Mascota mascota){
        mascotas.add(mascota);
        return mascota;
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable Long id){
        mascotas.removeIf(m -> m.getId().equals(id));
    }

}

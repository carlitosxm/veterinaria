package com.krakedev.veterinaria.controller;

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
        mascotas.add(new Mascota(1, "n1", "e1", 1, "nd1"));
        mascotas.add(new Mascota(2,"m2","e2",2,"nd2"));
    }

    @GetMapping
    public List<Mascota> listarMensajes(){
        return mascotas;
    }

    @GetMapping("/{id}")
    public Mascota obtenerMascotaId(@PathVariable int id){
        Optional<Mascota> mascota = mascotas.stream()
        .filter(m -> m.getId() == id).findAny();
        return mascota.orElse(null);
    }

    @PostMapping
    public Mascota agregarMascota(@RequestBody Mascota mascota){
        mascotas.add(mascota);
        return mascota;
    }

    @DeleteMapping("/{id}")
    public void eliminarMascota(@PathVariable int id){
        mascotas.removeIf(m -> m.getId() == id);
    }

}

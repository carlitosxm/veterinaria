package com.krakedev.veterinaria.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.veterinaria.entity.Mascota;
import com.krakedev.veterinaria.service.MascotaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/mascotas")
@RequiredArgsConstructor
public class MascotaController {

    private final MascotaService mascotaService;

    @PostMapping("/registrar")
    public ResponseEntity<?> registrarMascota(@RequestBody Mascota mascota){
        Mascota nuevaMascota = mascotaService.registrarMascota(mascota);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaMascota);
    }

    @GetMapping
    public ResponseEntity<List<Mascota>> listarMascotas(){
        List<Mascota> mascotas = mascotaService.listasMascotas();
        return ResponseEntity.ok(mascotas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mascota> obtenerMascotaId(@PathVariable Long id){
        Optional<Mascota> mascota = mascotaService.buscasPorId(id);
        return mascota.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mascota> actualizarMascota(@PathVariable Long id, @RequestBody Mascota mascota){
        Mascota actualizada = mascotaService.actualizarMascota(id, mascota);
        if (actualizada == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMascota(@PathVariable Long id){
        mascotaService.eliminarMascota(id);
        return ResponseEntity.noContent().build();
    }
}

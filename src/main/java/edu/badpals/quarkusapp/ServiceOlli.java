package edu.badpals.quarkusapp;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ServiceOlli {
    public Usuaria cargaUsuaria(String nombre_usuaria) {
        Optional<Usuaria> usuaria = Usuaria.findByIdOptional(nombre_usuaria);
        return usuaria.isPresent()?
                usuaria.get():
                new Usuaria();
    }
}

package edu.badpals.quarkusapp.repository;

import edu.badpals.quarkusapp.dominio.Usuaria;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuariaRepository implements PanacheRepositoryBase<Usuaria,String> {
}

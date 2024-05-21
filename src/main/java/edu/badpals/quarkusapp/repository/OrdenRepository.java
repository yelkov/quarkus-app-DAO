package edu.badpals.quarkusapp.repository;

import edu.badpals.quarkusapp.dominio.Orden;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdenRepository implements PanacheRepositoryBase<Orden,Long> {
}

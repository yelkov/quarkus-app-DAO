package edu.badpals.quarkusapp;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdenRepository implements PanacheRepositoryBase<Orden,Long> {
}

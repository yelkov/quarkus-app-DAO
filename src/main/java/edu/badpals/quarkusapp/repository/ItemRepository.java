package edu.badpals.quarkusapp.repository;

import edu.badpals.quarkusapp.dominio.Item;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemRepository implements PanacheRepositoryBase<Item,String> {
}

package edu.badpals.quarkusapp;

import edu.badpals.quarkusapp.dominio.Item;
import edu.badpals.quarkusapp.dominio.Orden;
import edu.badpals.quarkusapp.dominio.Usuaria;
import edu.badpals.quarkusapp.repository.ItemRepository;
import edu.badpals.quarkusapp.repository.OrdenRepository;
import edu.badpals.quarkusapp.repository.UsuariaRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class ServiceOlli {

    @Inject
    UsuariaRepository usuariaRepository;
    @Inject
    ItemRepository itemRepository;
    @Inject
    OrdenRepository ordenRepository;

    public Usuaria cargaUsuaria(String nombre_usuaria) {
        Optional<Usuaria> usuaria = usuariaRepository.findByIdOptional(nombre_usuaria);
        return usuaria.isPresent()?
                usuaria.get():
                new Usuaria();
    }


    public Item cargaItem(String nombre_item) {
        Optional<Item> item = itemRepository.findByIdOptional(nombre_item);
        return item.isPresent()?
                item.get():
                new Item();
    }

    public List<Orden> cargaOrden(String nombre_usuaria) {
        List<Orden> ordenes = ordenRepository.listAll();
        Optional<Usuaria> usuaria = usuariaRepository.findByIdOptional(nombre_usuaria);

        List<Orden> ordenesFiltradas = new ArrayList<>();
        for (Orden orden : ordenes){
            if(orden.getUser().getNombre().equals(nombre_usuaria)){
                ordenesFiltradas.add(orden);
            }
        }

        return ordenesFiltradas;
    }

    public Orden comanda(String nombre_usuaria, String nombre_item) {
        Usuaria usuaria = usuariaRepository.findById(nombre_usuaria);
        Item item = itemRepository.findById(nombre_item);

        Orden orden = null;
        if( usuaria != null && item != null
            && usuaria.getDestreza() > item.getQuality()) {
           orden = new Orden(usuaria,item);
           ordenRepository.persist(orden);
        }

        return orden;
    }

    public List<Orden> comandaMultiple(String nombre_usuaria, List<String> items) {
        Usuaria usuaria = usuariaRepository.findById(nombre_usuaria);
        List<Orden> ordenes = new ArrayList<>();

        if(usuaria != null){
            for(String item : items){
                Orden orden = comanda(nombre_usuaria,item);
                if (orden != null) {
                    ordenes.add(orden);
                }
            }
        }
        return ordenes;
    }
}

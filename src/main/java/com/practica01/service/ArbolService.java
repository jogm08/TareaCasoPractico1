package com.practica01.service;

import com.practica01.domain.Arbol;
import java.util.List;

public interface ArbolService {
    
    // Se obtiene un listado de categorias en un List
    public List<Arbol> getArbol(boolean activos);
 
       // Se obtiene un Categoria, a partir del id de un categoria     
    public Arbol getArbol(Arbol arbol);          
    // Se inserta un nuevo categoria si el id del categoria esta vacío     
    // Se actualiza un categoria si el id del categoria NO esta vacío     
    public void save(Arbol arbol);          
    // Se elimina el categoria que tiene el id pasado por parámetro     
    public void delete(Arbol arbol);
}
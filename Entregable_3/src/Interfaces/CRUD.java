package Interfaces;

import java.util.List;

public interface CRUD<T> {
	void crear(T entidad);              // Create
    List<T> listar();              // Read - Obtener todos
    void actualizar(T entidad);         // Update
    T obtener(int ID);     		// Read - Obtener por clave
    //void eliminar(String clave);      // Delete
    
}
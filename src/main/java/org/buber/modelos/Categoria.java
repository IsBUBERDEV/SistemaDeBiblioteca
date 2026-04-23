package org.buber.modelos;
import java.util.ArrayList;

public class Categoria {
    private final int id;
    private final String nombre;
    private ArrayList<Libro> listaLibros;

    public Categoria(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.listaLibros = new ArrayList<>();
    }
    
    public void Agregarlibro(Libro libro){
        this.listaLibros.add(libro);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }

    @Override
    public String toString() {
        return "Categoria{" + "id=" + id + ", nombre=" + nombre + ", listaLibros=" + listaLibros + '}';
    }   
}

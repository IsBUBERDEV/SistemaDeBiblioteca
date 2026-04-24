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

    public void mostrarLibrosDeCategoria() {
        System.out.println("Libros en la categoría: " + this.nombre); 
        if (listaLibros.isEmpty()) {
            System.out.println("No hay libros registrados en esta categoría."); 
        } else {
            for (Libro libro : listaLibros) {
                System.out.println("- " + libro.getTitulo()); 
            }
        }
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

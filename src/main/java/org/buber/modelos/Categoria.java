package org.buber.modelos;
import java.util.ArrayList;

public class Categoria {
    private final int id;
    private final String nombre;
    private ArrayList<Libro> libros;

    private static int contador = 1;

    public Categoria(String nombre) {
        this.id = contador++; // ✔ id automático
        this.nombre = nombre;
        this.libros = new ArrayList<>();
    }

    // ✔ nombre corregido (camelCase)
    public void agregarLibro(Libro libro){
        this.libros.add(libro);
    }

    public void mostrarLibrosDeCategoria() {
        System.out.println("Libros en la categoría: " + this.nombre);

        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en esta categoría.");
        } else {
            for (Libro libro : libros) {
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

    // ✔ nombre corregido (lo que usa tu biblioteca)
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id=" + id +
                ", nombre=" + nombre +
                ", libros=" + libros +
                '}';
    }
}
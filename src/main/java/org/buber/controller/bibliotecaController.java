package org.buber.controller;
import java.util.Scanner;
import org.buber.modelos.*;

public class bibliotecaController {

    private Biblioteca biblioteca;
    private Scanner sc;

    public bibliotecaController() {
        biblioteca = new Biblioteca();
        sc = new Scanner(System.in);
    }
    public void iniciar(){
        int opcion;
        do{
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion){
                case 1:
                    crearCategoria();
                    break;
                case 2:
                    agregarAutor();
                    break;
                case 3:
                    agregarLibro();
                    break;
                case 4:
                    realizarPrestamo();
                    break;
                case 5:
                    devolverLibro();
                    break;
                case 6:
                    biblioteca.verLibrosDisponibles();
                    break;
                case 7:
                    verAutor();
                    break;
                case 8:
                    verLibrosPorCategoria();
                    break;
                case 9:
                    System.out.println("Las multas se calculan al devolver");
                case 10:
                    System.out.println("Estadisticas no implementadas.");
                case 11:
                    System.out.println("Saliendo.");
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion != 11);
    }
    private void mostrarMenu(){
        System.out.println("\n===== SISTEMA DE BIBLIOTECA =====");
        System.out.println("1. Crear Categoría");
        System.out.println("2. Agregar Autor");
        System.out.println("3. Agregar Libro");
        System.out.println("4. Realizar Préstamo");
        System.out.println("5. Devolver Libro");
        System.out.println("6. Ver Libros Disponibles");
        System.out.println("7. Ver Autor");
        System.out.println("8. Ver Libros por Categoría");
        System.out.println("9. Ver Multas");
        System.out.println("10. Estadísticas");
        System.out.println("11. Salir");
        System.out.print("Seleccione: ");
    }
    //metodos
    private void crearCategoria(){
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        Categoria c = new Categoria(nombre);
        biblioteca.agregarCategoria(c);

        System.out.println("Categoria agregada con ID: " + c.getId());
    }

    private void agregarAutor(){
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("País: ");
        String pais = sc.nextLine();

        System.out.print("Año nacimiento: ");
        int anio = sc.nextInt();
        sc.nextLine();

        Autor a = new Autor(nombre, pais, anio);
        biblioteca.agregarAutor(a);

        System.out.println("Autor agregado con ID: " + a.getId());
    }
    private void agregarLibro(){
        System.out.print("ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Título: ");
        String titulo = sc.nextLine();

        System.out.print("ID Autor: ");
        int idAutor = sc.nextInt();

        System.out.print("ID Categoría: ");
        int idCategoria = sc.nextInt();
        sc.nextLine();

        Autor autor = null;
        for (Autor a : biblioteca.getAutores()) {
            if (a.getId() == idAutor) {
                autor = a;
                break;
            }
        }

        Categoria categoria = null;
        for (Categoria c : biblioteca.getCategoria()) {
            if (c.getId() == idCategoria) {
                categoria = c;
                break;
            }
        }

        if (autor == null || categoria == null) {
            System.out.println("Autor o categoría no encontrados.");
            return;
        }

        Libro libro = new Libro(isbn, titulo, autor, categoria);
        categoria.agregarLibro(libro);

        System.out.println("Libro agregado.");
    }
    private void realizarPrestamo() {
        System.out.print("Título del libro: ");
        String titulo = sc.nextLine();

        System.out.print("Usuario: ");
        String usuario = sc.nextLine();

        System.out.print("Fecha préstamo: ");
        String fechaPrestamo = sc.nextLine();

        System.out.print("Fecha límite: ");
        String fechaLimite = sc.nextLine();

        Libro libro = null;

        for (Categoria c : biblioteca.getCategoria()) {
            for (Libro l : c.getLibros()) {
                if (l.getTitulo().equalsIgnoreCase(titulo)) {
                    libro = l;
                    break;
                }
            }
        }

        if (libro == null || !libro.isDisponible()) {
            System.out.println("Libro no disponible.");
            return;
        }

        Prestamo p = new Prestamo(
                biblioteca.getPrestamo().size() + 1,
                libro,
                usuario,
                fechaPrestamo,
                fechaLimite
        );

        biblioteca.agregarPrestamo(p);

        System.out.println("Préstamo realizado con ID: " + p.getId());
    }

    private void devolverLibro() {
        System.out.print("ID préstamo: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Fecha devolución: ");
        String fecha = sc.nextLine();

        double multa = biblioteca.devolverLibro(id, fecha);

        if (multa == -1) {
            System.out.println("Préstamo no encontrado.");
        } else if (multa > 0) {
            System.out.println("Devuelto con multa: $" + multa);
        } else {
            System.out.println("Devuelto sin multa.");
        }
    }

    private void verAutor() {
        System.out.print("ID Autor: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Autor a : biblioteca.getAutores()) {
            if (a.getId() == id) {
                System.out.println(a);
                return;
            }
        }

        System.out.println("Autor no encontrado.");
    }

    private void verLibrosPorCategoria() {
        System.out.print("ID Categoría: ");
        int id = sc.nextInt();
        sc.nextLine();

        for (Categoria c : biblioteca.getCategoria()) {
            if (c.getId() == id) {
                for (Libro l : c.getLibros()) {
                    System.out.println(l.getTitulo());
                }
                return;
            }
        }

        System.out.println("Categoría no encontrada.");
    }
}

package org.buber.modelos;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Categoria> categorias;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca() {
        categorias = new ArrayList<>();
        autores = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public ArrayList<Prestamo> getPrestamos() {
        return prestamos;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "categorias=" + categorias +
                ", autores=" + autores +
                ", prestamos=" + prestamos + '}';
    }

    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }
    public double devolverLibro(int idPrestamo, String fechaDevolucion) {
        for (Prestamo p : prestamos) {
            if (p.getId() == idPrestamo && !p.isDevuelto()) {

                p.setDevuelto(true);
                p.setFechaDevolucion(fechaDevolucion);

                double multa = 0;

                if (fechaDevolucion.compareTo(p.getFechaLimite()) > 0) {
                    multa = 2000;
                }

                return multa;
            }
        }
        return -1;
    }
    public void verLibrosDisponibles() {
        for (Categoria c : categorias) {
            for (Libro l : c.getLibros()) {
                if (l.isDisponible()) {
                    System.out.println(l.getTitulo());
                }
            }
        }
    }
    public double calcularMultas() {
        double total = 0;
        for (Prestamo p : prestamos) {
            if (p.isDevuelto() && p.getFechaDevolucion() != null) {
                if (p.getFechaDevolucion().compareTo(p.getFechaLimite()) > 0) {
                    total += 2000;
                }
            }
        }
        return total;
    }
    public int totalPrestamos() {
        return prestamos.size();
    }

    public int totalAutores() {
        return autores.size();
    }

    public int totalCategorias() {
        return categorias.size();
    }
}
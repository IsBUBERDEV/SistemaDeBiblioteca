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

    // GETTERS
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

    // AGREGAR
    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
    }

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    // DEVOLVER LIBRO
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
        return -1; // No se encontró el préstamo o ya estaba devuelto
    }

    // LIBROS DISPONIBLES (préstamos activos)
    public ArrayList<Prestamo> verDisponibles() {
        ArrayList<Prestamo> disponibles = new ArrayList<>();
        for (Prestamo p : prestamos) {
            if (!p.isDevuelto()) {
                disponibles.add(p);
            }
        }
        return disponibles;
    }

    // CÁLCULO DE MULTAS
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

    // ESTADISTICAS
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
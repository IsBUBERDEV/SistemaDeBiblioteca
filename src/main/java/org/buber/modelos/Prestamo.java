package org.buber.modelos;

public class Prestamo {
    private final int id;
    private Libro libro;
    private String usuario;
    private String fechaPrestamo;
    private String fechaLimite;
    private String fechaDevolucion;
    private boolean devuelto;

    public Prestamo(int id, Libro libro, String usuario, String fechaPrestamo, String fechaLimite) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaLimite = fechaLimite;
        this.devuelto = false;

        libro.prestar(); // el libro pasa a no disponible
    }

    public void devolverLibro() {
        libro.devolver();
        this.devuelto = true;
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public String getFechaLimite() {
        return fechaLimite;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public boolean isDevuelto() {
        return devuelto;
    }

    public void setDevuelto(boolean devuelto) {
        this.devuelto = devuelto;
        if (devuelto) {
            libro.devolver();
        }
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", libro=" + libro +
                ", usuario='" + usuario + '\'' +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaLimite='" + fechaLimite + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                ", devuelto=" + devuelto +
                '}';
    }
}
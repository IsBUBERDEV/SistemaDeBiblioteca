package org.buber.modelos;

public class Prestamo {
    private final int id;
    private Libro libro;
    private String usuario;
    private String fechaPrestamo;
    private String fechaDevolucion;

    public Prestamo(int id, Libro libro, String usuario, String fechaPrestamo, String fechaDevolucion) {
        this.id = id;
        this.libro = libro;
        this.usuario = usuario;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;

        libro.prestar(); // el libro pasa a no disponible
    }

    public void devolverLibro() {
        libro.devolver();
    }

    public int getId() {
        return id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(String fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public String getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(String fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id=" + id +
                ", libro=" + libro +
                ", usuario='" + usuario + '\'' +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                '}';
    }
}

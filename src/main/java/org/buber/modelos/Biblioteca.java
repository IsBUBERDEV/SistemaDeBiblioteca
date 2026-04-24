package org.buber.modelos;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Categoria> categorias;
    private ArrayList<Autor> autores;
    private ArrayList<Prestamo> prestamos;

    public Biblioteca(){
        categorias = new ArrayList<>();
        autores = new ArrayList<>();
        prestamos = new ArrayList<>();
    }

   
    // GETTERS
  

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Categoria> getCategorias(){
        return categorias;
    }

    public ArrayList<Prestamo> getPrestamos(){
        return prestamos;
    }

    // TO STRING
    

    @Override
    public String toString() {
        return "Biblioteca{" + 
                "categorias=" + categorias + 
                ", autores=" + autores + 
                ", prestamos=" + prestamos + '}';
    }

    // AGREGAR
    

    public void agregarCategoria(Categoria categoria){
        categorias.add(categoria);
    }

    public void agregarAutor(Autor autor){
        autores.add(autor);
    }

    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    // DEVOLVER LIBRO
   

    public double devolverLibro(int idPrestamo, String fechaDevolucion){
        for(Prestamo p : prestamos){

            if(p.getId() == idPrestamo && !p.isDevuelto()){
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

   
    // LIBROS DISPONIBLES
    // (en realidad préstamos activos)
  

    public ArrayList<Prestamo> verDisponibles(){
        ArrayList<Prestamo> disponibles = new ArrayList<>();

        for(Prestamo p : prestamos){
            if(!p.isDevuelto()){
                disponibles.add(p);
            }
        }

        return disponibles;
    }

  
    // DETALLE AUTOR
 

    public Autor buscarAutor(int id){
        for(Autor a : autores){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }

    
    // "LIBROS POR CATEGORIA"
  

    public ArrayList<Prestamo> prestamosPorCategoria(String nombreCategoria){
        ArrayList<Prestamo> lista = new ArrayList<>();

        for(Prestamo p : prestamos){
            if(p.getCategoria().getNombre().equalsIgnoreCase(nombreCategoria)){
                lista.add(p);
            }
        }

        return lista;
    }

   
    // MULTAS TOTALES
  

    public double calcularMultas(){
        double total = 0;

        for(Prestamo p : prestamos){
            if(p.isDevuelto()){
                if(p.getFechaDevolucion().compareTo(p.getFechaLimite()) > 0){
                    total += 2000;
                }
            }
        }

        return total;
    }

 
    // ESTADISTICAS


    public int totalPrestamos(){
        return prestamos.size();
    }

    public int totalAutores(){
        return autores.size();
    }

    public int totalCategorias(){
        return categorias.size();
    }
}
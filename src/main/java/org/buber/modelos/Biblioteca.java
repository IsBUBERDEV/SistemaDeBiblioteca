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

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<Categoria> getCategoria(){
        return categorias;
    }
    
    public ArrayList<Prestamo> getPrestamo(){
        return prestamos;
    }
    
    @Override
    public String toString() {
        return "Biblioteca{" + "categorias=" + categorias + ", autores=" + autores + ", prestamos=" + prestamos + '}';
    }
    
    public void agregarCategoria( Categoria categoria){
        categorias.add(categoria);
    }
    
    public void agregarAutor( Autor autor){
        autores.add(autor);
    }
    
    public void agregarPrestamo( Prestamo prestamo){
        prestamos.add(prestamo);
    }    
    
    public double devolverLibro(int idPrestamo, String fechaDevolucion){
        for(Prestamo p : prestamos){
            //comparando el id de un objeto p con el id seleccionado
            if(p.getId() == idPrestamo && !isDevuelto()){
                p.setDevuelto(true);
                p.setFechaDevolucion(fechaDevolucion);
                double multa = 0;
                
                //multa en caso de necesitar comparando las fechas con compareTo
                if (fechaDevolucion.compareTo(p.getFechaLimite()) > 0) {
                multa = 2000; 
                
                    return multa;
                }
            }
            
            return -1;
        }
    
    }

    
}
    return -1; // no encontrado
}
  
}

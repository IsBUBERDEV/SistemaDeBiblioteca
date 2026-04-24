package org.buber.modelos;

public class Autor {
    
    private static int contadorIdGlobal = 1;
    
    private int id;
    private final String nombre; 
    private String pais;
    private int añoNacimiento;
    
    

    public Autor(String nombre, String pais, int añoNacimiento) {
        this.id = getGenerarId(); 
        this.nombre = nombre;
        this.pais = pais;
        this.añoNacimiento = añoNacimiento;
    }
    //funcion statica con id para generar un id nuevo :)
    public static int getGenerarId(){
        return contadorIdGlobal++;
    }

    public static int getContadorIdGlobal() {
        return contadorIdGlobal;
    }
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getAñoNacimiento() {
        return añoNacimiento;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setAñoNacimiento(int añoNacimiento) {
        this.añoNacimiento = añoNacimiento;
    }

    @Override
    public String toString() {
        return "Autor{" + "id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", a\u00f1oNacimiento=" + añoNacimiento + '}';
    }
      
}

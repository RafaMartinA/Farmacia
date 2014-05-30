/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;

/**
 *
 * @author Gon
 */
public class principioActivo {
   private String nombre;
   private int mg;

    public int getMg() {
        return mg;
    }

    public String getNombre() {
        return nombre;
    }

    public void setMg(int mg) {
        this.mg = mg;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
   
     @Override
    public String toString() {       
         return "principio activo = "+nombre+" en al cantidad de "+ mg +"mg.";
        
    }
    
}

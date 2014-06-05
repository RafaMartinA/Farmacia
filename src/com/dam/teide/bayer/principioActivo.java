/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;

import java.io.Serializable;

/**
 *
 * @author DAM1
 */
public class principioActivo implements Serializable{
   private String nombre;
   private int mg;   

    public principioActivo(String nombre, int mg) {
        this.nombre = nombre;
        this.mg = mg;
    }     

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
         return "principio activo = "+nombre+" en al cantidad de "+ mg +"mg.\n";
        
    }
          @Override
     public boolean equals(Object obj) {
        principioActivo p = (principioActivo) obj;
        return nombre.equals(p.nombre);
    } 
    
}

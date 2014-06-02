/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;

import java.util.ArrayList;

/**
 *
 * @author Gon
 */
public class Medicamento {
    private String nombre, fechaFabric, fechacad,tipoM;
    private int precio, numU;
    private ArrayList<principioActivo> principiosActivo = new ArrayList<>();
    public Medicamento(String nombre, String fechaFabric, String fechacad, int precio, int numU, String tipoM) {
        this.nombre = nombre;
        this.fechaFabric = fechaFabric;
        this.fechacad = fechacad;
        this.precio = precio;
        this.numU = numU;
        this.tipoM=tipoM;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaFabric() {
        return fechaFabric;
    }

    public String getFechacad() {
        return fechacad;
    }

    public int getPrecio() {
        return precio;
    }

    public int getNumU() {
        return numU;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public ArrayList<principioActivo> getPrincipiosActivo() {
        return principiosActivo;
    }

    public void añadirPrincipiosActivo(principioActivo p) {
        this.principiosActivo.add(p);
        
    }
       @Override
      public String toString() {       
         return nombre +" unidades:"+numU+" precio unitario:"+precio+"€ fecha de fabricacion:"+fechaFabric+" fecha de caducidad:"+fechacad+" "+tipoM+"/n";        
    }
    
     @Override
     public boolean equals(Object obj) {
        Medicamento c = (Medicamento) obj;
        return nombre.equals(c.nombre);
    }     
}

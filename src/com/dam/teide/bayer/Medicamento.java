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
    private String nombre, fechaFabric, fechacad;
    private int precio, numU;
    ArrayList<principioActivo> principiosActivo = new ArrayList<>();

    public Medicamento(String nombre, String fechaFabric, String fechacad, int precio, int numU) {
        this.nombre = nombre;
        this.fechaFabric = fechaFabric;
        this.fechacad = fechacad;
        this.precio = precio;
        this.numU = numU;
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
    
    
     @Override
     public boolean equals(Object obj) {
        Medicamento c = (Medicamento) obj;
        return nombre.equals(c.nombre);
    }
}

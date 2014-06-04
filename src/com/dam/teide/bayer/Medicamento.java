/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;

import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Locale;
/**
 *
 * @author Gon
 */
public class Medicamento implements Comparable<Medicamento>{
    private String nombre;
    private boolean tipoM;
    private GregorianCalendar fechacad,fechaFabric; 
    private int numU, posicion=-1,posicionPrin=-1;
    private double precio;
    private ArrayList<principioActivo> principiosActivo = new ArrayList<>();
    public Medicamento(String nombre, double precio, int numU, Boolean tipoM) {
        this.nombre = nombre;
        this.fechaFabric= new GregorianCalendar(Locale.ENGLISH);
        this.fechacad= new GregorianCalendar(fechaFabric.get(GregorianCalendar.YEAR), fechaFabric.get(GregorianCalendar.MONTH), fechaFabric.get(GregorianCalendar.DAY_OF_MONTH)+30);
        this.precio = precio;
        this.numU = numU;
        this.tipoM=tipoM;
    }

    public void setPosicionPrin(int posicionPrin) {
        this.posicionPrin = posicionPrin;
    }

    public int getPosicionPrin() {
        return posicionPrin;
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }    

    public String getNombre() {
        return nombre;
    }

    public GregorianCalendar getFechaFabric() {
        return fechaFabric;
    }

    public GregorianCalendar getFechacad() {
        return fechacad;
    }

    public double getPrecio() {
        return precio;
    }

    public int getNumU() {
        return numU;
    }

    public void setNumU(int numU) {
        this.numU = numU;
    }
    

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isTipoM() {
        return tipoM;
    }    

    public ArrayList<principioActivo> getPrincipiosActivo() {
        return principiosActivo;
    }

    public void añadirPrincipiosActivo(principioActivo p) {
        this.principiosActivo.add(p);
        
    }
       @Override
      public String toString() {      
           SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
        String fechafabric = fmt.format(fechaFabric.getTime());
        String fechacad2 = fmt.format(fechacad.getTime());
         String tipo;
           if (tipoM) tipo= "Con factura";
           else tipo= "Sin factura";
         return nombre +" unidades:"+numU+" precio unitario:"+precio+"â‚¬ fecha de fabricacion:"+fechafabric+" fecha de caducidad:"+fechacad2+" "+tipo+"\n";        
    }
    
     @Override
     public boolean equals(Object obj) {
        Medicamento c = (Medicamento) obj;
        return nombre.equals(c.nombre);
    } 
     
     @Override
     public int compareTo(Medicamento m) {          
       if (fechacad.get(GregorianCalendar.YEAR) < m.fechacad.get(GregorianCalendar.YEAR)) return -1;
        else if (fechacad.get(GregorianCalendar.YEAR) == m.fechacad.get(GregorianCalendar.YEAR)){
            if (fechacad.get(GregorianCalendar.MONTH) < m.fechacad.get(GregorianCalendar.MONTH)) return -1;
            else if (fechacad.get(GregorianCalendar.MONTH) == m.fechacad.get(GregorianCalendar.MONTH)){
                if (fechacad.get(GregorianCalendar.DAY_OF_MONTH) < m.fechacad.get(GregorianCalendar.DAY_OF_MONTH)) return -1;
                else if (fechacad.get(GregorianCalendar.DAY_OF_MONTH) == m.fechacad.get(GregorianCalendar.DAY_OF_MONTH)) return 0;
                else return 1;                             
            } else return 1;
        } else return 1;
    }
}

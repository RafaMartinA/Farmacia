/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Gon
 */
public class Bayer {
    Scanner s = new Scanner(System.in);  
     private ArrayList<Medicamento> medicamento = new ArrayList<>();
    principioActivo p;   
     
     public boolean altaMedicamento(String nombre, String fechaFabric, String fechacad, int precio, int numU, String tipoM){ 
         Medicamento m = new Medicamento(nombre, fechaFabric, fechacad, precio, numU, tipoM);
         int i=0;
         boolean a = false;
         for ( i = 0; i < medicamento.size() ; i++) {
             if( medicamento.get(i).equals(nombre)) {
                  medicamento.get(i).setPrecio(precio);
                  a= true;               
             }             
         }          
         if(a) {
            for (int j = 0; j < medicamento.get(i).getPrincipiosActivo().size(); j++) {               
                m.añadirPrincipiosActivo(medicamento.get(i).getPrincipiosActivo().get(j));
            }     
            medicamento.add(m);
            return false;
        }
         else  {
             do{                 
                 p = new principioActivo();
                 System.out.println("Ponga el nombre del principio activo");
                 p.setNombre(s.nextLine());
                 System.out.println("Ponga los miligramos");
                 p.setMg(s.nextInt());
                 m.añadirPrincipiosActivo(p);
                 System.out.println("¿Quiere añadir otro principio activo?. Escriba 'Si' o 'No'");
             }while(s.nextLine().equals("Si"));                          
             medicamento.add(m);
             return true;
         }         
     }
     
     String busquedaMedicamento(String palabra, boolean opcion){
         String salida ="";
         int posicion= -1;
         if(opcion){
             for (int i = 0; i < medicamento.size(); i++) {
                 posicion = medicamento.get(i).getNombre().indexOf(palabra);
                 if (posicion!=-1) {
                     salida+= medicamento.get(i); 
                     for (int j = 0; j < medicamento.get(posicion).getPrincipiosActivo().size(); j++) {
                    salida+=medicamento.get(posicion).getPrincipiosActivo().get(j);
                    }
                }               
            }
         }
         else{
             for (int i = 0; i < medicamento.size(); i++) {
                 for (int j = 0; j < medicamento.get(j).getPrincipiosActivo().size(); j++) {              
                     posicion = medicamento.get(posicion).getPrincipiosActivo().get(i).getNombre().indexOf(salida);
                     if(posicion!=-1) {
                         salida+=medicamento.get(posicion).getPrincipiosActivo().get(j);
                         salida+=medicamento.get(j).toString();
                     }
                }
                 
             }             
         }
         return salida;         
     }
}

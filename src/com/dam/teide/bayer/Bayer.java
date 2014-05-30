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
    ArrayList<Medicamento> medicamento = new ArrayList<>();
    principioActivo p;   
     
     public boolean altaMedicamento(String nombre, String fechaFabric, String fechacad, int precio, int numU, String tipoM){ 
         Medicamento m = new Medicamento(nombre, fechaFabric, fechacad, precio, numU, tipoM);
         int i=0;
         boolean a = false;
         for (int h = 0; h < medicamento.size() ; h++) {
             if( medicamento.get(h).equals(nombre)) {
                  medicamento.get(h).setPrecio(precio);
                  a= true;
                  i=h;
             }             
         }          
         if(a) {
            for (int j = 0; j < medicamento.get(i).principiosActivo.size(); j++) {
                m.principiosActivo.add(medicamento.get(i).principiosActivo.get(j));
            }     
            medicamento.add(m);
            return false;
        }
         else  {
             do{                 
                 p = new principioActivo();
                 System.out.println("Ponga el nombre del principio activo");
                 p.nombre= s.nextLine();
                 System.out.println("Ponga los miligramos");
                 p.mg = s.nextInt();
                 m.principiosActivo.add(p);
                 System.out.println("¿Quiere añadir otro principio activo?. Escriba 'Si' o 'No'");
             }while(s.nextLine().equals("Si"));                          
             medicamento.add(m);
             return true;
         }         
     }
     
     public String busquedaMedicamentos (String busqueda, int opcion) {
         String total="";
         int posicion=-1;
         switch(opcion) {
             case 1: {
                  for (int i = 0; i < medicamento.size();i++) {
                      posicion= medicamento.get(i).getNombre().indexOf(busqueda);
                    if (posicion != -1) {
                        total+= medicamento.get(i).getNombre()+" ";
                        for (int j=0;j<medicamento.size();j++) {
                            total+=medicamento.get(posicion).principiosActivo.get(j);
                            }
                        }
                    }
                 }break;
             case 2 : {
                 for (int i=0; i<medicamento.get(i).principiosActivo.size();i++) {
                     posicion=medicamento.get(i).principiosActivo.get(i).nombre.indexOf(busqueda);
                     if(posicion !=-1) {
                         total+=medicamento.get(i)+" ";
                         total+=medicamento.get(i).principiosActivo.get(i)+" ";
                        }
                    }
                }break;         
        }
         return "La busqueda que ha realizado se compone de : "+total;
   }
}

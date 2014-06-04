/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author DAM1
 */
public class Bayer {       
    private ArrayList<Medicamento> medicamento = new ArrayList<>();
    private ArrayList<Medicamento> venta;
    Medicamento m; 
    principioActivo p;   
     
    public void altaPrincipioActivo(String nombre, int mg, int numero){
         p = new principioActivo(nombre, mg);    
         m.añadirPrincipiosActivo(p);  
         numero--;
         if (numero == 0) medicamento.add(m);            
          }
     public boolean altaMedicamento(String nombre, double precio, int numU, boolean tipoM){ 
         int posicion=0;
         m = new Medicamento(nombre, precio, numU, tipoM);
         int i=0;
         boolean a = false;
         for ( i = 0; i < medicamento.size() ; i++) {
             if( medicamento.get(i).equals(m)) {
                  medicamento.get(i).setPrecio(precio);                  
                  a= true;    
                  posicion=i;
             }             
         }          
         if(a) {
            for (int j = 0; j < medicamento.get(posicion).getPrincipiosActivo().size(); j++) {               
                m.añadirPrincipiosActivo(medicamento.get(posicion).getPrincipiosActivo().get(j));
            }     
            medicamento.add(m);
            return true;
        }
         else return false;
                 
     }
     
     String busquedaMedicamento(String palabra, boolean opcion){
         String salida ="";        
         int posicion= -1;
         if(opcion){
             for (int i = 0; i < medicamento.size(); i++) {
                 posicion = medicamento.get(i).getNombre().indexOf(palabra);
                 if (posicion!=-1) {
                     salida+= medicamento.get(i).toString(); 
                     for (int j = 0; j < medicamento.get(posicion).getPrincipiosActivo().size(); j++) {
                    salida+=medicamento.get(posicion).getPrincipiosActivo().get(j);
                    }
                }               
            }
         }
         else{
             for (int i = 0; i < medicamento.size(); i++) {
                 for (int j = 0; j < medicamento.get(i).getPrincipiosActivo().size(); j++) {              
                     posicion = medicamento.get(i).getPrincipiosActivo().get(j).getNombre().indexOf(palabra);
                     if(posicion!=-1) {
                         salida+=medicamento.get(i).getPrincipiosActivo().get(j);
                         salida+=medicamento.get(i);
                     }
                }
                 
             }             
         }
         return salida;   
     }
     String ventaMedicamento(String palabra, boolean opcion){
         String salida ="";
         venta = new ArrayList<>();
         int posicion= -1;
         if(opcion){           
             for (int i = 0; i < medicamento.size(); i++) {                 
                 posicion = medicamento.get(i).getNombre().indexOf(palabra);
                 if (posicion!=-1) {
                     salida+= medicamento.get(i);
                     medicamento.get(i).setPosicion(i);
                     venta.add(medicamento.get(i));
                     for (int j = 0; j < medicamento.get(posicion).getPrincipiosActivo().size(); j++) {
                    salida+=medicamento.get(posicion).getPrincipiosActivo().get(j);
                    }
                }               
            }
             for (int i = 0; i < venta.size()-1; i++) {
                 if(venta.get(i).equals(venta.get(i+1)));
                 else return salida;                     
             } return venta.get(0).getNombre();
         }
         else{            
             for (int i = 0; i < medicamento.size(); i++) {
                 for (int j = 0; j < medicamento.get(i).getPrincipiosActivo().size(); j++) {              
                     posicion = medicamento.get(i).getPrincipiosActivo().get(j).getNombre().indexOf(palabra);
                     if(posicion!=-1) {
                         salida+=medicamento.get(i).getPrincipiosActivo().get(posicion);
                         salida+=medicamento.get(i);
                         medicamento.get(i).setPosicion(i);
                         medicamento.get(i).setPosicionPrin(posicion);
                         venta.add(medicamento.get(i));
                     }
                }                 
             }
             for (int i = 0; i < venta.size()-1; i++) {
                 if(venta.get(i).getPrincipiosActivo().get(venta.get(i).getPosicionPrin()).equals(venta.get(i+1).getPrincipiosActivo().get(venta.get(i+1).getPosicionPrin())));
                 else return salida;                     
             } return venta.get(0).getPrincipiosActivo().get(venta.get(0).getPosicionPrin()).getNombre() ;
         }         
     }
     String ventaMedicamento2(String palabra, boolean opcion ){  
         boolean iguales=false;            
         String salida ="";         
         int posicion= -1;
         if(opcion){           
             for (int i = 0; i < venta.size(); i++) {                 
                 posicion = venta.get(i).getNombre().indexOf(palabra);
                 if (posicion!=-1) {
                     salida+= venta.get(i);                                          
                     for (int j = 0; j < venta.get(posicion).getPrincipiosActivo().size(); j++) {
                    salida+=venta.get(posicion).getPrincipiosActivo().get(j);
                    }
                }  else{
                     venta.remove(i);
                     i--;
                 }             
            }
             for (int i = 0; i < venta.size(); i++) {
                if(venta.get(i).getNombre().equals(palabra)){
                     iguales = true;
                 }
             }    
            if (iguales){
                for (int i = 0; i < venta.size(); i++) {
                    if(!(venta.get(i).getNombre().equals(palabra))) venta.remove(i);              
            }return venta.get(0).getNombre();
             }
             else return salida;
         }
             
         else{            
             for (int i = 0; i < venta.size(); i++) {                 
                 for (int j = 0; j < venta.get(i).getPrincipiosActivo().size(); j++) {              
                     posicion = venta.get(i).getPrincipiosActivo().get(j).getNombre().indexOf(palabra);
                     if(posicion!=-1) {
                         salida+=venta.get(i).getPrincipiosActivo().get(j);
                         salida+=venta.get(i);                                                
                     } else{
                         venta.remove(i);
                         i--;
                     }
                }                 
             }
             for (int i = 0; i < venta.size(); i++) {
                  if(venta.get(i).getPrincipiosActivo().get(venta.get(i).getPosicionPrin()).getNombre().equals(palabra)) iguales=true;                                     
              }
              if (iguales) {                 
                 for (int i = 0; i < venta.size(); i++) {
                     if(!(venta.get(i).getPrincipiosActivo().get(venta.get(i).getPosicionPrin()).getNombre().equals(palabra))) venta.remove(i);
                  }
              } else return salida;
              return venta.get(0).getPrincipiosActivo().get(venta.get(0).getPosicionPrin()).getNombre();
         }
     }
     double ventaMedicamentoFinal(int numU){
         Collections.sort(venta);
         int total=0;
         boolean tipoM = false;
         for (int i = 0; i < venta.size(); i++) {
             total+=venta.get(i).getNumU();
         }
         if (total< numU) return -1;
         else {
             for (int i = 0; i < venta.size()||tipoM==true; i++) {                 
               if(venta.get(i).getNumU()-numU<=0) {
                   numU=numU-venta.get(i).getNumU();
                   if(venta.get(i).isTipoM()==true){
                       tipoM=true;                       
                   } 
               }  
               else if(tipoM)return -2;
             }  return 2;           
         }
                   
     }
     double restaUnidades(int numU, boolean opcion){             
         if(opcion){             
             for (int i = 0; i < venta.size(); i++) {
                medicamento.get(venta.get(i).getPosicion()).setNumU(medicamento.get(venta.get(i).getPosicion()).getNumU()-numU);
                if(medicamento.get(venta.get(i).getPosicion()).getNumU()<0){                 
                    numU=Math.abs(medicamento.get(venta.get(i).getPosicion()).getNumU());
                    medicamento.get(venta.get(i).getPosicion()).setNumU(0);     
                } else return venta.get(0).getPrecio();
             }
             return venta.get(0).getPrecio();
             
        }else{             
             double total=0;
             for (int i = 0; i < venta.size(); i++) {                   
                medicamento.get(venta.get(i).getPosicion()).setNumU(medicamento.get(venta.get(i).getPosicion()).getNumU()-numU);
                if(medicamento.get(venta.get(i).getPosicion()).getNumU()<0){                 
                    numU=Math.abs(medicamento.get(venta.get(i).getPosicion()).getNumU());
                    medicamento.get(venta.get(i).getPosicion()).setNumU(0);  
                    total+=venta.get(i).getPrecio()*venta.get(i).getNumU();
                } else{
                    total+=venta.get(i).getPrecio()*(venta.get(i).getNumU()-medicamento.get(venta.get(i).getPosicion()).getNumU());
                    return total;
                }
           }             
           return total;
         }
        
    }
     void borrarMedicamentos(){
    for (int i = 0; i < venta.size(); i++) {
            medicamento.remove(venta.get(i).getPosicion());
         }
    
    }
}

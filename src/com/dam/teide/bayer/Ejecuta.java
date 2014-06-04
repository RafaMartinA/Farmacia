/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;
import java.util.Scanner;
/**
 *
 * @author Gon
 */
public class Ejecuta {
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);   
        Bayer b = new Bayer();       
        int opcion = 0;       
        do{      
            System.out.println("1. Abrir farmacia");
            System.out.println("2. Meter medicamento");
            System.out.println("3. Buscar medicamento");
            System.out.println("4. Buscar principio activo");     
            System.out.println("5. Vender medicamento");
            System.out.println("6. Vender medicamento por principio activo");
            System.out.println("7. Cerrar farmacia");           
            opcion = s.nextInt();
            s.nextLine();
            switch(opcion){
                  case 1:{                      
                                       
                    break;
                }
                case 2:{
                    String nombre;
                    double precio;                   
                    String factura;
                    boolean tipoM;
                    System.out.println("Ponga el nombre del medicamento.");
                    nombre = s.nextLine();
                    System.out.println("Ponga el precio del "+nombre);
                    precio=s.nextDouble();
                    s.nextLine();
                    System.out.println("Ponga si necesita receta o no, escriba: 'Si' o 'No'");
                    factura=s.nextLine();
                    if(factura.toLowerCase().equals("si")||factura.toLowerCase().equals("sÃ­")||factura.equals("'Si'")) tipoM=true;
                    else tipoM=false;
                    System.out.println("Ponga el numero de unidades");
                    if(!b.altaMedicamento(nombre, precio, s.nextInt(), tipoM)){                                              
                        System.out.println("Â¿Cuantos productos activos tiene este medicamento?");                        
                        for (int i = s.nextInt(); i >0; i--) {
                            s.nextLine();
                            System.out.println("Ponga el nombre del producto activo");
                            nombre=s.nextLine();
                            System.out.println("Ponga los mg que hay de "+nombre);                           
                            b.altaPrincipioActivo(nombre, s.nextInt(), i);
                        }
                       
                    }
                    break;
                }
                case 3:{       
                    String salida;
                    System.out.println("Ponga el nombre del medicamento o busque por palabras clave");
                    salida=b.busquedaMedicamento(s.nextLine(), true);
                    if(salida.equals("")) System.out.println("No se encuentra ningun medicamento");
                    else System.out.println(salida);
                    break;
               }
               case 4:{       
                    String salida;
                    System.out.println("Ponga el nombre del principio activo o busque por palabras clave");
                    salida=b.busquedaMedicamento(s.nextLine(), false);
                    if(salida.equals("")) System.out.println("No se encuentra principio activo");
                    else System.out.println(salida);
                    break;
               }
             case 5:{       
                    String salida;
                    System.out.println("Ponga el nombre del del medicamento o busque por palabras clave");
                    salida=b.ventaMedicamento(s.nextLine(), true);
                    do{
                        if(salida.equals("")) System.out.println("No se encuentra ningun medicamento");
                        else if(salida.lastIndexOf("\n")>=0){
                        System.out.println("Se han encontrado estos resultados:\n"+salida+"\nÂ¿Cual de estos medicamentos es el que quiere vender?, ponga el nombre.");                        
                        salida=b.ventaMedicamento2(s.nextLine(), true);
                    }                 
                    }while(salida.lastIndexOf("\n")>=0);  
                    int numU;
                    double result;
                    System.out.println("Â¿Cuantas unidades quiere vender de "+salida+"?"); 
                    numU=s.nextInt();
                    s.nextLine();
                    result=b.ventaMedicamentoFinal(numU);
                    if(result==-1) {
                        System.out.println("No hay suficientes unidades");
                        break;
                    }
                    else if(result==-2){
                        String factura;
                        System.out.println("Este medicamento necesita receta, Â¿Dispone de ella?, escriba: 'Si' o 'No'");
                       factura=s.nextLine();
                    if(factura.toLowerCase().equals("si")||factura.toLowerCase().equals("sÃ­")||factura.equals("'Si'"));
                    else break;
                    }
                    System.out.println("El precio a pagar es de: "+numU*b.restaUnidades(numU,true)+"\nPulse una tecla para continuar");
                    s.nextLine();                                      
                    break;                    
               }
         
           }             
        }while(opcion!=7);
    }
 }





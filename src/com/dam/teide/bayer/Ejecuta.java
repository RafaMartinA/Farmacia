/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dam.teide.bayer;
import java.util.Scanner;
/**
 *
 * @author DAM1
 */
public class Ejecuta {
public static void main(String[] args) {
        Scanner s = new Scanner(System.in);   
        Bayer b = new Bayer();       
        int opcion = 0;   
        boolean farmacia = false;
        do{      
            System.out.println("1. Abrir farmacia");
            System.out.println("2. Meter medicamento");
            System.out.println("3. Buscar medicamento");
            System.out.println("4. Buscar principio activo");     
            System.out.println("5. Vender medicamento");
            System.out.println("6. Vender medicamento por principio activo");
            System.out.println("7. Borrar un medicamento");
            System.out.println("8. Cerrar farmacia");           
            opcion = s.nextInt();
            s.nextLine();
            switch(opcion){
                  case 1:{ 
                      if (!farmacia) {                          
                          String salida = b.abrirFarmacia();    
                          if(salida.equals("")) System.out.println("Farmacia abierta sin ningun producto caducado.");
                          else System.out.println("Los productos caducados son: \n"+salida);
                          farmacia = true;                          
                      }
                      else System.out.println("La farmacia ya esta abierta");
                     System.out.println("Pulse enter para continuar");
                     s.nextLine();

                    break;
                }
                case 2:{                   
                    boolean tipoM;
                    System.out.println("Ponga el nombre del medicamento.");
                    String nombre = s.nextLine();
                    System.out.println("Ponga el precio del "+nombre);
                    double precio=s.nextDouble();
                    s.nextLine();
                    System.out.println("Ponga si necesita receta o no, escriba: 'Si' o 'No'");
                    String receta=s.nextLine();
                    if(receta.toLowerCase().equals("si")||receta.toLowerCase().equals("sí")||receta.equals("'Si'")) tipoM=true;
                    else tipoM=false;
                    System.out.println("Ponga el numero de unidades");
                    if(!b.altaMedicamento(nombre, precio, s.nextInt(), tipoM)){                                              
                        System.out.println("¿Cuantos productos activos tiene este medicamento?");   
                        int cantidad= s.nextInt();
                        if (cantidad==0) b.altaPrincipioActivo("", 0, cantidad);
                        for ( ;cantidad >0; cantidad--) {                            
                            System.out.println("Ponga el nombre del producto activo");
                            nombre=s.nextLine();
                            System.out.println("Ponga los mg que hay de "+nombre);                          
                            b.altaPrincipioActivo(nombre, s.nextInt(), cantidad);
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
                    System.out.println("Pulse enter para continuar");
                    s.nextLine();
                    break;
               }
               case 4:{       
                    String salida;
                    System.out.println("Ponga el nombre del principio activo o busque por palabras clave");
                    salida=b.busquedaMedicamento(s.nextLine(), false);
                    if(salida.equals("")) System.out.println("No se encuentra principio activo");
                    else System.out.println(salida);
                    System.out.println("Pulse enter para continuar");
                    s.nextLine();
                    break;
               }
             case 5:{       
                    String salida;
                    System.out.println("Ponga una palabra similar al medicamento que quiere comprar");
                    salida=b.ventaMedicamento(s.nextLine(), true);
                            
                    do{                       
                        if(salida.lastIndexOf("\n")>=0){
                        System.out.println("Se han encontrado estos resultados:\n"+salida+"\n¿Cual de estos medicamentos es el que quiere comprar?, ponga el nombre.");                        
                        salida=b.ventaMedicamento2(s.nextLine(), true);
                    }                                 
                    }while(salida.lastIndexOf("\n")>=0);  
                    if(!salida.equals("")){
                        int numU;
                        double result;
                        System.out.println("¿Cuantas unidades quiere comprar de "+salida+"?"); 
                        numU=s.nextInt();
                        s.nextLine();
                        result=b.ventaMedicamentoFinal(numU);
                        if(result==-1) {
                            System.out.println("No hay suficientes unidades");
                            System.out.println("Pulse enter para continuar");
                            s.nextLine();
                            break;
                        }
                        else if(result==-2){
                            String receta;
                            System.out.println("Este medicamento necesita receta, ¿Dispone de ella?, escriba: 'Si' o 'No'");
                           receta=s.nextLine();
                        if(receta.toLowerCase().equals("si")||receta.toLowerCase().equals("sí")||receta.equals("'Si'")){
                            System.out.println("El precio a pagar es de: "+numU*b.restaUnidades(numU,true));                         
                        }
                        else System.out.println("No se puede comprar este medicamento sin receta.");


                        } else System.out.println("El precio a pagar es de: "+numU*b.restaUnidades(numU,true)); 
                    } else System.out.println("No se encuentra ningun medicamento");
                    System.out.println("Pulse enter para continuar");
                    s.nextLine();                    
                    break;                    
               }
             case 6:{
                 String salida;
                    System.out.println("Ponga una palabra similar al principio activo que quiere comprar");
                    salida=b.ventaMedicamento(s.nextLine(), false);
                    do{                        
                        if(salida.lastIndexOf("\n")>=0){
                        System.out.println("Se han encontrado estos resultados:\n"+salida+"\n¿Cual de estos principios activos es el que quiere vender?, ponga el nombre.");                        
                        salida=b.ventaMedicamento2(s.nextLine(), false);
                    }                                 
                    }while(salida.lastIndexOf("\n")>=0);  
                    if(!salida.equals("")){                        
                        int numU;
                        double result;
                        System.out.println("¿Cuantas unidades quiere comprar de "+salida+"?"); 
                        numU=s.nextInt();
                        s.nextLine();
                        result=b.ventaMedicamentoFinal(numU);
                        if(result==-1) {
                            System.out.println("No hay suficientes unidades");
                            System.out.println("Pulse enter para continuar");
                            s.nextLine();
                            break;
                        }
                        else if(result==-2){
                            String receta;
                            System.out.println("Este medicamento necesita receta, ¿Dispone de ella?, escriba: 'Si' o 'No'");
                           receta=s.nextLine();
                        if(receta.toLowerCase().equals("si")||receta.toLowerCase().equals("sí")||receta.equals("'Si'")){
                            System.out.println("El precio a pagar es de: "+b.restaUnidades(numU,false));                         
                        }
                        else System.out.println("No se puede comprar este principio activo sin receta.");


                        } else System.out.println("El precio a pagar es de: "+b.restaUnidades(numU,false)); 
                     } else System.out.println("No se encuentra ningun principio activo");
                     System.out.println("Pulse enter para continuar");
                     s.nextLine();
                    
                    break;         
             }
             case 7 : {                 
             
                 String salida;
                    System.out.println("Ponga una palabra similar al medicamento que quiere borrar");
                    salida=b.ventaMedicamento(s.nextLine(), true);
                    do{                       
                        if(salida.lastIndexOf("\n")>=0){
                        System.out.println("Se han encontrado estos resultados:\n"+salida+"\n¿Cual de estos medicamentos es el que quiere borrar?, ponga el nombre.");                        
                        salida=b.ventaMedicamento2(s.nextLine(), true);
                    }                                 
                    }while(salida.lastIndexOf("\n")>=0);  
                    if(!salida.equals("")){
                     b.borrarMedicamentos(true);
                        System.out.println("Medicamento borrado correctamente");
                    }else System.out.println("No se ha encontrado ningun medicamento");
                    System.out.println("Pulse enter para continuar");
                    s.nextLine();
                    break;
             } 
             case 8 : {
                 if (b.cerrarFarmacia()) System.out.println("Se ha guardado correctamente el inventario");
                 else System.out.println("No se ha podido guardar el inventario");
             }
               default: break;
         
           }             
        }while(opcion!=8);
    }
 }





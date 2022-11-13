
    
        
    
package com.mycompany.aplicacionhibernate;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import models.carta_productos;
import models.pedidos;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class AplicacionHibernate {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
            LocalDate todaysDate = LocalDate.now();
             pedidos  pedido = new pedidos();
             
        System.out.println(todaysDate);
          Time  araa=new Time(System.currentTimeMillis());
       
        
        limpiaPantalla();
		
		int opcion =1;
		while (opcion!=9) {
	imprimirMenu();
	
	opcion=leerEntrada();
    switch (opcion){
    case 0 : opcion= 0;
    		TodosLosPedidos();
    		  break;
    
    case 1:  opcion = 1;
     
    			Meter( araa,  todaysDate);
             break;
    case 2:  opcion = 2;
    			Borrar();
             break;
    case 3:  opcion = 3;
    			Actualizar();
             break;
    case 4:  opcion = 4;
			PedidosHoy();
             break;
   

	case 9:
	
		System.out.println("Has salido del programa");
		break;
		default:{System.out.println("ese número no existe en el menu");}
			
	} 
		
	if (opcion!=9) 
	System.out.println();
	System.out.println("Pulse enter para continuar");
	esperaPulsacion();
		}
	}
	
				public static void esperaPulsacion() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
				
	}

				public static int leerEntrada() {
	Scanner sc = new Scanner(System.in);
			int numero = sc.nextInt();
			return numero;
	}
				private static void limpiaPantalla() {

					
					for (int i=0;i<200;i++) {
						System.out.println();
					}
				}
					
				
				public static void imprimirMenu() {
					System.out.println("************************************");
					System.out.println("************ Menu Principal ********");
					System.out.println("************ Menu de Programas ********");
					 System.out.println("0 Ver todos los pedidos");
					 System.out.println("1 Anadir pedido");
     			      System.out.println("2 Borrar pedido");
     			      System.out.println("3 Marcar como recogido un producto");
     			      System.out.println("4 Pedidos de hoy");
     			      System.out.println("5 Pedidos por cliente");
     			      System.out.println("6 Numero de clientes");
     			     System.out.println("7 Plato mas consumido");
     			    System.out.println("8 Ingresos del ultimo mes");
					System.out.println("9 Salir ");
					System.out.println("************************************");
					System.out.println("Introduzca una opción:");
				}
      Scanner sc = new Scanner(System.in);
 
        
        
    private static void Meter(Time araa, LocalDate todaysDate){
        carta_productosDAOHib miau = new carta_productosDAOHib();
        
         for (var aa : miau.getAll()){  System.out.println(aa); };
    	   LocalDate fechaActual = LocalDate.now();
           
    	    Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nombre del cliente ");
            String nombre = sc.nextLine();
        pedidos p = new pedidos();
   
        p.setCliente(nombre);
        System.out.println("Introduce el numero del producto que desea" );
        int aer=0;
          for (var aa : miau.getAll()){  System.out.println(aer+++"  "+aa.getNombre()); };
        
        int producto = sc.nextInt();
        switch (producto){
        case 0:  producto = 0;
        	
        			p.setProducto_id(1);
                 break;
        case 1:  producto = 1;

		p.setProducto_id(2);
     break;
        case 2:  producto = 2;

		p.setProducto_id(3);
     break;
        }
        
        p.setFecha(fechaActual);
        p.setHora(araa);
        p.setEstado("En preparacion");
         PedidosDAOHib a = new PedidosDAOHib();
           
        a.save(p);
        System.out.println("Pedido añadido con exito:");
        System.out.println(a.get(p.getId_pedido()));
        
    }
    
    
        
        private static void TodosLosPedidos(){
             PedidosDAOHib a = new PedidosDAOHib();
               int aer=0;
          for (var aa : a.AllPedidos()){  System.out.println(aer+++"  "+aa); };
        }
        
        
        
        
        
        private static void  Borrar(){
               PedidosDAOHib a = new PedidosDAOHib();
                 ArrayList PedidosID = new ArrayList();
          for (var aae : a.AllPedidos()){PedidosID.add(aae.getId_pedido());}
              pedidos pedidoBorrar = new pedidos();
     int aer=0;
          for (var aa : a.AllPedidos()){  System.out.println(aer+++"  "+aa); };
                   System.out.println("escribe un numero de la lista");
                    Scanner sc = new Scanner(System.in);
                     int numeroelegido = sc.nextInt();
                int ara  =  (int) PedidosID.get(numeroelegido);
                     
                        pedidoBorrar= a.get(ara);
                        a.delete(pedidoBorrar);
             
        }
        
        
        
        
          private static void  Actualizar(){
                PedidosDAOHib a = new PedidosDAOHib();
                ArrayList PedidosID = new ArrayList();
          for (var aae : a.AllPedidos()){PedidosID.add(aae.getId_pedido());}
              pedidos pedidoActualizar = new pedidos();
     int aer=0;
          for (var aa : a.AllPedidos()){  System.out.println(aer+++"  "+aa); };
                   System.out.println("escribe un numero de la lista");
                    Scanner sc = new Scanner(System.in);
                     int numeroelegido = sc.nextInt();
                int ara  =  (int) PedidosID.get(numeroelegido);
                    
                        pedidoActualizar= a.get(ara);
                        
                     pedidoActualizar.setEstado("Recogido");
                     a.update(pedidoActualizar);
                     System.out.println(a.get(ara));
            
        }
             private static void  PedidosHoy(){
                   PedidosDAOHib a = new PedidosDAOHib();
                    for (var aa : a.PedidosHoy()){  System.out.println(aa); };
             }
              
          
        

        
          carta_productosDAOHib errerer = new carta_productosDAOHib();
         
       
    
    
       
      
        
    
       
        //
       
       
        
    
        
        
    
    }

    
    
        
    
    
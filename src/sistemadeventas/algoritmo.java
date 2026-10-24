/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemadeventas;

import java.util.Scanner;

/**
 *
 * @author MANOLO GOMEZ
 */
public class algoritmo {
    
    public static void compra() {
        Scanner teclado = new Scanner(System.in);
        
        //variables para menu y registro de ventas 
        int op;
        int cantidadproductos = 0;
        int i = 1;
        double subtotal = 0;
        double codigo = 0;
        String nombre ;
        double precio;
        int cantidad;
        int confirmar = 2;
        double descuento = 0;
        double montocondescuento;
        double iva;
        double total;
        double subtotalventa;
        int formadepago ;
        double efectivorecibido = 0;
        double cambio = 0;
        int ventaefectivo = 0;
        int ventatarjeta = 0;
        int ventatransferencia = 0;
        int n = 0;
    
        //variables consultar caja y estadisticas 
        int cantidadventas = 0;
        int productosvendidos = 0;
        double totalvendido = 0 ;
        double ventaMayor = 0;
        double ventaMenor = 0;
        double promedio;
        
        do {
            System.out.println("|=========================================|");
            System.out.println("|            SISTEMA DE VENTAS            |");
            System.out.println("|=========================================|");
            System.out.println("|1. registrar una venta                   |");
            System.out.println("|2. consultar caja                        |");
            System.out.println("|3. mostrar estadistica                   |");
            System.out.println("|4. salir                                 |");
            System.out.println("|=========================================|");
            System.out.println("opcion:");
            op = teclado.nextInt();
        
          
            //registrar venta 
            switch ( op ){
                case 1 -> {
                    System.out.println("cuantos productos tendra la venta");
                    cantidadproductos = teclado.nextInt();
                    
                    
                    if (cantidadproductos <= 0) {
                        System.out.println("la cantidad debe ser mayor a cero");
                        System.out.println("cuantos productos tendra la venta");
                        cantidadproductos = teclado.nextInt();
                    }
                    
                    
                    for (i=1; i<= cantidadproductos; i ++) {
                        
                        System.out.println("\n producto " +i );
                        
                        
                        
                        System.out.println("ingrese el codigo:");
                        codigo = teclado.nextInt();
                        
                        System.out.println("ingrese el nombre:");
                        nombre = teclado.next();
                        
                        System.out.println("ingrese el precio:");
                        precio = teclado.nextDouble();
                        while (precio <= 0){
                            System.out.println("el precio debe ser mayor a cero");
                            System.out.println("ingrese el precio:");
                            precio = teclado.nextDouble();
                        }
                        System.out.println("ingrese la cantidad:");
                        cantidad = teclado.nextInt();
                        while (cantidad <= 0 ){
                            System.out.println("la cantidad debe ser mayor que cero");
                            System.out.println("ingrese la cantidad:");
                            cantidad = teclado.nextInt();
                        }
                        
                        subtotal = subtotal + cantidad * precio;
                        
                    }
                    System.out.println("|=============================|");
                    System.out.println("|     RESUMEN DE COMPRA       |");
                    System.out.println("|=============================|");
                    
                    System.out.println("|El subtotal es .......Q"+ subtotal);
                    
                    
                    // descuento
                    if (subtotal <200){
                        descuento = 0;
                        System.out.println("|El descuentos es ......Q" + Math.round(descuento* 100.0) / 100.0);
                    }else if (subtotal >=200 && subtotal <500){
                        descuento = subtotal * 0.05;
                        System.out.println("|El descuentos es ......Q " + Math.round(descuento* 100.0) / 100.0);
                    }else if (subtotal >=500 && subtotal <1000 ){
                        descuento = subtotal * 0.08;
                        System.out.println("|El descuento es ......Q" +Math.round(descuento* 100.0) / 100.0);
                    }else if (subtotal >=1000){
                        descuento = subtotal *0.10;
                        System.out.println("|El descuento es ......Q" + Math.round(descuento* 100.0) / 100.0);
                    }
                    
                    montocondescuento= subtotal - descuento;
                    System.out.println("|monto con descuento ..Q" + montocondescuento);
                    
                    iva = montocondescuento *0.12;
                    System.out.println("|El iva es ............Q" + Math.round(iva* 100.0) / 100.0);
                    
                    total = montocondescuento + iva;
                    System.out.println("|El total es ..........Q" + Math.round(total * 100.0) / 100.0);
                    System.out.println("|=============================|");
                    System.out.println("");
                    
                    //forma de pago 
                    System.out.println("|-----------------------------|");
                    System.out.println("|        FORMA DE PAGO        |");
                    System.out.println("|-----------------------------|");
                    System.out.println("|1. efectivo                  |");
                    System.out.println("|2. tarjeta                   |");
                    System.out.println("|3. transferencia             |");
                    System.out.println("|-----------------------------|");
                    System.out.println("opcion:                      ");
                    
                    formadepago = teclado.nextInt();
                    
                    while (formadepago <1 && formadepago >3){
                        System.out.println("opcion invalida");
                        System.out.println("opcion");
                    }
                    switch (formadepago){
                        case 1 -> {
                            System.out.println ("efectivo");
                            System.out.println("El efectivo recibido es:");
                            efectivorecibido = teclado.nextDouble();
                            
                            while ( efectivorecibido < total ){ 
                                System.out.println("efectivo insuficiente");
                                cambio = efectivorecibido - total;
                                System.out.println("faltan Q:" + Math.round(cambio * 100.0) / 100.0);
                                System.out.println("El efectivo recibido es:");
                                efectivorecibido = teclado.nextDouble();
                                
                            }
                            cambio = efectivorecibido - total;
                            System.out.println("cambio Q:" + cambio);
                            ventaefectivo++;
                            System.out.println("");
                            break;
                        }
                        case 2 -> {
                            System.out.println("tarjeta");
                            System.out.println(".....deslizando tarjeta....bip...bip...");
                            System.out.println("............pago exitoso.............");
                            ventatarjeta++;
                            System.out.println("");
                            break;
                        }
                        case 3 -> {
                            System.out.println("transferencia");
                            System.out.println("......verificando transferencia.....");
                            System.out.println(".......transferencia recibida.......");
                            ventatransferencia++;
                            System.out.println("");
                            break;
                        }
                    }
                    //contadores y acumuladores generales
                    cantidadventas++;
                    productosvendidos = productosvendidos + cantidadproductos;
                    totalvendido = totalvendido + total;
                    
          
                    if(cantidadventas == 1){
                        ventaMayor = total;
                        ventaMenor = total;
                    }else {
                        if (total > ventaMayor){
                            ventaMayor = total;
                        }
                        if (total < ventaMenor){
                            ventaMenor = total;
                        }
                   }
                    // resumen de la compra o ticket de la compra 
                    System.out.println("|------------------------------------|");
                    System.out.println("|        DESCRIPCION DE FACTURA      |");
                    System.out.println("|------------------------------------|");
                    System.out.println("cantidad de productos ......."+ cantidadproductos);
                    System.out.println("subtotal.....................Q"+ subtotal);
                    System.out.println("descuento....................Q"+ descuento);
                    System.out.println("iva..........................Q"+ iva);
                    System.out.println("total........................Q"+ Math.round(total * 100.0) / 100.0);
                    switch (formadepago) {
                        case 1 -> {
                            System.out.println("efectivo recibido............Q"+ efectivorecibido);
                            System.out.println("cambio.......................Q"+ Math.round(cambio * 100.0) / 100.0 );
                        }
                        case 2 ->{
                            System.out.println("............pago exitoso......." );}
                        
                        case 3 -> {
                            System.out.println("........transferencia recibida.....");
                        }
                        
                    }
                    System.out.println("|------------------------------------|");
                    System.out.println("|         GRACIAS POR SU COMPRA      |");
                    System.out.println("|------------------------------------|");
                    System.out.println("");
                }
                case 2 -> {
                    System.out.println("");
                    System.out.println("|--------------------------------------|");
                    System.out.println("|          caja registradora           |");
                    System.out.println("|--------------------------------------|");
                    System.out.println("|ventas realizadas.................."+ cantidadventas);
                    System.out.println("|productos vendidos................."+ productosvendidos);
                    System.out.println("|total vendido...................Q"+ Math.round(totalvendido * 100.0) / 100.0);
                    System.out.println("|ventas en efectivo................."+ ventaefectivo);
                    System.out.println("|ventas con tarjeta................."+ ventatarjeta);
                    System.out.println("|ventas por transferencia..........."+ ventatransferencia);
                    System.out.println("|--------------------------------------|");
                    System.out.println();
                }
               
                    case 3 -> { 
                        promedio = totalvendido / cantidadventas;
                        System.out.println("|-----------------------------------------|");
                        System.out.println("|               ESTADISTICAS              |");
                        System.out.println("|-----------------------------------------|");
                        if (cantidadventas == 0){
                        System.out.println("|no existen ventas registradas            |");
                        System.out.println("|-----------------------------------------|");
                            System.out.println("");
                        }else{
                            System.out.println("|numero total de ventas................."+ cantidadventas);
                            System.out.println("|cantidad total de productos vendidos..."+productosvendidos);
                            System.out.println("|total de dinero vendido................"+ Math.round(totalvendido * 100.0) / 100.0);
                            System.out.println("|promedio de dinero por venta..........."+ Math.round(promedio* 100.0) / 100.0);
                            System.out.println("|-----------------------------------------|");
                            System.out.println("|ventas en efectivo....................."+ ventaefectivo);
                            System.out.println("|ventas con tarjeta....................."+ ventatarjeta);
                            System.out.println("|ventas por transferencia..............."+ ventatransferencia);
                            System.out.println("|-----------------------------------------|");
                            System.out.println("|venta de mayor valor..................."+ Math.round(ventaMayor * 100.0) / 100.0);
                            System.out.println("|venta de menor valor..................."+ Math.round(ventaMenor* 100.0) / 100.0);
                            System.out.println("|-----------------------------------------|");
                            System.out.println();
                        }
                }
                case 4 -> {
                    System.out.println("seguro que desea salir? (1 = si, 2 = no)");
                    confirmar = teclado.nextInt();
                    
                    while (confirmar !=1 && confirmar != 2){
                        System.out.println("opcion invalida");
                        System.out.println("seguro que desea salir?(1 = si, 2 = no)");
                        confirmar = teclado.nextInt();
                    }
                    if (confirmar == 1){
                        System.out.println("saliendo....");
                    }
                }
             
        }
                                   
        }while(confirmar !=1);
        }

    public algoritmo() {
    }
}

        

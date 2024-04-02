/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;
import javax.swing.UIManager;

/**
 *
 * @author Antonio Ramírez
 */
public class Main {

    public static void main(String[] args) {
        Tpv t1 = new Tpv();

        t1.encenderTpv();
      
        List<Producto> productos = Funciones.leerProductos("productos.csv");

     
        System.out.println("Productos:");
        for (Producto producto : productos) {
            System.out.println(producto.getIdProducto() + ", " + producto.getDescripcion() + ", " +
                    producto.getCategoria() + ", " + producto.getSubcategoria() + ", " +
                    producto.getPrecio() + ", " + producto.getIva().getTasa() + "%, " +
                    producto.getStock());
        }

       
        List<Ticket> tickets = new ArrayList<>();
        tickets.add(new Ticket(productos.subList(0, 3))); 
        tickets.add(new Ticket(productos.subList(3, 6))); 

   
        Funciones.escribirTickets(tickets, "tickets.csv");
    }
    }


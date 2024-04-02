/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import static daw.Categoria.BEBIDA;
import static daw.Categoria.COMIDA;
import static daw.Categoria.POSTRE;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author rocio
 */
public class Funciones {

  public static List<Producto> crearCarta() {
    List<Producto> carta = new ArrayList<>();

    carta.add(new Producto("Solomillo de cerdo", Categoria.COMIDA, Subcategoria.CARNE, 10.0, 20));
    carta.add(new Producto("Secreto iberico", Categoria.COMIDA, Subcategoria.CARNE, 12.0, 15));
    carta.add(new Producto("Pinchitos de pollo", Categoria.COMIDA, Subcategoria.CARNE, 8.0, 25));
    carta.add(new Producto("Abadejo", Categoria.COMIDA, Subcategoria.PESCADO, 15.0, 10));
    carta.add(new Producto("Calamares", Categoria.COMIDA, Subcategoria.PESCADO, 9.0, 30));
    carta.add(new Producto("Gambas al pil pil", Categoria.COMIDA, Subcategoria.PESCADO, 18.0, 12));
    carta.add(new Producto("Ensalada mixta", Categoria.COMIDA, Subcategoria.VERDURA, 6.0, 40));
    carta.add(new Producto("Ensalada César", Categoria.COMIDA, Subcategoria.VERDURA, 7.0, 35));
    carta.add(new Producto("Revuelto de espárragos", Categoria.COMIDA, Subcategoria.VERDURA, 9.0, 20));
    carta.add(new Producto("Fanta", Categoria.BEBIDA, Subcategoria.REFRESCO, 2.0, 50));
    carta.add(new Producto("Coca-Cola", Categoria.BEBIDA, Subcategoria.REFRESCO, 2.0, 50));
    carta.add(new Producto("Nesteá", Categoria.BEBIDA, Subcategoria.REFRESCO, 2.5, 40));
    carta.add(new Producto("Cerveza", Categoria.BEBIDA, Subcategoria.ALCOHOLICA, 2.0, 30));
    carta.add(new Producto("Vino tinto", Categoria.BEBIDA, Subcategoria.ALCOHOLICA, 5.0, 25));
    carta.add(new Producto("Whisky", Categoria.BEBIDA, Subcategoria.ALCOHOLICA, 8.0, 15));
    carta.add(new Producto("Zumo de piña", Categoria.BEBIDA, Subcategoria.ZUMO, 3.0, 35));
    carta.add(new Producto("Zumo de melocotón", Categoria.BEBIDA, Subcategoria.ZUMO, 3.0, 35));
    carta.add(new Producto("Zumo de naranja", Categoria.BEBIDA, Subcategoria.ZUMO, 3.0, 35));
    carta.add(new Producto("Zumo de manzana", Categoria.BEBIDA, Subcategoria.ZUMO, 3.0, 35));
    carta.add(new Producto("Agua con gas", Categoria.BEBIDA, Subcategoria.AGUA, 3.0, 20));
    carta.add(new Producto("Agua", Categoria.BEBIDA, Subcategoria.AGUA, 3.0, 20));
    carta.add(new Producto("Tarta de queso", Categoria.POSTRE, Subcategoria.NULL, 5.0, 20));
    carta.add(new Producto("Helado", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));
    carta.add(new Producto("Natillas", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));
    carta.add(new Producto("Arroz con leche", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));
    carta.add(new Producto("Tiramisu", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));
    carta.add(new Producto("Flan", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));
    carta.add(new Producto("Brownie", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));
    carta.add(new Producto("Mousse de chocolate", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));
    carta.add(new Producto("Crema catalana", Categoria.POSTRE, Subcategoria.NULL, 3.0, 20));

    return carta;
}
  
    public static List<Producto> crearLista(List<Producto> carta, Categoria c) {

        List<Producto> lista = new ArrayList<>();

        for (Producto producto : carta) {
            if (producto.getCategoria() == c) {
                lista.add(producto);
            }

        }
        return lista;
    }

    public static Producto mostrarMenuDesplegable(List<Producto> carta) {
        String[] opciones = new String[carta.size()];
        for (int i = 0; i < carta.size(); i++) {
            opciones[i] = carta.get(i).getDescripcion();
        }

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un producto:", "Menú",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        Producto productoADevolver = null;

        for (Producto producto : carta) {
            if (producto.getDescripcion().equals(seleccion)) {
                productoADevolver = producto;
                break;
            }
        }

        return productoADevolver;

    }

    public static Producto mostrarMenuDesplegablePrecio(List<Producto> carta) {
        DecimalFormat dosDecimales = new DecimalFormat("#.##");

        String[] opciones = new String[carta.size()];
        for (int i = 0; i < carta.size(); i++) {
            opciones[i] = carta.get(i).getDescripcion() + "    " + dosDecimales.format(carta.get(i).getPrecio()) + "€";
        }

        String seleccion = (String) JOptionPane.showInputDialog(null, "Seleccione un producto:", "Menú",
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == null) {
            return null;

        }

        Producto productoADevolver = null;

        for (Producto producto : carta) {
            if ((producto.getDescripcion() + "    " + dosDecimales.format(producto.getPrecio()) + "€").equals(seleccion)) {
                productoADevolver = producto;
                break;
            }
        }

        return productoADevolver;
    }

    public static List<String> mostrarId(List<Producto> carta) {
        List<String> formato = new ArrayList<>();

        for (Producto producto : carta) {
            String vale = """
                         "El id de %s es %d
                         """.formatted(producto.getDescripcion(), producto.getIdProducto());
            formato.add(vale);
        }
        return formato;
    }

    public static void anadirProducto(List<Producto> carta, String nombre, Categoria c, Subcategoria s) {

        Producto p1 = new Producto(nombre, c, s, 15.00, 10);

        if (p1.getCategoria() == null || p1.getSubcategoria() == null) {
            JOptionPane.showMessageDialog(null, "Producto no válido");
        } else {
            carta.add(p1);
            JOptionPane.showMessageDialog(null, "Producto añadido");
        }

    }

    public static void anadirProductoExcepciones(List<Producto> carta) {
        Categoria[] categorias = Categoria.values();
        Subcategoria[] subcategorias = Subcategoria.values();
        Subcategoria subcategoriaSeleccionada = Subcategoria.AGUA;
        Categoria categoriaSeleccionada = Categoria.BEBIDA;
        String nombre = "";
        boolean valido = true;
        boolean valido2 = true;

        do {
            try {

                nombre = JOptionPane.showInputDialog(null, "Introduce el nombre del producto");

                categoriaSeleccionada = (Categoria) JOptionPane.showInputDialog(null, "Seleccione una categoría:",
                        "Selección de Categoría", JOptionPane.QUESTION_MESSAGE, null, categorias, categorias[0]);

                do {

                    switch (categoriaSeleccionada) {
                        case POSTRE ->
                            subcategoriaSeleccionada = (Subcategoria) JOptionPane.showInputDialog(null, "Seleccione una subcategoría:",
                                    "Selección de Subcategoría", JOptionPane.QUESTION_MESSAGE, null, subcategorias, subcategorias[0]);
                        case COMIDA ->
                            subcategoriaSeleccionada = (Subcategoria) JOptionPane.showInputDialog(null, "Seleccione una subcategoría:",
                                    "Selección de Subcategoría", JOptionPane.QUESTION_MESSAGE, null, subcategorias, subcategorias[0]);
                        case BEBIDA ->
                            subcategoriaSeleccionada = (Subcategoria) JOptionPane.showInputDialog(null, "Seleccione una subcategoría:",
                                    "Selección de Subcategoría", JOptionPane.QUESTION_MESSAGE, null, subcategorias, subcategorias[0]);

                    }

                    if (categoriaSeleccionada == Categoria.COMIDA && (subcategoriaSeleccionada == Subcategoria.CARNE || subcategoriaSeleccionada == Subcategoria.PESCADO || subcategoriaSeleccionada == Subcategoria.VERDURA)) {
                        valido2 = false;
                    }
                    if (categoriaSeleccionada == Categoria.BEBIDA && (subcategoriaSeleccionada == Subcategoria.AGUA || subcategoriaSeleccionada == Subcategoria.ALCOHOLICA || subcategoriaSeleccionada == Subcategoria.REFRESCO || subcategoriaSeleccionada == Subcategoria.ZUMO)) {
                        valido2 = false;
                    }
                    if (categoriaSeleccionada == Categoria.POSTRE && (subcategoriaSeleccionada == Subcategoria.NULL)) {
                        valido2 = false;
                    }

                } while (valido2);

            } catch (NumberFormatException nfe) {
                valido = false;
            }
        } while (!valido);

        anadirProducto(carta, nombre, categoriaSeleccionada, subcategoriaSeleccionada);

    }

    public static void borrarProductoExcepciones(List<Producto> carta) {
        boolean valido = true;
        do {
            try {
                carta.remove(mostrarMenuDesplegable(carta));
                valido = true;
            } catch (NullPointerException npe) {
                valido = false;
            }
        } while (!valido);

    }

    public static void cambiarAtributos(Producto p) {

        String[] opcionesAtributos = {"Descripción", "Precio", "Stock"};
        int seleccionAtributo = JOptionPane.showOptionDialog(null, "Selecciona el atributo a cambiar", "Cambiar Atributo",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcionesAtributos,
                opcionesAtributos[0]);

        if (seleccionAtributo >= 0) {
            String nuevoValorStr = JOptionPane.showInputDialog("Introduce el nuevo valor para " + opcionesAtributos[seleccionAtributo] + ":");

            switch (seleccionAtributo) {
                case 0 ->
                    p.setDescripcion(nuevoValorStr);
                case 1 -> {
                    double nuevoPrecio = Double.parseDouble(nuevoValorStr);
                    p.setPrecio(nuevoPrecio);
                }
                case 2 -> {
                    int nuevoStock = Integer.parseInt(nuevoValorStr);
                    p.setStock(nuevoStock);
                }
            }
        }
    }

    public static String generarContrasena() {
        String caracteresMayuscula = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String caracteresMinuscula = "abcdefghijklmnopqrstuvwxyz";
        String caracteresNumeros = "0123456789";
        String caracteresEspeciales = "!@#$^&()_=+-*/%<>?[]{}";

        Random random = new Random();
        StringBuilder contraseña = new StringBuilder();

        int indiceMinuscula = random.nextInt(caracteresMinuscula.length());
        contraseña.append(caracteresMinuscula.charAt(indiceMinuscula));
        int indiceMayuscula = random.nextInt(caracteresMinuscula.length());
        contraseña.append(caracteresMayuscula.charAt(indiceMayuscula));
        int indiceNumeros = random.nextInt(caracteresNumeros.length());
        contraseña.append(caracteresNumeros.charAt(indiceNumeros));
        int indiceEspeciales = random.nextInt(caracteresEspeciales.length());
        contraseña.append(caracteresEspeciales.charAt(indiceEspeciales));

        for (int i = 1; i < 3; i++) {
            String caracteres = caracteresMayuscula + caracteresMinuscula + caracteresNumeros;
            int indice = random.nextInt(caracteres.length());
            char caracter = caracteres.charAt(indice);
            contraseña.append(caracter);
        }

        return contraseña.toString();
    }

    public static void menuInicial(List<Producto> carta) {
        String[] seleccion = {"Usuario", "Administrador", "Salir"};
        List<Ticket> tickets = new ArrayList<>();
        int opcion = 0;
        do {

            try {
                opcion = JOptionPane.showOptionDialog(null, "Elige una opcion", "Eleccion",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, seleccion, seleccion[0]);

                switch (opcion) {
                    case 0 ->
                        menuUsuario(carta, tickets);
                    case 1 -> {
                        String contrasena = generarContrasena();
                        System.out.println(contrasena);
                        verificarContrasena(contrasena);
                        menuAdministrador(carta, tickets);
                    }
                }
            } catch (NullPointerException npe) {
            }
        } while (opcion != 2);
    }

    public static boolean verificarContrasena(String contrasenya) {
        boolean valida = true;

        do {
            String entradaUsuario = JOptionPane.showInputDialog("Introduce la contraseña: ");

            if (entradaUsuario.equals(contrasenya)) {
                JOptionPane.showMessageDialog(null, "Contraseña correcta");
                valida = true;
            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
                valida = false;

            }

        } while (!valida);

        return valida;

    }

    public static void menuAdministrador(List<Producto> carta, List<Ticket> tickets) {
        String[] eleccionAdmin = {"Cambiar datos", "Añadir producto", "Borrar producto", "Consultar ventas", "Salir"};
        int admin;

        do {
            admin = JOptionPane.showOptionDialog(null, "Elige una acción",
                    "Eleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionAdmin, null);

            switch (admin) {
                case 0 -> {
                    Producto productoSeleccionado = mostrarMenuDesplegable(carta);
                    cambiarAtributos(productoSeleccionado);
                }
                case 1 ->
                    anadirProductoExcepciones(carta);
                case 2 ->
                    borrarProductoExcepciones(carta);
                case 3 ->
                    subMenuConsultarVentas(tickets); // Pendiente de hacer
            }
        } while (admin != 4);
    }

    public static void menuUsuario(List<Producto> carta, List<Ticket> tickets) {
        String[] eleccionUsuario = {"Ver comidas", "Ver bebidas", "Ver postres", "Carrito", "Volver atrás"};
        List<Producto> carrito = new ArrayList<>();
        int usuario = 0;
        int cantidad = 0;
        List<Integer> cantidades = new ArrayList<>();
        do {
            usuario = JOptionPane.showOptionDialog(null, "Elige una opción",
                    "Eleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionUsuario, eleccionUsuario[0]);

            switch (usuario) {

                case 0 -> {
                    Producto p1 = mostrarMenuDesplegablePrecio(crearLista(carta, Categoria.COMIDA));
                    if (p1 == null) {
                        break;
                    }
                    anadirCarrito(carrito, p1);
                    cantidad = obtenerCantidadProducto(p1);
                    cantidades.add(cantidad);
                }
                case 1 -> {
                    Producto p1 = mostrarMenuDesplegablePrecio(crearLista(carta, Categoria.BEBIDA));
                    if (p1 == null) {
                        break;
                    }
                    anadirCarrito(carrito, p1);
                    cantidad = obtenerCantidadProducto(p1);
                    cantidades.add(cantidad);

                }
                case 2 -> {
                    Producto p1 = mostrarMenuDesplegablePrecio(crearLista(carta, Categoria.POSTRE));
                    if (p1 == null) {
                        break;
                    }
                    anadirCarrito(carrito, p1);
                    cantidad = obtenerCantidadProducto(p1);
                    cantidades.add(cantidad);

                }
                case 3 -> {
                    verCarrito(carrito, cantidades, tickets);
                }
            }

        } while (usuario != 4);
    }

    private static int obtenerCantidadProducto(Producto producto) {
        String cantidadStr = JOptionPane.showInputDialog("¿Cuántas unidades de " + producto.getDescripcion() + " desea?");

        try {
            int cantidad = Integer.parseInt(cantidadStr);

            if (cantidad == 0) {
                JOptionPane.showMessageDialog(null, "Ingrese un número mayor a 0.", "Error", JOptionPane.ERROR_MESSAGE);
                return obtenerCantidadProducto(producto);
            } else if (cantidad > producto.getStock()) {
                JOptionPane.showMessageDialog(null, "Stock insuficiente para " + producto.getDescripcion(), "Error", JOptionPane.ERROR_MESSAGE);
                return obtenerCantidadProducto(producto);
            } else {
                producto.setStock(producto.getStock() - cantidad);
                return cantidad;
            }
        } catch (NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "Ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            return obtenerCantidadProducto(producto);
        }
    }

    public static void anadirCarrito(List<Producto> carrito, Producto p) {
        carrito.add(p);
    }

    public static void anadirTicket(List<Ticket> tickets, Ticket t) {
        tickets.add(t);
    }

    private static void verCarrito(List<Producto> carrito, List<Integer> cantidades, List<Ticket> tickets) {  //añadir que si pones dos produtos iguales se sumen las cantidades
        DecimalFormat dosDecimales = new DecimalFormat("#.##");
        String[] eleccionUsuario = {"Comprar", "No comprar", "Seguir comprando"};
        double totalPrecio = 0.0;
        double totalPrecioIva = 0;
        String[][] carritoMostrar = new String[carrito.size()][3];

        for (int i = 0; i < carrito.size(); i++) {
            Producto producto = carrito.get(i);
            int cantidad = cantidades.get(i);

            try {
                double precioTotal = producto.getPrecio() * cantidad;
                double precioTotalIva = precioTotal * (producto.getIva().getTasa() + 1);

                carritoMostrar[i][0] = String.valueOf(cantidad);
                carritoMostrar[i][1] = producto.getDescripcion();
                carritoMostrar[i][2] = dosDecimales.format(precioTotal);

                totalPrecio += precioTotal;
                totalPrecioIva += precioTotalIva;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Error");
            }
        }

        StringBuilder texto = new StringBuilder();
        for (String[] fila : carritoMostrar) {
            texto.append(fila[0]).append(" ").append(fila[1]).append(" ").append(fila[2]).append("€\n");
        }

        int comprar = JOptionPane.showOptionDialog(null, carrito.isEmpty() ? "El carrito esta vacío" : texto.toString() + "Total: " + dosDecimales.format(totalPrecio) + "€ " + " Con Iva: " + dosDecimales.format(totalPrecioIva) + "€",
                "Carrito", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, eleccionUsuario, eleccionUsuario[0]);

        switch (comprar) {
            case 0 ->
                realizarTransaccion(carrito, cantidades, totalPrecioIva, tickets);
            case 1 -> {
                carrito.clear();
                cantidades.clear();
            }
        }
       
    }

    public static void subMenuConsultarVentas(List<Ticket> tickets) {
        String[] eleccionVentas = {"Hoy", "Hasta una fecha", "Siempre", "Salir"};
        int consultaVentas = 0;

        consultaVentas = JOptionPane.showOptionDialog(null, "Consultar ventas de ",
                "Eleccion", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, eleccionVentas, null);
        switch (consultaVentas) {
            case 0 ->
                consultarVentasHoy(tickets);
            case 1 ->
                JOptionPane.showMessageDialog(null, "Hasta una fecha");
            case 2 ->
                JOptionPane.showMessageDialog(null, "Siempre");
        }
    }

    public static void consultarVentasHoy(List<Ticket> tickets) {
        List<Integer> ticketsHoy = new ArrayList<>();
        for (Ticket ticket : tickets) {
            if (ticket.getFecha().equals(LocalDate.now())) {
                ticketsHoy.add(ticket.getIdTicket());
            }
        }
        JOptionPane.showMessageDialog(null, ticketsHoy);
    }

    public static void realizarTransaccion(List<Producto> carrito, List<Integer> cantidades, double precio, List<Ticket> tickets) {
        boolean esNumeroDeCuatroDigitos = false;
        boolean esFecha = false;
        boolean esCvv = false;
        String ultimosCuatroDigitos = "";
        String fecha = "";
        String cvv = "";
        List<Tarjeta> tarjetasValidas = crearTarjetasValidas();

        do {
            ultimosCuatroDigitos = JOptionPane.showInputDialog(null, "Ingrese los últimos 4 dígitos de su tarjeta: ");

            esNumeroDeCuatroDigitos = ultimosCuatroDigitos.matches("\\d{4}");

            if (!esNumeroDeCuatroDigitos) {
                JOptionPane.showMessageDialog(null, "Número de tarjeta inválido. Por favor, inténtelo de nuevo.");
            }

        } while (!esNumeroDeCuatroDigitos);

        do {
            fecha = JOptionPane.showInputDialog(null, "Ingrese la fecha de caducidad de su tarjeta (MM/YY): ");

            esFecha = fecha.matches("(0[1-9]|1[0-2])\\/([0-9]{2})");

            if (!esFecha) {
                JOptionPane.showMessageDialog(null, "Fecha de caducidad inválida. Por favor, inténtelo de nuevo.");
            }

        } while (!esFecha);

        do {
            cvv = JOptionPane.showInputDialog(null, "Ingrese el CVV de su tarjeta: ");

            esCvv = cvv.matches("\\d{3}");

            if (!esCvv) {
                JOptionPane.showMessageDialog(null, "CVV inválido. Por favor, inténtelo de nuevo.");
            }

        } while (!esCvv);

        Tarjeta t1 = new Tarjeta(ultimosCuatroDigitos, fecha, cvv);

        if (t1.comprobarTarjeta(tarjetasValidas)) {
            if (precio < t1.getSaldo()) {
                t1.setSaldo(precio - t1.getSaldo());
                Ticket ticket = new Ticket(cantidades, carrito, precio);
                ticket.imprimirTicket();
                anadirTicket(tickets, ticket);
                carrito.clear();
            } else {
                JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Error", JOptionPane.ERROR_MESSAGE);
                carrito.clear();
            }
        }
    }

    public static List<Tarjeta> crearTarjetasValidas() {
        List<Tarjeta> tarjetasValidas = new ArrayList<>();

        tarjetasValidas.add(new Tarjeta("1234", "01/28", "123"));
        tarjetasValidas.add(new Tarjeta("4542", "01/28", "986"));
        tarjetasValidas.add(new Tarjeta("9886", "10/30", "548"));
        tarjetasValidas.add(new Tarjeta("9821", "09/26", "897"));

        for (Tarjeta tarjetaValida : tarjetasValidas) {
            System.out.println(tarjetaValida.toString());
        }

        return tarjetasValidas;
    }
    public static List<Producto> leerProductos(String nombreArchivo) {
        List<Producto> productos = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            br.readLine(); // Saltar la primera línea (encabezado)
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                String descripcion = partes[0];
                Categoria categoria = Categoria.valueOf(partes[1]);
                Subcategoria subcategoria = Subcategoria.valueOf(partes[2]);
                double precio = Double.parseDouble(partes[3]);
                int stock = Integer.parseInt(partes[4]);
                productos.add(new Producto(descripcion, categoria, subcategoria, precio, stock));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public static void escribirTickets(List<Ticket> tickets, String nombreArchivo) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Ticket ticket : tickets) {
                for (Producto producto : ticket.getProductos()) {
                    pw.print(producto.getIdProducto() + ",");
                }
                pw.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



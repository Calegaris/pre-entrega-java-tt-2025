package com.talentotech.calegaris.pedidosapp.principal;

import com.talentotech.calegaris.pedidosapp.modelos.Producto;
import com.talentotech.calegaris.pedidosapp.servicios.GestorPedidos;
import com.talentotech.calegaris.pedidosapp.servicios.GestorProductos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTest {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        GestorProductos gestorProductos = new GestorProductos();
        GestorPedidos gestorPedidos = new GestorPedidos(gestorProductos);

        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Agregar producto");
            System.out.println("2. Mostrar productos");
            System.out.println("3. Buscar producto por ID o nombre");
            System.out.println("4. Actualizar precio de producto");
            System.out.println("5. Actualizar stock de producto");
            System.out.println("6. Eliminar producto");
            System.out.println("7. Crear pedido");
            System.out.println("8. Mostrar pedidos realizados");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del producto: ");
                    String nombre = scanner.nextLine();

                    System.out.print("Precio: ");
                    double precio = scanner.nextDouble();

                    System.out.print("Stock: ");
                    int stock = scanner.nextInt();
                    scanner.nextLine(); // limpia buffer

                    gestorProductos.agregarProducto(nombre, precio, stock);
                    break;

                case 2:
                    gestorProductos.mostrarProductos();
                    break;

                case 3:
                    System.out.print("Buscar por ID (1) o Nombre (2): ");
                    int tipoBusqueda = scanner.nextInt();
                    scanner.nextLine();

                    if (tipoBusqueda == 1) {
                        System.out.print("Ingrese ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        gestorProductos.buscarPorId(id);
                    } else if (tipoBusqueda == 2) {
                        System.out.print("Ingrese nombre: ");
                        String nombreBusqueda = scanner.nextLine();
                        gestorProductos.buscarPorNombre(nombreBusqueda);
                    }
                    break;

                case 4:
                    System.out.print("ID del producto: ");
                    int idPrecio = scanner.nextInt();
                    System.out.print("Nuevo precio: ");
                    double nuevoPrecio = scanner.nextDouble();
                    gestorProductos.actualizarPrecio(idPrecio, nuevoPrecio);
                    break;

                case 5:
                    System.out.print("ID del producto: ");
                    int idStock = scanner.nextInt();
                    System.out.print("Nuevo stock: ");
                    int nuevoStock = scanner.nextInt();
                    gestorProductos.actualizarStock(idStock, nuevoStock);
                    break;

                case 6:
                    System.out.print("ID del producto a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("¿Estás seguro? (s/n): ");
                    String confirmacion = scanner.nextLine();
                    if (confirmacion.equalsIgnoreCase("s")) {
                        gestorProductos.eliminarProducto(idEliminar);
                    } else {
                        System.out.println("Eliminación cancelada.");
                    }
                    break;

                case 7:
                    //gestorPedidos.crearPedido(scanner); // Esto sí podría necesitar el scanner porque es más complejo
                    break;

                case 8:
                    gestorPedidos.mostrarPedidos();
                    break;

                case 0:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }

        scanner.close();



    }

}

package com.talentotech.calegaris.pedidosapp.servicios;

import com.talentotech.calegaris.pedidosapp.modelos.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorProductos {

    private List<Producto> listaProductos;

    public GestorProductos(){
        this.listaProductos = new ArrayList<>();
    }

    public void agregarProducto(String nombre, double precio, int cantidadEnStock){
        Producto producto = new Producto(nombre, precio, cantidadEnStock);

        listaProductos.add(producto);

        System.out.println("Producto agregado con éxito: " + producto.getNombre());
    }

    public void mostrarProductos(){

        if (listaProductos.isEmpty()){
            System.out.println("No hay productos registrados.");
        }else {
            System.out.println("Lista de productos registrados: ");
            for (Producto p : listaProductos){
                System.out.println(p);
            }
        }

    }


    public Producto buscarPorId(int id){
        for (Producto p : listaProductos) {
            if (p.getId() == id){
                return p;
            }

        }

        return null;

    }

    public List<Producto> buscarPorNombre(String nombre){

        List<Producto> resultados = new ArrayList<>();
        for (Producto p : listaProductos) {
            if (p.getNombre().equalsIgnoreCase(nombre)){
                resultados.add(p);
            }

        }

        return resultados;

    }

//    public boolean actualizarProducto(int id, Double nuevoPrecio, Integer nuevoStock){
//        Producto producto = buscarPorId(id);
//        if (producto != null){
//            if (nuevoPrecio != null && nuevoPrecio >= 0){
//                producto.setPrecio(nuevoPrecio);
//            }
//            if (nuevoStock != null && nuevoStock >= 0){
//                producto.setStock(nuevoStock);
//            }
//            System.out.println("Producto actualizado: " + producto);
//            return true;
//        } else {
//            System.out.println("Producto no encontrado con ID: " + id);
//            return false;
//        }
//    }
    //lo voy a dividir en dos funciones diferentes

    public boolean actualizarPrecio(int id, double nuevoPrecio) {
        Producto producto = buscarPorId(id);
        if (producto != null) {
            if (nuevoPrecio >= 0) {
                producto.setPrecio(nuevoPrecio);
                System.out.println("Precio actualizado: " + producto);
                return true;
            } else {
                System.out.println("El precio no puede ser negativo.");
            }
        } else {
            System.out.println("Producto no encontrado con ID: " + id);
        }
        return false;
    }

    public boolean actualizarStock(int id, int nuevoStock) {
        Producto producto = buscarPorId(id);
        if (producto != null) {
            if (nuevoStock >= 0) {
                producto.setStock(nuevoStock);
                System.out.println("Stock actualizado: " + producto);
                return true;
            } else {
                System.out.println("El stock no puede ser negativo.");
            }
        } else {
            System.out.println("Producto no encontrado con ID: " + id);
        }
        return false;
    }




    public boolean eliminarProducto(int id){
        Producto producto = buscarPorId(id);
        if (producto != null){
            Scanner teclado = new Scanner(System.in);
            System.out.println("Producto encontrado: "+producto.getNombre());
            System.out.println("¿Estás seguro de que querés eliminar el producto: ? (s/n)");
            String respuesta = teclado.nextLine();

            if (respuesta.equalsIgnoreCase("s")){
                listaProductos.remove(producto);
                System.out.println("Producto eliminado: " + producto.getNombre());
                return true;
            }else {
                System.out.println("Eliminacion cancelada");
                return false;
            }
        }else {
            System.out.println("No se encontró ningún producto con ese ID.");
            return false;
        }
    }

    //getter
     public List<Producto> getListaProductos(){
        return this.listaProductos;
     }



}

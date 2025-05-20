package com.talentotech.calegaris.pedidosapp.servicios;

import com.talentotech.calegaris.pedidosapp.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class GestorPedidos {

    private List<Pedido> pedidos = new ArrayList<>();
    private GestorProductos gestorProductos;

    public GestorPedidos(GestorProductos gestorProductos) {
        this.gestorProductos = gestorProductos;
    }

    public Pedido crearPedido(List<Integer> idsProductos, List<Integer> cantidades) {
        Pedido pedido = new Pedido();

        for (int i = 0; i < idsProductos.size(); i++) {
            int id = idsProductos.get(i);
            int cantidad = cantidades.get(i);

            Producto producto = gestorProductos.buscarPorId(id);
            if (producto != null && producto.getStock() >= cantidad) {
                pedido.agregarLinea(producto, cantidad);
                gestorProductos.actualizarStock(id, producto.getStock() - cantidad);
            } else {
                System.out.println("❌ No hay suficiente stock para el producto: " + (producto != null ? producto.getNombre() : "ID " + id));
            }
        }

        if (!pedido.getLineas().isEmpty()) {
            pedidos.add(pedido);
            System.out.println("Pedido creado con éxito:");
            System.out.println(pedido);
            return pedido;
        } else {
            System.out.println("No se pudo crear el pedido. Verificá los productos/stock.");
            return null;
        }
    }

    public void mostrarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("📭 No hay pedidos realizados aún.");
        } else {
            for (Pedido pedido : pedidos) {
                System.out.println(pedido);
            }
        }
    }




}

package com.talentotech.calegaris.pedidosapp.servicios;

import com.talentotech.calegaris.pedidosapp.modelos.LineaPedido;
import com.talentotech.calegaris.pedidosapp.modelos.Producto;

import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private static int contadorPedidos = 1;
    private int id;
    private List<LineaPedido> lineas;
    private double total;

    public Pedido(){
        this.id = contadorPedidos++;
        this.lineas = new ArrayList<>();
        this.total = 0.0;
    }

    public void agregarLinea(Producto producto, int cantidad){
        LineaPedido linea = new LineaPedido(producto, cantidad);
        lineas.add(linea);
        total += linea.calcularSubtotal();
    }

    public int getId() {
        return id;
    }

    public double getTotal() {
        return total;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido ID: ").append(id).append("\n");
        for (LineaPedido linea : lineas) {
            sb.append(" - ").append(linea.toString()).append("\n");
        }
        sb.append("Total: $").append(total).append("\n");
        return sb.toString();
    }


}

package com.talentotech.calegaris.pedidosapp.modelos;

public class Producto {
    private static int contProdu = 1; //con este contabilizo globalmente los productos
    private int id; //y con este los identifico
    private String nombre;
    private double precio;
    private int stock;


    public Producto(String nombre, double precio, int stock) {
        this.id = contProdu++; //aca le asigno el conteo global como id, el primero se asigna como 1 y se aumenta para el proximo
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    //estos son los get
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }

    //y estos los setters

    public void setId(int id) {
        this.id = id;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setPrecio(double precio) {
        this.precio = precio;
    }


    public void setStock(int stock) {
        this.stock = stock;
    }


    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantStock=" + stock +
                '}';
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package t1_poo_g1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author piere
 */
public class GestionProducto {
    private List<Producto> listaProductos = new ArrayList<>();
    private int contadorId = 1;

    public void agregarProducto(String nombre, String categoria, double precio) {
        Producto nuevo = new Producto(contadorId++, nombre, categoria, precio);
        listaProductos.add(nuevo);
        System.out.println("Producto agregado exitosamente.\n");
    }

    public void listarProductos() {
        if (listaProductos.isEmpty()) {
            System.out.println("No hay productos registrados.\n");
            return;
        }
        System.out.println("--- Lista de Productos ---");
        for (Producto p : listaProductos) {
            System.out.println(p);
        }
        System.out.println();
    }

    public void listarPorCategoria(String categoria) {
        boolean encontrado = false;
        System.out.println("--- Productos en categoria: " + categoria + " ---");
        for (Producto p : listaProductos) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No hay productos en esta categoria.\n");
        } else {
            System.out.println();
        }
    }

    public void actualizarProducto(int id, String nuevoNombre, String nuevaCategoria, double nuevoPrecio) {
        for (Producto p : listaProductos) {
            if (p.getId() == id) {
                p.setNombre(nuevoNombre);
                p.setCategoria(nuevaCategoria);
                p.setPrecio(nuevoPrecio);
                System.out.println("Producto actualizado exitosamente.\n");
                return;
            }
        }
        System.out.println("Producto no encontrado.\n");
    }
    public void buscarProductoPorNombre(String nombre) {
        boolean encontrado = false;
        System.out.println("--- Buscando producto: " + nombre + " ---");
        for (Producto p : listaProductos) {
            if (p.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                System.out.println(p);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro ningun producto con ese nombre.\n");
        } else {
            System.out.println();
        }
    }

    public void eliminarProducto(int id) {
        Iterator<Producto> it = listaProductos.iterator();
        while (it.hasNext()) {
            Producto p = it.next();
            if (p.getId() == id) {
                it.remove();
                System.out.println("Producto eliminado exitosamente.\n");
                return;
            }
        }
        System.out.println("Producto no encontrado.\n");
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica2;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de Pedido
        Pedido pedido = new Pedido("Repartidor 1", 5, 75, LocalDateTime.now());

        // Serializar el objeto Pedido
        try {
            FileOutputStream fileOut = new FileOutputStream("pedido.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(pedido);
            out.close();
            fileOut.close();
            System.out.println("El objeto Pedido ha sido serializado y guardado en 'pedido.ser'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

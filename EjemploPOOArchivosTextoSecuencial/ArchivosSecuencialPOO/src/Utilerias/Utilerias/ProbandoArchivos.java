/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilerias.Utilerias;
import paquete1.Profesor;

import java.io.*;
import java.util.Formatter;
import java.util.Scanner;

public class ProbandoArchivos {
    public static void main(String[] args) throws FileNotFoundException {
        Profesor profesores[]={new Profesor("Ivan","Auxiliar")
                , new Profesor("David","Principal"),
                new Profesor("Augusto","Estrella"),
                new Profesor("Pablo","Principal")};
        Formatter flujoSalida= new Formatter("MiPrueba.txt");
        int bandera=0;
        for (Profesor profeAux: profesores) {
            flujoSalida.format("%s %s\n",profeAux.obtenerNombre(),profeAux.obtenerTipo());
        }
        flujoSalida.close();
        Scanner flujoEntrada = new Scanner(new File("MiPrueba.txt"));
        Profesor profesores1 = new Profesor(flujoEntrada.next(),flujoEntrada.next());
        Profesor profesores2 = new Profesor(flujoEntrada.next(),flujoEntrada.next());
        System.out.println(profesores1);
        System.out.println(profesores2);

        Profes profes1[]={new Profes("Ivan","Auxiliar")
                , new Profes("David","Principal"),
                new Profes("Augusto","Estrella"),
                new Profes("Pablo","Principal")};
        try {
            //Flujo de SALIDA basada en bytes, para escribir objetos en Archivos
            ObjectOutputStream flujoSalida2 = new ObjectOutputStream(new FileOutputStream("Profes.prof"));
            flujoSalida2.writeObject(profes1[0]);
            flujoSalida2.writeObject(profes1[1]);
            flujoSalida2.writeObject(profes1[2]);
            flujoSalida2.writeObject(profes1[3]);
            flujoSalida2.close();

            //Flujo de ENTRADA basada en bytes, para leer objetos en Archivos
            ObjectInputStream flujoEntrada2 = new ObjectInputStream(new FileInputStream("Profes.prof"));
            Profes prof1= (Profes) flujoEntrada2.readObject();
            System.out.println(prof1);
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class Profes implements Serializable{
    private String nombre;
    private String tipo;
    public Profes(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Profes{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}    
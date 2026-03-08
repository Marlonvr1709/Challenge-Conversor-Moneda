package com.conversor.main;

import com.conversor.model.Conversor;
import com.conversor.service.ConsultaAPI;

import java.util.Scanner;

public class ConversorApp
{
    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaAPI consulta = new ConsultaAPI();
        Conversor conversor = new Conversor();

        int opcion = 0;

        while(opcion != 7){

            System.out.println("\n=================================");
            System.out.println(" CONVERSOR DE MONEDAS ");
            System.out.println("=================================");
            System.out.println("1) USD → ARS");
            System.out.println("2) ARS → USD");
            System.out.println("3) USD → BRL");
            System.out.println("4) BRL → USD");
            System.out.println("5) USD → COP");
            System.out.println("6) COP → USD");
            System.out.println("7) Salir");
            System.out.println("=================================");
            System.out.print("Seleccione una opción: ");

            opcion = lectura.nextInt();

            if(opcion == 7){
                System.out.println("Gracias por usar el conversor.");
                break;
            }

            System.out.print("Ingrese el valor a convertir: ");
            double cantidad = lectura.nextDouble();

            try{

                String json;
                double resultado = 0;

                switch(opcion){

                    case 1:
                        json = consulta.obtenerDatos("USD");
                        resultado = conversor.convertir(json,"ARS",cantidad);
                        break;

                    case 2:
                        json = consulta.obtenerDatos("ARS");
                        resultado = conversor.convertir(json,"USD",cantidad);
                        break;

                    case 3:
                        json = consulta.obtenerDatos("USD");
                        resultado = conversor.convertir(json,"BRL",cantidad);
                        break;

                    case 4:
                        json = consulta.obtenerDatos("BRL");
                        resultado = conversor.convertir(json,"USD",cantidad);
                        break;

                    case 5:
                        json = consulta.obtenerDatos("USD");
                        resultado = conversor.convertir(json,"COP",cantidad);
                        break;

                    case 6:
                        json = consulta.obtenerDatos("COP");
                        resultado = conversor.convertir(json,"USD",cantidad);
                        break;

                    default:
                        System.out.println("Opción inválida");
                        continue;
                }

                System.out.println("\nResultado:");
                System.out.println(cantidad + " convertido = " + resultado);

            }catch(Exception e){
                System.out.println("Error al obtener datos de la API");
            }

        }

    }
}

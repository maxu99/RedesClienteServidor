package Utn.Redes;

import Utn.Redes.models.Cliente;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main(String[] args) throws IOException
    {

        String ip="";
        int puerto=0;
        Scanner scan = new Scanner(System.in);

        System.out.println("Iniciando cliente\n");

        System.out.println("Ingrese la direccion ip:");
        ip=scan.nextLine();
        System.out.println("Ingrese el puerto:");
        puerto=scan.nextInt();

        if(ip.equals("127.0.0.1") ){
            if(puerto==3000){
                Cliente cli = new Cliente(ip,puerto); //Se crea el cliente
                cli.startClient(); //Se inicia el cliente
            }else{
                System.out.println("El puerto es incorrecto");
            }
        }else{
            System.out.println("La ip es incorrecta");
        }

    }
}

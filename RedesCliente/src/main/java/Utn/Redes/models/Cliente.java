package Utn.Redes.models;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cliente extends Connect
{
    public Cliente(String ip , int port) throws IOException {
        super("cliente",port,ip);


    } //Se usa el constructor para cliente de Conexion

    public void startClient() //Método para iniciar el cliente
    {

        String salida = "";
        try
        {
            String st = "";
             DataInputStream bufferDeEntrada = null;
            bufferDeEntrada = new DataInputStream(cs.getInputStream());
            int limit=0;
            //Se enviarán dos mensajes
            while(!salida.equals("x")){

                //Flujo de datos hacia el servidor
                st = (String) bufferDeEntrada.readUTF();
                salidaServidor = new DataOutputStream(cs.getOutputStream());
                System.out.println(st);
                Scanner scan = new Scanner(System.in);
                System.out.println("Ingrese mensaje:");
                salida=scan.nextLine();
                //salidaServidor.writeUTF(salida);
                salidaServidor.writeUTF(salida);

            }



        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
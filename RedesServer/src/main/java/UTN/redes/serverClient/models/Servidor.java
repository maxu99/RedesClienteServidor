package UTN.redes.serverClient.models;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Servidor extends Connect {

    public Servidor() throws IOException {super("servidor");} //Se usa el constructor para servidor de Conexion

    public void startServer()//Método para iniciar el servidor
    {
        try
        {
            System.out.println("Esperando..."); //Esperando conexión

            cs = ss.accept(); //Accept comienza el socket y espera una conexión desde un cliente

            System.out.println("Cliente en línea");

            //Se obtiene el flujo de salida del cliente para enviarle mensajes
            salidaCliente = new DataOutputStream(cs.getOutputStream());

            //Se le envía un mensaje al cliente usando su flujo de salida
            salidaCliente.writeUTF("Peticion recibida y aceptada");

            //Se obtiene el flujo entrante desde el cliente

            Scanner scan = new Scanner(System.in);
            String st= "";
             DataInputStream bufferDeEntrada = new DataInputStream(cs.getInputStream());
             BufferedReader entradita = new BufferedReader(new InputStreamReader(cs.getInputStream()));


            while(true) //Mientras haya mensajes desde el cliente
            {
                //Se muestra por pantalla el mensaje recibido



                //ESTA PORCION DE CODIGO COMENTADO PERMITE QUE TELNET SE COMUNIQUE CON INTELLIJ
                // ES DECIR DE TELNET A CONSOLA SERVER
                   /* mensajeServidor= entradita.readLine();
                    if(mensajeServidor.equals("x")){
                        cs.close();
                        ss.close();
                        System.out.println("Cerrando el server!");
                        break;
                    }
                    System.out.println("Cliente: "+mensajeServidor);*/


                    // ESTE HAY QUE DESCOMENTAR PARA QUE LEA CLIENTE A SERVER POR INTELLIJ
                        // ES DECIR DE CONSOLA A CONSOLA
                    st = (String) bufferDeEntrada.readUTF();
                    if(st.equals("x")){
                        cs.close();
                        ss.close();
                        System.out.println("Cerrando el server!");
                        break;
                    }
                    System.out.println("Cliente: "+st);

                    System.out.println("Server:");
                    st=scan.nextLine();
                    if(st.equals("x")){
                        cs.close();
                        ss.close();
                        System.out.println("Cerrando el server!");
                    }
                    salidaCliente.writeUTF(st);

            }

        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}

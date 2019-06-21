package UTN.redes.serverClient;

import UTN.redes.serverClient.models.Servidor;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class MainServidor
{
    public static void main(String[] args) throws IOException
    {
        Servidor serv = new Servidor(); //Se crea el servidor
        System.out.println("Iniciando servidor\n");
        serv.startServer(); //Se inicia el servidor
    }
}

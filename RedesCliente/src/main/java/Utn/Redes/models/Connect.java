package Utn.Redes.models;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect {

    private  int PUERTO = 0; //Puerto para la conexión
    private  String HOST = ""; //Host para la conexión
    protected String mensajeServidor; //Mensajes entrantes (recibidos) en el servidor
    protected ServerSocket ss; //Socket del servidor
    protected Socket cs; //Socket del cliente
    protected DataOutputStream salidaServidor, salidaCliente; //Flujo de datos de salida

    public Connect(String tipo,int port,String host) throws IOException //Constructor
    {
        setPUERTO(port);
        setHOST(host);
        if(tipo.equalsIgnoreCase("servidor"))
        {
            ss = new ServerSocket(PUERTO);//Se crea el socket para el servidor en puerto 1234
            cs = new Socket(); //Socket para el cliente
        }
        else
        {
            cs = new Socket(HOST, PUERTO); //Socket para el cliente en localhost en puerto 1234
        }
    }

    public void setPUERTO(int PUERTO) {
        this.PUERTO = PUERTO;
    }

    public void setHOST(String HOST) {
        this.HOST = HOST;
    }
}

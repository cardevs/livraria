package livraria.server;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorMain {


    public static void main(String[] args) {
        int port=8818;
        Servidor servidor= new Servidor(port);
        servidor.start();

    }






}

package livraria.server;

import javax.imageio.IIOException;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {


    public static void main(String[] args) {
        int port=8818;
        try {
            ServerSocket serverSocket= new ServerSocket(port);

            while (true)
            {
                Socket cliente=serverSocket.accept();//Cria uma nova ligacao para o servidor
                ServidorFuncionando servidorFuncionando=new ServidorFuncionando(cliente);
                servidorFuncionando.start();


            }
        }catch (IOException e){
            e.printStackTrace();
        }





    }






}

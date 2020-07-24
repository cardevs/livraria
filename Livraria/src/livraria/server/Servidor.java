package livraria.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Servidor extends Thread{

    private final int porta;
    private ArrayList<ServidorFuncionando> workers= new ArrayList<>();

    public Servidor(int porta) {

    this.porta=porta;

    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket= new ServerSocket(porta);

            while (true)//Ciclo infinito para receber conexoes;
            {
                Socket cliente=serverSocket.accept();//Cria uma nova ligacao para o servidor
                System.out.println("Conexao aceit: "+cliente);
                ServidorFuncionando servidorFuncionando=new ServidorFuncionando(this,cliente);
                servidorFuncionando.start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }



    }
}

package livraria.server;

import java.io.*;
import java.net.Socket;
import java.util.Date;

public class ServidorFuncionando extends Thread{

    private final Socket cliente;


    public ServidorFuncionando(Socket cliente){
        this.cliente=cliente;
    }

    //Funcao que executa a Thread
    @Override
    public void run(){

        try {
            handleClientSocket();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }

    private void handleClientSocket() throws IOException, InterruptedException{
        InputStream leituraDados=cliente.getInputStream();//Para ler dados do cliente
        OutputStream saidaDados=cliente.getOutputStream();
        BufferedReader reader= new BufferedReader(new InputStreamReader(leituraDados));

        String linha;

        while ((linha=reader.readLine())!=null){

            if ("quit".equalsIgnoreCase(linha))//verifica se ele escreveu para sair
                break;
            String mensagem="Voce escreveu: "+linha+"\n";
            saidaDados.write(mensagem.getBytes());//Transforma mensagem em Bytes e envia
        }

        /*
        for (int i=0; i<10; i++){
            saidaDados.write(("Time now is"+new Date()+"\n").getBytes());
            Thread.sleep(1000);
        }*/

        cliente.close();
    }

}

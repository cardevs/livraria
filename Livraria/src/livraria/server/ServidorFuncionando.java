package livraria.server;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class ServidorFuncionando extends Thread{

    private final Socket cliente;



    public ServidorFuncionando(Servidor servidor, Socket cliente){
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
        System.out.println(cliente);
        BufferedReader reader= new BufferedReader(new InputStreamReader(leituraDados));
        String linha;
        //System.out.println("Ola");



        while ((linha=reader.readLine())!=null){
            System.out.println("Ola");
            String [] tokens=StringUtils.split(linha);//Separa cada palvra da frase inserida
          if (tokens!=null && tokens.length>0)//Verifica se foi inserida alguma coisal;
           {
            String comandoInserido=tokens[0];//Pega o comando inserido
               if ("quit".equals(comandoInserido)){
                       break;
               }
               else if("login".equalsIgnoreCase(comandoInserido))//Verifica se foi inserido um comando de Login
               {
                   fazendoLogin(saidaDados, tokens);//Envia os dados para seu devido tratament
               }

           }
        }

        cliente.close();
    }

    private void fazendoLogin(OutputStream saidaDados, String[] tokens) throws IOException {

       if (tokens.length==3)//Verifica se foi inserido tres comandos
       {
           String utilizador=tokens[1];
           String password=tokens[2];
           if ("adolfo".equalsIgnoreCase(utilizador) && "quende".equalsIgnoreCase(password)){
String mensagem="Eu muito mau!!";
               saidaDados.write(mensagem.getBytes());
           }
else
           {
               String mensagem="Erro no login";
               saidaDados.write(mensagem.getBytes());
           }

       }
    }

}

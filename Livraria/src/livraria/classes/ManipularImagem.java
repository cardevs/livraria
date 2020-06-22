package livraria.classes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ManipularImagem {


    public static BufferedImage setDimensao(String caminho, Integer largura, Integer altura){
Double novaLargura=null;
Double novaAltura= null;
Double proporcao=null;
Graphics2D grafico=null;
BufferedImage imagem=null;
BufferedImage novaImagem=null;

try {
    imagem= ImageIO.read(new File(caminho));
}catch (IOException erro){
    System.out.println(erro.getMessage());
    Logger.getLogger(ManipularImagem.class.getName()).log(Level.SEVERE,null,erro);
}
novaLargura=(double) imagem.getWidth();
novaAltura=(double) imagem.getHeight();

if (novaLargura>=largura){
    proporcao=(novaAltura/novaLargura);
    novaAltura=(double)altura;
    novaAltura=(novaAltura*proporcao);

    while (novaAltura>altura){
        novaLargura=(double)(--largura);
        novaAltura=(novaLargura*proporcao);
    }
}
else if(novaAltura>=altura){
    proporcao=novaLargura/novaLargura;
    novaAltura=(novaLargura*proporcao);
    while (novaLargura>largura){
        novaAltura=(double)(--altura);
        novaLargura=(novaAltura*proporcao);
    }
}
novaImagem= new BufferedImage(novaLargura.intValue(),novaAltura.intValue(),BufferedImage.TYPE_INT_ARGB);
grafico=novaImagem.createGraphics();
grafico.drawImage(novaImagem,0,0,novaLargura.intValue(),novaAltura.intValue(),null);

return novaImagem;
    }



}

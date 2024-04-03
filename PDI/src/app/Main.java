package app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // LOAD DA IMAGEM
        BufferedImage image = ImageIO.read(new File("lands.jpg"));

        // VISUALIZAÇÃO DA IMAGEM
        ManipulateImage.showImage(
                image,

                Operacoes.bandaR(image),
                Operacoes.bandaG(image),
                Operacoes.bandaB(image),
                Operacoes.cinza(image),
                Operacoes.cinzaR(image),
                Operacoes.cinzaG(image),
                Operacoes.cinzaB(image),
                Operacoes.negativa(image),
                Operacoes.ajusteTonalidade(image, "red", 100),
                Operacoes.ajusteTonalidade(image, "green", 100),
                Operacoes.ajusteTonalidade(image, "blue", 100),
                Operacoes.binarizacao(image, 100),
                Operacoes.conversaoYIQ_RGB(image),
                Operacoes.brilhoAditivoEmRGB(image, 50),
                Operacoes.brilhoMultiplicativo(image, 50),
                Operacoes.brilhoAditivoNaBandaY(image, 50),
                Operacoes.brilhoMultiplicativoNaBandaY(image, 50),
                Operacoes.negativaNaBandaY(image)
        );
    }


}


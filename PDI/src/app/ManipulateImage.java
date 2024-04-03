package app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ManipulateImage {
    public static void main(String[] args) throws IOException {
        // Carrega a imagem a partir do arquivo "lands.png"
        BufferedImage image = ImageIO.read(new File("lands.png"));

        // Obtém as dimensões da imagem e calcula o centro
        int width = image.getWidth();
        int height = image.getHeight();
        int centerX = width / 2;
        int centerY = height / 2;

        // Define a cor do primeiro pixel da imagem para azul
        image.setRGB(0, 0, Color.BLUE.getRGB());

        // Define a cor do pixel central da imagem para verde
        image.setRGB(centerX, centerY, Color.GREEN.getRGB());

        // Define a cor do último pixel da imagem para vermelho
        image.setRGB(width - 1, height - 1, Color.RED.getRGB());

        // Percorre a imagem pixel a pixel e imprime as informações RGB de cada pixel
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color color = new Color(image.getRGB(w, h));
                int r = color.getRed();    // Valor da banda R (vermelho)
                int g = color.getGreen();  // Valor da banda G (verde)
                int b = color.getBlue();   // Valor da banda B (azul)

                System.out.println("Pixel(" + w + "," + h + "): RGB(" + r + "," + g + "," + b + ")");
            }
        }

        // Exibe a imagem
        showImage(image);
    }

    public static void showImage(BufferedImage... images) {
        // Cria uma nova janela Swing
        JFrame jframe = new JFrame("Imagem modificada");
        jframe.setLayout(new BorderLayout());

        // Cria um painel para conter as imagens
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Adiciona cada imagem ao painel
        for (BufferedImage image : images) {
            JLabel jlabel = new JLabel(new ImageIcon(image));
            panel.add(jlabel);
        }

        // Adiciona o painel a um JScrollPane para permitir a rolagem
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Adiciona o JScrollPane à região central da janela
        jframe.add(scrollPane, BorderLayout.CENTER);

        // Ajusta o tamanho da janela para se ajustar ao conteúdo
        jframe.pack();
        // Torna a janela visível
        jframe.setVisible(true);
        // Define o comportamento ao fechar a janela para terminar o programa
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
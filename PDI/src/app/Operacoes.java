package app;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Operacoes {
    public static BufferedImage bandaR(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        // Cria uma nova imagem com as mesmas dimensões
        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        // Itera sobre cada pixel na imagem original
        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                // Obtém a cor do pixel na posição (w, h)
                Color corPixel = new Color(imagem.getRGB(w, h));

                // Cria uma nova cor mantendo apenas a componente vermelha
                Color novaCor = new Color(corPixel.getRed(), 0, 0);

                // Define a nova cor na imagem de resultado
                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        // Retorna a imagem resultante
        return imagemResultante;
    }

    public static BufferedImage bandaG(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                Color novaCor = new Color(0, corPixel.getGreen(), 0);

                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage bandaB(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                Color novaCor = new Color(0, 0, corPixel.getBlue());

                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage cinzaR(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();

                // o cinza de uma x cor é a repetição dela em todas as bandas
                Color novaCor = new Color(r, r, r);

                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage cinzaG(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int g = corPixel.getGreen();

                Color novaCor = new Color(g, g, g);

                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage cinzaB(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int b = corPixel.getBlue();

                Color novaCor = new Color(b, b, b);

                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage cinza(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                // o cinza é a média de todas as bandas em todas as bandas
                int mediaColors = (r + g + b) / 3;
                Color novaCor = new Color(mediaColors, mediaColors, mediaColors);

                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage negativa(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                // o negativo da imagem é a diferença do máximo de cada cor primária com a cor da imagem
                Color novaCor = new Color(255 - r, 255 - g, 255 - b);

                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    private static int limiteCor(int colorValue) {
        return Math.min(Math.max(colorValue, 0), 255);
    }

    public static BufferedImage ajusteTonalidade(BufferedImage imagem, String color, int ajusteTonalidade) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                // o aumento da tonalidade é a cor da imagem adicionando o quanto quer que aumente (respeitado o limite da cor [0,255])
                if (color.equalsIgnoreCase("red")) {
                    r = limiteCor(r + ajusteTonalidade);
                } else if (color.equalsIgnoreCase("green")) {
                    g = limiteCor(g + ajusteTonalidade);
                } else if (color.equalsIgnoreCase("blue")) {
                    b = limiteCor(b + ajusteTonalidade);
                }

                imagemResultante.setRGB(w, h, new Color(r, g, b).getRGB());
            }
        }

        return imagemResultante;
    }


    public static BufferedImage binarizacao(BufferedImage imagem, int limiar) {
        if (limiar < 1 || limiar > 254) throw new IllegalArgumentException("Limiar inválido!");

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                int mediaColors = (r + g + b) / 3;

                // binarização é a transformação de uma imagem colorida em uma nova imagem com apenas duas cores a partir do comparação do cinza com o valor da limiar (segmentação de imagens)
                if (mediaColors > limiar) imagemResultante.setRGB(w, h, Color.WHITE.getRGB());
                else imagemResultante.setRGB(w, h, Color.BLACK.getRGB());
            }
        }

        return imagemResultante;
    }


    public static BufferedImage brilhoAditivoEmRGB(BufferedImage imagem, int aumentoAditivo) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                // Aumenta o brilho aditivamente soma o valor de aumento a cada componente de cor [pixelResultante = pixelAtual + valor]. Respeitando o limite das cores [0,255]!!
                r = limiteCor(r + aumentoAditivo);
                g = limiteCor(g + aumentoAditivo);
                b = limiteCor(b + aumentoAditivo);

                Color novaCor = new Color(r, g, b);
                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage brilhoMultiplicativo(BufferedImage imagem, int aumentoMultiplicativo) {
        if (aumentoMultiplicativo < 0) throw new IllegalCallerException("Valor inválido!");

        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                // Aumento do brilho multiplicativo é a multiplicar o valor de aumento a cada componente de cor [pixelResultante = pixelAtual * valor]. Respeitando o limite das cores [0,255]!!!
                r = limiteCor(r * aumentoMultiplicativo);
                g = limiteCor(g * aumentoMultiplicativo);
                b = limiteCor(b * aumentoMultiplicativo);

                Color novaCor = new Color(r, g, b);
                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage conversaoYIQ_RGB(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultanteYIQ = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);
        BufferedImage imagemResultanteRGB = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                float y = (float) ((0.299 * r) + (0.587 * g) + (0.114 * b));
                float i = (float) ((0.596 * r) - (0.274 * g) - (0.322 * b));
                float q = (float) ((0.211 * r) - (0.523 * g) + (0.312 * b));

                y = limiteCor((int) y);
                i = limiteCor((int) i);
                q = limiteCor((int) q);

                int red = limiteCor((int) ((1.000 * y) + (0.956 * i) + (0.621 * q)));
                int green = limiteCor((int) ((1.000 * y) - (0.272 * i) - (0.647 * q)));
                int blue = limiteCor((int) ((1.000 * y) - (1.106 * i) + (1.703 * q)));

                Color novaCorYIQ = new Color((int) y, (int) i, (int) q);
                imagemResultanteYIQ.setRGB(w, h, novaCorYIQ.getRGB());

                Color novaCorRGB = new Color(red, green, blue);
                imagemResultanteRGB.setRGB(w, h, novaCorRGB.getRGB());
            }
        }

        return imagemResultanteRGB;
    }

    public static BufferedImage brilhoAditivoNaBandaY(BufferedImage imagem, int aumentoAditivo) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                float y = (float) (0.299 * r + 0.587 * g + 0.114 * b) + aumentoAditivo;
                float i = (float) (0.596 * r - 0.274 * g - 0.322 * b);
                float q = (float) (0.211 * r - 0.523 * g + 0.312 * b);

                y = limiteCor((int) y);
                i = limiteCor((int) i);
                q = limiteCor((int) q);

                Color novaCor = new Color((int) y, (int) i, (int) q);
                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage brilhoMultiplicativoNaBandaY(BufferedImage imagem, float aumentoMultiplicativo) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                float y = (float) (0.299 * r + 0.587 * g + 0.114 * b) * aumentoMultiplicativo;
                float i = (float) (0.596 * r - 0.274 * g - 0.322 * b);
                float q = (float) (0.211 * r - 0.523 * g + 0.312 * b);

                y = limiteCor((int) y);
                i = limiteCor((int) i);
                q = limiteCor((int) q);

                Color novaCor = new Color((int) y, (int) i, (int) q);
                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

    public static BufferedImage negativaNaBandaY(BufferedImage imagem) {
        int largura = imagem.getWidth();
        int altura = imagem.getHeight();

        BufferedImage imagemResultante = new BufferedImage(largura, altura, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < largura; w++) {
            for (int h = 0; h < altura; h++) {
                Color corPixel = new Color(imagem.getRGB(w, h));

                int r = corPixel.getRed();
                int g = corPixel.getGreen();
                int b = corPixel.getBlue();

                float y = 255 - (float) (0.299 * r + 0.587 * g + 0.114 * b);
                float i = (float) (0.596 * r - 0.274 * g - 0.322 * b);
                float q = (float) (0.211 * r - 0.523 * g + 0.312 * b);

                y = limiteCor((int) y);
                i = limiteCor((int) i);
                q = limiteCor((int) q);

                Color novaCor = new Color((int) y, (int) i, (int) q);
                imagemResultante.setRGB(w, h, novaCor.getRGB());
            }
        }

        return imagemResultante;
    }

}

package app;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Operations {
    public static BufferedImage redBand(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                Color newColor = new Color(pixelColor.getRed(), 0, 0);

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage greenBand(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                Color newColor = new Color(0, pixelColor.getGreen(), 0);

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage blueBand(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                Color newColor = new Color(0, 0, pixelColor.getBlue());

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage grayR(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();

                Color newColor = new Color(r, r, r);

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage grayG(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int g = pixelColor.getGreen();

                Color newColor = new Color(g, g, g);

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage grayB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int b = pixelColor.getBlue();

                Color newColor = new Color(b, b, b);

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage gray(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                int averageColor = (r + g + b) / 3;
                Color newColor = new Color(averageColor, averageColor, averageColor);

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage negative(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                Color newColor = new Color(255 - r, 255 - g, 255 - b);

                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    private static int limitColor(int colorValue) {
        return Math.min(Math.max(colorValue, 0), 255);
    }

    public static BufferedImage hueAdjustment(BufferedImage image, String color, int hueAdjustment) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                if (color.equalsIgnoreCase("red")) {
                    r = limitColor(r + hueAdjustment);
                } else if (color.equalsIgnoreCase("green")) {
                    g = limitColor(g + hueAdjustment);
                } else if (color.equalsIgnoreCase("blue")) {
                    b = limitColor(b + hueAdjustment);
                }

                resultImage.setRGB(w, h, new Color(r, g, b).getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage binarization(BufferedImage image, int threshold) {
        if (threshold < 1 || threshold > 254) throw new IllegalArgumentException("Invalid threshold!");

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                int averageColor = (r + g + b) / 3;

                if (averageColor > threshold) resultImage.setRGB(w, h, Color.WHITE.getRGB());
                else resultImage.setRGB(w, h, Color.BLACK.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage additiveBrightnessInRGB(BufferedImage image, int additiveIncrease) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                r = limitColor(r + additiveIncrease);
                g = limitColor(g + additiveIncrease);
                b = limitColor(b + additiveIncrease);

                Color newColor = new Color(r, g, b);
                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage multiplicativeBrightness(BufferedImage image, int multiplicativeIncrease) {
        if (multiplicativeIncrease < 0) throw new IllegalCallerException("Invalid value!");

        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                r = limitColor(r * multiplicativeIncrease);
                g = limitColor(g * multiplicativeIncrease);
                b = limitColor(b * multiplicativeIncrease);

                Color newColor = new Color(r, g, b);
                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage YIQ_RGBConversion(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultYIQImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        BufferedImage resultRGBImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                float y = (float) ((0.299 * r) + (0.587 * g) + (0.114 * b));
                float i = (float) ((0.596 * r) - (0.274 * g) - (0.322 * b));
                float q = (float) ((0.211 * r) - (0.523 * g) + (0.312 * b));

                y = limitColor((int) y);
                i = limitColor((int) i);
                q = limitColor((int) q);

                // Conversion to RGB to YIQ
                Color newYIQColor = new Color((int) y, (int) i, (int) q);
                resultYIQImage.setRGB(w, h, newYIQColor.getRGB());

                float red = ((float) ((1.000 * y) + (0.956 * i) + (0.621 * q)));
                float green = ((float) ((1.000 * y) - (0.272 * i) - (0.647 * q)));
                float blue = ((float) ((1.000 * y) - (1.106 * i) + (1.703 * q)));

                red = limitColor((int) red);
                green = limitColor((int) green);
                blue = limitColor((int) blue);

                // Conversion to YIQ to RGB
                Color newRGBColor = new Color((int) red, (int) green, (int) blue);
                resultRGBImage.setRGB(w, h, newRGBColor.getRGB());

            }
        }

        return resultRGBImage;
    }

    public static BufferedImage additiveBrightnessInYBand(BufferedImage image, int additiveIncrease) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                float y = (float) (0.299 * r + 0.587 * g + 0.114 * b) + additiveIncrease;
                float i = (float) (0.596 * r - 0.274 * g - 0.322 * b);
                float q = (float) (0.211 * r - 0.523 * g + 0.312 * b);

                y = limitColor((int) y);
                i = limitColor((int) i);
                q = limitColor((int) q);

                Color newColor = new Color((int) y, (int) i, (int) q);
                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage multiplicativeBrightnessInYBand(BufferedImage image, float multiplicativeIncrease) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                float y = (float) (0.299 * r + 0.587 * g + 0.114 * b) * multiplicativeIncrease;
                float i = (float) (0.596 * r - 0.274 * g - 0.322 * b);
                float q = (float) (0.211 * r - 0.523 * g + 0.312 * b);

                y = limitColor((int) y);
                i = limitColor((int) i);
                q = limitColor((int) q);

                Color newColor = new Color((int) y, (int) i, (int) q);
                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }

    public static BufferedImage negativeInYBand(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();

        BufferedImage resultImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                Color pixelColor = new Color(image.getRGB(w, h));

                int r = pixelColor.getRed();
                int g = pixelColor.getGreen();
                int b = pixelColor.getBlue();

                float y = 255 - (float) (0.299 * r + 0.587 * g + 0.114 * b);
                float i = (float) (0.596 * r - 0.274 * g - 0.322 * b);
                float q = (float) (0.211 * r - 0.523 * g + 0.312 * b);

                y = limitColor((int) y);
                i = limitColor((int) i);
                q = limitColor((int) q);

                Color newColor = new Color((int) y, (int) i, (int) q);
                resultImage.setRGB(w, h, newColor.getRGB());
            }
        }

        return resultImage;
    }
}

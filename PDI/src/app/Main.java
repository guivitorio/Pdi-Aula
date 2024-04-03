package app;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // LOAD THE IMAGE
        BufferedImage image = ImageIO.read(new File("lands.jpg"));

        // IMAGE VISUALIZATION
        ManipulateImage.showImage(
                image,
                Operations.redBand(image),
                Operations.greenBand(image),
                Operations.blueBand(image),
                Operations.gray(image),
                Operations.grayR(image),
                Operations.grayG(image),
                Operations.grayB(image),
                Operations.negative(image),
                Operations.hueAdjustment(image, "red", 100),
                Operations.hueAdjustment(image, "green", 100),
                Operations.hueAdjustment(image, "blue", 100),
                Operations.binarization(image, 100),
                Operations.YIQ_RGBConversion(image),
                Operations.additiveBrightnessInRGB(image, 50),
                Operations.multiplicativeBrightness(image, 50),
                Operations.additiveBrightnessInYBand(image, 50),
                Operations.multiplicativeBrightnessInYBand(image, 50),
                Operations.negativeInYBand(image)
        );
    }
}

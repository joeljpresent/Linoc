package io.github.joeljpresent.linoc.swapper;

import io.github.joeljpresent.linoc.exceptions.ColorAlreadyPresentException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/**
 * Perform color-swapping.
 */
public class LinocSwapper
{
    /**
     * Mappings of source colors to destination colors.
     */
    final private HashMap<Color, Color> mappings;
    final private BufferedImage srcImg;
    final private BufferedImage destImg;

    public LinocSwapper(HashMap<Color, Color> mappings, File sourceImage)
            throws IOException
    {
        this.mappings = mappings;
        this.srcImg = ImageIO.read(sourceImage);
        this.destImg = newImageWithDimensionsOf(this.srcImg);
    }

    private static BufferedImage newImageWithDimensionsOf(BufferedImage img)
    {
        return new BufferedImage(img.getWidth(), img.getHeight(),
                img.getType());
    }
}

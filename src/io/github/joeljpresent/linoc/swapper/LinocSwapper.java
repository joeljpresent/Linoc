package io.github.joeljpresent.linoc.swapper;

import io.github.joeljpresent.linoc.viewer.LinocViewer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Perform color-swapping.
 */
public class LinocSwapper
{
    /**
     * LinocMappings of source colors to destination colors.
     */
    final private LinocMappings mappings;
    final private BufferedImage srcImg;
    final private BufferedImage destImg;

    public LinocSwapper(LinocMappings mappings, BufferedImage sourceImage)
    {
        this.mappings = mappings;
        this.srcImg = sourceImage;
        this.destImg = newImageWithDimensionsOf(this.srcImg);
    }

    public LinocSwapper(LinocMappings mappings, File sourceImage)
            throws IOException
    {
        this(mappings, ImageIO.read(sourceImage));
    }

    public BufferedImage swap()
    {
        for (int x = 0; x < srcImg.getWidth(); x++)
        {
            for (int y = 0; y < srcImg.getHeight(); y++)
            {
                swapPixel(x,y);
            }
        }
        return destImg;
    }

    private void swapPixel(int x, int y)
    {
        Color sourceColor = new Color(srcImg.getRGB(x, y));
        if (mappings.containsKey(sourceColor))
            destImg.setRGB(x, y, mappings.get(sourceColor).getRGB());
        else
            destImg.setRGB(x, y, sourceColor.getRGB());
    }

    public void view()
    {
        LinocViewer viewer = new LinocViewer(this);
        viewer.open();
    }

    private static BufferedImage newImageWithDimensionsOf(BufferedImage img)
    {
        return new BufferedImage(img.getWidth(), img.getHeight(),
                img.getType());
    }

    public BufferedImage getSourceImage()
    {
        return srcImg;
    }

    public BufferedImage getDestinationImage()
    {
        return destImg;
    }

    public LinocMappings getMappings()
    {
        return mappings;
    }
}

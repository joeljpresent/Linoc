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

    public static LinocSwapper
    swap(LinocMappings mappings, BufferedImage sourceImage)
    {
        LinocSwapper swapper = new LinocSwapper(mappings, sourceImage);
        swapper.swap();
        return swapper;
    }

    public static LinocSwapper swap(LinocMappings mappings, File sourceImage)
            throws IOException
    {
        return LinocSwapper.swap(mappings, ImageIO.read(sourceImage));
    }

    public LinocSwapper swap()
    {
        for (int x = 0; x < srcImg.getWidth(); x++)
        {
            for (int y = 0; y < srcImg.getHeight(); y++)
            {
                swapPixel(x,y);
            }
        }
        return this;
    }

    private void swapPixel(int x, int y)
    {
        Color sourceColor = new Color(srcImg.getRGB(x, y));
        if (mappings.containsKey(sourceColor))
            destImg.setRGB(x, y, mappings.get(sourceColor).getRGB());
        else
            destImg.setRGB(x, y, sourceColor.getRGB());
    }

    public LinocSwapper view()
    {
        LinocViewer viewer = new LinocViewer(this);
        viewer.open();
        return this;
    }

    private void save(String formatName, File output) throws IOException
    {
        ImageIO.write(destImg, formatName, output);
    }

    public LinocSwapper saveAsPng(File output) throws IOException
    {
        save("png", output);
        return this;
    }

    public LinocSwapper saveAsPng(String output) throws IOException
    {
        save("png", new File(output));
        return this;
    }

    public LinocSwapper saveAsGif(File output) throws IOException
    {
        save("gif", output);
        return this;
    }

    public LinocSwapper saveAsGif(String output) throws IOException
    {
        save("gif", new File(output));
        return this;
    }

    public LinocSwapper saveAsJpeg(File output) throws IOException
    {
        save("jpg", output);
        return this;
    }

    public LinocSwapper saveAsJpeg(String output) throws IOException
    {
        save("jpg", new File(output));
        return this;
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

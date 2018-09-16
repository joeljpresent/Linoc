package io.github.joeljpresent.linoc.viewer;

import javax.swing.*;
import java.awt.image.BufferedImage;

public class LinocViewer
{
    private final JFrame frame;
    private BufferedImage src;
    private BufferedImage dest;

    public LinocViewer(BufferedImage source, BufferedImage destination)
    {
        this.frame = new JFrame("Linoc Viewer");
        this.src = source;
        this.dest = destination;
    }

    public void open()
    {
        setUpFrame();
    }

    private void setUpFrame()
    {
        this.frame.setSize(640, 480);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
    }

    public BufferedImage getSourceImage()
    {
        return src;
    }

    public void setSourceImage(BufferedImage src)
    {
        this.src = src;
    }

    public BufferedImage getDestinationImage()
    {
        return dest;
    }

    public void setDestinationImage(BufferedImage dest)
    {
        this.dest = dest;
    }
}

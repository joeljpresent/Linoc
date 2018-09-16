package io.github.joeljpresent.linoc.viewer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

class ImageComparisonPanel extends JPanel
{
    final private BufferedImage src;
    final private BufferedImage dest;

    ImageComparisonPanel(LinocViewer viewer)
    {
        this.src = viewer.getSourceImage();
        this.dest = viewer.getDestinationImage();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        g.drawImage(src, 10, 50, 250, 200, this);
        g.drawImage(dest, 300, 50, 250, 200, this);
    }
}

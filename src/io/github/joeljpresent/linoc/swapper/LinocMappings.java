package io.github.joeljpresent.linoc.swapper;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class LinocMappings extends HashMap<Color, Color>
{
    public LinocMappings(int initialCapacity, float loadFactor)
    {
        super(initialCapacity, loadFactor);
    }

    public LinocMappings(int initialCapacity)
    {
        super(initialCapacity);
    }

    public LinocMappings()
    {
    }

    public LinocMappings(Map<? extends Color, ? extends Color> m)
    {
        super(m);
    }
}

/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class TNewLine extends Token
{
    public TNewLine(String text)
    {
        setText(text);
    }

    public TNewLine(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TNewLine(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTNewLine(this);
    }
}


/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class TAt extends Token
{
    public TAt()
    {
        super.setText("@");
    }

    public TAt(int line, int pos)
    {
        super.setText("@");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TAt(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAt(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TAt text.");
    }
}


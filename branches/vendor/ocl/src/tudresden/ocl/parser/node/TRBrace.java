/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class TRBrace extends Token
{
    public TRBrace()
    {
        super.setText("}");
    }

    public TRBrace(int line, int pos)
    {
        super.setText("}");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TRBrace(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTRBrace(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TRBrace text.");
    }
}


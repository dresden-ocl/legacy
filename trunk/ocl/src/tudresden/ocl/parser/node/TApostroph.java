/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class TApostroph extends Token
{
    public TApostroph()
    {
        super.setText("\'");
    }

    public TApostroph(int line, int pos)
    {
        super.setText("\'");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TApostroph(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTApostroph(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TApostroph text.");
    }
}


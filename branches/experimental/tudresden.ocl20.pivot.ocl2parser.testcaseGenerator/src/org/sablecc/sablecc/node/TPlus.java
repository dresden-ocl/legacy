/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TPlus;
import org.sablecc.sablecc.node.Token;



public final class TPlus extends Token
{
    public TPlus()
    {
        super.setText("+");
    }

    public TPlus(int line, int pos)
    {
        super.setText("+");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TPlus(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTPlus(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TPlus text.");
    }
}

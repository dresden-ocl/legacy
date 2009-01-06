/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TDot;
import org.sablecc.sablecc.node.Token;



public final class TDot extends Token
{
    public TDot()
    {
        super.setText(".");
    }

    public TDot(int line, int pos)
    {
        super.setText(".");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TDot(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTDot(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TDot text.");
    }
}

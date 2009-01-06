/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TTokenSpecifier;
import org.sablecc.sablecc.node.Token;



public final class TTokenSpecifier extends Token
{
    public TTokenSpecifier()
    {
        super.setText("T");
    }

    public TTokenSpecifier(int line, int pos)
    {
        super.setText("T");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TTokenSpecifier(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTTokenSpecifier(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TTokenSpecifier text.");
    }
}

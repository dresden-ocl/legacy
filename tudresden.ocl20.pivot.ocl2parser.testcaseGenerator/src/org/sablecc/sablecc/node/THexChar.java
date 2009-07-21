/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.THexChar;
import org.sablecc.sablecc.node.Token;



public final class THexChar extends Token
{
    public THexChar(String text)
    {
        setText(text);
    }

    public THexChar(String text, int line, int pos)
    {
        setText(text);
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new THexChar(getText(), getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTHexChar(this);
    }
}
/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class TAll extends Token
{
    public TAll()
    {
        super.setText("all");
    }

    public TAll(int line, int pos)
    {
        super.setText("all");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TAll(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTAll(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TAll text.");
    }
}
/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class TExcept extends Token
{
    public TExcept()
    {
        super.setText("except");
    }

    public TExcept(int line, int pos)
    {
        super.setText("except");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TExcept(getLine(), getPos());
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTExcept(this);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TExcept text.");
    }
}

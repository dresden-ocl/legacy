/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class TOclexpression extends Token
{
    public TOclexpression()
    {
        super.setText("#oclexpression");
    }

    public TOclexpression(int line, int pos)
    {
        super.setText("#oclexpression");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TOclexpression(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTOclexpression(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseTOclexpression(this, param);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TOclexpression text.");
    }
}
/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class TTestname extends Token
{
    public TTestname()
    {
        super.setText("#testname");
    }

    public TTestname(int line, int pos)
    {
        super.setText("#testname");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TTestname(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTTestname(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseTTestname(this, param);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TTestname text.");
    }
}

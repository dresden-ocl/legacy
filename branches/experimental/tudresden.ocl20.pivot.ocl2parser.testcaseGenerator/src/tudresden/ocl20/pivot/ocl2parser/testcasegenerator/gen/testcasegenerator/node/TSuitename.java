/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class TSuitename extends Token
{
    public TSuitename()
    {
        super.setText("#suitename");
    }

    public TSuitename(int line, int pos)
    {
        super.setText("#suitename");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TSuitename(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTSuitename(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseTSuitename(this, param);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TSuitename text.");
    }
}

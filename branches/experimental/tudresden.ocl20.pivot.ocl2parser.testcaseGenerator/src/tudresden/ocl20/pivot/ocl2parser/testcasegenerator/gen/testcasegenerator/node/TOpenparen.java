/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class TOpenparen extends Token
{
    public TOpenparen()
    {
        super.setText("(");
    }

    public TOpenparen(int line, int pos)
    {
        super.setText("(");
        setLine(line);
        setPos(pos);
    }

    public Object clone()
    {
      return new TOpenparen(getLine(), getPos());
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseTOpenparen(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseTOpenparen(this, param);
    }

    public void setText(String text)
    {
        throw new RuntimeException("Cannot change TOpenparen text.");
    }
}

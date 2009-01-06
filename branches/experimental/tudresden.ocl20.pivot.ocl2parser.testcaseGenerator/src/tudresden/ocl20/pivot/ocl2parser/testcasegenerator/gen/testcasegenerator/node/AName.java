/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import java.util.*;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class AName extends PName
{
    private TTestname _testname_;
    private TIdent _ident_;

    public AName()
    {
    }

    public AName(
        TTestname _testname_,
        TIdent _ident_)
    {
        setTestname(_testname_);

        setIdent(_ident_);

    }
    public Object clone()
    {
        return new AName(
            (TTestname) cloneNode(_testname_),
            (TIdent) cloneNode(_ident_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAName(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseAName(this, param);
    }

    public TTestname getTestname()
    {
        return _testname_;
    }

    public void setTestname(TTestname node)
    {
        if(_testname_ != null)
        {
            _testname_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _testname_ = node;
    }

    public TIdent getIdent()
    {
        return _ident_;
    }

    public void setIdent(TIdent node)
    {
        if(_ident_ != null)
        {
            _ident_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _ident_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_testname_)
            + toString(_ident_);
    }

    void removeChild(Node child)
    {
        if(_testname_ == child)
        {
            _testname_ = null;
            return;
        }

        if(_ident_ == child)
        {
            _ident_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_testname_ == oldChild)
        {
            setTestname((TTestname) newChild);
            return;
        }

        if(_ident_ == oldChild)
        {
            setIdent((TIdent) newChild);
            return;
        }

    }
}

/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import java.util.*;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class AStringSimpleExpression extends PSimpleExpression
{
    private TTick _first_;
    private TStringLiteral _stringLiteral_;
    private TTick _last_;

    public AStringSimpleExpression()
    {
    }

    public AStringSimpleExpression(
        TTick _first_,
        TStringLiteral _stringLiteral_,
        TTick _last_)
    {
        setFirst(_first_);

        setStringLiteral(_stringLiteral_);

        setLast(_last_);

    }
    public Object clone()
    {
        return new AStringSimpleExpression(
            (TTick) cloneNode(_first_),
            (TStringLiteral) cloneNode(_stringLiteral_),
            (TTick) cloneNode(_last_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAStringSimpleExpression(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseAStringSimpleExpression(this, param);
    }

    public TTick getFirst()
    {
        return _first_;
    }

    public void setFirst(TTick node)
    {
        if(_first_ != null)
        {
            _first_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _first_ = node;
    }

    public TStringLiteral getStringLiteral()
    {
        return _stringLiteral_;
    }

    public void setStringLiteral(TStringLiteral node)
    {
        if(_stringLiteral_ != null)
        {
            _stringLiteral_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _stringLiteral_ = node;
    }

    public TTick getLast()
    {
        return _last_;
    }

    public void setLast(TTick node)
    {
        if(_last_ != null)
        {
            _last_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _last_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_first_)
            + toString(_stringLiteral_)
            + toString(_last_);
    }

    void removeChild(Node child)
    {
        if(_first_ == child)
        {
            _first_ = null;
            return;
        }

        if(_stringLiteral_ == child)
        {
            _stringLiteral_ = null;
            return;
        }

        if(_last_ == child)
        {
            _last_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_first_ == oldChild)
        {
            setFirst((TTick) newChild);
            return;
        }

        if(_stringLiteral_ == oldChild)
        {
            setStringLiteral((TStringLiteral) newChild);
            return;
        }

        if(_last_ == oldChild)
        {
            setLast((TTick) newChild);
            return;
        }

    }
}

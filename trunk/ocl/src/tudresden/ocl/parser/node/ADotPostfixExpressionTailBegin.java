/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ADotPostfixExpressionTailBegin extends PPostfixExpressionTailBegin
{
    private TDot _dot_;

    public ADotPostfixExpressionTailBegin()
    {
    }

    public ADotPostfixExpressionTailBegin(
        TDot _dot_)
    {
        setDot(_dot_);

    }
    public Object clone()
    {
        return new ADotPostfixExpressionTailBegin(
            (TDot) cloneNode(_dot_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADotPostfixExpressionTailBegin(this);
    }

    public TDot getDot()
    {
        return _dot_;
    }

    public void setDot(TDot node)
    {
        if(_dot_ != null)
        {
            _dot_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _dot_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_dot_);
    }

    void removeChild(Node child)
    {
        if(_dot_ == child)
        {
            _dot_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_dot_ == oldChild)
        {
            setDot((TDot) newChild);
            return;
        }

    }
}

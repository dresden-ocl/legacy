/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class ANumericUnaryExpression extends PUnaryExpression
{
    private TNumericValue _numericValue_;

    public ANumericUnaryExpression()
    {
    }

    public ANumericUnaryExpression(
        TNumericValue _numericValue_)
    {
        setNumericValue(_numericValue_);

    }
    public Object clone()
    {
        return new ANumericUnaryExpression(
            (TNumericValue) cloneNode(_numericValue_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseANumericUnaryExpression(this);
    }

    public TNumericValue getNumericValue()
    {
        return _numericValue_;
    }

    public void setNumericValue(TNumericValue node)
    {
        if(_numericValue_ != null)
        {
            _numericValue_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _numericValue_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_numericValue_);
    }

    void removeChild(Node child)
    {
        if(_numericValue_ == child)
        {
            _numericValue_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_numericValue_ == oldChild)
        {
            setNumericValue((TNumericValue) newChild);
            return;
        }

    }
}

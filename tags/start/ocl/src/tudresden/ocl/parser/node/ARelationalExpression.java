/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ARelationalExpression extends PRelationalExpression
{
    private PAdditiveExpression _additiveExpression_;
    private PRelationalExpressionTail _relationalExpressionTail_;

    public ARelationalExpression()
    {
    }

    public ARelationalExpression(
        PAdditiveExpression _additiveExpression_,
        PRelationalExpressionTail _relationalExpressionTail_)
    {
        setAdditiveExpression(_additiveExpression_);

        setRelationalExpressionTail(_relationalExpressionTail_);

    }
    public Object clone()
    {
        return new ARelationalExpression(
            (PAdditiveExpression) cloneNode(_additiveExpression_),
            (PRelationalExpressionTail) cloneNode(_relationalExpressionTail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseARelationalExpression(this);
    }

    public PAdditiveExpression getAdditiveExpression()
    {
        return _additiveExpression_;
    }

    public void setAdditiveExpression(PAdditiveExpression node)
    {
        if(_additiveExpression_ != null)
        {
            _additiveExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _additiveExpression_ = node;
    }

    public PRelationalExpressionTail getRelationalExpressionTail()
    {
        return _relationalExpressionTail_;
    }

    public void setRelationalExpressionTail(PRelationalExpressionTail node)
    {
        if(_relationalExpressionTail_ != null)
        {
            _relationalExpressionTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _relationalExpressionTail_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_additiveExpression_)
            + toString(_relationalExpressionTail_);
    }

    void removeChild(Node child)
    {
        if(_additiveExpression_ == child)
        {
            _additiveExpression_ = null;
            return;
        }

        if(_relationalExpressionTail_ == child)
        {
            _relationalExpressionTail_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_additiveExpression_ == oldChild)
        {
            setAdditiveExpression((PAdditiveExpression) newChild);
            return;
        }

        if(_relationalExpressionTail_ == oldChild)
        {
            setRelationalExpressionTail((PRelationalExpressionTail) newChild);
            return;
        }

    }
}


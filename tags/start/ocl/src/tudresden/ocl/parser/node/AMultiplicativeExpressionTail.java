/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AMultiplicativeExpressionTail extends PMultiplicativeExpressionTail
{
    private PMultiplyOperator _multiplyOperator_;
    private PUnaryExpression _unaryExpression_;

    public AMultiplicativeExpressionTail()
    {
    }

    public AMultiplicativeExpressionTail(
        PMultiplyOperator _multiplyOperator_,
        PUnaryExpression _unaryExpression_)
    {
        setMultiplyOperator(_multiplyOperator_);

        setUnaryExpression(_unaryExpression_);

    }
    public Object clone()
    {
        return new AMultiplicativeExpressionTail(
            (PMultiplyOperator) cloneNode(_multiplyOperator_),
            (PUnaryExpression) cloneNode(_unaryExpression_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAMultiplicativeExpressionTail(this);
    }

    public PMultiplyOperator getMultiplyOperator()
    {
        return _multiplyOperator_;
    }

    public void setMultiplyOperator(PMultiplyOperator node)
    {
        if(_multiplyOperator_ != null)
        {
            _multiplyOperator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _multiplyOperator_ = node;
    }

    public PUnaryExpression getUnaryExpression()
    {
        return _unaryExpression_;
    }

    public void setUnaryExpression(PUnaryExpression node)
    {
        if(_unaryExpression_ != null)
        {
            _unaryExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _unaryExpression_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_multiplyOperator_)
            + toString(_unaryExpression_);
    }

    void removeChild(Node child)
    {
        if(_multiplyOperator_ == child)
        {
            _multiplyOperator_ = null;
            return;
        }

        if(_unaryExpression_ == child)
        {
            _unaryExpression_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_multiplyOperator_ == oldChild)
        {
            setMultiplyOperator((PMultiplyOperator) newChild);
            return;
        }

        if(_unaryExpression_ == oldChild)
        {
            setUnaryExpression((PUnaryExpression) newChild);
            return;
        }

    }
}


/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AAdditiveExpression extends PAdditiveExpression
{
    private PMultiplicativeExpression _multiplicativeExpression_;
    private final LinkedList _additiveExpressionTail_ = new TypedLinkedList(new AdditiveExpressionTail_Cast());

    public AAdditiveExpression()
    {
    }

    public AAdditiveExpression(
        PMultiplicativeExpression _multiplicativeExpression_,
        List _additiveExpressionTail_)
    {
        setMultiplicativeExpression(_multiplicativeExpression_);

        {
            Object temp[] = _additiveExpressionTail_.toArray();
            for(int i = 0; i < temp.length; i++)
            {
                this._additiveExpressionTail_.add(temp[i]);
            }
        }

    }

    public AAdditiveExpression(
        PMultiplicativeExpression _multiplicativeExpression_,
        XPAdditiveExpressionTail _additiveExpressionTail_)
    {
        setMultiplicativeExpression(_multiplicativeExpression_);

        if(_additiveExpressionTail_ != null)
        {
            while(_additiveExpressionTail_ instanceof X1PAdditiveExpressionTail)
            {
                this._additiveExpressionTail_.addFirst(((X1PAdditiveExpressionTail) _additiveExpressionTail_).getPAdditiveExpressionTail());
                _additiveExpressionTail_ = ((X1PAdditiveExpressionTail) _additiveExpressionTail_).getXPAdditiveExpressionTail();
            }
            this._additiveExpressionTail_.addFirst(((X2PAdditiveExpressionTail) _additiveExpressionTail_).getPAdditiveExpressionTail());
        }

    }
    public Object clone()
    {
        return new AAdditiveExpression(
            (PMultiplicativeExpression) cloneNode(_multiplicativeExpression_),
            cloneList(_additiveExpressionTail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAdditiveExpression(this);
    }

    public PMultiplicativeExpression getMultiplicativeExpression()
    {
        return _multiplicativeExpression_;
    }

    public void setMultiplicativeExpression(PMultiplicativeExpression node)
    {
        if(_multiplicativeExpression_ != null)
        {
            _multiplicativeExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _multiplicativeExpression_ = node;
    }

    public LinkedList getAdditiveExpressionTail()
    {
        return _additiveExpressionTail_;
    }

    public void setAdditiveExpressionTail(List list)
    {
        Object temp[] = list.toArray();
        for(int i = 0; i < temp.length; i++)
        {
            _additiveExpressionTail_.add(temp[i]);
        }
    }

    public String toString()
    {
        return ""
            + toString(_multiplicativeExpression_)
            + toString(_additiveExpressionTail_);
    }

    void removeChild(Node child)
    {
        if(_multiplicativeExpression_ == child)
        {
            _multiplicativeExpression_ = null;
            return;
        }

        if(_additiveExpressionTail_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_multiplicativeExpression_ == oldChild)
        {
            setMultiplicativeExpression((PMultiplicativeExpression) newChild);
            return;
        }

        for(ListIterator i = _additiveExpressionTail_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class AdditiveExpressionTail_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PAdditiveExpressionTail node = (PAdditiveExpressionTail) o;

            if((node.parent() != null) &&
                (node.parent() != AAdditiveExpression.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AAdditiveExpression.this))
            {
                node.parent(AAdditiveExpression.this);
            }

            return node;
        }
    }
}


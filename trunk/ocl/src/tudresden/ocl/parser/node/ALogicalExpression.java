/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ALogicalExpression extends PLogicalExpression
{
    private PRelationalExpression _relationalExpression_;
    private final LinkedList _logicalExpressionTail_ = new TypedLinkedList(new LogicalExpressionTail_Cast());

    public ALogicalExpression()
    {
    }

    public ALogicalExpression(
        PRelationalExpression _relationalExpression_,
        List _logicalExpressionTail_)
    {
        setRelationalExpression(_relationalExpression_);

        {
            Object temp[] = _logicalExpressionTail_.toArray();
            for(int i = 0; i < temp.length; i++)
            {
                this._logicalExpressionTail_.add(temp[i]);
            }
        }

    }

    public ALogicalExpression(
        PRelationalExpression _relationalExpression_,
        XPLogicalExpressionTail _logicalExpressionTail_)
    {
        setRelationalExpression(_relationalExpression_);

        if(_logicalExpressionTail_ != null)
        {
            while(_logicalExpressionTail_ instanceof X1PLogicalExpressionTail)
            {
                this._logicalExpressionTail_.addFirst(((X1PLogicalExpressionTail) _logicalExpressionTail_).getPLogicalExpressionTail());
                _logicalExpressionTail_ = ((X1PLogicalExpressionTail) _logicalExpressionTail_).getXPLogicalExpressionTail();
            }
            this._logicalExpressionTail_.addFirst(((X2PLogicalExpressionTail) _logicalExpressionTail_).getPLogicalExpressionTail());
        }

    }
    public Object clone()
    {
        return new ALogicalExpression(
            (PRelationalExpression) cloneNode(_relationalExpression_),
            cloneList(_logicalExpressionTail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALogicalExpression(this);
    }

    public PRelationalExpression getRelationalExpression()
    {
        return _relationalExpression_;
    }

    public void setRelationalExpression(PRelationalExpression node)
    {
        if(_relationalExpression_ != null)
        {
            _relationalExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _relationalExpression_ = node;
    }

    public LinkedList getLogicalExpressionTail()
    {
        return _logicalExpressionTail_;
    }

    public void setLogicalExpressionTail(List list)
    {
        Object temp[] = list.toArray();
        for(int i = 0; i < temp.length; i++)
        {
            _logicalExpressionTail_.add(temp[i]);
        }
    }

    public String toString()
    {
        return ""
            + toString(_relationalExpression_)
            + toString(_logicalExpressionTail_);
    }

    void removeChild(Node child)
    {
        if(_relationalExpression_ == child)
        {
            _relationalExpression_ = null;
            return;
        }

        if(_logicalExpressionTail_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_relationalExpression_ == oldChild)
        {
            setRelationalExpression((PRelationalExpression) newChild);
            return;
        }

        for(ListIterator i = _logicalExpressionTail_.listIterator(); i.hasNext();)
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

    private class LogicalExpressionTail_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PLogicalExpressionTail node = (PLogicalExpressionTail) o;

            if((node.parent() != null) &&
                (node.parent() != ALogicalExpression.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != ALogicalExpression.this))
            {
                node.parent(ALogicalExpression.this);
            }

            return node;
        }
    }
}

/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AActualParameterList extends PActualParameterList
{
    private PExpression _expression_;
    private final LinkedList _actualParameterListTail_ = new TypedLinkedList(new ActualParameterListTail_Cast());

    public AActualParameterList()
    {
    }

    public AActualParameterList(
        PExpression _expression_,
        List _actualParameterListTail_)
    {
        setExpression(_expression_);

        {
            Object temp[] = _actualParameterListTail_.toArray();
            for(int i = 0; i < temp.length; i++)
            {
                this._actualParameterListTail_.add(temp[i]);
            }
        }

    }

    public AActualParameterList(
        PExpression _expression_,
        XPActualParameterListTail _actualParameterListTail_)
    {
        setExpression(_expression_);

        if(_actualParameterListTail_ != null)
        {
            while(_actualParameterListTail_ instanceof X1PActualParameterListTail)
            {
                this._actualParameterListTail_.addFirst(((X1PActualParameterListTail) _actualParameterListTail_).getPActualParameterListTail());
                _actualParameterListTail_ = ((X1PActualParameterListTail) _actualParameterListTail_).getXPActualParameterListTail();
            }
            this._actualParameterListTail_.addFirst(((X2PActualParameterListTail) _actualParameterListTail_).getPActualParameterListTail());
        }

    }
    public Object clone()
    {
        return new AActualParameterList(
            (PExpression) cloneNode(_expression_),
            cloneList(_actualParameterListTail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAActualParameterList(this);
    }

    public PExpression getExpression()
    {
        return _expression_;
    }

    public void setExpression(PExpression node)
    {
        if(_expression_ != null)
        {
            _expression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _expression_ = node;
    }

    public LinkedList getActualParameterListTail()
    {
        return _actualParameterListTail_;
    }

    public void setActualParameterListTail(List list)
    {
        Object temp[] = list.toArray();
        for(int i = 0; i < temp.length; i++)
        {
            _actualParameterListTail_.add(temp[i]);
        }
    }

    public String toString()
    {
        return ""
            + toString(_expression_)
            + toString(_actualParameterListTail_);
    }

    void removeChild(Node child)
    {
        if(_expression_ == child)
        {
            _expression_ = null;
            return;
        }

        if(_actualParameterListTail_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_expression_ == oldChild)
        {
            setExpression((PExpression) newChild);
            return;
        }

        for(ListIterator i = _actualParameterListTail_.listIterator(); i.hasNext();)
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

    private class ActualParameterListTail_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PActualParameterListTail node = (PActualParameterListTail) o;

            if((node.parent() != null) &&
                (node.parent() != AActualParameterList.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AActualParameterList.this))
            {
                node.parent(AActualParameterList.this);
            }

            return node;
        }
    }
}


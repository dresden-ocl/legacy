/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AListExpressionListOrRangeTail extends PExpressionListOrRangeTail
{
    private final LinkedList _expressionListTail_ = new TypedLinkedList(new ExpressionListTail_Cast());

    public AListExpressionListOrRangeTail()
    {
    }

    public AListExpressionListOrRangeTail(
        List _expressionListTail_)
    {
        {
            Object temp[] = _expressionListTail_.toArray();
            for(int i = 0; i < temp.length; i++)
            {
                this._expressionListTail_.add(temp[i]);
            }
        }

    }

    public AListExpressionListOrRangeTail(
        XPExpressionListTail _expressionListTail_)
    {
        if(_expressionListTail_ != null)
        {
            while(_expressionListTail_ instanceof X1PExpressionListTail)
            {
                this._expressionListTail_.addFirst(((X1PExpressionListTail) _expressionListTail_).getPExpressionListTail());
                _expressionListTail_ = ((X1PExpressionListTail) _expressionListTail_).getXPExpressionListTail();
            }
            this._expressionListTail_.addFirst(((X2PExpressionListTail) _expressionListTail_).getPExpressionListTail());
        }

    }
    public Object clone()
    {
        return new AListExpressionListOrRangeTail(
            cloneList(_expressionListTail_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAListExpressionListOrRangeTail(this);
    }

    public LinkedList getExpressionListTail()
    {
        return _expressionListTail_;
    }

    public void setExpressionListTail(List list)
    {
        Object temp[] = list.toArray();
        for(int i = 0; i < temp.length; i++)
        {
            _expressionListTail_.add(temp[i]);
        }
    }

    public String toString()
    {
        return ""
            + toString(_expressionListTail_);
    }

    void removeChild(Node child)
    {
        if(_expressionListTail_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        for(ListIterator i = _expressionListTail_.listIterator(); i.hasNext();)
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

    private class ExpressionListTail_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PExpressionListTail node = (PExpressionListTail) o;

            if((node.parent() != null) &&
                (node.parent() != AListExpressionListOrRangeTail.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AListExpressionListOrRangeTail.this))
            {
                node.parent(AListExpressionListOrRangeTail.this);
            }

            return node;
        }
    }
}


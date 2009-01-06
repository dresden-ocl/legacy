/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.AStateList;
import org.sablecc.sablecc.node.Cast;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PStateList;
import org.sablecc.sablecc.node.PStateListTail;
import org.sablecc.sablecc.node.PTransition;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TId;
import org.sablecc.sablecc.node.TLBrace;
import org.sablecc.sablecc.node.TRBrace;
import org.sablecc.sablecc.node.TypedLinkedList;
import org.sablecc.sablecc.node.X1PStateListTail;
import org.sablecc.sablecc.node.X2PStateListTail;
import org.sablecc.sablecc.node.XPStateListTail;



public final class AStateList extends PStateList
{
    private TLBrace _lBrace_;
    private TId _id_;
    private PTransition _transition_;
    private final LinkedList _stateLists_ = new TypedLinkedList(new StateLists_Cast());
    private TRBrace _rBrace_;

    public AStateList()
    {
    }

    public AStateList(
        TLBrace _lBrace_,
        TId _id_,
        PTransition _transition_,
        List _stateLists_,
        TRBrace _rBrace_)
    {
        setLBrace(_lBrace_);

        setId(_id_);

        setTransition(_transition_);

        {
            this._stateLists_.clear();
            this._stateLists_.addAll(_stateLists_);
        }

        setRBrace(_rBrace_);

    }

    public AStateList(
        TLBrace _lBrace_,
        TId _id_,
        PTransition _transition_,
        XPStateListTail _stateLists_,
        TRBrace _rBrace_)
    {
        setLBrace(_lBrace_);

        setId(_id_);

        setTransition(_transition_);

        if(_stateLists_ != null)
        {
            while(_stateLists_ instanceof X1PStateListTail)
            {
                this._stateLists_.addFirst(((X1PStateListTail) _stateLists_).getPStateListTail());
                _stateLists_ = ((X1PStateListTail) _stateLists_).getXPStateListTail();
            }
            this._stateLists_.addFirst(((X2PStateListTail) _stateLists_).getPStateListTail());
        }

        setRBrace(_rBrace_);

    }
    public Object clone()
    {
        return new AStateList(
            (TLBrace) cloneNode(_lBrace_),
            (TId) cloneNode(_id_),
            (PTransition) cloneNode(_transition_),
            cloneList(_stateLists_),
            (TRBrace) cloneNode(_rBrace_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStateList(this);
    }

    public TLBrace getLBrace()
    {
        return _lBrace_;
    }

    public void setLBrace(TLBrace node)
    {
        if(_lBrace_ != null)
        {
            _lBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lBrace_ = node;
    }

    public TId getId()
    {
        return _id_;
    }

    public void setId(TId node)
    {
        if(_id_ != null)
        {
            _id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _id_ = node;
    }

    public PTransition getTransition()
    {
        return _transition_;
    }

    public void setTransition(PTransition node)
    {
        if(_transition_ != null)
        {
            _transition_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _transition_ = node;
    }

    public LinkedList getStateLists()
    {
        return _stateLists_;
    }

    public void setStateLists(List list)
    {
        _stateLists_.clear();
        _stateLists_.addAll(list);
    }

    public TRBrace getRBrace()
    {
        return _rBrace_;
    }

    public void setRBrace(TRBrace node)
    {
        if(_rBrace_ != null)
        {
            _rBrace_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rBrace_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_lBrace_)
            + toString(_id_)
            + toString(_transition_)
            + toString(_stateLists_)
            + toString(_rBrace_);
    }

    void removeChild(Node child)
    {
        if(_lBrace_ == child)
        {
            _lBrace_ = null;
            return;
        }

        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

        if(_transition_ == child)
        {
            _transition_ = null;
            return;
        }

        if(_stateLists_.remove(child))
        {
            return;
        }

        if(_rBrace_ == child)
        {
            _rBrace_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_lBrace_ == oldChild)
        {
            setLBrace((TLBrace) newChild);
            return;
        }

        if(_id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(_transition_ == oldChild)
        {
            setTransition((PTransition) newChild);
            return;
        }

        for(ListIterator i = _stateLists_.listIterator(); i.hasNext();)
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

        if(_rBrace_ == oldChild)
        {
            setRBrace((TRBrace) newChild);
            return;
        }

    }

    private class StateLists_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PStateListTail node = (PStateListTail) o;

            if((node.parent() != null) &&
                (node.parent() != AStateList.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != AStateList.this))
            {
                node.parent(AStateList.this);
            }

            return node;
        }
    }
}

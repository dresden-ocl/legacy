/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;
import org.sablecc.sablecc.analysis.*;

public final class AIdListTail extends PIdListTail
{
    private TComma _comma_;
    private TId _id_;

    public AIdListTail()
    {
    }

    public AIdListTail(
        TComma _comma_,
        TId _id_)
    {
        setComma(_comma_);

        setId(_id_);

    }
    public Object clone()
    {
        return new AIdListTail(
            (TComma) cloneNode(_comma_),
            (TId) cloneNode(_id_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAIdListTail(this);
    }

    public TComma getComma()
    {
        return _comma_;
    }

    public void setComma(TComma node)
    {
        if(_comma_ != null)
        {
            _comma_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _comma_ = node;
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

    public String toString()
    {
        return ""
            + toString(_comma_)
            + toString(_id_);
    }

    void removeChild(Node child)
    {
        if(_comma_ == child)
        {
            _comma_ = null;
            return;
        }

        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_comma_ == oldChild)
        {
            setComma((TComma) newChild);
            return;
        }

        if(_id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

    }
}

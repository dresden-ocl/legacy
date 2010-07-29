/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;
import org.sablecc.sablecc.analysis.*;

public final class AAltsTail extends PAltsTail
{
    private TBar _bar_;
    private PAlt _alt_;

    public AAltsTail()
    {
    }

    public AAltsTail(
        TBar _bar_,
        PAlt _alt_)
    {
        setBar(_bar_);

        setAlt(_alt_);

    }
    public Object clone()
    {
        return new AAltsTail(
            (TBar) cloneNode(_bar_),
            (PAlt) cloneNode(_alt_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAAltsTail(this);
    }

    public TBar getBar()
    {
        return _bar_;
    }

    public void setBar(TBar node)
    {
        if(_bar_ != null)
        {
            _bar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _bar_ = node;
    }

    public PAlt getAlt()
    {
        return _alt_;
    }

    public void setAlt(PAlt node)
    {
        if(_alt_ != null)
        {
            _alt_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _alt_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_bar_)
            + toString(_alt_);
    }

    void removeChild(Node child)
    {
        if(_bar_ == child)
        {
            _bar_ = null;
            return;
        }

        if(_alt_ == child)
        {
            _alt_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_bar_ == oldChild)
        {
            setBar((TBar) newChild);
            return;
        }

        if(_alt_ == oldChild)
        {
            setAlt((PAlt) newChild);
            return;
        }

    }
}

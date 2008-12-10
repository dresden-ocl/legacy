/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;
import org.sablecc.sablecc.analysis.*;

public final class ALookAhead extends PLookAhead
{
    private TSlash _slash_;
    private PRegExp _regExp_;

    public ALookAhead()
    {
    }

    public ALookAhead(
        TSlash _slash_,
        PRegExp _regExp_)
    {
        setSlash(_slash_);

        setRegExp(_regExp_);

    }
    public Object clone()
    {
        return new ALookAhead(
            (TSlash) cloneNode(_slash_),
            (PRegExp) cloneNode(_regExp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALookAhead(this);
    }

    public TSlash getSlash()
    {
        return _slash_;
    }

    public void setSlash(TSlash node)
    {
        if(_slash_ != null)
        {
            _slash_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _slash_ = node;
    }

    public PRegExp getRegExp()
    {
        return _regExp_;
    }

    public void setRegExp(PRegExp node)
    {
        if(_regExp_ != null)
        {
            _regExp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _regExp_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_slash_)
            + toString(_regExp_);
    }

    void removeChild(Node child)
    {
        if(_slash_ == child)
        {
            _slash_ = null;
            return;
        }

        if(_regExp_ == child)
        {
            _regExp_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_slash_ == oldChild)
        {
            setSlash((TSlash) newChild);
            return;
        }

        if(_regExp_ == oldChild)
        {
            setRegExp((PRegExp) newChild);
            return;
        }

    }
}

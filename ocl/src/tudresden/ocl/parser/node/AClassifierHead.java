/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AClassifierHead extends PClassifierHead
{
    private TName _name_;
    private TColon _colon_;

    public AClassifierHead()
    {
    }

    public AClassifierHead(
        TName _name_,
        TColon _colon_)
    {
        setName(_name_);

        setColon(_colon_);

    }
    public Object clone()
    {
        return new AClassifierHead(
            (TName) cloneNode(_name_),
            (TColon) cloneNode(_colon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAClassifierHead(this);
    }

    public TName getName()
    {
        return _name_;
    }

    public void setName(TName node)
    {
        if(_name_ != null)
        {
            _name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _name_ = node;
    }

    public TColon getColon()
    {
        return _colon_;
    }

    public void setColon(TColon node)
    {
        if(_colon_ != null)
        {
            _colon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _colon_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_name_)
            + toString(_colon_);
    }

    void removeChild(Node child)
    {
        if(_name_ == child)
        {
            _name_ = null;
            return;
        }

        if(_colon_ == child)
        {
            _colon_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_name_ == oldChild)
        {
            setName((TName) newChild);
            return;
        }

        if(_colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

    }
}


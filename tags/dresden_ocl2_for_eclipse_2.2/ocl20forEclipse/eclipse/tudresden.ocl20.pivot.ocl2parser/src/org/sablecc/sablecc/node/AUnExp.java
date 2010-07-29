/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;
import org.sablecc.sablecc.analysis.*;

public final class AUnExp extends PUnExp
{
    private PBasic _basic_;
    private PUnOp _unOp_;

    public AUnExp()
    {
    }

    public AUnExp(
        PBasic _basic_,
        PUnOp _unOp_)
    {
        setBasic(_basic_);

        setUnOp(_unOp_);

    }
    public Object clone()
    {
        return new AUnExp(
            (PBasic) cloneNode(_basic_),
            (PUnOp) cloneNode(_unOp_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAUnExp(this);
    }

    public PBasic getBasic()
    {
        return _basic_;
    }

    public void setBasic(PBasic node)
    {
        if(_basic_ != null)
        {
            _basic_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _basic_ = node;
    }

    public PUnOp getUnOp()
    {
        return _unOp_;
    }

    public void setUnOp(PUnOp node)
    {
        if(_unOp_ != null)
        {
            _unOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _unOp_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_basic_)
            + toString(_unOp_);
    }

    void removeChild(Node child)
    {
        if(_basic_ == child)
        {
            _basic_ = null;
            return;
        }

        if(_unOp_ == child)
        {
            _unOp_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_basic_ == oldChild)
        {
            setBasic((PBasic) newChild);
            return;
        }

        if(_unOp_ == oldChild)
        {
            setUnOp((PUnOp) newChild);
            return;
        }

    }
}

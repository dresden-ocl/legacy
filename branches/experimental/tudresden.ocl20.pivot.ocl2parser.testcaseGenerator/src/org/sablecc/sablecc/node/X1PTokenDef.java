/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PTokenDef;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.XPTokenDef;

public final class X1PTokenDef extends XPTokenDef
{
    private XPTokenDef _xPTokenDef_;
    private PTokenDef _pTokenDef_;

    public X1PTokenDef()
    {
    }

    public X1PTokenDef(
        XPTokenDef _xPTokenDef_,
        PTokenDef _pTokenDef_)
    {
        setXPTokenDef(_xPTokenDef_);
        setPTokenDef(_pTokenDef_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPTokenDef getXPTokenDef()
    {
        return _xPTokenDef_;
    }

    public void setXPTokenDef(XPTokenDef node)
    {
        if(_xPTokenDef_ != null)
        {
            _xPTokenDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPTokenDef_ = node;
    }

    public PTokenDef getPTokenDef()
    {
        return _pTokenDef_;
    }

    public void setPTokenDef(PTokenDef node)
    {
        if(_pTokenDef_ != null)
        {
            _pTokenDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pTokenDef_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPTokenDef_ == child)
        {
            _xPTokenDef_ = null;
        }

        if(_pTokenDef_ == child)
        {
            _pTokenDef_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPTokenDef_) +
            toString(_pTokenDef_);
    }
}
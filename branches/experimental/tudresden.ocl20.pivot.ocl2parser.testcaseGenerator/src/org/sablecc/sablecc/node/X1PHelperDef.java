/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PHelperDef;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.XPHelperDef;

public final class X1PHelperDef extends XPHelperDef
{
    private XPHelperDef _xPHelperDef_;
    private PHelperDef _pHelperDef_;

    public X1PHelperDef()
    {
    }

    public X1PHelperDef(
        XPHelperDef _xPHelperDef_,
        PHelperDef _pHelperDef_)
    {
        setXPHelperDef(_xPHelperDef_);
        setPHelperDef(_pHelperDef_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPHelperDef getXPHelperDef()
    {
        return _xPHelperDef_;
    }

    public void setXPHelperDef(XPHelperDef node)
    {
        if(_xPHelperDef_ != null)
        {
            _xPHelperDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPHelperDef_ = node;
    }

    public PHelperDef getPHelperDef()
    {
        return _pHelperDef_;
    }

    public void setPHelperDef(PHelperDef node)
    {
        if(_pHelperDef_ != null)
        {
            _pHelperDef_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pHelperDef_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPHelperDef_ == child)
        {
            _xPHelperDef_ = null;
        }

        if(_pHelperDef_ == child)
        {
            _pHelperDef_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPHelperDef_) +
            toString(_pHelperDef_);
    }
}
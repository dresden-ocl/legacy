/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PProd;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.XPProd;

public final class X2PProd extends XPProd
{
    private PProd _pProd_;

    public X2PProd()
    {
    }

    public X2PProd(
        PProd _pProd_)
    {
        setPProd(_pProd_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public PProd getPProd()
    {
        return _pProd_;
    }

    public void setPProd(PProd node)
    {
        if(_pProd_ != null)
        {
            _pProd_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pProd_ = node;
    }

    void removeChild(Node child)
    {
        if(_pProd_ == child)
        {
            _pProd_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_pProd_);
    }
}
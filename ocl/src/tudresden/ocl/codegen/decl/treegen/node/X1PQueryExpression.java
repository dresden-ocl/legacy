/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class X1PQueryExpression extends XPQueryExpression
{
    private XPQueryExpression _xPQueryExpression_;
    private PQueryExpression _pQueryExpression_;

    public X1PQueryExpression()
    {
    }

    public X1PQueryExpression(
        XPQueryExpression _xPQueryExpression_,
        PQueryExpression _pQueryExpression_)
    {
        setXPQueryExpression(_xPQueryExpression_);
        setPQueryExpression(_pQueryExpression_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPQueryExpression getXPQueryExpression()
    {
        return _xPQueryExpression_;
    }

    public void setXPQueryExpression(XPQueryExpression node)
    {
        if(_xPQueryExpression_ != null)
        {
            _xPQueryExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPQueryExpression_ = node;
    }

    public PQueryExpression getPQueryExpression()
    {
        return _pQueryExpression_;
    }

    public void setPQueryExpression(PQueryExpression node)
    {
        if(_pQueryExpression_ != null)
        {
            _pQueryExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pQueryExpression_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPQueryExpression_ == child)
        {
            _xPQueryExpression_ = null;
        }

        if(_pQueryExpression_ == child)
        {
            _pQueryExpression_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPQueryExpression_) +
            toString(_pQueryExpression_);
    }
}

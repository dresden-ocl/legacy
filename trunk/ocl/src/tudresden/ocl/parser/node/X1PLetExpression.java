/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class X1PLetExpression extends XPLetExpression
{
    private XPLetExpression _xPLetExpression_;
    private PLetExpression _pLetExpression_;

    public X1PLetExpression()
    {
    }

    public X1PLetExpression(
        XPLetExpression _xPLetExpression_,
        PLetExpression _pLetExpression_)
    {
        setXPLetExpression(_xPLetExpression_);
        setPLetExpression(_pLetExpression_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPLetExpression getXPLetExpression()
    {
        return _xPLetExpression_;
    }

    public void setXPLetExpression(XPLetExpression node)
    {
        if(_xPLetExpression_ != null)
        {
            _xPLetExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPLetExpression_ = node;
    }

    public PLetExpression getPLetExpression()
    {
        return _pLetExpression_;
    }

    public void setPLetExpression(PLetExpression node)
    {
        if(_pLetExpression_ != null)
        {
            _pLetExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pLetExpression_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPLetExpression_ == child)
        {
            _xPLetExpression_ = null;
        }

        if(_pLetExpression_ == child)
        {
            _pLetExpression_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPLetExpression_) +
            toString(_pLetExpression_);
    }
}


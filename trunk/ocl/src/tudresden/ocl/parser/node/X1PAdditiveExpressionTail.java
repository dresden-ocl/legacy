/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class X1PAdditiveExpressionTail extends XPAdditiveExpressionTail
{
    private XPAdditiveExpressionTail _xPAdditiveExpressionTail_;
    private PAdditiveExpressionTail _pAdditiveExpressionTail_;

    public X1PAdditiveExpressionTail()
    {
    }

    public X1PAdditiveExpressionTail(
        XPAdditiveExpressionTail _xPAdditiveExpressionTail_,
        PAdditiveExpressionTail _pAdditiveExpressionTail_)
    {
        setXPAdditiveExpressionTail(_xPAdditiveExpressionTail_);
        setPAdditiveExpressionTail(_pAdditiveExpressionTail_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPAdditiveExpressionTail getXPAdditiveExpressionTail()
    {
        return _xPAdditiveExpressionTail_;
    }

    public void setXPAdditiveExpressionTail(XPAdditiveExpressionTail node)
    {
        if(_xPAdditiveExpressionTail_ != null)
        {
            _xPAdditiveExpressionTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPAdditiveExpressionTail_ = node;
    }

    public PAdditiveExpressionTail getPAdditiveExpressionTail()
    {
        return _pAdditiveExpressionTail_;
    }

    public void setPAdditiveExpressionTail(PAdditiveExpressionTail node)
    {
        if(_pAdditiveExpressionTail_ != null)
        {
            _pAdditiveExpressionTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pAdditiveExpressionTail_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPAdditiveExpressionTail_ == child)
        {
            _xPAdditiveExpressionTail_ = null;
        }

        if(_pAdditiveExpressionTail_ == child)
        {
            _pAdditiveExpressionTail_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPAdditiveExpressionTail_) +
            toString(_pAdditiveExpressionTail_);
    }
}

/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import tudresden.ocl.parser.analysis.*;

public final class X1PPostfixExpressionTail extends XPPostfixExpressionTail
{
    private XPPostfixExpressionTail _xPPostfixExpressionTail_;
    private PPostfixExpressionTail _pPostfixExpressionTail_;

    public X1PPostfixExpressionTail()
    {
    }

    public X1PPostfixExpressionTail(
        XPPostfixExpressionTail _xPPostfixExpressionTail_,
        PPostfixExpressionTail _pPostfixExpressionTail_)
    {
        setXPPostfixExpressionTail(_xPPostfixExpressionTail_);
        setPPostfixExpressionTail(_pPostfixExpressionTail_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw)
    {
        throw new RuntimeException("Switch not supported.");
    }

    public XPPostfixExpressionTail getXPPostfixExpressionTail()
    {
        return _xPPostfixExpressionTail_;
    }

    public void setXPPostfixExpressionTail(XPPostfixExpressionTail node)
    {
        if(_xPPostfixExpressionTail_ != null)
        {
            _xPPostfixExpressionTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _xPPostfixExpressionTail_ = node;
    }

    public PPostfixExpressionTail getPPostfixExpressionTail()
    {
        return _pPostfixExpressionTail_;
    }

    public void setPPostfixExpressionTail(PPostfixExpressionTail node)
    {
        if(_pPostfixExpressionTail_ != null)
        {
            _pPostfixExpressionTail_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pPostfixExpressionTail_ = node;
    }

    void removeChild(Node child)
    {
        if(_xPPostfixExpressionTail_ == child)
        {
            _xPPostfixExpressionTail_ = null;
        }

        if(_pPostfixExpressionTail_ == child)
        {
            _pPostfixExpressionTail_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPPostfixExpressionTail_) +
            toString(_pPostfixExpressionTail_);
    }
}


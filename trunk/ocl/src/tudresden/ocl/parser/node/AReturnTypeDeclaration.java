/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AReturnTypeDeclaration extends PReturnTypeDeclaration
{
    private TColon _colon_;
    private PTypeName _typeName_;

    public AReturnTypeDeclaration()
    {
    }

    public AReturnTypeDeclaration(
        TColon _colon_,
        PTypeName _typeName_)
    {
        setColon(_colon_);

        setTypeName(_typeName_);

    }
    public Object clone()
    {
        return new AReturnTypeDeclaration(
            (TColon) cloneNode(_colon_),
            (PTypeName) cloneNode(_typeName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAReturnTypeDeclaration(this);
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

    public PTypeName getTypeName()
    {
        return _typeName_;
    }

    public void setTypeName(PTypeName node)
    {
        if(_typeName_ != null)
        {
            _typeName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _typeName_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_colon_)
            + toString(_typeName_);
    }

    void removeChild(Node child)
    {
        if(_colon_ == child)
        {
            _colon_ = null;
            return;
        }

        if(_typeName_ == child)
        {
            _typeName_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_colon_ == oldChild)
        {
            setColon((TColon) newChild);
            return;
        }

        if(_typeName_ == oldChild)
        {
            setTypeName((PTypeName) newChild);
            return;
        }

    }
}


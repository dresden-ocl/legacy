/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ALetExpressionTypeDeclaration extends PLetExpressionTypeDeclaration
{
    private TColon _colon_;
    private PPathTypeName _pathTypeName_;

    public ALetExpressionTypeDeclaration()
    {
    }

    public ALetExpressionTypeDeclaration(
        TColon _colon_,
        PPathTypeName _pathTypeName_)
    {
        setColon(_colon_);

        setPathTypeName(_pathTypeName_);

    }
    public Object clone()
    {
        return new ALetExpressionTypeDeclaration(
            (TColon) cloneNode(_colon_),
            (PPathTypeName) cloneNode(_pathTypeName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseALetExpressionTypeDeclaration(this);
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

    public PPathTypeName getPathTypeName()
    {
        return _pathTypeName_;
    }

    public void setPathTypeName(PPathTypeName node)
    {
        if(_pathTypeName_ != null)
        {
            _pathTypeName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pathTypeName_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_colon_)
            + toString(_pathTypeName_);
    }

    void removeChild(Node child)
    {
        if(_colon_ == child)
        {
            _colon_ = null;
            return;
        }

        if(_pathTypeName_ == child)
        {
            _pathTypeName_ = null;
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

        if(_pathTypeName_ == oldChild)
        {
            setPathTypeName((PPathTypeName) newChild);
            return;
        }

    }
}


/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class AFeatureCallParameters extends PFeatureCallParameters
{
    private TLPar _lPar_;
    private PDeclarator _declarator_;
    private PActualParameterList _actualParameterList_;
    private TRPar _rPar_;

    public AFeatureCallParameters()
    {
    }

    public AFeatureCallParameters(
        TLPar _lPar_,
        PDeclarator _declarator_,
        PActualParameterList _actualParameterList_,
        TRPar _rPar_)
    {
        setLPar(_lPar_);

        setDeclarator(_declarator_);

        setActualParameterList(_actualParameterList_);

        setRPar(_rPar_);

    }
    public Object clone()
    {
        return new AFeatureCallParameters(
            (TLPar) cloneNode(_lPar_),
            (PDeclarator) cloneNode(_declarator_),
            (PActualParameterList) cloneNode(_actualParameterList_),
            (TRPar) cloneNode(_rPar_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAFeatureCallParameters(this);
    }

    public TLPar getLPar()
    {
        return _lPar_;
    }

    public void setLPar(TLPar node)
    {
        if(_lPar_ != null)
        {
            _lPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _lPar_ = node;
    }

    public PDeclarator getDeclarator()
    {
        return _declarator_;
    }

    public void setDeclarator(PDeclarator node)
    {
        if(_declarator_ != null)
        {
            _declarator_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _declarator_ = node;
    }

    public PActualParameterList getActualParameterList()
    {
        return _actualParameterList_;
    }

    public void setActualParameterList(PActualParameterList node)
    {
        if(_actualParameterList_ != null)
        {
            _actualParameterList_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _actualParameterList_ = node;
    }

    public TRPar getRPar()
    {
        return _rPar_;
    }

    public void setRPar(TRPar node)
    {
        if(_rPar_ != null)
        {
            _rPar_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _rPar_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_lPar_)
            + toString(_declarator_)
            + toString(_actualParameterList_)
            + toString(_rPar_);
    }

    void removeChild(Node child)
    {
        if(_lPar_ == child)
        {
            _lPar_ = null;
            return;
        }

        if(_declarator_ == child)
        {
            _declarator_ = null;
            return;
        }

        if(_actualParameterList_ == child)
        {
            _actualParameterList_ = null;
            return;
        }

        if(_rPar_ == child)
        {
            _rPar_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_lPar_ == oldChild)
        {
            setLPar((TLPar) newChild);
            return;
        }

        if(_declarator_ == oldChild)
        {
            setDeclarator((PDeclarator) newChild);
            return;
        }

        if(_actualParameterList_ == oldChild)
        {
            setActualParameterList((PActualParameterList) newChild);
            return;
        }

        if(_rPar_ == oldChild)
        {
            setRPar((TRPar) newChild);
            return;
        }

    }
}


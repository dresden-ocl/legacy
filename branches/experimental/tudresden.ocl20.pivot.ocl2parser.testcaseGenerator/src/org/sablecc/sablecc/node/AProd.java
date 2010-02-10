/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;

import org.sablecc.sablecc.analysis.*;
import org.sablecc.sablecc.node.AProd;
import org.sablecc.sablecc.node.Node;
import org.sablecc.sablecc.node.PAlts;
import org.sablecc.sablecc.node.PAstType;
import org.sablecc.sablecc.node.PProd;
import org.sablecc.sablecc.node.Switch;
import org.sablecc.sablecc.node.TEqual;
import org.sablecc.sablecc.node.TExclam;
import org.sablecc.sablecc.node.TId;
import org.sablecc.sablecc.node.TSemicolon;



public final class AProd extends PProd
{
    private TExclam _exclam_;
    private TId _id_;
    private PAstType _astType_;
    private TEqual _equal_;
    private PAlts _alts_;
    private TSemicolon _semicolon_;

    public AProd()
    {
    }

    public AProd(
        TExclam _exclam_,
        TId _id_,
        PAstType _astType_,
        TEqual _equal_,
        PAlts _alts_,
        TSemicolon _semicolon_)
    {
        setExclam(_exclam_);

        setId(_id_);

        setAstType(_astType_);

        setEqual(_equal_);

        setAlts(_alts_);

        setSemicolon(_semicolon_);

    }
    public Object clone()
    {
        return new AProd(
            (TExclam) cloneNode(_exclam_),
            (TId) cloneNode(_id_),
            (PAstType) cloneNode(_astType_),
            (TEqual) cloneNode(_equal_),
            (PAlts) cloneNode(_alts_),
            (TSemicolon) cloneNode(_semicolon_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAProd(this);
    }

    public TExclam getExclam()
    {
        return _exclam_;
    }

    public void setExclam(TExclam node)
    {
        if(_exclam_ != null)
        {
            _exclam_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _exclam_ = node;
    }

    public TId getId()
    {
        return _id_;
    }

    public void setId(TId node)
    {
        if(_id_ != null)
        {
            _id_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _id_ = node;
    }

    public PAstType getAstType()
    {
        return _astType_;
    }

    public void setAstType(PAstType node)
    {
        if(_astType_ != null)
        {
            _astType_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _astType_ = node;
    }

    public TEqual getEqual()
    {
        return _equal_;
    }

    public void setEqual(TEqual node)
    {
        if(_equal_ != null)
        {
            _equal_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _equal_ = node;
    }

    public PAlts getAlts()
    {
        return _alts_;
    }

    public void setAlts(PAlts node)
    {
        if(_alts_ != null)
        {
            _alts_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _alts_ = node;
    }

    public TSemicolon getSemicolon()
    {
        return _semicolon_;
    }

    public void setSemicolon(TSemicolon node)
    {
        if(_semicolon_ != null)
        {
            _semicolon_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _semicolon_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_exclam_)
            + toString(_id_)
            + toString(_astType_)
            + toString(_equal_)
            + toString(_alts_)
            + toString(_semicolon_);
    }

    void removeChild(Node child)
    {
        if(_exclam_ == child)
        {
            _exclam_ = null;
            return;
        }

        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

        if(_astType_ == child)
        {
            _astType_ = null;
            return;
        }

        if(_equal_ == child)
        {
            _equal_ = null;
            return;
        }

        if(_alts_ == child)
        {
            _alts_ = null;
            return;
        }

        if(_semicolon_ == child)
        {
            _semicolon_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_exclam_ == oldChild)
        {
            setExclam((TExclam) newChild);
            return;
        }

        if(_id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(_astType_ == oldChild)
        {
            setAstType((PAstType) newChild);
            return;
        }

        if(_equal_ == oldChild)
        {
            setEqual((TEqual) newChild);
            return;
        }

        if(_alts_ == oldChild)
        {
            setAlts((PAlts) newChild);
            return;
        }

        if(_semicolon_ == oldChild)
        {
            setSemicolon((TSemicolon) newChild);
            return;
        }

    }
}
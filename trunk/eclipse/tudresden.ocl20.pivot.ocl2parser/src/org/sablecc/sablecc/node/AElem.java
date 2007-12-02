/* This file was generated by SableCC (http://www.sablecc.org/). */

package org.sablecc.sablecc.node;

import java.util.*;
import org.sablecc.sablecc.analysis.*;

public final class AElem extends PElem
{
    private PElemName _elemName_;
    private TExclam _exclam_;
    private PSpecifier _specifier_;
    private TId _id_;
    private PUnOp _unOp_;
    private TCustomheritage _customHeritage_;
    private TMaketree _makeTree_;

    public AElem()
    {
    }

    public AElem(
        PElemName _elemName_,
        TExclam _exclam_,
        PSpecifier _specifier_,
        TId _id_,
        PUnOp _unOp_,
        TCustomheritage _customHeritage_,
        TMaketree _makeTree_)
    {
        setElemName(_elemName_);

        setExclam(_exclam_);

        setSpecifier(_specifier_);

        setId(_id_);

        setUnOp(_unOp_);

        setCustomHeritage(_customHeritage_);

        setMakeTree(_makeTree_);

    }
    public Object clone()
    {
        return new AElem(
            (PElemName) cloneNode(_elemName_),
            (TExclam) cloneNode(_exclam_),
            (PSpecifier) cloneNode(_specifier_),
            (TId) cloneNode(_id_),
            (PUnOp) cloneNode(_unOp_),
            (TCustomheritage) cloneNode(_customHeritage_),
            (TMaketree) cloneNode(_makeTree_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAElem(this);
    }

    public PElemName getElemName()
    {
        return _elemName_;
    }

    public void setElemName(PElemName node)
    {
        if(_elemName_ != null)
        {
            _elemName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _elemName_ = node;
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

    public PSpecifier getSpecifier()
    {
        return _specifier_;
    }

    public void setSpecifier(PSpecifier node)
    {
        if(_specifier_ != null)
        {
            _specifier_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _specifier_ = node;
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

    public PUnOp getUnOp()
    {
        return _unOp_;
    }

    public void setUnOp(PUnOp node)
    {
        if(_unOp_ != null)
        {
            _unOp_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _unOp_ = node;
    }

    public TCustomheritage getCustomHeritage()
    {
        return _customHeritage_;
    }

    public void setCustomHeritage(TCustomheritage node)
    {
        if(_customHeritage_ != null)
        {
            _customHeritage_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _customHeritage_ = node;
    }

    public TMaketree getMakeTree()
    {
        return _makeTree_;
    }

    public void setMakeTree(TMaketree node)
    {
        if(_makeTree_ != null)
        {
            _makeTree_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _makeTree_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_elemName_)
            + toString(_exclam_)
            + toString(_specifier_)
            + toString(_id_)
            + toString(_unOp_)
            + toString(_customHeritage_)
            + toString(_makeTree_);
    }

    void removeChild(Node child)
    {
        if(_elemName_ == child)
        {
            _elemName_ = null;
            return;
        }

        if(_exclam_ == child)
        {
            _exclam_ = null;
            return;
        }

        if(_specifier_ == child)
        {
            _specifier_ = null;
            return;
        }

        if(_id_ == child)
        {
            _id_ = null;
            return;
        }

        if(_unOp_ == child)
        {
            _unOp_ = null;
            return;
        }

        if(_customHeritage_ == child)
        {
            _customHeritage_ = null;
            return;
        }

        if(_makeTree_ == child)
        {
            _makeTree_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_elemName_ == oldChild)
        {
            setElemName((PElemName) newChild);
            return;
        }

        if(_exclam_ == oldChild)
        {
            setExclam((TExclam) newChild);
            return;
        }

        if(_specifier_ == oldChild)
        {
            setSpecifier((PSpecifier) newChild);
            return;
        }

        if(_id_ == oldChild)
        {
            setId((TId) newChild);
            return;
        }

        if(_unOp_ == oldChild)
        {
            setUnOp((PUnOp) newChild);
            return;
        }

        if(_customHeritage_ == oldChild)
        {
            setCustomHeritage((TCustomheritage) newChild);
            return;
        }

        if(_makeTree_ == oldChild)
        {
            setMakeTree((TMaketree) newChild);
            return;
        }

    }
}

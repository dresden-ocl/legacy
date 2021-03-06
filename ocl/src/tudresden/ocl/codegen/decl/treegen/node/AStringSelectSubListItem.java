/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class AStringSelectSubListItem extends PSelectSubListItem
{
    private TIdentifier _string_;
    private TIdentifier _asClause_;

    public AStringSelectSubListItem()
    {
    }

    public AStringSelectSubListItem(
        TIdentifier _string_,
        TIdentifier _asClause_)
    {
        setString(_string_);

        setAsClause(_asClause_);

    }
    public Object clone()
    {
        return new AStringSelectSubListItem(
            (TIdentifier) cloneNode(_string_),
            (TIdentifier) cloneNode(_asClause_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseAStringSelectSubListItem(this);
    }

    public TIdentifier getString()
    {
        return _string_;
    }

    public void setString(TIdentifier node)
    {
        if(_string_ != null)
        {
            _string_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _string_ = node;
    }

    public TIdentifier getAsClause()
    {
        return _asClause_;
    }

    public void setAsClause(TIdentifier node)
    {
        if(_asClause_ != null)
        {
            _asClause_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _asClause_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_string_)
            + toString(_asClause_);
    }

    void removeChild(Node child)
    {
        if(_string_ == child)
        {
            _string_ = null;
            return;
        }

        if(_asClause_ == child)
        {
            _asClause_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_string_ == oldChild)
        {
            setString((TIdentifier) newChild);
            return;
        }

        if(_asClause_ == oldChild)
        {
            setAsClause((TIdentifier) newChild);
            return;
        }

    }
}

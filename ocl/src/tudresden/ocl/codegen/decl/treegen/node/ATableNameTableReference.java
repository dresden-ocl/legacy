/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class ATableNameTableReference extends PTableReference
{
    private TIdentifier _tableName_;
    private TIdentifier _correlationName_;

    public ATableNameTableReference()
    {
    }

    public ATableNameTableReference(
        TIdentifier _tableName_,
        TIdentifier _correlationName_)
    {
        setTableName(_tableName_);

        setCorrelationName(_correlationName_);

    }
    public Object clone()
    {
        return new ATableNameTableReference(
            (TIdentifier) cloneNode(_tableName_),
            (TIdentifier) cloneNode(_correlationName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseATableNameTableReference(this);
    }

    public TIdentifier getTableName()
    {
        return _tableName_;
    }

    public void setTableName(TIdentifier node)
    {
        if(_tableName_ != null)
        {
            _tableName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tableName_ = node;
    }

    public TIdentifier getCorrelationName()
    {
        return _correlationName_;
    }

    public void setCorrelationName(TIdentifier node)
    {
        if(_correlationName_ != null)
        {
            _correlationName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _correlationName_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_tableName_)
            + toString(_correlationName_);
    }

    void removeChild(Node child)
    {
        if(_tableName_ == child)
        {
            _tableName_ = null;
            return;
        }

        if(_correlationName_ == child)
        {
            _correlationName_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_tableName_ == oldChild)
        {
            setTableName((TIdentifier) newChild);
            return;
        }

        if(_correlationName_ == oldChild)
        {
            setCorrelationName((TIdentifier) newChild);
            return;
        }

    }
}

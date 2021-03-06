/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public final class ADerivedTableTableReference extends PTableReference
{
    private PQueryExpression _queryExpression_;
    private TIdentifier _correlationName_;

    public ADerivedTableTableReference()
    {
    }

    public ADerivedTableTableReference(
        PQueryExpression _queryExpression_,
        TIdentifier _correlationName_)
    {
        setQueryExpression(_queryExpression_);

        setCorrelationName(_correlationName_);

    }
    public Object clone()
    {
        return new ADerivedTableTableReference(
            (PQueryExpression) cloneNode(_queryExpression_),
            (TIdentifier) cloneNode(_correlationName_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseADerivedTableTableReference(this);
    }

    public PQueryExpression getQueryExpression()
    {
        return _queryExpression_;
    }

    public void setQueryExpression(PQueryExpression node)
    {
        if(_queryExpression_ != null)
        {
            _queryExpression_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _queryExpression_ = node;
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
            + toString(_queryExpression_)
            + toString(_correlationName_);
    }

    void removeChild(Node child)
    {
        if(_queryExpression_ == child)
        {
            _queryExpression_ = null;
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
        if(_queryExpression_ == oldChild)
        {
            setQueryExpression((PQueryExpression) newChild);
            return;
        }

        if(_correlationName_ == oldChild)
        {
            setCorrelationName((TIdentifier) newChild);
            return;
        }

    }
}

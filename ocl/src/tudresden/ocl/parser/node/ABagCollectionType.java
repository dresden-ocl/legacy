/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ABagCollectionType extends PCollectionType
{
    private TTBag _tBag_;

    public ABagCollectionType()
    {
    }

    public ABagCollectionType(
        TTBag _tBag_)
    {
        setTBag(_tBag_);

    }
    public Object clone()
    {
        return new ABagCollectionType(
            (TTBag) cloneNode(_tBag_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseABagCollectionType(this);
    }

    public TTBag getTBag()
    {
        return _tBag_;
    }

    public void setTBag(TTBag node)
    {
        if(_tBag_ != null)
        {
            _tBag_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tBag_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_tBag_);
    }

    void removeChild(Node child)
    {
        if(_tBag_ == child)
        {
            _tBag_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_tBag_ == oldChild)
        {
            setTBag((TTBag) newChild);
            return;
        }

    }
}

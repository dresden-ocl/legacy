/* This file was generated by SableCC (http://www.sable.mcgill.ca/sablecc/). */

package tudresden.ocl.parser.node;

import java.util.*;
import tudresden.ocl.parser.analysis.*;

public final class ASetCollectionKind extends PCollectionKind
{
    private TTSet _tSet_;

    public ASetCollectionKind()
    {
    }

    public ASetCollectionKind(
        TTSet _tSet_)
    {
        setTSet(_tSet_);

    }
    public Object clone()
    {
        return new ASetCollectionKind(
            (TTSet) cloneNode(_tSet_));
    }

    public void apply(Switch sw)
    {
        ((Analysis) sw).caseASetCollectionKind(this);
    }

    public TTSet getTSet()
    {
        return _tSet_;
    }

    public void setTSet(TTSet node)
    {
        if(_tSet_ != null)
        {
            _tSet_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _tSet_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_tSet_);
    }

    void removeChild(Node child)
    {
        if(_tSet_ == child)
        {
            _tSet_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_tSet_ == oldChild)
        {
            setTSet((TTSet) newChild);
            return;
        }

    }
}


/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import java.util.*;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class AMetamodelDesc extends PMetamodelDesc
{
    private TMetamodel _metamodel_;
    private TPackageName _packageName_;

    public AMetamodelDesc()
    {
    }

    public AMetamodelDesc(
        TMetamodel _metamodel_,
        TPackageName _packageName_)
    {
        setMetamodel(_metamodel_);

        setPackageName(_packageName_);

    }
    public Object clone()
    {
        return new AMetamodelDesc(
            (TMetamodel) cloneNode(_metamodel_),
            (TPackageName) cloneNode(_packageName_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseAMetamodelDesc(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseAMetamodelDesc(this, param);
    }

    public TMetamodel getMetamodel()
    {
        return _metamodel_;
    }

    public void setMetamodel(TMetamodel node)
    {
        if(_metamodel_ != null)
        {
            _metamodel_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _metamodel_ = node;
    }

    public TPackageName getPackageName()
    {
        return _packageName_;
    }

    public void setPackageName(TPackageName node)
    {
        if(_packageName_ != null)
        {
            _packageName_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _packageName_ = node;
    }

    public String toString()
    {
        return ""
            + toString(_metamodel_)
            + toString(_packageName_);
    }

    void removeChild(Node child)
    {
        if(_metamodel_ == child)
        {
            _metamodel_ = null;
            return;
        }

        if(_packageName_ == child)
        {
            _packageName_ = null;
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_metamodel_ == oldChild)
        {
            setMetamodel((TMetamodel) newChild);
            return;
        }

        if(_packageName_ == oldChild)
        {
            setPackageName((TPackageName) newChild);
            return;
        }

    }
}

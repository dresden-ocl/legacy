/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import java.util.*;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class ATestcasefile extends PTestcasefile
{
    private PName _name_;
    private PPackageDeclaration _packageDeclaration_;
    private PModelDeclaration _modelDeclaration_;
    private final LinkedList _testcaseElement_ = new TypedLinkedList(new TestcaseElement_Cast());

    public ATestcasefile()
    {
    }

    public ATestcasefile(
        PName _name_,
        PPackageDeclaration _packageDeclaration_,
        PModelDeclaration _modelDeclaration_,
        List _testcaseElement_)
    {
        setName(_name_);

        setPackageDeclaration(_packageDeclaration_);

        setModelDeclaration(_modelDeclaration_);

        {
            this._testcaseElement_.clear();
            this._testcaseElement_.addAll(_testcaseElement_);
        }

    }

    public ATestcasefile(
        PName _name_,
        PPackageDeclaration _packageDeclaration_,
        PModelDeclaration _modelDeclaration_,
        XPTestcaseElement _testcaseElement_)
    {
        setName(_name_);

        setPackageDeclaration(_packageDeclaration_);

        setModelDeclaration(_modelDeclaration_);

        if(_testcaseElement_ != null)
        {
            while(_testcaseElement_ instanceof X1PTestcaseElement)
            {
                this._testcaseElement_.addFirst(((X1PTestcaseElement) _testcaseElement_).getPTestcaseElement());
                _testcaseElement_ = ((X1PTestcaseElement) _testcaseElement_).getXPTestcaseElement();
            }
            this._testcaseElement_.addFirst(((X2PTestcaseElement) _testcaseElement_).getPTestcaseElement());
        }

    }
    public Object clone()
    {
        return new ATestcasefile(
            (PName) cloneNode(_name_),
            (PPackageDeclaration) cloneNode(_packageDeclaration_),
            (PModelDeclaration) cloneNode(_modelDeclaration_),
            cloneList(_testcaseElement_));
    }

    public void apply(Switch sw) {
        ((Analysis) sw).caseATestcasefile(this);
    }

    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        return ((AnalysisWithReturn) sw).caseATestcasefile(this, param);
    }

    public PName getName()
    {
        return _name_;
    }

    public void setName(PName node)
    {
        if(_name_ != null)
        {
            _name_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _name_ = node;
    }

    public PPackageDeclaration getPackageDeclaration()
    {
        return _packageDeclaration_;
    }

    public void setPackageDeclaration(PPackageDeclaration node)
    {
        if(_packageDeclaration_ != null)
        {
            _packageDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _packageDeclaration_ = node;
    }

    public PModelDeclaration getModelDeclaration()
    {
        return _modelDeclaration_;
    }

    public void setModelDeclaration(PModelDeclaration node)
    {
        if(_modelDeclaration_ != null)
        {
            _modelDeclaration_.parent(null);
        }

        if(node != null)
        {
            if(node.parent() != null)
            {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _modelDeclaration_ = node;
    }

    public LinkedList getTestcaseElement()
    {
        return _testcaseElement_;
    }

    public void setTestcaseElement(List list)
    {
        _testcaseElement_.clear();
        _testcaseElement_.addAll(list);
    }

    public String toString()
    {
        return ""
            + toString(_name_)
            + toString(_packageDeclaration_)
            + toString(_modelDeclaration_)
            + toString(_testcaseElement_);
    }

    void removeChild(Node child)
    {
        if(_name_ == child)
        {
            _name_ = null;
            return;
        }

        if(_packageDeclaration_ == child)
        {
            _packageDeclaration_ = null;
            return;
        }

        if(_modelDeclaration_ == child)
        {
            _modelDeclaration_ = null;
            return;
        }

        if(_testcaseElement_.remove(child))
        {
            return;
        }

    }

    void replaceChild(Node oldChild, Node newChild)
    {
        if(_name_ == oldChild)
        {
            setName((PName) newChild);
            return;
        }

        if(_packageDeclaration_ == oldChild)
        {
            setPackageDeclaration((PPackageDeclaration) newChild);
            return;
        }

        if(_modelDeclaration_ == oldChild)
        {
            setModelDeclaration((PModelDeclaration) newChild);
            return;
        }

        for(ListIterator i = _testcaseElement_.listIterator(); i.hasNext();)
        {
            if(i.next() == oldChild)
            {
                if(newChild != null)
                {
                    i.set(newChild);
                    oldChild.parent(null);
                    return;
                }

                i.remove();
                oldChild.parent(null);
                return;
            }
        }

    }

    private class TestcaseElement_Cast implements Cast
    {
        public Object cast(Object o)
        {
            PTestcaseElement node = (PTestcaseElement) o;

            if((node.parent() != null) &&
                (node.parent() != ATestcasefile.this))
            {
                node.parent().removeChild(node);
            }

            if((node.parent() == null) ||
                (node.parent() != ATestcasefile.this))
            {
                node.parent(ATestcasefile.this);
            }

            return node;
        }
    }
}

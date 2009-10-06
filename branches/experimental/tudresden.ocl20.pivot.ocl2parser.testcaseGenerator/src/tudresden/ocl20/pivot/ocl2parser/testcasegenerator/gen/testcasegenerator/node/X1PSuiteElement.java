/* This file was generated by SableCC (http://www.sablecc.org/). */

package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.node;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.gen.testcasegenerator.analysis.*;

public final class X1PSuiteElement extends XPSuiteElement
{
    private XPSuiteElement _xPSuiteElement_;
    private PSuiteElement _pSuiteElement_;

    public X1PSuiteElement()
    {
    }

    public X1PSuiteElement(
        XPSuiteElement _xPSuiteElement_,
        PSuiteElement _pSuiteElement_)
    {
        setXPSuiteElement(_xPSuiteElement_);
        setPSuiteElement(_pSuiteElement_);
    }

    public Object clone()
    {
        throw new RuntimeException("Unsupported Operation");
    }

    public void apply(Switch sw) {
        throw new RuntimeException("Switch not supported.");
    }
    public Object apply(SwitchWithReturn sw, Object param) throws AttrEvalException {
        throw new RuntimeException("Switch not supported.");
    }

    public XPSuiteElement getXPSuiteElement() {
        return _xPSuiteElement_;
    }

    public void setXPSuiteElement(XPSuiteElement node) {
        if(_xPSuiteElement_ != null) {
            _xPSuiteElement_.parent(null);
        }

        if(node != null) {
            if(node.parent() != null) {
                node.parent().removeChild(node);
            }
            node.parent(this);
        }

        _xPSuiteElement_ = node;
    }

    public PSuiteElement getPSuiteElement() {
        return _pSuiteElement_;
    }

    public void setPSuiteElement(PSuiteElement node)
    {
        if(_pSuiteElement_ != null)
        {
            _pSuiteElement_.parent(null);
        }

        if(node != null) {
            if(node.parent() != null) {
                node.parent().removeChild(node);
            }

            node.parent(this);
        }

        _pSuiteElement_ = node;
    }

    void removeChild(Node child) {
        if(_xPSuiteElement_ == child)
        {
            _xPSuiteElement_ = null;
        }

        if(_pSuiteElement_ == child)
        {
            _pSuiteElement_ = null;
        }
    }

    void replaceChild(Node oldChild, Node newChild)
    {
    }

    public String toString()
    {
        return "" +
            toString(_xPSuiteElement_) +
            toString(_pSuiteElement_);
    }
}
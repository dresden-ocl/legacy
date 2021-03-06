/* This file was generated by SableCC (http://www.sablecc.org/). */
/* SQL Project Adaptation (C) 2002 by Sten Loecher (sl13) */

package tudresden.ocl.codegen.decl.treegen.node;

import java.util.*;
import tudresden.ocl.codegen.decl.treegen.analysis.*;

public abstract class Node implements Switchable, Cloneable
{
    private Node parent;

    public abstract Object clone();

    public Node parent()
    {
        return parent;
    }

    void parent(Node parent)
    {
        this.parent = parent;
    }

    abstract void removeChild(Node child);
    abstract void replaceChild(Node oldChild, Node newChild);

    public void replaceBy(Node node)
    {
        if(parent != null)
        {
            parent.replaceChild(this, node);
        }
    }

    protected String toString(Node node)
    {
        if(node != null)
        {
            return node.toString();
        }

        return "";
    }

    protected String toString(List list)
    {
        StringBuffer s = new StringBuffer();

        for(Iterator i = list.iterator(); i.hasNext();)
        {
            s.append(i.next());
        }

        return s.toString();
    }

    protected Node cloneNode(Node node)
    {
        if(node != null)
        {
        	// edited sl13: to assign tasks to clones
        	int nodeTask = node.getTaskNumber();
        	Node theClone = (Node)node.clone();
        	theClone.setTaskNumber(nodeTask);
            return theClone;
        }

        return null;
    }

    protected List cloneList(List list)
    {
        List clone = new LinkedList();

        for(Iterator i = list.iterator(); i.hasNext();)
        {        	
        	// edited sl13: to assign tasks to clones
        	Node node = (Node)i.next(); 
        	int nodeTask = node.getTaskNumber();
        	Node theClone = (Node)node.clone();
        	theClone.setTaskNumber(nodeTask);
            clone.add(theClone);
        }

        return clone;
    }
    
    // added sl13: for task to node assignments
    private int taskNumber = -1;
		
	public void setTaskNumber(int no) {
		taskNumber = no;
	}
	
	public int getTaskNumber() {
		return taskNumber;
	}
}

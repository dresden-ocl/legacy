package tudresden.ocl20.pivot.tracer.model;

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;

public class TracerNode {
	private ArrayList<TracerNode> children;
	private TracerItem tracerItem;
	private TracerNode parent;
	private EObject reference;
	
	public TracerNode(TracerNode parent, TracerItem tracerItem, EObject reference) {
		this.tracerItem = tracerItem;
		this.parent = parent;
		this.children = null;
		this.reference = reference;
	}
	
	public void addChild(TracerNode node) {
		if(children == null) {
			children = new ArrayList<TracerNode>();
		}
		//no else
		
		children.add(node);
	}
	
	public TracerItem getTracerItem() {
		return tracerItem;
	}
	
	public TracerNode getParent() {
		return parent;
	}
	
	public TracerNode[] getChildren() {
		if(children == null) {
			return new TracerNode[0];
		}
		
		TracerNode[] result = new TracerNode[children.size()];
		result = children.toArray(result);
		return result;
	}
	
	public boolean isReference(EObject reference) {
		//TODO: remove reference == null
		//return this.reference==null?false:this.reference.equals(reference);
		return this.reference.equals(reference);
	}
	
	public void setTracerItem(TracerItem item) {
		this.tracerItem = item;
	}
	
	public EObject getReference() {
		return this.reference;
	}
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar;

/**
 * The abstract super class for all elements of a grammar. This class provides
 * methods to traverse the grammar rules.
 */
public abstract class OclSyntaxElement {
	
	private OclSyntaxElement[] children;
	private OclSyntaxElement parent;
	private tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclCardinality cardinality;
	
	public OclSyntaxElement(tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclCardinality cardinality, OclSyntaxElement[] children) {
		this.cardinality = cardinality;
		this.children = children;
		if (this.children != null) {
			for (OclSyntaxElement child : this.children) {
				child.setParent(this);
			}
		}
	}
	
	/**
	 * Sets the parent of this syntax element. This method must be invoked at most
	 * once.
	 */
	public void setParent(OclSyntaxElement parent) {
		assert this.parent == null;
		this.parent = parent;
	}
	
	/**
	 * Returns the parent of this syntax element. This parent is determined by the
	 * containment hierarchy in the CS model.
	 */
	public OclSyntaxElement getParent() {
		return parent;
	}
	
	public OclSyntaxElement[] getChildren() {
		if (children == null) {
			return new OclSyntaxElement[0];
		}
		return children;
	}
	
	public org.eclipse.emf.ecore.EClass getMetaclass() {
		return parent.getMetaclass();
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclCardinality getCardinality() {
		return cardinality;
	}
	
}

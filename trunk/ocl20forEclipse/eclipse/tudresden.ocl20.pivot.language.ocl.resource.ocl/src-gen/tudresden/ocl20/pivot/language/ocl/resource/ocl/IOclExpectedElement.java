/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl;

/**
 * An element that is expected at a given position in a resource stream.
 */
public interface IOclExpectedElement {
	
	/**
	 * Returns the names of all tokens that are expected at the given position.
	 */
	public java.util.Set<String> getTokenNames();
	
	/**
	 * Returns the metaclass of the rule that contains the expected element.
	 */
	public org.eclipse.emf.ecore.EClass getRuleMetaclass();
	
	/**
	 * Returns the syntax element that is expected.
	 */
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclSyntaxElement getSymtaxElement();
	
	/**
	 * Adds an element that is a valid follower for this element.
	 */
	public void addFollower(tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclExpectedElement follower, tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclContainedFeature[] path);
	
	/**
	 * Returns all valid followers for this element. Each follower is represented by a
	 * pair of an expected elements and the containment trace that leads from the
	 * current element to the follower.
	 */
	public java.util.Collection<tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclPair<tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclExpectedElement, tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclContainedFeature[]>> getFollowers();
	
}

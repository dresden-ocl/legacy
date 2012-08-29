/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp;

/**
 * A representation for a range in a document where an enumeration literal (i.e.,
 * a set of static strings) is expected.
 */
public class OclExpectedEnumerationTerminal extends tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclAbstractExpectedElement {
	
	private tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclEnumerationTerminal enumerationTerminal;
	
	public OclExpectedEnumerationTerminal(tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclEnumerationTerminal enumerationTerminal) {
		super(enumerationTerminal.getMetaclass());
		this.enumerationTerminal = enumerationTerminal;
	}
	
	public java.util.Set<String> getTokenNames() {
		// EnumerationTerminals are associated with multiple tokens, one for each literal
		// that was mapped to a string
		java.util.Set<String> tokenNames = new java.util.LinkedHashSet<String>();
		java.util.Map<String, String> mapping = enumerationTerminal.getLiteralMapping();
		for (String literalName : mapping.keySet()) {
			String text = mapping.get(literalName);
			if (text != null && !"".equals(text)) {
				tokenNames.add("'" + text + "'");
			}
		}
		return tokenNames;
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclEnumerationTerminal getEnumerationTerminal() {
		return this.enumerationTerminal;
	}
	
	/**
	 * Returns the expected enumeration terminal.
	 */
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.grammar.OclSyntaxElement getSymtaxElement() {
		return enumerationTerminal;
	}
	
	public String toString() {
		return "EnumTerminal \"" + getEnumerationTerminal() + "\"";
	}
	
}

/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp;

public class OclTaskItem {
	
	private String keyword;
	
	private String message;
	
	private int line;
	
	private int charStart;
	
	private int charEnd;
	
	public OclTaskItem(String keyword, String message, int line, int charStart, int charEnd) {
		super();
		this.keyword = keyword;
		this.message = message;
		this.line = line;
		this.charStart = charStart;
		this.charEnd = charEnd;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public String getMessage() {
		return message;
	}
	
	public int getLine() {
		return line;
	}
	
	public int getCharStart() {
		return charStart;
	}
	
	public int getCharEnd() {
		return charEnd;
	}
	
}

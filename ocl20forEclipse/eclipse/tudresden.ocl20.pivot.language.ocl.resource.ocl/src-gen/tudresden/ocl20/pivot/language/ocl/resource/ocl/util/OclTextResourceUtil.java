/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl.util;

/**
 * Class OclTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.
 */
public class OclTextResourceUtil {
	
	/**
	 * Use
	 * tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.getResource
	 * () instead.
	 */
	@Deprecated	
	public static tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclResource getResource(org.eclipse.core.resources.IFile file) {
		return new tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclEclipseProxy().getResource(file);
	}
	
	/**
	 * Use
	 * tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.getResource
	 * () instead.
	 */
	@Deprecated	
	public static tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use
	 * tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.getResource
	 * () instead.
	 */
	@Deprecated	
	public static tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclResource getResource(org.eclipse.emf.common.util.URI uri) {
		return tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.getResource(uri);
	}
	
	/**
	 * Use
	 * tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.getResource
	 * () instead.
	 */
	@Deprecated	
	public static tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return tudresden.ocl20.pivot.language.ocl.resource.ocl.util.OclResourceUtil.getResource(uri, options);
	}
	
}

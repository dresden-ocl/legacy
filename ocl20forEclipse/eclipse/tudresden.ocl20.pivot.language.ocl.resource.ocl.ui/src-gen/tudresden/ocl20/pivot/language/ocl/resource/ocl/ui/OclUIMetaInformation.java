/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl.ui;

public class OclUIMetaInformation extends tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclMetaInformation {
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclHoverTextProvider getHoverTextProvider() {
		return new tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclHoverTextProvider();
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclImageProvider getImageProvider() {
		return tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclImageProvider.INSTANCE;
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclColorManager createColorManager() {
		return new tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclColorManager();
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclTokenScanner createTokenScanner(tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclColorManager colorManager) {
		return new tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclTokenScanner(colorManager);
	}
	
	public tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclCodeCompletionHelper createCodeCompletionHelper() {
		return new tudresden.ocl20.pivot.language.ocl.resource.ocl.ui.OclCodeCompletionHelper();
	}
	
}

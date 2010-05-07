/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis;

import java.util.List;

import tudresden.ocl20.pivot.essentialocl.EssentialOclPlugin;
import tudresden.ocl20.pivot.essentialocl.types.OclLibrary;
import tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclReferenceResolveHelper;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;
import tudresden.ocl20.pivot.pivotmodel.Property;

public class ImplicitPropertyCallCSPropertyReferenceResolver
		implements
		tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclReferenceResolver<tudresden.ocl20.pivot.language.ocl.ImplicitPropertyCallCS, tudresden.ocl20.pivot.pivotmodel.Property> {

	private tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclDefaultResolverDelegate<tudresden.ocl20.pivot.language.ocl.ImplicitPropertyCallCS, tudresden.ocl20.pivot.pivotmodel.Property> delegate = new tudresden.ocl20.pivot.language.ocl.resource.ocl.analysis.OclDefaultResolverDelegate<tudresden.ocl20.pivot.language.ocl.ImplicitPropertyCallCS, tudresden.ocl20.pivot.pivotmodel.Property>();

	public void resolve(
			java.lang.String identifier,
			tudresden.ocl20.pivot.language.ocl.ImplicitPropertyCallCS container,
			org.eclipse.emf.ecore.EReference reference,
			int position,
			boolean resolveFuzzy,
			final tudresden.ocl20.pivot.language.ocl.resource.ocl.IOclReferenceResolveResult<tudresden.ocl20.pivot.pivotmodel.Property> result) {
		IModel model = ModelBusPlugin.getModelRegistry().getActiveModel();
		if (model == null)
			return;
		OclLibrary oclLibrary = EssentialOclPlugin.getOclLibraryProvider()
				.getOclLibrary();

		IOclReferenceResolveHelper rrHelper = OclReferenceResolveHelperProvider
				.getOclReferenceResolveHelper();
		if (rrHelper != null) {
			List<Property> properties = rrHelper.resolveProperty(identifier,
					resolveFuzzy, container, model, oclLibrary);
			for (Property property : properties) {
				if (!resolveFuzzy)
					result.addMapping(identifier, property);
				else
					result.addMapping(property.getName(), property);
			}
		}
	}

	public java.lang.String deResolve(
			tudresden.ocl20.pivot.pivotmodel.Property element,
			tudresden.ocl20.pivot.language.ocl.ImplicitPropertyCallCS container,
			org.eclipse.emf.ecore.EReference reference) {
		return delegate.deResolve(element, container, reference);
	}

	public void setOptions(java.util.Map<?, ?> options) {
		// save options in a field or leave method empty if this resolver does not
		// depend on any option
	}

}

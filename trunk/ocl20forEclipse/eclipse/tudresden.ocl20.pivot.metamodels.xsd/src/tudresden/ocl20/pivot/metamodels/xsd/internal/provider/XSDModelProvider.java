package tudresden.ocl20.pivot.metamodels.xsd.internal.provider;

import java.net.URL;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import tudresden.ocl20.pivot.metamodels.xsd.XSDMetamodelPlugin;
import tudresden.ocl20.pivot.metamodels.xsd.internal.model.XSDModel;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.model.IModelProvider;
import tudresden.ocl20.pivot.model.ModelAccessException;
import tudresden.ocl20.pivot.model.base.AbstractModelProvider;
import tudresden.ocl20.pivot.modelbus.ModelBusPlugin;

/**
 * Implementation of the {@link IModelProvider} interface for XSD models. This
 * implementation will create an {@link XSDModel} instance.
 * 
 * @generated
 */
public class XSDModelProvider extends AbstractModelProvider implements
		IModelProvider {

	// Logger for this class
	private static final Logger logger = Logger.getLogger(XSDModelProvider.class);

	private ResourceSet resourceSet = null;

	/**
	 * @see tudresden.ocl20.pivot.model.IModelProvider#getModel(java.net.URL)
	 * 
	 * @generated
	 */
	public IModel getModel(URL modelURL) throws ModelAccessException {

		if (logger.isDebugEnabled()) {
			logger.debug("getModel(modelURL=" + modelURL + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		URI modelURI;
		IModel model = null;
		Resource resource;

		// try to create a URI
		try {
			modelURI = URI.createURI(modelURL.toString());
		} catch (IllegalArgumentException e) {
			throw new ModelAccessException("Invalid URL: " + modelURL, e); //$NON-NLS-1$
		}

		// Check if the model has already been cached
		if (this.m_modelCache.get(modelURL.toString()) != null) {
			return this.m_modelCache.get(modelURL.toString());
		}
		// no else

		// get the resource
		resource = getResourceSet().getResource(modelURI, false);

		if (resource == null) {
			// we only want to create the resource, not load it
			resource = getResourceSet().createResource(modelURI);
		}

		model =
				new XSDModel(getResourceSet().getResource(modelURI, false),
						ModelBusPlugin.getMetamodelRegistry().getMetamodel(
								XSDMetamodelPlugin.ID));
		
		// Cache the model
		this.m_modelCache.put(modelURL.toString(), model);

		if (logger.isDebugEnabled()) {
			logger.debug("getModel() - exit - return value=" + model); //$NON-NLS-1$
		}

		return model;
	}

	/**
	 * Helper method that lazily creates a resource set.
	 * 
	 * @return
	 */
	protected ResourceSet getResourceSet() {

		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

}
package tudresden.ocl20.pivot.language.ocl.resource.ocl;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import tudresden.ocl20.pivot.essentialocl.types.OclLibrary;
import tudresden.ocl20.pivot.language.ocl.OclExpressionCS;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.pivotmodel.TypedElement;

public interface IOclReferenceResolveHelper {

	List<Namespace> resolveNamespace(String identifier, boolean resolveFuzzy, EObject container, IModel model, OclLibrary oclLibrary);
	
	List<Type> resolveType(String identifier, boolean resolveFuzzy, EObject container, IModel model, OclLibrary oclLibrary);
	
	List<TypedElement> resolveTypedElement(String identifier, boolean resolveFuzzy, EObject container, IModel model, OclLibrary oclLibrary);
	
	List<Property> resolveProperty(String identifier, boolean resolveFuzzy, EObject container, IModel model, OclLibrary oclLibrary);
	
	List<Operation> resolveOperation(String identifier, boolean resolveFuzzy, EObject container, EReference reference, List<OclExpressionCS> parameters, IModel model, OclLibrary oclLibrary);
}

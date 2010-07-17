package tudresden.ocl20.pivot.language.ocl.resource.ocl;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

import tudresden.ocl20.pivot.language.ocl.resource.ocl.mopp.OclResource;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.OclStaticSemanticsException;
import tudresden.ocl20.pivot.language.ocl.staticsemantics.postporcessor.OclStaticSemanticsProvider;
import tudresden.ocl20.pivot.model.IModel;
import tudresden.ocl20.pivot.parser.IOclParser;
import tudresden.ocl20.pivot.parser.ParseException;
import tudresden.ocl20.pivot.parser.SemanticException;
import tudresden.ocl20.pivot.pivotmodel.Constraint;

public class Ocl22Parser implements IOclParser {

	private static Ocl22Parser instance;

	private Ocl22Parser() {

	}

	private static Ocl22Parser instance() {
		if (instance == null)
			instance = new Ocl22Parser();
		return instance;
	}

	public static Ocl22Parser INSTANCE = instance();

	public List<Constraint> doParse(IModel model, URI uri) throws ParseException {
		// return doParse(model, reader, false);
		return null;
	}

	public List<Constraint> doParse(IModel model, URI uri, boolean addToModel)
			throws ParseException {
		try {
			ResourceSet rs = new ResourceSetImpl();
			OclResource resource = new OclResource(uri);
			rs.getResources().add(resource);
			resource.setModel(model);
			resource.load(Collections.EMPTY_MAP);
			if (!resource.getErrors().isEmpty())
				throw new SemanticException(resource.getErrors().get(0).getMessage());
			tudresden.ocl20.pivot.language.ocl.staticsemantics.OclStaticSemantics staticSemantics = OclStaticSemanticsProvider
					.getStaticSemantics(resource);
			List<Constraint> constraints;
			try {
				constraints = staticSemantics.cs2EssentialOcl(resource.getContents()
						.get(0));
			} catch (OclStaticSemanticsException e) {
				throw new SemanticException(e.getMessage(), e);
			}
			if (!resource.getErrors().isEmpty())
				throw new SemanticException(resource.getErrors().get(0).getMessage());
			return constraints;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ParseException(e.getMessage(), e);
		}
	}

}

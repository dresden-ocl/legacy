/*
    Copyright (C) 2008  Nils (s0006383@inf.tu-dresden.de)

    This file is part of the testcase generator for OCL parser of the Dresden OCL2 for Eclipse.

    The testcase generator is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    The testcase generator is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with the testcase generator.  If not, see <http://www.gnu.org/licenses/>.
.
*/
package tudresden.ocl20.pivot.ocl2parser.testcasegenerator.visitors;

import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IAbstractModel;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IAsSetElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.ICollectionKindElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IConstraintElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IConstraintKindElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IEnumerationLiteralElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IErrorElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IEssentialOclElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IIntegerElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IListElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IMetamodelReference;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IModelReference;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.INamespaceElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.INullElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IOperationElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IOperationNewElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IOperationStaticElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IPackageDeclaration;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IParameterElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IParameterKindElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IPropertyElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IPropertyNewElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IPropertyStaticElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IRealElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IStringElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.ITestSuite;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.ITestcase;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.ITestcaseElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.ITypeElement;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.abstractsyntax.IVariable;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.util.BuildingASMException;
import tudresden.ocl20.pivot.ocl2parser.testcasegenerator.util.IEnvironment;

public interface IVisitor {
	//public void visitTest(Test node, IEnvironment env);
	public void visitTestSuite(ITestSuite node, IEnvironment env) throws BuildingASMException;
	public void visitTestcase(ITestcase node, IEnvironment env) throws BuildingASMException;
	public void visitTestcaseElement(ITestcaseElement node, IEnvironment env) throws BuildingASMException;
	//public void visitResult(Result node, IEnvironment env);
	public void visitErrorElement(IErrorElement node, IEnvironment env) throws BuildingASMException;
	public void visitAbstractModel(IAbstractModel node, IEnvironment env) throws BuildingASMException;
	public void visitVariable(IVariable node, IEnvironment env) throws BuildingASMException;
	//public void visitModelExpression(ModelExpression node, IEnvironment env);
	//public void visitEnumerationElement(EnumerationElement node, IEnvironment env);
	public void visitCollectionKindElement(ICollectionKindElement node, IEnvironment env) throws BuildingASMException;
	public void visitConstraintKindElement(IConstraintKindElement node, IEnvironment env) throws BuildingASMException;
	public void visitParameterKindElement(IParameterKindElement node, IEnvironment env) throws BuildingASMException;
	//public void visitComplexElement(ComplexElement node, IEnvironment env);
	public void visitListElement(IListElement node, IEnvironment env) throws BuildingASMException;
	public void visitEssentialOclElement(IEssentialOclElement node, IEnvironment env) throws BuildingASMException;
	//public void visitSimpleElement(SimpleElement node, IEnvironment env);
	public void visitNullElement(INullElement node, IEnvironment env) throws BuildingASMException;
	public void visitRealElement(IRealElement node, IEnvironment env) throws BuildingASMException;
	public void visitIntegerElement(IIntegerElement node, IEnvironment env) throws BuildingASMException;
	public void visitStringElement(IStringElement node, IEnvironment env) throws BuildingASMException;
	//public void visitReferenceElement(ReferenceElement node, IEnvironment env);
	public void visitOperationStaticElement(IOperationStaticElement node, IEnvironment env) throws BuildingASMException;
	public void visitOperationElement(IOperationElement node, IEnvironment env) throws BuildingASMException;
	public void visitTypeElement(ITypeElement node, IEnvironment env) throws BuildingASMException;
	public void visitNamespaceElement(INamespaceElement node, IEnvironment env) throws BuildingASMException;
	public void visitEnumerationLiteralElement(IEnumerationLiteralElement node, IEnvironment env) throws BuildingASMException;
	public void visitPropertyStaticElement(IPropertyStaticElement node, IEnvironment env) throws BuildingASMException;
	public void visitParameterElement(IParameterElement node, IEnvironment env) throws BuildingASMException;
	public void visitOperationNewElement(IOperationNewElement node, IEnvironment env) throws BuildingASMException;
	public void visitPropertyNewElement(IPropertyNewElement node, IEnvironment env) throws BuildingASMException;
	public void visitPropertyElement(IPropertyElement node, IEnvironment env) throws BuildingASMException;
	public void visitConstraintElement(IConstraintElement node, IEnvironment env) throws BuildingASMException;
	public void visitAsSetElement(IAsSetElement node, IEnvironment env) throws BuildingASMException;
	
	public void visitPackageDeclaration(IPackageDeclaration node, IEnvironment env) throws BuildingASMException;
	public void visitModelReference(IModelReference node, IEnvironment env) throws BuildingASMException;
	public void visitMetamodelReference(IMetamodelReference node, IEnvironment env) throws BuildingASMException;
}

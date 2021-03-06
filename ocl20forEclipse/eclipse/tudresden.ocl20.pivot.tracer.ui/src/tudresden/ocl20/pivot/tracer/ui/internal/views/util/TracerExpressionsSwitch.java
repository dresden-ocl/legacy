/*
Copyright (C) 2011 by Lars Schuetze (lschuetze@gmx.net)

This file is part of the OCL 2 Interpreter of Dresden OCL2 for Eclipse.

Dresden OCL2 for Eclipse is free software: you can redistribute it and/or modify 
it under the terms of the GNU Lesser General Public License as published by the 
Free Software Foundation, either version 3 of the License, or (at your option)
any later version.

Dresden OCL2 for Eclipse is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License 
for more details.

You should have received a copy of the GNU Lesser General Public License along 
with Dresden OCL2 for Eclipse. If not, see <http://www.gnu.org/licenses/>.
 */
package tudresden.ocl20.pivot.tracer.ui.internal.views.util;

import org.eclipse.emf.ecore.EObject;

import tudresden.ocl20.pivot.essentialocl.expressions.BooleanLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.CallExp;
import tudresden.ocl20.pivot.essentialocl.expressions.CollectionItem;
import tudresden.ocl20.pivot.essentialocl.expressions.CollectionLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.CollectionLiteralPart;
import tudresden.ocl20.pivot.essentialocl.expressions.CollectionRange;
import tudresden.ocl20.pivot.essentialocl.expressions.EnumLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.ExpressionInOcl;
import tudresden.ocl20.pivot.essentialocl.expressions.FeatureCallExp;
import tudresden.ocl20.pivot.essentialocl.expressions.IfExp;
import tudresden.ocl20.pivot.essentialocl.expressions.IntegerLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.InvalidLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.IterateExp;
import tudresden.ocl20.pivot.essentialocl.expressions.IteratorExp;
import tudresden.ocl20.pivot.essentialocl.expressions.LetExp;
import tudresden.ocl20.pivot.essentialocl.expressions.LiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.LoopExp;
import tudresden.ocl20.pivot.essentialocl.expressions.NumericLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.essentialocl.expressions.OperationCallExp;
import tudresden.ocl20.pivot.essentialocl.expressions.PrimitiveLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.PropertyCallExp;
import tudresden.ocl20.pivot.essentialocl.expressions.RealLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.StringLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.TupleLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.TupleLiteralPart;
import tudresden.ocl20.pivot.essentialocl.expressions.TypeLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.UndefinedLiteralExp;
import tudresden.ocl20.pivot.essentialocl.expressions.UnlimitedNaturalExp;
import tudresden.ocl20.pivot.essentialocl.expressions.Variable;
import tudresden.ocl20.pivot.essentialocl.expressions.VariableExp;
import tudresden.ocl20.pivot.essentialocl.expressions.util.ExpressionsSwitch;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.Expression;
import tudresden.ocl20.pivot.pivotmodel.NamedElement;
import tudresden.ocl20.pivot.pivotmodel.TypedElement;

/**
 * @author Lars Schuetze
 * 
 */
public class TracerExpressionsSwitch extends ExpressionsSwitch<String> {

	@Override
	public String caseVariableExp(VariableExp object) {

		return object.getName();
	}

	@Override
	public String caseVariable(Variable object) {

		return object.getName();
	}

	@Override
	public String caseUnlimitedNaturalExp(UnlimitedNaturalExp object) {

		// TODO Auto-generated method stub
		return super.caseUnlimitedNaturalExp(object);
	}

	@Override
	public String caseTypeLiteralExp(TypeLiteralExp object) {

		return "referred Type: " + object.getReferredType().getName();
	}

	@Override
	public String caseTupleLiteralPart(TupleLiteralPart object) {

		// TODO Auto-generated method stub
		return super.caseTupleLiteralPart(object);
	}

	@Override
	public String caseTupleLiteralExp(TupleLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseTupleLiteralExp(object);
	}

	@Override
	public String caseStringLiteralExp(StringLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseStringLiteralExp(object);
	}

	@Override
	public String caseRealLiteralExp(RealLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseRealLiteralExp(object);
	}

	@Override
	public String casePropertyCallExp(PropertyCallExp object) {

		return "Name: " + object.getReferredProperty().getName() + ", Type: "
				+ object.getType().getName();
	}

	@Override
	public String casePrimitiveLiteralExp(PrimitiveLiteralExp object) {

		// TODO Auto-generated method stub
		return super.casePrimitiveLiteralExp(object);
	}

	@Override
	public String caseOperationCallExp(OperationCallExp object) {

		return (object.getReferredOperation() != null) ? object
				.getReferredOperation().getName() : object.getName();
	}

	@Override
	public String caseOclExpression(OclExpression object) {

		// TODO Auto-generated method stub
		return super.caseOclExpression(object);
	}

	@Override
	public String caseNumericLiteralExp(NumericLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseNumericLiteralExp(object);
	}

	@Override
	public String caseUndefinedLiteralExp(UndefinedLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseUndefinedLiteralExp(object);
	}

	@Override
	public String caseLoopExp(LoopExp object) {

		// TODO Auto-generated method stub
		return super.caseLoopExp(object);
	}

	@Override
	public String caseLiteralExp(LiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseLiteralExp(object);
	}

	@Override
	public String caseLetExp(LetExp object) {

		// TODO Auto-generated method stub
		return super.caseLetExp(object);
	}

	@Override
	public String caseIteratorExp(IteratorExp object) {

		return object.getName();
	}

	@Override
	public String caseIterateExp(IterateExp object) {

		// TODO Auto-generated method stub
		return super.caseIterateExp(object);
	}

	@Override
	public String caseInvalidLiteralExp(InvalidLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseInvalidLiteralExp(object);
	}

	@Override
	public String caseIntegerLiteralExp(IntegerLiteralExp object) {

		return Integer.toString(object.getIntegerSymbol());
	}

	@Override
	public String caseIfExp(IfExp object) {

		// TODO Auto-generated method stub
		return super.caseIfExp(object);
	}

	@Override
	public String caseFeatureCallExp(FeatureCallExp object) {

		// TODO Auto-generated method stub
		return super.caseFeatureCallExp(object);
	}

	@Override
	public String caseBooleanLiteralExp(BooleanLiteralExp object) {

		return object.getName();
	}

	@Override
	public String caseCallExp(CallExp object) {

		// TODO Auto-generated method stub
		return super.caseCallExp(object);
	}

	@Override
	public String caseCollectionItem(CollectionItem object) {

		// TODO Auto-generated method stub
		return super.caseCollectionItem(object);
	}

	@Override
	public String caseCollectionLiteralExp(CollectionLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseCollectionLiteralExp(object);
	}

	@Override
	public String caseCollectionLiteralPart(CollectionLiteralPart object) {

		// TODO Auto-generated method stub
		return super.caseCollectionLiteralPart(object);
	}

	@Override
	public String caseCollectionRange(CollectionRange object) {

		// TODO Auto-generated method stub
		return super.caseCollectionRange(object);
	}

	@Override
	public String caseEnumLiteralExp(EnumLiteralExp object) {

		// TODO Auto-generated method stub
		return super.caseEnumLiteralExp(object);
	}

	@Override
	public String caseExpressionInOcl(ExpressionInOcl object) {

		return object.getBody().trim();
	}

	@Override
	public String caseTypedElement(TypedElement object) {

		// TODO Auto-generated method stub
		return super.caseTypedElement(object);
	}

	@Override
	public String caseNamedElement(NamedElement object) {

		// TODO Auto-generated method stub
		return super.caseNamedElement(object);
	}

	@Override
	public String caseExpression(Expression object) {

		// TODO Auto-generated method stub
		return super.caseExpression(object);
	}

	@Override
	public String defaultCase(EObject object) {

		if (object instanceof Constraint) {
			return ((Constraint) object).getSpecification().getBody().trim();
		}
		else
			return object.getClass().getCanonicalName() + " NOT IMPLEMENTED YET";
	}

}

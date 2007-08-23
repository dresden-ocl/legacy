/**
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 * Copyright (C) 2007 Matthias Braeuer (braeuer.matthias@web.de).            *
 * All rights reserved.                                                      *
 *                                                                           *
 * This work was done as a project at the Chair for Software Technology,     *
 * Dresden University Of Technology, Germany (http://st.inf.tu-dresden.de).  *
 * It is understood that any modification not identified as such is not      *
 * covered by the preceding statement.                                       *
 *                                                                           *
 * This work is free software; you can redistribute it and/or modify it      *
 * under the terms of the GNU Library General Public License as published    *
 * by the Free Software Foundation; either version 2 of the License, or      *
 * (at your option) any later version.                                       *
 *                                                                           *
 * This work is distributed in the hope that it will be useful, but WITHOUT  *
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or     *
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Library General Public     *
 * License for more details.                                                 *
 *                                                                           *
 * You should have received a copy of the GNU Library General Public License *
 * along with this library; if not, you can view it online at                *
 * http://www.fsf.org/licensing/licenses/gpl.html.                           *
 *                                                                           *
 * To submit a bug report, send a comment, or get the latest news on this    *
 * project, please visit the website: http://dresden-ocl.sourceforge.net.    *
 * For more information on OCL and related projects visit the OCL Portal:    *
 * http://st.inf.tu-dresden.de/ocl                                           *
 * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *
 *
 * $Id$
 */
package tudresden.ocl20.pivot.parser.internal.xocl;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.osgi.util.NLS;

import tudresden.ocl20.pivot.essentialocl.expressions.CollectionItem;
import tudresden.ocl20.pivot.essentialocl.expressions.CollectionKind;
import tudresden.ocl20.pivot.essentialocl.expressions.CollectionLiteralPart;
import tudresden.ocl20.pivot.essentialocl.expressions.CollectionRange;
import tudresden.ocl20.pivot.essentialocl.expressions.ExpressionInOcl;
import tudresden.ocl20.pivot.essentialocl.expressions.OclExpression;
import tudresden.ocl20.pivot.essentialocl.expressions.TupleLiteralPart;
import tudresden.ocl20.pivot.essentialocl.expressions.Variable;
import tudresden.ocl20.pivot.essentialocl.types.CollectionType;
import tudresden.ocl20.pivot.modelbus.FactoryException;
import tudresden.ocl20.pivot.modelbus.IModelFactory;
import tudresden.ocl20.pivot.modelbus.ITypeResolver;
import tudresden.ocl20.pivot.modelbus.ModelAccessException;
import tudresden.ocl20.pivot.modelbus.TypeNotFoundException;
import tudresden.ocl20.pivot.parser.AbstractOclParser;
import tudresden.ocl20.pivot.parser.IOclParser;
import tudresden.ocl20.pivot.parser.ParseException;
import tudresden.ocl20.pivot.parser.internal.ParserMessages;
import tudresden.ocl20.pivot.pivotmodel.ConstrainableElement;
import tudresden.ocl20.pivot.pivotmodel.Constraint;
import tudresden.ocl20.pivot.pivotmodel.ConstraintKind;
import tudresden.ocl20.pivot.pivotmodel.Expression;
import tudresden.ocl20.pivot.pivotmodel.Namespace;
import tudresden.ocl20.pivot.pivotmodel.Operation;
import tudresden.ocl20.pivot.pivotmodel.Property;
import tudresden.ocl20.pivot.pivotmodel.Type;
import tudresden.ocl20.pivot.xocl.BooleanLiteralExpXS;
import tudresden.ocl20.pivot.xocl.CollectionItemXS;
import tudresden.ocl20.pivot.xocl.CollectionKindXS;
import tudresden.ocl20.pivot.xocl.CollectionLiteralExpXS;
import tudresden.ocl20.pivot.xocl.CollectionLiteralPartXS;
import tudresden.ocl20.pivot.xocl.CollectionOperationCallExpXS;
import tudresden.ocl20.pivot.xocl.CollectionRangeXS;
import tudresden.ocl20.pivot.xocl.ConstraintKindXS;
import tudresden.ocl20.pivot.xocl.ConstraintXS;
import tudresden.ocl20.pivot.xocl.EnumLiteralExpXS;
import tudresden.ocl20.pivot.xocl.ExpressionInOclXS;
import tudresden.ocl20.pivot.xocl.IfExpXS;
import tudresden.ocl20.pivot.xocl.IntegerLiteralExpXS;
import tudresden.ocl20.pivot.xocl.InvalidLiteralExpXS;
import tudresden.ocl20.pivot.xocl.IterateExpXS;
import tudresden.ocl20.pivot.xocl.IteratorExpXS;
import tudresden.ocl20.pivot.xocl.LetExpXS;
import tudresden.ocl20.pivot.xocl.ModelOperationCallExpXS;
import tudresden.ocl20.pivot.xocl.NamespaceXS;
import tudresden.ocl20.pivot.xocl.OclExpressionXS;
import tudresden.ocl20.pivot.xocl.OperationCallExpXS;
import tudresden.ocl20.pivot.xocl.PropertyCallExpXS;
import tudresden.ocl20.pivot.xocl.RealLiteralExpXS;
import tudresden.ocl20.pivot.xocl.StaticOperationCallExpXS;
import tudresden.ocl20.pivot.xocl.StaticPropertyCallExpXS;
import tudresden.ocl20.pivot.xocl.StringLiteralExpXS;
import tudresden.ocl20.pivot.xocl.TupleLiteralExpXS;
import tudresden.ocl20.pivot.xocl.TupleLiteralPartXS;
import tudresden.ocl20.pivot.xocl.TypeLiteralExpXS;
import tudresden.ocl20.pivot.xocl.UndefinedLiteralExpXS;
import tudresden.ocl20.pivot.xocl.VariableExpXS;
import tudresden.ocl20.pivot.xocl.VariableXS;
import tudresden.ocl20.pivot.xocl.XOCLPackage;
import tudresden.ocl20.pivot.xocl.util.XOCLSwitch;

/**
 * A parser for XOCL expressions.
 * 
 * @author Matthias Braeuer
 * @version 1.0 17.04.2007
 */
public class XOCLParser extends AbstractOclParser implements IOclParser {

  /**
   * A concrete {@link XOCLSwitch} that uses an {@link IModelFactory} to produce
   * {@link OclExpression}s from {@link OclExpressionXS} elements.
   */
  protected class ModelSwitch extends XOCLSwitch<OclExpression> {

    /**
     * Logger for this class
     */
    private final Logger logger = Logger.getLogger(ModelSwitch.class);

    // a cache of previously created variables
    private Map<VariableXS, Variable> variables;

    // the cached model factory
    private IModelFactory modelFactory;

    /**
     * Creates a new <code>ModelSwitch</code> instance.
     * 
     * @param variables the map of variables visible in the scope of the
     *          associated <code>ExpressionInOcl</code>
     * @param modelFactory2
     */
    public ModelSwitch(Map<VariableXS, Variable> variables,
        IModelFactory modelFactory) {
      this.variables = variables;
      this.modelFactory = modelFactory;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#casePropertyCallExpXS(tudresden.ocl20.pivot.xocl.PropertyCallExpXS)
     */
    @Override
    public OclExpression casePropertyCallExpXS(PropertyCallExpXS expression) {
      List<OclExpression> qualifier = new ArrayList<OclExpression>(expression
          .getQualifier().size());

      // parse the qualifiers of the property call expression
      for (OclExpressionXS oclExpressionXS : expression.getQualifier()) {
        qualifier.add(doSwitch(oclExpressionXS));
      }

      return modelFactory.createPropertyCallExp(
          doSwitch(expression.getSource()), expression
              .getReferredPropertyName(), qualifier
              .toArray(new OclExpression[qualifier.size()]));
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseStaticPropertyCallExpXS(tudresden.ocl20.pivot.xocl.StaticPropertyCallExpXS)
     */
    @Override
    public OclExpression caseStaticPropertyCallExpXS(
        StaticPropertyCallExpXS expression) {

      if (logger.isDebugEnabled()) {
        logger.debug("caseStaticPropertyCallExpXS(expression=" + expression //$NON-NLS-1$
            + ") - enter"); //$NON-NLS-1$
      }

      List<OclExpression> qualifier;

      // parse the qualifiers of the property call expression
      qualifier = new ArrayList<OclExpression>(expression.getQualifier().size());

      for (OclExpressionXS oclExpressionXS : expression.getQualifier()) {
        qualifier.add(doSwitch(oclExpressionXS));
      }

      try {
        OclExpression returnOclExpression = modelFactory.createPropertyCallExp(
            tokenizePathName(expression.getReferredPropertyName()), qualifier
                .toArray(new OclExpression[qualifier.size()]));

        if (logger.isDebugEnabled()) {
          logger.debug("caseStaticPropertyCallExpXS() - exit - return value=" //$NON-NLS-1$
              + returnOclExpression);
        }

        return returnOclExpression;
      }

      catch (FactoryException e) {
        logger.error("caseStaticPropertyCallExpXS(expression=" + expression //$NON-NLS-1$
            + ")", e); //$NON-NLS-1$

        throw new ParseRuntimeException(
            "Failed to parse static property call '" //$NON-NLS-1$
                + expression.getReferredPropertyName() + "'.", e); //$NON-NLS-1$
      }

    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseModelOperationCallExpXS(tudresden.ocl20.pivot.xocl.ModelOperationCallExpXS)
     */
    @Override
    public OclExpression caseModelOperationCallExpXS(
        ModelOperationCallExpXS expression) {
      return modelFactory.createOperationCallExp(doSwitch(expression
          .getSource()), expression.getReferredOperationName(),
          parseArguments(expression));
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseStaticOperationCallExpXS(tudresden.ocl20.pivot.xocl.StaticOperationCallExpXS)
     */
    @Override
    public OclExpression caseStaticOperationCallExpXS(
        StaticOperationCallExpXS expression) {

      if (logger.isDebugEnabled()) {
        logger.debug("caseStaticOperationCallExpXS(expression=" + expression //$NON-NLS-1$
            + ") - enter"); //$NON-NLS-1$
      }

      try {
        OclExpression returnOclExpression = modelFactory
            .createOperationCallExp(tokenizePathName(expression
                .getReferredOperationName()), parseArguments(expression));

        if (logger.isDebugEnabled()) {
          logger.debug("caseStaticOperationCallExpXS() - exit - return value=" //$NON-NLS-1$
              + returnOclExpression);
        }

        return returnOclExpression;
      }

      catch (FactoryException e) {
        logger.error("caseStaticOperationCallExpXS(expression=" + expression //$NON-NLS-1$
            + ")", e); //$NON-NLS-1$

        throw new ParseRuntimeException(
            "Failed to parse the static operation call '" //$NON-NLS-1$
                + expression.getReferredOperationName() + "'.", e); //$NON-NLS-1$
      }
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseCollectionOperationCallExpXS(tudresden.ocl20.pivot.xocl.CollectionOperationCallExpXS)
     */
    @Override
    public OclExpression caseCollectionOperationCallExpXS(
        CollectionOperationCallExpXS expression) {

      // parse the source expression
      OclExpression source = doSwitch(expression.getSource());

      // if the source expression is not a collection type, we need to create a
      // Singleton set with
      // the expression (OCL Specification, Section 9.3)
      if (!(source.getType() instanceof CollectionType)) {
        source = source.withAsSet();
      }

      return modelFactory.createOperationCallExp(source, expression
          .getReferredCollectionOperation().toString(),
          parseArguments(expression));
    }

    /**
     * Helper method to parse the arguments of an operation call expression.
     */
    private OclExpression[] parseArguments(OperationCallExpXS operationCallExpXS) {
      List<OclExpression> arguments;

      // create a new list for the OCL expressions parsed from the arguments
      arguments = new ArrayList<OclExpression>(operationCallExpXS.getArgument()
          .size());

      // parse the arguments of the operation call expression
      for (OclExpressionXS oclExpressionXS : operationCallExpXS.getArgument()) {
        arguments.add(doSwitch(oclExpressionXS));
      }

      return arguments.toArray(new OclExpression[arguments.size()]);
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseLetExpXS(tudresden.ocl20.pivot.xocl.LetExpXS)
     */
    @Override
    public OclExpression caseLetExpXS(LetExpXS expression) {
      VariableXS variableXS = expression.getVariable();

      if (variableXS == null) {
        throw new IllegalArgumentException(
            "The declared variable of a LetExpXS must not be null."); //$NON-NLS-1$
      }

      Variable variable = variables.get(expression.getVariable());

      if (variable == null) {
        variable = createVariable(variableXS, this, modelFactory);
        variables.put(variableXS, variable);
      }

      return modelFactory.createLetExp(variable, doSwitch(expression.getIn()));
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseVariableExpXS(tudresden.ocl20.pivot.xocl.VariableExpXS)
     */
    @Override
    public OclExpression caseVariableExpXS(VariableExpXS expression) {
      VariableXS variableXS = expression.getReferredVariable();

      if (variableXS == null) {
        throw new IllegalArgumentException(
            "The referred variable of a VariableExp must not be null."); //$NON-NLS-1$
      }

      Variable variable = variables.get(expression.getReferredVariable());

      if (variable == null) {
        throw new IllegalStateException("The variable '" //$NON-NLS-1$
            + expression.getReferredVariable().getName()
            + "' has not been defined."); //$NON-NLS-1$
      }

      return modelFactory.createVariableExp(variable);
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseBooleanLiteralExpXS(tudresden.ocl20.pivot.xocl.BooleanLiteralExpXS)
     */
    @Override
    public OclExpression caseBooleanLiteralExpXS(BooleanLiteralExpXS expression) {
      return modelFactory.createBooleanLiteralExp(expression.isBooleanSymbol());
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseIntegerLiteralExpXS(tudresden.ocl20.pivot.xocl.IntegerLiteralExpXS)
     */
    @Override
    public OclExpression caseIntegerLiteralExpXS(IntegerLiteralExpXS expression) {
      return modelFactory
          .createIntegerLiteralExp(expression.getIntegerSymbol());
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseRealLiteralExpXS(tudresden.ocl20.pivot.xocl.RealLiteralExpXS)
     */
    @Override
    public OclExpression caseRealLiteralExpXS(RealLiteralExpXS expression) {
      return modelFactory.createRealLiteralExp(expression.getRealSymbol());
    }

    /**
     * Parses a <code>StringLiteralExpressionXS</code>.
     */
    @Override
    public OclExpression caseStringLiteralExpXS(StringLiteralExpXS expression) {
      return modelFactory.createStringLiteralExp(expression.getStringSymbol());
    }

    /**
     * Parses an <code>EnumLiteralExpXS^</code>.
     */
    @Override
    public OclExpression caseEnumLiteralExpXS(EnumLiteralExpXS expression) {
      if (logger.isDebugEnabled()) {
        logger.debug("caseEnumLiteralExpXS(expression=" + expression //$NON-NLS-1$
            + ") - enter"); //$NON-NLS-1$
      }

      OclExpression enumLiteralExp;

      try {
        enumLiteralExp = modelFactory
            .createEnumLiteralExp(tokenizePathName(expression
                .getReferredEnumLiteralPathName()));
      }

      catch (FactoryException e) {
        logger.error("caseEnumLiteralExpXS(expression=" + expression + ")", e); //$NON-NLS-1$ //$NON-NLS-2$

        throw new ParseRuntimeException(
            "An error occured when creating the enum literal expression for '" //$NON-NLS-1$
                + expression.getReferredEnumLiteralPathName() + "'.", e); //$NON-NLS-1$

      }

      if (logger.isDebugEnabled()) {
        logger.debug("caseEnumLiteralExpXS() - exit - return value=" //$NON-NLS-1$
            + enumLiteralExp);
      }

      return enumLiteralExp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseTypeLiteralExpXS(tudresden.ocl20.pivot.xocl.TypeLiteralExpXS)
     */
    @Override
    public OclExpression caseTypeLiteralExpXS(TypeLiteralExpXS expression) {
      OclExpression typeLiteralExp;

      try {
        typeLiteralExp = modelFactory
            .createTypeLiteralExp(tokenizePathName(expression
                .getReferredTypeName()));
      }

      catch (FactoryException e) {
        throw new ParseRuntimeException(
            "An error occured when creating the type literal expression for '" //$NON-NLS-1$
                + expression.getReferredTypeName() + "'.", e); //$NON-NLS-1$
      }

      return typeLiteralExp;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseCollectionLiteralExpXS(tudresden.ocl20.pivot.xocl.CollectionLiteralExpXS)
     */
    @Override
    public OclExpression caseCollectionLiteralExpXS(
        CollectionLiteralExpXS expression) {
      List<CollectionLiteralPart> parts = new ArrayList<CollectionLiteralPart>(
          expression.getPart().size());

      // parse the individual parts
      for (CollectionLiteralPartXS part : expression.getPart()) {

        switch (part.eClass().getClassifierID()) {
          case XOCLPackage.COLLECTION_ITEM_XS:
            parts.add(createCollectionItem((CollectionItemXS) part));
            break;
          case XOCLPackage.COLLECTION_RANGE_XS:
            parts.add(createCollectionRange((CollectionRangeXS) part));
            break;
        }
      }

      return modelFactory.createCollectionLiteralExp(
          translateCollectionKind(expression.getKind()), parts
              .toArray(new CollectionLiteralPart[parts.size()]));
    }

    /**
     * Helper method to create an OCL abstract syntax {@link CollectionItem}
     * from an XOCL {@link CollectionItemXS}.
     */
    private CollectionLiteralPart createCollectionItem(CollectionItemXS part) {
      return modelFactory.createCollectionItem(doSwitch(part.getItem()));
    }

    /**
     * Helper method to create an OCL abstract syntax {@link CollectionRange}
     * from an XOCL {@link CollectionRangeXS}.
     */
    private CollectionLiteralPart createCollectionRange(CollectionRangeXS part) {
      return modelFactory.createCollectionRange(doSwitch(part.getFirst()),
          doSwitch(part.getLast()));
    }

    /**
     * Translates a collection kind from XOCL to the OCL abstract syntax
     * equivalent.
     */
    private CollectionKind translateCollectionKind(
        CollectionKindXS collectionKindXS) {
      CollectionKind kind;

      switch (collectionKindXS) {
        case SEQUENCE:
          kind = CollectionKind.SEQUENCE;
          break;

        case BAG:
          kind = CollectionKind.BAG;
          break;

        case SET:
          kind = CollectionKind.SET;
          break;

        case ORDERED_SET:
          kind = CollectionKind.ORDERED_SET;
          break;

        default:
          throw new IllegalArgumentException(
              "Unknown collection kind '" + collectionKindXS //$NON-NLS-1$
                  + "' found in XOCL expression."); //$NON-NLS-1$
      }

      return kind;
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseTupleLiteralExpXS(tudresden.ocl20.pivot.xocl.TupleLiteralExpXS)
     */
    @Override
    public OclExpression caseTupleLiteralExpXS(TupleLiteralExpXS expression) {
      List<TupleLiteralPart> parts;

      // parse the tuple literal parts
      parts = new ArrayList<TupleLiteralPart>(expression.getPart().size());

      for (TupleLiteralPartXS partXS : expression.getPart()) {
        parts.add(createTupleLiteralPart(partXS));
      }

      return modelFactory.createTupleLiteralExp(parts
          .toArray(new TupleLiteralPart[parts.size()]));
    }

    /**
     * Helper method to parse a {@link TupleLiteralPartXS}.
     */
    protected TupleLiteralPart createTupleLiteralPart(
        TupleLiteralPartXS tupleLiteralPartXS) {

      if (logger.isDebugEnabled()) {
        logger.debug("createTupleLiteralPart(tupleLiteralPartXS=" //$NON-NLS-1$
            + tupleLiteralPartXS + ") - enter"); //$NON-NLS-1$
      }

      TupleLiteralPart part;

      try {
        part = modelFactory.createTupleLiteralPart(createVariable(
            tupleLiteralPartXS.getVariableDeclaration(), this, modelFactory));
      }

      catch (FactoryException e) {
        logger.error("createTupleLiteralPart(tupleLiteralPartXS=" //$NON-NLS-1$
            + tupleLiteralPartXS + ")", e); //$NON-NLS-1$

        throw new ParseRuntimeException(
            "Failed to create tuple literal part from variable '" //$NON-NLS-1$
                + tupleLiteralPartXS.getVariableDeclaration().getName() + "'.", //$NON-NLS-1$
            e);

      }

      if (logger.isDebugEnabled()) {
        logger.debug("createTupleLiteralPart() - exit - return value=" + part); //$NON-NLS-1$
      }

      return part;

    }

    /**
     * Parses an <code>IterateExpXS</code>.
     */
    @Override
    public OclExpression caseIterateExpXS(IterateExpXS expression) {
      List<Variable> iterator;
      Variable result;
      OclExpression source, body;

      // collect iterator variables
      iterator = new ArrayList<Variable>(expression.getIterator().size());

      for (VariableXS iteratorXS : expression.getIterator()) {
        Variable iteratorVar = createVariable(iteratorXS, this, modelFactory);
        iterator.add(iteratorVar);

        // add the iterator variable temporarily to the list of variables
        // available to the parser
        variables.put(iteratorXS, iteratorVar);
      }

      // create the accumulator variable
      result = createVariable(expression.getResult(), this, modelFactory);
      variables.put(expression.getResult(), result);

      // parse source and body
      source = doSwitch(expression.getSource());
      body = doSwitch(expression.getBody());

      // remove iterator variables and result variable again
      for (VariableXS iteratorXS : expression.getIterator()) {
        variables.remove(iteratorXS);
      }

      variables.remove(expression.getResult());

      return modelFactory.createIterateExp(source, body, result, iterator
          .toArray(new Variable[iterator.size()]));
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseIteratorExpXS(tudresden.ocl20.pivot.xocl.IteratorExpXS)
     */
    @Override
    public OclExpression caseIteratorExpXS(IteratorExpXS expression) {
      List<Variable> iteratorVars = new ArrayList<Variable>(expression
          .getIterator().size());

      for (VariableXS variableXS : expression.getIterator()) {
        Variable iteratorVariable = createVariable(variableXS, this,
            modelFactory);
        iteratorVars.add(iteratorVariable);

        // add the iterator variable temporarily to the list of variables
        // available to the parser
        variables.put(variableXS, iteratorVariable);
      }

      // parse the source and body expression
      OclExpression source = doSwitch(expression.getSource());
      OclExpression body = doSwitch(expression.getBody());

      // remove the iterator variables again from the parser map
      for (VariableXS variableXS : expression.getIterator()) {
        variables.remove(variableXS);
      }

      return modelFactory.createIteratorExp(source, expression.getName()
          .toString(), body, iteratorVars.toArray(new Variable[iteratorVars
          .size()]));
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseInvalidLiteralExpXS(tudresden.ocl20.pivot.xocl.InvalidLiteralExpXS)
     */
    @Override
    @SuppressWarnings("unused")
    public OclExpression caseInvalidLiteralExpXS(InvalidLiteralExpXS expression) {
      return modelFactory.createInvalidLiteralExp();
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseUndefinedLiteralExpXS(tudresden.ocl20.pivot.xocl.UndefinedLiteralExpXS)
     */
    @Override
    @SuppressWarnings("unused")
    public OclExpression caseUndefinedLiteralExpXS(
        UndefinedLiteralExpXS expression) {
      return modelFactory.createUndefinedLiteralExp();
    }

    /*
     * (non-Javadoc)
     * 
     * @see tudresden.ocl20.pivot.xocl.util.XOCLSwitch#caseIfExpXS(tudresden.ocl20.pivot.xocl.IfExpXS)
     */
    @Override
    public OclExpression caseIfExpXS(IfExpXS expression) {
      return modelFactory.createIfExp(doSwitch(expression.getCondition()),
          doSwitch(expression.getThenExpression()), doSwitch(expression
              .getElseExpression()));
    }
  }

  /**
   * A runtime exception thrown by the various case methods. We cannot use the
   * checked {@link ParseException} here to keep the method signatures of the
   * XOCLSwitch class.
   */
  protected class ParseRuntimeException extends RuntimeException {

    // default serial version id
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new <code>ParseRuntimeException</code> with an error message
     * and a causing throwable.
     */
    public ParseRuntimeException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  /**
   * Implements parsing for XOCL files.
   */
  @Override
  public void doParse(URL url) throws ParseException {
    NamespaceXS declaredPackage;
    String declaredPackageName;
    Namespace targetNamespace;

    // get the top package and its name
    declaredPackage = getDeclaredPackage(loadResource(url));
    declaredPackageName = declaredPackage.getPathName();

    if (declaredPackageName == null) {
      logger.warn("The path name of the top package in the XOCL file '" + url //$NON-NLS-1$
          + "' is null; assuming the root package of the model."); //$NON-NLS-1$
      declaredPackageName = ""; //$NON-NLS-1$
    }

    // find the target namespace in the model
    targetNamespace = findTargetNamespace(declaredPackageName);

    // parse each constraint in the package
    for (ConstraintXS constraint : declaredPackage.getOwnedRule()) {
      if (logger.isInfoEnabled()) {
        logger.info(NLS.bind(ParserMessages.XOCLParser_ParsingConstraint,
            StringUtils.isNotEmpty(constraint.getName()) ? constraint.getName()
                : "unnamed")); //$NON-NLS-1$
      }

      // create the constraint and add it to the target namespace
      targetNamespace.addRule(createConstraint(constraint, declaredPackageName,
          getModelFactory()));
    }
  }

  /**
   * Helper method to load the XOCL resource from the given URL.
   */
  protected Resource loadResource(URL url) throws ParseException {
    if (logger.isDebugEnabled()) {
      logger.debug("loadResource(url=" + url + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    Resource resource;
    URI resourceURI;

    // try to create a URI
    try {
      resourceURI = URI.createURI(url.toString());
    }
    catch (IllegalArgumentException e) {
      logger.error("loadResource(url=" + url + ")", e); //$NON-NLS-1$ //$NON-NLS-2$
      throw new ParseException("Invalid URL: " + url, e); //$NON-NLS-1$
    }

    // get the resource
    resource = new ResourceSetImpl().createResource(resourceURI);

    // load the resource
    try {
      resource.load(null);
    }
    catch (IOException e) {
      logger.error("loadResource(url=" + url + ")", e); //$NON-NLS-1$ //$NON-NLS-2$
      throw new ParseException(
          "Failed loading resource '" + resourceURI + "'.", e); //$NON-NLS-1$ //$NON-NLS-2$
    }

    if (logger.isDebugEnabled()) {
      logger.debug("loadResource() - exit - return value=" + resource); //$NON-NLS-1$
    }

    return resource;
  }

  /**
   * Helper method to return the containing namespace in the XOCL model which
   * represents the <code>package</code> statement in OCL.
   */
  protected NamespaceXS getDeclaredPackage(Resource resource)
      throws ParseException {
    if (logger.isDebugEnabled()) {
      logger.debug("getDeclaredPackage(resource=" + resource + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    NamespaceXS declaredPackage;

    // check that we have exactly one root
    if (resource.getContents().size() != 1) {
      throw new ParseException(
          "Failed to parse '" + resource.getURI() //$NON-NLS-1$
              + "'. Exactly one NamespaceXS root representing the OCL package statement is required."); //$NON-NLS-1$
    }

    EObject root = resource.getContents().get(0);

    if (!(root instanceof NamespaceXS)) {
      throw new ParseException(
          "The root of '" + resource.getURI() + "' is not a NamespaceXS."); //$NON-NLS-1$ //$NON-NLS-2$
    }

    declaredPackage = (NamespaceXS) root;

    if (logger.isDebugEnabled()) {
      logger.debug("getDeclaredPackage() - exit - return value=" //$NON-NLS-1$
          + declaredPackage);
    }

    return declaredPackage;
  }

  /**
   * Helper method to find the namespace in the model where the constraints
   * should go to.
   */
  protected Namespace findTargetNamespace(String pathName)
      throws ParseException {
    if (logger.isDebugEnabled()) {
      logger.debug("findTargetNamespace(pathName=" + pathName + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    Namespace targetNamespace;

    try {
      targetNamespace = getModel().findNamespace(tokenizePathName(pathName));
    }

    catch (ModelAccessException e) {
      logger.error("findTargetNamespace(pathName=" + pathName + ")", e); //$NON-NLS-1$ //$NON-NLS-2$
      throw new ParseException(
          "Error while looking up namespace '" + pathName + "' in model '" //$NON-NLS-1$ //$NON-NLS-2$
              + getModel().getDisplayName() + "'."); //$NON-NLS-1$
    }

    if (logger.isDebugEnabled()) {
      logger.debug("findTargetNamespace() - exit - return value=" //$NON-NLS-1$
          + targetNamespace);
    }

    return targetNamespace;
  }

  /**
   * Creates a {@link Constraint} from a {@link ConstraintXS} within the scope
   * of the given package. All references to types and features will be
   * considered relative to the given package.
   */
  protected Constraint createConstraint(ConstraintXS constraintXS,
      String packageName, IModelFactory modelFactory) throws ParseException {

    if (logger.isDebugEnabled()) {
      logger.debug("createConstraint(constraintXS=" + constraintXS //$NON-NLS-1$
          + ", packageName=" + packageName + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    Constraint constraint;
    ConstraintKind constraintKind;
    Expression specification;
    ConstrainableElement constrainedElement;

    try {
      // translate the constraint kind into the abstract syntax
      constraintKind = translateConstraintKind(constraintXS.getKind());

      // find the constrained element
      constrainedElement = findConstrainedElement(packageName, constraintXS
          .getConstrainedElement(), constraintKind, getTypeResolver());

      // create the specification expression
      specification = createExpressionInOcl(constraintXS.getSpecification(),
          modelFactory);

      // create the constraint
      constraint = modelFactory.createConstraint(constraintXS.getName(),
          constraintKind, specification, constrainedElement);
    }

    catch (Exception e) {
      logger.error("createConstraint(constraintXS=" + constraintXS //$NON-NLS-1$
          + ", packageName=" + packageName + ")", e); //$NON-NLS-1$ //$NON-NLS-2$
      throw new ParseException(
          "Error in constraint '" + constraintXS.getName() + "': " //$NON-NLS-1$//$NON-NLS-2$
              + e.getMessage(), e);
    }

    if (logger.isDebugEnabled()) {
      logger.debug("createConstraint() - exit - return value=" + constraint); //$NON-NLS-1$
    }

    return constraint;
  }

  /**
   * Helper method that translates a {@link ConstraintKindXS} into the
   * corresponding {@link ConstraintKind}.
   */
  protected ConstraintKind translateConstraintKind(
      ConstraintKindXS constraintKindXS) {
    if (logger.isDebugEnabled()) {
      logger.debug("translateConstraintKind(constraintKindXS=" //$NON-NLS-1$
          + constraintKindXS + ") - enter"); //$NON-NLS-1$
    }

    ConstraintKind constraintKind;

    if (constraintKindXS == null) {
      throw new IllegalArgumentException(
          "The constraint kind must not be null."); //$NON-NLS-1$
    }

    switch (constraintKindXS) {
      case BODY:
        constraintKind = ConstraintKind.BODY;
        break;
      case DEFINITION:
        constraintKind = ConstraintKind.DEFINITION;
        break;
      case DERIVEDVALUE:
        constraintKind = ConstraintKind.DERIVED;
        break;
      case INITIALVALUE:
        constraintKind = ConstraintKind.INITIAL;
        break;
      case INVARIANT:
        constraintKind = ConstraintKind.INVARIANT;
        break;
      case PRECONDITION:
        constraintKind = ConstraintKind.PRECONDITION;
        break;
      case POSTCONDITION:
        constraintKind = ConstraintKind.POSTCONDITION;
        break;
      default:
        throw new IllegalArgumentException(
            "Unknown constraint kind: " + constraintKindXS); //$NON-NLS-1$
    }

    if (logger.isDebugEnabled()) {
      logger.debug("translateConstraintKind() - exit - return value=" //$NON-NLS-1$
          + constraintKind);
    }

    return constraintKind;
  }

  /**
   * Helper method to look for a {@link ConstrainableElement} in the getModel().
   */
  protected ConstrainableElement findConstrainedElement(String packageName,
      String constrainedElementName, ConstraintKind constraintKind,
      ITypeResolver typeResolver) {

    if (logger.isDebugEnabled()) {
      logger.debug("findConstrainedElement(packageName=" + packageName //$NON-NLS-1$
          + ", constrainedElementName=" + constrainedElementName //$NON-NLS-1$
          + ", constraintKind=" + constraintKind + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    ConstrainableElement element = null;

    // split the name of the constrained element into its path segments,
    // construct a new list because tokenizePathName returns an immutable list
    List<String> pathName = new LinkedList<String>(
        tokenizePathName(constrainedElementName));

    // check if a valid path was found
    if (pathName.size() == 0) {
      throw new IllegalArgumentException(
          "The path name '" + constrainedElementName + "'is invalid."); //$NON-NLS-1$ //$NON-NLS-2$
    }

    // prepend the package name
    pathName.add(0, packageName);

    // depending on the constraint kind, look for different types of
    // constrainable elements
    switch (constraintKind) {
      case INVARIANT:
      case DEFINITION:
        element = findType(pathName, typeResolver);
        break;

      case DERIVED:
      case INITIAL:
        element = findProperty(pathName, typeResolver);
        break;

      case BODY:
      case PRECONDITION:
      case POSTCONDITION:
        element = findOperation(pathName, typeResolver);
        break;
    }

    // check that an element was found
    if (element == null) {
      throw new IllegalArgumentException(
          "Failed to locate the constrained element '" //$NON-NLS-1$
              + constrainedElementName
              + "' in model '" + getModel().getDisplayName() + "'."); //$NON-NLS-1$ //$NON-NLS-2$
    }

    if (logger.isDebugEnabled()) {
      logger.debug("findConstrainedElement() - exit - return value=" + element); //$NON-NLS-1$
    }

    return element;
  }

  /**
   * Helper method to find a type in the associated getModel().
   */
  protected Type findType(List<String> pathName, ITypeResolver typeResolver) {
    Type type;

    try {
      type = typeResolver.findType(pathName);
    }

    catch (ModelAccessException e) {
      logger.error("findType(pathName=" + pathName + ")", e); //$NON-NLS-1$//$NON-NLS-2$
      throw new ParseRuntimeException("An error occured when accessing model '" //$NON-NLS-1$
          + getModel().getDisplayName() + "'.", e); //$NON-NLS-1$
    }

    catch (TypeNotFoundException e) {
      logger.error("findType(pathName=" + pathName + ")", e); //$NON-NLS-1$ //$NON-NLS-2$
      throw new ParseRuntimeException(
          "Failed to lookup type " + pathName + ".", e); //$NON-NLS-1$//$NON-NLS-2$
    }

    return type;
  }

  /**
   * Helper method to find a property in the associated getModel().
   */
  protected Property findProperty(List<String> pathName,
      ITypeResolver typeResolver) {
    if (logger.isDebugEnabled()) {
      logger.debug("findProperty(pathName=" + pathName + ") - enter"); //$NON-NLS-1$ //$NON-NLS-2$
    }

    Type contextualType;
    Property property;

    // find the contextual type
    contextualType = findContextualType(pathName, typeResolver);

    // split off the type of the property if existent
    String propertyName = pathName.get(pathName.size() - 1);
    int typeSeparatorIndex = propertyName.indexOf(':');

    if (typeSeparatorIndex > 0) {
      propertyName = propertyName.substring(0, typeSeparatorIndex);
    }

    // lookup the property
    property = contextualType.lookupProperty(propertyName);

    // TODO: theoretically, we should check whether the declared type equals the
    // actual type but in this prototypical parser, we do without it

    if (logger.isDebugEnabled()) {
      logger.debug("findProperty() - exit - return value=" + property); //$NON-NLS-1$
    }

    return property;
  }

  /**
   * Helper method to find an operation in the associated model.
   */
  protected Operation findOperation(List<String> pathName,
      ITypeResolver typeResolver) {
    Type contextualType;
    Operation operation = null;

    // find the contextual type
    contextualType = findContextualType(pathName, typeResolver);

    // instantiate a regular expression to match operations and extract their
    // names and parameters (for more information on this pattern, see
    // ExpressionInOclXSImpl.getOperationPattern)
    Pattern operationPattern = Pattern
        .compile("(\\w+)(\\(\\s*(?:(?:\\w+\\s*:\\s*\\w+,\\s*)*\\w+\\s*:\\s*\\w+)?\\s*\\))\\s*(?::\\s*(\\w+))?"); //$NON-NLS-1$
    Matcher matcher = operationPattern.matcher(pathName
        .get(pathName.size() - 1));

    // if the syntax of the operation signature is valid, extract relevant parts
    if (matcher.matches()) {
      String operationName;
      String[] parametersArray;
      List<Type> parameterTypes;

      // the operation name is in the first capture group
      operationName = matcher.group(1);

      // the parameters are in the second capture group
      String parameters = matcher.group(2);

      // trim leading and trailing parenthesis
      parameters = parameters.substring(1, parameters.length() - 1);

      // tokenize around the commas to get the parameter names and types
      if (parameters == StringUtils.EMPTY) {
        parametersArray = ArrayUtils.EMPTY_STRING_ARRAY;
      }

      else {
        parametersArray = parameters.split("\\s*,\\s*"); //$NON-NLS-1$
      }

      // collect the parameter types
      for (int i = 0; i < parametersArray.length; i++) {
        parametersArray[i] = parametersArray[i].substring(parametersArray[i]
            .indexOf(':') + 1);
      }

      // find the parameter types
      parameterTypes = new ArrayList<Type>(parametersArray.length);

      for (String typeName : parametersArray) {
        parameterTypes.add(findType(tokenizePathName(typeName), typeResolver));
      }

      // lookup the operation
      operation = contextualType.lookupOperation(operationName, parameterTypes);
    }

    return operation;
  }

  /**
   * Helper method to find the contextual type of an operation or property
   * constraint.
   */
  private Type findContextualType(List<String> pathName,
      ITypeResolver typeResolver) {
    Type contextualType;

    // lookup the type
    contextualType = findType(pathName.subList(0, pathName.size() - 1),
        typeResolver);

    if (contextualType == null) {
      throw new IllegalArgumentException(
          "Unable to find the contextual type for constrained element " + pathName); //$NON-NLS-1$
    }

    return contextualType;
  }

  /**
   * Helper method to create an {@link ExpressionInOcl} from an
   * {@link ExpressionInOclXS}.
   */
  protected ExpressionInOcl createExpressionInOcl(
      ExpressionInOclXS expressionInOclXS, IModelFactory modelFactory) {
    if (logger.isDebugEnabled()) {
      logger.debug("createExpressionInOcl(expressionInOclXS=" //$NON-NLS-1$
          + expressionInOclXS + ") - enter"); //$NON-NLS-1$
    }

    ExpressionInOcl expressionInOcl;
    Map<VariableXS, Variable> variables;
    ModelSwitch modelSwitch;
    VariableXS contextVariableXS, resultVariableXS;
    Variable contextVariable, resultVariable = null;
    List<Variable> parameterVariables;

    // precondition check
    if (expressionInOclXS == null) {
      throw new IllegalArgumentException(
          "The parameter 'expressionInOclCS' must not be null."); //$NON-NLS-1$
    }

    // create a new map to cache variables
    variables = new HashMap<VariableXS, Variable>();

    // create a new model switch
    modelSwitch = new ModelSwitch(variables, modelFactory);

    // create the various variables of the expression in OCL and cache them
    contextVariableXS = expressionInOclXS.getContext();

    if (contextVariableXS == null) {
      throw new IllegalArgumentException(
          "No context variable defined for ExpressionInOclXS '" //$NON-NLS-1$
              + expressionInOclXS.getBody() + "'."); //$NON-NLS-1$
    }

    contextVariable = createVariable(expressionInOclXS.getContext(),
        modelSwitch, modelFactory);
    variables.put(contextVariableXS, contextVariable);

    resultVariableXS = expressionInOclXS.getResult();

    if (resultVariableXS != null) {
      resultVariable = createVariable(resultVariableXS, modelSwitch,
          modelFactory);
      variables.put(resultVariableXS, resultVariable);
    }

    parameterVariables = new ArrayList<Variable>(expressionInOclXS
        .getParameter().size());

    for (VariableXS parameterVariableXS : expressionInOclXS.getParameter()) {
      Variable parameterVariable = createVariable(parameterVariableXS,
          modelSwitch, modelFactory);
      parameterVariables.add(parameterVariable);
      variables.put(parameterVariableXS, parameterVariable);
    }

    // finally create the ExpressionInOcl
    expressionInOcl = modelFactory.createExpressionInOcl(expressionInOclXS
        .getBody(),
        modelSwitch.doSwitch(expressionInOclXS.getBodyExpression()),
        contextVariable, resultVariable, parameterVariables
            .toArray(new Variable[parameterVariables.size()]));

    if (logger.isDebugEnabled()) {
      logger.debug("createExpressionInOcl() - exit - return value=" //$NON-NLS-1$
          + expressionInOcl);
    }

    return expressionInOcl;
  }

  /**
   * Creates a {@link Variable} from a {@link VariableXS}.
   */
  @SuppressWarnings("unchecked")
  protected Variable createVariable(VariableXS variableXS,
      ModelSwitch modelSwitch, IModelFactory modelFactory) {
    if (logger.isDebugEnabled()) {
      logger.debug("createVariable(variableXS=" + variableXS + ", modelSwitch=" //$NON-NLS-1$ //$NON-NLS-2$
          + modelSwitch + ") - enter"); //$NON-NLS-1$
    }

    Variable variable;
    OclExpression initExpression = null;
    List<String> typePath = null;
    List<String> typeArgumentPath = null;

    // parse the init expression if existing
    if (variableXS.getInitExpression() != null) {
      initExpression = modelSwitch.doSwitch(variableXS.getInitExpression());
    }

    // check whether the type name contains type arguments
    Matcher matcher = Pattern.compile("(\\w+)\\((\\w+)\\)").matcher( //$NON-NLS-1$
        variableXS.getType());

    if (matcher.matches()) {
      typePath = tokenizePathName(matcher.group(1));
      typeArgumentPath = tokenizePathName(matcher.group(2));
    }

    // create the variable using the model factory
    try {

      // create a variable with type arguments
      if (typeArgumentPath != null) {
        variable = modelFactory.createVariable(variableXS.getName(), typePath,
            Arrays.asList(typeArgumentPath), initExpression);
      }

      // create an non-generic variable
      else {
        variable = modelFactory.createVariable(variableXS.getName(),
            tokenizePathName(variableXS.getType()), initExpression);
      }
    }

    catch (FactoryException e) {
      throw new ParseRuntimeException(
          "Failed to create variable '" + variableXS.getName() + "'.", e); //$NON-NLS-1$ //$NON-NLS-2$

    }

    if (logger.isDebugEnabled()) {
      logger.debug("createVariable() - exit - return value=" + variable); //$NON-NLS-1$
    }

    return variable;
  }

  /**
   * Helper method to split a path name separated by <code>::</code> into a
   * list of strings. Note that the returned list is <strong>immutable</strong>.
   * 
   * @param pathName a path name
   * 
   * @return a list of path segments
   */
  @SuppressWarnings("unchecked")
  protected List<String> tokenizePathName(String pathName) {

    // return an empty list if the path name is empty
    if (StringUtils.isEmpty(pathName)) {
      throw new ParseRuntimeException(
          "Encountered an empty path name for a type", null); //$NON-NLS-1$
    }

    return Arrays.asList(pathName.split("::")); //$NON-NLS-1$
  }

}

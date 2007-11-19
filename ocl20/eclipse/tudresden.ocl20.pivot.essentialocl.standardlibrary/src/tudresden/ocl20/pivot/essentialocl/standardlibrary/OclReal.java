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
package tudresden.ocl20.pivot.essentialocl.standardlibrary;

/**
 * 
 * 
 * @author Matthias Braeuer
 * @version 1.0 30.03.2007
 */
public interface OclReal extends OclAny, OclComparable {

	/**
	 * 
	 * @param r
	 * @return the value of the addition of <code>this</code> and
	 *         <code>r</code>.
	 */
	OclReal add(OclReal r);

	/**
	 * 
	 * @param r
	 * @return the value of the subtraction of <code>r</code> from
	 *         <code>this</code>.
	 */
	OclReal subtract(OclReal r);

	/**
	 * 
	 * @param r
	 * @return the value of the multiplication of <code>this</code> and
	 *         <code>r</code>.
	 */
	OclReal multiply(OclReal r);

	/**
	 * 
	 * @return the negative value of <code>this</code>.
	 */
	OclReal negative();

	/**
	 * 
	 * @param r
	 * @return the value of <code>this</code> divided by <code>r</code>.
	 *         Evaluates to {@link OclInvalid} if <code>r</code> is equal to
	 *         zero.
	 */
	OclReal divide(OclReal r);

	/**
	 * 
	 * @return the absolute value of <code>this</code>.
	 */
	OclReal abs();

	/**
	 * 
	 * @return the largest {@link OclInteger} that is less than or equal to
	 *         <code>this</code>.
	 */
	OclInteger floor();

	/**
	 * 
	 * @return the {@link OclInteger} that is closest to <code>this</code>.
	 *         When there are two such {@link OclInteger}, the largest one.
	 */
	OclInteger round();

	/**
	 * 
	 * @param r
	 * @return the maximum of <code>this</code> and <code>r</code>.
	 */
	OclReal max(OclReal r);

	/**
	 * 
	 * @param r
	 * @return the minimum of <code>this</code> and <code>r</code>.
	 */
	OclReal min(OclReal r);

	/**
	 * 
	 * @param r
	 * @return true if <code>this</code> is less than <code>r</code>.
	 */
	OclBoolean isLessThan(OclReal r);

	/**
	 * 
	 * @param r
	 * @return true if <code>this</code> is greater than <code>r</code>.
	 */
	OclBoolean isGreaterThan(OclReal r);

	/**
	 * 
	 * @param r
	 * @return true if <code>this</code> is less than or equal to
	 *         <code>r</code>.
	 */
	OclBoolean isLessEqual(OclReal r);

	/**
	 * 
	 * @param r
	 * @return true if <code>this</code> is greater than or equal to
	 *         <code>r</code>.
	 */
	OclBoolean isGreaterEqual(OclReal r);
}

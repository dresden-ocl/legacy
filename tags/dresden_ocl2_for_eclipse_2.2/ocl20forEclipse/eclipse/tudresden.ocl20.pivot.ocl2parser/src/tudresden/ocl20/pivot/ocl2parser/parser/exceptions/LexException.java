/*
    Copyright (C) 2008  Nils (s0006383@inf.tu-dresden.de)

    This file is part of the OCL parser of the Dresden OCL2 for Eclipse.

    The OCL parser is free software: you can redistribute it and/or modify
    it under the terms of the GNU Lesser General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    The OCL parser is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU Lesser General Public License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with the OCL parser.  If not, see <http://www.gnu.org/licenses/>.
.
 */

package tudresden.ocl20.pivot.ocl2parser.parser.exceptions;

import tudresden.ocl20.pivot.parser.ParseException;

/**
 * <p>
 * Represents {@link Exception}s that occur during lexing an OCL file.
 * </p>
 * 
 * @author Nils Thieme
 * @author Claas Wilke (refactoring and documentation)
 */
public class LexException extends ParseException {

	/** Generated ID for serialization. */
	private static final long serialVersionUID = 8655563804831189426L;

	/**
	 * <p>
	 * Creates a new {@link Ocl2ParsingException}.
	 * </p>
	 * 
	 * @param msg
	 *            The message of this {@link Exception}.
	 */
	public LexException(String message) {
		super(message);
	}

	/**
	 * <p>
	 * Creates a new {@link Ocl2ParsingException}.
	 * </p>
	 * 
	 * @param msg
	 *            The message of this {@link Exception}.
	 * @param cause
	 *            The cause of this {@link Exception}.
	 */
	public LexException(String message, Throwable cause) {
		super(message, cause);
	}
}
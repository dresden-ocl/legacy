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


package tudresden.ocl20.pivot.ocl2parser.internal;

import java.util.List;

import tudresden.ocl20.pivot.essentialocl.expressions.Variable;
import tudresden.ocl20.pivot.pivotmodel.Type;

public class OperationSignatureContainer {
	protected List<Variable> parameterList;
	protected Type resultType;
	
	public OperationSignatureContainer(List<Variable> variableList, Type result) {
		parameterList = variableList;
		resultType = result;
	}

	public List<Variable> getParameterList() {
		return parameterList;
	}

	public void setParameterList(List<Variable> parameterList) {
		this.parameterList = parameterList;
	}

	public Type getResultType() {
		return resultType;
	}

	public void setResultType(Type resultType) {
		this.resultType = resultType;
	}
	
	
}
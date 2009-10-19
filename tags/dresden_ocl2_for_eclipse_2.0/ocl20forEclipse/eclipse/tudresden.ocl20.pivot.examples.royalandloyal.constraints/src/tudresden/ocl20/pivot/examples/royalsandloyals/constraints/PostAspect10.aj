package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect PostAspect10 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Transaction#getProgram()}.</p>
     */
    protected pointcut getProgramCaller(tudresden.ocl20.pivot.examples.royalsandloyals.Transaction aClass):
    	call(* tudresden.ocl20.pivot.examples.royalsandloyals.Transaction.getProgram())
    	&& target(aClass);
    
    /**
     * <p>Checks a postcondition for the getProgram() defined by the constraint
     * <code>context Transaction::getProgram() : tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram
     *       post: self[].oclIsTypeOf( Transaction[])</code></p>
     */
    tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram around(tudresden.ocl20.pivot.examples.royalsandloyals.Transaction aClass): getProgramCaller(aClass) {
        /* Disable this constraint for subclasses of Transaction. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Transaction")) {
    
        tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram result;
        result = proceed(aClass);
    
        if (!aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Transaction")) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
    
        return result;
        }
    
        else {
            return proceed(aClass);
        }
    }
}
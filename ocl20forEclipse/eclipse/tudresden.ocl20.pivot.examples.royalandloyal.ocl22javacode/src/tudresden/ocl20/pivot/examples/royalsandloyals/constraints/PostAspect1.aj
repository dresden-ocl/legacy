package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect PostAspect1 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram#enroll(tudresden.ocl20.pivot.examples.royalsandloyals.Customer c)}.</p>
     */
    protected pointcut enrollCaller(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass, tudresden.ocl20.pivot.examples.royalsandloyals.Customer c):
    	call(* tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram.enroll(tudresden.ocl20.pivot.examples.royalsandloyals.Customer))
    	&& target(aClass) && args(c);
    
    /**
     * <p>Checks a postcondition for the enroll(, tudresden.ocl20.pivot.examples.royalsandloyals.Customer c) defined by the constraint
     * <code>context LoyaltyProgram::enroll(c: tudresden.ocl20.pivot.examples.royalsandloyals.Customer) : Boolean
     *       post: participants[].=( participants[]@pre.including( c[]))</code></p>
     */
    Boolean around(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass, tudresden.ocl20.pivot.examples.royalsandloyals.Customer c): enrollCaller(aClass, c) {
        /* Disable this constraint for subclasses of LoyaltyProgram. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram")) {
    
        tudresden.ocl20.pivot.ocl2java.types.OclSet<tudresden.ocl20.pivot.examples.royalsandloyals.Customer> atPreValue1;
        
        if ((Object) aClass.participants == null) {
            atPreValue1 = null;
        } else {
            atPreValue1 = new tudresden.ocl20.pivot.ocl2java.types.OclSet<tudresden.ocl20.pivot.examples.royalsandloyals.Customer>(aClass.participants);
        }
    
        Boolean result;
        result = proceed(aClass, c);
    
        if (!aClass.participants.equals(atPreValue1.including(c))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
    
        return result;
        }
    
        else {
            return proceed(aClass, c);
        }
    }
}
package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect PreAspect6 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Date#now()}.</p>
     */
    protected pointcut nowCaller():
    	execution(* tudresden.ocl20.pivot.examples.royalsandloyals.Date.now());
    
    /**
     * <p>Checks a precondition for the {@link Date#now()} defined by the constraint
     * <code>context Date::now() : tudresden.ocl20.pivot.examples.royalsandloyals.Date
     *       pre: true</code></p>
     */
    before(): nowCaller() {
        if (!new Boolean(true)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
    }
}
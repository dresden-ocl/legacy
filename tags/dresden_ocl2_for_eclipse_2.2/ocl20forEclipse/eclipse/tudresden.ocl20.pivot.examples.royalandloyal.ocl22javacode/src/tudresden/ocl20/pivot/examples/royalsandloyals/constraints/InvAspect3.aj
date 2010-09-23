package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect InvAspect3 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedLoyaltyProgram;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class LoyaltyProgram defined by the constraint
     * <code>context LoyaltyProgram
     *       inv: levels[].includes( membership[].currentLevel[])</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of LoyaltyProgram. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram")) {
        if (!tudresden.ocl20.pivot.ocl22java.types.util.OclCollections.includes(aClass.levels, aClass.membership.currentLevel)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
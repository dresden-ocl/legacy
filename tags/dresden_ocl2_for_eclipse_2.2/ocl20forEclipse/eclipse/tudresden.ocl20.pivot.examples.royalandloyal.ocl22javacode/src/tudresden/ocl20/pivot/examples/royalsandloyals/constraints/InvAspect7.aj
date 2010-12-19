package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect InvAspect7 {

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
     *       inv: partners[].deliveredServices[] -> forAll (  | pointsEarned[].=( 0).and( pointsBurned[].=( 0))).implies( membership[].accounts[].isEmpty())</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of LoyaltyProgram. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram")) {
        java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.Service> result2;
        result2 = new java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.Service>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner anElement2 : aClass.partners) {
            result2.addAll(anElement2.deliveredServices);
        }
        Boolean result1;
        result1 = true;
        
        /* Iterator ForAll: Iterate and check, if all elements fulfill the condition. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Service anElement1 : result2) {
            if (!(((Object) anElement1.pointsEarned).equals(new Integer(0)) && ((Object) anElement1.pointsBurned).equals(new Integer(0)))) {
                result1 = false;
                break;
            }
            // no else
        }
    
        if (!(!result1 || tudresden.ocl20.pivot.ocl22java.types.util.OclCollections.isEmpty(aClass.membership.accounts))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
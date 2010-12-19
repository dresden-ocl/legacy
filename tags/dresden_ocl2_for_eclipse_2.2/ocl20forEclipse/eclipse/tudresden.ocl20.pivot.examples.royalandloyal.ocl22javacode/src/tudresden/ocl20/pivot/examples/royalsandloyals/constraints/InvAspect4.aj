package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect InvAspect4 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.Membership extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedMembership;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Membership#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.Membership aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.Membership.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class Membership defined by the constraint
     * <code>context Membership
     *       inv: program[].participants[].cards[].flatten().includes( self[].card[])</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.Membership aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of Membership. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Membership")) {
        java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard> result1;
        result1 = new java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Customer anElement1 : aClass.program.participants) {
            result1.addAll(anElement1.cards);
        }
    
        if (!tudresden.ocl20.pivot.ocl22java.types.util.OclCollections.includes((java.util.List<tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard>) tudresden.ocl20.pivot.ocl22java.types.util.OclBags.flatten(result1), aClass.card)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
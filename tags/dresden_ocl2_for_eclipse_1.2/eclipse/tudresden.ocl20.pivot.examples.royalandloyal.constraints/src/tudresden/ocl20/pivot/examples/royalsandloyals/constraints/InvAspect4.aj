package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
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
     *       inv: program[].participants[].cards[].includes( self[].card[])</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.Membership aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of Membership. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Membership")) {
        tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard> result1;
        result1 = new tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Customer anElement1 : aClass.program.participants) {
            result1.addAll(anElement1.cards);
        }
    
        if (!result1.contains(aClass.card)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
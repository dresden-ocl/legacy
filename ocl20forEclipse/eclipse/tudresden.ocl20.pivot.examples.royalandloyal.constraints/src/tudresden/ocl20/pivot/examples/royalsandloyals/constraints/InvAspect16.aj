package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect InvAspect16 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.Burning extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedBurning;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Burning#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.Burning aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.Burning.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class Burning defined by the constraint
     * <code>context Burning
     *       inv: self[].points[].=( self[].oclAsType( Transaction[]).points[])</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.Burning aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of Burning. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Burning")) {
        if (!((Object) aClass.points).equals(((tudresden.ocl20.pivot.examples.royalsandloyals.Transaction) aClass).points)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect InvAspect11 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedProgramPartner;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aClass):
    	call(void tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner.checkInvariants())
    	&& target(aClass);
    
    /**
     * <p><code>Checks an invariant on the class ProgramPartner defined by the constraint
     * <code>context ProgramPartner
     *       inv: deliveredServices[].transaction[] -> select (  | oclIsTypeOf( Earning[])).points[].sum().<( 10000)</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of ProgramPartner. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner")) {
        tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction> result3;
        result3 = new tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Service anElement3 : aClass.deliveredServices) {
            result3.add(anElement3.transaction);
        }
        tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction> result2;
        result2 = new tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction>();
        
        /* Iterator Select: Select all elements which fulfill the condition. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Transaction anElement2 : result3) {
            if (anElement2.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Earning")) {
                result2.add(anElement2);
            }
            // no else
        }
        tudresden.ocl20.pivot.ocl2java.types.OclBag<Integer> result1;
        result1 = new tudresden.ocl20.pivot.ocl2java.types.OclBag<Integer>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Transaction anElement1 : result2) {
            result1.add(anElement1.points);
        }

        Integer result4;
        result4 = new Integer(0);
        
        /* Compute the result of a sum operation. */
        for (Integer anElement4 : result1) {
            result4 += anElement4;
        }
    
        if (!(result4 < new Integer(10000))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect InvAspect10 {

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
     *       inv: deliveredServices[].transaction[].points[].sum().<( 10000)</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of ProgramPartner. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner")) {
        java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction> result2;
        result2 = new java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Service anElement2 : aClass.deliveredServices) {
            result2.add(anElement2.transaction);
        }
        java.util.ArrayList<Integer> result1;
        result1 = new java.util.ArrayList<Integer>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Transaction anElement1 : result2) {
            result1.add(anElement1.points);
        }
    
        if (!(new Integer(tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclCollections.sum(result1).intValue()) < new Integer(10000))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
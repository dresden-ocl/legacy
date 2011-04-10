package org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect LoyaltyProgram_InvAspect_minServices {

    /**
     * <p>Pointcut for all calls on {@link org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass):
    	call(void checkInvariants())
    	&& target(aClass);

    /**
     * <p><code>Checks an invariant on the class LoyaltyProgram defined by the constraint
     * <code>context LoyaltyProgram
     *       inv minServices: partners->forAll(deliveredServices->size() >= 1)</code></p>
     */
    after(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of LoyaltyProgram. */
        if (aClass.getClass().getCanonicalName().equals("org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram")) {
        Boolean result1;
        result1 = true;

        /* Iterator ForAll: Iterate and check, if all elements fulfill the condition. */
        for (org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner anElement1 : aClass.partners) {
            if (!(tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclCollections.size(anElement1.deliveredServices) >= new Integer(1))) {
                result1 = false;
                break;
            }
            // no else
        }

        if (!result1) {
        	// TODO Auto-generated code executed when constraint is violated.
        	String msg = "Error: Constraint 'minServices' (inv minServices: partners->forAll(deliveredServices->size() >= 1)) was violated for Object " + aClass.toString() + ".";
        	throw new RuntimeException(msg);
        }
        // no else.
        }
        // no else.
    }
}
package org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect ProgramPartner_InvAspect_nrOfParticipants {

    declare parents: org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner implements tudresden.ocl20.pivot.tools.codegen.ocl2java.types.OclCheckable;

    public void org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner.checkInvariants() {
        /* Remains empty. Is only filled with behavior by advice(s). */
    }
    /**
     * <p>Pointcut for all calls on {@link org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aClass):
    	call(void checkInvariants())
    	&& target(aClass);

    /**
     * <p><code>Checks an invariant on the class ProgramPartner defined by the constraint
     * <code>context ProgramPartner
     *       inv nrOfParticipants: numberOfCustomers = programs.participants->size()</code></p>
     */
    after(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of ProgramPartner. */
        if (aClass.getClass().getCanonicalName().equals("org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner")) {
        java.util.ArrayList<org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Customer> result1;
        result1 = new java.util.ArrayList<org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Customer>();

        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram anElement1 : aClass.programs) {
            result1.addAll(anElement1.participants);
        }

        if (!((Object) aClass.numberOfCustomers).equals(tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclCollections.size(result1))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	String msg = "Error: Constraint 'nrOfParticipants' (inv nrOfParticipants: numberOfCustomers = programs.participants->size()) was violated for Object " + aClass.toString() + ".";
        	throw new RuntimeException(msg);
        }
        // no else.
        }
        // no else.
    }
}
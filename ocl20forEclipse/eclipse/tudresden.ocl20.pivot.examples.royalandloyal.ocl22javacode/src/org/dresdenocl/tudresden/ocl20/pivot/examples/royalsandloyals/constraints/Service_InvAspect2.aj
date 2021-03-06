package org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Service_InvAspect2 {

    declare parents: org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Service implements tudresden.ocl20.pivot.tools.codegen.ocl2java.types.OclCheckable;

    public void org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Service.checkInvariants() {
        /* Remains empty. Is only filled with behavior by advice(s). */
    }
    /**
     * <p>Pointcut for all calls on {@link org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Service#checkInvariants()}.</p>
     */
    protected pointcut checkInvariantsCaller(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Service aClass):
    	call(void checkInvariants())
    	&& target(aClass);

    /**
     * <p><code>Checks an invariant on the class Service defined by the constraint
     * <code>context Service
     *       inv: self.oclIsUndefined() = false</code></p>
     */
    after(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Service aClass) : checkInvariantsCaller(aClass) {
        /* Disable this constraint for subclasses of Service. */
        if (aClass.getClass().getCanonicalName().equals("org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Service")) {
        if (!((Object) (aClass == null)).equals(new Boolean(false))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	String msg = "Error: Constraint 'undefined' (inv: self.oclIsUndefined() = false) was violated for Object " + aClass.toString() + ".";
        	throw new RuntimeException(msg);
        }
        // no else.
        }
        // no else.
    }
}
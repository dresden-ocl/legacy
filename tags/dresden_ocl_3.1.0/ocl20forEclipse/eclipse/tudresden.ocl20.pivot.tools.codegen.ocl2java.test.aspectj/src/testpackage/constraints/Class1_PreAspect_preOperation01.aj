package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_PreAspect_preOperation01 {

    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#preOperation01(Integer anInt)}.</p>
     */
    protected pointcut preOperation01Caller(testpackage.Class1 aClass, Integer anInt):
    	call(* testpackage.Class1.preOperation01(Integer))
    	&& target(aClass) && args(anInt);
    
    /**
     * <p>Checks a precondition for the {@link Class1#preOperation01(, Integer anInt)} defined by the constraint
     * <code>context Class1::preOperation01(anInt: Integer) : Integer
     *       pre testPre01: not anInt.oclIsUndefined()</code></p>
     */
    before(testpackage.Class1 aClass, Integer anInt): preOperation01Caller(aClass, anInt) {
        /* Disable this constraint for subclasses of Class1. */
        if (aClass.getClass().getCanonicalName().equals("testpackage.Class1")) {
        if (!!(((Integer) anInt) == null)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	String msg = "Error: Constraint 'testPre01' (pre testPre01: not anInt.oclIsUndefined()) was violated for Object " + aClass.toString() + ".";
        	throw new RuntimeException(msg);
        }
        // no else.
        }
        // no else.
    }
}
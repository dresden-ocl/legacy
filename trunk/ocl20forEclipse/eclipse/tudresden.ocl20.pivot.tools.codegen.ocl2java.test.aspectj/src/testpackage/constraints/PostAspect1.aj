package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect PostAspect1 {

    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#postOperation01(Integer in1)}.</p>
     */
    protected pointcut postOperation01Caller(testpackage.Class1 aClass, Integer in1):
    	call(* testpackage.Class1.postOperation01(Integer))
    	&& target(aClass) && args(in1);
    
    /**
     * <p>Checks a postcondition for the operation {@link Class1#postOperation01(, Integer in1)} defined by the constraint
     * <code>context Class1::postOperation01(in1: Integer) : Integer
     *       post: result = anInt * 2</code></p>
     */
    Integer around(testpackage.Class1 aClass, Integer in1): postOperation01Caller(aClass, in1) {
        /* Disable this constraint for subclasses of Class1. */
        if (aClass.getClass().getCanonicalName().equals("testpackage.Class1")) {
    
        Integer result;
        result = proceed(aClass, in1);
    
        if (!((Object) result).equals((anInt * new Integer(2)))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
    
        return result;
        }
    
        else {
            return proceed(aClass, in1);
        }
    }
}
package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect PostAspect2 {

    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#Class1(Integer anInt)}.</p>
     */
    protected pointcut Class1Caller(Integer anInt):
    	execution(testpackage.Class1.new(Integer)) && args(anInt);
    
    /**
     * <p>Checks a postcondition for the operation {@link Class1#Class1(, Integer anInt)} defined by the constraint
     * <code>context Class1::Class1(anInt: Integer) : 
     *       post: true</code></p>
     */
    void around(Integer anInt): Class1Caller(anInt) {
    
        proceed(anInt);
    
        if (!new Boolean(true)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
    }
}
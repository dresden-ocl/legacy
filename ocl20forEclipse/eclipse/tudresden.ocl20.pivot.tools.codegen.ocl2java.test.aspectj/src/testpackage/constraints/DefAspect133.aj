package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect133 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testStringToInteger(String source)}.</p>
     */
    protected pointcut testStringToIntegerCaller(testpackage.Class1 aClass, String source):
    	call(* testpackage.Class1.testStringToInteger(String))
    	&& target(aClass) && args(source);
    
    /**
     * <p>Defines the method testStringToInteger(String source) defined by the constraint
     * <code>context Class1
     *       def: testStringToInteger(source: String): Integer =
    source.toInteger()</code></p>
     */
    Integer around(testpackage.Class1 aClass, String source): testStringToIntegerCaller(aClass, source) {
        return Integer.parseInt(source);
    }
}
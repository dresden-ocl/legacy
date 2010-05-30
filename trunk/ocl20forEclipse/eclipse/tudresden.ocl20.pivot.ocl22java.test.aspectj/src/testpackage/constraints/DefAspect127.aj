package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect127 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testStringToReal(String source)}.</p>
     */
    protected pointcut testStringToRealCaller(testpackage.Class1 aClass, String source):
    	call(* testpackage.Class1.testStringToReal(String))
    	&& target(aClass) && args(source);
    
    /**
     * <p>Defines the method testStringToReal(String source) defined by the constraint
     * <code>context Class1
     *       def: testStringToReal = source[].toReal()</code></p>
     */
    Float around(testpackage.Class1 aClass, String source): testStringToRealCaller(aClass, source) {
        return Float.parseFloat(source);
    }
}
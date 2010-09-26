package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect79 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testIntegerMax01(Integer source, Integer arg01)}.</p>
     */
    protected pointcut testIntegerMax01Caller(testpackage.Class1 aClass, Integer source, Integer arg01):
    	call(* testpackage.Class1.testIntegerMax01(Integer, Integer))
    	&& target(aClass) && args(source, arg01);
    
    /**
     * <p>Defines the method testIntegerMax01(Integer source, Integer arg01) defined by the constraint
     * <code>context Class1
     *       def: testIntegerMax01(source: Integer, arg01: Integer): Integer =
    source.max(arg01)</code></p>
     */
    Integer around(testpackage.Class1 aClass, Integer source, Integer arg01): testIntegerMax01Caller(aClass, source, arg01) {
        return java.lang.Math.max(source, arg01);
    }
}
package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect85 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testIntegerPlus01(Integer source, Integer arg01)}.</p>
     */
    protected pointcut testIntegerPlus01Caller(testpackage.Class1 aClass, Integer source, Integer arg01):
    	call(* testpackage.Class1.testIntegerPlus01(Integer, Integer))
    	&& target(aClass) && args(source, arg01);
    
    /**
     * <p>Defines the method testIntegerPlus01(Integer source, Integer arg01) defined by the constraint
     * <code>context Class1
     *       def: testIntegerPlus01(source: Integer, arg01: Integer): Integer =
    source + arg01</code></p>
     */
    Integer around(testpackage.Class1 aClass, Integer source, Integer arg01): testIntegerPlus01Caller(aClass, source, arg01) {
        return (source + arg01);
    }
}
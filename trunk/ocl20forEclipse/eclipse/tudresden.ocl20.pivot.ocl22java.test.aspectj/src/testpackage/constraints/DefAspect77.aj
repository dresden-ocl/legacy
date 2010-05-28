package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect77 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testSetCount01(java.util.Set<Object> source, Object arg01)}.</p>
     */
    protected pointcut testSetCount01Caller(testpackage.Class1 aClass, java.util.Set<Object> source, Object arg01):
    	call(* testpackage.Class1.testSetCount01(java.util.Set<Object>, Object))
    	&& target(aClass) && args(source, arg01);
    
    /**
     * <p>Defines the method testSetCount01(java.util.Set<Object> source, Object arg01) defined by the constraint
     * <code>context Class1
     *       def: testSetCount01 = source[].count( arg01[])</code></p>
     */
    Integer around(testpackage.Class1 aClass, java.util.Set<Object> source, Object arg01): testSetCount01Caller(aClass, source, arg01) {
        return tudresden.ocl20.pivot.ocl22java.types.util.OclSets.count(source, arg01);
    }
}
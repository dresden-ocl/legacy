package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect4 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testCollectionMin(tudresden.ocl20.pivot.ocl2java.types.OclCollection<Object> source)}.</p>
     */
    protected pointcut testCollectionMinCaller(testpackage.Class1 aClass, tudresden.ocl20.pivot.ocl2java.types.OclCollection<Object> source):
    	call(* testpackage.Class1.testCollectionMin(tudresden.ocl20.pivot.ocl2java.types.OclCollection<Object>))
    	&& target(aClass) && args(source);
    
    /**
     * <p>Defines the method testCollectionMin(tudresden.ocl20.pivot.ocl2java.types.OclCollection<Object> source) defined by the constraint
     * <code>context Class1
     *       def: testCollectionMin = source[].min()</code></p>
     */
    Object around(testpackage.Class1 aClass, tudresden.ocl20.pivot.ocl2java.types.OclCollection<Object> source): testCollectionMinCaller(aClass, source) {
        Object result1;
        result1 = null;
        
        /* Compute the result of a min operation. */
        for (Object anElement1 : source) {
            if (result1 == null || ((Comparable) result1).compareTo((Comparable) anElement1) > 0) {
                result1 = anElement1;
            }
        }
    
        return result1;
    }
}
package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect97 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testOrderedSetAppend(java.util.List<Object> source, Object arg01)}.</p>
     */
    protected pointcut testOrderedSetAppendCaller(testpackage.Class1 aClass, java.util.List<Object> source, Object arg01):
    	call(* testpackage.Class1.testOrderedSetAppend(java.util.List<Object>, Object))
    	&& target(aClass) && args(source, arg01);
    
    /**
     * <p>Defines the method testOrderedSetAppend(java.util.List<Object> source, Object arg01) defined by the constraint
     * <code>context Class1
     *       def: testOrderedSetAppend(source: OrderedSet(OclAny), arg01: OclAny): OrderedSet(OclAny) =
    source ->append(arg01)</code></p>
     */
    java.util.List<Object> around(testpackage.Class1 aClass, java.util.List<Object> source, Object arg01): testOrderedSetAppendCaller(aClass, source, arg01) {
        return tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclOrderedSets.append(source, arg01);
    }
}
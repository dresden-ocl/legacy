package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect34 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testCollectionIsEmpty(java.util.Collection<Object> source)}.</p>
     */
    protected pointcut testCollectionIsEmptyCaller(testpackage.Class1 aClass, java.util.Collection<Object> source):
    	call(* testpackage.Class1.testCollectionIsEmpty(java.util.Collection<Object>))
    	&& target(aClass) && args(source);
    
    /**
     * <p>Defines the method testCollectionIsEmpty(java.util.Collection<Object> source) defined by the constraint
     * <code>context Class1
     *       def: testCollectionIsEmpty(source: Collection(OclAny)): Boolean =
    source ->isEmpty()</code></p>
     */
    Boolean around(testpackage.Class1 aClass, java.util.Collection<Object> source): testCollectionIsEmptyCaller(aClass, source) {
        return tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclCollections.isEmpty(source);
    }
}
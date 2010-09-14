package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect38 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testCollectionNotEquals(java.util.Collection<Object> source, java.util.Collection<Object> arg01)}.</p>
     */
    protected pointcut testCollectionNotEqualsCaller(testpackage.Class1 aClass, java.util.Collection<Object> source, java.util.Collection<Object> arg01):
    	call(* testpackage.Class1.testCollectionNotEquals(java.util.Collection<Object>, java.util.Collection<Object>))
    	&& target(aClass) && args(source, arg01);
    
    /**
     * <p>Defines the method testCollectionNotEquals(java.util.Collection<Object> source, java.util.Collection<Object> arg01) defined by the constraint
     * <code>context Class1
     *       def: testCollectionNotEquals(source: Collection(OclAny), arg01: Collection(OclAny)): Boolean =
    source <> arg01</code></p>
     */
    Boolean around(testpackage.Class1 aClass, java.util.Collection<Object> source, java.util.Collection<Object> arg01): testCollectionNotEqualsCaller(aClass, source, arg01) {
        return tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclCollections.notEquals(source, arg01);
    }
}
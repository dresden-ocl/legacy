package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect39 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testBagAsBag(java.util.List<Object> source)}.</p>
     */
    protected pointcut testBagAsBagCaller(testpackage.Class1 aClass, java.util.List<Object> source):
    	call(* testpackage.Class1.testBagAsBag(java.util.List<Object>))
    	&& target(aClass) && args(source);
    
    /**
     * <p>Defines the method testBagAsBag(java.util.List<Object> source) defined by the constraint
     * <code>context Class1
     *       def: testBagAsBag(source: Bag(OclAny)): 
      Bag(OclAny) =
    source ->asBag()</code></p>
     */
    java.util.List<Object> around(testpackage.Class1 aClass, java.util.List<Object> source): testBagAsBagCaller(aClass, source) {
        return tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclBags.asBag(source);
    }
}
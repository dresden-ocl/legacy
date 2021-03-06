package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testBagFlatten {

    /**
     * <p>Defines the method testBagFlatten(java.util.List<Object> source) defined by the constraint
     * <code>context Class1
     *       def: testBagFlatten(source: Bag(OclAny)): Bag(OclAny) = source ->flatten()</code></p>
     */
    public java.util.List<Object> testpackage.Class1.testBagFlatten(java.util.List<Object> source) {
        return (java.util.List<Object>) tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclBags.flatten(source);
    }
}
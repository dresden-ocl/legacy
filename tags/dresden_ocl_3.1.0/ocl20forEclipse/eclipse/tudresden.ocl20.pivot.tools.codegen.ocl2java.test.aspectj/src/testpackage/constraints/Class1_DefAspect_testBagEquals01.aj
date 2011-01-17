package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testBagEquals01 {

    /**
     * <p>Defines the method testBagEquals01(java.util.List<Object> source, java.util.List<Object> arg01) defined by the constraint
     * <code>context Class1
     *       def: testBagEquals01(source: Bag(OclAny), arg01: Bag(OclAny)): Boolean = source = arg01</code></p>
     */
    public Boolean testpackage.Class1.testBagEquals01(java.util.List<Object> source, java.util.List<Object> arg01) {
        return tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclBags.equals(source, arg01);
    }
}
package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testSequenceAt {

    /**
     * <p>Defines the method testSequenceAt(java.util.List<Object> source, Integer arg01) defined by the constraint
     * <code>context Class1
     *       def: testSequenceAt(source: Sequence(OclAny), arg01: Integer): OclAny = source ->at(arg01)</code></p>
     */
    public Object testpackage.Class1.testSequenceAt(java.util.List<Object> source, Integer arg01) {
        return tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclSequences.at(source, arg01);
    }
}
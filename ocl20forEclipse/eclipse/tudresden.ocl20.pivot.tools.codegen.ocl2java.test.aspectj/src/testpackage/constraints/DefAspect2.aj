package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect2 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#defOperation01()}.</p>
     */
    protected pointcut defOperation01Caller(testpackage.Class1 aClass):
    	call(* testpackage.Class1.defOperation01())
    	&& target(aClass);
    
    /**
     * <p>Defines the method defOperation01() defined by the constraint
     * <code>context Class1
     *       def: defOperation01(): Integer = 42</code></p>
     */
    Integer around(testpackage.Class1 aClass): defOperation01Caller(aClass) {
        return new Integer(42);
    }
}
package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect BodyAspect2 {

    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#bodyOperation02(Integer in1)}.</p>
     */
    protected pointcut bodyOperation02Caller(testpackage.Class1 aClass, Integer in1):
    	call(* testpackage.Class1.bodyOperation02(Integer))
    	&& target(aClass) && args(in1);
    
    /**
     * <p>Defines the body of the method bodyOperation02(Integer in1) defined by the constraint
     * <code>context Class1::bodyOperation02(in1: Integer): Integer
     *       body: -anInt</code></p>
     */
    Integer around(testpackage.Class1 aClass, Integer in1): bodyOperation02Caller(aClass, in1) {
        return -(anInt);
    }
}
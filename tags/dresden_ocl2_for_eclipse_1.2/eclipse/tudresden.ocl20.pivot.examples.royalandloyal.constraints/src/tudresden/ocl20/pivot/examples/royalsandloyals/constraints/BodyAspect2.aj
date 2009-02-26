package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect BodyAspect2 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.Date#nowAsString()}.</p>
     */
    protected pointcut nowAsStringCaller():
    	execution(* tudresden.ocl20.pivot.examples.royalsandloyals.Date.nowAsString());
    
    /**
     * <p>Defines the body of the method nowAsString() defined by the constraint
     * <code>context Date::nowAsString(): String
     *       body: now().toString()</code></p>
     */
    String around(): nowAsStringCaller() {
        return tudresden.ocl20.pivot.examples.royalsandloyals.Date.now().toString();
    }
}
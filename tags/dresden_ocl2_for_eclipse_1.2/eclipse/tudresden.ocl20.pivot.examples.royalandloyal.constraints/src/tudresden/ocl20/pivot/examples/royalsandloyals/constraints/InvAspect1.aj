package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect InvAspect1 {

    /**
     * <p>Describes all Constructors of the class {@link tudresden.ocl20.pivot.examples.royalsandloyals.Customer}.</p>
     */
    protected pointcut allCustomerConstructors(tudresden.ocl20.pivot.examples.royalsandloyals.Customer aClass):
        execution(tudresden.ocl20.pivot.examples.royalsandloyals.Customer.new(..)) && this(aClass);
    
    /**
     * <p>Describes all public methods of the class {@link tudresden.ocl20.pivot.examples.royalsandloyals.Customer}.</p>
     */
    protected pointcut allCustomerPublicMethods(tudresden.ocl20.pivot.examples.royalsandloyals.Customer aClass):
        execution(public * tudresden.ocl20.pivot.examples.royalsandloyals.Customer.*(..)) && this(aClass);
    
    /**
     * <p><code>Checks an invariant on the class Customer defined by the constraint
     * <code>context Customer
     *       inv: age[].>=( 18)</code>
     * before execution of public methods.</p>
     */
    before(tudresden.ocl20.pivot.examples.royalsandloyals.Customer aClass) : allCustomerPublicMethods(aClass) {
        /* Disable this constraint for subclasses of Customer. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Customer")) {
        if (!(aClass.age >= new Integer(18))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
    
    /**
     * <p><code>Checks an invariant on the class Customer defined by the constraint
     * <code>context Customer
     *       inv: age[].>=( 18)</code>
     * after execution of public methods and constructors.</p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.Customer aClass) : allCustomerConstructors(aClass) || allCustomerPublicMethods(aClass) {
        /* Disable this constraint for subclasses of Customer. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Customer")) {
        if (!(aClass.age >= new Integer(18))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
    
    /**
     * <p><code>Checks an invariant on the class Customer defined by the constraint
     * <code>context Customer
     *       inv: age[].>=( 18)</code>
     * after execution of public methods throwing any Exception.</p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.Customer aClass) throwing : allCustomerPublicMethods(aClass) {
        /* Disable this constraint for subclasses of Customer. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Customer")) {
        if (!(aClass.age >= new Integer(18))) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
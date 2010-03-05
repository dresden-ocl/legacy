package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect InitAspect2 {

    /**
     * <p>Describes all Constructors of the class {@link tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard}.</p>
     */
    protected pointcut allCustomerCardConstructors(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard aClass):
        execution(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard.new(..)) && this(aClass);
    
    /**
     * <p><code>Initializes the attribute valid defined by the constraint
     * <code>context CustomerCard::valid
     *       init: true</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard aClass) : allCustomerCardConstructors(aClass) {
        aClass.valid = new Boolean(true);
    }
}
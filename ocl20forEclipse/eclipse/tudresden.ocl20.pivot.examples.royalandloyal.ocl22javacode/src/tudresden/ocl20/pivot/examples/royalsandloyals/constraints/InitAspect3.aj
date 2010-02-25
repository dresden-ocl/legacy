package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect InitAspect3 {

    /**
     * <p>Describes all Constructors of the class {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount}.</p>
     */
    protected pointcut allLoyaltyAccountConstructors(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass):
        execution(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount.new(..)) && this(aClass);
    
    /**
     * <p><code>Initializes the attribute transactions defined by the constraint
     * <code>context LoyaltyAccount::transactions
     *       init: Set{}</code></p>
     */
    after(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass) : allLoyaltyAccountConstructors(aClass) {
        tudresden.ocl20.pivot.ocl2java.types.OclSet collection1;
        collection1 = new tudresden.ocl20.pivot.ocl2java.types.OclSet();
    
        aClass.transactions = collection1;
    }
}
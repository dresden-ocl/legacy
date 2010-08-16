package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect DefAspect4 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedLoyaltyAccount;
    
    /**
     * <p>Pointcut for all requests on {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount#usedServices}.</p>
     */
    protected pointcut usedServicesGetter(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass) :
    	get(* usedServices) && this(aClass);
    
    /**
     * <p>Initializes the attribute usedServices defined by the constraint
     * <code>context LoyaltyAccount
     *       def: usedServices = transactions[].service[].asSet()</code></p>
     */
    before(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass): usedServicesGetter(aClass) {
        tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.Service> result1;
        result1 = new tudresden.ocl20.pivot.ocl2java.types.OclBag<tudresden.ocl20.pivot.examples.royalsandloyals.Service>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Transaction anElement1 : aClass.transactions) {
            result1.add(anElement1.service);
        }
    
        aClass.usedServices = result1.asSet();
    }
}
package org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect LoyaltyAccount_BodyAspect_getCustomerName {

    /**
     * <p>Pointcut for all calls on {@link org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount#getCustomerName()}.</p>
     */
    protected pointcut getCustomerNameCaller(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass):
    	call(* org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount.getCustomerName())
    	&& target(aClass);

    /**
     * <p>Defines the body of the method getCustomerName() defined by the constraint
     * <code>context LoyaltyAccount::getCustomerName(): String
     *       body: membership.card.owner.name</code></p>
     */
    String around(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass): getCustomerNameCaller(aClass) {
        return aClass.membership.card.owner.name;
    }
}
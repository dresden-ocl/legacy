package org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect LoyaltyAccount_InitAspect_points {

    /**
     * <p>Describes all Constructors of the class {@link org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount}.</p>
     */
    protected pointcut allLoyaltyAccountConstructors(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass):
        execution(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount.new(..)) && this(aClass);

    /**
     * <p><code>Initializes the attribute points defined by the constraint
     * <code>context LoyaltyAccount::points
     *       init: 0</code></p>
     */
    after(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount aClass) : allLoyaltyAccountConstructors(aClass) {
        aClass.points = new Integer(0);
    }
}
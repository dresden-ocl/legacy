package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>
 * The class {@link tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedLoyaltyAccount} provides some newly defined attributes and methods class {@link LoyaltyAccount}.
 * </p>
 */
public class ExtendedLoyaltyAccount extends Object {

    protected Float turnover;

    protected java.util.Set<tudresden.ocl20.pivot.examples.royalsandloyals.Service> usedServices;    
    
    /**
     * @return The attribute turnover of the type {@link Float}.
     */
    public Float getTurnover() {
        return this.turnover;
    }

    /**
     * @return The attribute usedServices of the type {@link java.util.Set<tudresden.ocl20.pivot.examples.royalsandloyals.Service>}.
     */
    public java.util.Set<tudresden.ocl20.pivot.examples.royalsandloyals.Service> getUsedServices() {
        return this.usedServices;
    }

    /**
     *<p>
     *A method signature implemented by an aspect.
     *</p>
     */
    public void checkInvariants() {
    }
        
}
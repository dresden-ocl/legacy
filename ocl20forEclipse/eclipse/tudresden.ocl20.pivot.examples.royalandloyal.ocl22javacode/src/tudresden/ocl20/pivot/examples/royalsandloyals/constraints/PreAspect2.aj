package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

@Generated
public privileged aspect PreAspect2 {

    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram#addService(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aPartner, tudresden.ocl20.pivot.examples.royalsandloyals.ServiceLevel aLevel, tudresden.ocl20.pivot.examples.royalsandloyals.Service aService)}.</p>
     */
    protected pointcut addServiceCaller(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass, tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aPartner, tudresden.ocl20.pivot.examples.royalsandloyals.ServiceLevel aLevel, tudresden.ocl20.pivot.examples.royalsandloyals.Service aService):
    	call(* tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram.addService(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner, tudresden.ocl20.pivot.examples.royalsandloyals.ServiceLevel, tudresden.ocl20.pivot.examples.royalsandloyals.Service))
    	&& target(aClass) && args(aPartner, aLevel, aService);
    
    /**
     * <p>Checks a precondition for the addService(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aPartner, tudresden.ocl20.pivot.examples.royalsandloyals.ServiceLevel aLevel, tudresden.ocl20.pivot.examples.royalsandloyals.Service aService) defined by the constraint
     * <code>context LoyaltyProgram::addService(aPartner: tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner, aLevel: tudresden.ocl20.pivot.examples.royalsandloyals.ServiceLevel, aService: tudresden.ocl20.pivot.examples.royalsandloyals.Service) : 
     *       pre: partners[].includes( aPartner[])</code></p>
     */
    before(tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram aClass, tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aPartner, tudresden.ocl20.pivot.examples.royalsandloyals.ServiceLevel aLevel, tudresden.ocl20.pivot.examples.royalsandloyals.Service aService): addServiceCaller(aClass, aPartner, aLevel, aService) {
        /* Disable this constraint for subclasses of LoyaltyProgram. */
        if (aClass.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyProgram")) {
        if (!aClass.partners.contains(aPartner)) {
        	// TODO Auto-generated code executed when constraint is violated.
        	throw new RuntimeException("Error: Constraint was violated.");
        }
        // no else.
        }
        // no else.
    }
}
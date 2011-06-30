package tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect8 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner extends tudresden.ocl20.pivot.examples.royalsandloyals.constraints.ExtendedProgramPartner;
    
    /**
     * <p>Pointcut for all calls on {@link tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner#getBurningTransactions()}.</p>
     */
    protected pointcut getBurningTransactionsCaller(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aClass):
    	call(* tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner.getBurningTransactions())
    	&& target(aClass);
    
    /**
     * <p>Defines the method getBurningTransactions() defined by the constraint
     * <code>context ProgramPartner
     *       def: getBurningTransactions = self[].deliveredServices[].transaction[] -> iterate (t:Transaction ; resultSet:Set( Transaction )=Set{} | if t[].oclIsTypeOf( Burning[]) then resultSet[].including( t[]) else resultSet[] )</code></p>
     */
    java.util.Set<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction> around(tudresden.ocl20.pivot.examples.royalsandloyals.ProgramPartner aClass): getBurningTransactionsCaller(aClass) {
        java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction> result1;
        result1 = new java.util.ArrayList<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction>();
        
        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Service anElement1 : aClass.deliveredServices) {
            result1.add(anElement1.transaction);
        }
        java.util.HashSet collection1;
        collection1 = new java.util.HashSet();
        java.util.Set<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction> resultSet;
        resultSet = collection1;
        /* IterateExp: Iterate through all elements and perform an operation on them. */
        for (tudresden.ocl20.pivot.examples.royalsandloyals.Transaction anElement2 : result1) {
            java.util.Set<tudresden.ocl20.pivot.examples.royalsandloyals.Transaction> ifExpResult1;
            
            if (anElement2.getClass().getCanonicalName().equals("tudresden.ocl20.pivot.examples.royalsandloyals.Burning")) {
                ifExpResult1 = tudresden.ocl20.pivot.tools.codegen.ocl2java.types.util.OclSets.including(resultSet, anElement2);
            } else {
                ifExpResult1 = resultSet;
            }
            resultSet = ifExpResult1;
        }
    
        return resultSet;
    }
}
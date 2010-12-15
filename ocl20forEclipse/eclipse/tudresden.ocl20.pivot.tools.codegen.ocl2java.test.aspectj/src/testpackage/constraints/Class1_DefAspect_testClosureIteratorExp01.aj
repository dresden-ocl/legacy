package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testClosureIteratorExp01 {

    /**
     * <p>Defines the method testClosureIteratorExp01() defined by the constraint
     * <code>context Class1
     *       def: testClosureIteratorExp01() : Set(Class1) =
    self->closure(parent)</code></p>
     */
    public java.util.Set<testpackage.Class1> testpackage.Class1.testClosureIteratorExp01( ) {
    	/* Self variable probably used within the definition. */
    	testpackage.Class1 aClass = this;
    	
        /* Compute closure iterator. */
        java.util.Set<testpackage.Class1> result2;
        result2 = new java.util.HashSet<testpackage.Class1>();
        result2.add(aClass);java.util.HashSet<testpackage.Class1> result1;
        result1 = new java.util.HashSet<testpackage.Class1>();
        // TODO replace toVisit with generated var    
        java.util.HashSet<testpackage.Class1> toVisit = new java.util.HashSet<testpackage.Class1>();
        toVisit.addAll(result2);
                
        while (toVisit.size() > 0) {
        	testpackage.Class1 anElement1 = toVisit.iterator().next();
            toVisit.remove(anElement1);
                	
            /* This is the body. */
            // TODO repleace bodyResult with generated var
            testpackage.Class1 bodyResult = anElement1.parent;
        	if (bodyResult != null && !result1.contains(bodyResult)) {
                result1.add(bodyResult);
                toVisit.add(bodyResult);
            }
            // no else.
        }
        // end while.
        return result1;
    }
}
package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect DefAspect25 {

    /* Declares a new super class containing the new attribute or method. */
    declare parents : testpackage.Class1 extends testpackage.constraints.ExtendedClass1;
    
    /**
     * <p>Pointcut for all calls on {@link testpackage.Class1#testCollectionLiteralExp03()}.</p>
     */
    protected pointcut testCollectionLiteralExp03Caller(testpackage.Class1 aClass):
    	call(* testpackage.Class1.testCollectionLiteralExp03())
    	&& target(aClass);
    
    /**
     * <p>Defines the method testCollectionLiteralExp03() defined by the constraint
     * <code>context Class1
     *       def: testCollectionLiteralExp03(): 
      OrderedSet(Integer) =
    OrderedSet { 0, 1, 2 }</code></p>
     */
    java.util.List<Integer> around(testpackage.Class1 aClass): testCollectionLiteralExp03Caller(aClass) {
        java.util.ArrayList<Integer> collection1;
        collection1 = new java.util.ArrayList<Integer>();
        
        collection1.add(new Integer(0));
        collection1.add(new Integer(1));
        collection1.add(new Integer(2));
    
        return collection1;
    }
}
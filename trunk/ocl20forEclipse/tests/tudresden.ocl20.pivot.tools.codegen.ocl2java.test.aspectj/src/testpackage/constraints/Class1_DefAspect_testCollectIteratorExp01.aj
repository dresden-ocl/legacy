package testpackage.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Class1_DefAspect_testCollectIteratorExp01 {

    /**
     * <p>Defines the method testCollectIteratorExp01() defined by the constraint
     * <code>context Class1
     *       def: testCollectIteratorExp01() : Bag(Boolean) = Set{1, 2, 3}->collect(i: Integer | i <> 2)</code></p>
     */
    public java.util.List<Boolean> testpackage.Class1.testCollectIteratorExp01() {
        java.util.HashSet<Integer> collection1;
        collection1 = new java.util.HashSet<Integer>();

        collection1.add(new Integer(1));
        collection1.add(new Integer(2));
        collection1.add(new Integer(3));
        java.util.ArrayList<Boolean> result1;
        result1 = new java.util.ArrayList<Boolean>();

        /* Iterator Collect: Iterate through all elements and collect them. Elements which are collections are flattened. */
        for (Integer anElement1 : collection1) {
            result1.add(!((Object) anElement1).equals(new Integer(2)));
        }

        return result1;
    }
}
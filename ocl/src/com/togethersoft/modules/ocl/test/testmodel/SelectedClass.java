/* Generated by Together */

package com.togethersoft.modules.ocl.test.testmodel;
import java.util.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

/**
 * @invariant unnamedConstraint : self . classInSamePackage . selectedOperation ( someDate ) = 5 
 * @invariant justATest : testOperation ( selectedOperation ( ) , '' ) = true  
 * @selectedForInstrumentation
 */
public class SelectedClass extends SuperclassOfSelectedClass {
    public int selectedOperation() {
        return 0; // no function, just to compile
    }

    public SelectedClass testOperation2(ClassInSamePackage classInSamePackage) {
        return new SelectedClass();
    }

    public boolean testOperation(int param1, String param2) {
        return false;  // no function, just to compile
    }

    public ClassInSamePackage[] operationReturnsArray() {
        return new ClassInSamePackage[4];
    }

    public void testOperation3(Date date) {
    }

    private UnnamedUndirectedAssociation lnkUnnamedUndirectedAssociation;
    private Date someDate;
    private String stringAttribute;
    private boolean booleanAttribute;
    private int integerAttribute;

    /**
     * @supplierRole firstRolename 
     */
    private NamedUndirectedAssociation lnkNamedUndirectedAssociation;

    /**
     * @bidirectional 
     */
    private UnnamedBidirectionalAssociation lnkrevUnnamedBidirectionalAssociation;
    private SomeAccidentalName lnkSomeAccidentalName;

    /**
     * @bidirectional
     */
    private NamedBidirectionalAssociation lnkrevNamedBidirectionalAssociation;

    /** @associates <{CollectionCreatedByPattern}>
     * @supplierCardinality 0..**/
    private ArrayList lnkCollectionCreatedByPattern;

    /**
     *@link aggregation
     * @supplierCardinality 6
     */
    private AggregationAsSimpleArray[] lnkCollectionAsSimpleArray;

    /**
     * @bidirectional 
     */
    private BidirectionalAssociationToCollection
        lnkrevBidrectionalAssociationToCollection;
}

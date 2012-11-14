package org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.constraints;

/**
 * <p>Generated Aspect to enforce OCL constraint.</p>
 *
 * @author OCL22Java of Dresden OCL2 for Eclipse
 * @Generated
 */
public privileged aspect Date_InitAspect_nowString {

    /**
     * <p>The initialization of the class {@link org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Date}.</p>
     */
    protected pointcut staticDateInit():
        staticinitialization(org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Date);

    /**
     * <p><code>Initializes the static attribute nowString defined by the constraint
     * <code>context Date::nowString
     *       init: Date::now().toString()</code></p>
     */
    after(): staticDateInit() {
        org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Date.nowString = org.dresdenocl.tudresden.ocl20.pivot.examples.royalsandloyals.Date.now().toString();
    }
}
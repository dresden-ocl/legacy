package tudresden.ocl20.pivot.examples.royalsandloyals.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tudresden.ocl20.pivot.examples.royalsandloyals.CustomerCard;
import tudresden.ocl20.pivot.examples.royalsandloyals.LoyaltyAccount;

/**
 * <p>
 * Provides some tests to tests the generated aspects for init constraints.
 * </p>
 * 
 * @author Claas Wilke
 */
public class TestInitAspects {

	/**
	 * <p>
	 * Tests the generated Aspect {@link InitAspect1}.
	 * </p>
	 */
	@Test
	public void testInitAspect1() {
		
		LoyaltyAccount anAccount;
		
		anAccount = new LoyaltyAccount();
		assertEquals(0, anAccount.getPoints());
	}

	/**
	 * <p>
	 * Tests the generated Aspect {@link InitAspect2}.
	 * </p>
	 */
	@Test
	public void testInitAspect2() {
		
		CustomerCard aCard;
		
		aCard = new CustomerCard();
		assertTrue(aCard.isValid());		
	}

	/**
	 * <p>
	 * Tests the generated Aspect {@link InitAspect3}.
	 * </p>
	 */
	@Test
	public void testInitAspect3() {
		
		LoyaltyAccount anAccount;
		
		anAccount = new LoyaltyAccount();
		
		assertTrue(anAccount.getTransactions().size() == 0);
	}

}

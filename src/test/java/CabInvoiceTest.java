import org.junit.Assert;
import org.junit.Test;

/**
 * In this we have written the test cases for our program We are using the TDD
 * approach here.
 * 
 * @Before annotation are run before each test. This is useful when we want to
 *         execute some common code before running a test.
 * @author Moinuddin
 *
 */
public class CabInvoiceTest {
	InvoiceGenerator invoice = new InvoiceGenerator();

	/**
	 * Check fare as: 4*10+4 = 44, for normal ride
	 */
	@Test
	public void testGenerateInvoice() {

		Assert.assertEquals(44, invoice.generateInvoice(new Rides(4, 4, false)), 0.0);
	}

	/**
	 * Check fare as: 4*20+ 2*4 = 88, for normal ride
	 */
	@Test
	public void testGenerateInvoicePremium() {

		Assert.assertEquals(88, invoice.generateInvoice(new Rides(4, 4, true)), 0.0);
	}

	/**
	 * Fare = 0.2*10+1 = 3 which is less than 5. Should give fare = 5
	 */
	@Test
	public void testGenerateInvoice_getMin() {

		Assert.assertEquals(5, invoice.generateInvoice(new Rides(0.2, 1, false)), 0.0);
	}

	/**
	 * Fare = 0.2*20+1*2 = 6 which is less than 20. Should give fare = 20
	 */
	@Test
	public void testGenerateInvoice_getMinPremium() {

		Assert.assertEquals(20, invoice.generateInvoice(new Rides(0.2, 1, true)), 0.0);
	}

	/**
	 * multiple rides: Ride 1 - 4 kms and 5 minutes. Ride 2 - 0.2 kms and 1 minute.
	 * Should return total fare = 50
	 */
	@Test
	public void whenGivenMultipleRidesShouldReturnTotalFare() {

		Rides[] rides = { new Rides(4, 5, false), new Rides(0.2, 1, false) };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double totalFare = invoiceGenerator.calculateTotalFare(rides).totalFare;
		Assert.assertEquals(50, totalFare, 0.0);
	}

	/**
	 * multiple rides: Ride 1 - 4 kms and 5 minutes. Ride 2 - 0.2 kms and 1 minute.
	 * Should return total fare = 50
	 */
	@Test
	public void whenGivenMultipleRidesShouldReturnTotalFarePremium() {

		Rides[] rides = { new Rides(4, 5, true), new Rides(0.2, 1, true) };
		InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
		double totalFare = invoiceGenerator.calculateTotalFare(rides).totalFare;
		Assert.assertEquals(110, totalFare, 0.0);
	}

}

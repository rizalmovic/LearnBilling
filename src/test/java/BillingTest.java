import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Billing Test Suite")
class BillingTest
{
    private Billing billing;

    @BeforeEach
    void setUp() {
        this.billing = new Billing();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void calculateShouldHaveAResult()
    {
        boolean isTrue = this.billing.calculate() == "" ? false : true;
        assertTrue(isTrue);
    }
}

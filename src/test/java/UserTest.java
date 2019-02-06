import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    User user;

    @BeforeEach
    void setUp() throws ParseException {
        this.user = new User("Habli Muhammad Rizal", User.Gender.MALE, "2017-05-01", false, false);
    }

    @Test
    void getName() {
        assertEquals(this.user.getName(), "Habli Muhammad Rizal");
    }

    @Test
    void getGender() {
        assertEquals(this.user.getGender(), User.Gender.MALE);
    }

    @Test
    void joinedMoreThanTwoYears() {
        this.user.setJoined_at("2012-01-01");
        assertTrue(this.user.getJoinedAt().until(LocalDate.now(), ChronoUnit.YEARS) >= 2);
    }

    @Test
    void joinedLessThanTwoYears() {
        this.user.setJoined_at("2018-01-01");
        assertTrue(this.user.getJoinedAt().until(LocalDate.now(), ChronoUnit.YEARS) < 2);
    }

    @Test
    void affiliateGetDiscount() {
        this.user.setAsAffiliate(true);
        assertEquals(this.user.getDiscount(), 0.1);
    }

    @Test
    void employeeGetDiscount() {
        this.user.setAsAffiliate(true);
        this.user.setAsEmployee(true);
        assertEquals(this.user.getDiscount(), 0.3);
    }

    @Test
    void oldCustomerGetDiscount() {
        this.user.setJoined_at("2012-01-01");
        assertEquals(this.user.getDiscount(), 0.05);
    }
}
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredBelowLimit() {

        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredOverLimit() {

        BonusService service = new BonusService();
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredLowLimit() {
        BonusService service = new BonusService();
        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredUnderLimit() {
        BonusService service = new BonusService();
        long amount = 0;
        boolean registered = true;
        long expected = 0;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForUnRegisteredUnderLimit() {
        BonusService service = new BonusService();
        long amount = 0;
        boolean registered = false;
        long expected = 0;
        long actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}

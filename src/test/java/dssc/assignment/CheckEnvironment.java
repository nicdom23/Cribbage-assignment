package dssc.assignment;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CheckEnvironment {

    @Test
    void isThisWorking() {
        Assertions.assertEquals(true, new Something().isWorking(), "Not yet!");
    }
}

package thigns.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SingleTest {
    @Autowired
    private Single single;

    @Test
    void prototypeTest() {

        System.out.println("single = " + single);
        System.out.println("single.logic(); = " + single.logic());
        System.out.println("single.logic(); = " + single.logic());
        System.out.println("single.logic(); = " + single.logic());
    }
}
import org.junit.Test;

import java.time.ZonedDateTime;

/**
 * @author: liukj
 * @date: 2020/5/23
 * @description：
 */
public class TimeGetTest {

    @Test
    public void test(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}

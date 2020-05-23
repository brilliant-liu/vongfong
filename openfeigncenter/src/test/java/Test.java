import java.util.HashMap;
import java.util.Map;

/**
 * @author: liukj
 * @date: 2020/5/21
 * @description：
 */
public class Test {
    @org.junit.Test
    public  void test(){
        Map <String,Boolean> booleanMap = new HashMap<>();
        boolean re = null != booleanMap ? booleanMap.get("test"):false;
        System.out.println(re);

    }
}

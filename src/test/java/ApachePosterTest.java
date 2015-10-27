import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: artur
 * Date: 27.10.15
 * Time: 23:14
 * To change this template use File | Settings | File Templates.
 */
public class ApachePosterTest {
    private ApachePoster poster;

    @Before
    public void setUp() throws Exception {
        poster = new ApachePoster();
    }

    @Test
    public void testPost() throws Exception {
        String response = poster.post();
        System.out.println(response);
    }
}

import com.phoenix.sca.remote.ApplicationRemoteStart;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = ApplicationRemoteStart.class)
@RunWith(SpringRunner.class)
public abstract class AbstractServiceTest {
}

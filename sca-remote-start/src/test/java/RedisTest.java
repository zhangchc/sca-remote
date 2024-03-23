import com.phoenix.sca.common.utils.RedisUtil;
import com.phoenix.sca.facade.api.userinfo.UserInfoService;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


public class RedisTest extends AbstractServiceTest{
@Autowired
private RedisUtil redisUtil;


    @Test
    public void getTest() {
       String s = redisUtil.get("test_key");
       if( StringUtils.isEmpty(s)){
            System.out.println("缓存中没有数据");
        }
        System.out.println("缓存数据"+s);
        redisUtil.set("test_key",s+"001");
        System.out.println("缓存变更后数据"+redisUtil.get("test_key"));

    }

    @Before
    public void setup() throws IOException {
    }

    @After
    public void after() throws IOException {
    }





}


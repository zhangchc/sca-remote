import com.alibaba.fastjson.JSONObject;
import com.zhang.sca.facade.api.UserService;
import com.zhang.sca.facade.model.dto.UserInfoRequest;
import com.zhang.sca.model.po.User;
import org.apache.http.client.HttpClient;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;


class UserServiceTest extends AbstractServiceTest{
@Autowired
private UserService userService;


    @Test
    void getTest() {
        UserInfoRequest user =new UserInfoRequest();
        user.setPageNo(1);
        user.setPageSize(10);
        user.setGender("男");
       userService.selectUserInfoBycon(user);
    }

    @Before
    public void setup() throws IOException, URISyntaxException {
    }

    @After
    public void after() throws IOException {
    }





}


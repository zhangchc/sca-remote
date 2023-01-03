import com.phoenix.sca.facade.api.userinfo.UserInfoService;
import com.phoenix.sca.facade.api.userinfo.dto.UserInfoRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


public class UserServiceTest extends AbstractServiceTest{
@Autowired
private UserInfoService userInfoService;


    @Test
    public void getTest() {
        UserInfoRequest user =new UserInfoRequest();
        user.setPageNo(1);
        user.setPageSize(10);
        user.setGender("男");
        userInfoService.selectUserInfoBycon(user);
    }

    @Before
    public void setup() throws IOException {
    }

    @After
    public void after() throws IOException {
    }





}


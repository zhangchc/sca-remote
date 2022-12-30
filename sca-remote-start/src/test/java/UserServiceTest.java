import com.phoenix.sca.facade.api.UserInfoService;
import com.phoenix.sca.facade.model.dto.UserInfoRequest;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;


class UserServiceTest extends AbstractServiceTest{
@Autowired
private UserInfoService userInfoService;


    @Test
    void getTest() {
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


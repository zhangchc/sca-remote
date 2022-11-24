//import com.alibaba.fastjson.JSON;
//import com.wechat.pay.contrib.apache.httpclient.WechatPayHttpClientBuilder;
//import com.wechat.pay.contrib.apache.httpclient.WechatPayUploadHttpPost;
//import com.wechat.pay.contrib.apache.httpclient.auth.AutoUpdateCertificatesVerifier;
//import com.wechat.pay.contrib.apache.httpclient.auth.PrivateKeySigner;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Credentials;
//import com.wechat.pay.contrib.apache.httpclient.auth.WechatPay2Validator;
//import com.wechat.pay.contrib.apache.httpclient.util.PemUtil;
//import com.zhang.sca.facade.ResponseInfo;
//import com.zhang.sca.facade.api.UserService;
//import com.zhang.sca.facade.model.dto.UserDTO;
//import com.zhang.sca.remote.configuration.SignV3Utils;
//import org.apache.commons.codec.digest.DigestUtils;
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.methods.HttpPost;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.crypto.BadPaddingException;
//import javax.crypto.Cipher;
//import javax.crypto.IllegalBlockSizeException;
//import javax.crypto.NoSuchPaddingException;
//import java.io.*;
//import java.net.URI;
//import java.net.URISyntaxException;
//import java.security.InvalidKeyException;
//import java.security.NoSuchAlgorithmException;
//import java.security.PrivateKey;
//import java.security.SignatureException;
//import java.security.cert.X509Certificate;
//import java.security.spec.InvalidKeySpecException;
//import java.util.Base64;
//import java.util.HashMap;
//
//
//class UserServiceTest extends AbstractServiceTest{
//@Autowired
//private UserService userService;
//
//
//    HttpClient httpClient;
//    @Test
//    void getTest() throws NoSuchAlgorithmException, SignatureException, InvalidKeySpecException, InvalidKeyException, UnsupportedEncodingException {
//        ResponseInfo<UserDTO> userDto = userService.test(1l);
//        UserDTO user= userDto.getData();
//        System.out.println(user.getUserId()+"===");
//        System.out.println(user.getUsername()+"===");
////        //处理请求参数
////        String param = JSON.toJSONString("请求参数");
////        //获取签名请求头
////        HashMap<String, String> heads = SignV3Utils.getSignMap("POST", "微信接口url", param);
////        //请求微信接口
////        HttpUtils.requestPostBody("微信接口url", param, heads);
//
//    }
//
//    @Before
//    public void setup() throws IOException, URISyntaxException {
//
//        String filePath = "/your/home/hellokitty.png";
//        URI uri = new URI("https://api.mch.weixin.qq.com/v3/merchant/media/upload");
//        File file = new File(filePath);
//
//        try (FileInputStream ins1 = new FileInputStream(file)) {
//            String sha256 = DigestUtils.sha256Hex(ins1);
//            try (InputStream ins2 = new FileInputStream(file)) {
//                HttpPost request = new WechatPayUploadHttpPost.Builder(uri)
//                        .withImage(file.getName(), sha256, ins2)
//                        .build();
////                CloseableHttpResponse response1 = httpClient.execute(request);
//            }
//        }
//
//
//        // 加载商户私钥（privateKey：私钥字符串）
////        String privateKey="";
//        String mchId ="";
//        String mchSerialNo="";
//        String apiV3Key ="";
//        PrivateKey merchantPrivateKey = PemUtil
//                .loadPrivateKey(new ByteArrayInputStream(privateKey.getBytes("utf-8")));
//
//        // 加载平台证书（mchId：商户号,mchSerialNo：商户证书序列号,apiV3Key：V3密钥）
//        AutoUpdateCertificatesVerifier verifier = new AutoUpdateCertificatesVerifier(
//                new WechatPay2Credentials(mchId, new PrivateKeySigner(mchSerialNo, merchantPrivateKey)),apiV3Key.getBytes("utf-8"));
//
//        // 初始化httpClient
//        httpClient = WechatPayHttpClientBuilder.create()
//                .withMerchant(mchId, mchSerialNo, merchantPrivateKey)
//                .withValidator(new WechatPay2Validator(verifier)).build();
//    }
//
//    @After
//    public void after() throws IOException {
////        httpClient.close();
//    }
//
//    public static String rsaEncryptOAEP(String message, X509Certificate certificate)
//            throws IllegalBlockSizeException, IOException {
//        try {
//            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
//            cipher.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());
//
//            byte[] data = message.getBytes("utf-8");
//            byte[] cipherdata = cipher.doFinal(data);
//            return Base64.getEncoder().encodeToString(cipherdata);
//        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
//            throw new RuntimeException("当前Java环境不支持RSA v1.5/OAEP", e);
//        } catch (InvalidKeyException e) {
//            throw new IllegalArgumentException("无效的证书", e);
//        } catch (IllegalBlockSizeException | BadPaddingException e) {
//            throw new IllegalBlockSizeException("加密原串的长度不能超过214字节");
//        }
//    }
//
//    public static String rsaDecryptOAEP(String ciphertext, PrivateKey privateKey)
//            throws BadPaddingException, IOException {
//        try {
//            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
//            cipher.init(Cipher.DECRYPT_MODE, privateKey);
//
//            byte[] data = Base64.getDecoder().decode(ciphertext);
//            return new String(cipher.doFinal(data), "utf-8");
//        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
//            throw new RuntimeException("当前Java环境不支持RSA v1.5/OAEP", e);
//        } catch (InvalidKeyException e) {
//            throw new IllegalArgumentException("无效的私钥", e);
//        } catch (BadPaddingException | IllegalBlockSizeException e) {
//            throw new BadPaddingException("解密失败");
//        }
//    }
//
//}
//

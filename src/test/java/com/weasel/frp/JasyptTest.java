package com.weasel.frp;

import org.jasypt.encryption.StringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Dylan
 * @date 2017/2/6.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationLauncher.class)
public class JasyptTest {

    @Autowired
    StringEncryptor stringEncryptor;

    @Test
    public void encryptPwd() {
        String result = stringEncryptor.encrypt("5805");
        System.out.println(result);
    }
}

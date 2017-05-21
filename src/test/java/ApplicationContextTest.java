import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.MessageSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.*;

import javax.accessibility.AccessibleResourceBundle;
import javax.annotation.Resource;
import java.util.Enumeration;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Administrator on 2017/5/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ApplicationContextTest {
    @Resource
    private MessageSource messages;
    @Test
    public void testI18n(){
        assertNotNull(messages);
        Locale aDefault = Locale.getDefault();
        System.out.println(aDefault.getDisplayName());
        String code = messages.getMessage("code", new Object[]{3333}, aDefault);
        System.out.println(code);
    }

    @Test
    public void test2(){

        Locale locale1 = new Locale("zh", "CN");
        ResourceBundle resb1 = ResourceBundle.getBundle("myres", locale1);
        System.out.println(resb1.getString("aaa"));

        ResourceBundle resb2 = ResourceBundle.getBundle("myres", Locale.getDefault());
        System.out.println(resb1.getString("aaa"));

        Locale locale3 = new Locale("en", "US");
        ResourceBundle resb3 = ResourceBundle.getBundle("myres", locale3);
        System.out.println(resb3.getString("aaa"));

//        ListResourceBundle lrb = new AccessibleResourceBundle();
//        Enumeration<String> keys = lrb.getKeys();
//        while (keys.hasMoreElements()){
//            String key = keys.nextElement();
//            System.out.println(key+"-->"+lrb.getString(key));
//        }
    }

}

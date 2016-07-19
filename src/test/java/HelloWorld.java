import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Created by Administrator on 2016/7/19.
 */
public class HelloWorld {
    public static void main(String[] args) {
        Factory<SecurityManager> securityManagerFactory = new IniSecurityManagerFactory("classpath:TestShiro.ini");
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        UsernamePasswordToken token = new UsernamePasswordToken("javass", "cc");
        token.setRememberMe(true);

        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        boolean flag = subject.isPermitted("p1");
        System.out.println("flag == " + flag);
        String ss = new Sha256Hash("123456").toHex();
        String ss2 = new Md5Hash("123456").toHex();
        System.out.println(ss);
        System.out.println(ss2);
    }
}

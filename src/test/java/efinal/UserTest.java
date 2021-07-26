package efinal;

import org.junit.Assert;
import org.junit.Test;


public class UserTest {

    @Test
    public void isUser() {
        var user = new User("hola","aloh");
        Assert.assertTrue(user.isUser());
    }
}
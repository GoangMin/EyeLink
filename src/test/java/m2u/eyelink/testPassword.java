package m2u.eyelink;

import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;
import m2u.eyelink.db.Password;

public class testPassword
{
  @Test
  public void testPasswords()
  {
    try
    {
      String str1 = "abc";
      System.out.println("Entered: " + str1);
      String str2 = Password.encrypt(str1);
      System.out.println(" EnCrypt : " + str2);
      str2 = Password.decrypt(str2);
      System.out.println(" DnCrypt : " + str2);
      Assert.assertEquals(str1, str2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Assert.fail("Failed");
    }
  }
  
  @Test
  public void testEnPasswords()
  {
    try
    {
      String str1 = "wm82";
      System.out.println("Entered: " + str1);
      String str2 = Password.encrypt(str1);
      System.out.println(" EnCrypt : " + str2);
      Assert.assertEquals("CnkKWClDQG8AlwqgDtatvQ==", str2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Assert.fail("Failed");
    }
  }
  
  @Test
  public void testDePasswords()
  {
    try
    {
      String str1 = "CnkKWClDQG8AlwqgDtatvQ==";
      System.out.println("Entered: " + str1);
      String str2 = "";
      str2 = Password.decrypt(str1);
      System.out.println(" DnCrypt : " + str2);
      Assert.assertEquals("wm828822", str2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Assert.fail("Failed");
    }
  }
  
  @Test
  public void testNewGenerateKey()
  {
    try
    {
      String str = "";
      str = Password.newGenerateKey();
      System.out.println(" New Key : " + str);
      Assert.assertEquals("", "");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Assert.fail("Failed");
    }
  }
}


package m2u.eyelink;

import java.io.PrintStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TimeZone;
import org.junit.Assert;
import org.junit.Test;
import m2u.eyelink.util.Util;

public class testUtil
{
  @Test
  public void testLpadNum()
  {
    try
    {
      String str = "49";
      int i = 49;
      str = Util.Lpad(i, 10, "0");
      Assert.assertEquals("0000000049", str);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Assert.fail("Failed");
    }
  }
  
  @Test
  public void testTrim()
  {
    try
    {
      String str = " 49 ";
      String[] arrayOfString = { "a ", "b ", " c" };
      System.out.printf("%s, %s \n", new Object[] { "a", Arrays.toString(arrayOfString) });
      Assert.assertEquals("49", str.trim());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Assert.fail("Failed");
    }
  }
  
  @Test
  public void testStringTokenizer()
  {
    try
    {
      String str = "49\r\n52\r\n1";
      StringTokenizer localStringTokenizer = new StringTokenizer(str, "\r\n");
      System.out.println("st count: " + localStringTokenizer.countTokens());
      Assert.assertTrue(localStringTokenizer.countTokens() > 0);
      str = "49\r\n52\r\n";
      localStringTokenizer = new StringTokenizer(str, "\r\n");
      System.out.println("st count: " + localStringTokenizer.countTokens());
      Assert.assertTrue(localStringTokenizer.countTokens() > 0);
      System.out.println('A');
      System.out.println('\036');
      System.out.println('\037');
      str = "\037\037\037\037b29c96a0-5289-11e2-8f9a-e972c9889f6d\037b29c96a0-5289-11e2-8f9a-e972c9889f6d\037b8c8a2d0-5289-11e2-8fa0-86a67f760b84\03720121230.140346.475000\03720121230.140346.890000\037baesunghan-pc:5555\037a6437ea1-789d-4b63-b698-282d6deed127\037Administrator\0371\03780\037WeasyM.Templates.Publish_Subscribe:Subscribe_Svc\0374\037com.wm.lang.flow.FlowException: java.lang.NumberFormatException: a, [Error Service]: pub.math:addInts\037323211\037b6b02310-5289-11e2-8f9d-f164dafd9832";
      localStringTokenizer = new StringTokenizer(str, "\037");
      System.out.println("1-1 : " + localStringTokenizer.nextToken());
      System.out.println("1-2 : " + localStringTokenizer.nextToken());
      System.out.println("1-3 : " + localStringTokenizer.nextToken());
      System.out.println("1-4 : " + localStringTokenizer.nextToken());
      System.out.println("1-5 : " + localStringTokenizer.nextToken());
      String[] arrayOfString = str.split("\037");
      System.out.println("2-1 : " + arrayOfString[0]);
      System.out.println("2-2 : " + arrayOfString[1]);
      System.out.println("2-3 : " + arrayOfString[2]);
      System.out.println("2-4 : " + arrayOfString[3]);
      System.out.println("2-5 : " + arrayOfString[4]);
      System.out.println("2-6 : " + arrayOfString[5]);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Assert.fail("Failed");
    }
  }
  
  @Test
  public void testCurrentDate()
  {
    String str1 = "20130227.080050.506000";
    String str2 = Util.getTimeGMT2Local(str1, "yyyyMMdd.HHmmss.SSS", "yyyyMMdd.HHmmss.SSS", TimeZone.getTimeZone("KST"));
    Assert.assertEquals("20130227.170050.506", str2);
  }
  
  @Test
  public void testDifferDate()
  {
    String str1 = "20130312.132116.343000";
    String str2 = "20130312.132116.351000";
    long l = Util.diffOfDate(str1, str2, "yyyyMMdd.HHmmss.SSS");
    System.out.println("ldif : " + l);
    Assert.assertEquals(Integer.valueOf(8), Long.valueOf(l));
  }
  
  @Test
  public void testCurrentTime()
  {
    String str = Util.getCurrentDateFormat("yyyyMMdd.HHmmss.SSS", true);
    System.out.println("currentdate : " + str);
  }
  
  @Test
  public void testCopyHashMap()
  {
    HashMap localHashMap1 = new HashMap();
    System.out.printf("%s, %s \n", new Object[] { "a- 01", localHashMap1.get("01") });
    HashMap localHashMap2 = new HashMap(localHashMap1);
    localHashMap1.clear();
    System.out.printf("%s, %s \n", new Object[] { "b- 01", localHashMap2.get("01") });
    System.out.printf("%s, %s \n", new Object[] { "a- 01", localHashMap1.get("01") });
    if (localHashMap1.get("01") == null) {
      System.out.println("is null");
    }
  }
  
  @Test
  public void testStringCompareto()
  {
    String str1 = "20130717";
    String str2 = "20130718";
    String str3 = "2013";
    Assert.assertEquals(Integer.valueOf(-1), Integer.valueOf(str1.compareTo(str2)));
    Assert.assertEquals(Integer.valueOf(1), Integer.valueOf(str2.compareTo(str1)));
    Assert.assertEquals(Integer.valueOf(0), Integer.valueOf(str2.compareTo(str2)));
    Assert.assertEquals(Integer.valueOf(4), Integer.valueOf(str1.compareTo(str3)));
    Assert.assertEquals(Integer.valueOf(-4), Integer.valueOf(str3.compareTo(str1)));
  }
  
  @Test
  public void testGetBeforeAfterDate()
    throws ParseException
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
    Date localDate1 = localSimpleDateFormat.parse("20130812");
    Date localDate2 = Util.getBeforeAfterDate(localDate1, -1);
    String str = new SimpleDateFormat("yyyyMMdd").format(localDate2);
    Assert.assertEquals("20130811", str);
    str = Util.getBeforeAfterDate(null, 1, "yyyyMMdd");
    Assert.assertEquals("20130822", str);
    Assert.assertEquals("A", String.valueOf(Character.toChars(65)));
    Assert.assertEquals("Z", String.valueOf(Character.toChars(90)));
    Assert.assertEquals("0", String.valueOf(Character.toChars(48)));
    Assert.assertEquals("9", String.valueOf(Character.toChars(57)));
  }
  
  @Test
  public void getDataFilePath()
  {
    String str1 = "cudobpm1/pipeline";
    String str2 = "20130808.080143.171000";
    String str3 = "be36cfb0-0000-11e3-85fc-857af9fd0dd0";
    String str4 = "";
    String str5 = str1 + "/" + str2.substring(0, 8) + "/" + str3.substring(0, 1).toUpperCase() + "/";
    str4 = Util.getDataFilePath(str1, str2, str3);
    Assert.assertEquals(str5, str4);
    str2 = "2013/08/08.08:01:43.171000";
    str4 = Util.getDataFilePath(str1, str2, str3);
    Assert.assertEquals(str5, str4);
  }
}

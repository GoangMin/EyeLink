package m2u.eyelink.util;


import java.io.File;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.UUID;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Util
{
  private static final Logger LOG = LoggerFactory.getLogger(Util.class);
  
  public static String nulToStr(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2;
    }
    return paramString1;
  }
  
  public static String getToday()
  {
    return new java.sql.Date(System.currentTimeMillis()).toString();
  }
  
  public static Timestamp getTimestamp(Object paramObject)
  {
    Timestamp localTimestamp = null;
    if (paramObject == null)
    {
      localTimestamp = new Timestamp(System.currentTimeMillis());
    }
    else if ((paramObject instanceof Timestamp))
    {
      localTimestamp = (Timestamp)paramObject;
    }
    else if ((paramObject instanceof java.sql.Date))
    {
      localTimestamp = new Timestamp(((java.sql.Date)paramObject).getTime());
    }
    else if ((paramObject instanceof Long))
    {
      localTimestamp = new Timestamp(((Long)paramObject).longValue());
    }
    else if ((paramObject instanceof String))
    {
      if (((String)paramObject).trim().equals("")) {
        return null;
      }
      int i = 1;
      long l = 0L;
      try
      {
        l = Long.parseLong((String)paramObject);
      }
      catch (Exception localException)
      {
        i = 0;
      }
      if (i != 0)
      {
        localTimestamp = new Timestamp(l);
      }
      else
      {
        StringTokenizer localStringTokenizer = new StringTokenizer((String)paramObject, " ");
        String[] arrayOfString = new String[2];
        if (localStringTokenizer.hasMoreElements())
        {
          int j = localStringTokenizer.countTokens();
          if (j >= 1) {
            arrayOfString[0] = localStringTokenizer.nextToken();
          }
          if (j >= 2) {
            arrayOfString[1] = localStringTokenizer.nextToken();
          } else {
            arrayOfString[1] = "00:00:00.0";
          }
        }
        localTimestamp = Timestamp.valueOf(arrayOfString[0] + " " + arrayOfString[1]);
      }
    }
    else
    {
      localTimestamp = new Timestamp(System.currentTimeMillis());
    }
    return localTimestamp;
  }
  
  public static String getTimeGMT2Local(String paramString1, String paramString2)
  {
    return getTimeGMT2Local(paramString1, paramString2, TimeZone.getTimeZone(Consts.WEASYM_TIMEZONE));
  }
  
  public static String getTimeGMT2Local(String paramString1, String paramString2, TimeZone paramTimeZone)
  {
    return getTimeGMT2Local(paramString1, paramString2, "yyyy/MM/dd HH:mm:ss SSS", paramTimeZone);
  }
  
  public static String getTimeGMT2Local(String paramString1, String paramString2, String paramString3, TimeZone paramTimeZone)
  {
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return "";
    }
    if (paramString1.length() > 19) {
      paramString1 = paramString1.substring(0, 19);
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString2);
    localSimpleDateFormat.setTimeZone(paramTimeZone);
    java.util.Date localDate = null;
    try
    {
      localDate = localSimpleDateFormat.parse(paramString1);
    }
    catch (ParseException localParseException) {}
    localSimpleDateFormat = new SimpleDateFormat(paramString3);
    String str = localSimpleDateFormat.format(localDate);
    return str;
  }
  
  public static String getTimeLocal2GMT(String paramString1, String paramString2)
  {
    return getTimeLocal2GMT(paramString1, paramString2, "yyyy/MM/dd HH:mm:ss SSS");
  }
  
  public static String getTimeLocal2GMT(String paramString1, String paramString2, String paramString3)
  {
    if ((paramString1 == null) || ("".equals(paramString1))) {
      return "";
    }
    if (paramString1.length() > 19) {
      paramString1 = paramString1.substring(0, 19);
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString2);
    java.util.Date localDate = null;
    try
    {
      localDate = localSimpleDateFormat.parse(paramString1);
    }
    catch (ParseException localParseException) {}
    localSimpleDateFormat = new SimpleDateFormat(paramString3);
    localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
    String str = localSimpleDateFormat.format(localDate);
    return str;
  }
  
  public static String getCurrentDateFormat(String paramString, boolean paramBoolean)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      paramString = "yyyy/MM/dd HH:mm:ss";
    }
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString);
    String str = "";
    if (paramBoolean)
    {
      java.util.Date localDate = new java.util.Date();
      localSimpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
      str = localSimpleDateFormat.format(localDate);
    }
    else
    {
      str = localSimpleDateFormat.format(getTimestamp(null));
    }
    return str;
  }
  
  public static long diffOfDate(String paramString1, String paramString2, String paramString3)
  {
    long l1 = 0L;
    try
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat(paramString3);
      if (paramString1.length() > 19) {
        paramString1 = paramString1.substring(0, 19);
      }
      if (paramString2.length() > 19) {
        paramString2 = paramString2.substring(0, 19);
      }
      java.util.Date localDate1 = localSimpleDateFormat.parse(paramString1);
      java.util.Date localDate2 = localSimpleDateFormat.parse(paramString2);
      long l2 = localDate2.getTime() - localDate1.getTime();
      l1 = l2;
    }
    catch (Exception localException)
    {
      LOG.error("", localException);
    }
    return l1;
  }
  
  public static java.util.Date getBeforeAfterDate(java.util.Date paramDate, int paramInt)
  {
    java.util.Date localDate1 = new java.util.Date();
    java.util.Date localDate2 = new java.util.Date();
    if (paramDate != null) {
      localDate1 = paramDate;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(localDate1);
    localCalendar.add(5, paramInt);
    localDate2 = localCalendar.getTime();
    return localDate2;
  }
  
  public static String getBeforeAfterDate(java.util.Date paramDate, int paramInt, String paramString)
  {
    java.util.Date localDate = getBeforeAfterDate(paramDate, paramInt);
    return new SimpleDateFormat(paramString).format(localDate);
  }
  
  public static String Lpad(String paramString1, int paramInt, String paramString2)
  {
    String str = paramString1;
    int i = paramInt - str.length();
    for (int j = 0; j < i; j++) {
      str = paramString2 + str;
    }
    return str;
  }
  
  public static String Lpad(int paramInt1, int paramInt2, String paramString)
  {
    String str = Integer.toString(paramInt1);
    int i = paramInt2 - str.length();
    for (int j = 0; j < i; j++) {
      str = paramString + str;
    }
    return str;
  }
  
  public static String Lpad(long paramLong, int paramInt, String paramString)
  {
    String str = Long.toString(paramLong);
    int i = paramInt - str.length();
    for (int j = 0; j < i; j++) {
      str = paramString + str;
    }
    return str;
  }
  
  public static String getElementValue(Node paramNode, String paramString)
  {
    String str = "";
    try
    {
      if (paramNode.getNodeType() == 1)
      {
        Element localElement1 = (Element)paramNode;
        NodeList localNodeList1 = localElement1.getElementsByTagName(paramString);
        Element localElement2 = (Element)localNodeList1.item(0);
        NodeList localNodeList2 = null;
        try
        {
          localNodeList2 = localElement2.getChildNodes();
        }
        catch (NullPointerException localNullPointerException1)
        {
          LOG.error("tagName (" + paramString + ") is not found!!!", localNullPointerException1);
        }
        try
        {
          str = localNodeList2.item(0).getNodeValue();
        }
        catch (NullPointerException localNullPointerException2) {}
      }
    }
    catch (Exception localException)
    {
      LOG.error("tagName (" + paramString + ") occur Error!!!", localException);
    }
    return str;
  }
  
  public static byte[] discardWhitespace(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
    int i = 0;
    for (int j = 0; j < paramArrayOfByte.length; j++) {
      switch (paramArrayOfByte[j])
      {
      case 10: 
      case 13: 
        break;
      default: 
        arrayOfByte1[(i++)] = paramArrayOfByte[j];
      }
    }
    byte[] arrayOfByte2 = new byte[i];
    System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 0, i);
    return arrayOfByte2;
  }
  
  public static String discardWhitespace(String paramString)
  {
    return discardWhitespace(paramString, " ");
  }
  
  public static String discardWhitespace(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      paramString1 = paramString1.replaceAll("\r", paramString2);
      paramString1 = paramString1.replaceAll("\n", paramString2);
    }
    return paramString1;
  }
  
  public Document readXMLFile(String paramString)
  {
    Document localDocument = null;
    try
    {
      File localFile = new File(paramString);
      DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
      DocumentBuilder localDocumentBuilder = localDocumentBuilderFactory.newDocumentBuilder();
      localDocument = localDocumentBuilder.parse(localFile);
    }
    catch (Exception localException)
    {
      LOG.error(localException.toString());
    }
    return localDocument;
  }
  
  public static boolean isNotNullandNotBlank(String paramString)
  {
    return (paramString != null) && (!"".equals(paramString));
  }
  
  public static boolean hasPrefix(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2);
    return i == 0;
  }
  
  public static boolean isCellNumber(String paramString)
  {
    return (hasPrefix(paramString, "010")) || (hasPrefix(paramString, "011")) || (hasPrefix(paramString, "016")) || (hasPrefix(paramString, "017")) || (hasPrefix(paramString, "018")) || (hasPrefix(paramString, "019"));
  }
  
  public static String changeInterNaToDome(String paramString)
  {
    String str = paramString;
    if (isCellNumber(paramString)) {
      str = paramString;
    } else if (hasPrefix(paramString, "+82"))
    {
      if (isCellNumber(replacePreString(paramString, "+82", "0"))) {
        str = replacePreString(paramString, "+82", "0");
      } else if (isCellNumber(replacePreString(paramString, "+82", ""))) {
        str = replacePreString(paramString, "+82", "");
      }
    }
    else if (hasPrefix(paramString, "82")) {
      if (isCellNumber(replacePreString(paramString, "82", "0"))) {
        str = replacePreString(paramString, "82", "0");
      } else if (isCellNumber(replacePreString(paramString, "82", ""))) {
        str = replacePreString(paramString, "82", "");
      }
    }
    return str;
  }
  
  public static String replacePreString(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if (hasPrefix(paramString1, paramString2))
    {
      str = paramString1.substring(paramString2.length());
      str = paramString3 + str;
    }
    else
    {
      str = paramString1;
    }
    return str;
  }
  
  public static String fillzero(int paramInt)
  {
    String str = "";
    if (paramInt >= 10000) {
      str = "" + paramInt;
    } else if (paramInt >= 1000) {
      str = "0" + paramInt;
    } else if (paramInt >= 100) {
      str = "00" + paramInt;
    } else if (paramInt >= 10) {
      str = "000" + paramInt;
    } else {
      str = "0000" + paramInt;
    }
    return str;
  }
  
  public static String getNewUUID()
  {
    return UUID.randomUUID().toString();
  }
  
  public static String getDataFilePath(String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    paramString2 = paramString2.replace("/", "").substring(0, 8);
    str = paramString1 + "/" + paramString2 + "/" + paramString3.substring(0, 1).toUpperCase() + "/";
    return str;
  }
}

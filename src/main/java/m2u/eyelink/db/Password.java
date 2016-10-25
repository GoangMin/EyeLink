package m2u.eyelink.db;


import java.io.PrintStream;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Hex;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import m2u.eyelink.util.LogUtil;

public class Password
{
  private static Cipher cipher;
  private static SecretKeySpec skeySpec;
  private static final String ALGORITHM = "AES";
  private static String sKeyString = "ab0a478e8f96860bca9513498864efe8";
  
  private static SecretKey generateKey()
    throws Exception
  {
    KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
    localKeyGenerator.init(128);
    SecretKey localSecretKey = localKeyGenerator.generateKey();
    return localSecretKey;
  }
  
  public static String newGenerateKey()
    throws Exception
  {
    SecretKey localSecretKey = generateKey();
    sKeyString = Hex.encodeHexString(localSecretKey.getEncoded());
    LogUtil.log(10000, "newGenerateKey - sKeyString : " + sKeyString);
    return sKeyString;
  }
  
  public static String encrypt(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Encryption(paramString, skeySpec, cipher);
      paramString = new BASE64Encoder().encode(arrayOfByte);
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String decrypt(String paramString)
  {
    try
    {
      byte[] arrayOfByte = Decryption(new BASE64Decoder().decodeBuffer(paramString), skeySpec, cipher);
      paramString = new String(arrayOfByte);
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static byte[] Encryption(String paramString, Key paramKey, Cipher paramCipher)
    throws Exception
  {
    paramCipher.init(1, paramKey);
    byte[] arrayOfByte = paramCipher.doFinal(paramString.getBytes());
    return arrayOfByte;
  }
  
  public static byte[] Decryption(byte[] paramArrayOfByte, Key paramKey, Cipher paramCipher)
    throws Exception
  {
    paramCipher.init(2, paramKey);
    byte[] arrayOfByte = paramCipher.doFinal(paramArrayOfByte);
    return arrayOfByte;
  }
  
  public static void main(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length < 1)
    {
      System.out.println("Please input arguement!(encrypt/decrypt password)");
      return;
    }
    String str1 = paramArrayOfString[0];
    String str2 = paramArrayOfString[1];
    String str3 = "";
    if ("encrypt".equals(str1))
    {
      str3 = encrypt(str2);
      System.out.println(" Input : " + str2 + ", EnCrypt : " + str3);
    }
    else if ("decrypt".equals(str1))
    {
      str3 = decrypt(str2);
      System.out.println(" Input : " + str2 + ", DnCrypt : " + str3);
    }
  }
  
  static
  {
    try
    {
      KeyGenerator localKeyGenerator = KeyGenerator.getInstance("AES");
      localKeyGenerator.init(128);
      skeySpec = new SecretKeySpec(Hex.decodeHex(sKeyString.toCharArray()), "AES");
      cipher = Cipher.getInstance("AES");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}

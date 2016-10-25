package m2u.eyelink.util;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileUtil
{
  private static final Logger LOG = LoggerFactory.getLogger(FileUtil.class);;
  
  public static void makeDir(String paramString)
  {
    File localFile = new File(paramString);
    localFile.mkdirs();
  }
  
  public static Boolean existFile(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.exists()) {
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(false);
  }
  
  public static void makeFile(String paramString)
  {
    File localFile = new File(paramString);
    try
    {
      localFile.createNewFile();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static boolean deleteFile(String paramString)
  {
    File localFile = new File(paramString);
    return localFile.delete();
  }
  
  public static void copyFile(String paramString1, String paramString2)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString1);
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
      int i = 0;
      while ((i = localFileInputStream.read()) != -1) {
        localFileOutputStream.write(i);
      }
      localFileInputStream.close();
      localFileOutputStream.close();
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static void moveFile(String paramString1, String paramString2)
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream(paramString1);
      FileOutputStream localFileOutputStream = new FileOutputStream(paramString2);
      int i = 0;
      while ((i = localFileInputStream.read()) != -1) {
        localFileOutputStream.write(i);
      }
      localFileInputStream.close();
      localFileOutputStream.close();
      deleteFile(paramString1);
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  public static boolean moveFile2(String paramString1, String paramString2)
  {
    try
    {
      File localFile1 = new File(paramString1);
      File localFile2 = new File(paramString2);
      return localFile1.renameTo(localFile2);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static List<File> getDirFileList(String paramString)
  {
    List localList = null;
    File localFile = new File(paramString);
    if (localFile.exists())
    {
      File[] arrayOfFile = localFile.listFiles();
      localList = Arrays.asList(arrayOfFile);
    }
    return localList;
  }
  
  public static void fileRead(String paramString1, String paramString2)
  {
    BufferedReader localBufferedReader = null;
    String str = "";
    LOG.debug("----- File Encoding : [" + paramString2 + "]");
    try
    {
      File localFile = new File(paramString1);
      if ((localFile.exists()) && (localFile.isFile()) && (localFile.length() > 0L))
      {
        localBufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(localFile), paramString2));
        char[] arrayOfChar = new char[(int)localFile.length()];
        localBufferedReader.read(arrayOfChar);
        str = new String(arrayOfChar);
        LOG.debug(str);
      }
      return;
    }
    catch (Exception localException2)
    {
      LOG.error("", localException2);
    }
    finally
    {
      if (localBufferedReader != null) {
        try
        {
          localBufferedReader.close();
        }
        catch (Exception localException4) {}
      }
    }
  }
  
  public static void fileWrite(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    try
    {
      OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(new FileOutputStream(paramString1, paramBoolean), paramString3);
      localOutputStreamWriter.write(paramString2);
      localOutputStreamWriter.close();
    }
    catch (Exception localException)
    {
      LOG.error("", localException);
    }
  }
  
  public static void fileWriteDirBuf(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    try
    {
      FileOutputStream localFileOutputStream = null;
      FileChannel localFileChannel = null;
      try
      {
        localFileOutputStream = new FileOutputStream(paramString1, paramBoolean);
        localFileChannel = localFileOutputStream.getChannel();
        ByteBuffer localByteBuffer = ByteBuffer.allocateDirect(paramString2.length() * 2);
        localByteBuffer.clear();
        localByteBuffer.put(paramString2.getBytes());
        localByteBuffer.flip();
        localFileChannel.write(localByteBuffer);
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        LOG.error("", localFileNotFoundException);
      }
      catch (IOException localIOException)
      {
        LOG.error("", localIOException);
      }
      catch (Exception localException8)
      {
        LOG.error("", localException8);
      }
      finally
      {
        try
        {
          localFileChannel.close();
        }
        catch (Exception localException11) {}
        try
        {
          localFileOutputStream.close();
        }
        catch (Exception localException12) {}
      }
      return;
    }
    catch (Exception localException1)
    {
      LOG.error("", localException1);
    }
  }
}


package m2u.eyelink.db;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m2u.eyelink.util.LogUtil;
import m2u.eyelink.util.Util;

public class SaveBlobToFile
  implements Runnable
{
  private static final Logger LOG = LoggerFactory.getLogger(SaveBlobToFile.class);
  private Blob aBlob = null;
  private String fileName = "";
  
  public SaveBlobToFile(Blob paramBlob, String paramString)
  {
    this.aBlob = paramBlob;
    this.fileName = paramString;
  }
  
  public void saveBlob()
  {
    long l1 = System.currentTimeMillis();
    try
    {
      InputStream localInputStream = this.aBlob.getBinaryStream();
      FileOutputStream localFileOutputStream = new FileOutputStream(this.fileName);
      int i = 0;
      while ((i = localInputStream.read()) != -1) {
        localFileOutputStream.write(i);
      }
      try
      {
        localFileOutputStream.close();
      }
      catch (Exception localException2) {}
      try
      {
        localInputStream.close();
      }
      catch (Exception localException3) {}
    }
    catch (Exception localException1)
    {
      LOG.error(localException1.toString());
    }
    long l2 = System.currentTimeMillis();
    LOG.trace("saveBlob finished, time : " + (l2 - l1) / 1000.0D);
  }
  
  public void run()
  {
    saveBlob();
  }
}

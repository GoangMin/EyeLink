package m2u.eyelink;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import m2u.eyelink.util.FileUtil;

public class testFileUtil
{
  public void testFile()
    throws Exception
  {
    String str1 = "C:/Users/BLOW/Downloads/tmp1/tmp1/org";
    String str2 = "C:\\Users\\BLOW\\Desktop";
    List localList = FileUtil.getDirFileList(str1);
    Object localObject;
    for (int i = 0; i < localList.size(); i++) {
      localObject = ((File)localList.get(i)).getName();
    }
    String str3 = "C:/data/weasym/queue/q1";
    if (FileUtil.existFile(str3).booleanValue()) {
      localObject = new File(str3);
    } else {
      FileUtil.makeFile(str3);
    }
  }
  
  @Test
  public void testSaveFileToObject()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("1", "aaa");
      localHashMap.put("2", "bbb");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add("cccc");
      localArrayList.add("ddd");
      FileOutputStream localFileOutputStream = new FileOutputStream("c:/data/test.dat");
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localFileOutputStream);
      localObjectOutputStream.writeObject(localHashMap);
      localObjectOutputStream.writeObject(localArrayList);
      localObjectOutputStream.close();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  @Test
  public void testReadObjectToFile()
  {
    try
    {
      FileInputStream localFileInputStream = new FileInputStream("c:/data/test.dat");
      ObjectInputStream localObjectInputStream = new ObjectInputStream(localFileInputStream);
      Map localMap = (Map)localObjectInputStream.readObject();
      Assert.assertEquals("aaa", localMap.get("1"));
      Assert.assertEquals("bbb", localMap.get("2"));
      List localList = (List)localObjectInputStream.readObject();
      Assert.assertEquals("cccc", localList.get(0));
      Assert.assertEquals("ddd", localList.get(1));
      localObjectInputStream.close();
    }
    catch (Exception localException) {}
  }
  
  public void testDeleteFile()
  {
    String str = "c:/Data/WeasyM/data/cudobpm1/detail/42e343c0-086b-11e3-9d87-cc15828abd3e.dat";
    Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(FileUtil.deleteFile(str)));
  }
  
  @Test
  public void testMoveFile2()
  {
    String str1 = "c:/Data/WeasyM/data/cudobpm1/detail/e2d0e600-03d7-11e3-94d7-9c76a634daae.dat";
    String str2 = "c:/Data/arch2/cudobpm1/detail/e2d0e600-03d7-11e3-94d7-9c76a634daae.dat";
    Assert.assertEquals(Boolean.valueOf(true), Boolean.valueOf(FileUtil.moveFile2(str1, str2)));
  }
}

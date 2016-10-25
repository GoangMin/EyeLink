package m2u.eyelink.util;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public class LogUtil
{
  static final String className = LogUtil.class.getName();
  static final Logger LOG = Logger.getLogger(getInvokingClassName());
  public static final int LEVEL_OFF = 0;
  public static final int LEVEL_TRACE = 5000;
  public static final int LEVEL_DEBUG = 10000;
  public static final int LEVEL_INFO = 20000;
  public static final int LEVEL_WARN = 30000;
  public static final int LEVEL_ERROR = 40000;
  public static final int LEVEL_FATAL = 50000;
  
  public static String getInvokingClassName()
  {
    return new Throwable().getStackTrace()[1].getClassName();
  }
  
  public static Logger getLogger()
  {
    Throwable localThrowable = new Throwable();
    StackTraceElement localStackTraceElement = localThrowable.getStackTrace()[1];
    Logger localLogger = Logger.getLogger(localStackTraceElement.getClassName());
    return localLogger;
  }
  
  public static void setLevel(Level paramLevel)
  {
    LOG.setLevel(paramLevel);
  }
  
  public static void log(int paramInt, String paramString)
  {
    if (paramInt != 0) {
      if (paramInt == 5000) {
        LOG.trace(paramString);
      } else if (paramInt == 10000) {
        LOG.debug(paramString);
      } else if (paramInt == 20000) {
        LOG.info(paramString);
      } else if (paramInt == 30000) {
        LOG.warn(paramString);
      } else if (paramInt == 40000) {
        LOG.error(paramString);
      } else if (paramInt == 50000) {
        LOG.fatal(paramString);
      }
    }
  }
  
  public static void log(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 40000) {
      LOG.error(paramString, paramThrowable);
    } else if (paramInt == 50000) {
      LOG.fatal(paramString, paramThrowable);
    }
  }
}

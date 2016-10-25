package m2u.eyelink.modelbean;

public class MailSMSBean
{
  private boolean WEASYM_MAIL_USE = false;
  private String WEASYM_MAIL_TYPE = "";
  private String WEASYM_MAIL_URL = "";
  private String WEASYM_MAIL_HOST = "";
  private int WEASYM_MAIL_PORT = 25;
  private String WEASYM_MAIL_USERID = "";
  private String WEASYM_MAIL_PASSWORD = "";
  private String WEASYM_MAIL_FROM_ADDRESS = "";
  private String WEASYM_MAIL_FROM_NAME = "";
  private String WEASYM_MAIL_CONTENTS_SIGN = "";
  private int WEASYM_MAIL_REPEAT_CNT = 3;
  private String WEASYM_MAIL_DB_TYPE = "";
  private String WEASYM_MAIL_DB_SERVER = "";
  private String WEASYM_MAIL_DB_PORT = "";
  private String WEASYM_MAIL_DB_DBNAME = "";
  private String WEASYM_MAIL_DB_USERID = "";
  private String WEASYM_MAIL_DB_PASSWORD = "";
  private int WEASYM_MAIL_DB_INITCONN = 0;
  private int WEASYM_MAIL_DB_MAXCONN = 0;
  private int WEASYM_MAIL_DB_MAXWAIT = 0;
  private String WEASYM_MAIL_DB_QUERY_HEADER = "";
  private String WEASYM_MAIL_DB_QUERY_SENDER = "";
  private boolean WEASYM_SMS_USE = false;
  private String WEASYM_SMS_TYPE = "";
  private String WEASYM_SMS_DB_TYPE = "";
  private String WEASYM_SMS_DB_URL = "";
  private String WEASYM_SMS_DB_SERVER = "";
  private String WEASYM_SMS_DB_PORT = "";
  private String WEASYM_SMS_DB_DBNAME = "";
  private String WEASYM_SMS_DB_USERID = "";
  private String WEASYM_SMS_DB_PASSWORD = "";
  private int WEASYM_SMS_DB_INITCONN = 0;
  private int WEASYM_SMS_DB_MAXCONN = 0;
  private int WEASYM_SMS_DB_MAXWAIT = 0;
  private String WEASYM_SMS_DB_SENDER = "";
  private String WEASYM_SMS_DB_QUERY = "";
  
  public boolean isMAIL_USE()
  {
    return this.WEASYM_MAIL_USE;
  }
  
  public void setMAIL_USE(String paramString)
  {
    this.WEASYM_MAIL_USE = ("Y".equals(paramString));
  }
  
  public String getMAIL_TYPE()
  {
    return this.WEASYM_MAIL_TYPE;
  }
  
  public void setMAIL_TYPE(String paramString)
  {
    this.WEASYM_MAIL_TYPE = paramString;
  }
  
  public String getMAIL_HOST()
  {
    return this.WEASYM_MAIL_HOST;
  }
  
  public void setMAIL_HOST(String paramString)
  {
    this.WEASYM_MAIL_HOST = paramString;
  }
  
  public int getMAIL_PORT()
  {
    return this.WEASYM_MAIL_PORT;
  }
  
  public void setMAIL_PORT(String paramString)
  {
    this.WEASYM_MAIL_PORT = Integer.parseInt(paramString);
  }
  
  public String getMAIL_USERID()
  {
    return this.WEASYM_MAIL_USERID;
  }
  
  public void setMAIL_USERID(String paramString)
  {
    this.WEASYM_MAIL_USERID = paramString;
  }
  
  public String getMAIL_PASSWORD()
  {
    return this.WEASYM_MAIL_PASSWORD;
  }
  
  public void setMAIL_PASSWORD(String paramString)
  {
    this.WEASYM_MAIL_PASSWORD = paramString;
  }
  
  public String getMAIL_FROM_ADDRESS()
  {
    return this.WEASYM_MAIL_FROM_ADDRESS;
  }
  
  public void setMAIL_FROM_ADDRESS(String paramString)
  {
    this.WEASYM_MAIL_FROM_ADDRESS = paramString;
  }
  
  public String getMAIL_FROM_NAME()
  {
    return this.WEASYM_MAIL_FROM_NAME;
  }
  
  public void setMAIL_FROM_NAME(String paramString)
  {
    this.WEASYM_MAIL_FROM_NAME = paramString;
  }
  
  public String getMAIL_CONTENTS_SIGN()
  {
    return this.WEASYM_MAIL_CONTENTS_SIGN;
  }
  
  public void setMAIL_CONTENTS_SIGN(String paramString)
  {
    this.WEASYM_MAIL_CONTENTS_SIGN = paramString;
  }
  
  public int getMAIL_REPEAT_CNT()
  {
    return this.WEASYM_MAIL_REPEAT_CNT;
  }
  
  public void setMAIL_REPEAT_CNT(int paramInt)
  {
    this.WEASYM_MAIL_REPEAT_CNT = paramInt;
  }
  
  public String getMAIL_DB_TYPE()
  {
    return this.WEASYM_MAIL_DB_TYPE;
  }
  
  public void setMAIL_DB_TYPE(String paramString)
  {
    this.WEASYM_MAIL_DB_TYPE = paramString;
  }
  
  public String getMAIL_DB_SERVER()
  {
    return this.WEASYM_MAIL_DB_SERVER;
  }
  
  public void setMAIL_DB_SERVER(String paramString)
  {
    this.WEASYM_MAIL_DB_SERVER = paramString;
  }
  
  public String getMAIL_DB_PORT()
  {
    return this.WEASYM_MAIL_DB_PORT;
  }
  
  public void setMAIL_DB_PORT(String paramString)
  {
    this.WEASYM_MAIL_DB_PORT = paramString;
  }
  
  public String getMAIL_DB_DBNAME()
  {
    return this.WEASYM_MAIL_DB_DBNAME;
  }
  
  public void setMAIL_DB_DBNAME(String paramString)
  {
    this.WEASYM_MAIL_DB_DBNAME = paramString;
  }
  
  public String getMAIL_DB_USERID()
  {
    return this.WEASYM_MAIL_DB_USERID;
  }
  
  public void setMAIL_DB_USERID(String paramString)
  {
    this.WEASYM_MAIL_DB_USERID = paramString;
  }
  
  public String getMAIL_DB_PASSWORD()
  {
    return this.WEASYM_MAIL_DB_PASSWORD;
  }
  
  public void setMAIL_DB_PASSWORD(String paramString)
  {
    this.WEASYM_MAIL_DB_PASSWORD = paramString;
  }
  
  public int getMAIL_DB_INITCONN()
  {
    return this.WEASYM_MAIL_DB_INITCONN;
  }
  
  public void setMAIL_DB_INITCONN(String paramString)
  {
    this.WEASYM_MAIL_DB_INITCONN = Integer.parseInt(paramString);
  }
  
  public int getMAIL_DB_MAXCONN()
  {
    return this.WEASYM_MAIL_DB_MAXCONN;
  }
  
  public void setMAIL_DB_MAXCONN(String paramString)
  {
    this.WEASYM_MAIL_DB_MAXCONN = Integer.parseInt(paramString);
  }
  
  public int getMAIL_DB_MAXWAIT()
  {
    return this.WEASYM_MAIL_DB_MAXWAIT;
  }
  
  public void setMAIL_DB_MAXWAIT(String paramString)
  {
    this.WEASYM_MAIL_DB_MAXWAIT = Integer.parseInt(paramString);
  }
  
  public String getMAIL_DB_QUERY_HEADER()
  {
    return this.WEASYM_MAIL_DB_QUERY_HEADER;
  }
  
  public void setMAIL_DB_QUERY_HEADER(String paramString)
  {
    this.WEASYM_MAIL_DB_QUERY_HEADER = paramString;
  }
  
  public String getMAIL_DB_QUERY_SENDER()
  {
    return this.WEASYM_MAIL_DB_QUERY_SENDER;
  }
  
  public void setMAIL_DB_QUERY_SENDER(String paramString)
  {
    this.WEASYM_MAIL_DB_QUERY_SENDER = paramString;
  }
  
  public boolean isSMS_USE()
  {
    return this.WEASYM_SMS_USE;
  }
  
  public void setSMS_USE(String paramString)
  {
    this.WEASYM_SMS_USE = ("Y".equals(paramString));
  }
  
  public String getSMS_TYPE()
  {
    return this.WEASYM_SMS_TYPE;
  }
  
  public void setSMS_TYPE(String paramString)
  {
    this.WEASYM_SMS_TYPE = paramString;
  }
  
  public String getSMS_DB_TYPE()
  {
    return this.WEASYM_SMS_DB_TYPE;
  }
  
  public void setSMS_DB_TYPE(String paramString)
  {
    this.WEASYM_SMS_DB_TYPE = paramString;
  }
  
  public String getSMS_DB_SERVER()
  {
    return this.WEASYM_SMS_DB_SERVER;
  }
  
  public void setSMS_DB_SERVER(String paramString)
  {
    this.WEASYM_SMS_DB_SERVER = paramString;
  }
  
  public String getSMS_DB_PORT()
  {
    return this.WEASYM_SMS_DB_PORT;
  }
  
  public void setSMS_DB_PORT(String paramString)
  {
    this.WEASYM_SMS_DB_PORT = paramString;
  }
  
  public String getSMS_DB_DBNAME()
  {
    return this.WEASYM_SMS_DB_DBNAME;
  }
  
  public void setSMS_DB_DBNAME(String paramString)
  {
    this.WEASYM_SMS_DB_DBNAME = paramString;
  }
  
  public String getSMS_DB_USERID()
  {
    return this.WEASYM_SMS_DB_USERID;
  }
  
  public void setSMS_DB_USERID(String paramString)
  {
    this.WEASYM_SMS_DB_USERID = paramString;
  }
  
  public String getSMS_DB_PASSWORD()
  {
    return this.WEASYM_SMS_DB_PASSWORD;
  }
  
  public void setSMS_DB_PASSWORD(String paramString)
  {
    this.WEASYM_SMS_DB_PASSWORD = paramString;
  }
  
  public int getSMS_DB_INITCONN()
  {
    return this.WEASYM_SMS_DB_INITCONN;
  }
  
  public void setSMS_DB_INITCONN(String paramString)
  {
    this.WEASYM_SMS_DB_INITCONN = Integer.parseInt(paramString);
  }
  
  public int getSMS_DB_MAXCONN()
  {
    return this.WEASYM_SMS_DB_MAXCONN;
  }
  
  public void setSMS_DB_MAXCONN(String paramString)
  {
    this.WEASYM_SMS_DB_MAXCONN = Integer.parseInt(paramString);
  }
  
  public int getSMS_DB_MAXWAIT()
  {
    return this.WEASYM_SMS_DB_MAXWAIT;
  }
  
  public void setSMS_DB_MAXWAIT(String paramString)
  {
    this.WEASYM_SMS_DB_MAXWAIT = Integer.parseInt(paramString);
  }
  
  public String getSMS_DB_SENDER()
  {
    return this.WEASYM_SMS_DB_SENDER;
  }
  
  public void setSMS_DB_SENDER(String paramString)
  {
    this.WEASYM_SMS_DB_SENDER = paramString;
  }
  
  public String getSMS_DB_QUERY()
  {
    return this.WEASYM_SMS_DB_QUERY;
  }
  
  public void setSMS_DB_QUERY(String paramString)
  {
    this.WEASYM_SMS_DB_QUERY = paramString;
  }
  
  public void setMAIL_DB_URL(String paramString)
  {
    this.WEASYM_MAIL_URL = paramString;
  }
  
  public String getMAIL_DB_URL()
  {
    return this.WEASYM_MAIL_URL;
  }
  
  public void setSMS_DB_URL(String paramString)
  {
    this.WEASYM_SMS_DB_URL = paramString;
  }
  
  public String getSMS_DB_URL()
  {
    return this.WEASYM_SMS_DB_URL;
  }
}

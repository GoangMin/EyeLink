package m2u.eyelink.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m2u.eyelink.modelbean.FetchServerBean;
import m2u.eyelink.util.LogUtil;
import m2u.eyelink.util.Util;
import m2u.eyelink.util.Password;

public class OracleConnectionManager
  extends ConnectionManager
{
  private static final Logger LOG = LoggerFactory.getLogger(OracleConnectionManager.class);
  
  public OracleConnectionManager() {}
  
  public OracleConnectionManager(FetchServerBean paramFetchServerBean)
  {
    this.poolName = paramFetchServerBean.getNAME();
    String str1 = "oracle.jdbc.driver.OracleDriver";
    String str2 = "jdbc:oracle:thin:@";
    String str3 = str2;
    if ((paramFetchServerBean.getDB_URL() == null) || ("".equals(paramFetchServerBean.getDB_URL()))) {
      str3 = str3 + paramFetchServerBean.getDB_SERVER() + ":" + paramFetchServerBean.getDB_PORT() + ":" + paramFetchServerBean.getDB_DBNAME();
    } else {
      str3 = str3 + paramFetchServerBean.getDB_URL();
    }
    LOG.debug("OracleConnectionManager URL : " + str3);
    LOG.debug("OracleConnectionManager UserID : " + paramFetchServerBean.getDB_USERID() + ", Password : " + paramFetchServerBean.getDB_PASSWORD());
    paramFetchServerBean.setDB_PASSWORD(Password.decrypt(paramFetchServerBean.getDB_PASSWORD()));
    this.connMgr = DBConnectionPoolManager.getInstance();
    this.connMgr.init(this.poolName, str1, str3, paramFetchServerBean.getDB_USERID(), paramFetchServerBean.getDB_PASSWORD(), paramFetchServerBean.getDB_MAXCONN(), paramFetchServerBean.getDB_INITCONN(), paramFetchServerBean.getDB_MAXWAIT());
  }
  
  public OracleConnectionManager(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.poolName = paramString1;
    String str1 = "oracle.jdbc.driver.OracleDriver";
    String str2 = "jdbc:oracle:thin";
    String str3 = str2 + ":@" + paramString2 + ":" + paramString3 + ":" + paramString4;
    LOG.debug("OracleConnectionManager URL : " + str3);
    LOG.debug("OracleConnectionManager UserID : " + paramString5 + ", Password : " + paramString6);
    paramString6 = Password.decrypt(paramString6);
    this.connMgr = DBConnectionPoolManager.getInstance();
    this.connMgr.init(this.poolName, str1, str3, paramString5, paramString6, paramInt2, paramInt1, paramInt3);
  }
  
  public Connection getConnection(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, boolean paramBoolean)
  {
    Connection localConnection = null;
    String str1 = "oracle.jdbc.driver.OracleDriver";
    String str2 = "jdbc:oracle:thin:@";
    String str3 = str2;
    if ((paramString1 == null) || ("".equals(paramString1))) {
      str3 = str3 + paramString2 + ":" + paramString3 + ":" + paramString4;
    } else {
      str3 = str3 + paramString1;
    }
    LOG.debug("OracleConnectionManager URL : " + str3);
    LOG.debug("OracleConnectionManager UserID : " + paramString5 + ", Password : " + paramString6);
    paramString6 = Password.decrypt(paramString6);
    try
    {
      Class.forName(str1);
      localConnection = DriverManager.getConnection(str3, paramString5, paramString6);
      localConnection.setAutoCommit(paramBoolean);
    }
    catch (SQLException localSQLException)
    {
      localSQLException.printStackTrace();
      LOG.error(localSQLException.getMessage());
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
      LOG.error(localClassNotFoundException.getMessage());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      LOG.error(localException.getMessage());
    }
    return localConnection;
  }
}

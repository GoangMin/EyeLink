package m2u.eyelink.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import m2u.eyelink.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m2u.eyelink.modelbean.FetchServerBean;
import m2u.eyelink.util.LogUtil;
import m2u.eyelink.util.Password;

public class MssqlConnectionManager
  extends ConnectionManager
{
  private static final Logger LOG = LoggerFactory.getLogger(MssqlConnectionManager.class);
  
  public MssqlConnectionManager() {}
  
  public MssqlConnectionManager(FetchServerBean paramFetchServerBean)
  {
    this.poolName = paramFetchServerBean.getNAME();
    String str1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String str2 = "jdbc:sqlserver://";
    String str3 = str2 + paramFetchServerBean.getDB_SERVER() + ":" + paramFetchServerBean.getDB_PORT() + ";databaseName=" + paramFetchServerBean.getDB_DBNAME();
    LOG.debug("URL : " + str3);
    LOG.debug("UserID : " + paramFetchServerBean.getDB_USERID() + ", Password : " + paramFetchServerBean.getDB_PASSWORD());
    paramFetchServerBean.setDB_PASSWORD(Password.decrypt(paramFetchServerBean.getDB_PASSWORD()));
    this.connMgr = DBConnectionPoolManager.getInstance();
    this.connMgr.init(this.poolName, str1, str3, paramFetchServerBean.getDB_USERID(), paramFetchServerBean.getDB_PASSWORD(), paramFetchServerBean.getDB_MAXCONN(), paramFetchServerBean.getDB_INITCONN(), paramFetchServerBean.getDB_MAXWAIT());
  }
  
  public MssqlConnectionManager(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, int paramInt3)
  {
    this.poolName = paramString1;
    String str1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String str2 = "jdbc:sqlserver://";
    String str3 = str2 + paramString2 + ":" + paramString3 + ";databaseName=" + paramString4;
    LOG.debug("MssqlConnectionManager URL : " + str3);
    LOG.debug("MssqlConnectionManager UserID : " + paramString5 + ", Password : " + paramString6);
    paramString6 = Password.decrypt(paramString6);
    this.connMgr = DBConnectionPoolManager.getInstance();
    this.connMgr.init(this.poolName, str1, str3, paramString5, paramString6, paramInt2, paramInt1, paramInt3);
  }
  
  public Connection getConnection(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, boolean paramBoolean)
  {
    Connection localConnection = null;
    String str1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    String str2 = "jdbc:sqlserver://";
    String str3 = str2 + paramString1 + ":" + paramString2 + ";databaseName=" + paramString3;
    LOG.debug("MssqlConnectionManager URL : " + str3);
    LOG.debug("MssqlConnectionManager UserID : " + paramString4 + ", Password : " + paramString5);
    paramString5 = Password.decrypt(paramString5);
    try
    {
      Class.forName(str1);
      localConnection = DriverManager.getConnection(str3, paramString4, paramString5);
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

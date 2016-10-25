package m2u.eyelink.db;


import java.sql.Connection;

public class ConnectionManager
{
  protected DBConnectionPoolManager connMgr = null;
  protected String poolName;
  protected String dbServer;
  protected String dbName;
  protected String port;
  protected String userID;
  protected String passwd;
  int maxConn;
  int initConn;
  int maxWait;
  
  public Connection getConnection()
  {
    return this.connMgr.getConnection(this.poolName);
  }
  
  public Connection getConnection(String paramString)
  {
    return this.connMgr.getConnection(paramString);
  }
  
  public void freeConnection(Connection paramConnection)
  {
    this.connMgr.freeConnection(this.poolName, paramConnection);
  }
  
  public void freeConnection(String paramString, Connection paramConnection)
  {
    this.connMgr.freeConnection(paramString, paramConnection);
  }
  
  public int getDriverNumber()
  {
    return this.connMgr.getDriverNumber();
  }
  
  public int getPoolsSize(String paramString)
  {
    return this.connMgr.getPoolsSize(paramString);
  }
}

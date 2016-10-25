package m2u.eyelink.db;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Date;
import java.util.Vector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m2u.eyelink.util.LogUtil;
import m2u.eyelink.util.Util;

public class DBConnectionPool
{
  private static final Logger LOG = LoggerFactory.getLogger(DBConnectionPool.class);;
  private int checkedOut;
  private Vector<Connection> freeConnections = new Vector();
  private int maxConn;
  private int initConn;
  private int maxWait;
  private String name;
  private String password;
  private String URL;
  private String user;
  
  public DBConnectionPool(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, int paramInt3)
  {
    this.name = paramString1;
    this.URL = paramString2;
    this.user = paramString3;
    this.password = paramString4;
    this.maxConn = paramInt1;
    this.maxWait = paramInt3;
    for (int i = 0; i < paramInt2; i++)
    {
      Connection localConnection = newConnection();
      if (localConnection != null) {
        this.freeConnections.addElement(localConnection);
      }
    }
  }
  
  public synchronized void freeConnection(Connection paramConnection)
  {
    this.freeConnections.addElement(paramConnection);
    this.checkedOut -= 1;
    notifyAll();
  }
  
  public synchronized Connection getConnection()
  {
    Connection localConnection = null;
    if (this.freeConnections.size() > 0)
    {
      localConnection = (Connection)this.freeConnections.firstElement();
      this.freeConnections.removeElementAt(0);
      try
      {
        if (localConnection.isClosed())
        {
          LOG.debug("Removed bad connection from " + this.name);
          localConnection = getConnection();
        }
      }
      catch (SQLException localSQLException)
      {
        LOG.error("Removed bad connection from " + this.name);
        localConnection = getConnection();
      }
    }
    else if ((this.maxConn == 0) || (this.checkedOut < this.maxConn))
    {
      localConnection = newConnection();
    }
    if (localConnection != null) {
      this.checkedOut += 1;
    }
    return localConnection;
  }
  
  public synchronized Connection getConnection(long paramLong)
  {
    long l = new Date().getTime();
    Connection localConnection;
    while ((localConnection = getConnection()) == null)
    {
      try
      {
        wait(paramLong * this.maxWait);
      }
      catch (InterruptedException localInterruptedException) {}
      if (new Date().getTime() - l >= paramLong) {
        return null;
      }
    }
    return localConnection;
  }
  
  private Connection newConnection()
  {
    Connection localConnection = null;
    try
    {
      if (this.user == null) {
        localConnection = DriverManager.getConnection(this.URL);
      } else {
        localConnection = DriverManager.getConnection(this.URL, this.user, this.password);
      }
      LOG.info("Created a new connection in pool " + this.name);
    }
    catch (SQLException localSQLException)
    {
      LOG.error("Can't create a new connection for " + this.URL + " user : " + this.user + " passwd : " + this.password, localSQLException);
      return null;
    }
    return localConnection;
  }
  
  public int size()
  {
    return this.freeConnections.size();
  }
}

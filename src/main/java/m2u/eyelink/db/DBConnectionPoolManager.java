package m2u.eyelink.db;

import java.sql.Connection;
import java.util.Hashtable;
import java.util.Vector;

import m2u.eyelink.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import m2u.eyelink.util.LogUtil;

public class DBConnectionPoolManager {
	private static final Logger LOG = LoggerFactory.getLogger(Util.class);
	private static DBConnectionPoolManager instance = null;
	private Vector<String> drivers = new Vector();
	private Hashtable<String, DBConnectionPool> pools = new Hashtable();

	public static synchronized DBConnectionPoolManager getInstance() {
		if (instance == null) {
			instance = new DBConnectionPoolManager();
		}
		return instance;
	}

	public void freeConnection(String paramString, Connection paramConnection) {
		DBConnectionPool localDBConnectionPool = (DBConnectionPool) this.pools
				.get(paramString);
		if (localDBConnectionPool != null) {
			localDBConnectionPool.freeConnection(paramConnection);
		}
		LOG.debug("One Connection of " + paramString + " was released");
	}

	public Connection getConnection(String paramString) {
		DBConnectionPool localDBConnectionPool = (DBConnectionPool) this.pools
				.get(paramString);
		if (localDBConnectionPool != null) {
			return localDBConnectionPool.getConnection(10L);
		}
		return null;
	}

	private void createPools(String paramString1, String paramString2,
			String paramString3, String paramString4, int paramInt1,
			int paramInt2, int paramInt3) {
		DBConnectionPool localDBConnectionPool = null;
		localDBConnectionPool = new DBConnectionPool(paramString1,
				paramString2, paramString3, paramString4, paramInt1, paramInt2,
				paramInt3);
		if (localDBConnectionPool.size() > 0) {
			this.pools.put(paramString1, localDBConnectionPool);
			LOG.info("Initialized pool " + paramString1 + "("
					+ localDBConnectionPool.size() + ") succeed!!!");
		}
	}

	public void init(String paramString1, String paramString2,
			String paramString3, String paramString4, String paramString5,
			int paramInt1, int paramInt2, int paramInt3) {
		loadDrivers(paramString2);
		createPools(paramString1, paramString3, paramString4, paramString5,
				paramInt1, paramInt2, paramInt3);
	}

	private void loadDrivers(String paramString) {
		try {
			Class.forName(paramString);
			this.drivers.addElement(paramString);
			LOG.debug("Registered JDBC driver " + paramString);
		} catch (Exception localException) {
			LOG.error("Can't register JDBC driver: " + paramString,
					localException);
		}
	}

	public Hashtable<String, DBConnectionPool> getPools() {
		return this.pools;
	}

	public int getDriverNumber() {
		return this.drivers.size();
	}

	public int getPoolsSize(String paramString) {
		return ((DBConnectionPool) this.pools.get(paramString)).size();
	}
}

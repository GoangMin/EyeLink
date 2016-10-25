package m2u.eyelink.modelbean;

public class FetchServerBean {
	private String NAME = "";
	private boolean ISUSE = false;
	private boolean ISSERVER = true;
	private String DESC = "";
	private String DB_URL = "";
	private String DB_TYPE = "";
	private String DB_DRIVERCLASS = "";
	private String DB_SERVER = "";
	private String DB_PORT = "";
	private String DB_DBNAME = "";
	private String DB_USERID = "";
	private String DB_PASSWORD = "";
	private int DB_INITCONN = 1;
	private int DB_MAXCONN = 1;
	private int DB_MAXWAIT = 5;
	private String DB_FETCHQUERY = "";
	private int DB_FETCHTIME = 10000;
	private String DB_PIPELINE_FETCHQUERY = "";
	private int DB_PIPELINE_THREAD = 1;

	public String getDB_SERVER() {
		return this.DB_SERVER;
	}

	public void setDB_SERVER(String paramString) {
		this.DB_SERVER = paramString;
	}

	public String getDB_PORT() {
		return this.DB_PORT;
	}

	public void setDB_PORT(String paramString) {
		this.DB_PORT = paramString;
	}

	public String getDB_DBNAME() {
		return this.DB_DBNAME;
	}

	public void setDB_DBNAME(String paramString) {
		this.DB_DBNAME = paramString;
	}

	public int getDB_INITCONN() {
		return this.DB_INITCONN;
	}

	public void setDB_INITCONN(int paramInt) {
		this.DB_INITCONN = paramInt;
	}

	public int getDB_MAXCONN() {
		return this.DB_MAXCONN;
	}

	public void setDB_MAXCONN(int paramInt) {
		this.DB_MAXCONN = paramInt;
	}

	public int getDB_MAXWAIT() {
		return this.DB_MAXWAIT;
	}

	public void setDB_MAXWAIT(int paramInt) {
		this.DB_MAXWAIT = paramInt;
	}

	public String getNAME() {
		return this.NAME;
	}

	public void setNAME(String paramString) {
		this.NAME = paramString;
	}

	public boolean isISUSE() {
		return this.ISUSE;
	}

	public void setISUSE(boolean paramBoolean) {
		this.ISUSE = paramBoolean;
	}

	public String getDESC() {
		return this.DESC;
	}

	public void setDESC(String paramString) {
		this.DESC = paramString;
	}

	public boolean isISSERVER() {
		return this.ISSERVER;
	}

	public void setISSERVER(boolean paramBoolean) {
		this.ISSERVER = paramBoolean;
	}

	public String getDB_TYPE() {
		return this.DB_TYPE;
	}

	public void setDB_TYPE(String paramString) {
		this.DB_TYPE = paramString;
	}

	public String getDB_DRIVERCLASS() {
		return this.DB_DRIVERCLASS;
	}

	public void setDB_DRIVERCLASS(String paramString) {
		this.DB_DRIVERCLASS = paramString;
	}

	public String getDB_USERID() {
		return this.DB_USERID;
	}

	public void setDB_USERID(String paramString) {
		this.DB_USERID = paramString;
	}

	public String getDB_PASSWORD() {
		return this.DB_PASSWORD;
	}

	public void setDB_PASSWORD(String paramString) {
		this.DB_PASSWORD = paramString;
	}

	public String getDB_FETCHQUERY() {
		return this.DB_FETCHQUERY;
	}

	public void setDB_FETCHQUERY(String paramString) {
		this.DB_FETCHQUERY = paramString;
	}

	public int getDB_FETCHTIME() {
		return this.DB_FETCHTIME;
	}

	public void setDB_FETCHTIME(int paramInt) {
		this.DB_FETCHTIME = paramInt;
	}

	public String getDB_PIPELINE_FETCHQUERY() {
		return this.DB_PIPELINE_FETCHQUERY;
	}

	public void setDB_PIPELINE_FETCHQUERY(String paramString) {
		this.DB_PIPELINE_FETCHQUERY = paramString;
	}

	public int getDB_PIPELINE_THREAD() {
		return this.DB_PIPELINE_THREAD;
	}

	public void setDB_PIPELINE_THREAD(int paramInt) {
		this.DB_PIPELINE_THREAD = paramInt;
	}

	public void setDB_URL(String paramString) {
		this.DB_URL = paramString;
	}

	public String getDB_URL() {
		return this.DB_URL;
	}
}

package m2u.eyelink.util;


import java.util.ArrayList;
import java.util.List;
import m2u.eyelink.modelbean.FetchServerBean;
import m2u.eyelink.modelbean.MailSMSBean;

public class Consts
{
  public static int BUFFER_SIZE = 1024;
  public static final char CR = '\r';
  public static final char LF = '\n';
  public static final String INIT_HEAD_STRING = "[HEAD=0000000090;TAIL=0000000089;SIZE=0000000090;AUDITTIMESTAMP=20120101.000000.000000;CID=47b38049-7cef-434a-ae4d-d75db18183ee;]\r\n";
  public static final int HEAD_BUFFER_SIZE = "[HEAD=0000000090;TAIL=0000000089;SIZE=0000000090;AUDITTIMESTAMP=20120101.000000.000000;CID=47b38049-7cef-434a-ae4d-d75db18183ee;]\r\n".length();
  public static final char DELI_FIELD = '\037';
  public static final char DELI_RECORD = '\036';
  public static final char DELI_CUSTOMID = '^';
  public static final char CSPACE = ' ';
  public static final String SSPACE = " ";
  public static final String COMMONCODE_STATUS_ERROR = "4";
  public static final String COMMONCODE_STATUS_COMPLETED = "2";
  public static final String COMMONCODE_STATUS_START = "1";
  public static final String COMMONCODE_SERVICE_LVL1 = "LEVEL1";
  public static final String COMMONCODE_SERVICE_LVL2 = "LEVEL2";
  public static final String COMMONCODE_SERVICE_LVL3 = "LEVEL3";
  public static String WEASYM_HOME_PATH = "c:/Data/WeasyM";
  public static String WEASYM_HOME_DATA_PATH = "c:/Data/WeasyM/data/";
  public static String WEASYM_HOME_QUEUE_PATH = "c:/Data/WeasyM/queue/";
  public static String WEASYM_HOME_INDEX_PATH = "c:/Data/WeasyM/index/ifdata";
  public static String WEASYM_HOME_IFMGMT_PATH = "";
  public static String WEASYM_HOME_ALERT_PATH = "";
  public static String WEASYM_IF_XML_PATH = "";
  public static String WEASYM_HOME_STATISTICS_PATH = "c:/Data/WeasyM/statistics/";
  public static List<FetchServerBean> WEASYM_SVR = new ArrayList();
  public static String DB_DRIVERCLASS = "";
  public static String DB_CONNECTIONURL = "";
  public static String DB_USERID = "";
  public static String DB_PASSWORD = "";
  public static String DB_FETCHQUERY = "";
  public static int DB_FETCHTIME = 10000;
  public static int FETCH_DB_PIPELINE_SIZE_LIMIT = 10240000;
  public static int FETCH_DB_PIPELINE_SIZE_FOR_THREAD = 200000;
  public static String WEASYM_TIMEZONE = "KST";
  public static String WEASYM_CHARSET = "euc-kr";
  public static int STATISTICS_FETCHTIME = 10000;
  public static String SERVICE_STATISTIC_QFILE = "q0_staticstic";
  public static String INTERFACE_PIPELINE_QFILE = "q0_pipeline";
  public static String DATE_FORMAT = "yyyyMMdd.HHmmss.SSS";
  public static String DB_ORACLE = "oracle";
  public static String DB_MSSQL = "mssql";
  public static String DB_DB2 = "db2";
  public static String FILE_TEST = "file_test";
  public static String WEASYM_ALERT_TARGET = "";
  public static String OWNER_DIV_CHAR = ";";
  public static MailSMSBean MAIL_SMS = new MailSMSBean();
  public static String SERVICE_ALERT_QFILE = "q0_alert";
}

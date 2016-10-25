package m2u.eyelink.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import m2u.eyelink.modelbean.FetchServerBean;
import m2u.eyelink.modelbean.InterfaceListMgmtBean;
import m2u.eyelink.modelbean.MailSMSBean;
import m2u.eyelink.util.Consts;
import m2u.eyelink.util.LogUtil;
import m2u.eyelink.util.Util;

public class LoadXmlConf {
	private static final Logger LOG = LoggerFactory.getLogger(Util.class);
	Map<String, InterfaceListMgmtBean> mapInterfaceListMgmt = new HashMap();

	public Map<String, InterfaceListMgmtBean> InterfaceXMLRead() {
		try {
			File localFile = new File(Consts.WEASYM_IF_XML_PATH);
			DocumentBuilderFactory localDocumentBuilderFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder localDocumentBuilder = localDocumentBuilderFactory
					.newDocumentBuilder();
			Document localDocument = localDocumentBuilder.parse(localFile);
			localDocument.getDocumentElement().normalize();
			NodeList localNodeList = localDocument
					.getElementsByTagName("definition");
			int i = 0;
			int j = localNodeList.getLength();
			while (i < j) {
				Node localNode = localNodeList.item(i);
				String str1 = Util.getElementValue(localNode, "InterfaceID");
				String str2 = Util.getElementValue(localNode, "InterfaceName");
				String str3 = Util.getElementValue(localNode, "ServiceName");
				String str4 = Util.getElementValue(localNode, "InterfaceGroup");
				String str5 = Util.getElementValue(localNode, "SourceSystem");
				String str6 = Util.getElementValue(localNode, "TargetSystem");
				String str7 = Util.getElementValue(localNode, "OwnerID");
				System.out.println("InterfaceID : " + str1
						+ ", InterfaceName : " + str2 + ", ServiceName : "
						+ str3 + ", UserID : " + str7);
				InterfaceListMgmtBean localInterfaceListMgmtBean = new InterfaceListMgmtBean();
				localInterfaceListMgmtBean.setInterfaceID(str1);
				localInterfaceListMgmtBean.setInterfaceName(Util
						.getElementValue(localNode, "InterfaceName"));
				localInterfaceListMgmtBean.setInterfaceGroup(Util
						.getElementValue(localNode, "InterfaceGroup"));
				localInterfaceListMgmtBean.setSourceSystem(Util.getElementValue(
						localNode, "SourceSystem"));
				localInterfaceListMgmtBean.setTargetSystem(Util.getElementValue(
						localNode, "TargetSystem"));
				localInterfaceListMgmtBean.setServiceName(Util.getElementValue(
						localNode, "ServiceName"));
				localInterfaceListMgmtBean.setOwnerID(Util.getElementValue(
						localNode, "OwnerID"));
				this.mapInterfaceListMgmt.put(str3, localInterfaceListMgmtBean);
				i++;
			}
		} catch (SAXException localSAXException) {
			localSAXException = localSAXException;
			LOG.error("InterfaceXMLRead", localSAXException);
		} catch (ParserConfigurationException localParserConfigurationException) {
			localParserConfigurationException = localParserConfigurationException;
			LOG.error("InterfaceXMLRead", localParserConfigurationException);
		} catch (FileNotFoundException localFileNotFoundException) {
			localFileNotFoundException = localFileNotFoundException;
			LOG.error("InterfaceXMLRead", localFileNotFoundException);
		} catch (IOException localIOException) {
			localIOException = localIOException;
			LOG.error("InterfaceXMLRead", localIOException);
		} finally {
		}
		return this.mapInterfaceListMgmt;
	}

	public void PropertiesRead(String paramString) {
		Properties localProperties = new Properties();
		try {
			localProperties.load(new BufferedReader(new InputStreamReader(
					new FileInputStream(paramString), "MS949")));
			setWmConstants(localProperties);
			LOG.info("Consts loading completed!!!");
		} catch (FileNotFoundException localFileNotFoundException) {
			LOG.error("conf.properties file not founded!!!(" + paramString
					+ ")", localFileNotFoundException);
		} catch (IOException localIOException) {
			LOG.error("PropertiesRed", localIOException);
		}
	}

	private void setWmConstants(Properties paramProperties) {
		Consts.WEASYM_HOME_PATH = paramProperties
				.getProperty("weasym.home.path");
		Consts.WEASYM_HOME_IFMGMT_PATH = paramProperties
				.getProperty("weasym.home.ifmgmt.path");
		Consts.WEASYM_HOME_ALERT_PATH = paramProperties
				.getProperty("weasym.home.alert.path");
		Consts.WEASYM_HOME_DATA_PATH = paramProperties
				.getProperty("weasym.home.data.path");
		Consts.WEASYM_HOME_QUEUE_PATH = paramProperties
				.getProperty("weasym.home.queue.path");
		Consts.WEASYM_HOME_INDEX_PATH = paramProperties
				.getProperty("weasym.home.index.path");
		Consts.WEASYM_IF_XML_PATH = paramProperties
				.getProperty("weasym.interfacelistmgmt.filename");
		Consts.WEASYM_HOME_STATISTICS_PATH = paramProperties
				.getProperty("weasym.home.statistics.path");
		Consts.BUFFER_SIZE = Integer.parseInt(paramProperties
				.getProperty("queue.buffersize"));
		Consts.FETCH_DB_PIPELINE_SIZE_LIMIT = Integer.parseInt(paramProperties
				.getProperty("fetch.db.pipeline.size.limit"));
		Consts.WEASYM_TIMEZONE = paramProperties.getProperty("weasym.timezone");
		Consts.WEASYM_CHARSET = paramProperties.getProperty("weasym.charset");
		Consts.STATISTICS_FETCHTIME = Integer.parseInt(paramProperties
				.getProperty("fetch.statistic.fetchtime"));
		Consts.WEASYM_ALERT_TARGET = paramProperties
				.getProperty("weasym.alert.target");
		Consts.OWNER_DIV_CHAR = paramProperties
				.getProperty("weasym.owner.div.char");
		int i = 1;
		int j = 1;
		String str1 = "";
		String str2 = "";
		while (j != 0) {
			str1 = paramProperties.getProperty("fetch.server." + i + ".name");
			str2 = paramProperties.getProperty("fetch.server." + i + ".use");
			if ((str1 == null) && (str2 == null)) {
				j = 0;
			} else if ("Y".equals(str2)) {
				FetchServerBean localFetchServerBean = new FetchServerBean();
				localFetchServerBean.setNAME(str1);
				localFetchServerBean.setISUSE(true);
				localFetchServerBean.setISSERVER("Y".equals(paramProperties
						.getProperty("fetch.server." + i + ".isserver")));
				localFetchServerBean.setDESC(paramProperties
						.getProperty("fetch.server." + i + ".desc"));
				localFetchServerBean.setDB_TYPE(paramProperties
						.getProperty("fetch.server." + i + ".db.type"));
				localFetchServerBean.setDB_DRIVERCLASS(paramProperties
						.getProperty("fetch.server." + i + ".db.driverclass"));
				try {
					localFetchServerBean.setDB_URL(paramProperties
							.getProperty("fetch.server." + i + ".db.url"));
				} catch (Exception localException4) {
					localFetchServerBean.setDB_URL(null);
				}
				if ((localFetchServerBean.getDB_URL() == null)
						|| ("".equals(localFetchServerBean.getDB_URL()))) {
					localFetchServerBean.setDB_SERVER(paramProperties
							.getProperty("fetch.server." + i + ".db.server"));
					localFetchServerBean.setDB_PORT(paramProperties
							.getProperty("fetch.server." + i + ".db.port"));
					localFetchServerBean.setDB_DBNAME(paramProperties
							.getProperty("fetch.server." + i + ".db.dbname"));
				}
				localFetchServerBean.setDB_USERID(paramProperties
						.getProperty("fetch.server." + i + ".db.userid"));
				localFetchServerBean.setDB_PASSWORD(paramProperties
						.getProperty("fetch.server." + i + ".db.password"));
				localFetchServerBean.setDB_FETCHQUERY(paramProperties
						.getProperty("fetch.server." + i + ".db.fetchquery"));
				localFetchServerBean.setDB_FETCHTIME(Integer
						.parseInt(paramProperties.getProperty("fetch.server."
								+ i + ".db.fetchtime")));
				localFetchServerBean.setDB_INITCONN(Integer
						.parseInt(paramProperties.getProperty("fetch.server."
								+ i + ".db.initconn")));
				localFetchServerBean.setDB_MAXCONN(Integer
						.parseInt(paramProperties.getProperty("fetch.server."
								+ i + ".db.maxconn")));
				localFetchServerBean.setDB_MAXWAIT(Integer
						.parseInt(paramProperties.getProperty("fetch.server."
								+ i + ".db.maxwait")));
				localFetchServerBean.setDB_PIPELINE_FETCHQUERY(paramProperties
						.getProperty("fetch.server." + i
								+ ".db.pipeline.fetchquery"));
				localFetchServerBean.setDB_PIPELINE_THREAD(Integer
						.parseInt(paramProperties.getProperty("fetch.server."
								+ i + ".db.pipeline.thread")));
				Consts.WEASYM_SVR.add(localFetchServerBean);
			}
			i += 1;
		}
		try {
			Consts.MAIL_SMS.setMAIL_USE(paramProperties
					.getProperty("weasym.mail.use"));
			if (Consts.MAIL_SMS.isMAIL_USE()) {
				Consts.MAIL_SMS.setMAIL_TYPE(paramProperties
						.getProperty("weasym.mail.type"));
				if ("smtp".equals(Consts.MAIL_SMS.getMAIL_TYPE())) {
					Consts.MAIL_SMS.setMAIL_HOST(paramProperties
							.getProperty("weasym.mail.host"));
					Consts.MAIL_SMS.setMAIL_PORT(paramProperties
							.getProperty("weasym.mail.port"));
					Consts.MAIL_SMS.setMAIL_USERID(paramProperties
							.getProperty("weasym.mail.userid"));
					Consts.MAIL_SMS.setMAIL_PASSWORD(paramProperties
							.getProperty("weasym.mail.password"));
				} else if ("db".equals(Consts.MAIL_SMS.getMAIL_TYPE())) {
					Consts.MAIL_SMS.setMAIL_DB_TYPE(paramProperties
							.getProperty("weasym.mail.db.type"));
					try {
						Consts.MAIL_SMS.setMAIL_DB_URL(paramProperties
								.getProperty("weasym.mail.db.url"));
					} catch (Exception localException1) {
						Consts.MAIL_SMS.setMAIL_DB_URL(null);
					}
					if ((Consts.MAIL_SMS.getMAIL_DB_URL() == null)
							|| ("".equals(Consts.MAIL_SMS.getMAIL_DB_URL()))) {
						Consts.MAIL_SMS.setMAIL_DB_SERVER(paramProperties
								.getProperty("weasym.mail.db.server"));
						Consts.MAIL_SMS.setMAIL_DB_PORT(paramProperties
								.getProperty("weasym.mail.db.port"));
						Consts.MAIL_SMS.setMAIL_DB_DBNAME(paramProperties
								.getProperty("weasym.mail.db.dbname"));
					}
					Consts.MAIL_SMS.setMAIL_DB_USERID(paramProperties
							.getProperty("weasym.mail.db.userid"));
					Consts.MAIL_SMS.setMAIL_DB_PASSWORD(paramProperties
							.getProperty("weasym.mail.db.password"));
					Consts.MAIL_SMS.setMAIL_DB_INITCONN(paramProperties
							.getProperty("weasym.mail.db.initconn"));
					Consts.MAIL_SMS.setMAIL_DB_MAXCONN(paramProperties
							.getProperty("weasym.mail.db.maxconn"));
					Consts.MAIL_SMS.setMAIL_DB_MAXWAIT(paramProperties
							.getProperty("weasym.mail.db.maxwait"));
					Consts.MAIL_SMS.setMAIL_DB_QUERY_HEADER(paramProperties
							.getProperty("weasym.mail.db.query.header"));
					Consts.MAIL_SMS.setMAIL_DB_QUERY_SENDER(paramProperties
							.getProperty("weasym.mail.db.query.sender"));
				}
				Consts.MAIL_SMS.setMAIL_FROM_ADDRESS(paramProperties
						.getProperty("weasym.mail.from.address"));
				Consts.MAIL_SMS.setMAIL_FROM_NAME(paramProperties
						.getProperty("weasym.mail.from.name"));
				Consts.MAIL_SMS.setMAIL_CONTENTS_SIGN(paramProperties
						.getProperty("weasym.mail.contents.sign"));
			}
			Consts.MAIL_SMS.setSMS_USE(paramProperties
					.getProperty("weasym.sms.use"));
			if (Consts.MAIL_SMS.isSMS_USE()) {
				Consts.MAIL_SMS.setSMS_TYPE(paramProperties
						.getProperty("weasym.sms.type"));
				if ("db".equals(Consts.MAIL_SMS.getSMS_TYPE())) {
					Consts.MAIL_SMS.setSMS_DB_TYPE(paramProperties
							.getProperty("weasym.sms.db.type"));
					try {
						Consts.MAIL_SMS.setSMS_DB_URL(paramProperties
								.getProperty("weasym.sms.db.url"));
					} catch (Exception localException2) {
						Consts.MAIL_SMS.setSMS_DB_URL(null);
					}
					if ((Consts.MAIL_SMS.getSMS_DB_URL() == null)
							|| ("".equals(Consts.MAIL_SMS.getSMS_DB_URL()))) {
						Consts.MAIL_SMS.setSMS_DB_SERVER(paramProperties
								.getProperty("weasym.sms.db.server"));
						Consts.MAIL_SMS.setSMS_DB_PORT(paramProperties
								.getProperty("weasym.sms.db.port"));
						Consts.MAIL_SMS.setSMS_DB_DBNAME(paramProperties
								.getProperty("weasym.sms.db.dbname"));
					}
					Consts.MAIL_SMS.setSMS_DB_USERID(paramProperties
							.getProperty("weasym.sms.db.userid"));
					Consts.MAIL_SMS.setSMS_DB_PASSWORD(paramProperties
							.getProperty("weasym.sms.db.password"));
					Consts.MAIL_SMS.setSMS_DB_INITCONN(paramProperties
							.getProperty("weasym.sms.db.initconn"));
					Consts.MAIL_SMS.setSMS_DB_MAXCONN(paramProperties
							.getProperty("weasym.sms.db.maxconn"));
					Consts.MAIL_SMS.setSMS_DB_MAXWAIT(paramProperties
							.getProperty("weasym.sms.db.maxwait"));
					Consts.MAIL_SMS.setSMS_DB_SENDER(paramProperties
							.getProperty("weasym.sms.db.sender"));
					Consts.MAIL_SMS.setSMS_DB_QUERY(paramProperties
							.getProperty("weasym.sms.db.query"));
				}
			}
		} catch (Exception localException3) {
			LOG.error("In conf.properties file, error from mail setting",
					localException3);
		}
	}

	public Map<String, InterfaceListMgmtBean> getMapInterfaceListMgmt() {
		return this.mapInterfaceListMgmt;
	}

	public void setMapInterfaceListMgmt(
			Map<String, InterfaceListMgmtBean> paramMap) {
		this.mapInterfaceListMgmt = paramMap;
	}
}

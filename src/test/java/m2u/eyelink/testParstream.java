package m2u.eyelink;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import org.junit.Assert;
import org.junit.Test;

import com.parstream.jdbc4.ParstreamConnection;

public class testParstream {
//	String ip = "m2u-da.eastus.cloudapp.azure.com";
	String ip = "m2u-parstream.eastus.cloudapp.azure.com";
	int port = 9042;
	String user = "parstream";
	String pass = "Rornfldkf!2";
	
//	@Test
	public void testJdbcConnection() {

		// JDBC driver name and database URL
		String JDBC_DRIVER = "com.parstream.ParstreamDriver";
		// String DB_URL =
		// "jdbc:parstream://m2u-parstream.eastus.cloudapp.azure.com:9043/eyelink?user=parstream&password=Rornfldkf!2";
		// String DB_URL =
		// "jdbc:parstream://m2u-parstream.eastus.cloudapp.azure.com:9043/eyelink";
		String DB_URL = "jdbc:parstream://" + ip + ":" + port + "/eyelink";
		// Database credentials

		Connection conn = null;
		Statement stmt = null;
		long startTime = System.currentTimeMillis();
		try {
			// STEP 2: Register JDBC driver
			Class.forName(JDBC_DRIVER);

			// STEP 3: Open a connection
			System.out.println("Connecting to database...");
			conn = DriverManager.getConnection(DB_URL, user, pass);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			stmt = conn.createStatement();
			String sql;
			// sql = "SELECT count(*) as cnt FROM tb_node_raw";
			sql = "select node_id, event_time, event_type, active_power, ampere,         "
					+ " als_level, dimming_level,          noise_decibel, noise_frequency,    "
					+ " vibration_x, vibration_y, vibration_z,          (vibration_x + vibration_y + vibration_z) / 3 as vibration   "
					+ " from tb_node_raw  "
					+ " where event_time >= timestamp '2016-12-12 00:00:00'   "
					+ " and event_time < timestamp '2017-01-02 23:59:59' limit 10";
			ResultSet rs = stmt.executeQuery(sql);

			long endTime = System.currentTimeMillis();

			System.out.println("query time 1 : " + (endTime - startTime)
					/ 1000. + " s");
			long startTime2 = System.currentTimeMillis();

			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			int num = 0;
			for (int i = 1; i <= columnCount; i++) {
				num = rsmd.getColumnType(i);
				String s = rsmd.getColumnTypeName(i);
				System.out.println(rsmd.getColumnName(i) + " Column " + i
						+ " is type " + s + ", num : " + num);
			}

			// STEP 5: Extract data from result set
			int cnt = 0;
			Vector hm = new Vector();
			while (rs.next()) {
				HashMap hh = new HashMap();
				hh.put("node_id", rs.getString("node_id"));
				hh.put("als_level", rs.getString("als_level"));
				hh.put("dimming_level", rs.getString("dimming_level"));
				hm.add(hh);
				// System.out.println("node id : " + rs.getString("node_id"));
				// Retrieve by column name
				// int cnt = rs.getInt("node_id");
				System.out.println(rs.getString("node_id"));
				System.out.println(rs.getString("event_time"));
				cnt++;
				// Display values
			}
			long endTime2 = System.currentTimeMillis();
			System.out.println("add vector time 2 : " + (endTime2 - startTime2)
					/ 1000. + " s");
			System.out.println("total time : " + (endTime2 - startTime) / 1000.
					+ " s");
			System.out.print("Cnt: " + cnt);
			// Assert.assertEquals("0000000049", "0000000049");
			Assert.assertTrue(cnt > 0);
			// STEP 6: Clean-up environment
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}// nothing we can do
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}// end finally try

		}

	}

	@Test
	public void testSocketConnection() {
		// TODO code application logic here
		Socket s;
		try {
			s = new Socket(ip, port);
			System.out.println(s.getPort());
	          // define streams
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
//            out.write("LOGIN 'parstream' 'Rornfldkf!2'\nselect * from tb_node_raw limit 10\nquit\n");
            out.write("SELECT * FROM tb_node_raw limit 10000\n");
//			out.write("select * from tb_node_raw limit 10;");
//			out.newLine();
			out.flush();

            // read response
			String ss = "";
			while ((ss = in.readLine()) != null) {
		        System.out.println(ss);
		      }
		      in.close();			
//            String returnData = in.readLine();
//            System.out.println(returnData);
//            out.write("quit\n");
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
//			Logger.getLogger(Solverapplet.class.getName()).log(Level.SEVERE,
//					null, ex);
		} catch (IOException ex) {
			ex.printStackTrace();
//			Logger.getLogger(Solverapplet.class.getName()).log(Level.SEVERE,
//					null, ex);
		}

	}
	
//	@Test
//	public void testAPI() {
//	       /*
//         * open a Cisco ParStream connection
//         */
//        ParstreamConnection parstreamConn = new ParstreamConnection();
//        try {
//            System.out.println("Using Cisco ParStream API version: " + parstreamConn.getVersion());
//
//            /*
//             * setup the connection
//             */
//            parstreamConn.createHandle();
//            parstreamConn.setTimeout(20000);
//            parstreamConn.setImportPriority(ImportPriority.MEDIUM);
//            parstreamConn.connect(host, port, username, password);
//
//            System.out.println("Cisco ParStream db version: " + parstreamConn.getDbVersion());
//            System.out.println("Connection id: " + parstreamConn.getConnectionId());
//
//            /*
//             * query tables and check whether the table to insert to exists
//             */
//            String[] tableNames = parstreamConn.listTables();
//            boolean tableFound = false;
//            for (int i = 0; i < tableNames.length; i++) {
//                System.out.println("table " + i + ": " + tableNames[i]);
//                if (tableNames[i].equals(tableName)) {
//                    tableFound = true;
//                }
//            }
//            if (!tableFound) {
//                throw new Exception("Missing table '" + tableName + "'");
//            }
//
//            /*
//             * print all columns of the table we use for insertions
//             */
//            ColumnInfo[] columns = parstreamConn.listImportColumns(tableName);
//            for (int i = 0; i < columns.length; i++) {
//                System.out.println("column " + i + ": " + columns[i].getName());
//            }
//
//            /*
//             * insert rows and skip invalid inserts
//             */
//            parstreamConn.prepareInsert(tableName);
//            for (MyData row : data) {
//                try {
//                    parstreamConn.rawInsert(row.toObjectArray());
//                } catch (ParstreamException e) {
//                    System.err.println("skip data: " + row + " due to:");
//                    e.printStackTrace();
//                    System.exit(1);
//                }
//            }
//            parstreamConn.commit();
//
//            /*
//             * start to insert a row and roll it back
//             */
//            parstreamConn.prepareInsert(tableName);
//            parstreamConn.rawInsert(data[0].toObjectArray());
//            parstreamConn.rollback();
//        } catch (ParstreamException e) {
//            e.printStackTrace();
//            System.exit(1);
//        } catch (ParstreamFatalException e) {
//            e.printStackTrace();
//            System.exit(1);
//        }
//        parstreamConn.close();		
//	}
}

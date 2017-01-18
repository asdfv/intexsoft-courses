package ForOpers.by;

import au.com.bytecode.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class ListOfCallsToCSV {

    public static int getSizeResS(ResultSet rs) throws SQLException {
        rs.last();
        int size = rs.getRow();
        rs.first();
        return size;
    }

    private static final String FIND_MISSED = "select data2, time(time), 'missed' as status from queue_log where time like concat(?, '%') and event = 'ENTERQUEUE' and callid in (" +
            "select callid from queue_log where time like concat(?, '%') and event = 'ABANDON' and data3 > 15 );";

    private static final String FIND_ANSWERED = "select data2, time(time), 'answered' as status from queue_log where time like concat(?, '%') and event = 'ENTERQUEUE' and callid in (" +
            "select callid from queue_log where time like concat(?, '%') and event = 'CONNECT' );";

    private static final String FIND_OUTGOING = "SELECT dst, time(calldate), 'outgoing' as status FROM cdr WHERE calldate like concat(?, '%') and ( dstchannel LIKE 'DAHDI%' OR dstchannel LIKE 'SIP/dinstar-trunk-gsm%' );";

    public static void main(String[] args) {

        // Current date if needed
        long curTime = System.currentTimeMillis();
        String curDate = new SimpleDateFormat("yyyy-MM-dd").format(curTime);

        // Variable declaration
        String period = "2015-09-22";

        Connection con = null;
        PreparedStatement missedPrepS;
        PreparedStatement answeredPrepS;
        PreparedStatement outgoingPrepS;
        ResultSet missedResS;
        ResultSet answeredResS;
        ResultSet outgoingResS;

        CSVWriter csvWriter = null;

        try {
            // Getting connection
            con = new ConnectionMaker().getConnection();

            // Creating prepare statements
            missedPrepS = con.prepareStatement(FIND_MISSED);
            missedPrepS.setString(1, period);
            missedPrepS.setString(2, period);

            answeredPrepS = con.prepareStatement(FIND_ANSWERED);
            answeredPrepS.setString(1, period);
            answeredPrepS.setString(2, period);

            outgoingPrepS = con.prepareStatement(FIND_OUTGOING);
            outgoingPrepS.setString(1, period);

            // Getting resutSets
            missedResS = missedPrepS.executeQuery();
            answeredResS = answeredPrepS.executeQuery();
            outgoingResS = outgoingPrepS.executeQuery();

            System.out.println("Percent of missed calls - " + getSizeResS(missedResS)*100 / (getSizeResS(answeredResS) + getSizeResS(missedResS)) + " %" );
            System.out.println(getSizeResS(missedResS));

            // Write to CSV-file
            csvWriter = new CSVWriter(new FileWriter("D://Missed.csv"), ';');
            csvWriter.writeAll(missedResS, false);
            csvWriter.writeAll(answeredResS, false);
            csvWriter.writeAll(outgoingResS, false);

            csvWriter.flush();
            System.out.println("Result export to D://Missed.csv");

        } catch (SQLException e) { e.printStackTrace();
        } catch (IOException e) { e.printStackTrace();
        } finally { //Closing writer stream and connection
            if (csvWriter != null) try { csvWriter.close(); } catch (IOException e) { e.printStackTrace(); }
            if (con != null) try { con.close(); } catch (SQLException e) { e.printStackTrace();
            }
        }
    }
}

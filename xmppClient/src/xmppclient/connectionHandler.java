package xmppclient;

/**
 *
 * @author Dean Wake
 */
import java.io.IOException;
import org.jivesoftware.smack.ConnectionConfiguration;
import org.jivesoftware.smack.SmackException;
import org.jivesoftware.smack.XMPPConnection;
import org.jivesoftware.smack.XMPPException;
import org.jivesoftware.smack.tcp.XMPPTCPConnection;

public class connectionHandler {

    private XMPPConnection connection;

    public XMPPConnection connect(String serverIP) {

        try {

            ConnectionConfiguration config = new ConnectionConfiguration(serverIP, 5222);

            config.setSecurityMode(ConnectionConfiguration.SecurityMode.disabled);

            connection = new XMPPTCPConnection(config);

            connection.connect();

            if (connection.isConnected()) {
                return connection;
            }

        } catch (SmackException | IOException | XMPPException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean login(String userName, String password) {

        try {
            connection.login(userName, password);
            
            if (this.connection.isAuthenticated()) {
                return true;
            }
            
           
        } catch (XMPPException | SmackException | IOException | NullPointerException ex) {
            ex.printStackTrace();
        }
         return false;
    }

    public boolean disconnect() {

        try {
            connection.disconnect();
            
            if (!this.connection.isConnected()) {
                return true;
            }
            
            
        } catch (SmackException.NotConnectedException | NullPointerException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}

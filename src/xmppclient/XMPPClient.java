package xmppclient;

import org.jivesoftware.smack.XMPPConnection;

/**
 *
 * @author Dean Wake
 */
public class XMPPClient {
     
   public void testConnect() {
        System.out.println("connect");
        String serverIP = "openfire.fin-tech.com";
        connectionHandler instance = new connectionHandler();
        XMPPConnection result = instance.connect(serverIP);
        
        System.out.println("Connection result: " + result);
    }

    /**
     * Test of login method, of class connectionHandler.
     */
    
    public void testLogin() {
        System.out.println("login");
        String userName = "deanmwake";
        String password = "hackt1v1st";
        connectionHandler instance = new connectionHandler();
        System.out.println("Is logged in: " + instance.login(userName, password));
    }

    /**
     * Test of disconnect method, of class connectionHandler.
     */
    
    public void testDisconnect() {
        System.out.println("disconnect");
        connectionHandler instance = new connectionHandler();
        System.out.println("Is disconnected: " + instance.disconnect());
    }

    public static void main(String[] args) {

        XMPPClient testClass = new XMPPClient();
        
        testClass.testConnect();
        
        testClass.testLogin();
        
        testClass.testDisconnect();
        
    }
    
}

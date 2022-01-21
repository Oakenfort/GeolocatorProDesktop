package client;

import java.awt.EventQueue;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JInternalFrame;
import javax.swing.JTable;

import dao.IDaoRemote;
import entities.Smartphone;
import entities.User;

public class UserGUI extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	private static IDaoRemote lookUpUser() throws NamingException {
		Hashtable<Object, Object> config = new Hashtable<Object, Object>();
		config.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		config.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(config);
		return (IDaoRemote) context.lookup("ejb:GéolocalisationEAR/EJB-test/UserService!dao.IDaoRemote");		
		
	}

	private static IDaoRemote lookUpSmartphone() throws NamingException {
		Hashtable<Object, Object> config = new Hashtable<Object, Object>();
		config.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		config.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		final Context context = new InitialContext(config);
		//return (IDaoRemote) context.lookup("ejb:/Géolocalisation-Server/SmartphoneService!dao.IDaoRemote");
		return (IDaoRemote) context.lookup("ejb:GéolocalisationEAR/EJB-test/Smartphone!dao.IDaoRemote");
		
	}
	private JTable table;
	private IDaoRemote<User> daoUser;
	private IDaoRemote<Smartphone> daoSmartphone;

 static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserGUI frame = new UserGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UserGUI() {
		setClosable(true);
		setBounds(100, 100, 450, 300);

	}

}

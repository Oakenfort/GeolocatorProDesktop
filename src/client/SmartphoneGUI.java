package client;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import dao.IDaoRemote;
import entities.Smartphone;
import entities.User;

import java.awt.BorderLayout;

public class SmartphoneGUI extends JInternalFrame {
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


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SmartphoneGUI frame = new SmartphoneGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public SmartphoneGUI() throws PropertyVetoException {
		setBackground(new Color(240, 240, 240));
		setClosed(true);
		setClosable(true);
		setBounds(100, 100, 623, 474);
		
		table = new JTable();
		getContentPane().add(table, BorderLayout.CENTER);

	}
	private void fillTable() throws RemoteException {

		List<Smartphone> smartphones = daoSmartphone.getAll();
		List<String[]> data = new ArrayList();

		for (Smartphone s : smartphones) {
			data.add(new String[] { s.getImei(), s.getUser().getNom()+" "+s.getUser().getPrenom(), String.valueOf(s.getId())});
		}

		List<String> columns = new ArrayList<String>();
		columns.add("IMEI");
		columns.add("Utilisateur");
		columns.add("id");

		TableModel tableModel = new DefaultTableModel(data.toArray(new Object[][] {}), columns.toArray());
		table.setModel(tableModel);
		table.removeColumn(table.getColumnModel().getColumn(2));
	}

}

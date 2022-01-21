package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyVetoException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class index {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			index window = new index();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		shell.setSize(699, 438);
		shell.setText("SWT Application");
		
		Label lblGestionDeLocalisation = new Label(shell, SWT.CENTER);
		lblGestionDeLocalisation.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		lblGestionDeLocalisation.setFont(SWTResourceManager.getFont("Segoe UI", 26, SWT.BOLD | SWT.ITALIC));
		lblGestionDeLocalisation.setBounds(97, 44, 478, 73);
		lblGestionDeLocalisation.setText("Gestion de Localisation");
		
		Button btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				UserGUI frame = new UserGUI();
			}
		});
		btnNewButton.setBounds(244, 188, 198, 42);
		btnNewButton.setText("Gestion des utilisateurs");
		
		Button btnGestionDesSmartphones = new Button(shell, SWT.NONE);
		btnGestionDesSmartphones.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				try {
					SmartphoneGUI frame = new SmartphoneGUI();
				} catch (PropertyVetoException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnGestionDesSmartphones.setText("gestion des smartphones");
		btnGestionDesSmartphones.setBounds(244, 268, 198, 42);

	}
}

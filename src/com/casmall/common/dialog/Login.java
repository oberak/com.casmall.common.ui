package com.casmall.common.dialog;
import net.miginfocom.swt.MigLayout;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.casmall.common.DConstants;
import com.casmall.usr.mgr.CmUsrInfMgr;
import com.cloudgarden.resource.SWTResourceManager;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class Login extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Label label;
	private Label label1;
	private Button btnLogin;
	private Text txtPassword;
	private Text txtID;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			Login inst = new Login(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Login(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText("Login");

			MigLayout dialogShellLayout = new MigLayout("","[left,fill]10[right]10[left, grow, fill]", "[fill]10");
			dialogShell.setLayout(dialogShellLayout);
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Login");
				label.setLayoutData("cell 0 0 4 0");
				label.setFont(SWTResourceManager.getTitleFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("ID");
				label.setLayoutData("cell 1 1");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label1 = new Label(dialogShell, SWT.NONE);
				label1.setText("Password");
				label1.setLayoutData("cell 1 2");
				label1.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtID = new Text(dialogShell, SWT.BORDER);
				txtID.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.keyCode == DConstants.KEY_ENTER){
							if(txtID.getText().getBytes().length > 0){
								txtPassword.setFocus();
							}
						}
					}
				});
				txtID.setLayoutData("cell 2 1");
			}
			{
				txtPassword = new Text(dialogShell, SWT.BORDER | SWT.PASSWORD);
				txtPassword.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						if(e.keyCode == DConstants.KEY_ENTER){
							if(txtPassword.getText().getBytes().length > 0){
								btnLoginMouseDown(null);
							}
						}
					}
				});
				txtPassword.setLayoutData("cell 2 2");
			}
			{
				btnLogin = new Button(dialogShell, SWT.PUSH | SWT.CENTER );
				btnLogin.addKeyListener(new KeyAdapter() {
					@Override
					public void keyPressed(KeyEvent e) {
						btnLoginMouseDown(null);
					}
				});
				btnLogin.setText("Login");
				btnLogin.setLayoutData("cell 3 1 1 2");
				btnLogin.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						btnLoginMouseDown(evt);
					}
				});
			}
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(263, 136);
			dialogShell.setLocation(getParent().toDisplay(100, 100));
			dialogShell.open();
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void btnLoginMouseDown(MouseEvent evt) {
		if("".equals(txtID.getText().trim())){
			MessageDialog.openInformation(dialogShell,"Validation","로그인 ID를 입력하세요.");
			txtID.setFocus();
			return;
		}
		if("".equals(txtPassword.getText().trim())){
			MessageDialog.openInformation(dialogShell,"Validation","Password를 입력하세요.");
			txtPassword.setFocus();
			return;
		}
		CmUsrInfMgr mgr = new CmUsrInfMgr();
		if(!mgr.checkLogin(txtID.getText().trim(), txtPassword.getText().trim())){
			MessageDialog.openInformation(dialogShell,"Login check","ID가 없거나 비밀번호가 잘못되었습니다.");
			txtPassword.setText("");
			txtID.setText("");
			txtID.setFocus();
			return;
		}

		// TODO NONE 메인화면에서 결과값 받을 수 있도록 처리 : 확인 필요 <== 미사용!!
		dialogShell.setData(true);
		dialogShell.close();
	}

}

package com.casmall.common.dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

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
public class About extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private CLabel lblTitle;
	private Button btnCancel;
	private CLabel cLabel2;
	private CLabel lblSaveTerm;
	private CLabel cLabel3;
	private CLabel cLabel1;

	/**
	* Auto-generated main method to display this 
	* org.eclipse.swt.widgets.Dialog inside a new Shell.
	*/
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			About inst = new About(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public About(Shell parent, int style) {
		super(parent, style);
	}

	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
			dialogShell.setText("About");
			{
				//Register as a resource user - SWTResourceManager will
				//handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}
			
			
			dialogShell.setLayout(new FormLayout());
			dialogShell.layout();
			dialogShell.pack();			
			dialogShell.setSize(386, 275);
			dialogShell.setBackground(SWTResourceManager.getColor(128, 128, 192));
			dialogShell.addMouseListener(new MouseAdapter() {
				public void mouseDown(MouseEvent evt) {
					dialogShell.close();
				}
			});
			{
				lblSaveTerm = new CLabel(dialogShell, SWT.NONE);
				FormData lblSaveTermLData = new FormData();
				lblSaveTermLData.width = 326;
				lblSaveTermLData.height = 29;
				lblSaveTermLData.left =  new FormAttachment(27, 1000, 0);
				lblSaveTermLData.top =  new FormAttachment(253, 1000, 0);
				lblSaveTermLData.bottom =  new FormAttachment(359, 1000, 0);
				lblSaveTermLData.right =  new FormAttachment(961, 1000, 0);
				lblSaveTerm.setLayoutData(lblSaveTermLData);
				lblSaveTerm.setText("Version 2.0  @2011.01.01");
				lblSaveTerm.setBackground(SWTResourceManager.getColor(128, 128, 192));
				lblSaveTerm.setForeground(SWTResourceManager.getColor(0, 0, 64));
				lblSaveTerm.setFont(SWTResourceManager.getFont("±¼¸²", 14, 1, false, false));
			}
			{
				lblTitle = new CLabel(dialogShell, SWT.NONE);
				FormData lblTitleLData = new FormData();
				lblTitleLData.width = 378;
				lblTitleLData.height = 48;
				lblTitleLData.left =  new FormAttachment(1, 1000, 0);
				lblTitleLData.top =  new FormAttachment(2, 1000, 0);
				lblTitleLData.bottom =  new FormAttachment(201, 1000, 0);
				lblTitleLData.right =  new FormAttachment(1001, 1000, 0);
				lblTitle.setLayoutData(lblTitleLData);
				lblTitle.setText("About ´Þ±¸Áö II");
				lblTitle.setBackground(SWTResourceManager.getColor(0, 0, 64));
				lblTitle.setForeground(SWTResourceManager.getColor(255, 255, 255));
				lblTitle.setFont(SWTResourceManager.getFont("±¼¸²", 24, 1, false, false));
				lblTitle.setAlignment(SWT.CENTER);
			}
			{
				cLabel2 = new CLabel(dialogShell, SWT.NONE);
				cLabel2.setText("\ubaa8\ub4e0 \uc800\uc791\uad8c\uc740 \uce74\uc2a4\ub9e4\uce74\ud2b8\ub85c\ub2c9\uc2a4\uc5d0 \uc788\uc2b5\ub2c8\ub2e4.");
				cLabel2.setBackground(SWTResourceManager.getColor(128, 128, 192));
				FormData cLabel2LData = new FormData();
				cLabel2LData.width = 355;
				cLabel2LData.height = 23;
				cLabel2LData.left =  new FormAttachment(25, 1000, 0);
				cLabel2LData.top =  new FormAttachment(381, 1000, 0);
				cLabel2LData.bottom =  new FormAttachment(465, 1000, 0);
				cLabel2LData.right =  new FormAttachment(964, 1000, 0);
				cLabel2.setLayoutData(cLabel2LData);
				cLabel2.setFont(SWTResourceManager.getFont("±¼¸²", 11, 1, false, false));
				cLabel2.setForeground(SWTResourceManager.getColor(0, 0, 64));
			}
			{
				btnCancel = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				FormData button1LData2 = new FormData();
				button1LData2.width = 104;
				button1LData2.height = 28;
				button1LData2.left =  new FormAttachment(371, 1000, 0);
				button1LData2.top =  new FormAttachment(802, 1000, 0);
				button1LData2.bottom =  new FormAttachment(919, 1000, 0);
				button1LData2.right =  new FormAttachment(646, 1000, 0);
				btnCancel.setLayoutData(button1LData2);
				btnCancel.setText("O K");
				btnCancel.setBackground(SWTResourceManager.getColor(128, 128, 192));
				btnCancel.setFont(SWTResourceManager.getFont("±¼¸²", 14, 1, false, false));
				btnCancel.setForeground(SWTResourceManager.getColor(128, 128, 192));
				btnCancel.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						dialogShell.close();
					}
				});
			}
			{
				cLabel1 = new CLabel(dialogShell, SWT.NONE);
				cLabel1.setText("\ubb34\ub2e8 \ubcf5\uc81c \ubc0f \uc0ac\uc6a9\uc744 \uae08\ud569\ub2c8\ub2e4.");
				cLabel1.setBackground(SWTResourceManager.getColor(128,128,192));
				FormData cLabel1LData = new FormData();
				cLabel1LData.width = 355;
				cLabel1LData.height = 22;
				cLabel1LData.left =  new FormAttachment(27, 1000, 0);
				cLabel1LData.right =  new FormAttachment(966, 1000, 0);
				cLabel1LData.top =  new FormAttachment(458, 1000, 0);
				cLabel1LData.bottom =  new FormAttachment(538, 1000, 0);
				cLabel1.setLayoutData(cLabel1LData);
				cLabel1.setFont(SWTResourceManager.getFont("±¼¸²", 11, 1, false, false));
				cLabel1.setForeground(SWTResourceManager.getColor(0,0,64));
			}
			{
				cLabel3 = new CLabel(dialogShell, SWT.NONE);
				cLabel3.setText("\uce74\uc2a4\uba54\uce74\ud2b8\ub85c\ub2c9\uc2a4  Tel) 031-618-3500");
				cLabel3.setBackground(SWTResourceManager.getColor(128,128,192));
				FormData cLabel3LData = new FormData();
				cLabel3LData.width = 356;
				cLabel3LData.height = 28;
				cLabel3LData.left =  new FormAttachment(33, 1000, 0);
				cLabel3LData.right =  new FormAttachment(974, 1000, 0);
				cLabel3LData.top =  new FormAttachment(636, 1000, 0);
				cLabel3LData.bottom =  new FormAttachment(753, 1000, 0);
				cLabel3.setLayoutData(cLabel3LData);
				cLabel3.setFont(SWTResourceManager.getFont("±¼¸²", 12, 1, false, false));
				cLabel3.setForeground(SWTResourceManager.getColor(0, 0, 255));
				cLabel3.setAlignment(SWT.CENTER);
			}
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
}

package com.casmall.common.dialog;

import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;

import java.io.IOException;
import java.text.NumberFormat;
import java.util.Enumeration;
import java.util.LinkedHashMap;

import net.miginfocom.swt.MigLayout;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.casmall.biz.domain.CmOsMcDTO;
import com.casmall.biz.mgr.CommonManager;
import com.casmall.common.DConstants;
import com.casmall.serial.CmSerial;
import com.casmall.serial.CmSerialManager;
import com.cloudgarden.resource.SWTResourceManager;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class SerialConfig extends org.eclipse.swt.widgets.Dialog {

	private Shell dialogShell;
	private Label label;
	private Combo cboPortName;
	private Button btnCancel;
	private Button btnSave;
	private Combo cboStopBits;
	private Text txtDelayTime;
	private Text txtRetryCounts;
	private Text txtWaitTime;
	private Text txtBufferSize;
	private Combo cboParityBits;
	private Combo cboBaudRate;

	private LinkedHashMap<Integer, String> mParity = new LinkedHashMap<Integer, String>();
	private CommonManager sem = CommonManager.getInstance();
	private Combo cboDataBits;
	private String mcID = "";

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog
	 * inside a new Shell.
	 */
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			SerialConfig inst = new SerialConfig(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SerialConfig(Shell parent, int style) {
		super(parent, style);
		this.mcID = DConstants.DEFAULT_MC_ID;
		init();
	}
	
	public SerialConfig(Shell parent, int style, String mcID) {
		super(parent, style);
		this.mcID = mcID;
		init();
	}
	
	private void init() {
	} // init

	private boolean reopenPort() {
		try{
			CmSerial cs = CmSerialManager.getInstance();
			if(cs.isOpen()){
				cs.close();
			}
			cs.open();
		} catch (IOException e) {
			e.printStackTrace();
			MessageDialog.openError(dialogShell,"Port open error","Port open 중 오류가 발생하였습니다.\n\n"+e.getMessage());
			return false;
		} catch (PortInUseException piue) {
			MessageDialog.openError(dialogShell,"Port open error","Port open 중 오류가 발생하였습니다.\n\n포트가 이미 사용 중입니다.");
			return false;
		}
		return true;
    }
	
	public void open() {
		try {
			Shell parent = getParent();
			dialogShell = new Shell(parent, SWT.DIALOG_TRIM
					| SWT.APPLICATION_MODAL);
			{
				// Register as a resource user - SWTResourceManager will
				// handle the obtaining and disposing of resources
				SWTResourceManager.registerResourceUser(dialogShell);
			}

			MigLayout dialogShellLayout = new MigLayout("",
					"[left,fill]10[right]10[left, grow, fill]", "50");
			dialogShell.setLayout(dialogShellLayout); 
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Serial Config");
				label.setLayoutData("cell 0 0 3 1");
				label.setFont(SWTResourceManager.getTitleFont());
			}
			{
				label = new Label(dialogShell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_OUT);
				label.setText("Port Info");
				label.setLayoutData("cell 0 1 3 1");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Port Name");
				label.setLayoutData("cell 1 2");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Baud Rate");
				label.setLayoutData("cell 1 3");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Data Bits");
				label.setLayoutData("cell 1 4");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Parity Bits");
				label.setLayoutData("cell 1 5");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Stop Bits");
				label.setLayoutData("cell 1 6");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_OUT);
				label.setText("Etc Info");
				label.setLayoutData("cell 0 7 3 1");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Open delay time");
				label.setLayoutData("cell 1 8");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Read buffer size");
				label.setLayoutData("cell 1 9");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Read wait time");
				label.setLayoutData("cell 1 10");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Read retry count");
				label.setLayoutData("cell 1 11");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				cboPortName = new Combo(dialogShell, SWT.NONE);
				cboPortName.setLayoutData("cell 2 2");
				cboPortName.setFont(SWTResourceManager.getDefaultFont());
				cboPortName.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyBlockKeyIn(evt);
					}
				});
			}
			{
				cboBaudRate = new Combo(dialogShell, SWT.NONE);
				cboBaudRate.setLayoutData("cell 2 3");
				cboBaudRate.setFont(SWTResourceManager.getDefaultFont());
				cboBaudRate.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyBlockKeyIn(evt);
					}
				});
			}
			{
				cboDataBits = new Combo(dialogShell, SWT.NONE);
				cboDataBits.setLayoutData("cell 2 4");
				cboDataBits.setFont(SWTResourceManager.getDefaultFont());
				cboDataBits.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyBlockKeyIn(evt);
					}
				});
			}
			{
				cboParityBits = new Combo(dialogShell, SWT.NONE);
				cboParityBits.setLayoutData("cell 2 5");
				cboParityBits.setFont(SWTResourceManager.getDefaultFont());
				cboParityBits.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyBlockKeyIn(evt);
					}
				});
			}
			{
				cboStopBits = new Combo(dialogShell, SWT.NONE);
				cboStopBits.setLayoutData("cell 2 6");
				cboStopBits.setFont(SWTResourceManager.getDefaultFont());
				cboStopBits.setSize(76, 24);
				cboStopBits.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyBlockKeyIn(evt);
					}
				});
			}
			{
				btnSave = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				btnSave.setText("저장");
				btnSave.setLayoutData("cell 2 12");
				btnSave.setFont(SWTResourceManager.getDefaultFont());
				btnSave.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						btnSaveMouseDown(evt);
					}
				});
			}
			{
				btnCancel = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				btnCancel.setText("취소");
				btnCancel.setLayoutData("cell 2 12");
				btnCancel.setFont(SWTResourceManager.getDefaultFont());
				btnCancel.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						dialogShell.close();
					}
				});
			}
			{
				txtDelayTime = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtDelayTime.setLayoutData("cell 2 8, width 50!");
				txtDelayTime.setFont(SWTResourceManager.getDefaultFont());
				txtDelayTime.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});

			}
			{
				txtBufferSize = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtBufferSize.setFont(SWTResourceManager.getDefaultFont());
				txtBufferSize.setLayoutData("cell 2 9, width 50!");
				txtBufferSize.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				txtWaitTime = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtWaitTime.setFont(SWTResourceManager.getDefaultFont());
				txtWaitTime.setLayoutData("cell 2 10,width 50!");
				txtWaitTime.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				txtRetryCounts = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtRetryCounts.setFont(SWTResourceManager.getDefaultFont());
				txtRetryCounts.setLayoutData("cell 2 11, width 50!");
				txtRetryCounts.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("ms");
				label.setLayoutData("cell 2 8");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("bytes");
				label.setLayoutData("cell 2 9");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("ms");
				label.setLayoutData("cell 2 10");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(300, 392);
			dialogShell.setText("Serial Config");
			dialogShell.setLocation(getParent().toDisplay(100, 100));
			dialogShell.open();

			initCombo();
			
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initCombo() {
		mParity.put(SerialPort.PARITY_NONE, "NONE");
		mParity.put(SerialPort.PARITY_ODD, "ODD");
		mParity.put(SerialPort.PARITY_EVEN, "EVEN");
		mParity.put(SerialPort.PARITY_MARK, "MARK");
		mParity.put(SerialPort.PARITY_SPACE, "SPACE");

		int[] br = { 2400, 4800, 9600, 14400, 19200, 38400, 57600, 115200 };
		NumberFormat snf = NumberFormat.getNumberInstance();
		for (int i = 0; i < br.length; i++) {
			cboBaudRate.add(snf.format(br[i]));
		}

		@SuppressWarnings("rawtypes")
		Enumeration pList = CommPortIdentifier.getPortIdentifiers();
		while (pList.hasMoreElements()) {
			CommPortIdentifier cpi = (CommPortIdentifier) pList.nextElement();

			if (cpi.getPortType() == CommPortIdentifier.PORT_SERIAL) {
				cboPortName.add(cpi.getName());
//			} else if (cpi.getPortType() == CommPortIdentifier.PORT_PARALLEL) {
			}
		} // while

		Object[] key = mParity.keySet().toArray();
		for (int i = 0; i < key.length; i++) {
			cboParityBits.add((String) mParity.get(key[i]));
		}

		cboDataBits.add("" + SerialPort.DATABITS_8);
		cboDataBits.add("" + SerialPort.DATABITS_7);
		cboDataBits.add("" + SerialPort.DATABITS_6);
		cboDataBits.add("" + SerialPort.DATABITS_5);

		cboStopBits.add("" + SerialPort.STOPBITS_1);
		// cboStopBits.add(""+SerialPort.STOPBITS_1_5);
		cboStopBits.add("" + SerialPort.STOPBITS_2);
		
		loadConfig(this.mcID);
	} // initCombo
	
	/**
	 * Load Serial config data from Database
	 * @param mcId
	 */
	private void loadConfig(String mcId){
		try {
			CmOsMcDTO mc = sem.getOsMcEnv(mcId);
			cboPortName.setText(mc.getPort_nm());
			NumberFormat snf = NumberFormat.getNumberInstance();
			cboBaudRate.setText(snf.format(mc.getBaud_rate()));
			cboDataBits.setText(""+mc.getData_bits());
			cboParityBits.setText((String) mParity.get(mc.getParity_bits()));
			cboStopBits.setText(""+mc.getStop_bits());
			
			txtDelayTime.setText(""+mc.getPort_open_wait_time());
			txtBufferSize.setText(""+mc.getRead_buff_size());
			txtWaitTime.setText(""+mc.getRead_wait_time());
			txtRetryCounts.setText(""+mc.getRead_retry_cnt());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// If data not exist, Add data in COMBO.
	} // loadConfig
	
	/**
	 * Save button click
	 * @param evt
	 */
	private void btnSaveMouseDown(MouseEvent evt) {
		CmOsMcDTO dto;
		try {
			dto = sem.getOsMcEnv();
			dto.setPort_nm(cboPortName.getText());
			dto.setBaud_rate(Integer.parseInt(cboBaudRate.getText().replaceAll(",", "")));
			dto.setData_bits(Integer.parseInt(cboDataBits.getText()));
			Object[] keys = mParity.keySet().toArray();
			for (int i = 0; i < keys.length; i++) {
				if (cboParityBits.getText().equals(mParity.get(keys[i]))) {
					dto.setParity_bits((Integer)keys[i]);
					break;
				}
			}
			
			dto.setStop_bits(Integer.parseInt(cboStopBits.getText()));
			
			dto.setPort_open_wait_time(Integer.parseInt(txtDelayTime.getText()));
			dto.setRead_buff_size(Integer.parseInt(txtBufferSize.getText()));
			dto.setRead_wait_time(Integer.parseInt(txtWaitTime.getText()));
			dto.setRead_retry_cnt(Integer.parseInt(txtRetryCounts.getText()));
			
			sem.setOsMcEnv(dto);
			if(!reopenPort()){
				return;
			}
			MessageDialog.openInformation(dialogShell,"Update Success","정상적으로 저장되었습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		dialogShell.close();
	} // btnSaveMouseDown
	
	/**
	 * key input block
	 * @param evt
	 */
	private void verifyBlockKeyIn(VerifyEvent evt){
		if(evt.keyCode!=0)
			evt.doit = false;
	}
	/**
	 * Verify input(Only allow digits)
	 * @param evt
	 */
	private void verifyOnlyDigits(VerifyEvent evt) {
		String string = evt.text;
        char[] chars = new char[string.length()];
        string.getChars(0, chars.length, chars, 0);
        for (int i = 0; i < chars.length; i++) {
          if (!('0' <= chars[i] && chars[i] <= '9')) {
        	  evt.doit = false;
            return;
          } // if
        }// for
	}// verifyOnlyDigits
}

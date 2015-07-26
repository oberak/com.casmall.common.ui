package com.casmall.common.dialog;

import gnu.io.PortInUseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.miginfocom.swt.MigLayout;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.casmall.biz.domain.CmMsgAttrDTO;
import com.casmall.biz.domain.CmMsgDTO;
import com.casmall.biz.mgr.CommonManager;
import com.casmall.common.DConstants;
import com.casmall.common.StringUtil;
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
public class MessageConfig extends org.eclipse.swt.widgets.Dialog {
	protected static Log logger = LogFactory.getLog(MessageConfig.class);
	
	private Shell dialogShell;
	private Label label;
	private Button btnCancel;
	private Button btnSave;
	private Text txtLineFeedChar;
	private Text txtLineFeedHex;
	private Button rdoLineFeedFlagChar;
	private Button rdoLineFeedFlag;

	private CommonManager sem = CommonManager.getInstance();
	private String mcID = "";
	private Text txtLineLength;
	private Text txtWeightSttPos;
	private Text txtWeightEndPos;
	private Text txtWeightLength;
	private Text txtMcnoSttPos;
	private Text txtMcnoEndPos;
	private Button btnLoad;
	private Text txtSample;
	private Text txtMcnoLength;
	private Label lblLineFeedHexSt;
	private Label lblLineFeedHexEd;
	private Text txtSampleOutput;

	/**
	 * Auto-generated main method to display this org.eclipse.swt.widgets.Dialog
	 * inside a new Shell.
	 */
	public static void main(String[] args) {
		try {
			Display display = Display.getDefault();
			Shell shell = new Shell(display);
			MessageConfig inst = new MessageConfig(shell, SWT.NULL);
			inst.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MessageConfig(Shell parent, int style) {
		super(parent, style);
		this.mcID = DConstants.DEFAULT_MC_ID;
	}
	
	public MessageConfig(Shell parent, int style, String mcID) {
		super(parent, style);
		this.mcID = mcID;
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
				label.setText("Message Config");
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
				label.setText("Line Feed");
				label.setLayoutData("cell 1 2"); //  1 2
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Line Length");
				label.setLayoutData("cell 1 4");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_OUT);
				label.setText("Message Detail");
				label.setLayoutData("cell 0 5 3 1");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Data parts");
				label.setLayoutData("cell 1 6");
				label.setFont(SWTResourceManager.getDefaultFont());
			}

			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Mc No");
				label.setLayoutData("cell 1 7");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.SEPARATOR | SWT.HORIZONTAL | SWT.SHADOW_OUT);
				label.setText("Data sample");
				label.setLayoutData("cell 0 8 3 1");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("Sample Data");
				label.setLayoutData("cell 1 9");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setLayoutData("cell 1 11");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setLayoutData("cell 1 12");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				btnSave = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				btnSave.setText("저장");
				btnSave.setLayoutData("cell 2 13");
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
				btnCancel.setLayoutData("cell 2 13");
				btnCancel.setFont(SWTResourceManager.getDefaultFont());
				btnCancel.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						try {
	                        CmSerialManager.getInstance().setCallbackWork(true);
                        } catch (IOException e) {
	                        e.printStackTrace();
                        }
						dialogShell.close();
					}
				});
			}
			{
				rdoLineFeedFlagChar = new Button(dialogShell, SWT.RADIO | SWT.LEFT);
				rdoLineFeedFlagChar.setText("Char");
				rdoLineFeedFlagChar.setLayoutData("cell 2 3,width 50!");
				rdoLineFeedFlagChar.addSelectionListener(new SelectionAdapter() {
					public void widgetSelected(SelectionEvent evt) {
						setVisibleLineFeedChar(rdoLineFeedFlagChar.getSelection());
					}
				});
			}

			{
				txtLineFeedChar = new Text(dialogShell, SWT.LEFT | SWT.BORDER);
				txtLineFeedChar.setLayoutData("cell 2 3,width 100!");
				txtLineFeedChar.setFont(SWTResourceManager.getDefaultFont());
				txtLineFeedChar.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent evt) {
						txtLineFeedHex.setText(StringUtil.byteArrayToHex(txtLineFeedChar.getText().getBytes()));
					}
				});
			}
			{
				lblLineFeedHexSt = new Label(dialogShell, SWT.NONE);
				lblLineFeedHexSt.setText("(Hex:");
				lblLineFeedHexSt.setLayoutData("cell 2 3,width 40!");
				lblLineFeedHexSt.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtLineFeedHex = new Text(dialogShell, SWT.LEFT | SWT.BORDER);
				txtLineFeedHex.setFont(SWTResourceManager.getDefaultFont());
				txtLineFeedHex.setLayoutData("cell 2 3,width 200!");
				txtLineFeedHex.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent evt) {
						if(txtLineFeedHex.getText().length() == 0){
							txtLineFeedChar.setText("");
						}else if(txtLineFeedHex.getText().length()%2==0){
							try{
								txtLineFeedChar.setText(new String(StringUtil.hexToByteArray(txtLineFeedHex.getText())));
							}catch(NumberFormatException nfe){
								txtLineFeedChar.setText("#NA:Format Wrong!!");
							}
						}else{
							txtLineFeedChar.setText("#NA");
						}
					}
				});
			}
			{
				lblLineFeedHexEd = new Label(dialogShell, SWT.NONE);
				lblLineFeedHexEd.setText(")");
				lblLineFeedHexEd.setLayoutData("cell 2 3");
				lblLineFeedHexEd.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtLineLength = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtLineLength.setFont(SWTResourceManager.getDefaultFont());
				txtLineLength.setLayoutData("cell 2 4,width 50!");
				txtLineLength.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.NONE);
				label.setText("bytes");
				label.setLayoutData("cell 2 4");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtMcnoSttPos = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtMcnoSttPos.setFont(SWTResourceManager.getDefaultFont());
				txtMcnoSttPos.setLayoutData("cell 2 7,width 50!");
				txtMcnoSttPos.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent evt) {
						calcMcnoLength();
					}
				});
				txtMcnoSttPos.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.LEFT);
				label.setText("~");
				label.setLayoutData("cell 2 7, width 10!");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtMcnoEndPos = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtMcnoEndPos.setFont(SWTResourceManager.getDefaultFont());
				txtMcnoEndPos.setLayoutData("cell 2 7,width 50!");
				txtMcnoEndPos.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent evt) {
						calcMcnoLength();
					}
				});
				txtMcnoEndPos.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.LEFT);
				label.setText("( Length: ");
				label.setLayoutData("cell 2 7, width 60!");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtMcnoLength = new Text(dialogShell, SWT.RIGHT | SWT.BORDER | SWT.READ_ONLY);
				txtMcnoLength.setFont(SWTResourceManager.getDefaultFont());
				txtMcnoLength.setLayoutData("cell 2 7,width 30!");
				txtMcnoLength.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.LEFT);
				label.setText(" )");
				label.setLayoutData("cell 2 7");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				rdoLineFeedFlag = new Button(dialogShell, SWT.RADIO | SWT.LEFT);
				rdoLineFeedFlag.setText("Enter (Hex: CRLF)");
				rdoLineFeedFlag.setLayoutData("cell 2 2");
			}
			{
				txtWeightSttPos = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtWeightSttPos.setFont(SWTResourceManager.getDefaultFont());
				txtWeightSttPos.setLayoutData("cell 2 6,width 50!");
				txtWeightSttPos.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent evt) {
						calcWeightLen();
					}
				});
				txtWeightSttPos.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.LEFT);
				label.setText("~");
				label.setLayoutData("cell 2 6, width 10!");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtWeightEndPos = new Text(dialogShell, SWT.RIGHT | SWT.BORDER);
				txtWeightEndPos.setFont(SWTResourceManager.getDefaultFont());
				txtWeightEndPos.setLayoutData("cell 2 6,width 50!");
				txtWeightEndPos.addKeyListener(new KeyAdapter() {
					public void keyReleased(KeyEvent evt) {
						calcWeightLen();
					}
				});
				txtWeightEndPos.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.LEFT);
				label.setText("( Length: ");
				label.setLayoutData("cell 2 6, width 60!");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtWeightLength = new Text(dialogShell, SWT.RIGHT | SWT.BORDER | SWT.READ_ONLY);
				txtWeightLength.setFont(SWTResourceManager.getDefaultFont());
				txtWeightLength.setLayoutData("cell 2 6,width 30!");
				txtWeightLength.addVerifyListener(new VerifyListener() {
					public void verifyText(VerifyEvent evt) {
						verifyOnlyDigits(evt);
					}
				});
			}
			{
				label = new Label(dialogShell, SWT.LEFT);
				label.setText(" )");
				label.setLayoutData("cell 2 6");
				label.setFont(SWTResourceManager.getDefaultFont());
			}
			{
				txtSample = new Text(dialogShell, SWT.MULTI | SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
				txtSample.setLayoutData("cell 2 9 1 4,growy");
				txtSample.setOrientation(SWT.HORIZONTAL);
				txtSample.setFont(SWTResourceManager.getFont("굴림체", 8, 0, false, false));
				txtSample.setBackground(SWTResourceManager.getColor(0, 0, 0));
				txtSample.setForeground(SWTResourceManager.getColor(255, 255, 0));
			}
			{
				txtSampleOutput = new Text(dialogShell, SWT.MULTI | SWT.READ_ONLY | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);
				txtSampleOutput.setLayoutData("cell 2 9 1 4,growy");
				txtSampleOutput.setOrientation(SWT.HORIZONTAL);
				txtSampleOutput.setFont(SWTResourceManager.getFont("굴림체", 8, 0, false, false));
				txtSampleOutput.setBackground(SWTResourceManager.getColor(0, 0, 0));
				txtSampleOutput.setForeground(SWTResourceManager.getColor(255, 255, 0));
			}
			{
				btnLoad = new Button(dialogShell, SWT.PUSH | SWT.CENTER);
				btnLoad.setText("Load");
				btnLoad.setLayoutData("cell 1 10");
				btnLoad.setFont(SWTResourceManager.getDefaultFont());
				btnLoad.addMouseListener(new MouseAdapter() {
					public void mouseDown(MouseEvent evt) {
						btnLoadMouseDown(evt);
					}
				});
			}

			dialogShell.layout();
			dialogShell.pack();
			dialogShell.setSize(698, 514);
			dialogShell.setText("Message Config");
			dialogShell.setLocation(getParent().toDisplay(100, 100));
			dialogShell.open();

			init();
			
			Display display = dialogShell.getDisplay();
			while (!dialogShell.isDisposed()) {
				if (!display.readAndDispatch())
					display.sleep();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void init() {
		loadConfig(this.mcID);
		try {
	        CmSerialManager.getInstance().setCallbackWork(false);
        } catch (IOException e) {
	        e.printStackTrace();
        }
	} // init

	private void calcMcnoLength() {
		if("".equals(txtMcnoSttPos.getText()) || "".equals(txtMcnoEndPos.getText()) || "-".equals(txtMcnoSttPos.getText()) || "-".equals(txtMcnoEndPos.getText())){
			txtMcnoLength.setText("");
			return;
		}
		txtMcnoLength.setText(""+(Integer.parseInt(txtMcnoEndPos.getText()) - Integer.parseInt(txtMcnoSttPos.getText()) +1));
	} // calcMcnoLength

	private void calcWeightLen() {
		if("".equals(txtWeightSttPos.getText()) || "".equals(txtWeightEndPos.getText()) || "-".equals(txtWeightSttPos.getText()) || "-".equals(txtWeightEndPos.getText())){
			txtWeightLength.setText("");
			return;
		}
		txtWeightLength.setText(""+(Integer.parseInt(txtWeightEndPos.getText()) - Integer.parseInt(txtWeightSttPos.getText()) +1));
	} // calcWeightLen

	/**
	 * Load Serial config data from Database
	 * @param mcId
	 */
	private void loadConfig(String mcId){
		try {
			CmMsgDTO dto = sem.getMsgEnv(mcId);
			
			if(DConstants.HEX_CRLF.equals(dto.getEnd_char()) ){
				rdoLineFeedFlag.setSelection(true);
				setVisibleLineFeedChar(false);
			}else{
				rdoLineFeedFlagChar.setSelection(true);
				txtLineFeedChar.setText(new String(dto.getEnd()));
				txtLineFeedHex.setText(dto.getEnd_char());
				setVisibleLineFeedChar(true);
			} // if
			
			txtLineLength.setText(""+dto.getMsg_tot_len());
			
			// attr
			List<CmMsgAttrDTO> attrs = dto.getAttrList();
			if(attrs !=null){
				for(int i=0; i<attrs.size();i++){
					if(DConstants.MSG_ATTR_WEITHT.equals(attrs.get(i).getAttr_nm())){
						txtWeightSttPos.setText(""+attrs.get(i).getStt_pos());
						txtWeightEndPos.setText(""+(attrs.get(i).getStt_pos()+attrs.get(i).getAttr_len()-1));
						txtWeightLength.setText(""+attrs.get(i).getAttr_len());
					}
					if(DConstants.MSG_ATTR_MC_NO.equals(attrs.get(i).getAttr_nm())){
						txtMcnoSttPos.setText(""+attrs.get(i).getStt_pos());
						txtMcnoEndPos.setText(""+(attrs.get(i).getStt_pos()+attrs.get(i).getAttr_len()-1));
						txtMcnoLength.setText(""+attrs.get(i).getAttr_len());
					}
					if(DConstants.MSG_ATTR_STATUS.equals(attrs.get(i).getAttr_nm())){
						
					}
				} // for
			} // if
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} // loadConfig
	
	/**
	 * Set Visible LineFeed parts
	 * 
	 * @param b
	 */
	private void setVisibleLineFeedChar(boolean b){
		if(b){
			txtLineFeedChar.setVisible(true);
			txtLineFeedHex.setVisible(true);
			lblLineFeedHexSt.setVisible(true);
			lblLineFeedHexEd.setVisible(true);
			txtLineFeedChar.setFocus();
		}else{
			txtLineFeedChar.setVisible(false);
			txtLineFeedHex.setVisible(false);
			lblLineFeedHexSt.setVisible(false);
			lblLineFeedHexEd.setVisible(false);
		}
	} // setVisibleLineFeedChar
	
	/**
	 * Set DTO from view
	 * @return
	 */
	private CmMsgDTO getMsgDtoFromView(){
		CmMsgDTO dto = null;
		try {
			dto = sem.getMsgEnv(mcID);
			if(rdoLineFeedFlag.getSelection()){
				dto.setEnd_char(DConstants.HEX_CRLF);
			}else{
				dto.setEnd_char(txtLineFeedHex.getText());
			} // if
			dto.setMsg_tot_len(Integer.parseInt(txtLineLength.getText()));
			
			// attr
			List<CmMsgAttrDTO> attrs = dto.getAttrList();
			if(attrs !=null){
				for(int i=0; i<attrs.size();i++){
					if(DConstants.MSG_ATTR_WEITHT.equals(attrs.get(i).getAttr_nm())){
						attrs.get(i).setStt_pos(Integer.parseInt(txtWeightSttPos.getText()));
						attrs.get(i).setAttr_len(Integer.parseInt(txtWeightLength.getText()));
					}
					if(DConstants.MSG_ATTR_MC_NO.equals(attrs.get(i).getAttr_nm())){
						attrs.get(i).setStt_pos(Integer.parseInt(txtMcnoSttPos.getText()));
						attrs.get(i).setAttr_len(Integer.parseInt(txtMcnoLength.getText()));
					}
					if(DConstants.MSG_ATTR_STATUS.equals(attrs.get(i).getAttr_nm())){
						
					}
				} // for
			} // if
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dto;
	} // getMsgDtoFromView
	
	/**
	 * Check input validate
	 * @return
	 */
	private boolean validate(){
		if(rdoLineFeedFlagChar.getSelection()){
			if("".equals(txtLineFeedChar.getText())){
				MessageDialog.openInformation(dialogShell,"Validation","Line Feed is not exists");
				txtLineFeedChar.setFocus();
				return false;
			}
			if("#NA".equals(txtLineFeedChar.getText())){
				MessageDialog.openInformation(dialogShell,"Validation","Line Feed is invalid");
				txtLineFeedChar.setFocus();
				return false;
			}
		}
		if("".equals(txtLineLength.getText()) || "-".equals(txtLineLength.getText())){
			MessageDialog.openInformation(dialogShell,"Validation","Line Length is not exists");
			txtLineLength.setFocus();
			return false;
		}
		if("".equals(txtWeightLength.getText()) || Integer.parseInt(txtWeightLength.getText())<=0){
			MessageDialog.openInformation(dialogShell,"Validation","Data parts length is invalid.");
			txtWeightSttPos.setFocus();
			return false;
		}
		if("".equals(txtMcnoLength.getText()) || Integer.parseInt(txtMcnoLength.getText())<=0){
			MessageDialog.openInformation(dialogShell,"Validation","Mc No length is invalid.");
			txtMcnoSttPos.setFocus();
			return false;
		}
		if(Integer.parseInt(this.txtLineLength.getText()) <= Integer.parseInt(this.txtWeightEndPos.getText()) ){
			MessageDialog.openInformation(dialogShell,"Validation","Data parts end position must be greater than Line Length.");
			txtWeightEndPos.setFocus();
			return false;
		}
		if(Integer.parseInt(this.txtLineLength.getText()) <= Integer.parseInt(this.txtMcnoEndPos.getText()) ){
			MessageDialog.openInformation(dialogShell,"Validation","Mc No end position must be greater than Line Length.");
			txtMcnoEndPos.setFocus();
			return false;
		}
		return true;
	} // validate
	
	/**
	 * Verify input(Only allow digits)
	 * @param evt
	 */
	private void verifyOnlyDigits(VerifyEvent evt) {
		String string = evt.text;
        char[] chars = new char[string.length()];
        string.getChars(0, chars.length, chars, 0);
        for (int i = 0; i < chars.length; i++) {
          if (!('0' <= chars[i] && chars[i] <= '9' || chars[i]=='-')) {
        	  evt.doit = false;
            return;
          } // if
        }// for
	}// verifyOnlyDigits
	
	/**
	 * Save button click
	 * @param evt
	 */
	private void btnSaveMouseDown(MouseEvent evt) {
		// validation check.
		if(!validate()){
			return;
		}
		
		// process save
		// set data
		CmMsgDTO dto = getMsgDtoFromView();
		try {
			// update data
			int cnt = sem.setMsgEnv(dto);
			if(cnt != 1){
				throw new IOException("Update MsgEnv fail.");
			}
			
			if(!reopenPort()){
				return;
			}
			MessageDialog.openInformation(dialogShell,"Update Success","정상적으로 저장되었습니다.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		// callback 재개
		try {
	        CmSerialManager.getInstance().setCallbackWork(true);
        } catch (IOException e) {
	        e.printStackTrace();
        }
		dialogShell.close();
	} // btnSaveMouseDown

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

	/**
	 * Load button down event
	 * @param evt
	 */
	private void btnLoadMouseDown(MouseEvent evt) {
		if(!validate()){
			return;
		}
		CmMsgDTO dto = getMsgDtoFromView();
		byte[] read;
		ArrayList<StringBuffer[]> leftData = new ArrayList<StringBuffer[]>();
		ArrayList<byte[]> readData = new ArrayList<byte[]>();
		StringBuffer[] arr = new StringBuffer[3];
		try {
			CmSerial cs = CmSerialManager.getInstance();
			try{
				if(cs.isOpen())
					cs.close();
				cs.open();
				// callback 중지
			}catch(PortInUseException ie){
				MessageDialog.openError(dialogShell,"Port open error","Port open 중 오류가 발생하였습니다.\n\n포트가 이미 사용 중입니다.");
				return;
			}catch(IOException ie){
				MessageDialog.openError(dialogShell,"Port open error","Port open 중 오류가 발생하였습니다.\n\n"+ie.getMessage());
				return;
			}
			
			txtSample.setText("");
			txtSampleOutput.setText("");

			int readerr=0;
			while(true){
				Thread.sleep(300);
				read = cs.readLine(dto);
				if(read == null){
					readerr++;
					if(readerr == 10){
						read = cs.readAll();
						if(read == null || read.length == 0){
							break;
						}
					}else if(readerr < 10){
						continue;
					}else{
						break;
					}
				}
				readData.add(read);
				arr = new StringBuffer[4];
				arr[0] = new StringBuffer(); // Idx
				arr[1] = new StringBuffer(); // Str
				arr[2] = new StringBuffer(); // Hex
				for(int i=0; i<read.length;i++){
					arr[0].append(String.format("%-3d", i%1000));
					if(read[i] == 13){
						arr[1].append("LF ");
					}else if(read[i] == 10){
						arr[1].append("CR ");
					}else{
						arr[1].append((char)read[i]+"  ");
					}
					arr[2].append(String.format("%02X ", read[i]));
				}
				leftData.add(arr);
				if(readData.size()>=10 || readerr >=10){
					break;
				}
			}

			StringBuffer out = new StringBuffer(1024);
			for(int i=0; i< leftData.size(); i++){
				out.append("STR:"+leftData.get(i)[1] +"\n");
				out.append("IDX:"+leftData.get(i)[0] +"\n");
				out.append("HEX:"+leftData.get(i)[2] +"\n");
				out.append("----------------------------------\n");
			}
			if(readData.size()==0){
				txtSample.setText("Reading data is empty!");
			}else {
				txtSample.setText(out.toString());
				txtSampleOutput.setText(parseSampleMsg(dto, readData).toString());
			}
			
			cs.close();
			cs.open();
		} catch (IOException e) {
			e.printStackTrace();
			MessageDialog.openError(dialogShell,"Port open error","Port open 중 오류가 발생하였습니다.\n\n"+e.getMessage());
			return;
		} catch (InterruptedException e) {
			e.printStackTrace();
			MessageDialog.openError(dialogShell,"Port open error","Port open 중 오류가 발생하였습니다.\n\n"+e.getMessage());
			return;
		} catch (PortInUseException e) {
	        e.printStackTrace();
			MessageDialog.openError(dialogShell,"Port open error","Port open 중 오류가 발생하였습니다.\n\n포트가 이미 사용 중입니다.");
        }
	} // btnLoadMouseDown
	
	private StringBuffer parseSampleMsg(CmMsgDTO msgEnv, ArrayList<byte[]> readData) throws IOException{
		StringBuffer output = new StringBuffer();
		CmSerial cs = CmSerialManager.getInstance();
		
		HashMap<String, Object> data;
		for(int i=0; i<readData.size();i++){
			data = null;
			output.append("PARSE:");
			try{
				data = cs.parse(msgEnv, readData.get(i));
				Object weight = data.get(DConstants.MSG_ATTR_WEITHT);
				Object mcno = data.get(DConstants.MSG_ATTR_MC_NO);
				output.append("Length-["+readData.get(i).length+"] ");
				output.append("Weight-["+weight+"]");
				try{
					StringUtil.parseDouble((String)weight);
				}catch(NumberFormatException nfe){
					output.append("-Error!! ");
				}
				output.append(" MC No-["+mcno+"]");
				try{
					Integer.parseInt((String)mcno);
				}catch(NumberFormatException nfe){
					output.append("-Error!! ");
				}
				output.append("\n");
			}catch(IOException ie){
				if(logger.isInfoEnabled()){
					logger.info(ie.getMessage());
				}
				output.append(ie.getMessage()+"\n");
			}
			
			output.append("ANALY:Length-["+readData.get(i).length+"] ");
			ArrayList<HashMap<String, Object>> anData = StringUtil.findDigit(new String(readData.get(i)));
			if(anData.size()==0){
				output.append("Weight-[#NA] ");
				output.append("Mc No-[#NA]");
			}
			if(anData.size()>0){
				output.append("Weight-["+anData.get(0).get("start")+"~"+anData.get(0).get("end")+"] ");
			}
			if(anData.size()<2){
				output.append("Mc No-[#NA]");
			}else{
				output.append("Mc No-["+anData.get(1).get("start")+"~"+anData.get(1).get("end")+"]");
			}
			output.append("\n");
			output.append("APPLY:Length-["+readData.get(i).length+"] ");
			if(anData.size()>0){
				output.append("Weight-["+StringUtil.parseDouble((String)anData.get(0).get("data"))+"] ");
			}
			if(anData.size()>1){
				output.append("Mc No-["+anData.get(1).get("data")+"] ");
			}
			output.append("\n");
			output.append("----------------------------------\n");
		}
		
		return output;
	}
}

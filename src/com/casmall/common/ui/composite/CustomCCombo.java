package com.casmall.common.ui.composite;

import java.util.ArrayList;

import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Composite;

public class CustomCCombo {
	ArrayList<String> keyList = new ArrayList<String>();
	ArrayList<String> valueList = new ArrayList<String>();
	CCombo cb;
	public CustomCCombo(Composite parent, int style) {
		cb = new CCombo(parent, style);
    }
	
	public void add(String key, String value){
		cb.add(value);
		keyList.add(key);
		valueList.add(value);
	}
	
	public void setText(String key){
		cb.select(find(key));
	}
	
	public String getText(){
		if(cb.getSelectionIndex()>=0)
			return keyList.get(cb.getSelectionIndex());
		return "";
	}
	
	private int find(String key){
		for(int i=0; i<keyList.size();i++){
			if(keyList.get(i).equals(key))
				return i;
		}
		return -1;
	}
	
	public void setLayoutData(Object layoutData){
		cb.setLayoutData(layoutData);
	}
	
	public void setFont(Font font){
		cb.setFont(font);
	}
	
	public void setEditable(boolean editable){
		cb.setEditable(editable);
	}
	
	public boolean setFocus(){
		return cb.setFocus();
	}
}

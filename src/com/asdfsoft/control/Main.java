package com.asdfsoft.control;

import javax.swing.JFileChooser;


public class Main {
	
	public static void main(String[] args) {
		JFileChooser j = new JFileChooser();
		j.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		Integer opt = j.showSaveDialog(null);
		if(opt == JFileChooser.APPROVE_OPTION) {
			String path = j.getSelectedFile().getAbsolutePath();
			CaptureThread captureThread = new CaptureThread(path);
			new Thread(captureThread).start();
		}
		else {
			CaptureThread captureThread = new CaptureThread("C://users//");
			new Thread(captureThread).start();
		}
	}
}

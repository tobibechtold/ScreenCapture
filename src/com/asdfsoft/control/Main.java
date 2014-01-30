package com.asdfsoft.control;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		File f = new File("sc.ini");
		
		if(f.exists()) {
			FileReader fr;
			BufferedReader br = null; 
			try {
				fr = new FileReader(f);
				br = new BufferedReader(fr);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String path = null;
				try {
					while(br.ready()) {
						path = br.readLine();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				CaptureThread captureThread = new CaptureThread(path);
				new Thread(captureThread).start();
			}
			

			else {
				CaptureThread captureThread = new CaptureThread("C:\\users\\");
				new Thread(captureThread).start();
			}
		}

		
	
}

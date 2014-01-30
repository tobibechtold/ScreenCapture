package com.asdfsoft.control;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CaptureThread implements Runnable{
	
	private String path;
	
	public CaptureThread(String path) {
		this.path = path;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int i = 0;
		while(true) {
			
			try {
				Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage capture = null;
				try {
					capture = new Robot().createScreenCapture(screenRect);
				} catch (AWTException e) {
					e.printStackTrace();
				}
				try {
					if(!path.endsWith("\\")) {
						path = path + "\\";
					}
					File f = new File(path + "capture"+i+".jpg");
					++i;
					ImageIO.write(capture, "jpg", f);
				} catch (IOException e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}

package ua.univer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormMain {

//class MyThreadText implements Runnable {
//	JTextField text;
//
////	public MyThreadText(JTextField text) {
////		this.text = text;
////	}
//
//	@Override
//	public void run() {
//		for (int i = 0; i < 100; i++) {
//			text.setText("" + i);
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e1) {
//				e1.printStackTrace();
//			}
//		}
//	}
//
//}
	public static void main(String[] args) {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(300, 200);
		JPanel panel = new JPanel();
		fr.setContentPane(panel);
		JTextField text = new JTextField("                       ");
		JButton button = new JButton("Ok");
		button.addActionListener((e) -> {
//			new Thread(new FormMain().new MyThreadText(text)).start();
			new Thread(() -> {
				for (int i = 0; i < 100; i++) {
					text.setText("" + i);
					try {
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
			}).start();

		});
		panel.add(text);
		panel.add(button);

		fr.setVisible(true);
	}

}

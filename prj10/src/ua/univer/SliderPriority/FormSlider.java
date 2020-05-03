package ua.univer.SliderPriority;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class FormSlider {
	static Thread thL;
	static Thread thR;

	public static void main(String[] args) {
		JFrame fr = new JFrame();
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setSize(550, 300);
		JPanel panel = new JPanel();
		JSlider slider = new JSlider();
		slider.setMinimum(0);
		slider.setMaximum(100);
		slider.setValue(50);
		JButton btnLM = new JButton("-");
		btnLM.addActionListener((e) -> {
			if (thL.getPriority() > Thread.MIN_PRIORITY)
				thL.setPriority(thL.getPriority() - 1); // приоритеты влияют когда есть ограниченость ресурсов!!!
		});
		JButton btnLP = new JButton("+");
		btnLM.addActionListener((e) -> {
			if (thL.getPriority() < Thread.MAX_PRIORITY)
				thL.setPriority(thL.getPriority() + 1);
		});
		JButton btnRM = new JButton("-");
		btnLM.addActionListener((e) -> {
			if (thR.getPriority() > Thread.MIN_PRIORITY)
				thR.setPriority(thR.getPriority() - 1);
		});
		JButton btnRP = new JButton("+");
		btnLM.addActionListener((e) -> {
			if (thR.getPriority() < Thread.MAX_PRIORITY)
				thR.setPriority(thR.getPriority() + 1);
		});
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener((e) -> {
			thL = new Thread(() -> {
				while (true) {
					slider.setValue(slider.getValue() - 1);
				}
			});
			thR = new Thread(() -> {
				while (true) {
					slider.setValue(slider.getValue() + 1);
				}
			});
			thL.start();
			thR.start();
		});

		panel.add(btnLM);
		panel.add(btnLP);
		panel.add(slider);
		panel.add(btnRM);
		panel.add(btnRP);
		panel.add(btnStart);
		fr.setContentPane(panel);
		fr.setVisible(true);

	}

}

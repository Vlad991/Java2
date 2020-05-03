package ua.univer.gui;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ua.univer.*;
import ua.univer.figures.base.Point;
import ua.univer.figures.poly.PolyPointsDynamic;

public class FormFigure {
	JPanel panel;
	public static void fillPoints(PolyPointsDynamic poly){
		poly.add(new Point(150,90));
		poly.add(new Point(60,50));
		poly.add(new Point(200,500));
		poly.add(new Point(90,50));
		poly.add(new Point(190,150));
		poly.add(new Point(100,500));
		poly.add(new Point(110,510));
	}
	public static void main(String[] args) {
		PolyPointsDynamic poly = new PolyPointsDynamic();		
		//fillPoints(poly);		
		JFrame win = new JFrame();
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.setSize(400, 500);
		JPanel panel = new JPanel();
		JButton button = new JButton("Ok");	
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Graphics gr = panel.getGraphics();
				for (int i = 0; i < poly.size(); i++) {
					gr.drawOval(poly.get(i).getX(), poly.get(i).getY(), 20, 20);
				if(i>0)	gr.drawLine(poly.get(i-1).getX(), poly.get(i-1).getY(), poly.get(i).getX(), poly.get(i).getY());
				}				
			}
		});
		panel.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				Graphics gr = panel.getGraphics();
				if(e.getButton()==MouseEvent.BUTTON1){
					gr.drawOval(e.getX(), e.getY(), 20, 20);
					poly.add(new Point(e.getX(),e.getY()));
				}
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		panel.add(button);
		win.setContentPane(panel);
		win.setVisible(true);
	}
	
	
}
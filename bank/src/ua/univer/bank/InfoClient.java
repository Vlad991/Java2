package ua.univer.bank;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InfoClient extends JDialog {
	
	private static Bank bank;

	private static final long serialVersionUID = 1L;
	private Client client;

	private JLabel lbClientSum = new JLabel("Client sum: ");

	private JComboBox comboTransaction;

	private JTextField txtSum = new JTextField();
	private JTextField txtSumForTransaction = new JTextField();

	private JButton btnDoTransaction = new JButton("Do transaction");
	private JButton btnExit = new JButton("exit");

	public static void main(String[] args) {
		bank = new Bank(1000000);
		new InfoClient(new Client("Vasya", 1000, bank));
	}

	public InfoClient(Client client) {
		this.client = client;
		this.setTitle("Client " + client.getName());
		this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.setLayout(new GridLayout(8, 2));
		this.setBounds(100, 50, 500, 300);
		String[] items = { "Get cash: ", "Add cash: ", "Transfer cash: ", "Pay amount : ", "Exchange amount : " };
		comboTransaction = new JComboBox(items);

		this.add(lbClientSum);
		this.add(txtSum);
		this.add(comboTransaction);
		this.add(txtSumForTransaction);
		this.add(btnDoTransaction);
		this.add(btnExit);

		comboTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showClientSum();
			}
		});

		btnDoTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch ((String)comboTransaction.getSelectedItem()) {
				case "Get cash: ":
					client.getAccount().getCash(Integer.parseInt(txtSumForTransaction.getText()));
					break;
				case "Add cash: ":
					client.getAccount().addCash(Integer.parseInt(txtSumForTransaction.getText()));
					break;
				case "Transfer cash: ":
					client.getAccount().transferCashToClient(new Client("Petya", 200, bank), Integer.parseInt(txtSumForTransaction.getText()));
					break;
				case "Pay amount : ":
					client.getAccount().payAmount(Integer.parseInt(txtSumForTransaction.getText()));
					break;
				case "Exchange amount : ":
					client.getAccount().exchangeAmount(Integer.parseInt(txtSumForTransaction.getText()));
					break;
				default:
					break;
				}
				refreshForm();
			}
		});

		refreshForm();
		this.setVisible(true);

	}

	protected void showClientSum() {
		txtSum.setText("$" + client.getAccount().getSum());
	}

	private void refreshForm() {
		showClientSum();
	}

}

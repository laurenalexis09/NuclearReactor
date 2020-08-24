import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Window;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class Reactor extends JFrame {

	//text fields

	private JTextField temp = new JTextField(10);
	private JTextField flow = new JTextField(10);	
	private JTextField pressure = new JTextField(10);	
	private JTextField tempUpdate = new JTextField();
	private JTextField flowUpdate = new JTextField();	
	private JTextField pressureUpdate = new JTextField();	
	private JTextField welcome = new JTextField("Welcome to Three Mile Island Nuclear Generating Station");
	private JTextField currentCond = new JTextField("Current reactor conditions");
	private JTextField updateInfo = new JTextField("Update reactor conditions:");
	private JTextField messages = new JTextField("System status:");
	private JTextField messages1 = new JTextField("Temperature is in normal range");
	private JTextField messages2 = new JTextField("Flow is in normal range");
	private JTextField messages3 = new JTextField("Pressure is in normal range");
	private JTextField volume = new JTextField("Full");

	//labels
	
	private	JLabel tempLabel = new JLabel("Temperature:", JLabel.CENTER);
	private JLabel flowLabel = new JLabel("Flow:", JLabel.CENTER);
	private JLabel pressureLabel = new JLabel("Pressure:", JLabel.CENTER);
	private	JLabel tempLabelTwo = new JLabel("Temperature:", JLabel.CENTER);
	private JLabel flowLabelTwo = new JLabel("Flow:", JLabel.CENTER);
	private JLabel pressureLabelTwo = new JLabel("Pressure:", JLabel.CENTER);
	private JLabel tankVolume = new JLabel("Tank level:", JLabel.CENTER);

	//border
	private	Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
	
	//button
	private	UpdateButton update = new UpdateButton(this);

	
	//JPanels
	private JPanel currentField = new JPanel();
	private JPanel infoField = new JPanel();
	private JPanel textField = new JPanel();
	private JPanel updateField = new JPanel();
	private JPanel messageField = new JPanel();
	private JPanel uField = new JPanel();

	//constructor
	public Reactor() {
		
		//Text aligment
		tempUpdate.setHorizontalAlignment(JTextField.CENTER);
		flowUpdate.setHorizontalAlignment(JTextField.CENTER);
		pressureUpdate.setHorizontalAlignment(JTextField.CENTER);
		temp.setHorizontalAlignment(JTextField.CENTER);
		flow.setHorizontalAlignment(JTextField.CENTER);
		pressure.setHorizontalAlignment(JTextField.CENTER);
		welcome.setHorizontalAlignment(JTextField.CENTER);
		messages.setHorizontalAlignment(JTextField.CENTER);
		messages1.setHorizontalAlignment(JTextField.CENTER);
		messages2.setHorizontalAlignment(JTextField.CENTER);
		messages3.setHorizontalAlignment(JTextField.CENTER);
		volume.setHorizontalAlignment(JTextField.CENTER);
		currentCond.setHorizontalAlignment(JTextField.CENTER);

		//Font sizing and bolding
		tempUpdate.setFont(tempUpdate.getFont().deriveFont(Font.BOLD, 14f));
		flowUpdate.setFont(flowUpdate.getFont().deriveFont(Font.BOLD, 14f));
		pressureUpdate.setFont(pressureUpdate.getFont().deriveFont(Font.BOLD, 14f));
		tempLabelTwo.setFont(pressureUpdate.getFont().deriveFont(Font.BOLD, 14f));
		flowLabelTwo.setFont(pressureUpdate.getFont().deriveFont(Font.BOLD, 14f));
		pressureLabelTwo.setFont(pressureUpdate.getFont().deriveFont(Font.BOLD, 14f));
		tankVolume.setFont(pressureUpdate.getFont().deriveFont(Font.BOLD, 14f));
		updateInfo.setFont(pressureUpdate.getFont().deriveFont(Font.BOLD, 12f));
		temp.setFont(temp.getFont().deriveFont(Font.BOLD, 14f));
		flow.setFont(flow.getFont().deriveFont(Font.BOLD, 14f));
		pressure.setFont(pressure.getFont().deriveFont(Font.BOLD, 14f));
		welcome.setFont(welcome.getFont().deriveFont(Font.BOLD, 12f));
		messages.setFont(messages.getFont().deriveFont(Font.BOLD, 12f));
		messages1.setFont(messages1.getFont().deriveFont(Font.BOLD, 12f));
		messages2.setFont(messages2.getFont().deriveFont(Font.BOLD, 12f));
		messages3.setFont(messages3.getFont().deriveFont(Font.BOLD, 12f));
		volume.setFont(volume.getFont().deriveFont(Font.BOLD, 14f));
		currentCond.setFont(currentCond.getFont().deriveFont(Font.BOLD, 14f));

		//adding borders
		tempUpdate.setBorder(border);
		flowUpdate.setBorder(border);
		pressureUpdate.setBorder(border);
		temp.setBorder(border);
		flow.setBorder(border);
		pressure.setBorder(border);
		currentCond.setBorder(border);
		welcome.setBorder(border);
		messages.setBorder(border);
		volume.setBorder(border);

		//Button method
		update.addActionListener(new UpdateListener(this, update, messages, messages1, messages2, messages3, temp, flow, pressure, tempUpdate, flowUpdate, pressureUpdate));

		//laying out the user interface
		
		currentField.setLayout(new GridLayout(4,2));
		currentField.add(tempLabelTwo);
		currentField.add(flowLabelTwo);
		currentField.add(temp);
		currentField.add(flow);
		currentField.add(pressureLabelTwo);
		currentField.add(tankVolume);
		currentField.add(pressure);	
		currentField.add(volume);

		infoField.setLayout(new GridLayout(1,7));
		infoField.add(tempLabel);
		infoField.add(tempUpdate);
		infoField.add(flowLabel);
		infoField.add(flowUpdate);
		infoField.add(pressureLabel);
		infoField.add(pressureUpdate);
		infoField.add(update);

		textField.setLayout(new GridLayout(2,1));
		textField.add(welcome);
		textField.add(currentCond);

		messageField.setLayout(new GridLayout(4,1));
		messageField.add(messages);
		messageField.add(messages1);
		messageField.add(messages2);
		messageField.add(messages3);

		uField.setLayout(new GridLayout(2,1));
		uField.add(updateInfo);
		uField.add(infoField);

		updateField.setLayout(new GridLayout(2,1));
		updateField.add(uField);
		updateField.add(messageField);

		setLayout(new BorderLayout());
		add(textField, BorderLayout.NORTH);
		add(currentField, BorderLayout.CENTER);
		add(updateField, BorderLayout.SOUTH);

		update.setMargin(new Insets(0, 0, 0, 0));

		setSize(500,500);

		pack();

		setTitle("Excelon");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new java.awt.event.WindowAdapter() {

			public void windowClosing(java.awt.event.WindowEvent e) {
				e.getWindow().dispose();

			}
		});

		temp.setText("300"+" C°");
		flow.setText("900"+ " gal/hr");
		pressure.setText("14"+ " megapascals");

		setLocationRelativeTo(null);
		setVisible(true);

		Color b = new Color(65,105,221);

		infoField.setBackground(b);
		currentField.setBackground(b);
		updateInfo.setBackground(b);

	}


	public static void main(String[] args) {

		try {
			// Set System L&F
			UIManager.setLookAndFeel(
					UIManager.getSystemLookAndFeelClassName());
		} 
		catch (UnsupportedLookAndFeelException e) {
			// handle exception
		}
		catch (ClassNotFoundException e) {
			// handle exception
		}
		catch (InstantiationException e) {
			// handle exception
		}
		catch (IllegalAccessException e) {
			// handle exception
		}

		new Reactor();

	}

}
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class UpdateListener implements ActionListener { //Class that decides text output

	private	JTextField temp;
	private JTextField flow;
	private	JTextField pressure;

	private	JTextField tempUpdate;
	private JTextField flowUpdate;
	private	JTextField pressureUpdate;
	private	JTextField messages;
	private	JTextField messages1;
	private	JTextField messages2;
	private	JTextField messages3;

	Reactor react;
	private	UpdateButton update;
	private	String tempParse;
	private	String flowParse;
	private String pressureParse;

	int t;
	int f;
	int p;

	static Color c;
	Color d;


	public UpdateListener(Reactor react, UpdateButton update, JTextField messages,  JTextField messages1, JTextField messages2, JTextField messages3, JTextField temp, JTextField flow, JTextField pressure, JTextField tempUpdate, JTextField flowUpdate, JTextField pressureUpdate){
		this.react = react;
		this.tempUpdate = tempUpdate;
		this.flowUpdate = flowUpdate;
		this.pressureUpdate = pressureUpdate;
		this.messages = messages;
		this.temp = temp;
		this.flow = flow;
		this.pressure = pressure;
		this.update = update;
		this.messages1 = messages1;
		this.messages2 = messages2;
		this.messages3 = messages3;
	}


	public void actionPerformed(ActionEvent arg0) {

		messages.setText("System status:");

		temp.setForeground(Color.BLACK);
		flow.setForeground(Color.BLACK);
		pressure.setForeground(Color.BLACK);

		tempParse = tempUpdate.getText();
		flowParse =	flowUpdate.getText();
		pressureParse = pressureUpdate.getText();


		try { //For no input changes
			t = Integer.parseInt(tempParse);
		} catch (java.lang.NumberFormatException e) {
			temp.setForeground(Color.BLACK);
			messages1.setText("No input detected. Condition remains unchanged.");
			tempUpdate.setText("");
			temp.setText("300 C°");
		}

		try {
			f = Integer.parseInt(flowParse);
		} catch (java.lang.NumberFormatException e) {
			flow.setForeground(Color.BLACK);
			messages2.setText("No input detected. Flow remains unchanged.");
			flowUpdate.setText("");
			flow.setText("900 gal/hr");
		}

		try {
			p = Integer.parseInt(pressureParse);
		} catch (java.lang.NumberFormatException e) {
			pressure.setForeground(Color.BLACK);
			messages3.setText("No input detected. Pressure remains unchanged.");
			pressureUpdate.setText("");
			pressure.setText("14 megapascals");
		}

		if(t <= 0) { //For invalid inputs
			messages1.setText("Temperature Error: Input was less than 1 or invalid.");
			tempUpdate.setText("");
			temp.setText(t+" C°");
			temp.setForeground(Color.RED);
		}

		if(t > 0 && t < 250) { //temperature inputs
			messages1.setText("Temperature Error: Temperature is too low.");
			tempUpdate.setText("");
			temp.setText(t+" C°");
			temp.setForeground(Color.RED);

		}

		else if(t >= 250 && t < 350 ) {
			messages1.setText("Temperature is in normal range.");
			tempUpdate.setText("");
			temp.setText(t+" C°");
			temp.setForeground(Color.BLACK);
		}

		else if(t >= 350 && t < 600 ) {
			messages1.setText("Temperature Error: Temperature is too high. Risk of meltdown.");
			tempUpdate.setText("");
			temp.setText(t+" C°");
			temp.setForeground(Color.RED);
		}

		if(t >= 600){
			messages1.setText("Temperature Error: Temperature is too high. Meltdown imminent.");
			tempUpdate.setText("");
			temp.setText(t+" C°");
			temp.setForeground(Color.RED);
		}

		if(f < 100) { //flow inputs
			flow.setForeground(Color.RED);
			messages2.setText("Flow Error: Flow of water is too low. Back up cooling system activated.");
			flowUpdate.setText("");
			flow.setText(f+" gal/hr");
		}

		if(f >= 100 && f < 800) {
			flow.setForeground(Color.RED);
			messages2.setText("Flow Error: Flow of water is too low.");
			flowUpdate.setText("");
			flow.setText(f+" gal/hr");
		}

		if(f >= 800 && f < 1000) {
			flow.setForeground(Color.BLACK);
			messages2.setText("Flow is in normal range.");
			flowUpdate.setText("");
			flow.setText(f+" gal/hr");
		}

		if(f >= 1000) {
			flow.setForeground(Color.RED);
			messages2.setText("Flow Error: Flow of water is too high.");
			flowUpdate.setText("");
			flow.setText(f+" gal/hr");
		}

		if(f <= 0) {
			messages2.setText("Flow Error: Input was less than 1 or invalid.");
			flowUpdate.setText("");
			flow.setText(f+" gal/hr");
			flow.setForeground(Color.RED);
		}

		if(p < 14 && p >= 1) { //pressure inputs
			pressure.setForeground(Color.RED);
			messages3.setText("Pressure Error: Pressure is too low.");
			pressureUpdate.setText("");
			pressure.setText(p+" megapascals");
		}

		if(p >= 14 && p <= 16) {
			pressure.setForeground(Color.BLACK);
			messages3.setText("Pressure is in normal range.");
			pressureUpdate.setText("");
			pressure.setText(p+" megapascals");
		}

		if(p > 16) {
			pressure.setForeground(Color.RED);
			messages3.setText("Pressure Error: Pressure is too high.");
			pressureUpdate.setText("");
			pressure.setText(p+" megapascals");
		}

		if(p <= 0) {
			pressure.setForeground(Color.RED);
			messages3.setText("Pressure Error: Input was less than 1 or invalid.");
			pressureUpdate.setText("");
			pressure.setText(p+" megapascals");
		}

	}



}

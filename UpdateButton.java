import javax.swing.JButton;

@SuppressWarnings("serial")
public class UpdateButton extends JButton{ //Creates the button

	Reactor react;

	public UpdateButton(Reactor react){

		this.react = react;

		setText("Update");
	}
}

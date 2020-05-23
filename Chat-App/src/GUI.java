import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI {
	
	private JFrame frame;
	private JPanel panel;
	private JLabel label;
	private JTextField message;
	private JList<String> messageList;
	private int msg_count = 0;
	public DefaultListModel<String> list = new DefaultListModel<String>();
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public GUI() {
		
		frame = new JFrame();
		label = new JLabel("Write your mesaages and hit enter to send!");
		message = new JTextField(16);
		message.addActionListener(action);
		messageList = new JList();
		
		panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,30));
		panel.setLayout(new GridLayout(0,1,10,10));
		panel.add(messageList);
		panel.add(label);
		panel.add(message);
		//panel.add(button);
		
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Chat App");
		frame.pack();
		frame.setVisible(true);
	}
	
	@SuppressWarnings("serial")
	Action action = new AbstractAction()
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			//messages[msg_count] = message.getText();
			list.addElement(message.getText());
			label.setText(message.getText());
			//messageList = new JList(list);
			//messageList.setSelectedIndex(msg_count);
            //messageList.ensureIndexIsVisible(msg_count);
			JOptionPane.showMessageDialog(null, message.getText());
			message.setText("");
			msg_count++;
			
		}
	};

}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatClient {

    JTextField sendField = new JTextField(45);
    JTextArea chatWindow = new JTextArea(15, 50);
    public JButton sendButton = new JButton("Send");

    public void start() {

        JFrame jFrame = new JFrame("ChatClient v0.1");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel chatPanel = new JPanel();
        chatWindow.setLineWrap(true);
        chatWindow.setWrapStyleWord(true);
        chatWindow.setEditable(false);

        JScrollPane jScrollPane = new JScrollPane(chatWindow);
        jScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        sendButton.addActionListener(new SendButtonListener());
        sendField.addActionListener(new SendButtonListener());

        chatPanel.add(chatWindow);
        chatPanel.add(jScrollPane);

        chatPanel.add(sendField);
        chatPanel.add(sendButton);

        jFrame.setSize(600, 330);

        jFrame.getContentPane().add(chatPanel, FlowLayout.LEFT);

        jFrame.setVisible(true);

    }

    public class SendButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent ex) {

            chatWindow.append(sendField.getText()+"\n");
            sendField.setText("");


        }
    }

}




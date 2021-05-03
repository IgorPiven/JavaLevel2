package Level2_L4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class Chat extends JFrame {

    JPanel panelNorth = new JPanel(new GridLayout());
    JPanel panelSouth = new JPanel(new GridLayout());

    JButton button = new JButton("Send");
    JTextArea textArea = new JTextArea();
    JScrollPane scroll = new JScrollPane(textArea);
    JTextField textField = new JTextField();


    Chat() throws IOException {
        super("My chat");
        setSize(400, 400);
        setMinimumSize(new Dimension(400, 400));

        textArea.setLineWrap(true);
        textArea.setEditable(false);


        button.addActionListener(e -> {
            sendMessage();
        });
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) sendMessage();
            }
        });

        panelNorth.add(scroll);
        panelSouth.add(textField);
        panelSouth.add(button);

        add(panelNorth);
        add("South", panelSouth);


        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void sendMessage() {
        String out = textField.getText();
        textArea.append(out + "\n");

        textField.setText("");
        textField.grabFocus();
    }


}

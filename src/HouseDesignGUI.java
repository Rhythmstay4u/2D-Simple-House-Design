import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HouseDesignGUI extends JFrame implements ActionListener {
    private JPanel mainPanel;
    private CardLayout cardLayout;

    public HouseDesignGUI() {
        setTitle("2D House Design");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);

        JPanel livingRoomPanel = createRoomPanelWithDescription("living_room.jpg", "This is the cozy living room.");
        JPanel bedroomPanel = createRoomPanelWithDescription("bedroom.jpg", "This is the comfortable bedroom.");
        JPanel kitchenPanel = createRoomPanelWithDescription("kitchen.jpg", "This is the modern kitchen.");

        mainPanel.add(livingRoomPanel, "Living Room");
        mainPanel.add(bedroomPanel, "Bedroom");
        mainPanel.add(kitchenPanel, "Kitchen");

        JPanel buttonPanel = new JPanel();
        JButton livingRoomButton = new JButton("Living Room");
        JButton bedroomButton = new JButton("Bedroom");
        JButton kitchenButton = new JButton("Kitchen");

        livingRoomButton.addActionListener(this);
        bedroomButton.addActionListener(this);
        kitchenButton.addActionListener(this);

        buttonPanel.add(livingRoomButton);
        buttonPanel.add(bedroomButton);
        buttonPanel.add(kitchenButton);

        getContentPane().add(mainPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }

    private JPanel createRoomPanelWithDescription(String imageName, String description) {
        JPanel roomPanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(imageName));
        JLabel label = new JLabel(imageIcon);
        JTextArea textArea = new JTextArea(description);
        textArea.setWrapStyleWord(true);
        textArea.setLineWrap(true);
        textArea.setOpaque(false);
        textArea.setEditable(false);
        roomPanel.add(label, BorderLayout.NORTH);
        roomPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        return roomPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String roomName = ((JButton) e.getSource()).getText();
        cardLayout.show(mainPanel, roomName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            HouseDesignGUI houseDesign = new HouseDesignGUI();
            houseDesign.setVisible(true);
        });
    }
}

// Main.java

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Main {
    private static class PetSelector extends JFrame {
        private JRadioButton birdButton, catButton, dogButton, rabbitButton, pigButton;
        private JLabel imageLabel;

        // Direct image URLs (replace these with your actual direct image URLs)
        private static final String DOG_URL = "https://cdn.britannica.com/79/232779-050-6B0411D7/German-Shepherd-dog-Alsatian.jpg";
        private static final String CAT_URL = "https://www.alleycat.org/wp-content/uploads/2019/03/FELV-cat.jpg";
        private static final String BIRD_URL = "https://images.unsplash.com/photo-1444464666168-49d633b86797";
        private static final String RABBIT_URL = "https://hips.hearstapps.com/hmg-prod/images/rabbit-breeds-american-white-1553635287.jpg?crop=0.976xw:0.651xh;0.0242xw,0.291xh&resize=980:*";
        private static final String PIG_URL = "https://media.istockphoto.com/id/1415613321/photo/cute-baby-pig-relaxing-and-enjoying-life-and-smiles-illuminated-by-the-sun.jpg?s=612x612&w=0&k=20&c=ouyg8jPrDhF_mC99NVzsAiy3pkTHq3CEkLFSi32IZ-k=";

        public PetSelector() {
            super("Pet Selector Demo");
            setLayout(new BorderLayout(20, 20));
            setSize(800, 600);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Create panel for radio buttons
            JPanel radioPanel = new JPanel();
            radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.Y_AXIS));
            radioPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // Create radio buttons
            birdButton = new JRadioButton("Bird");
            catButton = new JRadioButton("Cat");
            dogButton = new JRadioButton("Dog");
            rabbitButton = new JRadioButton("Rabbit");
            pigButton = new JRadioButton("Pig");

            // Group the radio buttons
            ButtonGroup group = new ButtonGroup();
            group.add(birdButton);
            group.add(catButton);
            group.add(dogButton);
            group.add(rabbitButton);
            group.add(pigButton);

            // Add radio buttons to panel
            radioPanel.add(birdButton);
            radioPanel.add(Box.createVerticalStrut(10));
            radioPanel.add(catButton);
            radioPanel.add(Box.createVerticalStrut(10));
            radioPanel.add(dogButton);
            radioPanel.add(Box.createVerticalStrut(10));
            radioPanel.add(rabbitButton);
            radioPanel.add(Box.createVerticalStrut(10));
            radioPanel.add(pigButton);

            // Create image label
            imageLabel = new JLabel();
            imageLabel.setPreferredSize(new Dimension(600, 400));
            imageLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
            imageLabel.setHorizontalAlignment(JLabel.CENTER);

            // Create a panel for the image with padding
            JPanel imagePanel = new JPanel(new BorderLayout());
            imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            imagePanel.add(imageLabel, BorderLayout.CENTER);

            // Add action listeners
            ActionListener radioListener = e -> {
                JRadioButton source = (JRadioButton) e.getSource();
                updateImage(source.getText());
                JOptionPane.showMessageDialog(this, 
                    "You selected: " + source.getText(),
                    "Pet Selection",
                    JOptionPane.INFORMATION_MESSAGE);
            };

            birdButton.addActionListener(radioListener);
            catButton.addActionListener(radioListener);
            dogButton.addActionListener(radioListener);
            rabbitButton.addActionListener(radioListener);
            pigButton.addActionListener(radioListener);

            // Add components to frame
            add(radioPanel, BorderLayout.WEST);
            add(imagePanel, BorderLayout.CENTER);

            // Set pig as default selection
            pigButton.setSelected(true);
            updateImage("Pig");

            // Center the frame on screen
            setLocationRelativeTo(null);
        }

        private void updateImage(String pet) {
            String imageUrl = "";
            switch(pet) {
                case "Bird":
                    imageUrl = BIRD_URL;
                    break;
                case "Cat":
                    imageUrl = CAT_URL;
                    break;
                case "Dog":
                    imageUrl = DOG_URL;
                    break;
                case "Rabbit":
                    imageUrl = RABBIT_URL;
                    break;
                case "Pig":
                    imageUrl = PIG_URL;
                    break;
            }

            try {
                URL url = new URL(imageUrl);
                Image image = ImageIO.read(url);
                if (image != null) {
                    // Scale the image to fit the label while maintaining aspect ratio
                    Image scaledImage = getScaledImage(image, 600, 400);
                    imageLabel.setIcon(new ImageIcon(scaledImage));
                }
            } catch (IOException e) {
                System.err.println("Error loading image: " + e.getMessage());
                imageLabel.setIcon(null);
                imageLabel.setText("Error loading image");
            }
        }

        private Image getScaledImage(Image srcImg, int targetWidth, int targetHeight) {
            double ratio = Math.min(
                (double) targetWidth / srcImg.getWidth(null),
                (double) targetHeight / srcImg.getHeight(null)
            );

            int width = (int) (srcImg.getWidth(null) * ratio);
            int height = (int) (srcImg.getHeight(null) * ratio);

            return srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PetSelector().setVisible(true);
        });
    }
}
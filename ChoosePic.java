import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ChoosePic extends JFrame implements MouseListener {

    public ArrayList<JLabel> allPicsLabels =new ArrayList<>() ;
    public static ImageIcon myImage =new ImageIcon();
        public ChoosePic(){
            this.setTitle("Image Gallery Example");
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setSize(820, 600);
            this.setResizable(false);
            this.setLayout(new BorderLayout());
    
            JPanel imagePanel = new JPanel();
            imagePanel.setLayout(new GridLayout(0, 3, 10, 10)); 
    
                File directory = new File("C:/Users/TAHA ALSOUS/Desktop/lastReppositry/testForMyProject/Images/mealsImagess");
                // C:\Users\TAHA ALSOUS\Desktop\lastReppositry\testForMyProject\Images
                File[] files = directory.listFiles((dir, name) -> name.toLowerCase().endsWith(".jpg")|| name.toLowerCase().endsWith(".png"));
    
                if (files != null) {
                    for (File file : files) {
                        ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
                        JLabel imageLabel = new JLabel();
                        allPicsLabels.add(imageLabel);
                        imageLabel.setIcon(imageIcon);
                        imageLabel.addMouseListener(this);
                        imagePanel.add(imageLabel);
                    }
                }
            
    
            JScrollPane scrollPane = new JScrollPane(imagePanel);
            this.add(scrollPane, BorderLayout.CENTER);
            this.setVisible(true);
    }
    
        @Override
        public void mouseClicked(MouseEvent e) {
            for (JLabel Label : allPicsLabels) {
                if (e.getSource()== Label){
                    myImage=(ImageIcon) Label.getIcon();
                    System.out.println(Label.getIcon().toString());
                    this.setVisible(false);

                }
                    
            }
        }
    
        @Override
        public void mousePressed(MouseEvent e) {
            
        }
    
        @Override
        public void mouseReleased(MouseEvent e) {
        }
    
        @Override
        public void mouseEntered(MouseEvent e) {
        }
    
        @Override
        public void mouseExited(MouseEvent e) {
        }
    
        public static ImageIcon getmyImage()
        {
            return myImage;
        }
}
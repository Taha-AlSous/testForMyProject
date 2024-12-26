import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class AddMeal extends JFrame implements ActionListener{
private JLabel mainBG;
        private ImageIcon posterImage;

        private JLabel logoLabel;
        private ImageIcon logoImage;

        private JLayeredPane layeredPane;

        private JLabel nameLabel;
        private JTextField nameTextField;
        private JLabel priceLabel;
        private JTextField priceTextField;
        private JLabel combonentLabel;
        private JTextField combonentTextField;

        private JButton chooseMealImage;
        private JButton confirmButton;
        private JButton gotoMenuButton;


        public AddMeal(){
        
            this.setSize(500,750);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
    
            layeredPane=new JLayeredPane();
    
            mainBG = new JLabel();
            posterImage= new ImageIcon(this.getClass().getResource("./Images/mainBG.png"));
    
            logoLabel = new JLabel();
            logoImage= new ImageIcon(this.getClass().getResource("./Images/firstLogo.png"));

            nameLabel = new JLabel("name:");
            nameTextField = new JTextField();
            priceLabel = new JLabel("price:");
            priceTextField = new JTextField();
            combonentLabel = new JLabel("combonent:");
            combonentTextField = new JTextField();
            

            chooseMealImage= new JButton("choose Meal Image");
            confirmButton= new JButton("confirm");
            gotoMenuButton= new JButton("go to Menu");


            ///////////
            /// 
            layeredPane.setPreferredSize(new Dimension(500,750));
            mainBG.setBounds(0, 0, 500, 750);
            mainBG.setIcon(posterImage);
            layeredPane.add(mainBG,JLayeredPane.DEFAULT_LAYER);

            //logo
            logoLabel.setBounds(0, -10, 200, 200);
            logoLabel.setIcon(logoImage);
            layeredPane.add(logoLabel,JLayeredPane.PALETTE_LAYER);

            // nameLabel
            nameLabel.setBounds(50, 150, 100, 100);
            nameLabel.setForeground(Color.white);
            nameLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
            layeredPane.add(nameLabel,JLayeredPane.PALETTE_LAYER);
            //nameTextField
            nameTextField.setBounds(170, 190, 200, 30);
            nameTextField.setForeground(Color.BLACK);
            nameTextField.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            layeredPane.add(nameTextField,JLayeredPane.PALETTE_LAYER);
            //priceLabel
            priceLabel.setBounds(50, 200, 100, 100);
            priceLabel.setForeground(Color.white);
            priceLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
            layeredPane.add(priceLabel,JLayeredPane.PALETTE_LAYER);
            //priceTextField
            priceTextField.setBounds(170, 240, 200, 30);
            priceTextField.setForeground(Color.BLACK);
            priceTextField.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            layeredPane.add(priceTextField,JLayeredPane.PALETTE_LAYER);
            //combonentLabel
            combonentLabel.setBounds(50, 250, 200, 100);
            combonentLabel.setForeground(Color.white);
            combonentLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
            layeredPane.add(combonentLabel,JLayeredPane.PALETTE_LAYER);
            //combonentTextField
            combonentTextField.setBounds(170, 290, 200, 30);
            combonentTextField.setForeground(Color.BLACK);
            combonentTextField.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            layeredPane.add(combonentTextField,JLayeredPane.PALETTE_LAYER);


            //chooseMealImage Button
            chooseMealImage.setBounds(150, 340, 200, 30);
            chooseMealImage.addActionListener(this);
            chooseMealImage.setForeground(Color.BLACK);
            chooseMealImage.setBackground(new Color(242,186,0));
            chooseMealImage.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            chooseMealImage.setFocusPainted(false);
            layeredPane.add(chooseMealImage,JLayeredPane.PALETTE_LAYER);
            
            //confirmButton
            confirmButton.setBounds(200, 390, 100, 30);
            confirmButton.addActionListener(this);
            confirmButton.setForeground(Color.BLACK);
            confirmButton.setBackground(new Color(242,186,0));
            confirmButton.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            confirmButton.setFocusPainted(false);
            layeredPane.add(confirmButton,JLayeredPane.PALETTE_LAYER);

            //gotoMenuButton
            gotoMenuButton.setBounds(150, 440, 200, 30);
            gotoMenuButton.addActionListener(this);
            gotoMenuButton.setForeground(new Color(242,186,0));
            gotoMenuButton.setBackground(new Color(31,25,27));
            gotoMenuButton.setBorderPainted(false);
            gotoMenuButton.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            gotoMenuButton.setFocusPainted(false);
            layeredPane.add(gotoMenuButton,JLayeredPane.PALETTE_LAYER);

            //add layerdPane to the frame
            this.add(layeredPane);
            this.setVisible(true);
            //
}


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==chooseMealImage)
            {
                new ChoosePic();
            }
            else if (e.getSource()==confirmButton)
            {
                Meal.Add(nameTextField.getText(), priceTextField.getText(), combonentTextField.getText(), ChoosePic.getmyImage());
                this.setVisible(false);
            }
            else if (e.getSource()==gotoMenuButton)
            {
                new Menu();
                this.setVisible(false);
            }
        }
        

}
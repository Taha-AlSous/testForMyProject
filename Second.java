import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

        
public class Second extends JFrame implements ActionListener ,MouseListener {

        private JLabel mainBG;
        private ImageIcon posterImage;

        private JLabel logoLabel;
        private ImageIcon logoImage;

        private JLayeredPane layeredPane;
        
        private JLabel usernameLabel;
        private JTextField usernameTextField;
        private JLabel passwordLabel;
        private JPasswordField passwordField;

        private JLabel eyeLabel;
        private ImageIcon eyeImage;
        private ImageIcon NoeyeImage;

        private JButton confirmButton;
        private JButton creatNewAccount;

        


    public Second(){
        
        this.setSize(500,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        layeredPane=new JLayeredPane();

        mainBG = new JLabel();
        posterImage= new ImageIcon(this.getClass().getResource("./Images/mainBG.png"));

        logoLabel = new JLabel();
        logoImage= new ImageIcon(this.getClass().getResource("./Images/firstLogo.png"));



        usernameLabel = new JLabel("username:");
        usernameTextField = new JTextField();
        passwordLabel = new JLabel("passowrd:");
        passwordField = new JPasswordField();

        eyeLabel = new JLabel();
        eyeImage = new ImageIcon(this.getClass().getResource("./Images/eye.png"));
        NoeyeImage = new ImageIcon(this.getClass().getResource("./Images/noeye.png"));

        confirmButton = new JButton("confirm");
        creatNewAccount = new JButton("creat New Account?");



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

        // usernameLabel
        usernameLabel.setBounds(50, 200, 100, 100);
        usernameLabel.setForeground(Color.white);
        usernameLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        layeredPane.add(usernameLabel,JLayeredPane.PALETTE_LAYER);
        //usernameTextField
        usernameTextField.setBounds(170, 240, 200, 30);
        usernameTextField.setForeground(Color.BLACK);
        usernameTextField.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        layeredPane.add(usernameTextField,JLayeredPane.PALETTE_LAYER);
        //passwordLabel
        passwordLabel.setBounds(50, 300, 100, 100);
        passwordLabel.setForeground(Color.white);
        passwordLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        layeredPane.add(passwordLabel,JLayeredPane.PALETTE_LAYER);
        //passwordField
        passwordField.setBounds(170, 340, 200, 30);
        passwordField.setEchoChar('*');
        passwordField.setForeground(Color.BLACK);
        passwordField.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        layeredPane.add(passwordField,JLayeredPane.PALETTE_LAYER);

        //eyeLabel
        eyeLabel.setBounds(400, 325, 60, 60);
        eyeLabel.addMouseListener(this);
        eyeLabel.setIcon(eyeImage);
        layeredPane.add(eyeLabel,JLayeredPane.PALETTE_LAYER);

        //confirmButton
        confirmButton.setBounds(200, 500, 100, 30);
        confirmButton.addActionListener(this);
        confirmButton.setForeground(Color.BLACK);
        confirmButton.setBackground(new Color(242,186,0));
        confirmButton.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        confirmButton.setFocusPainted(false);
        layeredPane.add(confirmButton,JLayeredPane.PALETTE_LAYER);
        //creatNewAccount
        creatNewAccount.setBounds(150, 550, 200, 30);
        creatNewAccount.addActionListener(this);
        creatNewAccount.setForeground(new Color(242,186,0));
        creatNewAccount.setBackground(new Color(31,25,27));
        creatNewAccount.setBorderPainted(false);
        creatNewAccount.setFont(new Font("Comic Sans MS",Font.BOLD,15));
        creatNewAccount.setFocusPainted(false);
        layeredPane.add(creatNewAccount,JLayeredPane.PALETTE_LAYER);



        //add layerdPane to the frame
        this.add(layeredPane);
        this.setVisible(true);
        //
        
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if(eyeLabel.getIcon()==eyeImage)
            {
                eyeLabel.setIcon(NoeyeImage);
                passwordField.setEchoChar((char)0);
            }
        else
             {
                eyeLabel.setIcon(eyeImage);
                passwordField.setEchoChar('*');
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


    //action listener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==creatNewAccount)
            {
                CreatAccount d =new CreatAccount();
            }
    }
}

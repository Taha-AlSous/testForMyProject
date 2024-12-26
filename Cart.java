import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Cart extends JFrame {
private JLayeredPane layeredPane;

    private JLabel titleLabel;

    private JLabel mainBG;
    private ImageIcon posterImage;

    private JLabel logoLabel;
    private ImageIcon logoImage;

    private JScrollPane scrollPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel scrollPanel;

    public Cart(){
        
        this.setSize(500,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);


        layeredPane=new JLayeredPane();
        mainBG = new JLabel();
        posterImage= new ImageIcon(this.getClass().getResource("./Images/mainBG menu.png"));

        logoLabel = new JLabel();
        logoImage= new ImageIcon(this.getClass().getResource("./Images/menuLogo.png"));

        scrollPanel= new JPanel();
        panel1= new JPanel();
        panel2= new JPanel();
        panel3= new JPanel();
        scrollPane = new JScrollPane(scrollPanel);



        ///////////
        /// 
        /// 
        layeredPane.setPreferredSize(new Dimension(500,750));
        mainBG.setBounds(0, 0, 500, 750);
        mainBG.setIcon(posterImage);
        layeredPane.add(mainBG,JLayeredPane.DEFAULT_LAYER);

        //title
        titleLabel = new JLabel("Cart");
        titleLabel.setBounds(125, 50, 250, 50);
        titleLabel.setForeground(new Color(242,186,0));
        titleLabel.setBackground(new Color(31,25,27));
        // titleLabel.setBorder(new LineBorder(new Color(242,186,0),3));
        titleLabel.setFont(new Font("Matura MT Script Capitals",Font.BOLD,40));
        titleLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        layeredPane.add(titleLabel,JLayeredPane.PALETTE_LAYER);

        //logo
        logoLabel.setBounds(0, 0, 100, 100);
        logoLabel.setIcon(logoImage);
        layeredPane.add(logoLabel,JLayeredPane.PALETTE_LAYER);

        //scroll panel
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.X_AXIS));
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        scrollPanel.add(panel1);
        scrollPanel.add(panel2);
        scrollPanel.add(panel3);
        scrollPanel.setBackground(new Color(31,25,27));

        //add labels to scroll panel
        JLabel label1 = new JLabel("meal name");
        label1.setLayout(new BoxLayout(label1, BoxLayout.Y_AXIS));
            label1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            label1.setForeground(new Color(242,186,0));
            panel1.add(label1);
            panel2.add(label1);
            panel3.add(label1);
            // label1.set(50,label1.getY(),50,50);

        // for (int i = 1; i <= 5; i++) {
        //     JLabel label = new JLabel("Label " + i+"    ");
        //     label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        //     label.setForeground(new Color(242,186,0));
        //     scrollPanel.add(label);
        //    // label.setAlignmentX(CENTER_ALIGNMENT);
        // }

        //scrollpane theem and added it to the layeredpane 
        scrollPane.getVerticalScrollBar().setBackground(new Color(31,25,27));
        scrollPane.setBorder(new LineBorder(new Color(242,186,0),4));
        scrollPane.setBounds(50, 110, 400 , 150); 
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);



        //stegeeee//////////////////

        

        this.add(layeredPane);
        this.setVisible(true);

}
}

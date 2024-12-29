import javax.swing.*;
import javax.swing.border.LineBorder;
import java.text.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Menu extends JFrame implements MouseListener,ActionListener,KeyListener{

    private JLayeredPane layeredPane;

    private JLabel titleLabel;

    private JLabel mainBG;
    private ImageIcon posterImage;

    private JLabel logoLabel;
    private ImageIcon logoImage;

    private JScrollPane scrollPane;
    private JPanel scrollPanel;

    private JLabel stageImageLabel;
    private ImageIcon stageImage;
    private JLabel stageNameLabel;
    private JLabel stagePriceLabel;
    private JLabel stageIngredientsLabel;

    private JTextField amountTextField;
    private JLabel amountLabel;

    private JButton addToCart;
    private JButton goToCart;
    
    private ArrayList<JLabel> allMealsLabels =new ArrayList<>() ;
    private JLabel mylabel=new JLabel();
    private Meal stageMeal=new Meal();


    public Menu(){
        
        this.setSize(500,750);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);


        layeredPane=new JLayeredPane();
        mainBG = new JLabel();
        posterImage= new ImageIcon(this.getClass().getResource("./Images/mainBG menu.png"));

        logoLabel = new JLabel();
        logoImage= new ImageIcon(this.getClass().getResource("./Images/menuLogo.png"));

        scrollPanel= new JPanel();
        scrollPane = new JScrollPane(scrollPanel);



        ///////////
        /// 
        /// 
        layeredPane.setPreferredSize(new Dimension(500,750));
        mainBG.setBounds(0, 0, 500, 750);
        mainBG.setIcon(posterImage);
        layeredPane.add(mainBG,JLayeredPane.DEFAULT_LAYER);

        //title
        titleLabel = new JLabel("Menu");
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


        // add meals from file
        try(
        FileInputStream file =new FileInputStream("MealsFile.ser");
        ObjectInputStream in =new ObjectInputStream(file)){
        Meal.meals= (ArrayList<Meal>) in.readObject();
        }
        catch(Exception e){
        
        }
        stageMeal=Meal.meals.get(0);

        //scroll panel
        scrollPanel.setLayout(new BoxLayout(scrollPanel, BoxLayout.X_AXIS));
        scrollPanel.setBackground(new Color(31,25,27));

        //add labels to scroll panel
        
        for (int i = 0; i < Meal.meals.size(); i++) {
            JLabel label = new JLabel(Meal.meals.get(i).name);
            label.addMouseListener(this);
            allMealsLabels.add(label);

            JLabel space = new JLabel("        ");

            label.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
            label.setForeground(new Color(242,186,0));

            scrollPanel.add(label);
            scrollPanel.add(space);
        }

        //scrollpane theem and added it to the layeredpane 
        scrollPane.getHorizontalScrollBar().setBackground(new Color(31,25,27));
        scrollPane.setBorder(new LineBorder(new Color(242,186,0),4));
        scrollPane.setBounds(50, 110, 400 , 75); 
        layeredPane.add(scrollPane, JLayeredPane.PALETTE_LAYER);


        ///////stage//////////
        /// Image
        stageImageLabel = new JLabel();
        // stageImage= new ImageIcon(this.getClass().getResource("./Images/mealsImagess/SeasonsPiza.jpg"));
        stageImageLabel.setBounds(125, 200, 250, 166);
        stageImageLabel.setIcon(Meal.meals.get(0).image);
        stageImageLabel.setBorder(new LineBorder(new Color(242,186,0),5));
        // stageImageLabel.setIcon(ChoosePic.getmyImage());
        layeredPane.add(stageImageLabel,JLayeredPane.PALETTE_LAYER);
        /// Name
        stageNameLabel = new JLabel();
        stageNameLabel.setBounds(125, 370, 250, 50);
        stageNameLabel.setText(Meal.meals.get(0).name);
        stageNameLabel.setForeground(new Color(242,186,0));
        stageNameLabel.setBackground(new Color(31,25,27));
        stageNameLabel.setBorder(new LineBorder(new Color(242,186,0),3));
        stageNameLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        stageNameLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        layeredPane.add(stageNameLabel,JLayeredPane.PALETTE_LAYER);
        /// Price
        stagePriceLabel = new JLabel();
        stagePriceLabel.setBounds(125, 425, 250, 50);
        stagePriceLabel.setText(Meal.meals.get(0).price + " $");
        stagePriceLabel.setForeground(new Color(242,186,0));
        stagePriceLabel.setBackground(new Color(31,25,27));
        stagePriceLabel.setBorder(new LineBorder(new Color(242,186,0),3));
        stagePriceLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        stagePriceLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        layeredPane.add(stagePriceLabel,JLayeredPane.PALETTE_LAYER);
        /// Ingredients
        stageIngredientsLabel = new JLabel();
        stageIngredientsLabel.setText("Ingredients");
        stageIngredientsLabel.setBounds(125, 480, 250, 50);
        stageIngredientsLabel.setForeground(new Color(242,186,0));
        stageIngredientsLabel.setBackground(new Color(31,25,27));
        stageIngredientsLabel.setBorder(new LineBorder(new Color(242,186,0),3));
        stageIngredientsLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        stageIngredientsLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        stageIngredientsLabel.addMouseListener(this);
        layeredPane.add(stageIngredientsLabel,JLayeredPane.PALETTE_LAYER);
        // Number Field
        amountLabel= new JLabel();
        amountLabel.setBounds(125, 535, 120, 50);
        amountLabel.setForeground(new Color(242,186,0));
        amountLabel.setBackground(new Color(31,25,27));
        amountLabel.setBorder(new LineBorder(new Color(242,186,0),3));
        amountLabel.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        amountLabel.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        amountLabel.setText("Amount: ");
        layeredPane.add(amountLabel,JLayeredPane.PALETTE_LAYER);

        amountTextField= new JFormattedTextField();
        amountTextField.setBounds(250, 535, 125, 50);
        amountTextField.setForeground(new Color(242,186,0));
        amountTextField.setBackground(new Color(31,25,27));
        amountTextField.setBorder(new LineBorder(new Color(242,186,0),3));
        amountTextField.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        amountTextField.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        amountTextField.setCaretColor(Color.white);
        amountTextField.addKeyListener(this);
        layeredPane.add(amountTextField,JLayeredPane.PALETTE_LAYER);
        // add to cart
        addToCart = new JButton();
        addToCart.setText("Add To Cart");
        addToCart.setBounds(125, 590, 250, 50);
        addToCart.setBackground(new Color(242,186,0));
        addToCart.setForeground(new Color(31,25,27));
        addToCart.setBorder(new LineBorder(new Color(242,186,0),3));
        addToCart.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        addToCart.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        addToCart.setFocusable(false);

        layeredPane.add(addToCart,JLayeredPane.PALETTE_LAYER);
        // go to cart
        goToCart = new JButton();
        goToCart.setText("Go To Cart");
        goToCart.setBounds(125, 645, 250, 50);
        goToCart.setBackground(new Color(150,50,10));
        goToCart.setForeground(new Color(242,186,0));
        goToCart.setBorder(new LineBorder(new Color(150,50,10),3));
        goToCart.setFont(new Font("Comic Sans MS",Font.BOLD,20));
        goToCart.setHorizontalAlignment((int) CENTER_ALIGNMENT);
        goToCart.setFocusable(false);
        layeredPane.add(goToCart,JLayeredPane.PALETTE_LAYER);




        this.add(layeredPane);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        //
    }


    @Override
    // this method to find a meal which has the same name of "mylabel"
    public void mouseClicked(MouseEvent e) {
        if (e.getSource()==stageIngredientsLabel)
        {
            JOptionPane.showMessageDialog(null, stageMeal.combonent,"combonent",JOptionPane.INFORMATION_MESSAGE);

        }
        for (JLabel Label : allMealsLabels) {
                if (e.getSource()== Label){
                    mylabel=Label;
                    break;
                }
            }
            for (Meal meal : Meal.meals) {
                if (mylabel.getText()==meal.name){
                    stageMeal=meal;

                    stageImageLabel.setIcon(stageMeal.image);
                    stageNameLabel.setText(stageMeal.name);
                    stagePriceLabel.setText(stageMeal.price + " $");


                    break;
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



    //key listener
    @Override
    public void keyTyped(KeyEvent e) {
        char c=e.getKeyChar();
        if (!Character.isDigit(c)&& c!='\b'&& c!=KeyEvent.VK_DELETE){
            e.consume();
            JOptionPane.showMessageDialog(null, "you must enter only number..","error",JOptionPane.OK_OPTION);

        }
           
    }


    @Override
    public void keyPressed(KeyEvent e) {
       
    }


    @Override
    public void keyReleased(KeyEvent e) {
       
    }


    // action listener
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}
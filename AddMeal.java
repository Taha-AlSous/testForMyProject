import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.*;

public class AddMeal extends JFrame implements ActionListener{
        private JLabel mainBG;
        private ImageIcon posterImage;

        private JLabel logoLabel;
        private ImageIcon logoImage;

        private JButton addMeal;
        private JButton deleteMeal;
        private JButton editMeal;

        private JLayeredPane layeredPane;

        private JLabel nameLabel;
        private JTextField nameTextField;
        private JButton sercheButton;

        private JLabel priceLabel;
        private JTextField priceTextField;
        private JLabel combonentLabel;
        private JTextField combonentTextField;

        private JButton chooseMealImage;
        private JButton confirmButton;
        private JButton gotoMenuButton;
        private int whatIsTheCase=1;
        private Meal myMeal;


        public AddMeal(){
        
            this.setSize(500,750);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            this.setResizable(false);

            addMeal= new JButton("Add Meal");
            deleteMeal= new JButton("Delete Meal");
            editMeal= new JButton("Edit Meal");

            layeredPane=new JLayeredPane();
    
            mainBG = new JLabel();
            posterImage= new ImageIcon(this.getClass().getResource("./Images/mainBG.png"));
    
            logoLabel = new JLabel();
            logoImage= new ImageIcon(this.getClass().getResource("./Images/firstLogo.png"));

            nameLabel = new JLabel("name:");
            nameTextField = new JTextField();
            sercheButton= new JButton("serche");

            priceLabel = new JLabel("price:");
            priceTextField = new JTextField();
            combonentLabel = new JLabel("combonent:");
            combonentTextField = new JTextField();
            

            chooseMealImage= new JButton("choose Meal Image");
            confirmButton= new JButton("confirm");
            gotoMenuButton= new JButton("cnofirm and go to Menu");

             myMeal=new Meal();



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

            //addMeal
            addMeal.setBounds(273, 50, 130, 30);
            addMeal.addActionListener(this);
            addMeal.setForeground(new Color(242,186,0));
            addMeal.setBackground(new Color(150,50,10));
            addMeal.setBorderPainted(false);
            addMeal.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            addMeal.setFocusPainted(false);
            layeredPane.add(addMeal,JLayeredPane.PALETTE_LAYER);

            //deleteMeal
            deleteMeal.setBounds(200, 100, 125, 30);
            deleteMeal.addActionListener(this);
            deleteMeal.setForeground(new Color(242,186,0));
            deleteMeal.setBackground(new Color(150,50,10));
            deleteMeal.setBorderPainted(false);
            deleteMeal.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            deleteMeal.setFocusPainted(false);
            layeredPane.add(deleteMeal,JLayeredPane.PALETTE_LAYER);

            //editMeal
            editMeal.setBounds(350, 100, 125, 30);
            editMeal.addActionListener(this);
            editMeal.setForeground(new Color(242,186,0));
            editMeal.setBackground(new Color(150,50,10));
            editMeal.setBorderPainted(false);
            editMeal.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            editMeal.setFocusPainted(false);
            layeredPane.add(editMeal,JLayeredPane.PALETTE_LAYER);

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

            //sercheButton
            sercheButton.setBounds(380, 190, 100, 30);
            sercheButton.addActionListener(this);
            sercheButton.setForeground(new Color(31,25,27));
            sercheButton.setBackground(new Color(242,186,0));
            sercheButton.setBorderPainted(false);
            sercheButton.setFont(new Font("Comic Sans MS",Font.BOLD,15));
            sercheButton.setFocusPainted(false);
            sercheButton.setVisible(false);
            layeredPane.add(sercheButton,JLayeredPane.PALETTE_LAYER);


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
            this.setLocationRelativeTo(null);
            this.setVisible(true);
            //
}


        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource()==addMeal) {
                whatIsTheCase=1;
                sercheButton.setVisible(false);
                priceLabel.setVisible(true);
                priceTextField.setVisible(true);
                combonentLabel.setVisible(true);
                combonentTextField.setVisible(true);
                chooseMealImage.setVisible(true);
            }
            if (e.getSource()==deleteMeal) {
                whatIsTheCase=2;
                sercheButton.setVisible(false);
                priceLabel.setVisible(false);
                priceTextField.setVisible(false);
                combonentLabel.setVisible(false);
                combonentTextField.setVisible(false);
                chooseMealImage.setVisible(false);
                
            }
            if (e.getSource()==editMeal) {
                whatIsTheCase=3;
                sercheButton.setVisible(true);
                priceLabel.setVisible(false);
                priceTextField.setVisible(false);
                combonentLabel.setVisible(false);
                combonentTextField.setVisible(false);
                chooseMealImage.setVisible(false);
            }
            if (e.getSource()==sercheButton) {
                whatIsTheCase=3;
                myMeal=this.editSerch(nameTextField.getText());
                System.out.println(myMeal.name+"    "+myMeal.price);

                
            }
            

            //chooseMealImage button
            if (e.getSource()==chooseMealImage)
            {
                new ChoosePic();
            }


//////////////////////////////////////////

            //confirm button
            if (e.getSource()==confirmButton)
            {
                if (whatIsTheCase==1)
                {
                    Meal.Add(nameTextField.getText(), priceTextField.getText(), combonentTextField.getText(), ChoosePic.getmyImage());
                    this.setVisible(false);
                }
                else if (whatIsTheCase==2)
                {
                    this.delete(nameTextField.getText());
                    System.out.println("22");
                    this.setVisible(false);
                
                }
                else if (whatIsTheCase==3)
                {
                    mealeditenformation(myMeal, new Meal(nameTextField.getText(), priceTextField.getText(),combonentTextField.getText(), ChoosePic.getmyImage()));
                    this.setVisible(false);
                
                }
                
                
            }





            // if (e.getSource()==gotoMenuButton)
            // {
            //     Meal.Add(nameTextField.getText(), priceTextField.getText(), combonentTextField.getText(), ChoosePic.getmyImage());
            //     new Menu();
            //     this.setVisible(false);
            // }
        }
//////////////////////////////////////////

    public void delete(String nameee){
         // add meals from file
        try(
        FileInputStream file =new FileInputStream("MealsFile.ser");
        ObjectInputStream in =new ObjectInputStream(file)){
        Meal.meals= (ArrayList<Meal>) in.readObject();
        }
        catch(Exception e){
        
        }

        for(Meal meal:Meal.meals) {
            if (meal.name.equals(nameee)){
                System.out.println("found");
                Meal.meals.remove(meal);
                System.out.println("removed");
                try(
                    FileOutputStream file =new FileOutputStream("MealsFile.ser");
                    ObjectOutputStream out =new ObjectOutputStream(file)){
                    out.writeObject(Meal.meals);
                    }
                    
                catch(Exception e){
                }
            }           
        }
    }


//////////////////////////////////////////
    public Meal editSerch(String nameee){
        //load meals from file
        try(
        FileInputStream file =new FileInputStream("MealsFile.ser");
        ObjectInputStream in =new ObjectInputStream(file)){
        Meal.meals= (ArrayList<Meal>) in.readObject();
        }
        catch(Exception e){
        
        }

        for(Meal meal:Meal.meals) {
            if (meal.name.equals(nameee)){
                priceLabel.setVisible(true);
                priceTextField.setVisible(true);
                combonentLabel.setVisible(true);
                combonentTextField.setVisible(true);
                chooseMealImage.setVisible(true);
                sercheButton.setVisible(false);

                ChoosePic.myImage=meal.image;
                priceTextField.setText(meal.price);
                combonentTextField.setText(meal.combonent);

                try(
                    FileOutputStream file =new FileOutputStream("MealsFile.ser");
                    ObjectOutputStream out =new ObjectOutputStream(file)){
                    out.writeObject(Meal.meals);
                    }
                    
                catch(Exception e){
                }
                return meal;
            }
        }
        JOptionPane.showMessageDialog(null, "there are no meal with this name", "not existe", JOptionPane.ERROR_MESSAGE);
        return null;

    }


//////////////////////////////////////////

    public void mealeditenformation(Meal befor,Meal after){
        //load meals from file
        try(
        FileInputStream file =new FileInputStream("MealsFile.ser");
        ObjectInputStream in =new ObjectInputStream(file)){
        Meal.meals= (ArrayList<Meal>) in.readObject();
        }
        catch(Exception e){
        
        }
        System.out.println(befor.combonent);
        System.out.println(befor.name);
        System.out.println(" ");
        for(int i=0;i<Meal.meals.size();i++) {
            if (Meal.meals.get(i).name.equals(befor.name)){
                Meal.meals.get(i).name=after.name;
                Meal.meals.get(i).price=after.price;
                Meal.meals.get(i).combonent=after.combonent;
                Meal.meals.get(i).image=after.image;
                try(
                    FileOutputStream file =new FileOutputStream("MealsFile.ser");
                    ObjectOutputStream out =new ObjectOutputStream(file)){
                    out.writeObject(Meal.meals);
                    }
                    
                catch(Exception e){
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "there are no meal with this name", "not existe", JOptionPane.ERROR_MESSAGE);
       

    }
        

}
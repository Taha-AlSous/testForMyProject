import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Meal implements Serializable {
public String name;
public String price;
public String combonent;
public ImageIcon image;

public static ArrayList <Meal> meals=new ArrayList<>();
        

public Meal(){

}
public Meal(String name,String price,String combonent,ImageIcon image){
    this.name= name;
    this.price= price;
    this.combonent=combonent;
    this.image=image;
    try(
        FileInputStream file =new FileInputStream("MealsFile.ser");
        ObjectInputStream in =new ObjectInputStream(file)){
        meals= (ArrayList<Meal>) in.readObject();
        }
    catch(Exception e){
    
    }
}

public static void Add(String name,String price,String combonent,ImageIcon image){
    Meal m=new Meal(name, price,combonent,image);
    meals.add(m);
    try(
        FileOutputStream file =new FileOutputStream("MealsFile.ser");
        ObjectOutputStream out =new ObjectOutputStream(file)){
        out.writeObject(meals);
        }
        
    catch(Exception e){
    
    }
    // try(
    //     FileInputStream file =new FileInputStream("MealsFile.ser");
    //     ObjectInputStream in =new ObjectInputStream(file)){
    //         for (Meal meal : meals) {
    //             meal=(Meal) in.readObject(); 
    //          }

    //     }
    // catch(Exception e){
    
    // }

}




                
}

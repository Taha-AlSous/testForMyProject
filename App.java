
public class App {
    
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
         Second s=new Second();
       // CreatAccount d =new CreatAccount();
        // ChoosePic c= new ChoosePic();
       
         new AddMeal();
        //  new AddMeal();
        //  new AddMeal();
        // try {
        // Thread.sleep(30000);
        // } catch (Exception e) {
        
        // }
        
        Menu m=new Menu();
        //LogIn.doLogin();
       // Cart c=new Cart();
        
    
    }
}






















// import javax.swing.*;
// import javax.swing.table.DefaultTableModel;
// import java.awt.*;
// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.io.*;
// import java.util.ArrayList;
// import java.util.List;
// class Customer implements Serializable {
//     private String name;
//     private String phone;
//     private String date;

//     public Customer(String name, String phone, String date) {
//         this.name = name;
//         this.phone = phone;
//         this.date = date;
//     }

//     public String getName() {
//         return name;
//     }

//     public String getPhone() {
//         return phone;
//     }

//     public String getDate() {
//         return date;
//     }
// }
// public class CustomerDataApp {
//     private JFrame frame;
//     private JTextField nameField;
//     private JTextField phoneField;
//     private JTextField dateField;
//     private JTable table;
//     private DefaultTableModel model;
//     private List<Customer> customers;

//     public CustomerDataApp() {
//         customers = loadFromFile();
//         initialize();
//     }
//     private void initialize() {
//         frame = new JFrame( "lsdkfj");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(600, 400);
//         frame.setLayout(new BorderLayout());

//         JPanel inputPanel = new JPanel();
//         inputPanel.setLayout(new GridLayout(4, 2));

//         inputPanel.add(new JLabel("name :"));
//         nameField = new JTextField();
//         inputPanel.add(nameField);

//         inputPanel.add(new JLabel(" num:"));
//         phoneField = new JTextField();
//         inputPanel.add(phoneField);

//         inputPanel.add(new JLabel("date:"));
//         dateField = new JTextField();
//         inputPanel.add(dateField);

//         JButton addButton = new JButton("add");
//         addButton.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 addCustomer();
//             }
//         });
//         inputPanel.add(addButton);

//         frame.add(inputPanel, BorderLayout.NORTH);

//         model = new DefaultTableModel(new String[]{" name", " num", "date"}, 0);
//         table = new JTable(model);
//         frame.add(new JScrollPane(table), BorderLayout.CENTER);

//         loadTableData();
        
//         frame.setVisible(true);
//     }
//     private void addCustomer() {
//         String name = nameField.getText();
//         String phone = phoneField.getText();
//         String date = dateField.getText();

//         if (!name.isEmpty() && !phone.isEmpty() && !date.isEmpty()) {
//             Customer customer = new Customer(name, phone, date);
//             customers.add(customer);
//             model.addRow(new Object[]{name, phone, date});
//             saveToFile();
//             nameField.setText("");
//             phoneField.setText("");
//             dateField.setText("");
//         } else {
//             JOptionPane.showMessageDialog(frame, "enter all fields");
//         }
//     }
//     private void saveToFile() {
//         try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.dat"))) {
//             oos.writeObject(customers);
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
//     @SuppressWarnings("unchecked")
//     private List<Customer> loadFromFile() {
//         List<Customer> customerList = new ArrayList<>();
//         File file = new File("customers.dat");
//         if (file.exists()) {

//             try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
//                 customerList = (List<Customer>) ois.readObject();
//             } catch (IOException | ClassNotFoundException e) {
//                 e.printStackTrace();
//             }
//         }
//         return customerList;
//     }
//     private void loadTableData() {
//         for (Customer customer : customers) {
//             model.addRow(new Object[]{customer.getName(), customer.getPhone(), customer.getDate()});
//         }
//     }
//     public static void main(String[] args) {
//         new CustomerDataApp();
//     }
// }

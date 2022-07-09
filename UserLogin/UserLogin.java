package login;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.*;

import java.awt.event.*;
import java.util.ArrayList;
//import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Scanner;
import javax.swing.*;
public class UserLogin {
JLabel jl1 = new JLabel("Enter customer id");
JTextField cid = new JTextField(10);
JLabel jl2 = new JLabel("Enter mobile number");
JTextField phone = new JTextField(12);
JButton check = new JButton("Check phone");
JLabel jl3 = new JLabel("Enter item id");
JTextField itemid = new JTextField(10);
JLabel jl4 = new JLabel("Enter quantity bought");
JTextField quan = new JTextField(4);
HashMap<Long,Integer> hm = new HashMap<Long,Integer>();
static ArrayList<ItemDetails> ar_items = new ArrayList<ItemDetails>();
JLabel jl5 = new JLabel("Item name");
JTextField itemname= new JTextField(30);
JLabel jl6 = new JLabel("Item cost");
JTextField itemc= new JTextField(4);
JButton display_item = new JButton("Item Details");
void add_collection()
{
hm.put(9887667887L,123);
hm.put(7665436788L,232);
hm.put(647485869L,456);
}
int check_collection(Long val)
{
//Add items into collection
add_collection();
if(hm.containsKey(val)) {
return hm.get(val);
}
else
return -1;
}
UserLogin(){
JFrame f1 = new JFrame("Customer information");
JFrame f2 = new JFrame("Customer Information");
String uname = JOptionPane.showInputDialog("Enter username");
String passwd = JOptionPane.showInputDialog("Enter Password");
if(uname.equals("uname@gmail.com")&&passwd.equals("pass"))
{
f1.add(jl2);f1.add(phone); f1.add(check);
f1.setSize(200,200);
f1.setVisible(true);
check.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent evt) {
f1.setVisible(false);
f2.add(jl1);f2.add(cid);
f2.add(jl3);f2.add(itemid);
f2.add(jl4);f2.add(quan);
//check collection
int v=check_collection(Long.parseLong(phone.getText()));
cid.setText(Integer.toString(v));
if(v==-1)
{
String cid1 = JOptionPane.showInputDialog(null,"Enter customer id");
cid.setText(cid1);
}
f2.setVisible(true);
}
});
}
else
{
JOptionPane.showMessageDialog(null,"Invalid details Please run the code once again ");
}
display_item.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent evt) {
int v1 = Integer.parseInt(itemid.getText());
check_item(v1);
}
});
}
void check_item(int id)
{
for(ItemDetails item:ar_items)
{
if(item.item_id==id)
{
itemname.setText(item.item_name);
itemc.setText(Float.toString(item.cost));
}
}
}
public static void main(String args[])
{
//create a collection of items
Scanner sc = new Scanner(System.in);
while(true)
{
System.out.println("Do u want to enter item details. Enter yes/no");
String v1 = sc.nextLine();
if(v1.equals("yes"))
{
System.out.println("Enter item id");
int id = Integer.parseInt(sc.nextLine());
System.out.println("Enter item name");
String item_name = sc.nextLine();
System.out.println("Enter item cost");
float cost =Float.parseFloat(sc.nextLine());
ItemDetails it = new ItemDetails(id,item_name,cost);
ar_items.add(it);
}
else
{
break;
}
}
UserLogin ul = new UserLogin();
}
}







package login;

public class ItemDetails {
int item_id;
String item_name;
float cost;
ItemDetails(int it,String iname,float c)
{
item_id =it;
item_name = iname;
cost = c;
}
public String toString()
{
return item_id+ " "+item_name+ " "+cost+" ";
}
}
package VendingMachine;

import Command.*;
import Product.Burgers.Burger1;
import Product.Burgers.Burger2;
import Product.Burgers.Burger3;
import Product.Chocolate.Bounty;
import Product.Chocolate.Twix;
import Product.Chocolate.Nuts;
import Product.Drink.CocaCola;
import Product.Drink.Fanta;
import Product.Drink.Sprite;
import Product.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class VendingMachine implements Serializable{
    public VendingMachine(){
        try {
            InputStream inputStream = new FileInputStream("database.txt");
            fill();
            if(inputStream.available()==0) {
                setVendingMachineToDatabase(this);
            }
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashMap<String, ArrayList<ArrayList<Product>>> vendingMachine = new HashMap<>();


    public ArrayList<Product> getProducts(Command command){
        VendingMachine currentVendingMachine = getVendingMachineFromDatabase();

        ArrayList<Product> productsToReturn = new ArrayList<Product>();
        ArrayList<ArrayList<Product>> currentProductRow = currentVendingMachine.vendingMachine.get(command.rowNumber);
        ArrayList<Product> currentProductColumn = currentProductRow.get(command.columnNumber-1);
        if(currentProductColumn.size()<command.quantity || currentProductColumn.size()==0){
            if(currentProductColumn.size()==0){
                Product currentProduct = vendingMachine.get(command.rowNumber).get(command.columnNumber-1).get(0);
                fillColumn(currentProductColumn,currentProduct);
            }
            else {
                fillColumn(currentProductColumn, currentProductColumn.get(0));
            }
        }
        for(int i = 0;i<command.quantity;i++){
            productsToReturn.add(currentProductColumn.get(currentProductColumn.size()-1));
            currentProductColumn.remove(currentProductColumn.size()-1);
        }
        System.out.println("You have bought "+productsToReturn.size()+" times ");
        for(int i = 0;i<productsToReturn.size();i++){
            System.out.print(productsToReturn.get(0).getClass().getTypeName());
        }
        setVendingMachineToDatabase(currentVendingMachine);
        return productsToReturn;
    }
    public void setVendingMachineToDatabase(VendingMachine vendingMachine){
        try {
            File file = new File("database.txt");
            OutputStream outputStream = new FileOutputStream("database.txt");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(vendingMachine);
            objectOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    public VendingMachine getVendingMachineFromDatabase(){
        VendingMachine currentVendingMachine = null;
        try {
            InputStream inputStream = new FileInputStream("database.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            currentVendingMachine = (VendingMachine) objectInputStream.readObject();
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return currentVendingMachine;
    }


    private  void fill(){
        ArrayList<ArrayList<Product>> drinksRow = new ArrayList<>();
        ArrayList<Product> cocaColaColumn = new ArrayList<Product>();
        fillColumn(cocaColaColumn,new CocaCola());
        ArrayList<Product> fantaColumn = new ArrayList<Product>();
        fillColumn(fantaColumn,new Fanta());
        ArrayList<Product> spriteColumn = new ArrayList<Product>();
        fillColumn(spriteColumn,new Sprite());

        drinksRow.add(cocaColaColumn);
        drinksRow.add(fantaColumn);
        drinksRow.add(spriteColumn);
        vendingMachine.put("A",drinksRow);

        ArrayList<ArrayList<Product>> burgersRow = new ArrayList<>();
        ArrayList<Product> burgerColumn = new ArrayList<Product>();
        fillColumn(burgerColumn,new Burger1());
        ArrayList<Product> burgerColumn2 = new ArrayList<Product>();
        fillColumn(burgerColumn2,new Burger2());
        ArrayList<Product> burgerColumn3 = new ArrayList<Product>();
        fillColumn(burgerColumn3,new Burger3());

        burgersRow.add(burgerColumn);
        burgersRow.add(burgerColumn2);
        burgersRow.add(burgerColumn3);
        vendingMachine.put("B",burgersRow);

        ArrayList<Product> chocolateColumn = new ArrayList<Product>();
        fillColumn(chocolateColumn,new Twix());
        ArrayList<Product> chocolateColumn2 = new ArrayList<Product>();
        fillColumn(chocolateColumn2,new Bounty());
        ArrayList<Product> chocolateColumn3 = new ArrayList<Product>();
        fillColumn(chocolateColumn3,new Nuts());

        ArrayList<ArrayList<Product>> chocoltaeRow = new ArrayList<>();
        chocoltaeRow.add(chocolateColumn);
        chocoltaeRow.add(chocolateColumn2);
        chocoltaeRow.add(chocolateColumn3);
        vendingMachine.put("C",chocoltaeRow);
    }

    private void fillColumn(ArrayList<Product> list,Product product){
        for(int i = list.size();i<20;i++){
            list.add(product);
        }
    }

}

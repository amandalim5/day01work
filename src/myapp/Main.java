package myapp;

import java.io.Console;
import java.util.LinkedList;
import java.util.List;


public class Main{
  public static void main(String[] args) {

    String input = "";

    Console cons = System.console();

    List<String> myShoppingList = new LinkedList<>();

    System.out.println("Welcome to your shopping cart");
    while(true){
      input = cons.readLine();
      // add
      if(input.trim().toLowerCase().startsWith("add")){
        String[] addInputArray = input.trim().split(" ");
        if(addInputArray.length > 1){
          boolean matching = false;
          for(int i=0; i<myShoppingList.size(); i++){
            if(myShoppingList.get(i).toLowerCase().equals(addInputArray[1].toLowerCase())){
              matching = true;
            }
          }
          if(!matching){
            myShoppingList.add(addInputArray[1]);
            System.out.printf("%s added to cart\n", addInputArray[1]);
          } else{
            System.out.printf("%s already added to cart\n", addInputArray[1]);
            System.out.println("It was not added to the cart");
            
          }
          
        }

        // delete
      } else if (input.trim().toLowerCase().startsWith("delete")) {
        String[] deleteInputArray = input.trim().split(" ");
        // checking if there is number given
        if(deleteInputArray.length > 1){
          Integer num = Integer.parseInt(deleteInputArray[1]) - 1;
          // checking if number is valid
          if(myShoppingList.size() >= num + 1){
            System.out.printf("%s removed from cart\n", myShoppingList.get(num));
            myShoppingList.remove((int)num);
          } else{
            System.out.println("Incorrect item index");
          }
        } else{
          System.out.println("No number given");
        }

        // list
      } else if(input.trim().toLowerCase().equals("list")){
        if(myShoppingList.size()==0){
          System.out.println("Your cart is empty");
        } else{
          for(int i=0; i<myShoppingList.size(); i++){
            System.out.printf("%d. %s\n", i+1, myShoppingList.get(i));
          }
        }

        // exit
      } else if(input.trim().toLowerCase().equals("exit")){
        break;
      }

    }

  }
}
//////////////// FILE HEADER (INCLUDE IN EVERY FILE) //////////////////////////
//
// Title: P01 Shopping Cart
// Course: CS 300 Spring 2022
//
// Author: Harshet Anand
// Email: hanand2@wisc.edu
// Lecturer: Mouna Kacem
//
///////////////////////// ALWAYS CREDIT OUTSIDE HELP //////////////////////////
//
// Persons: NONE
// Online Sources: NONE
//
///////////////////////////////////////////////////////////////////////////////


/**
 * This class allows us to implement Java arrays to implement a Shopping Cart as a way of storing
 * several elements and collection of data. This program will allow an item from the list of
 * elements from the marketItems array to be added to cart along with several other methods such as:
 * looking up an item by its name, looking up an item by its ID, getting the price of each element,
 * retrieving a copy of the cart, adding an item to the cart, the number of times each item appears
 * in the cart, the items contained in the cart, removing an item from the cart, checking out the
 * final price of the cart, and getting the cart summary.
 * 
 * @author Harshet Anand
 */


public class ShoppingCart {

  private static final double TAX_RATE = 0.05; // sales tax
  // MarketItems: a perfect-size two-dimensional array that stores the list of
  // available items in a given market
  // MarketItems[i][0] refers to a String representation of the item identifiers
  // MarketItems[i][1] refers the item name. Item names are also unique
  // MarketItems[i][2] a String representation of the unit price of the item in dollars

  private static String[][] marketItems =
      new String[][] {{"4390", "Apple", "$1.59"}, {"4046", "Avocado", "$0.59"},
          {"4011", "Banana", "$0.49"}, {"4500", "Beef", "$3.79"}, {"4033", "Blueberry", "$6.89"},
          {"4129", "Broccoli", "$1.79"}, {"4131", "Butter", "$4.59"}, {"4017", "Carrot", "$1.19"},
          {"3240", "Cereal", "$3.69"}, {"3560", "Cheese", "$3.49"}, {"3294", "Chicken", "$5.09"},
          {"4071", "Chocolate", "$3.19"}, {"4363", "Cookie", "$9.5"}, {"4232", "Cucumber", "$0.79"},
          {"3033", "Eggs", "$3.09"}, {"4770", "Grape", "$2.29"}, {"3553", "Ice Cream", "$5.39"},
          {"3117", "Milk", "$2.09"}, {"3437", "Mushroom", "$1.79"}, {"4663", "Onion", "$0.79"},
          {"4030", "Pepper", "$1.99"}, {"3890", "Pizza", "$11.5"}, {"4139", "Potato", "$0.69"},
          {"3044", "Spinach", "$3.09"}, {"4688", "Tomato", "$1.79"}, null, null, null, null};


  /**
   * This method returns a string representation of the item whose name is provided as input and a
   * match was found in marketItems.
   * 
   * @param name The name of the product or item to search on the market.
   * @return A string value containing product ID, name, and price. If the name of the item is not
   *         on the market, this will return "No match found".
   */
  public static String lookupProductByName(String name) {
    for (int j = 0; j < marketItems.length; j++) {
      if (marketItems[j] == null) {
        continue;
      }
      if (marketItems[j] != null && marketItems[j][1].equals(name)) {
        return marketItems[j][0] + " " + marketItems[j][1] + " " + marketItems[j][2];
      }
    }
    return (String) "No match found";
  }


  /**
   * This method returns a string representation of the item whose ID is provided as input and a
   * match was found in marketItems.
   * 
   * @param id The identifier of the item to search in the marketItems array.
   * @return A string representation of the item whose id is found as the input if a match was
   *         found. If the ID of the item is not found in the market, this will return "No match
   *         found".
   */
  public static String lookupProductById(int id) {
    for (int j = 0; j < marketItems.length; j++) {
      if (marketItems[j] == null) {
        continue;
      }
      if (Integer.parseInt(marketItems[j][0]) == (id)) {
        return marketItems[j][0] + " " + marketItems[j][1] + " " + marketItems[j][2];
      }
    }
    return (String) "No match found";
  }


  /**
   * This method returns the value of the price of the product that is provided as the input whilst
   * returning a value of -1.0 if the product is not found in the marketItems array.
   * 
   * @param name The name of the element is provided as an input in order to find the value of the
   *             price.
   * @return The price in dollars parsed as a double value of the market item provided its name. If
   *         the item is not found in the marketItems array, this will return a value of -1.0.
   */
  public static double getProductPrice(String name) {
    for (int j = 0; j < marketItems.length; j++) {
      if (marketItems[j] == null) {
        continue;
      }
      if (marketItems[j] != null && marketItems[j][1].equals(name)) {
        String getProductPrice = marketItems[j][2].substring(1);
        return (Double.parseDouble(getProductPrice));
      }
    }
    return (double) -1.0;
  }


  /**
   * This method returns a deep copy of the marketItems which copies a list of the references onto
   * another array however the array data of marketItems does not change.
   * 
   * @return The deep copy of the marketItems which is assigned as marketItems2 and returns another
   *         array with the same elements.
   */
  public static String[][] getCopyOfMarketItems() {
    String[][] marketItems2 = new String[marketItems.length][];
    for (int j = 0; j < marketItems.length; j++) {
      marketItems2[j] = marketItems[j];
    }
    return (String[][]) marketItems2;
  }


  /**
   * This method appends an item to a given shopping cart where if the cart is full, no more items
   * can be added to the cart length as it is greater than the size.
   * 
   * @param item The name of the product that is to be added to the shopping cart.
   * @param cart An array of string which contains the names of the items in the shopping cart.
   * @param size The number of items in the shopping cart.
   * @return The size of the over-sized array shopping cart whilst trying to add an item to the cart
   *         and whereby it is impossible to add another item to the cart if the cart is full.
   */
  public static int addItemToCart(String item, String[] cart, int size) {
    if (cart.length - 1 >= size) {
      cart[size] = item;
      size += 1;
    }
    return (int) size;
  }


  /**
   * This method find the number of times each item occurs within a cart. However, this method does
   * not making any changes to the elements of the cart itself.
   * 
   * @param item The name of the item that is being checked to see how many times it occurs within
   *             the shopping cart.
   * @param cart An array of strings which contains the names of the items that are added to the
   *             shopping cart.
   * @param size The number of items that are added to the shopping cart which helps compare the
   *             occurrences to the number of items in the cart to make sure it doesn't exceed the
   *             size.
   * @return The number of occurrences of each item within the over-sized array cart. This number
   *         can range from 0 to the size of the cart.
   */
  public static int nbOccurrences(String item, String[] cart, int size) {
    int numberOfOccurrences = 0;
    for (int j = 0; j < size; j++) {
      if (cart[j].equals(item)) {
        numberOfOccurrences += 1;
      }
    }
    return (int) numberOfOccurrences;
  }


  /**
   * This method checks if the shopping cart contains at least one occurrence of a given item from
   * the marketItems list. However, this does not make any changes to the elements of the shopping
   * cart.
   * 
   * @param item The name of the item that is being checked to see how many times it is contained
   *             within the shopping cart.
   * @param cart An array of strings which contains the names of the items that are added to the
   *             shopping cart.
   * @param size The number of items that are added to the shopping cart which helps compare the
   *             occurrences to the number of items in the cart to make sure it doesn't exceed the
   *             size.
   * @return True if there is an exact match of the item that is contained within the shopping cart
   *         and false otherwise.
   */
  public static boolean contains(String item, String[] cart, int size) {
    boolean containsOccurrences = false;
    for (int j = 0; j < size; j++) {
      if (cart[j].equals(item)) {
        containsOccurrences = true;
        return (boolean) containsOccurrences;
      }
    }
    return (boolean) containsOccurrences;
  }


  /**
   * This method calculates the total price of all the items added in the shopping cart in dollars
   * as well as taxing all the products by 5% in the market.
   * 
   * @param cart An array of strings which contains the names of the items that are added to the
   *             shopping cart so it can be checked out.
   * @param size The number of items that are added to the shopping cart which helps compare the
   *             occurrences to the number of items in the cart to make sure it doesn't exceed the
   *             size.
   * @return The total value in dollars of the shopping cart including the 5% tax on the items
   *         included in the shopping cart.
   */
  public static double checkout(String[] cart, int size) {
    double finalValue = 0.0;
    for (int j = 0; j < size; j++) {
      finalValue += getProductPrice(cart[j]);
    }
    finalValue *= 1.05;
    return (double) finalValue;
  }


  /**
   * This method remove at least one occurrence of an item from a given shopping cart. If no match
   * is found with a specific item in the cart, the method returns the same value of the input size.
   * However, this will not make any changes to the elements of the shopping cart itself.
   * 
   * @param cart An array of strings which contains the names of the items that are added to the
   *             shopping cart so it can be removed.
   * @param item The name of the item that is being checked to see how many times it occurs within
   *             the shopping cart so it can be removed.
   * @param size The number of items that are added to the shopping cart which helps compare the
   *             occurrences to the number of items in the cart to make sure it doesn't exceed the
   *             size.
   * @return The size of the over-sized array shopping cart after trying to remove the item from the
   *         shopping cart.
   */
  public static int removeItem(String[] cart, String item, int size) {
    if (size > 0) {
      for (int j = 0, k = 0; j < size; j++) {
        if (cart[j].equals(item)) {
          cart[j] = cart[k + 1];
          size -= 1;
          return size;
        }
      }
    }
    return (int) size;
  }


  /**
   * This method removes every single item from a given shopping cart. The array of the shopping
   * cart must be empty and must contain only null references after the method is return to make
   * sure the shopping cart is empty.
   * 
   * @param cart An array of strings which contains the names of the items that are added to the
   *             shopping cart so it can be emptied out.
   * @param size The number of items that are added to the shopping cart which helps compare the
   *             occurrences to the number of items in the cart to make sure it doesn't exceed the
   *             size.
   * @return The size of the shopping cart after all elements from the cart have been removed.
   *         Should only return cart with null references.
   */
  public static int emptyCart(String[] cart, int size) {
    int itemsInCart = size;
    for (int j = 0; j < size; j++) {
      cart[j] = null;
      itemsInCart -= 1;
    }
    return (int) itemsInCart;
  }


  /**
   * This method gets the summary of the contents of a given shopping cart where the format of the
   * string contains a set of lines where each line contains the number of occurrences of each given
   * item followed by the name of the given item in the cart. The list of items in the shopping cart
   * should be grouped together. (E.g Pizza, Pizza, Tomato should output: (2) Pizza, (1) Tomato).
   * 
   * @param cart An array of strings which contains the names of the items that are added to the
   *             shopping cart so it can be summarised and the items can be totalled up.
   * @param size The number of items that are added to the shopping cart which helps compare the
   *             occurrences to the number of items in the cart to make sure it doesn't exceed the
   *             size.
   * @return A string representation of the summary of the contents of the shopping cart which each
   *         item printing out on a new line and the number of times each item occurs in the
   *         shopping cart.
   */
  public static String getCartSummary(String[] cart, int size) {
    String cartSummary = "";
    for (int j = 0; j < size; j++) {
      int k;
      for (k = 0; k < j; k++)
        if (cart[j] == cart[k])
          break;
      if (j == k) {
        cartSummary += "(" + nbOccurrences(cart[j], cart, size) + ") " + cart[j] + "\n";
      }
    }
    return (String) cartSummary;
  }
}

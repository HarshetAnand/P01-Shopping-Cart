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
 * This class tests for all the methods used in ShoppingCart.java to check that all methods run
 * successfully and complete each task required.
 * 
 * @author Harshet Anand
 */


import java.util.Arrays;

public class ShoppingCartTester {


  /**
   * The main method checks whether ShoppingCart.lookupProductByName(),
   * ShoppingCart.lookupProductById(), ShoppingCart.getProductPrice(), ShoppingCart.addItemToCart(),
   * ShoppingCart.contains(), ShoppingCart.nbOccurrences(), ShoppingCart.removeItem(),
   * ShoppingCart.checkout(), ShoppingCart.getCartSummary, and ShoppingCart.emptyCart() methods work
   * as expected by running the runAllTests() method and printing out the result of that method. If
   * all tests run successfully, this will return true else it will return false with the failed
   * method.
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println("runAllTests(): " + runAllTests());
  }


  /**
   * Checks the correctness of getProductPrice() and lookupProductById() methods work successfully
   * by running four different scenarios with different inputs and comparing them to their
   * respective ID's.
   * 
   * @return true if all four scenarios pass else false if one of the scenarios fails printing out
   *         the method which did not pass and the item that was used as input.
   */
  public static boolean testLookupMethods() {
    // 1. The item to find is at index 0 of the marketItems array
    String expectedOutput = "4390 Apple $1.59";
    // Compares Apple to its respective ID
    if (!ShoppingCart.lookupProductByName("Apple").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Apple as input");
      return false;
    }

    if (!ShoppingCart.lookupProductById(4390).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id " + "of Apple as input");
      return false;
    }

    // 2. The item to find is at the last non-null position of the marketItems array
    expectedOutput = "4688 Tomato $1.79";
    // Compares Tomato to its respective ID
    if (!ShoppingCart.lookupProductByName("Tomato").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Tomato as input");
      return false;
    }

    if (!ShoppingCart.lookupProductById(4688).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id " + "of Tomato as input");
      return false;
    }

    // 3. The item to find is at an arbitrary position of the middle of the marketItems array
    expectedOutput = "3890 Pizza $11.5";
    // Compares Pizza to its respective ID
    if (!ShoppingCart.lookupProductByName("Pizza").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed Pizza as input");
      return false;
    }

    if (!ShoppingCart.lookupProductById(3890).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the id " + "of Pizza as input");
      return false;
    }

    // 4. The item to find is not found in the market
    expectedOutput = "No match found";
    // No match found compares to random ID
    if (!ShoppingCart.lookupProductByName("NOT FOUND").equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductByName() method "
          + "failed to return the expected output when passed the name of "
          + "a product not found in the market.");
      return false;
    }

    if (!ShoppingCart.lookupProductById(1000).equals(expectedOutput)) {
      System.out.println("Problem detected: Your lookupProductById() method "
          + "failed to return the expected output when passed the identifier"
          + "of a product not found in the market.");
      return false;
    }
    return true;
  }



  /**
   * Checks the correctness of getProductPrice() method by running three different scenarios and
   * comparing it with the expected price.
   * 
   * @return True when all three scenarios pass else return false if one of the scenarios fails
   *         printing out the error messages for the input that did not pass.
   */
  public static boolean testGetProductPrice() {
    // (1) This scenario gets the price of the product Apple in the market.
    double expectedPrice = 1.59;
    // Compares Apple to its respective expected price
    if (Math.abs(ShoppingCart.getProductPrice("Apple") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when Apple passed the identifier");
      return false;
    }

    // (2) This scenario gets the price of the product Spinach in the market.
    expectedPrice = 3.09;
    // Compares Spinach to its respective expected price
    if (Math.abs(ShoppingCart.getProductPrice("Spinach") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when Spinach passed the identifier");
      return false;
    }

    // (3) This scenario gets the price of a product not on the market.
    expectedPrice = -1.0;
    // Prints out false price for item not found
    if (Math.abs(ShoppingCart.getProductPrice("Eggplant") - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your getProductPrice() method "
          + "failed to return the expected output when passed the identifier"
          + "of a product not found in the market.");
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of addItemToCart(), contains(), and nbOccurrences() methods work
   * successfully by running three different scenarios for addItemToCart(), two different scenarios
   * for contains(), and one scenario for nbOccurrences() with different inputs and comparing them
   * to their respective shopping cart arrays.
   * 
   * @return true if all six scenarios pass else false if one of the scenarios fails printing out
   *         the method which did not pass and the item that was used as input.
   */
  public static boolean testAddItemToCartContainsNbOccurrences() {
    // Tests the correctness of addItemToCart

    // (1) This scenario should add an item to an empty cart.
    // This should return the cart with the newly added item.
    String cartItems[] = new String[] {null, null, null, null, null, null, null, null, null};
    int size = 1;
    String addItem = "Ice Cream";
    // Ice cream added to empty cart using addItemToCart() method

    if (!(ShoppingCart.addItemToCart(addItem, cartItems, 0) == (size))) {
      System.out.println("Problem detected: Your addItemToCart() method "
          + "failed to return the expected output when Ice Cream passed the identifier");
      return false;
    }

    // (2) This scenario should add an item to a full cart.
    // This should return the full cart with the newly added item.
    String cartItems2[] =
        new String[] {"Avocado", "Butter", "Pizza", "Pizza", "Spinach", "Milk", "Blueberry"};
    size = 7;
    addItem = "Mushroom";
    // Mushroom added to full cart using addItemToCart() method

    if (!(ShoppingCart.addItemToCart(addItem, cartItems2, 7) == (size))) {
      System.out.println("Problem detected: Your addItemToCart() method "
          + "failed to return the expected output when Mushroom passed the identifier");
      return false;
    }

    // (3) This scenario should add an item to a non-empty cart.
    // This should return the non-empty cart with the newly added item at the end of the array cart
    // and the size of the array should be updated.
    String cartItems3[] = new String[] {"Avocado", "Butter", "Pizza", "Pizza", "Spinach", "Milk",
        "Blueberry", "Banana", null, null, null, null};
    size = 9;
    addItem = "Cookie";
    // Cookie added to non-empty cart using addItemToCart() method

    if (!(ShoppingCart.addItemToCart(addItem, cartItems3, 8) == (size))) {
      System.out.println("Problem detected: Your addItemToCart() method "
          + "failed to return the expected output when Cookie passed the identifier");
      return false;
    }

    // Tests the correctness of contains

    // (1) This scenario should check that an element is contained in the array-list.
    boolean expectedOutput = true;
    String containsItem = "Butter";
    // Checks to see if butter is contained using contains() method in cartItems2 (full cart from
    // addItemToCart() tester above)

    if (!(ShoppingCart.contains(containsItem, cartItems2, size) == (expectedOutput))) {
      System.out.println("Problem detected: Your contains() method "
          + "failed to return the expected output when Butter passed the identifier");
      return false;
    }

    // (2) This scenario should check that an element is not contained in the array-list.
    boolean expectedOutput2 = false;
    // Cookie not contained in cartItems2 (full cart from addItemToCart() tester above)

    if (!(ShoppingCart.contains("Cookie", cartItems2, 7) == (expectedOutput2))) {
      System.out.println("Problem detected: Your contains() method "
          + "failed to return the expected output when Cookie passed the identifier");
      return false;
    }

    // Tests the correctness of nbOccurrences

    // (1) This scenario should check the number of occurrences that a specific item appears in the
    // shopping cart.
    cartItems = new String[] {"Avocado", "Butter", "Pizza", "Pizza", "Spinach"};
    int expectedNbOccurrences = 2;
    String itemOccurred = "Pizza";
    // Pizza occurs twice checked using nbOccurrences() method

    if (!(ShoppingCart.nbOccurrences(itemOccurred, cartItems, 5) == expectedNbOccurrences)) {
      System.out.println("Problem detected: Your nbOccurrences() method "
          + "failed to return the expected output when Pizza passed the identifier");
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of removeItem() method works successfully by running five different
   * scenarios for removeItem() with different inputs and relying on the nbOccurrences() method to
   * check if the number of times the item occurs has decreased or stayed the same depending on the
   * scenario.
   * 
   * @return true if all five scenarios pass else false if one of the scenarios fails printing out
   *         the method which did not pass and the item that was used as input.
   */
  public static boolean testRemoveItem() {
    // (1) This scenario should remove an item stored at index 0 of a non-empty cart.]
    String cartItems[] =
        new String[] {"Avocado", "Blueberry", "Butter", "Pizza", "Spinach", null, null, null};
    int size = 5;
    String cartItemRemoved = "Avocado";
    int expectedCartSize = 4;
    // Avocado should be removed from the array and cart size should decrease by one

    if (!(ShoppingCart.removeItem(cartItems, cartItemRemoved, size) == expectedCartSize)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Avocado passed the identifier");
      return false;
    }

    size = 4;
    int expectedOccurrences = 0;
    // Avocado should not occur at all in the cart. Compared using nbOccurrences() method

    if (!(ShoppingCart.nbOccurrences(cartItemRemoved, cartItems, size) == expectedOccurrences)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Avocado occurrences passed the identifier");
      return false;
    }

    // (2) This scenario should remove an item whose first occurrence is stored at the last index
    // position of a non-empty cart.
    cartItems =
        new String[] {"Avocado", "Blueberry", "Butter", "Pizza", "Spinach", null, null, null};
    size = 5;
    cartItemRemoved = "Spinach";
    expectedCartSize = 4;
    // Last index item is Spinach which should be removed from the array and size should decrease by
    // one

    if (!(ShoppingCart.removeItem(cartItems, cartItemRemoved, size) == expectedCartSize)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Spinach passed the identifier");
      return false;
    }

    size = 4;
    expectedOccurrences = 0;
    // Spinach should not occur at all in the cart. Compared using nbOccurrences() method

    if (!(ShoppingCart.nbOccurrences(cartItemRemoved, cartItems, size) == expectedOccurrences)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Spinach occurrences passed the identifier");
      return false;
    }

    // (3) This scenario should remove an item whose first occurrence is stored at an arbitrary
    // position within a non-empty array cart.
    cartItems = new String[] {"Avocado", "Butter", "Cookie", "Pizza", "Pizza", "Pizza", "Spinach",
        "Potato", null, null, null};
    size = 8;
    cartItemRemoved = "Pizza";
    expectedCartSize = 7;
    // Pizza located in the middle of the cart should be remove and size should decrease by one

    if (!(ShoppingCart.removeItem(cartItems, cartItemRemoved, size) == expectedCartSize)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Pizza passed the identifier");
      return false;
    }

    size = 7;
    expectedOccurrences = 2;
    // Pizza should occur two times instead of three in the cart. Compared using nbOccurrences()
    // method

    if (!(ShoppingCart.nbOccurrences(cartItemRemoved, cartItems, size) == expectedOccurrences)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Pizza occurrences passed the identifier");
      return false;
    }

    // (4) This scenario should try to remove an item from an empty cart where size is 0.
    cartItems = new String[] {null, null, null, null, null};
    size = 0;
    cartItemRemoved = "Spinach";
    expectedCartSize = 0;
    // Spinach can not be removed from empty cart. Therefore size should stay zero

    if (!(ShoppingCart.removeItem(cartItems, cartItemRemoved, size) == expectedCartSize)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Spinach passed the identifier");
      return false;
    }

    size = 0;
    expectedOccurrences = 0;
    // Spinach should not occur at all in the cart. Compared using nbOccurrences() method

    if (!(ShoppingCart.nbOccurrences(cartItemRemoved, cartItems, size) == expectedOccurrences)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Spinach occurrences passed the identifier");
      return false;
    }

    // (5) This scenario should try to remove a non-existing item from the cart.
    cartItems = new String[] {"Avocado", "Butter", "Onion", "Pizza", "Spinach", null, null, null};
    size = 5;
    cartItemRemoved = "Tomato";
    expectedCartSize = 5;
    // Tomato can not be removed from cart as it is not added. Therefore size remains five

    if (!(ShoppingCart.removeItem(cartItems, cartItemRemoved, size) == expectedCartSize)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Tomato passed the identifier");
      return false;
    }

    size = 5;
    expectedOccurrences = 0;
    // Tomato should not occur at all in the cart. Compared using nbOccurrences() method

    if (!(ShoppingCart.nbOccurrences(cartItemRemoved, cartItems, size) == expectedOccurrences)) {
      System.out.println("Problem detected: Your removeItem() method "
          + "failed to return the expected output when Tomato occurrences passed the identifier");
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of checkout() and getCartSummary() methods work successfully by running
   * one scenario for checkout() and three scenarios for getCartSummary() with different inputs and
   * comparing them to their respective cart arrays.
   * 
   * @return true if all four scenarios pass else false if one of the scenarios fails printing out
   *         the method which did not pass and the item that was used as input.
   */
  public static boolean testCheckoutGetCartSummary() {
    // Tests the correctness of checkout

    // (1) This scenario calls ShoppingCart.checkout on a full cart.
    // This should return the final checkout price.
    String cartItems[] = new String[] {"Milk", "Apple", "Banana", "Pizza"};
    int cartSize = 4;
    double expectedPrice = 16.4535;
    // Makes sure that the price of the items adds up to expected price including 5% tax
    if (Math.abs((ShoppingCart.checkout(cartItems, cartSize)) - expectedPrice) > 0.001) {
      System.out.println("Problem detected: Your checkout() method "
          + "failed to return the expected output when passed the identifier");
      return false;
    }

    // Tests the correctness of getCartSummary

    // (1) This scenario calls ShoppingCart.getCartSummary() on an empty cart.
    // This should return an empty string.
    String cartSummary[] = new String[7];
    cartSize = 0;
    String emptyCart = "";
    // String of empty cart should print out with seven null items
    if (!(ShoppingCart.getCartSummary(cartSummary, cartSize).equals(emptyCart))) {
      System.out.println("Problem detected: Your getCartSummary() method "
          + "failed to return the expected output when an empty cart passed the identifier");
      return false;
    }

    // (2) This scenario calls ShoppingCart.getCartSummary() on a cart which contains unique items.
    // This should return a string which consists of the unique items in any order.
    String cartSummary2[] = new String[] {"Milk", "Apple", "Banana", "Pizza", null, null};
    cartSize = 4;
    String uniqueCart = "(1) Milk\n" + "(1) Apple\n" + "(1) Banana\n" + "(1) Pizza\n";
    // String of cart with no duplicates elements prints out only one of each item
    if (!(ShoppingCart.getCartSummary(cartSummary2, cartSize).equals(uniqueCart))) {
      System.out.println("Problem detected: Your getCartSummary() method "
          + "failed to return the expected output when unique items passed the identifier");
      return false;
    }

    // (3) This scenario calls ShoppingCart.getCartSummary() on a cart which contains non-unique
    // items at different positions of the over-sized array.
    // This should return a string which consists of the duplicate items in any order.
    String cartSummary3[] = new String[] {"Tomato", "Milk", "Milk", "Eggs", "Tomato", "Onion",
        "Eggs", "Milk", "Banana"};
    cartSize = 9;
    String duplicateItems =
        "(2) Tomato\n" + "(3) Milk\n" + "(2) Eggs\n" + "(1) Onion\n" + "(1) Banana\n";
    // String of cart with duplicate elements prints out multiple of certain items
    if (!(ShoppingCart.getCartSummary(cartSummary3, cartSize).equals(duplicateItems))) {
      System.out.println("Problem detected: Your getCartSummary() method "
          + "failed to return the expected output when non-unique items passed the identifier");
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of emptyCart() method works successfully by running one scenario for
   * emptyCart() with different inputs.
   * 
   * @return true if one scenario passes else false if one of the scenarios fails printing out the
   *         method which did not pass and the item that was used as input.
   */
  public static boolean testEmptyCart() {
    String cartItems[] = new String[] {"Tomato", "Milk", "Milk", "Eggs", "Tomato", "Onion", "Eggs",
        "Milk", "Banana"};
    int cartSize = 9;
    int expectedCartSize = 0;
    // All elements from full cart should be removed thus returning array will no elements

    if (!(ShoppingCart.emptyCart(cartItems, cartSize) == (expectedCartSize))) {
      System.out.println("Problem detected: Your emptyCart() method "
          + "failed to return the expected output when passed the identifier");
      return false;
    }
    return true;
  }


  /**
   * Checks the correctness of all test methods works successfully by running all tests
   * 
   * @return true if all test methods pass else false if one or more tests fail printing out the
   *         test and the method which did not pass as well as the item that was used as input.
   */
  public static boolean runAllTests() {
    boolean allTestsPassed =
        testLookupMethods() && testGetProductPrice() && testAddItemToCartContainsNbOccurrences()
            && testRemoveItem() && testCheckoutGetCartSummary() && testEmptyCart();
    // Can only return true if all test cases return true. Will go back to main method to return
    // final result
    return allTestsPassed;
  }
}



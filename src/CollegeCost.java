import java.util.Scanner;

public class CollegeCost {
static Scanner in = new Scanner(System.in);
public static void main(String[] args){
        String name = getName();
        printTotal(name);// print total through main method
}
public static String getName(){
    System.out.println("What is the student's name?");
    String name = in.nextLine(); // get input from use and assign as name
    return name;

}
public static void printTotal(String name) {
    double total = 0;
    if (onCampus(name)) {
        total = calculateTotal(estimatedLivingExpenses(),
                booksAndSupplies(), creditHours(), costPerCredit());
    } else {
        total = calculateTotal(booksAndSupplies(), creditHours(),
                costPerCredit());
    }
    String year = getYear();
    if (year.equalsIgnoreCase("other"))
        System.out.printf("the total cost of " + name + "is $%7.2f", total);
    else
        System.out.printf("the total cost of " + name + " as a " + year + "is $%7.2f", total);
    System.out.println();

}
    private static boolean onCampus(String name) {
    boolean invalidResponse = true;
    do {
        System.out.println("Is" + name + " living on compus?(yes/no)");
        String response = in.nextLine();
        if (response.equalsIgnoreCase("yes"))
            return true;
        else if (response.equalsIgnoreCase("no"))
            return false;
        else
            System.out.println("Invalid response.");


    }while (invalidResponse);
    return false;
}
    public static double estimatedLivingExpenses() {
    double total = 0;
    try{
     System.out.println("How many weeks are you gona be in school?");
     String value = in.nextLine();// take answer
     int weeks = Integer.parseInt(value);
     
     System.out.println(" weekly living cost/expenses?");
     value =in.nextLine();
     double weeklyExpenses = Double.parseDouble(value);
     System.out.println("whats is the room board for the year?");
     value = in.nextLine();
     double roomboard = Double.parseDouble(value);
     
     
     total = weeks*weeklyExpenses + roomboard;
     
     
    }catch (Exception e){
        System.out.println("invalid data types");
        e.printStackTrace();
    }
    return total;
    }
        public static double booksAndSupplies() {
        System.out.println("what is the estimate cost of "+
                "textbooks and supplies");
        double cost = in.nextDouble();
        return cost;
    }
    public static int creditHours() {
        System.out.println("How many hours is the student planning"+
                "to take?");
        int hours = in.nextInt();
        return hours;
    }
    public static double costPerCredit() {
    System.out.print("What is the cost credit per hours?");
    Double costCredit = in.nextDouble();
    in.nextLine();//??
    return costCredit;
    }

    public static String getYear() {
    System.out.println("What year is the student(fresh, Soph, ");
String sYear = in.nextLine();
return sYear;
}



    public static double calculateTotal(double livingExpenses, double books,
                                        int credit, double cost) {
return livingExpenses + books +(credit * cost);
}
    public static double calculateTotal( double books,
                                        int credit, double cost) {
        return   books +(credit * cost);
    }

}


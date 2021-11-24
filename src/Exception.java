import java.io.*;


public class Exception {

    public static void recursiveMethod() {
        recursiveMethod();
    }

    public static void main(String args[]) throws FileNotFoundException {
        int a[] = new int[0];
        try {
            System.out.println(a[1]);
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Exception was processed. Program continues" + "\n");
        }


        try  {
            FileReader reader = new FileReader("notes5.txt");
            }
        catch(FileNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Exception was processed. Program continues" + "\n");
        }

        Object n = null;
        try {
            (n).toString();
        }
        catch(NullPointerException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Exception was processed. Program continues" + "\n");
        }

        try  {
            FileWriter wr = new FileWriter("notes3.txt", false);
            FileReader reader = new FileReader("notes3.txt");
            reader.close();
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            System.out.println("Exception was processed. Program continues" + "\n");
        }

        class Person{ int Age = 0; }
        class Employee extends Person{int salary = 0;}
        class Teacher extends Employee{ int class_ = 1; }
        try {
            Employee e = new Employee();
            Teacher t = (Teacher)e;
        }
        catch(ClassCastException exception) {
            System.out.println(exception.getMessage());
            System.out.println("Exception was processed. Program continues" + "\n");
        }

        try {
            int d = 2021 / 0;
        }
        catch (ArithmeticException e) {
            System.out.println(e);
            System.out.println("Exception was processed. Program continues" + "\n");
        }


        StringBuilder st = new StringBuilder();

        try {
            while(true){
                st.append("kaferf");
            }
        }
        catch (OutOfMemoryError e) {
            System.out.println(e);
            System.out.println("Exception was processed. Program continues" + "\n");
        }

        try {
            recursiveMethod();
        }
        catch (StackOverflowError e) {
            System.out.println(e);
            System.out.println("Exception was processed. Program continues" + "\n");
        }
    }
}

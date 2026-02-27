// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
import java.util.Scanner;

public class StudentManagementSystem {
   static Scanner sc;
   static final int MAX = 100;
   static Student[] students;
   static int count;

   public StudentManagementSystem() {
   }

   public static void main(String[] var0) {
      int var1;
      do {
         System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
         System.out.println("1. Add Student");
         System.out.println("2. View Students");
         System.out.println("3. Search Student");
         System.out.println("4. Delete Student");
         System.out.println("5. Exit");
         System.out.print("Enter choice: ");
         var1 = sc.nextInt();
         switch (var1) {
            case 1:
               addStudent();
               break;
            case 2:
               viewStudents();
               break;
            case 3:
               searchStudent();
               break;
            case 4:
               deleteStudent();
               break;
            case 5:
               System.out.println("Exiting...");
               break;
            default:
               System.out.println("Invalid choice!");
         }
      } while(var1 != 5);

   }

   public static void addStudent() {
      if (count >= 100) {
         System.out.println("Student limit reached!");
      } else {
         sc.nextLine();
         System.out.print("Enter Name: ");
         String var0 = sc.nextLine();
         System.out.print("Enter Age: ");
         int var1 = sc.nextInt();
         System.out.print("Enter Roll No: ");
         int var2 = sc.nextInt();
         System.out.print("Enter Marks: ");
         double var3 = sc.nextDouble();
         students[count] = new Student(var0, var1, var2, var3);
         ++count;
         System.out.println("Student Added Successfully!");
      }
   }

   public static void viewStudents() {
      if (count == 0) {
         System.out.println("No students available.");
      } else {
         for(int var0 = 0; var0 < count; ++var0) {
            students[var0].displayStudent();
         }

      }
   }

   public static void searchStudent() {
      System.out.print("Enter Roll No to Search: ");
      int var0 = sc.nextInt();
      boolean var1 = false;

      for(int var2 = 0; var2 < count; ++var2) {
         if (students[var2].rollNo == var0) {
            students[var2].displayStudent();
            var1 = true;
            break;
         }
      }

      if (!var1) {
         System.out.println("Student not found!");
      }

   }

   public static void deleteStudent() {
      System.out.print("Enter Roll No to Delete: ");
      int var0 = sc.nextInt();
      boolean var1 = false;

      for(int var2 = 0; var2 < count; ++var2) {
         if (students[var2].rollNo == var0) {
            for(int var3 = var2; var3 < count - 1; ++var3) {
               students[var3] = students[var3 + 1];
            }

            students[count - 1] = null;
            --count;
            System.out.println("Student Deleted Successfully!");
            var1 = true;
            break;
         }
      }

      if (!var1) {
         System.out.println("Student not found!");
      }

   }

   static {
      sc = new Scanner(System.in);
      students = new Student[100];
      count = 0;
   }

   static class Person {
      String name;
      int age;

      public Person(String var1, int var2) {
         this.name = var1;
         this.age = var2;
      }

      public void displayPerson() {
         System.out.println("Name: " + this.name);
         System.out.println("Age: " + this.age);
      }
   }

   static class Student extends Person {
      int rollNo;
      double marks;

      public Student(String var1, int var2, int var3, double var4) {
         super(var1, var2);
         this.rollNo = var3;
         this.marks = var4;
      }

      public void displayStudent() {
         this.displayPerson();
         System.out.println("Roll No: " + this.rollNo);
         System.out.println("Marks: " + this.marks);
         System.out.println("------------------------");
      }
   }
}

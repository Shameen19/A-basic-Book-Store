package com.company;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Collections;
import java.util.Date;
//In this system , it is online book store where we can generate recipet by doing payment in 2 methods and the discount is given accordingly
//A class named book is being made here in which several array lists ae declared
class book {
    //Arraylist<String> books=new Arraylist<>();
    ArrayList books = new ArrayList();
    ArrayList Customer = new ArrayList();
    ArrayList Cart = new ArrayList();
    ArrayList total=new ArrayList(); //to calculate the total
    ArrayList quantity=new ArrayList();//to calculate quantity
    Scanner input = new Scanner(System.in);
    boolean book_rec = false;//to check if book record is entered or not
    boolean cust_rec = false;// to check if customer record is entered or not
    boolean cart_rec = false; //to check if cart record is entered or not
//No pareameters are passed or return
//Function type is voi
    //This function displays the main menu for the user to enter records respectively
    public void main_menu() {

        int menu = 0;
        boolean check = true;
        do {
            try {
                System.out.println("----------Welcome To Books Heaven -----------");
                System.out.println("1.Add book record \n2.Add cutomer record \n3.Add to cart record \n4.Generate record \n5.Exit \nEnter a number ");
                menu = input.nextInt();
                check = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry : Try Again");
                input.nextLine();

            }
        } while (check == true);
        switch (menu) {
            case 1: {
                Book_record();
                break;
            }
            case 2: {
                Customer_record();
                break;
            }
            case 3: {
                Add_cart_menu();
                break;
            }
            case 4:
            {
                Generate_Receipt();
                break;
            }
            case 5:
            {
                System.exit(0);
            }
            default: {
                System.out.println("Invalid Input");
                main_menu();
            }

        }
    }
//No parameteres are return or passed
    //Function type is void
    //Dipslays the book menu for the user to enter the record of the books
    public void Book_record() {
        int menu_books = 0;
        boolean book_check = true;

        do {
            try {
                System.out.println("------RECORD OF THE Book------");
                System.out.println("1.Add book record \n2.view book record \n3.Search the book record \n4.Update book record \n5.DELETE book record \n6.Sort book record \n7.Main Menu \nEnter the number");
                menu_books = input.nextInt();
                book_check = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry :Try Again");
                input.nextLine();
            }
        } while (book_check == true);

        switch (menu_books) {
            case 1: {
                add_book();
                break;
            }
            case 2: {
                view_record();
                break;
            }
            case 3: {
                search_book();
                break;
            }
            case 4: {
                Update_book();
                break;
            }
            case 5: {
                Delete_book();
                break;
            }
            case 6: {
                Sort_book();
                break;
            }
            default: {
                main_menu();
                break;
            }

        }
    }
//Function type is void
    //No parameters are passe or return
    //Adds the book record to Book arraylist
    //the Quantity of the books is fixed which is 5 and prices are genreated randomly
    public void add_book() {
        int check = 1;
        while (check == 1) {


            Scanner in = new Scanner(System.in);
            String book_id = "";
            boolean book_id_check = true;
            boolean book_repe = true;

            while (book_id_check == true) {
                System.out.println("Enter book serial number");
                book_id = input.next();
                String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");  //Format for the book id is defined here
                if (book_id.matches(format)) {
                    book_id_check = false;
                } else {
                    System.out.println("Invalid Format : Try Aagin");
                    book_id_check = true;
                }
            }
            boolean book_check = books.contains(book_id);//cheking if book id is already present in record
            if (book_check == false) {
                books.add(book_id);
            } else {
                System.out.println("There is not much space left in the shelf : Enter another id ");
                continue;
            }


            String book_name = "";
            boolean book_name_check = true;
            char name_check = 0;
            while (book_name_check == true) {
                System.out.println("Enter book name  i-e only chrachters ");
                book_name = input.next();
                for (int name = 0; name < book_name.length(); name++) {
                    name_check = book_name.charAt(name);

                    if (Character.isLetter(name_check)) {
                        book_name_check = false;

                    } else {

                        book_name_check = true;
                    }
                }
            }
            books.add(book_name);
            String Author_name = "";
            boolean auth_check = true;
            char auth = 0;
            while (auth_check) {
                System.out.println("Enter Aurhor name i-e only charachter ");
                Author_name = in.next();
                for (int auth_name = 0; auth_name < Author_name.length(); auth_name++) {
                    name_check = Author_name.charAt(auth_name);

                    if (Character.isLetter(name_check)) {
                        auth_check = false;
                    } else {

                        auth_check = true;
                    }
                }
            }
            books.add(Author_name);


            int quantity = 5;
            books.add(quantity);


            int book_price = (int) (200 + (Math.random() * 500));
            books.add(book_price);
            String book_category = "";
            boolean cat_check = true;
            char cat_count = 0;
            while (cat_check==true) {
                System.out.println("Enter book category i-e only chrachters ");
                book_category = in.next();
                for (int cat_name = 0; cat_name < book_category.length(); cat_name++) {
                    cat_count = book_category.charAt(cat_name);

                    if (Character.isLetter(cat_count)) {
                        if (book_category.length() > 1 && book_category.length() <= 10) {
                            cat_check = false;
                        }
                    } else {
                        System.out.println("Enter only chrachters and length must be less than 10 chrachters  ");
                        cat_check = true;
                    }
                }
            }
            books.add(book_category);
            book_rec = true;
            System.out.println("enter 1 to enter record or 0 to terminate");
            check = in.nextInt();
            if (check != 1) {
                break;
            }
        }
        Book_record();

    }

//No paraeters are return or passed
    //Function type is void
    // Dispalys the book record for the user
    public void view_record() {
        if (book_rec == true) {
            System.out.println("----------VIEWING THE RECORD OF THE BOOK-------------");
            System.out.println("\n");
            System.out.println("Book_id\t\t\t\t\t\tname\tAuthor\t Quantity\t Price\t Category");
            System.out.println("----------------------------------------------------------------------------------------------------");
            for (int i = 0; i < books.size(); i += 6) {
                System.out.println(books.get(i) + "           " + books.get(i + 1) + "      " +books.get(i + 2) + "    " + books.get(i + 3) + "      " + books.get(i + 4) + "     " + books.get(i + 5));

            }


        } else {
            System.out.println("Enter book record first ");
            Book_record();
        }
        Book_record();
    }

    //No paraeters are return or passed
    //Function type is void
    //Displays the searched id of the book by the user in order to detemine which record is enterend or not
    public void search_book() {
        if (book_rec == true) {
            int x = 1;
            while (x == 1) {
                System.out.println("----------SEARCHING THE RECORD ---------------");
                String Id = "";
                boolean id_check = true;
                while (id_check == true) {
                    System.out.println("Enter the id of book you want to search");
                    Id = input.next();
                    String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                    if (Id.matches(format)) {
                        id_check = false;
                    } else {
                        System.out.println("Invalid Format : Try Aagin");
                        id_check = true;
                    }

                }
                //Seacrhing for the book in book array list
                if (books.contains(Id) & (books.indexOf(Id) == 0) | (books.indexOf(Id) % 6 == 0)) {
                    int search_rec = books.indexOf(Id);
                    System.out.println("ID              \t\tName       \t  Author      \t   Quantity      \tPrice     \t     Category");
                    System.out.println("----------------------------------------------------------------------------------------------------");
                    System.out.println(books.get(search_rec) + "\t\t"+books.get(search_rec + 1) + "\t\t\t"+ books.get(search_rec + 2) + " \t\t\t\t"+books.get(search_rec + 3) +  "\t\t\t"+ books.get(search_rec + 4) + " \t\t\t\t"+ books.get(search_rec + 5));
                } else {
                    System.out.println("Record not found");
                }
                boolean input_check=true;
                do {
                    try
                    {
                        System.out.println("Enter 1 to search more ");
                        x = input.nextInt();
                        input_check=false;
                    }
                    catch(InputMismatchException ex)
                    {
                        System.out.println("Invalid input : Try Again");
                        input.nextLine();
                        input_check=true;
                    }
                }while(input_check==true);

            }
            if (x != 1) {
                Book_record();
            } else {
                search_book();
            }
        } else {
            System.out.println("ENTER BOOK RECORD FIRST "); //If book record is not entered than it will display this
            Book_record();
        }


        Book_record();

    }

    //No paraeters are return or passed
    //Function type is void
    //Updates the book recod if the user wants to update any book present . Does not take redundant book id's
    public void Update_book() {

        int f = 1;
        if (book_rec == true) {
            while (f == 1) {
                System.out.println("-----------Updating The Record -------------------");
                String id = "";
                boolean id_check = true;
                while (id_check == true) {
                    System.out.println("Enter the id you want to update ");
                    id = input.next();
                    String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                    if (id.matches(format)) {
                        id_check = false;
                    } else {
                        System.out.println("Invalid Format : Try Aagin");
                        id_check = true;
                    }
                }
                if (books.contains(id) & (books.indexOf(id) == 0) | (books.indexOf(id) % 6 == 0)) {
                    int up_rec = books.indexOf(id);
                    String book_id = "";
                    boolean book_id_check = true;
                    while (book_id_check == true) {
                        System.out.println("Enter updated id of book ");
                        book_id = input.next();
                        String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                        if (book_id.matches(format)) {
                            book_id_check = false;
                        } else {
                            System.out.println("Invalid Format : Try Aagin");
                            book_id_check = true;
                        }
                    }
                    //Checks if the book id is present in array list or not
                    if (books.contains(book_id) & (books.indexOf(book_id) == 0) | (books.indexOf(book_id) % 6 == 0)) {
                        System.out.println("This record is already present");
                    }
                    else {
                        books.set(up_rec, book_id);
                        String name = "";
                        boolean name_check = true;
                        char name_check_up = 0;
                        while (name_check == true) {
                            System.out.println("Enter the updated name");
                            name = input.next();
                            for (int name_1 = 0; name_1 < name.length(); name_1++) {
                                name_check_up = name.charAt(name_1);
                            }
                            if (Character.isLetter(name_check_up)) {
                                name_check = false;
                            } else {
                                System.out.println("Enter only chrachters ");
                                name_check = true;
                            }
                        }
                        books.set(up_rec + 1, name);
                        String auth_name = "";
                        boolean auth_check = true;
                        char n_1 = 0;
                        while (auth_check == true) {
                            System.out.println("Enter the updated author  name");
                            auth_name = input.next();
                            for (int n_check = 0; n_check < auth_name.length(); n_check++) {
                                n_1 = auth_name.charAt(n_check);
                            }
                            if (Character.isLetter(n_1)) {
                                auth_check = false;
                            } else {
                                System.out.println("Enter only chrachters ");
                                auth_check = true;
                            }
                        }
                        books.set(up_rec + 2, auth_name);
                        int quantity = 5;
                        books.set(up_rec + 3, quantity);

                        books.set(up_rec + 4, (int) (200 + (Math.random() * 500)));
                        String cate_name = "";
                        boolean cate_check = true;
                        char cate_name_check = 0;
                        while (cate_check == true) {
                            System.out.println("Enter the updated category name");
                            cate_name = input.next();
                            for (int name_2 = 0; name_2 < cate_name.length(); name_2++) {
                                cate_name_check = cate_name.charAt(name_2);
                            }
                            if (Character.isLetter(cate_name_check)) {
                                cate_check = false;
                            } else {
                                System.out.println("Enter only chrachters ");
                                cate_check = true;
                            }
                        }
                        books.set(up_rec + 5, cate_name);

                    }
                } else {
                    System.out.println("this id does not exist");
                }
                boolean input_check = true;
                do {

                    try {
                        System.out.println("Enter 1 to  update more record ");
                        f = input.nextInt();
                        input_check = false;

                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Entry : Try again");
                        input.nextLine();
                    }
                } while (input_check == true);

                if (f == 1) {
                    Update_book();

                } else {
                    break;
                }
            }
        } else {
            System.out.println("Enter Book record First ");
            Book_record();
        }
        Book_record();
    }
    //No paraeters are return or passed
    //Function type is void
    //Deletes the book id if the user wants to
    public void Delete_book() {
        if (book_rec == true) {
            int x = 1;
            while (x == 1) {
                System.out.println("------------------DELETING THE RECORD------------------");
                String id = "";
                boolean id_check = true;
                while (id_check == true) {
                    System.out.println("Enter the id you want to delete");
                    id = input.next();
                    String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                    if (id.matches(format)) {
                        id_check = false;
                    } else {
                        System.out.println("Invalid Format : Try Aagin");
                        id_check = true;
                    }
                }
                if (books.contains(id) & (books.indexOf(id) == 0) | (books.indexOf(id) % 6 == 0)) {
                    int del_rec = books.indexOf(id);
                    books.remove(del_rec); //removing the record of the book entered by the user
                    books.remove(del_rec);
                    books.remove(del_rec);
                    books.remove(del_rec);
                    books.remove(del_rec);
                    books.remove(del_rec);
                } else {
                    System.out.println("Record not found");
                }
                boolean input_check = true;
                do {
                    try {
                        System.out.println("Enter 1 to delete more record ");
                        x = input.nextInt();
                        input_check = false;

                    } catch (InputMismatchException e) {
                        System.out.println("Inavlid Entry : Try Again");
                        input.nextLine();
                    }
                } while (input_check == true);

                if (x != 1) {
                    break;
                } else {
                    Delete_book();
                }
            }
        } else {
            System.out.println("Enter Book record first");
            Book_record();
        }
        Book_record();

    }
    //No paraeters are return or passed
    //Function type is void
    //This function will sort the book id entered in descending order in ascending order by fetching their id's and then the record in fromt of them
    public void Sort_book() {
        System.out.println("---------Sorting the record----------------------");
        System.out.println("\n");
        ArrayList sort_books = new ArrayList(); //new array list for sorting
        int e1;

        for (int i = 0; i < books.size(); i += 6) {
            sort_books.add(books.get(i)); //getting the ids of the books
        }
        Collections.sort(sort_books);
        int s1 = sort_books.size();
        System.out.println("ID              \t\tName       \t   Author      \t Quantity\t Price  \t  Category");
        System.out.println("----------------------------------------------------------------------------------------------------");
        for (int j = 0; j < s1; j++) {
            e1 = books.indexOf(sort_books.get(j));
            for (int x = e1; x < e1 + 6; x++) {
                System.out.print(books.get(x) + "\t\t\t");
            }
            System.out.println("");
        }
        Book_record();

    }
    //No paraeters are return or passed
    //Function type is void
    //This will display the function of Customer record for teh user to enter the ids of customer to register them . So that they can shop
    public void Customer_record() {
        int menu_customer = 0;
        boolean customer_check = true;

        System.out.println("------RECORD OF Customer------");
        System.out.println("1.Add customer record \n2.view customer record \n3.Search the customer record \n4.update customer record \n5.DELETE customer record \n6.Sort customer record \n7.Main Menu \nEner your choice ");
        do {
            try {
                System.out.println("Enter the number");
                menu_customer = input.nextInt();
                customer_check = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid Entry : Try Again");
                input.nextLine();
            }
        } while (customer_check == true);

        switch (menu_customer) {
            case 1: {
                add_Customer();
                break;
            }
            case 2: {
                view_Customer();
                break;
            }
            case 3: {
                search_Customer();
                break;
            }
            case 4: {
                Update_Customer();
                break;
            }
            case 5: {
                Delete_Customer();
                break;
            }
            case 6: {
                Sort_Customer();
                break;
            }
            case 7: {
                main_menu();
                break;
            }
            default: {
                System.out.println("Invalid Entry ");
                main_menu();
            }

        }
    }
//No paraeters are return or passed
    //Function type is void
   //This function will add the customer records enterd by the user so that they can get themselves register
    public void add_Customer() {
        int check = 1;
        while (check == 1) {


            String cust_id = "";
            boolean cust_id_check = true;
            while (cust_id_check) {
                System.out.println("Enter  Customer id i-e xxx-xx ");
                cust_id = input.next();
                String format = ("\\d{3}-\\d{2}"); //Format for the customer id is defined
                if (cust_id.matches(format)) {
                    cust_id_check = false;
                } else {
                    System.out.println("Invalid Format : Try Aagin");
                    cust_id_check = true;
                }
            }
            boolean cust_check_1 = Customer.contains(cust_id);//cheking if customer id is already present in record
            if (cust_check_1 == false) {
                Customer.add(cust_id);
            } else {
                System.out.println("id is taken : Enter another id ");
                continue;
            }

            String cust_name = "";
            boolean cust_name_check = true;
            char cust_check = 0;
            while (cust_name_check == true) {
                System.out.println("Enter Customer name");
                cust_name = input.next();
                for (int name_3 = 0; name_3 < cust_name.length(); name_3++) {
                    cust_check = cust_name.charAt(name_3);
                }
                if (Character.isLetter(cust_check)) {
                    cust_name_check = false;
                } else {
                    System.out.println("Enter only chrachters ");
                    cust_name_check = true;
                }
            }
            Customer.add(cust_name);


            boolean contact_check = true;
            String cust_contact = "";
            while (contact_check) {
                System.out.println("Enter Customer contact number i-e xxx-xxxxxxx   or xxxx-xxxxxxx  ");
                cust_contact = input.next();
                String format = ("\\d{3}-\\d{7}");
                String format_2 = ("\\d{4}-\\d{7}");
                if (cust_contact.matches(format) || cust_contact.matches(format_2)) {
                    contact_check = false;
                } else {
                    System.out.println("Invalid Format : Try Aagin");
                    contact_check = true;
                }
            }

            Customer.add(cust_contact);
            cust_rec = true;
            boolean input_check = true;
            do {
                try {
                    System.out.println("enter 1 to enter record or 0 to terminate");
                    check = input.nextInt();
                    input_check = false;
                } catch (InputMismatchException e) {
                    System.out.println("Invalid Entry : Tr Again");
                    input.nextLine();
                    input_check=true;
                }
            } while (input_check == true);

            if (check != 1) {
                break;
            }
        }
        Customer_record();

    }

    //No paraeters are return or passed
    //Function type is void
    //This will display the record of the customer entered in customer array list
    public void view_Customer() {
        if (cust_rec) {
            System.out.println("----------VIEWING THE RECORD OF THE Customer-------------");
            System.out.println("\n");
            System.out.println("ID, \tName  \t Contact number");
            System.out.println("----------------------------------");
            for (int i = 0; i < Customer.size(); i += 3) {
                System.out.println(Customer.get(i) + "\t" + Customer.get(i + 1) + "\t\t" + Customer.get(i + 2));

            }
        } else {
            System.out.println("Enter customer record first");
            Customer_record();
        }
        Customer_record();

    }

    //No paraeters are return or passed
    //Function type is void
    //This function will search the record of the customer entered to know if they are registered or not
    public void search_Customer() {


        int x = 1;
        if (cust_rec) {

            while (x == 1) {
                System.out.println("----------SEARCHING THE RECORD OF CUSTOMER ---------------");
                String Id = "";
                boolean id_check = true;
                while (id_check == true) {
                    System.out.println("Enter the id of Customer you want to search");
                    Id = input.next();
                    String format = ("\\d{3}-\\d{2}");
                    if (Id.matches(format)) {
                        id_check = false;
                    } else {
                        System.out.println("Invalid Format : Try Aagin");
                        id_check = true;
                    }
                }
                if (Customer.contains(Id) & (Customer.indexOf(Id) == 0) | (Customer.indexOf(Id) % 3 == 0)) {
                    int search_rec = Customer.indexOf(Id);
                    System.out.println("ID, \tName  \t  Contact number");
                    System.out.println("----------------------------------");  //Searched record of the customer
                    System.out.println(Customer.get(search_rec) + "\t" + Customer.get(search_rec + 1) + "\t\t" + Customer.get(search_rec + 2));
                } else {
                    System.out.println("Record not found");
                }
                boolean continue_input = true;
                do {
                    try {
                        System.out.println("Enter 1 to search more ");
                        x = input.nextInt();
                        continue_input=false;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Entry : Try Again");
                        input.nextLine();
                        continue_input=true;
                    }
                } while (continue_input);
            }
                if (x != 1) {
                    Customer_record();
                } else {
                    search_Customer();
                }


        } else {
            System.out.println("Enter Customer record first ");
            Customer_record();
        }
        Customer_record();
    }

    //No paraeters are return or passed
    //Function type is void
    //This function will update the record of the customer. However, it does not take the redundant id's to be entered.
    public void Update_Customer() {

        int f = 1;
        if (cust_rec == true) {

            while (f == 1) {
                System.out.println("-----------Updating The Record of Customer -------------------");
                String id = "";
                boolean id_Check = true;
                while (id_Check == true) {
                    System.out.println("Enter the id you want to update ");
                    id = input.next();
                    String format = ("\\d{3}-\\d{2}");  //Customer id format
                    if (id.matches(format)) {
                        id_Check = false;
                    } else {
                        System.out.println("Invalid Format : Try Aagin");
                        id_Check = true;
                    }
                }
                if (Customer.contains(id) & (Customer.indexOf(id) == 0) | (Customer.indexOf(id) % 3 == 0)) {
                    int up_rec = Customer.indexOf(id);
                    String cust_id = "";
                    boolean cust_check = true;
                    while (cust_check == true) {
                        System.out.println("Enter updated id of Customer ");  //updated id to be entered
                        cust_id = input.next();
                        String format = ("\\d{3}-\\d{2}");
                        if (cust_id.matches(format)) {
                            cust_check = false;
                        } else {
                            System.out.println("Invalid Format : Try Aagin");
                            cust_check = true;
                        }
                    }
                    if (Customer.contains(cust_id) & (Customer.indexOf(cust_id) == 0) | (Customer.indexOf(cust_id) % 3 == 0))
                        System.out.println("This record is already present");
                    else {
                        Customer.set(up_rec, cust_id);
                        String name = "";
                        boolean name_chek = true;
                        char cust_name_check = 0;
                        while (name_chek == true) {
                            System.out.println("Enter the updated name");
                            name = input.next();

                            for (int name_4 = 0; name_4 < name.length(); name_4++) {
                                cust_name_check = name.charAt(name_4);
                            }
                            if (Character.isLetter(cust_name_check)) {
                                name_chek = false;
                            } else {
                                System.out.println("Enter only chrachters ");
                                name_chek = true;
                            }
                        }
                        Customer.set(up_rec + 1, name);
                        String cust_cont = "";
                        boolean cust_cont_check = true;
                        while (cust_cont_check) {
                            System.out.println("Enter the updated Contact number");
                            cust_cont = input.next();
                            String format = ("\\d{3}-\\d{7}");
                            String format_2 = ("\\d{4}-\\d{7}");
                            if (cust_cont.matches(format) || cust_cont.matches(format_2)) {
                                cust_cont_check = false;
                            } else {
                                System.out.println("Invalid Format : Try Aagin");
                                cust_cont_check = true;
                            }
                        }

                        Customer.set(up_rec + 2, cust_cont);

                    }
                } else {
                    System.out.println("this id does not exist");
                }
                boolean input_check = true;
                do {
                    try {
                        System.out.println("Enter 1 to  update more record ");
                        f = input.nextInt();
                        input_check = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Entry : Try Again ");
                        input.nextLine();
                    }
                } while (input_check == true);

                if (f == 1) {
                    Update_Customer();

                } else {
                    break;
                }
            }
        } else {
            System.out.println("Enter Customer record first");
            Customer_record();
        }
        Customer_record();
    }
    //No paraeters are return or passed
    //Function type is void
    //This function will delte the record of the customer if the customer is no longer registered at book stored
    public void Delete_Customer() {

        int x = 1;
        if (cust_rec) {
            while (x == 1) {
                System.out.println("------------------DELETING THE RECORD OF CUSTOMER------------------");
                String id = "";
                boolean id_check = true;
                while (id_check == true) {
                    System.out.println("Enter the id you want to delete");
                    id = input.next();
                    String format = ("\\d{3}-\\d{2}");
                    if (id.matches(format)) {
                        id_check = false;
                    } else {
                        System.out.println("Invalid Format : Try Aagin");
                        id_check = true;
                    }
                }
                if (Customer.contains(id) & (Customer.indexOf(id) == 0) | (Customer.indexOf(id) % 3 == 0)) {
                    int del_rec = Customer.indexOf(id);
                    Customer.remove(del_rec);
                    Customer.remove(del_rec);  //Removing the record of customer
                    Customer.remove(del_rec);


                } else {
                    System.out.println("Record not found");
                }
                boolean input_check = true;
                do {
                    try {
                        System.out.println("Enter 1 to delete more record ");
                        x = input.nextInt();
                        input_check = false;
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid Entry : Try Again");
                        input.nextLine();
                    }
                } while (input_check == true);

                if (x != 1) {
                    break;
                } else {
                    Delete_Customer();
                }
            }
        } else {
            System.out.println("Enter customer record First");
            Customer_record();
        }
        Customer_record();

    }
    //No paraeters are return or passed
    //Function type is void
    //This function will sort the record of the customer entered in oreder
    public void Sort_Customer() {
        System.out.println("---------Sorting the record of Customer----------------------");
        System.out.println("\n");
        ArrayList sort_cust = new ArrayList();  //Array list created to  for sorting
        int e1;

        for (int i = 0; i < Customer.size(); i += 3) {
            sort_cust.add(Customer.get(i));
        }
        Collections.sort(sort_cust);
        int s1 = sort_cust.size();
        System.out.println("ID, \t\t Name   \tContact Number  ");
        System.out.println("--------------------------------------------------------------------------------------------");
        for (int j = 0; j < s1; j++) {
            e1 = Customer.indexOf(sort_cust.get(j));
            for (int x = e1; x < e1 + 3; x++) {
                System.out.print(Customer.get(x) + "\t\t");
            }
            System.out.println(" ");
        }
        Customer_record();

    }
    //No paraeters are return or passed
    //Function type is void.
    //This function will display the menu for add to cart to customer to shop and add items to cart

    public void Add_cart_menu() {
        boolean cart_check = true;
        System.out.println("------RECORD OF THE Cart------");
        System.out.println("1.Add to cart \n2.view Cart record \n3.Search the cart record \n4.update cart record \n5.DELETE cart record \n6.Main_menu \nEnter your choice");
        int menu_cart = 0;
        do {
            try {
                System.out.println("Enter the number");
                menu_cart = input.nextInt();
                cart_check = false;
            } catch (InputMismatchException e) {
                System.out.println("Invalid ENtry : Try Again");
                input.nextLine();
                cart_check = true;
            }
        } while (cart_check == true);

        switch (menu_cart) {
            case 1: {
                add_Cart();
                break;
            }
            case 2: {
                view_Cart();
                break;
            }
            case 3: {
                search_Cart();
                break;
            }
            case 4: {
                Update_Cart();
                break;
            }
            case 5: {
                Delete_Cart();
                break;
            }


            default: {
                main_menu();
                break;
            }

        }
    }
    //No paraeters are return or passed
    //Function type is void
    //This function will add the items bought by the cutomer to the cart .
    //This will not take two id'sof customer and not two same id as the recipet is genreated for only one customer at a time
    public void add_Cart() {
        int inputt = 1;


        String cust_id_1 = null;
        boolean cust_check = true;
        while (cust_check == true) {
            System.out.println("Enter the id of customer i-e xxx-xx");
            cust_id_1 = input.next();
            String format = ("\\d{3}-\\d{2}");
            if (cust_id_1.matches(format)) {
                cust_check = false;
            } else {
                System.out.println("Invalid Format : Try Aagin");
                input.nextLine();
                cust_check = true;
            }
        }
        if (Customer.contains(cust_id_1)) {
            System.out.println("You are registered ");
            Cart.add(Customer.get(Customer.indexOf(cust_id_1)));  //ADDING the id name and contact of the customer
            Cart.add(Customer.get(Customer.indexOf(cust_id_1) + 1));
            Cart.add(Customer.get(Customer.indexOf(cust_id_1) + 2));
            String id = "";
            boolean book_check = true;
            while (book_check == true) {
                System.out.println("Enter the book id you want to buy i-e xxx-x-xx-xxxxxx-x ");
                id = input.next();
                String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                if (id.matches(format)) {
                    book_check = false;
                } else {
                    System.out.println("Invalid Format : Try Aagin");
                    book_check = true;
                }

            }
            if (books.contains(id) & (books.indexOf(id) == 0) | (books.indexOf(id) % 6 == 0)) {
                if (Cart.contains(id)) {
                    System.out.println("This book is already present in the cart : tO UPDATE QUANTITY go to update cart function"); // if user has already bought the id

                } else {
                    System.out.println("Your book is found ");
                    Cart.add(books.get(books.indexOf(id)));
                    Cart.add(books.get(books.indexOf(id) + 1));
                    System.out.println("The quantity of this book we have is 5 ");
                    int quan = 0;
                    boolean quantit_check = true;
                    boolean quan_ch = true;

                    while (quan_ch == true) {

                        do {
                            try {
                                System.out.println("Enter the quantity of this book you want to buy");  //asking for the quantity
                                quan = input.nextInt();
                                quantit_check = false;
                            } catch (InputMismatchException ex) {
                                System.out.println("Invalid Entry : Try Again");
                                input.nextLine();
                                quantit_check = true;
                            }
                        } while (quantit_check == true);

                         //quanity should not be zero or grater than 5
                        if (quan != 0 && quan <= 5) {
                            Cart.add(5, quan);
                            quantity.add(quan);
                            quan_ch = false;

                        } else {
                            System.out.println("Enter quantity less than 5");
                            quan_ch = true;
                        }
                    }


                    Cart.add(books.get(books.indexOf(id) + 4)); //adding the record at the specified indexes of he cart
                    total.add(books.get(books.indexOf(id) + 4));
                    cart_rec = true;

                }
            }else {
                System.out.println("Your book is not found ");

            }
        }
        else
        {
            System.out.println("You are not registered");
            Add_cart_menu();
        }
        boolean c_in=true;
        do {

            try
            {
                System.out.println("enter 1 to add another record on the same id and any other number to go back");
                inputt = input.nextInt();
                c_in=false;
            }
            catch(InputMismatchException ex)
            {
                System.out.println("Invalid Entry: Try Again");
                input.nextLine();
                c_in=true;
            }
        }while(c_in==true);

        while (inputt == 1) {


            if (Customer.contains(cust_id_1)) {
                if (Cart.contains(cust_id_1)) {
                    int index = Cart.indexOf(cust_id_1);
                    String id = "";
                    boolean id_check = true;
                    while (id_check == true) {
                        System.out.println("Enter the book id you want to buy ");
                        id = input.next();
                        String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                        if (id.matches(format)) {
                            id_check = false;
                        } else {
                            System.out.println("Invalid Format : Try Aagin");
                            id_check = true;
                        }
                    }
                    if (Cart.contains(id)) {
                        System.out.println("This book is already present :IF you want to buy more update the quantity in update record ");
                    } else {
                        if (books.contains(id) & (books.indexOf(id) == 0) | (books.indexOf(id) % 6 == 0)) {
                            System.out.println("Your book is found ");
                            Cart.add(index + 7, " \t   ");
                            Cart.add(index + 8, " \t   ");
                            Cart.add(index + 9, " \t   ");
                            Cart.add(index + 10, books.get(books.indexOf(id)));
                            Cart.add(index + 11, books.get(books.indexOf(id) + 1));
                            int next_quan = 0;
                            boolean quan_check1 = true;
                            boolean quan_check2 = true;
                            while (quan_check1) {
                                do {
                                    try {
                                        System.out.println("The quantity we have for this book is 5");
                                        System.out.println("Enter Quantity ");
                                        next_quan = input.nextInt();
                                        quan_check2 = false;
                                    } catch (InputMismatchException ex) {
                                        System.out.println("Invalid Entry : Try Again");
                                        input.nextLine();

                                        quan_check2 = true;
                                    }
                                } while (quan_check2 == true);
                                if (next_quan != 0 && next_quan <= 5) {
                                    Cart.add(12, next_quan);
                                    quantity.add(next_quan);
                                    quan_check1 = false;
                                } else {
                                    System.out.println("Out of stock");
                                    quan_check1 = true;
                                }

                            }

                            Cart.add(index + 13, books.get(books.indexOf(id) + 4));
                            total.add(books.get(books.indexOf(id) + 4));

                        } else {
                            System.out.println("Your book is not found ");

                        }
                    }
                }

            }
        else {
                System.out.println("You are not registered");
                Add_cart_menu();
            }
            boolean input_1 = true;
            do {
                try {
                    System.out.println("enter 1 to add another record on the same id and any other number to go back");
                    inputt = input.nextInt();
                    input_1 = false;
                } catch (InputMismatchException ex) {
                    System.out.println("INvalid Entry: Try Again");
                    input.nextLine();
                    input_1 = true;
                }
            } while (input_1 == true);
        }
        if (inputt != 1) {
            Add_cart_menu();
        }

        Add_cart_menu();
    }

    //No paraeters are return or passed
    //Function type is void
    //This will display teh record of cart for the customer to see if he has bought respective books or not
    public void view_Cart() {
        if(cart_rec==true) {
            System.out.println("----------VIEWING THE RECORD OF THE Cart-------------");
            System.out.println("\n");
            System.out.println("ID, \t Name  \t\t Contact  \t\t\tBook_id\t\t\t\tname\tQuantity\tPrice");

            System.out.println("--------------------------------------------------------------------------------------------");
            for (int i = 0; i < Cart.size(); i += 7) {
                System.out.println(Cart.get(i) + "\t" + Cart.get(i + 1) + "\t\t" + Cart.get(i + 2) + "\t\t" + Cart.get(i + 3) + "         " + Cart.get(i + 4) + "      " + Cart.get(i + 5) + "         " + Cart.get(i + 6));

            }
        }
        else
            {
                System.out.println("Enter cart record first");
                Add_cart_menu();
            }
        Add_cart_menu();
    }
    //No paraeters are return or passed
    //Function type is void
    //This will display the record for the customer .
    //First register yoursdelf
    //second enter the customer registed id and then teh id of teh book you want to search
    public void search_Cart() {
        int x = 1;
        if(cart_rec==true) {
            while (x == 1) {
                System.out.println("----------SEARCHING THE RECORD OF CART ---------------");
                System.out.println("Enter the id of Customer you want to search");
                String Id = input.next();
                if (Cart.contains(Id) & (Cart.indexOf(Id) == 0) | (Cart.indexOf(Id) % 7 == 0)) {
                    int search_rec = Customer.indexOf(Id);
                    System.out.println("ENter the book id you want to search");
                    String book_id = input.next();
                    if (Cart.contains(book_id)) {
                        int index = Cart.indexOf(book_id);
                        System.out.println("BOOK ID \t\t Name  \t\tQuantity  \t Price ");
                        System.out.println(Cart.get(index) + "\t" + Cart.get(index + 1) + "\t" + Cart.get(index + 2) + "\t" + Cart.get(index + 3));
                    } else {
                        System.out.println("You have not bought this book");
                    }
                } else {
                    System.out.println("Record not found");
                }
                System.out.println("Enter 1 to search more ");
                x = input.nextInt();
                if (x != 1) {
                    break;
                } else {
                    search_Cart();
                }

            }
        }
        else
        {
            System.out.println("Enter cart record first");
            Add_cart_menu();
        }
        Add_cart_menu();
    }


    //No paraeters are return or passed
    //Function type is void
    //This will delete the cart of the record of the book bought by the user
    public void Delete_Cart() {
        int del_check = 1;
        if(cart_rec==true) {
            String cust_id = "";
            boolean cust_check = true;
            while (cust_check == true) {
                System.out.println("Enter customer id ");
                cust_id = input.next();
                String format = ("\\d{3}-\\d{2}");
                if (cust_id.matches(format)) {
                    cust_check = false;
                } else {
                    System.out.println("Invalid Format : Try Aagin");
                    cust_check = true;
                }
            }
            if (Cart.contains(cust_id)) {

                while (del_check == 1) {
                    String book_id = "";
                    boolean book_check = true;
                    while (book_check == true) {
                        System.out.println("Enter the book id you ant to delete ");
                        book_id = input.next();
                        String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                        if (book_id.matches(format)) {
                            book_check = false;
                        } else {
                            System.out.println("Invalid Format : Try Aagin");
                            book_check = true;
                        }
                    }
                    if (Cart.contains(book_id)) {
                        System.out.println("-----Delteing the book fro Cart-----");
                        int index_book = Cart.indexOf(book_id);
                        Cart.set(index_book, "-");
                        Cart.set(index_book + 1, "-");
                        Cart.set(index_book + 2, "-");
                        Cart.set(index_book + 3, "-");
                    } else {
                        System.out.println("You have not bought this book ");
                    }
                    boolean input_check = true;
                    do {
                        try {
                            System.out.println("Enter 1 to delte more or 0 to terinate ");
                            del_check = input.nextInt();
                            input_check = false;
                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid input: Try Again");
                            input_check = true;
                        }
                    } while (input_check == true);

                }

            } else {
                System.out.println("You are not registered");
                Add_cart_menu();
            }
        }
        else
        {
            System.out.println("Enter cart record first");
            Add_cart_menu();
        }
        Add_cart_menu();
    }
    //No paraeters are return or passed
    //Function type is void
    //This wil displa two menu for the user either to update whole book record or just the quantity
    //the quantity can only be less than or equal to 5 and not 0
    //this will update the record of the books bought acorodingly
    public void Update_Cart()
    {
        int looping_update=1;
        if(cart_rec==true) {
            while (looping_update == 1) {
                String customer = "";
                boolean customer_check = true;
                while (customer_check == true) {
                    System.out.println("Enter customer id ");
                    customer = input.next();
                    String format = ("\\d{3}-\\d{2}");
                    if (customer.matches(format)) {
                        customer_check = false;
                    } else {
                        System.out.println("Invalid Format : Try Aagin");
                        customer_check = true;
                    }
                }
                if (Cart.contains(customer)) {
                    System.out.println("Your record is found ");
                    int choice = 0;
                    boolean choice_input = true;
                    do {
                        try {
                            System.out.println("1.To Update whole book record \n2.To update quantity \nEnter your choice ");
                            choice = input.nextInt();
                            choice_input = false;

                        } catch (InputMismatchException ex) {
                            System.out.println("Invalid Entry: Try again ");
                            input.nextLine();
                            choice_input = true;
                        }
                    } while (choice_input == true);
                    if (choice == 1)
                    {
                        int looping=1;
                        while(looping==1)
                        {
                        String book_id="";
                        boolean format_check=true;
                        while(format_check==true)
                        {
                            System.out.println("Enter the book id you want to update ");
                            book_id = input.next();
                            String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                            if (book_id.matches(format)) {
                                format_check = false;
                            } else {
                                System.out.println("Invalid Format : Try Aagin");
                                format_check = true;
                            }
                        }
                        if(Cart.contains(book_id)) {
                            System.out.println("Your book id found ");
                            int index = Cart.indexOf(book_id);
                            boolean book_id_check = true;
                            String bookid = "";
                            while (book_id_check == true) {
                                System.out.println("Enter the updated book id  ");
                                bookid = input.next();
                                String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                                if (bookid.matches(format)) {
                                    book_id_check = false;
                                } else {
                                    System.out.println("Invalid Format : Try Aagin");
                                    book_id_check = true;
                                }
                            }
                            if(books.contains(bookid))
                            {
                                System.out.println("Your book is found");
                               Cart.set(index,books.get(books.indexOf(bookid)));
                               Cart.set(index+1,books.get(books.indexOf(bookid)+1));
                               boolean quan_check_1=true;
                               boolean quan_check_2=true;
                               int quantity=0;
                               while(quan_check_1==true)
                               {
                                   do {
                                       try
                                       {
                                           System.out.println("The quantity we have for this book is 5");
                                           System.out.println("Eneter Quantity");
                                           quantity=input.nextInt();
                                           quan_check_2=false;
                                       }
                                       catch(InputMismatchException ex)
                                       {
                                           System.out.println("Invalid Entry : Try Again");
                                           input.nextLine();
                                           quan_check_2=true;
                                       }
                                   }while(quan_check_2==true);
                                   if(quantity!=0 && quantity<=5)
                                   {
                                       Cart.set(index+2,quantity);
                                       quan_check_1=false;
                                   }
                                   else
                                   {
                                       quan_check_1=true;
                                   }
                               }
                               Cart.set(index+3,books.get(books.indexOf(bookid)+4));

                            }
                            else
                            {
                                System.out.println("Sorry we do not have this book");
                            }
                        }
                        else
                        {
                            System.out.println("Sorry You have not bought this book");
                        }
                        boolean checking=true;
                        do {
                            try
                            {
                                System.out.println("Enter 1 to update more book record or 0 to terminate");
                                looping=input.nextInt();
                                checking=false;
                            }
                            catch(InputMismatchException ex)
                            {
                                System.out.println("Invalid Entry : Try Again");
                                input.nextLine();
                                checking=true;
                            }
                        }while(checking==true);
                        }
                        if(choice!=1)
                        {
                            System.out.println("Terminating");
                        }
                    } else if (choice == 2)
                    {
                      int looping_1=1;
                      while(looping_1==1)
                      {
                          String iid="";
                          boolean book_iid=true;
                          while(book_iid==true)
                          {
                              System.out.println("Enter the book id for which you want to update the quantity");
                              iid=input.next();
                              String format = ("\\d{3}-\\d{1}-\\d{2}-\\d{6}-\\d{1}");
                              if (iid.matches(format)) {
                                  book_iid = false;
                              } else {
                                  System.out.println("Invalid Format : Try Aagin");
                                  book_iid = true;
                              }
                          }
                          if(Cart.contains(iid))
                          {
                              int index_2=Cart.indexOf(iid);
                              boolean quantit=true;
                              int quany=1;
                              boolean coninue_inpt=true;
                              while(quantit==true)
                              {
                                  do {
                                      try
                                      {
                                          System.out.println("The quantity we have for this book is 5");
                                          System.out.println("Enter the quantity");
                                          quany=input.nextInt();
                                          coninue_inpt=false;
                                      }
                                      catch(InputMismatchException ex)
                                      {
                                          System.out.println("Invalid Entry : Try Again");
                                          input.nextLine();
                                          coninue_inpt=true;
                                      }
                                  }while(coninue_inpt==true);
                                  if(quany!=0 && quany<=5)
                                  {
                                      Cart.set((index_2)+2,quany);
                                      quantit=false;
                                  }
                                  else
                                  {
                                      System.out.println("Enter AGAIN");
                                      quantit=true;
                                  }
                              }
                          }
                          else
                          {
                              System.out.println("Not found");
                          }
                          boolean looping_3=true;
                          do {
                              try
                              {
                                  System.out.println("Enter 1 t update more quantity or zero to termininate");
                                  looping_1=input.nextInt();
                                  looping_3=false;
                              }
                              catch(InputMismatchException ex)
                              {
                                  System.out.println("Invalid Entry : Try again");
                                  input.nextLine();
                                  looping_3=true;
                              }
                          }while(looping_3==true);
                      }
                    } else
                        {
                            System.out.println("Invalid Input");
                        }
                } else {
                    System.out.println("You have not shopped here yet ");

                }
                boolean continuing=true;
                do {
                    try
                    {
                        System.out.println("Enter 1 to update more or 0 to terminate");
                        looping_update=input.nextInt();
                        continuing=false;
                    }
                    catch(InputMismatchException ex)
                    {
                        System.out.println("Invalid Entry : Try Again");
                        input.nextLine();
                        continuing=true;
                    }
                }while(continuing==true);
            }
        }
        else
        {
            System.out.println("Enter cart record first");
            Add_cart_menu();
        }
        Add_cart_menu();
    }
    //No paraeters are return or passed
    //Function type is void
    //This will generate teh recipt when all the records of the user entered
    //This will disply discounted amount to if the books number is greater than or equal to 4
    //This will also ask teh customer to either pay through cash or debit card
    public void Generate_Receipt()
    {
        if(cart_rec==true)

        {
            int count_1=0;
            int count_2=0;
            int count_3=0;
            int Discount=0;
            boolean gen_rec=true;

            int price=0;
            int quan_2=0;
            for(int x=0;x<total.size();x++)
            {
                int to_1= (int) total.get(x);
                price+=to_1;
            }
            for(int y=0;y<quantity.size();y++)
            {
                int to_2= (int) quantity.get(y);
                quan_2+=to_2;
            }
            int total=price*quan_2;
            if(quan_2>=4)
            {
                Discount=total-350;
                count_1+=1;
            }
            boolean price_check=true;
            int choice=0;
            do {
                try
                {
                    System.out.println("Payment Method");
                    System.out.println("1.Debit Card \n2.Cash \nEnter your choice");
                    choice=input.nextInt();
                    price_check=false;
                }
                catch(InputMismatchException ex)
                {
                    System.out.println("Invalid Input : Try Again");
                    price_check=true;
                }
            }while(price_check==true);
            if(choice==1) {
                boolean debit = true;
                String deb_card = "";
                while (debit == true) {
                    System.out.println("Enter debit card i-r xxx-xxxx-xx");
                    deb_card = input.next();
                    String format = ("\\d{3}-\\d{4}-\\d{2}");
                    if (deb_card.matches(format)) {
                        debit = false;

                    } else {
                        System.out.println("Invalid Try : Try Again");
                        debit = true;
                    }

                }
                count_2++;
            }
            else if(choice==2)
            {
                count_3++;
            }
            SimpleDateFormat formatter=new SimpleDateFormat("dd/MM/yyyy");
            Date date=new Date();
            System.out.println("DATE : " + formatter.format(date));
            DateTimeFormatter dtf=DateTimeFormatter.ofPattern("HH:mm:ss");
            LocalDateTime now=LocalDateTime.now();
            System.out.println("Time : " + dtf.format(now));
            System.out.println("ID, \t Name  \t\t Contact  \t\t\tBook_id\t\t\t\tname\t Quantity\t Price");

            System.out.println("--------------------------------------------------------------------------------------------");
            for(int a=0;a<Cart.size();a+=7)
            {
                System.out.println(Cart.get(a) +  "\t" + Cart.get(a + 1) + "\t\t" + Cart.get(a + 2) + "\t\t" +Cart.get(a+3) + "           " + Cart.get(a + 4)  + "    " + Cart.get(a + 5) + "      " + Cart.get(a + 6)   );
            }
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal :"  + total);

            if(count_1==1)
            {

                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tDiscount:"  + Discount);
            }
            else
            {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal :"  + total);
            }
            if(count_2==1)
            {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tpayment method :"  + "Debit Card");
            }
            else if(count_3==1)
            {
                System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tPayment method:"  + "Cash");
            }
            System.out.println("                                           Thank you for shopping here                           ");


            cart_rec=false;
            if(cart_rec==false)
            {
                for (int x=0;x<Cart.size();x++)
                {
                    Cart.remove(x);
                }
            }

        }
        else
        {
            System.out.println("Enter Cart record first");
            Add_cart_menu();
        }
        Add_cart_menu();
    }


}



//This is the main class for the user .
//This will call the main function defined in the Class book

public class Main {

    public static void main(String[] args) {
        book n=new book();
        n.main_menu();
	// write your code here
    }
}

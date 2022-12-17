package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 85);
        Book alphabet = new Book("Alphabet", 33);
        Book harryPotter = new Book("Harry Potter", 458);
        Book pinocchio = new Book("Pinocchio", 125);
        Book[] books = new Book[4];
        books[0] = cleanCode;
        books[1] = alphabet;
        books[2] = harryPotter;
        books[3] = pinocchio;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getCount() + " pages");
        }
        System.out.println("After changes:");
        Book ch = books[0];
        books[0] = books[3];
        books[3] = ch;
        for (Book book : books) {
            System.out.println(book.getName() + " - " + book.getCount() + " pages");
        }
        System.out.println("Clean code");
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName() + " - " + book.getCount() + " pages");
            }
        }
    }
}

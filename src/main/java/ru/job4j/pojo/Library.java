package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 567);
        Book book2 = new Book("Bible", 234);
        Book book3 = new Book("Java for beginners", 458);
        Book book4 = new Book("Java or Python?", 10);
        Book[] books = new Book[]{book1, book2, book3, book4};

        for (int i = 0; i < books.length; i++) {
            System.out.println("Name of book: \"" + books[i].getName()
                    + "\",  " + books[i].getNumberOfPage() + " pages.");
        }
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        System.out.println("After change:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Name of book: \"" + books[i].getName()
                    + "\",  " + books[i].getNumberOfPage() + " pages.");
        }
        System.out.println("Only Clean code");
        for (Book bk : books) {
            if (bk.getName().equals("Clean code")) {
                System.out.println("Name of book: \"" + bk.getName()
                        + "\",  " + bk.getNumberOfPage() + " pages.");
            }
        }

    }
}

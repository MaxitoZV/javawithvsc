import model.Book;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.format("My name is %s, my last name is %s, am %d years old, am %.2f meters tall  \n", "Max","Zavaleta",48, 1.74);

        System.out.printf("Qty args: %d\n", args.length);
        int i=1;
        for (String string : args) {
            System.out.format("Args[%d]: %s\n", i,string);
            i++;
        }
        Book book = new Book(1, "100 años de soledad", "Gabriel García Marquez");
        System.out.format("Book: %s", book);
    }
}

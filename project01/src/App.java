public class App {
    public static void main(String[] args) throws Exception {
        System.out.printf("Qty args: %d\n", args.length);
        int i=1;
        for (String string : args) {
            System.out.format("Args[%d]: %s\n", i,string);
            i++;
        }
    }
}

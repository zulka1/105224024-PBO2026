

public class Filter {
    public static void main(String[] args) throws Exception {
        for(int i = 0; i < 50; i++) {
            if(i % 3 == 0) {
               continue;
            }
            else if(i % 5 == 0) {
                continue;
            }
            System.out.println(i);
        }
    }
}

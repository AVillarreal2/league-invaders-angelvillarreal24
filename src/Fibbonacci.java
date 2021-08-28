public class Fibbonacci {
    public static void main(String[] args) {
        Fibbonacci fibbonacci = new Fibbonacci();
        for(int i = 0; i <= 10; i++){
            int e = fibbonacci.fib(i);
            System.out.println(e);
        }
    }

    private int fib(int d){
        if(d <= 0){

        }
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 0; i <= d; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

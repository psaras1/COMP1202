public class Debug{

    public int a=61;
    public int b=57;
    public int c=22;
    public static int d;
    public static boolean bl = true;

    public static int aMethod(){
        d=9;
        int d = 87;
        Debug b1 = new Debug();
        d=15;
        b1.aMethod(145);
        Debug b2 = new Debug();
        b2=b1;
        if(bl){
            b2.a = 299;
            b2.b = 209;
            b1.a = 222;
            b1.b = 345;
            b1.c = 315;
            b2.c = 191;
            Debug.bl = false;
        }
        return b1.c;
    }

    public void aMethod(int a){
        int b = 33;
        c=a;
        d=d+1;
    }

    public static int fibonacci(int number){
        if(number <2){
            return number;
        }
        return fibonacci(number-1) + fibonacci(number -2);
    }

    public static int count() {
        int count = 0;

        while(!bl){

            count = count + aMethod();
            Debug.bl = true;
        }
        return count;
    }

    public static void main(String args[]){
        System.out.println(aMethod());
        System.out.println(fibonacci(10));
        System.out.println(count());
    }
}
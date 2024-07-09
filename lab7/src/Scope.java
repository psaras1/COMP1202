public class Scope {
    public int a = 1;
    public int b = 3;
    public int c = 4;
    public static int d;

    public static void main(String[] args) {
        d = 5;
        System.out.println("A:" + d);//5
        System.out.println("B:" + Scope.d);//5
        int d = 13;
        System.out.println("C:" + d);//13
        System.out.println("D:" + Scope.d);//5
        Scope.d = 14;
        d = 15;
        System.out.println("E:" + d);//15
        System.out.println("F:" + Scope.d);//14

        Scope s1 = new Scope();
        System.out.println("G:" + s1.a);//1
        System.out.println("H:" + s1.b);//3
        System.out.println("I:" + s1.c);//4

        s1.aMethod(77);

        System.out.println("J:" + s1.a); //1
        System.out.println("K:" + s1.b); //3
        System.out.println("L:" + s1.c); //77

        Scope s2 = new Scope();

        System.out.println("M:" + s2.a);//1
        System.out.println("N:" + s2.b);//3
        System.out.println("O:" + s2.c);//4
        s2=s1;
        System.out.println("P:" + s2.a);//1
        System.out.println("Q:" + s2.b);//3
        System.out.println("R:" + s2.c);//77

        s2.a=19;
        s2.b=20;
        s1.a=33;
        s1.b=34;
        s1.c=35;
        s2.c=21;

        System.out.println("S:" + s1.a);//33
        System.out.println("T:" + s1.b);//34
        System.out.println("U:" + s1.c);//21
        System.out.println("V:" + s2.a);//33
        System.out.println("W:" + s2.b);//34
        System.out.println("X:" + s2.c);//21


    }


    public void aMethod(int a){
        int b=4;
        System.out.println("FOO.A:"+a); //77
        System.out.println("FOO.B:"+b); //4
        System.out.println("FOO.C:"+c); //4
        System.out.println("FOO.D:"+d); //14
        c=a;
        d=d+1;
        System.out.println("FOO.E:"+a); //77
        System.out.println("FOO.F:"+b); //4
        System.out.println("FOO.G:"+c); //77
        System.out.println("FOO.H:"+d); //15
        System.out.println("FOO.I:"+this.b); //15

    }
}

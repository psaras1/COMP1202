package lab4part2;

import lab4part1.Toolbox;

public class Main {

    public static void main(String[]args){
        lab4part1.Toolbox myToolbox = new Toolbox();
        int x= myToolbox.readIntegerFromCmd();
        int[] times;
        for(int i=1;i<21;i++){
            if(i==20){
                System.out.print(x*i);
            }
            else {
                System.out.print(x * i + ",");
            }
        }
        System.out.println();
        int sum=0;
        int w=0;
        int count=0;
        while(sum<500){
                w+=1;
                sum+=w;
                count+=1;
        }
        System.out.print(count);

        System.out.println();

        UserGroup users = new UserGroup();
        users.addSampleData();
        users.printUsernames();


    }
}

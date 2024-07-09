package lab4part3;

import lab4part1.Toolbox;
import lab4part3.User;

import java.util.Iterator;

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
        System.out.println();


        UserGroup administrators = new UserGroup();
        administrators.addSampleData();
        Iterator<User> it = users.getUserIterator();
        while(it.hasNext()){
            if (it.next().getUserType().equals("admin")){
                administrators.addAdmins(it.next());
            }
        }
        System.out.println();

        Iterator<User> ad = administrators.getUserIterator();
        while(ad.hasNext()){
            System.out.println(ad.next().getUserType());
        }

        administrators.getLastUser().setUserType("user");
        administrators.printUsernames();

        //when using the set user type method on the administrators array, the User stays in the administrators array regardless
        //of the user type we set. This could be solved by adding a condition to the setUserType method, if the user type was admin and changed to
        //something else, remove the given user from the administrators array and add them to the corresponding array.

    }



}

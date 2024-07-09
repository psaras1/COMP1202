package lab4part2;

import java.util.ArrayList;

public class UserGroup {

    private ArrayList<User> users;
    public UserGroup(){
        users = new ArrayList<User>();

    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public void addSampleData(){
        for(int i=0;i<10;i++){
            users.add(new User("username","type","name"));

        }
    }
    public User getUser(int i){
        return users.get(i);
    }
    public void printUsernames(){
        for (User x : users){
            System.out.println(x.getUsername()+" "+x.getUserType());
        }
    }

}

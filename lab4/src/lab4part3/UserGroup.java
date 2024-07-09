package lab4part3;

import java.util.ArrayList;
import java.util.Iterator;

public class UserGroup {

    private ArrayList<User> users;
    public UserGroup(){
        users = new ArrayList<>();

    }
    public ArrayList<User> getUsers(){
        return users;
    }
    public void addSampleData(){
        for(int i=0;i<10;i++){
            users.add(new User("username","admin","name"));

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

    public void removeFirstUser(){
        users.remove(0);
    }
    public void removeLastUser(){
        int size = users.size();
        users.remove(size-1);
    }

    public void removeUser(String username){
        int size = users.size();
        for (int i=0;i<size;i++){
            String inArray = users.get(i).getUsername();
            if(inArray.equals(username)){
                users.remove(i);
                size--;
            }

        }
    }

    public Iterator<User> getUserIterator(){
        return users.iterator();
    }
    public void addAdmins(User user){
        users.add(user);
    }

    public User getLastUser(){
        return users.get(users.size()-1);
    }

}

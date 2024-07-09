package lab4part3;

public class User {
    private String username;
    private String userType; //user, editor or admin ?
    private String name;
    public User(String uName,String uType,String n){
        username = uName;
        userType = uType;
        name = n;
    }
    public String getUsername(){
        return username;
    }
    public String getUserType(){
        return userType;
    }
    public String getName(){
        return name;
    }
    public void setUserType(String userType){
        if(userType.equals("user")||userType.equals("editor")||userType.equals("admin")) {
            this.userType = userType;
        }
    }
}

import java.io.*;
class UserData implements Serializable {
    String name;
    int id;
    UserData(String name, int id) {
        this.name = name;
        this.id = id;
    }
}
public class BackupSystem{
    public static void main(String[] args){
        UserData data = new UserData("Manish", 101);
        if (data instanceof Serializable) {
            System.out.println("Data is eligible for backup");
        } else {
            System.out.println("Data cannot be backed up");
        }
    }
}


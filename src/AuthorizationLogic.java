import java.io.*;
import java.util.Scanner;

public class AuthorizationLogic {
    private String path;
    public AuthorizationLogic(String path) {
        this.path = path;
    }
    boolean isValid(String userName, String password) {
        File db = new File(path);
        try {
            Scanner sc = new Scanner(db);
            while(sc.hasNext()) {
                String curname = sc.next();
                String pass = sc.next();

                if(curname.equals(userName) &&
                        pass.equals(PasswordEncrypter.getMd5Hash(password)))
                    return true;
                else {
                    System.out.println(curname + " " + pass + " doesn't match " + userName + " " + PasswordEncrypter.getMd5Hash(password));
                }

            }
            sc.close();
        }catch (Exception e) {

        }
        return false;
    }
    private boolean containsLogin (String login) {
        File db = new File(path);
        try {
            Scanner sc = new Scanner(db);
            while(sc.hasNext()) {
                String curname = sc.next();
                String pass = sc.next();
                if(curname.equals(login))
                    return true;

            }
            sc.close();
        }catch (Exception e) {

        }

        return false;
    }
    public void registerAnAccount(String name, String password) {
        if(containsLogin(name)) {
            System.out.println("Such login already exists");
            return;
        }
        try {
            FileWriter fw = new FileWriter(path, true);
            fw.write("\n"+name + " " + PasswordEncrypter.getMd5Hash(password));
            fw.close();
        }catch (Exception e) {}
    }

}

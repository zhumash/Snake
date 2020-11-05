public class Main {
    public static String userName = "";
    public static void main (String [] args) {
        AuthorizationGui a = new AuthorizationGui();
        while(!a.closed()){
            try {
                Thread.sleep(1);
            }catch (Exception e) {}
        }
        System.out.println(userName);
        if(!userName.equals("")) {
            SnakeGui g = new SnakeGui();
        }

    }
}

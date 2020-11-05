import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AuthorizationGui extends JFrame {
    JButton signIn  = new JButton("sign in");
    JButton register  = new JButton("register");
    JTextField userName = new JTextField("", 5);
    JTextField password = new JTextField("", 5);
    boolean isClose;
    AuthorizationLogic ac = new AuthorizationLogic("C:\\Users\\ЖАНДОС\\Desktop\\JavaCode\\Snake\\src\\resources\\db.txt");
    boolean closed (){
        return isClose;
    }
    public AuthorizationGui() {
        super("AuthorizationGui");
        setVisible(true);
        this.setBounds(400,200,500,500);
        isClose = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(ac.isValid(userName.getText(), password.getText())) {
                    Main.userName = userName.getText();
                    isClose = true;
                    dispose();
                }
            }
        });
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(password.getText().equals("") || userName.equals(""))
                    System.out.println("some field are empty");
                else{

                    ac.registerAnAccount(userName.getText(), password.getText());
                }
            }
        });
        Container container = this.getContentPane();
        container.setLayout(new GridLayout(10, 5, 2, 2));
        container.add(userName);
        container.add(password);
        container.add(signIn);
        container.add(register);

    }
}

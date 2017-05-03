package sample;

import com.melloware.jintellitype.HotkeyListener;
import com.melloware.jintellitype.JIntellitype;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Main extends Application {
    private Robot robot;
    private boolean status=false,running=false;
    static int holdSpeed=30;

    @Override
    public void start(Stage primaryStage) throws Exception{

        // JavaFX Scene Process
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("KeyCheater");
        Scene scene = new Scene(root, 150, 100);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Variable Declaration/Initialization
        robot = new Robot();

        // Set Base Hotkeys
        JIntellitype.getInstance().registerHotKey(-3, JIntellitype.MOD_CONTROL + JIntellitype.MOD_WIN, (int)'Z');   // Terminate Listener (Ctrl+Win+Z)
        JIntellitype.getInstance().registerHotKey(-1, JIntellitype.MOD_WIN + JIntellitype.MOD_ALT, (int)'Z');       // Start Listener (Win+Alt+Z)

        // Setup Listener
        JIntellitype.getInstance().addHotKeyListener(new HotkeyListener(){
            @Override
            public void onHotKey(int id) {
                if(id == -3){               // Terminate Listener
                    status = false;
                    JIntellitype.getInstance().cleanUp();
                    System.out.println("Listening Terminated");
                    System.exit(0);
                }
                else if(id == -1){          // Start Listener
                    status = true;
                    JIntellitype.getInstance().unregisterHotKey(-1);
                    JIntellitype.getInstance().registerHotKey(-2, JIntellitype.MOD_WIN + JIntellitype.MOD_ALT, (int)'Z');
                    regAll();               // Register all hotkeys
                    System.out.println("Listening Started");
                }
                else if(id == -2){          // Pause Listener
                    status = false;
                    JIntellitype.getInstance().unregisterHotKey(-2);
                    JIntellitype.getInstance().registerHotKey(-1, JIntellitype.MOD_WIN + JIntellitype.MOD_ALT, (int)'Z');
                    unregAll();             // Unregister all hotkeys
                    System.out.println("Listening Paused");
                }

                else if(status){            // Ready to execute keys
                    unregAll();             // Temporarily Unregister all hotkeys (to prevent key stacking)

                    if(id == 999){
                        running = true;
                        Thread t = new Thread(new Runnable(){       // Create Executor Thread
                            public void run() {
                                while(running) {
                                    robot.keyPress(KeyEvent.VK_A);
                                    try{
                                        Thread.sleep(holdSpeed);
                                    }
                                    catch (Exception e){ e.printStackTrace(); }
                                }
                                robot.keyRelease(KeyEvent.VK_A);
                            }
                        });
                        t.start();
                        try{
                            Thread.sleep(2000);
                        } catch(Exception e){ e.printStackTrace(); }
                        running = false;
                    }

                    regAll();
                }
            }
        });
    }

    private void regAll(){
        // Hotkeys here
        JIntellitype.getInstance().registerHotKey(999, JIntellitype.MOD_WIN + JIntellitype.MOD_ALT, (int)'S');  // Sample : Hold 'A' for 2 seconds (Win+Alt+S)
    }
    private void unregAll(){
        JIntellitype.getInstance().unregisterHotKey(999);
    }

    public static void main(String[] args) { launch(args); }
}

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
    private static int holdSpeed=30,tapSpeed=15,restSpeed=25;

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
            public void onHotKey(int id){
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
                        press(KeyEvent.VK_A,2000);
                    }

                    else if(id == 1){       // Z
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_A,tapSpeed);
                    }
                    else if(id == 2){       // X
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_S,tapSpeed);
                    }
                    else if(id == 3){       // C
                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_D,tapSpeed);
                    }
                    else if(id == 4){       // V
                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_S,tapSpeed);
                    }
                    else if(id == 5){       // B
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_D,tapSpeed);
                    }
                    else if(id == 6){       // 1
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_F,tapSpeed);
                    }
                    else if(id == 7){       // 2
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_F,tapSpeed);
                    }
                    else if(id == 8){       // 3
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_D,tapSpeed);
                    }
                    else if(id == 9){       // 4
                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_F,tapSpeed);
                    }
                    else if(id == 10){       // 5
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_F,tapSpeed);
                    }
                    else if(id == 11){       // N7
                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_D,tapSpeed);
                    }
                    else if(id == 12){       // N8
                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD1,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_F,tapSpeed);
                    }
                    else if(id == 13){       // N9
                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD2,KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_NUMPAD3,tapSpeed);

                        try{
                            Thread.sleep(restSpeed);
                        } catch(Exception e){ e.printStackTrace(); }

                        press(KeyEvent.VK_F,tapSpeed);
                    }

                    regAll();
                }
            }
        });
    }

    private void regAll(){
        // Hotkeys here (Keys = KeyEvent.VK...)
        JIntellitype.getInstance().registerHotKey(999, JIntellitype.MOD_WIN + JIntellitype.MOD_ALT, (int)'S');  // Sample : Hold 'A' for 2 seconds (Win+Alt+S)
        JIntellitype.getInstance().registerHotKey(1, 0, KeyEvent.VK_Z);
        JIntellitype.getInstance().registerHotKey(2, 0, KeyEvent.VK_X);
        JIntellitype.getInstance().registerHotKey(3, 0, KeyEvent.VK_C);
        JIntellitype.getInstance().registerHotKey(4, 0, KeyEvent.VK_V);
        JIntellitype.getInstance().registerHotKey(5, 0, KeyEvent.VK_B);
        JIntellitype.getInstance().registerHotKey(6, 0, KeyEvent.VK_1);     // Skill Bars
        JIntellitype.getInstance().registerHotKey(7, 0, KeyEvent.VK_2);
        JIntellitype.getInstance().registerHotKey(8, 0, KeyEvent.VK_3);
        JIntellitype.getInstance().registerHotKey(9, 0, KeyEvent.VK_4);
        JIntellitype.getInstance().registerHotKey(10, 0, KeyEvent.VK_5);
        JIntellitype.getInstance().registerHotKey(11, 0, KeyEvent.VK_NUMPAD7);
        JIntellitype.getInstance().registerHotKey(12, 0, KeyEvent.VK_NUMPAD8);
        JIntellitype.getInstance().registerHotKey(13, 0, KeyEvent.VK_NUMPAD9);

    }
    private void unregAll(){
        JIntellitype.getInstance().unregisterHotKey(999);
        for(int i = 1; i <= 13; i++){
            JIntellitype.getInstance().unregisterHotKey(i);
        }
    }

    private void press(int key,int t){           // Key pressing function
        running = true;
        new Thread(new Runnable(){               // Create Executor Thread
            public void run() {
                while(running) {
                    robot.keyPress(key);
                    try{
                        Thread.sleep(holdSpeed);
                    }
                    catch (Exception e){ e.printStackTrace(); }
                }
                robot.keyRelease(key);
            }
        }).start();
        try{
            Thread.sleep(t);                     // Hold for t ms
        } catch(Exception e){ e.printStackTrace(); }
        running = false;
    }

    private void press(int key,int key2,int t){           // Key pressing function (Double)
        running = true;
        new Thread(new Runnable(){               // Create Executor Thread
            public void run() {
                while(running) {
                    robot.keyPress(key);
                    robot.keyPress(key2);
                    try{
                        Thread.sleep(holdSpeed);
                    }
                    catch (Exception e){ e.printStackTrace(); }
                }
                robot.keyRelease(key);
                robot.keyRelease(key2);
            }
        }).start();
        try{
            Thread.sleep(t);                     // Hold for t ms
        } catch(Exception e){ e.printStackTrace(); }
        running = false;
    }

    public static void main(String[] args) { launch(args); }
}

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WidgetClock extends Object {
    /**
     * WidgetClockメソッド
     * HIIT機能を作成
     * 20秒⇒10秒を3セット繰り返す
     */
    public void perfome() {
       
        JFrame mainframe = new JFrame("HIIT");
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainframe.setSize(900, 500);
        mainframe.setLayout(new GridLayout(2, 1));

        JLabel datLabel = new JLabel();
        datLabel.setFont(new Font("Arial", Font.PLAIN, 28));
        datLabel.setHorizontalAlignment(JLabel.CENTER);

        mainframe.add(datLabel);

        mainframe.setVisible(true);

        Timer aTimer = new Timer();

        aTimer.scheduleAtFixedRate(new TimerTask() {
            
            int time = 20;
            int time2 = 20;
            int time3 =20;
            int rest = 10;
            int rest2 = 10;
            

            public void run() {

               if(time != -1){
                datLabel.setText("1st time Remaining Time :" + time);
                time--;
               }

                if (time < 0 && rest != -1 ) {
                    datLabel.setText("Until the end of the break :" + rest);
                    rest--;
                    

                }

             
                if(time < 0 && rest < 0 && time2 != -1 ){
                    datLabel.setText("2nd time Remaining Time :" + time2);
                    time2--;
                }

                if(time2 < 0 && rest2 != -1 ){
                    datLabel.setText("Until the end of the break :" + rest2);
                    rest2--;
                    
                }

                if(rest2 < 0 && time3 != -1){
                    datLabel.setText("Last time Remaining Time :" + time3);
                    time3--;
                }


                

                if ( time3 == -1) {
                    aTimer.cancel();
                    datLabel.setText("You did it!!");
                }


                

               
                        

            }
        }, 0, 1000);

    }
}
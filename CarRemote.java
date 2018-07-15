package e.olive.carremote;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;
import java.util.UUID;

public class CarRemote extends AppCompatActivity {

    /** Need to hardcode our bluetooth values**/
    //private final String DEVICE_ADDRESS = "20:15:11:23:93:85"; //MAC Address of Bluetooth Module
    //private final UUID PORT_UUID =  UUID.fromString("00001101-0000-1000-8000-00805f9b34fb");

    private BluetoothDevice device;
    private BluetoothSocket socket;
    private OutputStream outputStream;

    //Create these buttons on the GUI
    Button btnGo, btnLeft, btnRight, btnReverse, btnStop;

    //Create text view for output of commands on screen
    TextView textOutput;

    String command; //string variable that will store value to be transmitted to the bluetooth module

    String stopOutput =  "command = a"
            + System.getProperty ("line.separator")
            + "outputStream.write(command.getBytes())"
            + "//Command Ended//";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Replace with layout name
        setContentView(R.layout.activity_car_remote);

        //declaration of button variables
        btnGo = (Button) findViewById(R.id.btnGo);
        btnLeft = (Button) findViewById(R.id.btnLeft);
        btnRight = (Button) findViewById(R.id.btnRight);
        btnReverse = (Button) findViewById(R.id.btnReverse);
        btnStop = (Button) findViewById(R.id.btnStop);
        textOutput = (TextView) findViewById(R.id.textOutput);



        //OnTouchListener code for the go button
        btnForward.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) //MotionEvent.ACTION_DOWN is when you hold a button down
                {
                    command = "g";

                    String output =
                                    "btnForward.setOnTouchListener"
                                    + System.getProperty ("line.separator")
                                    + "command = g"
                                    + System.getProperty ("line.separator")
                                    + "outputStream.write(command.getBytes())";

                    try
                    {
                        outputStream.write(command.getBytes()); //transmits the value of command to the bluetooth module
                        textOutput.setText(output);

                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP) //MotionEvent.ACTION_UP is when you release a button
                {
                    command = "a";
                    String output =
                             "command = a"
                              + System.getProperty ("line.separator")
                              + "outputStream.write(command.getBytes())"
                              + "//Command Ended//";
                    try
                    {
                        outputStream.write(command.getBytes());
                        textOutput.setText(output);

                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }

                return false;
            }

        });

        //OnTouchListener code for the reverse button (button long press)
        btnReverse.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "b";
                    String output =
                                  "btnReverse.setOnTouchListener"
                                    + System.getProperty ("line.separator")
                                    + "command = b"
                                    + System.getProperty ("line.separator")
                                    + "outputStream.write(command.getBytes())";

                    try
                    {
                        outputStream.write(command.getBytes());
                        textOutput.setText(output);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    try
                    {
                        outputStream.write(command.getBytes());
                        textOutput.setText(stopOutput);

                    }
                    catch(IOException e)
                    {

                    }

                }
                return false;
            }
        });

        //OnTouchListener code for the forward left button (button long press)
        btnLeft.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "l";
                    String output =
                            "btnLeft.setOnTouchListener"
                                    + System.getProperty ("line.separator")
                                    + "command = l"
                                    + System.getProperty ("line.separator")
                                    + "outputStream.write(command.getBytes())";

                    try
                    {
                        outputStream.write(command.getBytes());
                        textOutput.setText(output);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "a";

                    try
                    {
                        outputStream.write(command.getBytes());
                        textOutput.setText(stopOutput);
                    }
                    catch(IOException e)
                    {

                    }

                }
                return false;
            }
        });

        //OnTouchListener code for the forward right button (button long press)
        btnRight.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                if(event.getAction() == MotionEvent.ACTION_DOWN)
                {
                    command = "r";
                    String output =
                            "btnRight.setOnTouchListener"
                                    + System.getProperty ("line.separator")
                                    + "command = r"
                                    + System.getProperty ("line.separator")
                                    + "outputStream.write(command.getBytes())";

                    try
                    {
                        outputStream.write(command.getBytes());
                        textOutput.setText(output);
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(event.getAction() == MotionEvent.ACTION_UP)
                {
                    command = "a";

                    try
                    {
                        outputStream.write(command.getBytes());
                        textOutput.setText(stopOutput);
                    }
                    catch(IOException e)
                    {
                        e.printStackTrace();
                    }

                }
                return false;
            }
        });
    }


    @Override
    protected void onStart()
    {
        super.onStart();
    }

}

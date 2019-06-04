package com.Immaculata.schoolapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //where the layout gets connected to the activity
        setContentView(R.layout.activity_main);

        //get teh contents from the design page
        final ImageView appIcon = (ImageView)findViewById(R.id.appIcon);
        final ImageView pencil1 = (ImageView)findViewById(R.id.pencil1);
        final ImageView pencil2 = (ImageView)findViewById(R.id.pencil2);

        //get the properties of the app icon
        int height = appIcon.getHeight();
        int yPos = Math.round(appIcon.getY());

        //get the properties of the first pencil
        int pencilY1 = Math.round(pencil1.getY());

        //get the properties from

        //construct the class
        label iconImage = new label(height, yPos, true, appIcon);
        pencil pencilOne = new pencil(pencilY1, -100, pencil1);
        pencilOne.movePencil();
    }

    //Classes
    //label class
    class label
    {
        //declare local variables
        int height;
        int yPos;
        boolean visible = false;
        ImageView label;
        //constructor
        //get values
        public label (int height, int yPosition, boolean visible, ImageView label)
        {
            //set values
            this.height = height;
            this.yPos = yPosition;
            this.visible = visible;
            this.label = label;
        }

    }

    class pencil
    {
        //declare local variables
        int yPos;
        int move;
        ImageView pencil;
        //constructor
        //get values
        public pencil ( int yPosition, int decreaseY,  ImageView pencil)
        {
            this.yPos = yPosition;
            this.pencil = pencil;
            this.move = decreaseY;
        }

        //this function will move the pencils
        public void movePencil()
        {
            pencil.setY(yPos);
            yPos += move;
            pencil.setY(yPos);
            System.out.println("Have been here");

            for (int counter = 0; counter == 5; counter++)
            {
                yPos += move;
                pencil.setY(yPos);
                System.out.println("Have been here");

                try {
                    Thread.sleep(1500);
                } catch(InterruptedException e) {
                    System.out.println("got interrupted!");
                }
            }
        }

    }
}

package com.example.pkx7576.demo;

import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Environment;

import com.example.pkx7576.demo.jni.StudentInput;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    private EditText inName;
    private EditText inSystem;
    private EditText incTherory;
    private EditText incExperient;
    private EditText inCollege;
    private TextView outName;
    private TextView outSystem;
    private TextView outCpp;
    private TextView outAverage;
    private TextView outCollege;
    public ImageView img;
    private Button button1;
   // private int value1;
   // private int value2;
   // private int result;

    //private ImageView img;
    //private String filepath="mnt/sdcard/pkx.jpg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inName=(EditText)findViewById(R.id.name);
        inSystem=(EditText)findViewById(R.id.system);
        incTherory=(EditText)findViewById(R.id.cpp_1);
        incExperient=(EditText)findViewById(R.id.cpp_2);
        inCollege=(EditText)findViewById(R.id.college);
        outName=(TextView)findViewById(R.id.name_out);
        outCollege=(TextView)findViewById(R.id.college_out);



        outSystem=(TextView)findViewById(R.id.system_out);
        outCpp=(TextView)findViewById(R.id.cpp_out);
        outAverage=(TextView)findViewById(R.id.average);

        boolean isSdCardExist = Environment.getExternalStorageState().equals(Environment
                .MEDIA_MOUNTED);// 判断sdcard是否存在
        if (isSdCardExist) {
           // String sdpath = Environment.getExternalStorageDirectory()
                  //  .getAbsolutePath();// 获取sdcard的根路径
           // String filepath = sdpath + File.separator + "pkx.jpg";
            //String filepath = "/mnt/sdcard/pkx.jpg";
            File file = new File("/storage/emulated/0/DCIM/Camera/IMG_20160126_103429.jpg");
            img=(ImageView)findViewById(R.id.imagine_view);
           // ImageView imageView = new ImageView(this);//创建一个imageView对象
            if (file.exists()) {
               // InputStream is = new URL( filepath ).openStream();
                Bitmap bm = BitmapFactory.decodeFile("/storage/emulated/0/DCIM/Camera/IMG_20160126_103429.jpg");
                // 将图片显示到ImageView中
                img.setImageBitmap(bm);
            }
        }
        //Log.d("MainActivity",""+StudentInput.getmScoreAverage(Integer.parseInt(incTherory.getText().toString()),Integer.parseInt(incExperient.getText().toString()),Integer.parseInt(inSystem.getText().toString()))+"");
        //Log.i("MainActivity", "onCreate: ");

              /*  img=(ImageView)findViewById(R.id.imagine_view);
        File file=new File(filepath);
        if(file.exists()){
            Bitmap bm= BitmapFactory.decodeFile(filepath);
            img.setImageBitmap(bm);
        }*/
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // value1 =Integer.parseInt(incTherory.getText().toString()) ;
               // value2 =Integer.parseInt(incExperient.getText().toString()) ;
               // result=value1+value2;
               // outCpp.setText(""+result+"");
                outName.setText(StudentInput.getStrName(inName.getText().toString()));
                outCollege.setText(StudentInput.getCollege(inCollege.getText().toString()));
                outSystem.setText(""+(StudentInput.getmScoreOS(Integer.parseInt(inSystem.getText().toString())))+"");
                outCpp.setText(""+(StudentInput.getmScoreCPPTotal(Integer.parseInt(incTherory.getText().toString()),Integer.parseInt(incExperient.getText().toString())))+"");
                outAverage.setText(""+(StudentInput.getmScoreAverage(Integer.parseInt(incTherory.getText().toString()),Integer.parseInt(incExperient.getText().toString()),Integer.parseInt(inSystem.getText().toString())))+"");
            }
        });
    }

}

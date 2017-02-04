package salim3dd.com.style;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    SharedPreferences shard ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        shard = getSharedPreferences("Setting", Context.MODE_PRIVATE);
        int myStyle = shard.getInt("myStyle",0);
        switch (myStyle){
            case 0:
                this.setTheme(R.style.AppTheme);
                break;
            case 1:
                this.setTheme(R.style.AppTheme1);
                break;
            case 2:
                this.setTheme(R.style.AppTheme2);
                break;

        }

        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyStyle(0);
            }
        });

         findViewById(R.id.btn_1).setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 MyStyle(1);
             }
         });

        findViewById(R.id.btn_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyStyle(2);
            }
        });

    }

    public void  MyStyle(int myStyle){
        SharedPreferences.Editor editor = shard.edit();
        editor.putInt("myStyle",myStyle);
        editor.apply();

        finish();
        startActivity(new Intent(this, MainActivity.class));
    }

}

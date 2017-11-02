package controlf13.enozes;

import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnVoltar = (ImageButton) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener( this.exit() );

        ImageButton btnConfig = (ImageButton) findViewById(R.id.btnConfig);
        btnConfig.setOnClickListener( this.config() );
    }

    protected OnClickListener exit() {
        OnClickListener exit = new OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Funcionalidades.vibe(50, getApplicationContext() );
                System.exit(0);
            }
        };
        return exit;
    }

    protected OnClickListener config() {
        OnClickListener config = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Funcionalidades.vibe(50, getApplicationContext() );
                Intent config = new Intent(getBaseContext(), ConfigActivity.class);
                config.putExtra( "Config", 2 );
                startActivity(config);
            }
        };
        return config;
    }

}

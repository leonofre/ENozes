package controlf13.enozes;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private OnClickListener exit = new OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
            Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(100);
            System.exit(0);
        }
    };
    private OnClickListener config = new OnClickListener() {
        @Override
        public void onClick(View view) {
            Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibe.vibrate(100);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton btnVoltar = (ImageButton) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener( this.exit );

        ImageButton btnConfig = (ImageButton) findViewById(R.id.btnConfig);
        btnConfig.setOnClickListener( this.config );

        final MediaPlayer originalSoundMP = MediaPlayer.create(this, R.raw.original);

        btnVoltar = (ImageButton) this.findViewById(R.id.btnVoltar);
        btnConfig = (ImageButton) this.findViewById(R.id.btnConfig);


        btnConfig.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
                originalSoundMP.start();
            }

        });
        btnVoltar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
                originalSoundMP.start();
            }});
    }



}

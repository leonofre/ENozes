package controlf13.enozes;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.view.View.OnClickListener;

public class ConfigActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        ImageButton btnVoltar = (ImageButton) findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener( this.back() );
    }

    protected OnClickListener back() {
        OnClickListener voltar = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);
                finish();
            }
        };
        return voltar;
    }
}

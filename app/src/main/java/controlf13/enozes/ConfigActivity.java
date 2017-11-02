package controlf13.enozes;

import android.content.Context;
import android.graphics.Color;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import java.util.HashMap;
import java.util.Map;

import controlf13.enozes.Funcionalidades;

public class ConfigActivity extends AppCompatActivity {
    static public Map<String, Boolean> config = new HashMap<String, Boolean>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        config.put( "Sound", true );
        config.put( "Music", true );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_config );

        ImageButton btnVoltar = ( ImageButton ) findViewById( R.id.btnVoltar );
        btnVoltar.setOnClickListener( this.back() );

        ImageButton soundActive = ( ImageButton ) findViewById( R.id.sound );
        ImageButton soundInactive = ( ImageButton ) findViewById( R.id.notSound );
        ImageButton musicActive = ( ImageButton ) findViewById( R.id.music );
        ImageButton musicInactive = ( ImageButton ) findViewById( R.id.notMusic );
        soundActive.setOnClickListener( this.setConfig( "Sound", soundActive, soundInactive ) );
        soundInactive.setOnClickListener( this.setConfig( "Sound", soundActive, soundInactive ) );
        musicActive.setOnClickListener( this.setConfig( "Music", musicActive, musicInactive ) );
        musicInactive.setOnClickListener( this.setConfig( "Music", musicActive, musicInactive ) );
    }

    protected OnClickListener back() {
        OnClickListener voltar = new OnClickListener() {
            @Override
            public void onClick(View view) {
                Funcionalidades.vibe(50, getApplicationContext() );
                finish();
            }
        };
        return voltar;
    }

    protected OnClickListener setConfig( final String configKey,final ImageButton btnActive, final ImageButton btnInactive ) {
        OnClickListener setConfig = new OnClickListener() {
            @Override
            public void onClick(View view) {

                if ( ConfigActivity.config.get( configKey ) ) {
                    ConfigActivity.config.put( configKey, false );
                    btnActive.setBackgroundColor(Color.parseColor("#21100B"));
                    btnActive.setImageResource(R.drawable.somiconeinativo);
                    btnInactive.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btnInactive.setImageResource(R.drawable.xiconeativo);
                    Funcionalidades.vibe(50, getApplicationContext() );
                } else {
                    ConfigActivity.config.put( configKey, true );
                    btnActive.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    btnActive.setImageResource(R.drawable.somiconeativo);
                    btnInactive.setBackgroundColor(Color.parseColor("#21100B"));
                    btnInactive.setImageResource(R.drawable.xiconeinativo);
                    Funcionalidades.vibe(50, getApplicationContext() );
                }
            }
        };
        return setConfig;
    }
}

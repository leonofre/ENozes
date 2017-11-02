package controlf13.enozes;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;


/**
 * Created by leona on 02/11/2017.
 */

public class Funcionalidades {

    /**
     * Função para chamar a classe vibrator.
     *
     * @param time Valor int em milisegundos da vibração.
     */
    static public void vibe(int time, Context context) {
        Vibrator vibe = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
        vibe.vibrate(20);
    }
}

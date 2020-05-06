package samuelmoreirasilva.app.barberhair.com.Helper;

import android.content.Context;
import android.widget.Toast;

public class Uteis {

    public static void exibirMensagemErro(Context activity, String msg){
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }
}

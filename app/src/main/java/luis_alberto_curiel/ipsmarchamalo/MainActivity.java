package luis_alberto_curiel.ipsmarchamalo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private final int numeroMesas = 18;
    private final int numeroLineas = 10;

    private Spinner mesas;
    private Spinner lineas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lineas = (Spinner)findViewById(R.id.sp_lineas);
        mesas = (Spinner)findViewById(R.id.sp_mesas);
        ArrayAdapter<Integer> adapterLineas = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_activated_1, generarLineas());
        ArrayAdapter<Integer> adapterMesas = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_activated_1, generarMesas());
        lineas.setAdapter(adapterLineas);
        mesas.setAdapter(adapterMesas);
    }

    public Integer[] generarLineas(){
        Integer[] m = new Integer[numeroLineas];

        for(int i = 0; i < m.length ; i++){
            m[i] = i + 1;
        }

        return m;
    }

    public Integer[] generarMesas(){
        Integer[] m = new Integer[numeroMesas];

        for(int i = 0; i < m.length ; i++){
            m[i] = i + 1;
        }

        return m;
    }


}

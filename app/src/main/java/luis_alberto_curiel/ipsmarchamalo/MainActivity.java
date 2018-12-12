package luis_alberto_curiel.ipsmarchamalo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private final int numeroMesas = 18;
    private final int numeroLineas = 10;

    private Spinner mesas;
    private Spinner lineas;

    private Button buscar;

    private TextView envio, price, ticket, reader, equipo;

    private ArrayList<Mesa> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        try {
            datos = LeerCSV.muestraContenido(new InputStreamReader(getAssets().open("IPS Format Impresora.csv")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        lineas = (Spinner)findViewById(R.id.sp_lineas);
        mesas = (Spinner)findViewById(R.id.sp_mesas);
        buscar = (Button)findViewById(R.id.btn_cargar);
        envio = (TextView)findViewById(R.id.tv_envio);
        price = (TextView)findViewById(R.id.tv_price);
        ticket = (TextView)findViewById(R.id.tv_ticket);
        reader = (TextView)findViewById(R.id.tv_reader);
        equipo = (TextView)findViewById(R.id.tv_equipo);
        ArrayAdapter<Integer> adapterLineas = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_activated_1, generarLineas());
        ArrayAdapter<Integer> adapterMesas = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_activated_1, generarMesas());
        lineas.setAdapter(adapterLineas);
        mesas.setAdapter(adapterMesas);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscar();
            }
        });
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

    public void buscar(){

        String x = lineas.getSelectedItem().toString();
        String y = String.format("%05d", mesas.getSelectedItem());
        Iterator<Mesa> it = datos.iterator();
        while (it.hasNext()){
            Mesa item = it.next();
            if (item.getId().equals(x + y)){
                envio.setText(item.getEnvio());
                price.setText(item.getPrecio());
                ticket.setText(item.getTicket());
                reader.setText(item.getReader());
                equipo.setText(item.getEquipo());
            }
        }
    }

}

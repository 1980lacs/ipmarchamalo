package luis_alberto_curiel.ipsmarchamalo;

import android.app.Activity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LeerCSV {

    static ArrayList<Mesa> muestraContenido(InputStreamReader archivo) throws FileNotFoundException, IOException {
        String cadena;
        //FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(archivo);
        String partes[];
        String aux;
        Mesa mesa = null;
        ArrayList<Mesa> mesas = new ArrayList<>();
        int cont = 0;
        while((cadena = b.readLine())!=null) {
            partes = cadena.split(";");
            //System.out.println(partes.length);
            if (partes.length >= 8) {
                mesa = new Mesa();
                mesa.setId(partes[0]);
                mesa.setEnvio(partes[1]);
                mesa.setPrecio(partes[2]);
                mesa.setTicket(partes[3]);
                mesa.setReader(partes[4]);
                if (partes.length == 8) mesa.setEquipo(partes[7]);
                else if (partes.length == 9) mesa.setEquipo(partes[8]);
                mesas.add(mesa);
            }
        }
        b.close();

        return mesas;
    }
}

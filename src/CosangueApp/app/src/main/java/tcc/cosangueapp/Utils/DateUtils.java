package tcc.cosangueapp.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    final static public String dateToString(Date data) {
        //"05/09/2013"
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dataFormatada = format.format(data);
        Log.i("DATA String", dataFormatada);
        return dataFormatada;
    }

    final static public String timeToString(Date data) {
        //"05/09/2013"
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        String dataFormatada = format.format(data);
        Log.i("DATA String", dataFormatada);
        return dataFormatada;
    }


    final static public Date stringToDate(String dataStr) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date dataFormatada = new Date();
        try {
            dataFormatada = format.parse(dataStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return dataFormatada;
    }

    final static public String dateTimeToString(Date data) {
        //"05/09/2013 06:30:07"
        SimpleDateFormat format = new SimpleDateFormat("dd/mm/yyyy hh:mm:ss");
        String dataFormatada = format.format(data);
        Log.i("DATA String", dataFormatada);
        return dataFormatada;
    }
}

package samuelmoreirasilva.app.barberhair.com.Helper;


import android.util.Log;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Validacoes {

    public static boolean validaData(String data){

        try {
            //SimpleDateFormat é usada para trabalhar com formatação de datas
            //neste caso meu formatador irá trabalhar com o formato "dd/MM/yyyy"
            //dd = dia, MM = mes, yyyy = ano
            //o "M" dessa String é maiusculo porque "m" minusculo se n me engano é minutos
            SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
            //a mágica desse método acontece aqui, pois o setLenient() é usado para setar
            //sua escolha sobre datas estranhas, quando eu seto para "false" estou dizendo
            //que não aceito datas falsas como 31/02/2016
            sdf.setLenient(false);
            //aqui eu tento converter a String em um objeto do tipo date, se funcionar
            //sua data é valida
            sdf.parse(data);
            //se nada deu errado retorna true (verdadeiro)
            return true;
        } catch (ParseException ex) {
            //se algum passo dentro do "try" der errado quer dizer que sua data é falsa, então,
            //retorna falso
            return false;
        }

    }

    public static int calculaIdade(String data){

        DateFormat sdf = new SimpleDateFormat("ddMMyyyy");

        Date dataNascInput = null;

        try {
            dataNascInput= sdf.parse(data);
        } catch (Exception e) {
            Log.d("Erro", "calculaIdade: erro ao validar data");
        }

        Calendar dataAniversario = new GregorianCalendar();

        dataAniversario.setTime(dataNascInput);

        // Cria um objeto calendar com a data atual
        Calendar today = Calendar.getInstance();

        // Obtém a idade baseado no ano
        int idade = today.get(Calendar.YEAR) - dataAniversario.get(Calendar.YEAR);

        return idade;
    }

    public static boolean validaCpf(String cpf){

        if  (cpf.equals("11111111111") || cpf.equals("22222222222") || cpf.equals("33333333333") || cpf.equals("44444444444") || cpf.equals("55555555555") || cpf.equals("66666666666") ||
             cpf.equals("77777777777") || cpf.equals("88888888888") || cpf.equals("99999999999") || cpf.equals("00000000000") )
            return false;

        String cpfCalc =  cpf.substring(0, 9);

        Integer primDig, segDig;

        int soma = 0, peso = 10;
        for (int i = 0; i < cpfCalc.length(); i++)
            soma += Integer.parseInt(cpfCalc.substring(i, i + 1)) * peso--;

        if (soma % 11 == 0 | soma % 11 == 1)
            primDig = new Integer(0);
        else
            primDig = new Integer(11 - (soma % 11));

        soma = 0;
        peso = 11;
        for (int i = 0; i < cpfCalc.length(); i++)
            soma += Integer.parseInt(cpfCalc.substring(i, i + 1)) * peso--;

        soma += primDig.intValue() * 2;
        if (soma % 11 == 0 | soma % 11 == 1)
            segDig = new Integer(0);
        else
            segDig = new Integer(11 - (soma % 11));

        String digitosCalc =  primDig.toString() + segDig.toString();

        if(digitosCalc.equals(cpf.substring(9, 11)))
            return true;
        else
            return false;

    }
}

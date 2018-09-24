package program3;


import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContainsDigit extends Decorator implements Predicate {
    Output streamOutput;
    boolean pass = false;
    Pattern p = Pattern.compile("(.)*[\\d]+(.)*");


    public ContainsDigit(Output streamOutput){
        this.streamOutput = streamOutput;
    }

    public boolean test(Object o){
        Matcher m = p.matcher(o.toString());
        pass = m.matches();
        if(pass){
            return true;
        }else {return false;}
    }

    @Override
    public void write(Object o) {
        pass = test(o);
        if(pass){streamOutput.write(o.toString());}
    }

}

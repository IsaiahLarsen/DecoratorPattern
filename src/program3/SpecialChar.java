package program3;

import java.io.FileOutputStream;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpecialChar extends Decorator implements Predicate{
    Output streamOutput;
    boolean pass = false;
    Pattern p = Pattern.compile("(.)*[@#\\*$%]+(.)*");

    public SpecialChar(Output streamOutput){
        this.streamOutput = streamOutput;
    }

    public void write(Object o) {
        pass = test(o);
        if(pass){
            streamOutput.write(o.toString());
        }
    }

    @Override
    public boolean test(Object o) {
        Matcher m = p.matcher(o.toString());
        pass = m.matches();
        if(pass){
            return true;
        }else return false;
    }
}

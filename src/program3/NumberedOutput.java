package program3;


public class NumberedOutput extends Decorator {
    Output streamOutput;
    private int lineNum = 1;

    public NumberedOutput(Output streamOutput){
        this.streamOutput = streamOutput;

    }

    @Override
    public void write(Object o) {
        try{
            streamOutput.write(String.format("\n\n%5d: ",lineNum) + o.toString());
        }catch (Exception e){System.out.println(e.getMessage());}
        lineNum++;
    }
}


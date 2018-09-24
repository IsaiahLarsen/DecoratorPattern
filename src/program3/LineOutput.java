package program3;

public class LineOutput extends Decorator {
    Output streamOutput;
    public LineOutput(Output streamOutput){
        this.streamOutput = streamOutput;
    }
    public void write(Object o){
        try{
            streamOutput.write(o.toString() + "\n");
        }catch (Exception e){System.out.println(e.getMessage());}
    }
}

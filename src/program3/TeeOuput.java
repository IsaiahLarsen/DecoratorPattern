package program3;

import java.io.*;

public class TeeOuput extends Decorator {
    Output streamOutput;
    File file;
    public TeeOuput(Output streamOutput, File file){
        this.streamOutput = streamOutput;
        this.file = file;
    }
    @Override
    public void write(Object o) {
        try {
            Writer writer = new FileWriter(file, true);
            writer.write(o.toString());
            writer.close();
        }catch (IOException e){e.getMessage();}

        streamOutput.write(o.toString());
    }
}

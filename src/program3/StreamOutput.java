package program3;

import java.io.*;

class StreamOutput implements Output {
    private Writer sink;
    public StreamOutput(Writer stream) {
        sink = stream;
    }


    public void write(Object o) {
        try{
            sink.write(o.toString());

        }catch(IOException e){throw new RuntimeException(e);}
    }

}
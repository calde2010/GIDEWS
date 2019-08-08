package co.gide.transferenciadian;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.activation.DataSource;
import javax.persistence.Entity;


public class InputStreamDataSource implements DataSource{

    
    private InputStream inputStream;
    
    public InputStreamDataSource(InputStream inputStream){
        this.inputStream=inputStream;
    }
    
    @Override
    public String getContentType(){
        return "*/*";
    }

    @Override
    public InputStream getInputStream() throws IOException{
        return inputStream;
    }

    @Override
    public String getName(){
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public OutputStream getOutputStream() throws IOException{
        // TODO Auto-generated method stub
        return null;
    }

}

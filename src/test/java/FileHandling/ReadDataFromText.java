package FileHandling;

import org.testng.annotations.Test;

import java.io.*;

public class ReadDataFromText {
    @Test
    public void ReadDataFromText() throws IOException {
        //make connection for the file
        File f=new File("D:\\VFC project\\SeleniumClasses\\Text.txt");
        //By using Filereader
        FileReader fr=new FileReader(f);
        //System.out.println((char)fr.read());//ascii
        int i=fr.read();
        while(i!=-1)
        {
            System.out.print((char)i);
            i= fr.read();
        }
    }

    @Test
    public void readtextusingBufferReader() throws IOException {
        //make connection for the file
        File f=new File("D:\\VFC project\\SeleniumClasses\\Text.txt");
        //By using Filereader
        FileReader fr=new FileReader(f);
        BufferedReader br=new BufferedReader(fr);
        String s= br.readLine();
        while (s!=null)
        {
            System.out.println(s);
            s= br.readLine();
        }
    }
    @Test
    public void writeDatausingFileWriter() throws IOException {
        File f=new File("D:\\VFC project\\SeleniumClasses\\Text1.txt");
        FileWriter fw=new FileWriter(f,true);
        fw.write("\nThis is new data");
        fw.flush();//save file
        fw.close();
    }
    @Test
    public void writeDatausingBufferedWriter() throws IOException {
        File f=new File("D:\\VFC project\\SeleniumClasses\\Text1.txt");
        FileWriter fw=new FileWriter(f,true);
        BufferedWriter bw=new BufferedWriter(fw);
        bw.newLine();
        bw.write("This is new data using bufferedwriter");
        bw.flush();//save file
        bw.close();
        //fw.close();
    }
}

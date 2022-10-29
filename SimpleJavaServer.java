import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleJavaServer {

    public static void main(String[] args) 	{
        try {
            ServerSocket s = new ServerSocket(3003);
            String str;
            while (true) {
                Socket c = s.accept();
                InputStream i = c.getInputStream();
                OutputStream o = c.getOutputStream();
                do {
                    byte[] line = new byte[100];
                    i.read(line);
                    str = new String(line);

                    String[] parts = str.split(" ");

                    Integer n1 = Integer.parseInt(parts[0].trim());
                    Integer n2 = Integer.parseInt(parts[2].trim());
                    Integer total = 0;

                    System.out.println(parts[1]);

                    switch (parts[1].trim()) {
                        case "+":
                            total = n1+n2;
                            break;
                        case "-":
                            total = n1-n2;
                            break;
                        case "*":
                            total = n1*n2;
                            break;
                        case "/":
                            total = n1/n2;
                            break;
                    }
                    o.write(total.toString().getBytes());
                } while ( !str.trim().equals("bye") );
                c.close();
            }
        }
        catch (Exception err){
            System.err.println(err);
        }
    }

}

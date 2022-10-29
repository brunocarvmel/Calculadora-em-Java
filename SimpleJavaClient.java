import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SimpleJavaClient {

    public static void main(String[] args) 	{
        try {
            Socket s = new Socket("127.0.0.1", 3003);
            InputStream i = s.getInputStream();
            OutputStream o = s.getOutputStream();
            String str;
            do {
                byte[] n1 = new byte[100];
                byte[] n2 = new byte[100];
                byte[] operation = new byte[100];
                byte[] scrr = new byte[100];

                System.out.println("Digite o primeiro número: ");
                System.in.read(n1);
                System.out.println("Digite o segundo número: ");
                System.in.read(n2);
                System.out.println("Digite o operador (+, -, *, /): ");
                System.in.read(operation);

                String s1 = new String(n1).trim();
                String s2 = new String(n2).trim();
                String s3 = new String(operation).trim();

                String values = s1+" "+s3+" "+s2;

                o.write(values.getBytes());
                i.read(scrr);
                str = new String(scrr);
                System.out.println("O resultado é " + str.trim());
            } while ( !str.trim().equals("bye") );
            s.close();
        }
        catch (Exception err) {
            System.err.println(err);
        }
    }

}

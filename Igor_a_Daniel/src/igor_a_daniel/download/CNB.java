/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.download;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


/**
 *
 * @author Игорь
 */
public class CNB {

    private static LocalDate date = LocalDate.now();

    private static void downloadFileCurrenciesCNB() {
       
        try {

            DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd.MM.uuuu");

            String text = date.format(formatters);
            URL website = new URL("http://www.cnb.cz/cs/financni_trhy/devizovy_trh/kurzy_devizoveho_trhu/denni_kurz.txt?date=" + text);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("CNB/kurzy.txt");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
           
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }

    public void downloadCurrencyFromCNB() throws IOException {
        downloadFileCurrenciesCNB();
        FileWriter writer;
        File file = new File("kurzy.txt");
        Scanner scan = new Scanner(file);
        File file2 = new File("CNB/kurz " + date.toString() + ".csv");
            writer = new FileWriter(file2);
            Writer fstream;
            BufferedWriter out;
            try {
                fstream = new OutputStreamWriter(new FileOutputStream(file2), "cp1250");
                out = new BufferedWriter(fstream);
                while (scan.hasNext()) {

                    String csv = scan.nextLine().replace("|", ";");
                    System.out.println(csv);
                    out.append(csv);
                    out.append("\n");
                    out.flush();
                }
            } catch (IOException e) {
                System.out.println(e);
            }

        
    }
   
}

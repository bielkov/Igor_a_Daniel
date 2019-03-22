/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package igor_a_daniel.download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author dvele
 */
public class Raiffeisen {
    private String url;
    private String fileTo;
    
    public Raiffeisen() {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date today = new Date();
        String day = format.format(today);
        this.fileTo = day;
        this.url = "https://www.rb.cz/informacni-servis/kurzovni-listek?p_p_id=CurrencyRate_WAR_CurrencyRateportlet_INSTANCE_24de2a2f&p_p_lifecycle=2&p_p_state=normal&p_p_mode=view&p_p_resource_id=downloadXml&p_p_cacheability=cacheLevelPage&p_p_col_id=_DynamicNestedPortlet_INSTANCE_026c60a5__column-1-1&p_p_col_count=1&_CurrencyRate_WAR_CurrencyRateportlet_INSTANCE_24de2a2f_date="+day;
    }
    
    public void Download() {
        try {
            URL website = new URL(this.url);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("Raiffeisen/" + this.fileTo + ".xml");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Raiffeisen r = new Raiffeisen();
        r.Download();
    }
}

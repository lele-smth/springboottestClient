package de.leonie.springboottestClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.*;

@Component
public class ZinsenClient implements CommandLineRunner {
    @Autowired
    ZinsenInterface zinsService;

    @Override
    public void run(String... args) throws Exception {
        double kapital = Double.parseDouble(args[0]);
        double zinssatz = Double.parseDouble(args[1]);
        int jahre = Integer.parseInt(args[2]);
        System.out.println("Berechne Endkapital für die Verzinsung von " + kapital +
                " über " + jahre + " Jahre mit " + zinssatz + "%");

        // mit GET-Aufruf Endkapital berechnen
        double endkapital = zinsService.berechneGet(kapital, zinssatz, jahre);
        System.out.println("Endkapital: " + endkapital);
        System.out.println();
        // mit POST-Aufruf Endkapital berechnen
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("kapital", kapital);
        params.put("zinssatz", zinssatz);
        params.put("jahre", jahre);
        endkapital = zinsService.berechnePost(params);
        System.out.println("Endkapital: " + endkapital);
        System.out.println();

    }
}

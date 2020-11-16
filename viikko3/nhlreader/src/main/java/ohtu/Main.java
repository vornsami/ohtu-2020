/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

/**
 *
 * @author mluukkai
 */

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players, new PlayerSorter());
        System.out.println("Oliot:");
        System.out.println("\tname\t   nationality\tteam\tgoals\tassists\tsum\tpenalties");
        for (Player player : players) {
            if(player.getNationality().equals("FIN")){
                System.out.println(player);
            }
        }   
    }
    
}

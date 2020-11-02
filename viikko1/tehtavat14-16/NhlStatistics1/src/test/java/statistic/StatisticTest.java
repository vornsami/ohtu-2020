/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statistic;

import java.util.ArrayList;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
/**
 *
 * @author Sami
 */
public class StatisticTest {
    private Statistics stats;
    
    @Before
    public void init(){
        stats = new Statistics(new StubReader());
    }
    
    @Test
    public void searchPlayer(){
        assertNotNull(stats.search("name1"));
    }
    @Test
    public void searchPlayerNotListed(){
        assertNull(stats.search("name4"));
    }
    @Test
    public void searchTeam(){
        assertEquals(stats.team("team1").get(0).getName(), "name1");
        assertEquals(stats.team("team1").get(1).getName(), "name2");
    }
    
    @Test
    public void searchTeamNotListed(){
        assertTrue(stats.team("team3").isEmpty());
    }
    @Test
    public void topScorers(){
        List<Player> top = stats.topScorers(2);
        assertEquals(top.get(0).getName(), "name3");
        assertEquals(top.get(1).getName(), "name2");
        assertEquals(top.get(2).getName(), "name1");
        
    }
    
    
    public class StubReader implements Reader {

    @Override
    public List<Player> getPlayers() {
        List<Player> players = new ArrayList<>();
        
        players.add(new Player("name1", "team1", 1, 1));
        players.add(new Player("name2", "team1", 2, 2));
        players.add(new Player("name3", "team2", 3, 3));
        
        return players;
    }
    
}
}

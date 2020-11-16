/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import java.util.Comparator;

/**
 *
 * @author Sami
 */
public class PlayerSorter implements Comparator{

    @Override
    public int compare(Object t, Object t1) {
        return ((Player) t1).getSum() - ((Player) t).getSum();
    }
    
}

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



class SILab2Test {
    List<Time> lista = new LinkedList<>();
    List<Integer> rez = new ArrayList<>();
    RuntimeException mess;
    @Test
    void everyBranchStatement() {

        lista.add(new Time(1,1,1));
        rez.add(3661);
        assertEquals(rez, SILab2.function(lista));

        lista.add(new Time(24,0,0));
        rez.add(86400);
        assertEquals(rez, SILab2.function(lista));

        lista.add(new Time(-7,11,17));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista));
        assertTrue(mess.getMessage().contains("The hours are smaller than the minimum"));

        List<Time> lista1 = new LinkedList<>();
        lista1.add(new Time(32,13,10));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista1));
        assertTrue(mess.getMessage().contains("The hours are greater than the maximum"));
        List<Time> lista2 = new LinkedList<>();
        lista2.add(new Time(10,-8,9));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista2));
        assertTrue(mess.getMessage().contains("The minutes are not valid!"));

    }

}




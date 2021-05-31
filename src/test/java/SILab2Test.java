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

        lista.add(new Time(1,0,1));
        rez.add(3661);
        assertEquals(rez, SILab2.function(lista));

        lista.add(new Time(25,0,0));
        rez.add(86400);
        assertEquals(rez, SILab2.function(lista));

        lista.add(new Time(-4,11,13));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista));
        assertTrue(mess.getMessage().contains("The hours are smaller than the minimum"));

        List<Time> lista1 = new LinkedList<>();
        lista1.add(new Time(27,11,13));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista1));
        assertTrue(mess.getMessage().contains("The hours are grater than the maximum"));

        List<Time> lista2 = new LinkedList<>();
        lista2.add(new Time(15,-3,10));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista2));
        assertTrue(mess.getMessage().contains("The minutes are not valid!"));

        List<Time> lista3 = new LinkedList<>();
        lista3.add(new Time(14,17,-10));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista3));
        assertTrue(mess.getMessage().contains("The seconds are not valid"));

        List<Time> lista4 = new LinkedList<>();
        List<Integer> r = new ArrayList<>();
        assertEquals(r, SILab2.function(lista4));

    }

    @Test
    void multipleCondition(){
        //if (hr < 0 || hr > 24)
        lista.add(new Time(-4,11,13));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista));
        assertTrue(mess.getMessage().contains("The hours are smaller than the minimum"));

        List<Time> lista1 = new LinkedList<>();
        lista1.add(new Time(27,11,13));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista1));
        assertTrue(mess.getMessage().contains("The hours are grater than the maximum"));

        List<Time> lista2 = new LinkedList<>();
        lista2.add(new Time(12,-19,25));
        mess = assertThrows(RuntimeException.class, () -> SILab2.function(lista2));
        assertTrue(mess.getMessage().contains("The minutes are not valid!"));

    }

}

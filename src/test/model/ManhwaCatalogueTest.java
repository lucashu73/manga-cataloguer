package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ManhwaCatalogueTest {

    private ManhwaCatalogue testManhwaCatalogue;

    @BeforeEach
    public void setup() {
        testManhwaCatalogue = new ManhwaCatalogue();
    }

    @Test
    public void testAddManhwa() {
        Manhwa manhwa1 = new Manhwa("Solo Leveling", "Dummy description.", 8);
        testManhwaCatalogue.addManhwa(manhwa1);
        assertEquals(testManhwaCatalogue.getEntryNumber("Solo Leveling"),
                testManhwaCatalogue.length());

        Manhwa manhwa2 = new Manhwa("The Beginning After the End", "Description.", 8);
        testManhwaCatalogue.addManhwa(manhwa2);
        assertEquals(testManhwaCatalogue.getEntryNumber("The Beginning After the End"),
                testManhwaCatalogue.length());
    }

    @Test
    public void testGetEntryNumber() {
        Manhwa manhwa1 = new Manhwa("A", "aaa", 3);
        Manhwa manhwa2 = new Manhwa("B", "bbb", 2);
        Manhwa manhwa3 = new Manhwa("C", "ccc", 1);

        testManhwaCatalogue.addManhwa(manhwa1);
        testManhwaCatalogue.addManhwa(manhwa2);
        testManhwaCatalogue.addManhwa(manhwa3);
        assertEquals(1, testManhwaCatalogue.getEntryNumber("A"));
        assertEquals(2, testManhwaCatalogue.getEntryNumber("B"));
        assertEquals(3, testManhwaCatalogue.getEntryNumber("C"));
        assertEquals(-1, testManhwaCatalogue.getEntryNumber("D"));
    }

    @Test
    public void testGetManhwa() {
        Manhwa manhwa1 = new Manhwa("Overgeared", "dummy", 10);

        testManhwaCatalogue.addManhwa(manhwa1);
        assertNull(testManhwaCatalogue.getManhwa("NOT OVERGEARED"));
        assertEquals(manhwa1, testManhwaCatalogue.getManhwa("Overgeared"));
    }

    @Test
    public void testGetCatalogue() {
        Manhwa manhwa1 = new Manhwa("Overgeared", "dummy", 10);
        Manhwa manhwa2 = new Manhwa("Attack On Titan", "dummy", 7);

        assertEquals("", testManhwaCatalogue.getCatalogue());
        testManhwaCatalogue.addManhwa(manhwa1);
        testManhwaCatalogue.addManhwa(manhwa2);
        assertEquals("Overgeared\nAttack On Titan\n", testManhwaCatalogue.getCatalogue());
    }

    @Test
    public void testGetDetails() {
        Manhwa manhwa1 = new Manhwa("A", "aaa", 3);
        testManhwaCatalogue.addManhwa(manhwa1);
        assertEquals("Title: A\n" +
                "Description: aaa\n" +
                "Rating: 3", testManhwaCatalogue.getDetails("A"));
        assertEquals("", testManhwaCatalogue.getDetails("B"));
    }

    @Test
    public void testLength() {
        assertEquals(0, testManhwaCatalogue.length());
        testManhwaCatalogue.addManhwa(new Manhwa("Sweet Home", "Desc.", 10));
        assertEquals(1, testManhwaCatalogue.length());
        testManhwaCatalogue.addManhwa(new Manhwa("Pigpen", "Desc.", 10));
        testManhwaCatalogue.addManhwa(new Manhwa("Shotgun Boy", "Desc.", 10));
        assertEquals(3, testManhwaCatalogue.length());
    }

}

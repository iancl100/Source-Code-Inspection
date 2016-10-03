/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.calebe.ticketmachine.test;

import br.calebe.ticketmachine.core.*;
import br.calebe.ticketmachine.exception.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gustavo
 */
public class TicketMachineTest {
    
    @Test
    public void testTicketMachineGetSaldo(){
        TicketMachine tm = new TicketMachine(3);
        tm.inserir(100.0);
        tm.inserir(50.0);
        assertEquals(tm.getSaldo()==150.0,true);
    }
    
    @Test
    public void testGetTrocoTicketMachine(){
        TicketMachine tm = new TicketMachine(3);
        tm.inserir(5.0);
        assertEquals(tm.getTroco()==2.0,true);
    }
    
    @Test
    public void testPapelMoedaSet(){
        PapelMoeda pm = new PapelMoeda(5.0,1);
        pm.setQuantidade(4);
        assertTrue(pm.getQuantidade()==5);
//        espera-se que ele aumente a quantidade em relação ao que ja havia
    }
    
    @Test
    public void testPapelMoedaGetQuantidade(){
        PapelMoeda pm = new PapelMoeda(5.0,1);
        assertTrue(pm.getQuantidade()==1);
    }
    
    @Test
    public void testPapelMoedaGetValor(){
        PapelMoeda pm = new PapelMoeda(5.0,1);
        assertTrue(pm.getValor()==5.0);
    }
    
    @Test
    public void testExceptionPapelMoedaInvalida(){
        TicketMachine tm = new TicketMachine(3);
        try{
            tm.inserir(25.0);
        }catch (Exception e){
            assertEquals(e, PapelMoedaInvalidaException.class);
        }
    }
    
    
    @Test
    public void testExceptionSaldoInsuficiente(){
        TicketMachine tm = new TicketMachine(3);
        try{
            tm.inserir(2.0);
            tm.imprimir();
        }catch (Exception e){
            assertEquals(e, SaldoInsuficienteException.class);
        }
    }
    @Test
    public void testTroco(){
        //Construtor do Troco resulta em looping infinito
    }
    @Test
    public void testInserirTicketMachine(){
        TicketMachine tm = new TicketMachine(3);
        tm.inserir(100.0);
        tm.inserir(20.0);
        assertEquals(tm.getSaldo()==120.0, true);
    }
}
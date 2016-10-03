package br.calebe.ticketmachine.core;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gustavo Dechechi
 */
public class TicketMachine {

    protected int valorTicket;
    protected double saldoMaquina;
    protected ArrayList<PapelMoeda> papeisMoeda;

    public TicketMachine(int valor) {
        System.out.println("Aguarde alguns instantes...");
        this.valorTicket = valor;
        this.saldoMaquina = 0;
        papeisMoeda = new ArrayList<>();
        papeisMoeda.add(new PapelMoeda(0.1,0));
        papeisMoeda.add(new PapelMoeda(0.25,0));
        papeisMoeda.add(new PapelMoeda(0.5,0));
        papeisMoeda.add(new PapelMoeda(1,0));
        papeisMoeda.add(new PapelMoeda(2,0));
        papeisMoeda.add(new PapelMoeda(5,0));
        papeisMoeda.add(new PapelMoeda(10,0));
        papeisMoeda.add(new PapelMoeda(20,0));
        papeisMoeda.add(new PapelMoeda(50,0));
        papeisMoeda.add(new PapelMoeda(100,0));
    }

    public void inserir(double quantia) {
        boolean achou = false;
        for (PapelMoeda papelMoeda : papeisMoeda) {
            if (papelMoeda.getValor() == quantia) {
                achou = true;
                papelMoeda.setQuantidade(1);
            }
        }
        if (achou != true) {
            try {
                throw new PapelMoedaInvalidaException("Papel moeda Invalida!!");
            } catch (PapelMoedaInvalidaException ex) {
                Logger.getLogger(TicketMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            this.saldoMaquina += quantia;
        }
    }

    public double getSaldo() {
        return this.saldoMaquina;
    }

    public double getTroco() {
        return saldoMaquina - valorTicket;
    }

    public void imprimir() {
        if (saldoMaquina < valorTicket) {           
            try {
                throw new SaldoInsuficienteException("Saldo insuficiente!");
            } catch (SaldoInsuficienteException ex) {
                Logger.getLogger(TicketMachine.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        String result = "*****************\n";
        result += "*** R$ " + saldoMaquina + ",00 ****\n";
        result += "*****************\n";
        System.out.println(result);
    }
}

package br.calebe.ticketmachine.core;

/**
 *
 * @author Gustavo Dechechi
 */
public class Troco {

    protected PapelMoeda[] papeisMoeda;

    //Comissao - Ausencia de um loop para pegar todos os casos.
    //Computacao - so ocorrem os determinados codigos em determinados casos de inserir dinheiro: 100, 50, 20, 10 , 5.
    public Troco() {
    }

    public Troco(int valor) {
        papeisMoeda = new PapelMoeda[6];
        int count = 0;
        //Desempenho - loop desnecessarios no lugar de condicoes.
        if (valor % 100 != 0) {
            count++;
        }
        papeisMoeda[5] = new PapelMoeda(100, count);
        count = 0;
        while (valor % 50 != 0) {
            count++;
        }
        papeisMoeda[4] = new PapelMoeda(50, count);
        count = 0;
        if (valor % 20 != 0) {
            count++;
        }
        papeisMoeda[3] = new PapelMoeda(20, count);
        count = 0;
        if (valor % 10 != 0) {
            count++;
        }
        papeisMoeda[2] = new PapelMoeda(10, count);
        count = 0;
        if (valor % 5 != 0) {
            count++;
        }
        papeisMoeda[1] = new PapelMoeda(5, count);
        count = 0;
        if (valor % 2 != 0) {
            count++;
        }

        papeisMoeda[0] = new PapelMoeda(2, count);
    }

    public PapelMoeda[] getPapeisMoeda() {
        return papeisMoeda;
    }

    public void setPapeisMoeda(PapelMoeda[] papeisMoeda) {
        this.papeisMoeda = papeisMoeda;
    }

    @Override
    public String toString() {
        return "Troco{" + "papeisMoeda=" + papeisMoeda + '}';
    }

}

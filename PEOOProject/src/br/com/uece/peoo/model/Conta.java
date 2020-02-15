package br.com.uece.peoo.model;

import br.com.uece.peoo.util.JSONable;
import br.com.uece.peoo.util.Question;
import org.json.simple.JSONObject;


/**
 * Classe genérica para representar uma Conta Bancária.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Conta extends JSONable {

    // Número da conta.
    protected int numConta;

    // Titular da conta.
    protected String titular;

    // Saldo da conta.
    protected double saldo;

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Método para Depositar.
     *
     * @param value valor a ser depositado.
     * @return <code>true</code> sucesso, <code>false</code> erro.
     */
    public boolean depositar(double value) {
        // Um depósito não pode ser negativo.
        if (value < 0) {
            System.err.println("Deposíto não pode ser negativo!!! Valor do Deposito: " + Question.numberFormat.format(value) + ".");
            return false;
        } else {
            this.saldo += value;
            System.out.println("Deposíto realizado. Saldo: " + Question.numberFormat.format(value));
        }
        // Mostrando a conta.
        this.showConta();
        return true;
    }

    /**
     * Método para sacar.
     *
     * @param value valor a ser sacado.
     * @return <code>true</code> sucesso, <code>false</code> erro.
     */
    public boolean sacar(double value) {
        // Saldo da conta não pode ser negativo.
        System.out.println("----------------------------------------------------------------");
        if (this.saldo < value) {
            System.err.println("Saldo na conta não pode ser negativo!");
            System.err.println("Saldo: " + Question.numberFormat.format(this.saldo) + ".");
            System.err.println("Saque: " + Question.numberFormat.format(value));
            return false;
        } else {
            System.out.println("Saque realizado. Valor: " + Question.numberFormat.format(value));
            this.saldo -= value;
        }
        System.out.println("----------------------------------------------------------------");
        // Mostrando a conta.
        this.showConta();
        return true;
    }

    /**
     * Construtor genérico.
     */
    public Conta() {
        this(-1, "", 0);
    }

    /**
     * @param numConta número da conta.
     * @param titular     titular da conta.
     * @param balance    saldo da conta.
     */
    public Conta(int numConta, String titular) {
        this(numConta, titular, 0);
    }

    /**
     * @param numConta número da conta.
     * @param titular     titular da conta.
     * @param saldo    saldo da conta.
     */
    public Conta(int numConta, String titular, double saldo) {
        setNumConta(numConta);
        setSaldo(saldo);
        setTitular(titular);
    }

    /**
     * Imprime um resumo da {@link Conta}.
     */
    public void showConta() {
        System.out.println("--------------------- Sua Conta --------------------------------");
        System.out.println(this);
        System.out.println("----------------------------------------------------------------");
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numConta=" + numConta +
                ", titular='" + titular + '\'' +
                ", saldo=" + Question.numberFormat.format(this.saldo) +
                "}";
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        object.put("numConta", this.numConta);
        object.put("titular", this.titular);
        object.put("saldo", Question.numberFormat.format(this.saldo));
        return object;
    }

}

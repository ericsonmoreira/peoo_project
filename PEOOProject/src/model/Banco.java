package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import util.JSONable;

import java.util.ArrayList;

/**
 * Classe que Representa um Banco.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Banco extends JSONable {

    // Nome do Banco
    private String nome;

    // Lista de Contas no banco.
    private ArrayList<Conta> contas;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    private void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    /**
     * Adiciona uma {@link Conta} às contas do Banco.
     *
     * @param conta {@link Conta} a ser adicionada.
     */
    public void addConta(Conta conta) {
        this.contas.add(conta);
    }

    /**
     * Remover uma {@link Conta} das contas do Banco.
     *
     * @param numConta número da conta a ser removida.
     * @return <code>true</code> caso a conta exista, <code>false</code> caso contrário.
     */
    public boolean removerConta(int numConta) {
        Conta account = buscarConta(numConta);
        if (account != null) {
            this.contas.remove(account);
        } else {
            return false;
        }
        return true;
    }

    public Banco(String nome) {
        setNome(nome);
        setContas(new ArrayList<Conta>());
    }


    /**
     * Construtor que recebeum {@link JSONObject}
     *
     * @param jsonObject
     */
    @SuppressWarnings("unchecked")
    public Banco(JSONObject jsonObject) {
        this((String) jsonObject.get("name"));
        this.setContas((ArrayList<Conta>) jsonObject.get("accounts"));
    }

    /**
     * Verifica se existe uma {@link Conta} no Banco.
     *
     * @param numConta Número da conta.
     * @return uma instância de {@link Conta} caso ela faça parte das contas do Banco. Caso contrário, <code>null</code>.
     */
    public Conta buscarConta(int numConta) {
        for (Conta conta : this.contas) {
            if (conta.getNumConta() == numConta) {
                return conta;
            }
        }
        return null;
    }

    /**
     * Transfere um valor de uma conta para outra.
     * Caso a contra devedora não tenha dinheiro suficiente, a transf. não poderá ser realizada
     *
     * @param devedor   {@link Conta} de onde sai o dinheiro.
     * @param credor {@link Conta} para onde vai o dinheiro.
     * @param valor    Valor a ser transferido.
     * @return <code>true</code> caso seja possível transferir.
     */
    public boolean transferir(Conta devedor, Conta credor, double valor) {
        if (devedor.getSaldo() >= valor) {
            devedor.setSaldo(devedor.getSaldo() - valor);
            credor.setSaldo(credor.getSaldo() + valor);
            // Transferência deu certo.
            return true;
        }
        // Transferência não deu certo.
        return false;
    }

    @Override
    public String toString() {
        return "Banco{" +
                "nome='" + nome + '\'' +
                ", contas=" + contas +
                "}";
    }

    /**
     * Usando JSON.
     *
     * @return Um {@link JSONObject} - uma representação do objeto em JSON.
     */
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray contas = new JSONArray();
        this.contas.forEach(a -> contas.add(a.toJSONObject()));
        object.put("name", this.nome);
        object.put("contas", contas);
        return object;
    }

}

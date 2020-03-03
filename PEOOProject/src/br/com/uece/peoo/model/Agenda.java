package br.com.uece.peoo.model;

import br.com.uece.peoo.util.JSONable;
import br.com.uece.peoo.util.TipoContato;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe para representar uma Agenda.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Agenda extends JSONable {

    // Lista de pessoas (Contatos)
    private ArrayList<Contato> contatos;

    // Lista de mensagens.
    private ArrayList<Mensagem> mensagens;

    // Não acho interessante esse método ser público.
    protected ArrayList<Contato> getContatos() {
        return contatos;
    }

    // Não acho interessante esse método ser público.
    protected void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }

    // Não acho interessante esse método ser público.
    private void setMensagens(ArrayList<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    /**
     * Construtor padão.
     */
    public Agenda() {
        setContatos(new ArrayList<Contato>());
        setMensagens(new ArrayList<Mensagem>());
    }

    /**
     * Adiciona uma pessoa pelo nome e teledone dela.
     *
     * @param name Nome da pessoa.
     * @param fone Telefone da pessoa.
     */
    public void addContato(Contato contato) {
        this.contatos.add(contato);
    }

    /**
     * Adiciona uma pessoa pelo nome e teledone dela.
     *
     * @param name Nome do contato.
     * @param fone Telefone do contato.
     * @param setor Setor do contato.
     */
    public void addContatoTrabalho(String name, String fone, String setor) {
        this.addContato(new ContatoTrabalho(name, fone, setor));
    }

    /**
     * Adiciona uma pessoa pelo nome e teledone dela.
     *
     * @param name Nome do contato.
     * @param fone Telefone do contato.
     * @param idade Idade do contato.
     */
    public void addContatoInfancia(String name, String fone, int idade) {
        this.addContato(new ContatoInfancia(name, fone, idade));
    }

    /**
     * Get dos contatos que sao contatos de trabalho.
     *
     * @return
     */
    public List<Contato> getContatosTrabalho(){
        return contatos.stream().filter(contato -> contato instanceof ContatoTrabalho).collect(Collectors.toList());
    }

    /**
     * Get dos contatos que sao contatos de infancia.
     *
     * @return
     */
    public List<Contato> getContatosInfancia(){
        return contatos.stream().filter(contato -> contato instanceof ContatoInfancia).collect(Collectors.toList());
    }

    /**
     * Método para procurar pessoa pelo nome.
     *
     * @param name Nome do contato.
     * @return {@link Contato} ou <code>null</code>, caso não encontre.
     */
    public Contato procuraContatoPeloNome(String name) {
        for (Contato contato : contatos) {
            if (contato.getNome() == name) {
                return contato;
            }
        }
        return null;
    }

    /**
     * Procurar pela pessoa pelo telefone.
     *
     * @param name Nome da pessoa.
     * @return {@link Contato} ou <code>null</code>.
     */
    public Contato procuraContatoPorTelefone(String telefone) {
        for (Contato contato : contatos) {
            if (contato.getTelefone() == telefone) {
                return contato;
            }
        }
        return null;
    }

    /**
     * Muda o telefone de uma pessoa da lista de pessoas.
     *
     * @param name    Nome da pessoa.
     * @param newFone Novo telefone da pessoa.
     * @return <code>true</code> caso consiga, <code>false</code> caso contrário.
     */
    public boolean mudaTelefoneDoContato(String nome, String telefoneNovo) {
        Contato contato = this.procuraContatoPeloNome(nome);
        if (contato != null) {
            contato.setTelefone(telefoneNovo);
            return true;
        }
        return false;
    }

    /**
     * Remove uma pessoa da lista de pessoas procurando pelo nome.
     *
     * @param name Nome da pessoa.
     * @return <code>true</code> caso consiga, <code>false</code> caso contrário.
     */
    public boolean removerContato(String nome) {
        Contato contato = this.procuraContatoPeloNome(nome);
        if (contato != null) {
            this.contatos.remove(contato);
            return true;
        }
        return false;
    }

    /**
     * Método para mostrar todas {@link ContatoTrabalho}.
     */
    public void showTodosContatos() {
        this.contatos.forEach(System.out::println);
    }

    /**
     * Método para mostrar todas {@link ContatoTrabalho}.
     */
    public void showTodosContatosTrabalho() {
        this.contatos.stream().filter(contato -> contato instanceof ContatoTrabalho).forEach(System.out::println);
    }

    /**
     * Método para mostrar todas {@link ContatoInfancia}.
     */
    public void showTodosContatosInfancia() {
        this.contatos.stream().filter(contato -> contato instanceof ContatoInfancia).forEach(System.out::println);
    }

    /**
     * Imprime todos os {@link ContatoTrabalho} pelo setor.
     *
     * @param setor Setor de Trabalho.
     */
    public void showContatosPorSetorDeTrabalho(String setor){
        this.getContatosTrabalho().stream().
                filter(ct -> ((ContatoTrabalho) ct).getSetor().equals(setor)).forEach(System.out::println);
    }

    /**
     * @param tipoContato
     */
    public void showContatosPorTipo(TipoContato tipoContato) {
        switch (tipoContato){
            case INFANCIA:
                showTodosContatosInfancia();
                break;
            case TRABALHO:
                showTodosContatosTrabalho();
                break;
            case TODOS:
                showTodosContatosTrabalho();
                showTodosContatosInfancia();
                break;
            default:
                System.out.println("ERRO");
        }
    }

    /**
     * Enviar uma Mensagem recebendo o número do contato e a mensagem a ser enviada, e realiza o envio.
     * Realizar o envio aqui será adicionar a mensagem na lista de mensagens.
     *
     * @param telefoneContato Telefone do Contato.
     * @param textoMensagem Texto da Mensagem.
     * @return <code>true</code> caso consiga mandar a mensagem, <code>false</code> caso contrário.
     */
    public boolean enviaMessage(String telefoneContato, String textoMensagem) {
        Contato contact = this.procuraContatoPorTelefone(telefoneContato);
        if (contact != null) {
            Mensagem mensagem = new Mensagem(contact, textoMensagem);
            this.mensagens.add(mensagem);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Agenda{" +
                "contatos=" + contatos +
                ", contatosTrabalho=" + getContatosTrabalho() +
                ", contatosInfancia=" + getContatosInfancia() +
                ", mensagens=" + mensagens +
                "}";
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray contatos = new JSONArray();
        JSONArray contatosTrabalho = new JSONArray();
        JSONArray contatosInfancia = new JSONArray();
        JSONArray messages = new JSONArray();
        this.contatos.forEach(p -> contatos.add(p.toJSONObject()));
        this.mensagens.forEach(m -> messages.add(m.toJSONObject()));

        object.put("contatos", contatos);
        object.put("contatosTrabalho", contatosTrabalho);
        object.put("contatosInfancia", contatosInfancia);
        object.put("messages", messages);
        return object;
    }

}

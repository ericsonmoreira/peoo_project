package model;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import util.JSONable;
import util.TipoContato;

import java.util.ArrayList;

/**
 * Classe para representar uma Agenda.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Agenda extends JSONable {

    // Lista de pessoas (Contatos)
    private ArrayList<Contato> contatos;

    // Lista de pessoas (Contatos)
    private ArrayList<ContatoTrabalho> contatosTrabalho;

    // Lista de pessoas (Contatos)
    private ArrayList<ContatoInfancia> contatosInfancia;

    // Lista de mensagens.
    private ArrayList<Message> messages;

    // Não acho interessante esse método ser público.
    protected ArrayList<Contato> getContatos() {
        return contatos;
    }

    // Não acho interessante esse método ser público.
    protected void setContatos(ArrayList<Contato> contatos) {
        this.contatos = contatos;
    }

    public ArrayList<Message> getMessages() {
        return messages;
    }

    // Não acho interessante esse método ser público.
    private void setMessages(ArrayList<Message> messages) {
        this.messages = messages;
    }

    public ArrayList<ContatoTrabalho> getContatosTrabalho() {
        return contatosTrabalho;
    }

    public void setContatosTrabalho(ArrayList<ContatoTrabalho> contatosTrabalho) {
        this.contatosTrabalho = contatosTrabalho;
    }

    public ArrayList<ContatoInfancia> getContatosInfancia() {
        return contatosInfancia;
    }

    public void setContatosInfancia(ArrayList<ContatoInfancia> contatosInfancia) {
        this.contatosInfancia = contatosInfancia;
    }

    /**
     * Construtor padão.
     */
    public Agenda() {
        setContatos(new ArrayList<Contato>());
        setMessages(new ArrayList<Message>());
        setContatosTrabalho(new ArrayList<ContatoTrabalho>());
        setContatosInfancia(new ArrayList<ContatoInfancia>());
    }

    /**
     * Adiciona uma {@link Contato} na lista de Pessoas.
     *
     * @param contato
     */
    public void addContato(Contato contato) {
        this.contatos.add(contato);
    }

    public  void addContatoTrabalho(ContatoTrabalho contatoTrabalho){
        this.contatosTrabalho.add(contatoTrabalho);
    }

    public  void addContatoInfancia(ContatoInfancia contatoInfancia){
        this.contatosInfancia.add(contatoInfancia);
    }

    /**
     * Adiciona uma pessoa pelo nome e teledone dela.
     *
     * @param name Nome da pessoa.
     * @param fone Telefone da pessoa.
     */
    public void addContato(String name, String fone) {
        this.addContato(new Contato(name, fone));
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
     * Método para procurar pessoa pelo nome.
     *
     * @param name Nome do contato.
     * @return {@link Contato} ou <code>null</code>.
     */
    public Contato procuraContatoPeloNome(String name) {
        for (Contato contato : contatos) {
            if (contato.getName() == name) {
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
    public Contato findContatoPorFone(String fone) {
        for (Contato contato : contatos) {
            if (contato.getFone() == fone) {
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
    public boolean changeFonePessoa(String name, String newFone) {
        Contato contato = this.procuraContatoPeloNome(name);
        if (contato != null) {
            contato.setFone(newFone);
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
    public boolean removeContato(String name) {
        Contato contato = this.procuraContatoPeloNome(name);
        if (contato != null) {
            this.contatos.remove(contato);
            return true;
        }
        return false;
    }

    /**
     * Método para mostrar todas {@link Contato}.
     */
    public void showTodosContatosGeral() {
        for (var contato : contatos) {
            System.out.println(contato);
        }
    }

    /**
     * Método para mostrar todas {@link ContatoTrabalho}.
     */
    public void showTodosContatosTrabalho() {
        for (var contato : contatosTrabalho) {
            System.out.println(contato);
        }
    }

    /**
     * Método para mostrar todas {@link ContatoInfancia}.
     */
    public void showTodosContatosInfancia() {
        for (var contato : contatosInfancia) {
            System.out.println(contato);
        }
    }

    public void showContatosPorTipo(TipoContato tipoContato) {
        switch (tipoContato){
            case GERAL:
                showTodosContatosGeral();
                break;
            case INFANCIA:
                showTodosContatosInfancia();
                break;
            case TRABALHO:
                showTodosContatosTrabalho();
                break;
            case TODOS:
                showTodosContatosGeral();
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
     * @param foneContact Telefone do Contato.
     * @param textMessage Texto da Mensagem.
     * @return <code>true</code> caso consiga mandar a mensagem, <code>false</code> caso contrário.
     */
    public boolean sendMessage(String foneContact, String textMessage) {
        Contato contact = this.findContatoPorFone(foneContact);
        if (contact != null) {
            Message message = new Message(contact, textMessage);
            this.messages.add(message);
            return true;
        }
        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray pessoas = new JSONArray();
        JSONArray messages = new JSONArray();

        this.contatos.forEach(p -> pessoas.add(p.toJSONObject()));
        this.messages.forEach(m -> messages.add(m.toJSONObject()));

        object.put("pessoas", pessoas);
        object.put("pessoas", messages);
        return object;
    }

}

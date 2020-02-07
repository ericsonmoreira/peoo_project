package model;

import lesson_07.questions.Question_01;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import util.JSONable;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Classe usada na questão {@link Question_01}
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public class Pais extends JSONable {

    // Come do país.
    private String nome;

    // Capital do país
    private String capital;

    // Dimensão do país em km quadrados
    private double dimencao;

    // Conjunto de paises vizinhos
    private HashSet<Pais> paisesVizinhos = new HashSet<Pais>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public double getDimencao() {
        return dimencao;
    }

    public void setDimencao(double dimencao) {
        this.dimencao = dimencao;
    }

    public HashSet<Pais> getPaisesVizinhos() {
        return paisesVizinhos;
    }

    public void addBorderCountrie(Pais pais) throws IllegalArgumentException {
        if (this.nome.equals(pais.nome)) {
            throw new IllegalArgumentException("IllegalArgumentException: Conflito entre paises.");
        }
        this.paisesVizinhos.add(pais);
    }

    /**
     * @param paisesVizinhos
     */
    public void setPaisesVizinhos(HashSet<Pais> paisesVizinhos) {
        paisesVizinhos.forEach(bc -> this.addBorderCountrie(bc));
    }

    public Pais(String nome, String capital, double dimencao) {
        setNome(nome);
        setCapital(capital);
        setDimencao(dimencao);
        setPaisesVizinhos(new HashSet<Pais>());
    }

    public boolean equals(Pais outro) {
        if (this.nome != outro.nome || this.capital != outro.capital || this.dimencao != outro.dimencao)
            return false;
        if (!(this.paisesVizinhos.containsAll(outro.paisesVizinhos) && outro.paisesVizinhos.containsAll(this.paisesVizinhos)))
            return false;
        return true;
    }

    /**
     * @return {@link HashMap} [key -> nome do país] X [value -> capital do país].
     */
    public HashMap<String, String> getCountryNameForCapital() {
        HashMap<String, String> map = new HashMap<String, String>();
        this.paisesVizinhos.forEach(pais -> map.put(pais.nome, pais.capital));
        return map;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "nome='" + nome + '\'' +
                ", capital='" + capital + '\'' +
                ", dimencao=" + dimencao +
                ", paisesVizinhos=" + paisesVizinhos +
                "}";
    }

    @Override
    @SuppressWarnings("unchecked")
    protected JSONObject toJSONObject() {
        JSONObject object = new JSONObject();
        JSONArray paisesVizinhosJsonArray = new JSONArray();

        this.paisesVizinhos.forEach(bc -> paisesVizinhosJsonArray.add(bc.toJSONObject()));

        object.put("nome", this.nome);
        object.put("capital", this.capital);
        object.put("dimencao", this.dimencao);
        object.put("paizesVizinhos", paisesVizinhosJsonArray);

        return object;
    }

}
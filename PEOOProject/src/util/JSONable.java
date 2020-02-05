package util;

import org.json.simple.JSONObject;

/**
 * Classe para abistratir qualquer objeto que possa ser manipulado no formato JSON.
 *
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 */
public abstract class JSONable {

    /**
     * Método para gerar uma String no padrão JSON.
     *
     * @return {@link String} no padrão JSON.
     */
    public String toStringJSON() {
        return this.toJSONObject().toJSONString();
    }

    /**
     * Método abistrato para gerar um objeto JSON.
     *
     * @return {@link String} no padrão JSON.
     */
    protected abstract JSONObject toJSONObject();

}

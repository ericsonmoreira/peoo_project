package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.JSONable;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * Classe que representa uma Mensagem.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Mensagem extends JSONable {

	private Contato contato; // Contato

	private String textoMensagem; // Texto da Mensagem

	private LocalDate data; // Calendar e Date estão desatualizados.

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getTextoMensagem() {
		return textoMensagem;
	}

	public void setTextoMensagem(String textoMensagem) {
		this.textoMensagem = textoMensagem;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	/**
	 * Construtor da class Mensagem. Uma mesangem tem um contato, texto da mensagem e a data em que
	 * a mensagem foi enviada (gerada na data de criação).
	 * 
	 * @param contact Contato.
	 * @param textoMensagem Texto da Mensagem.
	 */
	public Mensagem(Contato contato, String textoMensagem) {
		this.setContato(contato);
		this.setTextoMensagem(textoMensagem);
		this.setData(LocalDate.now()); // passa a data atual.
	}
	
	/**
	 * Construtor que recebeum {@link JSONObject}
	 * 
	 * @param jsonObject 
	 */
	public Mensagem(JSONObject jsonObject) {
		this((Contato) jsonObject.get("contato"), (String) jsonObject.get("textMessage"));
		this.setData((LocalDate) jsonObject.get("date"));
	}
	
	/**
	 * Construtor que recebe uma {@link String} no padão JSON.
	 * 
	 * @param jsonString
	 */
	public Mensagem(String jsonString) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(jsonString);
			this.setContato((Contato) object.get("contato"));
			this.setTextoMensagem((String) object.get("textoMensagem"));
			this.setData((LocalDate) object.get("data"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		var dateFormat = new SimpleDateFormat("dd/MM/yy");
		return "Mensagem{" +
				"contato=" + contato +
				", textoMensagem='" + textoMensagem + '\'' +
				", data=" + dateFormat.format(this.data) +
				"}";
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("contato", this.contato);
		object.put("textoMensagem", this.textoMensagem);
		object.put("data", this.data);
		return object;
	}

}

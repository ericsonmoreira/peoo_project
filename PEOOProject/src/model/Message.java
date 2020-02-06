package model;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import util.JSONable;

import java.util.Calendar;

/**
 * Classe que representa uma Mensagem.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Message extends JSONable {


	// Contato
	private Contato contato;

	// Texto da Mensagem
	private String textMessage;

	/*
	 *  Data de envio.
	 *  ToDO: Talvez mudar aqui para a classe Timestamp
	 *  Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
	 */
	private Calendar date;

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getTextMessage() {
		return textMessage;
	}

	public void setTextMessage(String textMessage) {
		this.textMessage = textMessage;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	/**
	 * Construtor da class Mensagem. Uma mesangem tem um contato, texto da mensagem e a data em que
	 * a mensagem foi enviada (gerada na data de criação).
	 * 
	 * @param contact Contato.
	 * @param textMessage Texto da Mensagem.
	 */
	public Message(Contato contato, String textMessage) {
		this.setContato(contato);
		this.setTextMessage(textMessage);
		this.setDate(Calendar.getInstance()); // passa a data atual.
	}
	
	/**
	 * Construtor que recebeum {@link JSONObject}
	 * 
	 * @param jsonObject 
	 */
	public Message(JSONObject jsonObject) {
		this(
				(Contato) jsonObject.get("contato"),
				(String) jsonObject.get("textMessage"));
		this.setDate((Calendar) jsonObject.get("date"));
	}
	
	/**
	 * Construtor que recebe uma {@link String} no padão JSON.
	 * 
	 * @param jsonString
	 */
	public Message(String jsonString) {
		JSONParser parser = new JSONParser();
		try {
			JSONObject object = (JSONObject) parser.parse(jsonString);
			this.setContato((Contato) object.get("contato"));
			this.setTextMessage((String) object.get("textMessage"));
			this.setDate((Calendar) object.get("date"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	
	@Override
	public String toString() {
		return "[Contato: " + this.contato + ", texto: " + this.textMessage +
				", data: " + this.date.get(Calendar.DAY_OF_MONTH) + "/"+ this.date.get(Calendar.MONTH) +
				"/" + this.date.get(Calendar.YEAR)+ "]";
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public JSONObject toJSONObject() {
		JSONObject object = new JSONObject();
		object.put("contact", this.contato);
		object.put("accounts", this.textMessage);
		object.put("date", this.date);
		return object;
	}
	
}

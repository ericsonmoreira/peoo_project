package util;

import java.util.Calendar;

/**
 * Classe que representa uma Mensagem.
 * 
 * @author Ericson R. Moreira {@link ericson.moreira@aluno.uece.br }
 *
 */
public class Message {
	
	private Pessoa contact;
	
	private String textMessage;
	
	private Calendar date;
	
	public Pessoa getContact() {
		return contact;
	}

	public void setContact(Pessoa contact) {
		this.contact = contact;
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
	public Message(Pessoa contact, String textMessage) {
		this.setContact(contact);
		this.setTextMessage(textMessage);
		this.setDate(Calendar.getInstance()); // passa a data atual.
	}
	
	@Override
	public String toString() {
		return "[Contato: " + this.contact + ", texto: " + this.textMessage + 
				", data: " + this.date.get(Calendar.DAY_OF_MONTH) + "/"+ this.date.get(Calendar.MONTH) +
				"/" + this.date.get(Calendar.YEAR)+ "]";
	}
	
}

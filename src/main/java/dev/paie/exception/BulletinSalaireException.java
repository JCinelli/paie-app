package dev.paie.exception;

import java.util.List;

public class BulletinSalaireException extends RuntimeException {

//	FIELDS
	private List<String> messagesErreurs;

//	CONSTRUCTOR
	public BulletinSalaireException(List<String> messagesErreurs) {
		this.messagesErreurs = messagesErreurs;
	}

//	METHODS
	public List<String> getMessagesErreurs() {
		return messagesErreurs;
	}

}

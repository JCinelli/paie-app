package dev.paie.exception;

import java.util.List;

public class RemunerationEmployeException extends RuntimeException {

//	FIELDS
	private List<String> messagesErreurs;

//	CONSTRUCTOR
	public RemunerationEmployeException(List<String> messagesErreurs) {
		this.messagesErreurs = messagesErreurs;
	}

//	METHODS
	public List<String> getMessagesErreurs() {
		return messagesErreurs;
	}

}

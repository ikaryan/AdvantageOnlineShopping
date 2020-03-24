package com.advantageonlineshopping.qa.automation.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class TheReplyMessage implements Question<String> {

	private Target message;

	public TheReplyMessage(Target message) {

		this.message = message;
	}

	@Override
	public String answeredBy(Actor actor) {

		return message
				.resolveFor(actor)
				.getText()
				.trim();
	}

	public static Question<? extends String> is(Target message) {

		return new TheReplyMessage(message);
	}
}

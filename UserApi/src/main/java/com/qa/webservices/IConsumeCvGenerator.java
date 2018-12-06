package com.qa.webservices;

import org.bson.types.Binary;

import com.qa.persistence.domain.CV;

public interface IConsumeCvGenerator {

	public CV createCV(Binary cv);

}

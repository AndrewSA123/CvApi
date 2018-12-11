package com.qa.webservice;

import java.io.IOException;

import com.qa.persistence.domain.CV;

public interface IConsumeUsers {
	
	public CV createCv(CV cv)throws IOException;

}

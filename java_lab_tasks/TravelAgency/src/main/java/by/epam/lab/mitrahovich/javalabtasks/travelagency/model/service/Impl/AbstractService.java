package by.epam.lab.mitrahovich.javalabtasks.travelagency.model.service.Impl;

import java.security.Provider.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractService {
	protected static Logger log;

	static {

		log = LoggerFactory.getLogger(Service.class);
	}
}

/*
 * Copyright 2014 Cisco Systems, Inc.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
 * 
 */
package com.cisco.oss.foundation.logging.converters;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.pattern.LoggingEventPatternConverter;
import org.apache.log4j.spi.LoggingEvent;

/**
 * @author Yair Ogen
 * 
 */
public final class FoundationLoggingCompVersionPatternConverter extends LoggingEventPatternConverter {
	
	private static String componentVersion = getComponentVersion();

	/**
	 * Private constructor.
	 * 
	 */
	private FoundationLoggingCompVersionPatternConverter() {
		super("compVersion", "compVersion");

	}

	/**
	 * Gets an instance of the class.
	 * 
	 * @param options
	 *            pattern options, may be null. If first element is "short",
	 *            only the first line of the throwable will be formatted.
	 * @return instance of class.
	 */
	public static FoundationLoggingCompVersionPatternConverter newInstance(final String[] options) {
		return new FoundationLoggingCompVersionPatternConverter();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void format(final LoggingEvent event, final StringBuffer toAppendTo) {
			toAppendTo.append(componentVersion);
	}

	/**
	 * This converter obviously handles throwables.
	 * 
	 * @return true.
	 */
	@Override
	public boolean handlesThrowable() {
		return false;
	}
	
	private static String getComponentVersion() {
		String compVersion = System.getenv("_ARTIFACT_VERSION");
		
		if(StringUtils.isBlank(compVersion)){
			compVersion = "UNKNOWN";
		}
		
		return compVersion;
	}
}

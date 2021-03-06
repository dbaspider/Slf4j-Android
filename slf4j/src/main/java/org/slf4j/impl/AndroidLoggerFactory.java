/*
 * Created 21.10.2009
 *
 * Copyright (c) 2009 SLF4J.ORG
 *
 * All rights reserved.
 *
 * Permission is hereby granted, free  of charge, to any person obtaining
 * a  copy  of this  software  and  associated  documentation files  (the
 * "Software"), to  deal in  the Software without  restriction, including
 * without limitation  the rights to  use, copy, modify,  merge, publish,
 * distribute,  sublicense, and/or sell  copies of  the Software,  and to
 * permit persons to whom the Software  is furnished to do so, subject to
 * the following conditions:
 *
 * The  above  copyright  notice  and  this permission  notice  shall  be
 * included in all copies or substantial portions of the Software.
 *
 * THE  SOFTWARE IS  PROVIDED  "AS  IS", WITHOUT  WARRANTY  OF ANY  KIND,
 * EXPRESS OR  IMPLIED, INCLUDING  BUT NOT LIMITED  TO THE  WARRANTIES OF
 * MERCHANTABILITY,    FITNESS    FOR    A   PARTICULAR    PURPOSE    AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE,  ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.slf4j.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.ILoggerFactory;

/**
 * An implementation of {@link ILoggerFactory} which always returns
 * {@link AndroidLogger} instances.
 *
 * @author Thorsten M&ouml;ler
 * @version $Rev:$; $Author:$; $Date:$
 */
public class AndroidLoggerFactory implements ILoggerFactory
{
	private final Map<String, AndroidLogger> loggerMap;

	public AndroidLoggerFactory()
	{
		loggerMap = new HashMap<String, AndroidLogger>();
	}

	/* @see org.slf4j.ILoggerFactory#getLogger(java.lang.String) */
	public AndroidLogger getLogger(final String name)
	{
		AndroidLogger slogger = null;
		// protect against concurrent access of the loggerMap
		synchronized (this)
		{
			slogger = loggerMap.get(name);
			if (slogger == null)
			{
				slogger = new AndroidLogger(name);
				loggerMap.put(name, slogger);
			}
		}
		return slogger;
	}
}

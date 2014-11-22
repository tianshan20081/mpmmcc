package com.aoeng.mp.xmlparser;

import javax.xml.parsers.SAXParser;

import org.xml.sax.Parser;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;

import com.aoeng.mp.bean.MpTextInfo;

public class MpTextInfoParser extends SAXParser {

	@Override
	public Parser getParser() throws SAXException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getProperty(String arg0) throws SAXNotRecognizedException, SAXNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public XMLReader getXMLReader() throws SAXException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isNamespaceAware() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isValidating() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setProperty(String arg0, Object arg1) throws SAXNotRecognizedException, SAXNotSupportedException {
		// TODO Auto-generated method stub

	}

	public static MpTextInfo parser() {
		// TODO Auto-generated method stub
		return null;
	}

}

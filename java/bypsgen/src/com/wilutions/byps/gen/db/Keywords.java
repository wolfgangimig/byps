package com.wilutions.byps.gen.db;

import java.util.HashSet;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;

public class Keywords {
	
	
	public static boolean checkIdentifier(Log log, String errorContext, String ident) {
		boolean ret = false;
		if (javaKeywords.contains(ident)) {
			log.error(errorContext + ": found Java keyword \"" + ident + "\"");
		}
		else if (csharpKeywords.contains(ident)) {
			log.error(errorContext + ": found C# keyword \"" + ident + "\"");
		}
		else {
			ret = true;
		}
		return ret;
	}

	private final static String JAVA_KEYWORDS = ""
			+ "abstract	continue	for	new	switch "
			+ "assert	default	goto	package	synchronized "
			+ "boolean	do	if	private	this "
			+ "break	double	implements	protected	throw "
			+ "byte	else	import	public	throws "
			+ "case	enum	instanceof	return	transient "
			+ "catch	extends	int	short	try "
			+ "char	final	interface	static	void "
			+ "class	finally	long	strictfp	volatile "
			+ "const	float	native	super	while ";

	private final static String CSHARP_KEYWORDS = ""
			+ "abstract	event	new	struct "
			+ "as	explicit	null	switch " + "base	extern	object	this "
			+ "bool	false	operator	throw " + "break	finally	out	true "
			+ "byte	fixed	override	try " + "case	float	params	typeof "
			+ "catch	for	private	uint " + "char	foreach	protected	ulong "
			+ "checked	goto	public	unchecked " + "class	if	readonly	unsafe "
			+ "const	implicit	ref	ushort " + "continue	in	return	using "
			+ "decimal	int	sbyte	virtual "
			+ "default	interface	sealed	volatile "
			+ "delegate	internal	short	void " + "do	is	sizeof	while "
			+ "double	lock	stackalloc " + "else	long	static "
			+ "enum	namespace	string ";

	public final static HashSet<String> javaKeywords = makeKeywords(JAVA_KEYWORDS);
	public final static HashSet<String> csharpKeywords = makeKeywords(CSHARP_KEYWORDS);

	private static HashSet<String> makeKeywords(String slist) {
		HashSet<String> set = new HashSet<String>();
		StringTokenizer stok = new StringTokenizer(slist, "\t ");
		while (stok.hasMoreTokens()) {
			String tok = stok.nextToken().trim();
			if (tok.length() == 0) continue;
			set.add(tok);
		}
		return set;
	}
}

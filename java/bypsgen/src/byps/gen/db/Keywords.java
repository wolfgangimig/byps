package byps.gen.db;
/* USE THIS FILE ACCORDING TO THE COPYRIGHT RULES IN LICENSE.TXT WHICH IS PART OF THE SOURCE CODE PACKAGE */
import java.util.HashSet;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;

public class Keywords {
	
	
	public static boolean checkIdentifier(Log log, String errorContext, String ident) {
		boolean ret = false;
		if (javaKeywords.contains(ident)) {
			log.error(errorContext + ": found Java keyword \"" + ident + "\"");
		}
//		C# keywords are escapted by @
//		else if (csharpKeywords.contains(ident)) { 
//		log.error(errorContext + ": found C# keyword \"" + ident + "\"");
//	}
		else if (cppKeywords.contains(ident)) {
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
			+ "enum	namespace	string params";
	
	private final static String CPP_KEYWORDS = ""
			+ "alignas	alignof	and	and_eq	asm	auto "
			+ "bitand	bitor	bool	break	case	catch "
			+ "char	char16_t 	char32_t 	class	compl "
			+ "const	constexpr 	const_cast	continue	decltype  "
			+ "default	delete	do	double	dynamic_cast	else "
			+ "enum	explicit	export	extern	false	float	for "
			+ "friend	goto	if	inline	int	long	mutable "
			+ "namespace	new	noexcept not	not_eq	nullptr  "
			+ "operator	or	or_eq	private	protected	public "
			+ "register	reinterpret_cast	return	short "
			+ "signed	sizeof	static	static_assert 	static_cast "
			+ "struct	switch	template	this	thread_local  "
			+ "throw	true	try	typedef	typeid	typename "
			+ "union	unsigned	using	virtual	void	volatile "
			+ "wchar_t	while	xor	xor_eq			 "
			+ "override final";

	public final static HashSet<String> javaKeywords = makeKeywords(JAVA_KEYWORDS);
	public final static HashSet<String> csharpKeywords = makeKeywords(CSHARP_KEYWORDS);
	public final static HashSet<String> cppKeywords = makeKeywords(CPP_KEYWORDS);

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

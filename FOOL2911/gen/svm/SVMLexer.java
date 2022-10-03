// Generated from G:/OneDrive - Alma Mater Studiorum UniversitÓ di Bologna/LCMC/Lab/Workspace/labs-fool-compiler/FOOL2911/src/svm\SVM.g4 by ANTLR 4.10.1
package svm;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SVMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.10.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		PUSH=1, POP=2, ADD=3, SUB=4, MULT=5, DIV=6, STOREW=7, LOADW=8, BRANCH=9, 
		BRANCHEQ=10, BRANCHLESSEQ=11, JS=12, LOADRA=13, STORERA=14, LOADTM=15, 
		STORETM=16, LOADFP=17, STOREFP=18, COPYFP=19, LOADHP=20, STOREHP=21, PRINT=22, 
		HALT=23, COL=24, LABEL=25, INTEGER=26, WHITESP=27, ERR=28;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", "BRANCH", 
			"BRANCHEQ", "BRANCHLESSEQ", "JS", "LOADRA", "STORERA", "LOADTM", "STORETM", 
			"LOADFP", "STOREFP", "COPYFP", "LOADHP", "STOREHP", "PRINT", "HALT", 
			"COL", "LABEL", "INTEGER", "WHITESP", "ERR"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'push'", "'pop'", "'add'", "'sub'", "'mult'", "'div'", "'sw'", 
			"'lw'", "'b'", "'beq'", "'bleq'", "'js'", "'lra'", "'sra'", "'ltm'", 
			"'stm'", "'lfp'", "'sfp'", "'cfp'", "'lhp'", "'shp'", "'print'", "'halt'", 
			"':'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "PUSH", "POP", "ADD", "SUB", "MULT", "DIV", "STOREW", "LOADW", 
			"BRANCH", "BRANCHEQ", "BRANCHLESSEQ", "JS", "LOADRA", "STORERA", "LOADTM", 
			"STORETM", "LOADFP", "STOREFP", "COPYFP", "LOADHP", "STOREHP", "PRINT", 
			"HALT", "COL", "LABEL", "INTEGER", "WHITESP", "ERR"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public int lexicalErrors=0;


	public SVMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "SVM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 27:
			ERR_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			 System.out.println("Invalid char: "+getText()+" at line "+getLine()); lexicalErrors++; 
			break;
		}
	}

	public static final String _serializedATN =
		"\u0004\u0000\u001c\u00b8\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002"+
		"\u0001\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002"+
		"\u0004\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002"+
		"\u0007\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002"+
		"\u000b\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e"+
		"\u0002\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011"+
		"\u0002\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014"+
		"\u0002\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017"+
		"\u0002\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a"+
		"\u0002\u001b\u0007\u001b\u0001\u0000\u0001\u0000\u0001\u0000\u0001\u0000"+
		"\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0001\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006"+
		"\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001"+
		"\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001\n\u0001"+
		"\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\r"+
		"\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"+
		"\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"+
		"\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"+
		"\u0001\u0017\u0001\u0018\u0001\u0018\u0005\u0018\u009b\b\u0018\n\u0018"+
		"\f\u0018\u009e\t\u0018\u0001\u0019\u0001\u0019\u0003\u0019\u00a2\b\u0019"+
		"\u0001\u0019\u0001\u0019\u0005\u0019\u00a6\b\u0019\n\u0019\f\u0019\u00a9"+
		"\t\u0019\u0003\u0019\u00ab\b\u0019\u0001\u001a\u0004\u001a\u00ae\b\u001a"+
		"\u000b\u001a\f\u001a\u00af\u0001\u001a\u0001\u001a\u0001\u001b\u0001\u001b"+
		"\u0001\u001b\u0001\u001b\u0001\u001b\u0000\u0000\u001c\u0001\u0001\u0003"+
		"\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f\b\u0011"+
		"\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010"+
		"!\u0011#\u0012%\u0013\'\u0014)\u0015+\u0016-\u0017/\u00181\u00193\u001a"+
		"5\u001b7\u001c\u0001\u0000\u0003\u0002\u0000AZaz\u0003\u000009AZaz\u0003"+
		"\u0000\t\n\r\r  \u00bc\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003"+
		"\u0001\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007"+
		"\u0001\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001"+
		"\u0000\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000"+
		"\u0000\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000"+
		"\u0000\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000"+
		"\u0000\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000"+
		"\u0000\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000"+
		"\u0000\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000"+
		"\u0000%\u0001\u0000\u0000\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000"+
		")\u0001\u0000\u0000\u0000\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001"+
		"\u0000\u0000\u0000\u0000/\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000"+
		"\u0000\u00003\u0001\u0000\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u0000"+
		"7\u0001\u0000\u0000\u0000\u00019\u0001\u0000\u0000\u0000\u0003>\u0001"+
		"\u0000\u0000\u0000\u0005B\u0001\u0000\u0000\u0000\u0007F\u0001\u0000\u0000"+
		"\u0000\tJ\u0001\u0000\u0000\u0000\u000bO\u0001\u0000\u0000\u0000\rS\u0001"+
		"\u0000\u0000\u0000\u000fV\u0001\u0000\u0000\u0000\u0011Y\u0001\u0000\u0000"+
		"\u0000\u0013[\u0001\u0000\u0000\u0000\u0015_\u0001\u0000\u0000\u0000\u0017"+
		"d\u0001\u0000\u0000\u0000\u0019g\u0001\u0000\u0000\u0000\u001bk\u0001"+
		"\u0000\u0000\u0000\u001do\u0001\u0000\u0000\u0000\u001fs\u0001\u0000\u0000"+
		"\u0000!w\u0001\u0000\u0000\u0000#{\u0001\u0000\u0000\u0000%\u007f\u0001"+
		"\u0000\u0000\u0000\'\u0083\u0001\u0000\u0000\u0000)\u0087\u0001\u0000"+
		"\u0000\u0000+\u008b\u0001\u0000\u0000\u0000-\u0091\u0001\u0000\u0000\u0000"+
		"/\u0096\u0001\u0000\u0000\u00001\u0098\u0001\u0000\u0000\u00003\u00aa"+
		"\u0001\u0000\u0000\u00005\u00ad\u0001\u0000\u0000\u00007\u00b3\u0001\u0000"+
		"\u0000\u00009:\u0005p\u0000\u0000:;\u0005u\u0000\u0000;<\u0005s\u0000"+
		"\u0000<=\u0005h\u0000\u0000=\u0002\u0001\u0000\u0000\u0000>?\u0005p\u0000"+
		"\u0000?@\u0005o\u0000\u0000@A\u0005p\u0000\u0000A\u0004\u0001\u0000\u0000"+
		"\u0000BC\u0005a\u0000\u0000CD\u0005d\u0000\u0000DE\u0005d\u0000\u0000"+
		"E\u0006\u0001\u0000\u0000\u0000FG\u0005s\u0000\u0000GH\u0005u\u0000\u0000"+
		"HI\u0005b\u0000\u0000I\b\u0001\u0000\u0000\u0000JK\u0005m\u0000\u0000"+
		"KL\u0005u\u0000\u0000LM\u0005l\u0000\u0000MN\u0005t\u0000\u0000N\n\u0001"+
		"\u0000\u0000\u0000OP\u0005d\u0000\u0000PQ\u0005i\u0000\u0000QR\u0005v"+
		"\u0000\u0000R\f\u0001\u0000\u0000\u0000ST\u0005s\u0000\u0000TU\u0005w"+
		"\u0000\u0000U\u000e\u0001\u0000\u0000\u0000VW\u0005l\u0000\u0000WX\u0005"+
		"w\u0000\u0000X\u0010\u0001\u0000\u0000\u0000YZ\u0005b\u0000\u0000Z\u0012"+
		"\u0001\u0000\u0000\u0000[\\\u0005b\u0000\u0000\\]\u0005e\u0000\u0000]"+
		"^\u0005q\u0000\u0000^\u0014\u0001\u0000\u0000\u0000_`\u0005b\u0000\u0000"+
		"`a\u0005l\u0000\u0000ab\u0005e\u0000\u0000bc\u0005q\u0000\u0000c\u0016"+
		"\u0001\u0000\u0000\u0000de\u0005j\u0000\u0000ef\u0005s\u0000\u0000f\u0018"+
		"\u0001\u0000\u0000\u0000gh\u0005l\u0000\u0000hi\u0005r\u0000\u0000ij\u0005"+
		"a\u0000\u0000j\u001a\u0001\u0000\u0000\u0000kl\u0005s\u0000\u0000lm\u0005"+
		"r\u0000\u0000mn\u0005a\u0000\u0000n\u001c\u0001\u0000\u0000\u0000op\u0005"+
		"l\u0000\u0000pq\u0005t\u0000\u0000qr\u0005m\u0000\u0000r\u001e\u0001\u0000"+
		"\u0000\u0000st\u0005s\u0000\u0000tu\u0005t\u0000\u0000uv\u0005m\u0000"+
		"\u0000v \u0001\u0000\u0000\u0000wx\u0005l\u0000\u0000xy\u0005f\u0000\u0000"+
		"yz\u0005p\u0000\u0000z\"\u0001\u0000\u0000\u0000{|\u0005s\u0000\u0000"+
		"|}\u0005f\u0000\u0000}~\u0005p\u0000\u0000~$\u0001\u0000\u0000\u0000\u007f"+
		"\u0080\u0005c\u0000\u0000\u0080\u0081\u0005f\u0000\u0000\u0081\u0082\u0005"+
		"p\u0000\u0000\u0082&\u0001\u0000\u0000\u0000\u0083\u0084\u0005l\u0000"+
		"\u0000\u0084\u0085\u0005h\u0000\u0000\u0085\u0086\u0005p\u0000\u0000\u0086"+
		"(\u0001\u0000\u0000\u0000\u0087\u0088\u0005s\u0000\u0000\u0088\u0089\u0005"+
		"h\u0000\u0000\u0089\u008a\u0005p\u0000\u0000\u008a*\u0001\u0000\u0000"+
		"\u0000\u008b\u008c\u0005p\u0000\u0000\u008c\u008d\u0005r\u0000\u0000\u008d"+
		"\u008e\u0005i\u0000\u0000\u008e\u008f\u0005n\u0000\u0000\u008f\u0090\u0005"+
		"t\u0000\u0000\u0090,\u0001\u0000\u0000\u0000\u0091\u0092\u0005h\u0000"+
		"\u0000\u0092\u0093\u0005a\u0000\u0000\u0093\u0094\u0005l\u0000\u0000\u0094"+
		"\u0095\u0005t\u0000\u0000\u0095.\u0001\u0000\u0000\u0000\u0096\u0097\u0005"+
		":\u0000\u0000\u00970\u0001\u0000\u0000\u0000\u0098\u009c\u0007\u0000\u0000"+
		"\u0000\u0099\u009b\u0007\u0001\u0000\u0000\u009a\u0099\u0001\u0000\u0000"+
		"\u0000\u009b\u009e\u0001\u0000\u0000\u0000\u009c\u009a\u0001\u0000\u0000"+
		"\u0000\u009c\u009d\u0001\u0000\u0000\u0000\u009d2\u0001\u0000\u0000\u0000"+
		"\u009e\u009c\u0001\u0000\u0000\u0000\u009f\u00ab\u00050\u0000\u0000\u00a0"+
		"\u00a2\u0005-\u0000\u0000\u00a1\u00a0\u0001\u0000\u0000\u0000\u00a1\u00a2"+
		"\u0001\u0000\u0000\u0000\u00a2\u00a3\u0001\u0000\u0000\u0000\u00a3\u00a7"+
		"\u000219\u0000\u00a4\u00a6\u000209\u0000\u00a5\u00a4\u0001\u0000\u0000"+
		"\u0000\u00a6\u00a9\u0001\u0000\u0000\u0000\u00a7\u00a5\u0001\u0000\u0000"+
		"\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8\u00ab\u0001\u0000\u0000"+
		"\u0000\u00a9\u00a7\u0001\u0000\u0000\u0000\u00aa\u009f\u0001\u0000\u0000"+
		"\u0000\u00aa\u00a1\u0001\u0000\u0000\u0000\u00ab4\u0001\u0000\u0000\u0000"+
		"\u00ac\u00ae\u0007\u0002\u0000\u0000\u00ad\u00ac\u0001\u0000\u0000\u0000"+
		"\u00ae\u00af\u0001\u0000\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000"+
		"\u00af\u00b0\u0001\u0000\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000"+
		"\u00b1\u00b2\u0006\u001a\u0000\u0000\u00b26\u0001\u0000\u0000\u0000\u00b3"+
		"\u00b4\t\u0000\u0000\u0000\u00b4\u00b5\u0006\u001b\u0001\u0000\u00b5\u00b6"+
		"\u0001\u0000\u0000\u0000\u00b6\u00b7\u0006\u001b\u0000\u0000\u00b78\u0001"+
		"\u0000\u0000\u0000\u0006\u0000\u009c\u00a1\u00a7\u00aa\u00af\u0002\u0000"+
		"\u0001\u0000\u0001\u001b\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}
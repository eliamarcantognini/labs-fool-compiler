// Generated from G:/OneDrive - Alma Mater Studiorum Universit� di Bologna/LCMC/Lab/Workspace/IntellJ/FOOL2510exp/src/main/java\SimpleExp.g4 by ANTLR 4.10.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SimpleExpParser}.
 */
public interface SimpleExpListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SimpleExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SimpleExpParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SimpleExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SimpleExpParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expProd2}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpProd2(SimpleExpParser.ExpProd2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expProd2}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpProd2(SimpleExpParser.ExpProd2Context ctx);
	/**
	 * Enter a parse tree produced by the {@code expProd3}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpProd3(SimpleExpParser.ExpProd3Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expProd3}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpProd3(SimpleExpParser.ExpProd3Context ctx);
	/**
	 * Enter a parse tree produced by the {@code expProd1}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpProd1(SimpleExpParser.ExpProd1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expProd1}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpProd1(SimpleExpParser.ExpProd1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code expProd4}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExpProd4(SimpleExpParser.ExpProd4Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expProd4}
	 * labeled alternative in {@link SimpleExpParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExpProd4(SimpleExpParser.ExpProd4Context ctx);
}
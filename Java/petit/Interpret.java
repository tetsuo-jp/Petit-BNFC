package petit;
import java_cup.runtime.*;
import petit.*;
import petit.Absyn.*;
import java.io.*;

public class Interpret {
    public static void main(String args[]) throws Exception {
	Yylex l  = new Yylex(System.in);
	parser p = new parser(l) ;
	petit.Absyn.Program parse_tree = p.pProgram() ;
	System.out.println(Interpreter.interpret(parse_tree)) ;
    }
}

JAVAC = javac
JAVAC_FLAGS = -sourcepath .

JAVA = java
JAVA_FLAGS =

CUP = java_cup.Main
CUPFLAGS = -nopositions -expect 100

JLEX = JLex.Main

all: test

test: absyn petit/Yylex.class petit/PrettyPrinter.class petit/Test.class petit/ComposVisitor.class petit/AbstractVisitor.class petit/FoldVisitor.class petit/AllVisitor.class petit/parser.class petit/sym.class petit/Test.class

.PHONY: absyn

%.class: %.java
	${JAVAC} ${JAVAC_FLAGS} $^

absyn: petit/Absyn/Program.java petit/Absyn/PDefs.java petit/Absyn/ListStm.java petit/Absyn/Stm.java petit/Absyn/SAss.java petit/Absyn/SFor.java petit/Absyn/Exp.java petit/Absyn/EZer.java petit/Absyn/ESuc.java petit/Absyn/EVar.java
	${JAVAC} ${JAVAC_FLAGS} $^

petit/Yylex.java: petit/Yylex
#	${JAVA} ${JAVA_FLAGS} ${JLEX} petit/Yylex
	jlex petit/Yylex

petit/sym.java petit/parser.java: petit/petit.cup
	${JAVA} ${JAVA_FLAGS} ${CUP} ${CUPFLAGS} petit/petit.cup
	mv sym.java parser.java petit/

petit/Yylex.class: petit/Yylex.java petit/sym.java

petit/sym.class: petit/sym.java

petit/parser.class: petit/parser.java petit/sym.java

petit/PrettyPrinter.class: petit/PrettyPrinter.java

clean:
	rm -f petit/Absyn/*.class petit/*.class
	rm -f .dvi petit.aux petit.log petit.ps  *.class

distclean: vclean

vclean:
	 rm -f petit/Absyn/Program.java petit/Absyn/PDefs.java petit/Absyn/ListStm.java petit/Absyn/Stm.java petit/Absyn/SAss.java petit/Absyn/SFor.java petit/Absyn/Exp.java petit/Absyn/EZer.java petit/Absyn/ESuc.java petit/Absyn/EVar.java petit/Absyn/Program.class petit/Absyn/PDefs.class petit/Absyn/ListStm.class petit/Absyn/Stm.class petit/Absyn/SAss.class petit/Absyn/SFor.class petit/Absyn/Exp.class petit/Absyn/EZer.class petit/Absyn/ESuc.class petit/Absyn/EVar.class
	 rm -f petit/Absyn/*.class
	 rm -f petit.tex petit.dvi petit.aux petit.log petit.ps
	 rm -f petit/Yylex petit/petit.cup petit/Yylex.java petit/VisitSkel.java petit/ComposVisitor.java petit/AbstractVisitor.java petit/FoldVisitor.java petit/AllVisitor.java petit/PrettyPrinter.java petit/Skeleton.java petit/Test.java petit/sym.java petit/parser.java petit/*.class
	rmdir petit/Absyn/
	# rmdir -p petit/

Java/petit/Interpret.class:
	cd Java; bnfc -java ../petit.cf;\
	make petit/Yylex.java petit/parser.java; \
	rm -f petit.tex; \
	(cd petit; rm -f ComposVisitor.java FoldVisitor.java PrettyPrinter.java VisitSkel.java);\
	LC_ALL=en javac petit/Interpret.java

Java_test: Java/petit/Interpret.class
	cd Java; cat ../examples/sum.p | java petit/Interpret

Haskell/Petit:
	cd Haskell; bnfc ../Petit.cf;\
	happy -gca ParPetit.y; alex -g LexPetit.x; ghc --make Petit

Haskell_test: Haskell/Petit
	cd Haskell; cat ../examples/sum.p | ./Petit

distclean:
	(cd Haskell; make distclean; rm -f Petit);
	(cd Java; make distclean);

clean:
	cd Haskell; make clean

veryclean: clean
	cd Haskell; rm -f Calc

.PHONY: Java clean

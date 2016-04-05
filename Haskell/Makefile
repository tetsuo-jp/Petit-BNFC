all:
	happy -gca ParPetit.y
	alex -g LexPetit.x
	ghc --make TestPetit.hs -o TestPetit

doc: DocPetit.pdf

DocPetit.pdf: DocPetit.tex
	pdflatex DocPetit.tex

clean:
	-rm -f *.log *.aux *.hi *.o *.dvi
	-rm -f DocPetit.ps

distclean: clean
	-rm -f DocPetit.* LexPetit.* ParPetit.* LayoutPetit.* SkelPetit.* PrintPetit.* TestPetit.* AbsPetit.* TestPetit ErrM.* SharedString.* ComposOpPetit.* Petit.dtd XMLPetit.*

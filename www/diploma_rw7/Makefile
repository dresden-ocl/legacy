
.PHONY:	all txt tex html dvi ps pdf

all:	html dvi ps pdf
		rm -f ocl-java.lyx~ zwischenbericht.lyx~ verteidigung.lyx~

txt:	ocl-java.txt
tex:	ocl-java.tex zwischenbericht.tex verteidigung.tex
html:	ocl-java.html
dvi:	ocl-java.dvi zwischenbericht.dvi verteidigung.dvi legal.dvi
ps:	ocl-java.ps legal.ps
pdf:	ocl-java.pdf

DOCEPS=\
        JavaParser.eps \
        PersonCompany.eps \
        WrapperLoop1.eps \
        WrapperLoop2.eps \
        WrapperLoop3.eps \
	observingInvariants.eps \
	observingMethods.eps \
	PersonCompany.eps

# running trice because labels may have changed
%.dvi:	%.tex $(DOCEPS)
		latex --interaction errorstopmode $<
		latex --interaction errorstopmode $<
		latex --interaction errorstopmode $<

%.ps:	%.dvi $(DOCEPS)
		dvips -q -o $@ $<

%.pdf:	%.ps
		ps2pdf $< $@

%.html:	%.tex $(DOCEPS) makehtml
		./makehtml $< $@
		
%.txt:	%.lyx
		echo $@ "is older than" $<

%.tex:	%.lyx
		echo $@ "is older than" $<

%.eps:	%.argo
		echo $@ "is older than" $<


.PHONY:	all txt tex html dvi ps pdf

all:	html dvi ps pdf
		rm -f ocl-java.lyx~ zwischenbericht.lyx~

txt:	ocl-java.txt
tex:	ocl-java.tex zwischenbericht.lyx
html:	ocl-java.html
dvi:	ocl-java.dvi zwischenbericht.dvi
ps:	ocl-java.ps
pdf:	ocl-java.pdf


# running twice because labels may have changed
%.dvi:	%.tex
		latex --interaction errorstopmode $<
		latex --interaction errorstopmode $<

%.ps:	%.dvi
		dvips -q -o $@ $<

%.pdf:	%.ps
		ps2pdf $< $@

%.html:	%.tex makehtml
		./makehtml $< $@
		
%.txt:	%.lyx
		echo $@ "is older than" $<

%.tex:	%.lyx
		echo $@ "is older than" $<


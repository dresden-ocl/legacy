
.PHONY:	all txt tex html dvi ps pdf

all:	html dvi
		rm -f ocl-java.lyx~

txt:	ocl-java.txt
tex:	ocl-java.tex
html:	ocl-java.html
dvi:	ocl-java.dvi
ps:	ocl-java.ps.gz
pdf:	ocl-java.pdf.gz


# running twice because labels may have changed
%.dvi:	%.tex
		latex --interaction errorstopmode $<
		latex --interaction errorstopmode $<


%.ps:	%.dvi
		dvips -q -o $@ $<

%.pdf:	%.ps
		ps2pdf $< $@

%.gz:	%
		gzip --best < $< > $@

%.bz2:	%
		bzip2 < $< > $@

%.html:	%.tex makehtml
		./makehtml $< $@
		
%.txt:	%.lyx
		echo $@ "is older than" $<

%.tex:	%.lyx
		echo $@ "is older than" $<


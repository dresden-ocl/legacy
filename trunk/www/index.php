<?php
/* Home page of the Webseite of the Dresden OCL2 Toolkit
 * Uses the sourceforge rss feed to print the latest news.
 *
 * Written by Claas Wilke in 2007
 * Contact: s8723446@mail.inf.tu-dresden.de.
 */

/* Include an external library for fetching the rss feed */
require_once("magpierss/rss_fetch.inc");

function print_feed() {
/* The path of the RSS feed */
$rss_path = "http://sourceforge.net/export/rss2_projnews.php?group_id=5840&rss_fulltext=1";

$rss = fetch_rss( $rss_path );

foreach ($rss->items as $item) {
//$pubdate = parse_w3cdtf($item['dc']['pubdate']);

$pubdate = $item['pubdate'];
$parseddate = getdate(strtotime($pubdate));
$title = $item['title'];
$description = $item['description'];
echo "<h3>$parseddate[year]/$parseddate[mon]/$parseddate[mday] - $title</h3>\n";
echo "<p>$description</p>\n";
}
}

?>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Dresden OCL Toolkit - Welcome Page</title>
<link rel="stylesheet" type="text/css" href="ocltoolkit.css" />

<?php include "_header.ssi"; ?>

</head>
<body>
<h1>Home</h1>

<?php include "_menu.html"; ?>

<h2>Welcome</h2>
<p><img src="images/OCLToolkit_Logo_mittel.gif"
	alt="Logo of the Dresden OCL Toolkit"
	style="border: 0px none; margin: 5px 10px; width: 247px; height: 93px; float: right;" />
Welcome on the project pages of the Dresden OCL Toolkit. If you just
came to see what the toolkit is about or want to know who stands behind
it, start with learning <a href="aboutproject.html">about the project</a>.</p>

<p>For the newest source code or information on how to get in touch with
the developers please go to <a
	href="http://sourceforge.net/projects/dresden-ocl/">our project page on
SourceForge</a>.</p>

<h2>News <a
	href="http://sourceforge.net/export/rss2_projnews.php?group_id=5840"
	class="rss"> RSS <img src="images/rss.gif" border="0"
	alt="Logo RSS-Feed" /> </a></h2>

<h3>2008/06/19 - Release of Dresden Toolkit for Eclipse released</h3>

<p>The team of the Dresden OCL Toolkit project is happy to announce the
release of the Dresden Toolkit for Eclipse supporting OCL 2.0.
The new version is available from the project download area at
Sourceforge: <a
	href="http://sourceforge.net/project/showfiles.php?group_id=5840&package_id=173625">http://sourceforge.net/project/showfiles.php?group_id=5840&package_id=173625</a></p>

<p>The new Version of the Dresden OCL2 Toolkit is based on a new
infrastructure, the so-called pivot model as exchange format for models
and metamodels developed by Matthias Br&auml;uer. The aim of this new
pivotal metamodel is to provide an abstraction to evaluate OCL queries
over instances of arbitrary domain-specific languages (including MOF and
UML). Furthermore, we support multiple repositories such as EMF besides
the currently used repository Netbeans MDR. The implementation of the
pivot model is based on the Eclipse Modeling Framework (EMF).</p>

<p>The new toolkit also contains an OCL2 Parser developed by Nils Thieme
and an OCL2 Interpreter developed by Ronny Brandt. Because of the new
infrastructure the new release does not contain all the other tools
provided in the Release 1.2 of the Dresden OCL2 Toolkit.</p>

<p>We are happy to announce this release and look forward to your
comments and feedback. You can find further information at our website
at <a href="http://dresden-ocl.sourceforge.net">http://dresden-ocl.sourceforge.net</a>
and <a href="http://www.sourceforge.net/projects/dresden-ocl">http://www.sourceforge.net/projects/dresden-ocl</a>.</p>


<h3>2007/10/01 - Dresden OCL2 Toolkit switches from CVS to SVN</h3>

<p>After thoughtful consideration the developers of the Dresden OCL2
Toolkit have decided to switch the repository management system of the
Dresden OCL2 Toolkit from Current Version System (CVS) to Subversion
(SVN).</p>

<p>The source code will be still available via CVS but will not be
updated anymore. We strongly recommend to use SVN access instead. For
more details about SVN and how to download the Dresden OCL2 Toolkit <a
	href="download.html">visit the download section</a>.</p>

<h3>2007/5/30 - New infrastructure for the Dresden OCL2 Toolkit</h3>

<p>With the publication of Matthias Br&auml;uer's Gro&szlig;er Beleg <i>"Design
and Prototypical Implementation of a Pivot Model as Exchange Format for
Models and Metamodels in a QVT/OCL Development Environment"</i> a new
milestone in the development of the Dresden OCL2 Toolkit was reached.</p>

<p>Matthias Br&auml;uer developed a new infrastructure for the toolkit
based on a so-called pivot model as exchange format for models and
metamodels.<br />
The aim of this new pivotal metamodel is to provide an abstraction to
evaluate OCL queries over instances of arbitrary domain-specific
languages (including MOF and UML). Furthermore, we support multiple
repositories such as EMF besides the currently used repository Netbeans
MDR. As a first milestone Matthias Br&auml;uer used in his
implementation of the pivot model the Eclipse Modeling Framework (EMF)
as its technological basis.</p>

<p>More details about the thesis are available on <a
	href="gbbraeuer/index.html" target="e">this Website</a>.</p>

<p>At present Ronny Brandt is working on an OCL2 interpreter based on
the new pivot model implementation. He already implemented the pivot
model based on the Netbeans MDR. A new version of the Dresden OCL2
Toolkit will be released, when Ronny Brandt has finished his diploma
thesis.</p>

<h3>2007/3/28 - Version 1.2 of Dresden OCL2 Toolkit released</h3>

<p>A new version of the Dresden OCL2 Toolkit was released. The new
version contains a new software written by Ronny Brandt. It is an
extension of the code generator written with which you can load
UML-models provided as XMI files and OCL-constraints and generate java
code to check these constraints at runtime. This generated code also can
be injected in existing java files (instrumentation) and they can be
reverse engineered too.<br />
The new version of the Dresden OCL2 Toolkit is available from the
project download area at Sourceforge: <a
	href="http://sourceforge.net/project/showfiles.php?group_id=5840&package_id=173625">http://sourceforge.net/project/showfiles.php?group_id=5840&package_id=173625</a></p>

<h3>2005/12/22 - First Dresden OCL2 Toolkit Release</h3>

<p>We are proud to present the first release of the Dresden OCL2
Toolkit. This release is a version of the Dresden OCL Toolkit supporting
OCL2.0. You can obtain this release from our files section on
SourceForge: <a
	href="https://sourceforge.net/project/showfiles.php?group_id=5840">https://sourceforge.net/project/showfiles.php?group_id=5840</a></p>

<?php include "_footer.ssi"; ?>

</body>
</html>

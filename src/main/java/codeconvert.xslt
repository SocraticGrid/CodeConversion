<?xml version="1.0" encoding="UTF-8"?>

<!--
    Document   : codeconvert.xsl
    Created on : May 3, 2013, 9:53 AM
    Author     : Jerry Goodnough
    Description:
        Purpose of transformation follows.
-->

<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:codesearch="java:org.socraticgrid.codeconversion.SearchProcessor?path=jar:CodeConversion-1.0-SNAPSHOT.jar!" xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fn="http://www.w3.org/2005/xpath-functions" xmlns:r="http://schemas.openxmlformats.org/package/2006/relationships" xmlns:w="http://schemas.openxmlformats.org/spreadsheetml/2006/main" xmlns:rD="http://schemas.openxmlformats.org/officeDocument/2006/relationships" xmlns:sgfx="http://www.socraticgrid.org/codeconvert/xlsx" xmlns:m="http://schemas.openxmlformats.org/spreadsheetml/2006/main">

	<xsl:function as="xs:string" name="sgfx:convertCode">
		<xsl:param as="xs:string" name="context"/>
		<xsl:param as="xs:string" name="targetSystem"/>
		<xsl:param as="xs:string" name="sourceSystem"/>
		<xsl:param as="xs:string" name="sourceCode"/>
		<xsl:param as="xs:string" name="sourceDisplay"/>
		<xsl:value-of select="codesearch:SearchProcessor.getSerchProcessor($context).findCode($targetSystem, $sourceSystem, $sourceCode, $sourceText)"/>
	</xsl:function>

</xsl:stylesheet>
